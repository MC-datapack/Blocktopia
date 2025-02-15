package github.mcdatapack.blocktopia.commands;

import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.RegistryPredicateArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.math.Box;

import java.util.Comparator;
import java.util.stream.Collectors;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class LocateMobCommand {

    private static final SuggestionProvider<ServerCommandSource> SUGGEST_MOB_IDENTIFIERS = (context, builder) -> CommandSource.suggestMatching(Registries.ENTITY_TYPE.stream()
            .filter(EntityType::isSummonable)
            .map(entityType -> Registries.ENTITY_TYPE.getId(entityType).toString())
            .collect(Collectors.toList()), builder);

    private static final DynamicCommandExceptionType INVALID_EXEPTION = new DynamicCommandExceptionType(
            id -> Text.stringifiedTranslatable("commands.locate.structure.invalid", id)
    );

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, access, registrationEnvironment) -> dispatcher.register(literal("locateMob")
                .requires(source -> source.hasPermissionLevel(2))
                .then(argument("mobIdentifier", RegistryPredicateArgumentType.registryPredicate(RegistryKeys.ENTITY_TYPE))
                        .suggests(SUGGEST_MOB_IDENTIFIERS)
                        .executes(context -> locateMob(context.getSource(), RegistryPredicateArgumentType.getPredicate(context, "mobIdentifier", RegistryKeys.ENTITY_TYPE, INVALID_EXEPTION))))));
    }

    private static int locateMob(ServerCommandSource source, RegistryPredicateArgumentType.RegistryPredicate<EntityType<?>> predicate) {
        var player = source.getPlayer();
        var playerPos = player.getPos();

        EntityType<?> entityType = Registries.ENTITY_TYPE.get(predicate.getKey().orThrow());

        LivingEntity nearestMob = player.getWorld().getEntitiesByType((EntityType<? extends LivingEntity>) entityType,
                        new Box(
                            playerPos.add(-10000, -10000, -10000),
                            playerPos.add(10000, 10000, 10000)),
                        entity -> true).stream()
                .min(Comparator.comparingDouble((LivingEntity a) -> a.squaredDistanceTo(playerPos)))
                .orElse(null);

        if (nearestMob != null) {
            var mobPos = nearestMob.getPos();
            String teleportCommand = String.format("/tp %s %s %s", mobPos.x, mobPos.y, mobPos.z);
            Text clickableMessage = Texts.bracketed(Text.literal("Click here to teleport"))
                    .styled(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, teleportCommand))
                            .withColor(net.minecraft.util.Formatting.GREEN));

            source.sendFeedback(() -> Text.literal("Nearest " + predicate.getKey().orThrow() + " is located at: " + mobPos).append(clickableMessage), false);
        } else {
            source.sendFeedback(() -> Text.literal("No mobs of type " + predicate.getKey().orThrow() + " found."), false);
        }

        return 1;
    }
}
