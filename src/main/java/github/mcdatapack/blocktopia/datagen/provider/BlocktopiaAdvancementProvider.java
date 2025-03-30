package github.mcdatapack.blocktopia.datagen.provider;

import com.google.common.collect.ImmutableMap;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import github.mcdatapack.blocktopia.init.worldgen.BiomeInit;
import github.mcdatapack.blocktopia.init.worldgen.DimensionInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.mixin.event.interaction.PlayerAdvancementTrackerMixin;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.entity.PlayerPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class BlocktopiaAdvancementProvider extends FabricAdvancementProvider {
    public BlocktopiaAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {
        create(BlockInit.SMALL_CHEST, "root",
                Optional.of(Blocktopia.id("textures/block/cobblestone_rd20090515.png")), Optional.empty(), false, false, false)
                .criterion("download", TickCriterion.Conditions.createTick())
                .build(exporter, Blocktopia.id("root"));

        generateTerrainAdvancements(registryLookup, exporter);
        generateLegacyAdvancements(registryLookup, exporter);
    }

    private void generateTerrainAdvancements(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {
        create(BlockInit.BANANA_LOG, "rainforest",
                Optional.empty(), Optional.empty())
                .criterion("biome", TickCriterion.Conditions.createLocation(biomeLocation(registryLookup, BiomeInit.RAIN_FOREST_KEY)))
                .parent(Blocktopia.id("root"))
                .build(exporter, Blocktopia.id("rainforest"));
        create(BlockInit.SANDY_DIRT, "palm_island",
                Optional.empty(), Optional.empty())
                .criterion("biome", TickCriterion.Conditions.createLocation(biomeLocation(registryLookup, BiomeInit.PALM_ISLAND_KEY)))
                .parent(Blocktopia.id("rainforest"))
                .build(exporter, Blocktopia.id("palm_island"));
        create(Blocks.JUNGLE_LOG, "tropics",
                Optional.empty(), Optional.empty())
                .criterion("dimension", ChangedDimensionCriterion.Conditions.create(World.OVERWORLD, DimensionInit.TROPICS_LEVEL_KEY))
                .parent(Blocktopia.id("palm_island"))
                .build(exporter, Blocktopia.id("tropics"));
    }
    
    private void generateLegacyAdvancements(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> exporter) {

    }



    private LocationPredicate.Builder biomeLocation(RegistryWrapper.WrapperLookup registryLookup, RegistryKey<Biome> biome) {
        return LocationPredicate.Builder.createBiome(registryLookup.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(biome));
    }

    private Builder create(ItemConvertible icon, String baseName) {
        return create(icon, baseName, Optional.empty(), Optional.empty(), true, true, false);
    }

    private Builder create(ItemConvertible icon, String baseName, Optional<Identifier> background, Optional<AdvancementFrame> frame) {
        return create(icon, baseName, background, frame, true, true, false);
    }

    private Builder create(ItemConvertible icon, String baseName, Optional<Identifier> background, Optional<AdvancementFrame> frame,
                                       boolean showToast, boolean announceToChat, boolean hidden) {
        return Builder.create().display(icon,
                Text.translatable("advancement.blocktopia." + baseName + ".title"), Text.translatable("advancement.blocktopia." + baseName + ".description"),
                background.orElse(null), frame.orElse(AdvancementFrame.TASK), showToast, announceToChat, hidden);
    }

    private static class Builder {
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
