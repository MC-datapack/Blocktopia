package github.mcdatapack.blocktopia.datagen.custom;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class BlocktopiaAdvancementGenerator extends FabricAdvancementProvider {
    private RegistryEntryLookup<Biome> biomeWrapper;

    protected BlocktopiaAdvancementGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
        registryLookup.thenAccept(lookup -> {
            biomeWrapper = lookup.getWrapperOrThrow(RegistryKeys.BIOME);
        });
    }

    protected AdvancementCriterion<TickCriterion.Conditions> tick() {
        return TickCriterion.Conditions.createTick();
    }

    public AdvancementCriterion<EnterBlockCriterion.Conditions> requireEnteringFluid(Block block) {
        return Criteria.ENTER_BLOCK.create(new EnterBlockCriterion.Conditions(Optional.empty(), Optional.of(block.getRegistryEntry()), Optional.empty()));
    }

    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(NumberRange.IntRange count, ItemConvertible item) {
        return conditionsFromPredicates(ItemPredicate.Builder.create().items(item).count(count));
    }

    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(ItemConvertible item) {
        return conditionsFromPredicates(ItemPredicate.Builder.create().items(item));
    }

    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromTag(TagKey<Item> tag) {
        return conditionsFromPredicates(ItemPredicate.Builder.create().tag(tag));
    }

    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromPredicates(ItemPredicate.Builder... predicates) {
        return conditionsFromItemPredicates((ItemPredicate[]) Arrays.stream(predicates).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new));
    }

    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItemPredicates(ItemPredicate... predicates) {
        return Criteria.INVENTORY_CHANGED
                .create(new InventoryChangedCriterion.Conditions(Optional.empty(), InventoryChangedCriterion.Conditions.Slots.ANY, List.of(predicates)));
    }

    public AdvancementCriterion<TickCriterion.Conditions> conditionsFromBiome(RegistryKey<Biome> biome) {
        return TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createBiome(biomeWrapper.getOrThrow(biome)));
    }

    public AdvancementCriterion<ChangedDimensionCriterion.Conditions> conditionsFromDimension(RegistryKey<World> from, RegistryKey<World> to) {
        return ChangedDimensionCriterion.Conditions.create(from,to);
    }

    public AdvancementCriterion<ChangedDimensionCriterion.Conditions> conditionsFromDimension(RegistryKey<World> to) {
        return ChangedDimensionCriterion.Conditions.to(to);
    }

    public String hasItem(ItemConvertible item) {
        return "has_" + getItemPath(item);
    }

    public String getItemPath(ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem()).getPath();
    }

    public String getRecipeName(ItemConvertible item) {
        return getItemPath(item);
    }

    public String convertBetween(ItemConvertible to, ItemConvertible from) {
        return getItemPath(to) + "_from_" + getItemPath(from);
    }

    public String getSmeltingItemPath(ItemConvertible item) {
        return getItemPath(item) + "_from_smelting";
    }

    public String getBlastingItemPath(ItemConvertible item) {
        return getItemPath(item) + "_from_blasting";
    }

    protected Builder create(ItemConvertible icon, String baseName) {
        return create(icon, baseName, Optional.empty(), Optional.empty(), true, true, false);
    }

    protected Builder create(ItemConvertible icon, String baseName, Optional<Identifier> background, Optional<AdvancementFrame> frame) {
        return create(icon, baseName, background, frame, true, true, false);
    }

    protected Builder create(ItemConvertible icon, String baseName, Optional<Identifier> background, Optional<AdvancementFrame> frame,
                           boolean showToast, boolean announceToChat, boolean hidden) {
        return Builder.create().display(icon,
                Text.translatable("advancement.blocktopia." + baseName + ".title"), Text.translatable("advancement.blocktopia." + baseName + ".description"),
                background.orElse(null), frame.orElse(AdvancementFrame.TASK), showToast, announceToChat, hidden);
    }

    protected static class Builder {
        private Optional<Identifier> parentObj = Optional.empty();
        private Optional<AdvancementDisplay> display = Optional.empty();
        private AdvancementRewards rewards = AdvancementRewards.NONE;
        private final ImmutableMap.Builder<String, AdvancementCriterion<?>> criteria = ImmutableMap.builder();
        private Optional<AdvancementRequirements> requirements = Optional.empty();
        private AdvancementRequirements.CriterionMerger merger = AdvancementRequirements.CriterionMerger.AND;
        private boolean sendsTelemetryEvent;

        public static Builder create() {
            return new Builder().sendsTelemetryEvent();
        }

        public static Builder createUntelemetered() {
            return new Builder();
        }

        public Builder parent(Identifier parentId) {
            this.parentObj = Optional.of(parentId);
            return this;
        }

        public Builder display(
                ItemStack icon,
                Text title,
                Text description,
                @Nullable Identifier background,
                AdvancementFrame frame,
                boolean showToast,
                boolean announceToChat,
                boolean hidden
        ) {
            return this.display(new AdvancementDisplay(icon, title, description, Optional.ofNullable(background), frame, showToast, announceToChat, hidden));
        }

        public Builder display(
                ItemConvertible icon,
                Text title,
                Text description,
                @Nullable Identifier background,
                AdvancementFrame frame,
                boolean showToast,
                boolean announceToChat,
                boolean hidden
        ) {
            return this.display(
                    new AdvancementDisplay(new ItemStack(icon.asItem()), title, description, Optional.ofNullable(background), frame, showToast, announceToChat, hidden)
            );
        }

        public Builder display(AdvancementDisplay display) {
            this.display = Optional.of(display);
            return this;
        }

        public Builder rewards(AdvancementRewards.Builder builder) {
            return this.rewards(builder.build());
        }

        public Builder rewards(AdvancementRewards rewards) {
            this.rewards = rewards;
            return this;
        }

        public Builder criterion(String name, AdvancementCriterion<?> criterion) {
            this.criteria.put(name, criterion);
            return this;
        }

        public Builder criteriaMerger(AdvancementRequirements.CriterionMerger merger) {
            this.merger = merger;
            return this;
        }

        public Builder requirements(AdvancementRequirements requirements) {
            this.requirements = Optional.of(requirements);
            return this;
        }

        public Builder sendsTelemetryEvent() {
            this.sendsTelemetryEvent = true;
            return this;
        }

        public AdvancementEntry build(Identifier id) {
            Map<String, AdvancementCriterion<?>> map = this.criteria.buildOrThrow();
            AdvancementRequirements advancementRequirements = this.requirements.orElseGet(() -> this.merger.create(map.keySet()));
            return new AdvancementEntry(id, new Advancement(this.parentObj, this.display, this.rewards, map, advancementRequirements, this.sendsTelemetryEvent));
        }

        public AdvancementEntry build(Consumer<AdvancementEntry> exporter, Identifier id) {
            AdvancementEntry advancementEntry = this.build(id);
            exporter.accept(advancementEntry);
            return advancementEntry;
        }
    }
}
