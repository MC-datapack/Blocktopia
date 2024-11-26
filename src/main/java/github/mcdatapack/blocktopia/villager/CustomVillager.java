package github.mcdatapack.blocktopia.villager;

import com.google.common.collect.ImmutableSet;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.LegacyBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;


public class CustomVillager {
    public static final RegistryKey<PointOfInterestType> LEGACY_KEY = poiKey("legacy");
    public static final PointOfInterestType LEGACY_POI = registerPoi("legacy", LegacyBlocks.CRAFTING_TABLE_IN20100131);
    public static final VillagerProfession LEGACY = registerProfession("legacy", LEGACY_KEY, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);

    public static final RegistryKey<PointOfInterestType> BEEKEEPER_KEY = poiKey("beekeeper");
    public static final PointOfInterestType BEEKEEPER_POI = registerPoi("beekeeper", Blocks.PINK_PETALS);
    public static final VillagerProfession BEEKEEPER = registerProfession("beekeeper", BEEKEEPER_KEY, SoundEvents.ENTITY_VILLAGER_WORK_FARMER);

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, SoundEvent soundEvent) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Blocktopia.id(name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), soundEvent));
    }

    public static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Blocktopia.id(name), 1, 10, block);
    }

    public static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Blocktopia.id(name));
    }

    public static void load() {}
}
