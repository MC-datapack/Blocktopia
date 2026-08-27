package github.mcdatapack.blocktopia.villager;

import com.google.common.collect.ImmutableSet;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import net.minecraft.world.poi.PointOfInterestType;

public interface ModVillagers {
    RegistryKey<PointOfInterestType> LEGACY_KEY = poiKey("legacy");
    PointOfInterestType LEGACY_POI = registerPoi("legacy", Registries.BLOCK.get(Identifier.of(BlocktopiaConfig.getConfig().villagerConfig.legacyVillagerWorkstation2)));
    VillagerProfession LEGACY = registerProfession("legacy", LEGACY_KEY, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);

    RegistryKey<PointOfInterestType> BEEKEEPER_KEY = poiKey("beekeeper");
    PointOfInterestType BEEKEEPER_POI = registerPoi("beekeeper", Registries.BLOCK.get(Identifier.of(BlocktopiaConfig.getConfig().villagerConfig.beekeeperVillagerWorkstation)));
    VillagerProfession BEEKEEPER = registerProfession("beekeeper", BEEKEEPER_KEY, SoundEvents.ENTITY_VILLAGER_WORK_FARMER);

    RegistryKey<PointOfInterestType> FORGER_KEY = poiKey("forger");
    PointOfInterestType FORGER_POI = registerPoi("forger", Blocks.ANVIL, Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL);
    VillagerProfession FORGER = registerProfession("forger", FORGER_KEY, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent soundEvent) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Blocktopia.id(name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), soundEvent));
    }

    private static PointOfInterestType registerPoi(String name, Block... block) {
        return PointOfInterestHelper.register(Blocktopia.id(name), 1, 10, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Blocktopia.id(name));
    }

    static void load() {}
}
