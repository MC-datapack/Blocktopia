package github.mcdatapack.blocktopia.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

@Config(name = "blocktopia")
public class BlocktopiaConfigData implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    public WorldgenConfig worldgenConfig = new WorldgenConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    public VillagerConfig villagerConfig = new VillagerConfig();

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    @Comment("Activate or Deactivate Blocktopia Items added to vanilla Loot Tables")
    public boolean enableLoot = true;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    @Comment("Activate or Deactivate Wandering Trader trades for Blocktopia Blocks")
    public boolean wanderingTraderTrades = true;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    public boolean randomMonkeyVariant = false;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    @Comment("Turn it down to 0 to disable it")
    @ConfigEntry.BoundedDiscrete(max = 15)
    public int glowingFloweringCherryLeaves = 8;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    @Comment("Turn it down to 0 to disable it")
    @ConfigEntry.BoundedDiscrete(max = 15)
    public int glowingBananaLeaves = 2;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("client")
    public SmallChestConfig smallChestConfig = new SmallChestConfig();

    public static class SmallChestConfig {
        @ConfigEntry.Gui.TransitiveObject
        public boolean renderItems = true;

        @ConfigEntry.Gui.TransitiveObject
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
        @Comment("The higher the value the longer it takes to fully open and close")
        public int closingSpeed = 12;
    }

    public static class WorldgenConfig {
        @ConfigEntry.Gui.CollapsibleObject
        public WorldgenFeatureConfig worldgenFeatures = new WorldgenFeatureConfig();

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Weight of Blocktopia Biomes (The higher the value, the more likely Bloktopia biomes are to generate)")
        @ConfigEntry.BoundedDiscrete(min = 5, max = 100)
        public int weight = 20;
    }

    public static class WorldgenFeatureConfig {
        @ConfigEntry.Gui.CollapsibleObject
        public BiomeConfig biomes = new BiomeConfig();

        @ConfigEntry.Gui.CollapsibleObject
        @Comment("Enable or disable all Features added to vanilla Biomes")
        public PlacedFeatureConfig features = new PlacedFeatureConfig();
    }

    public static class BiomeConfig {
        @ConfigEntry.Gui.RequiresRestart
        public boolean rain_forest = true;

        @ConfigEntry.Gui.RequiresRestart
        public boolean palm_island = true;

        @ConfigEntry.Gui.RequiresRestart
        public boolean sandy_dirt_in_palm_island = true;
    }

    public static class PlacedFeatureConfig {
        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig palm = new SinglePlacedFeatureConfig(true, 12, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig tree_c0_24st = new SinglePlacedFeatureConfig(false, 0, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST);

        //@ConfigEntry.Gui.CollapsibleObject
        //public SinglePlacedFeatureConfig birch_b1_5 = new SinglePlacedFeatureConfig(false, 0,BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        //@ConfigEntry.Gui.CollapsibleObject
        //public SinglePlacedFeatureConfig spruce_b1_5 = new SinglePlacedFeatureConfig(false, 0, BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_coal_ores = new SingleOrePlacedFeatureConfig(false, 20, 17, 0, 192);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_iron_ores = new SingleOrePlacedFeatureConfig(false, 10, 9, 0, 72);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_gold_ores = new SingleOrePlacedFeatureConfig(false, 8, 9, 0, 32);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_diamond_ores = new SingleOrePlacedFeatureConfig(false, 8, 9, 0, 20);

        //@ConfigEntry.Gui.CollapsibleObject
        //public SingleOrePlacedFeatureConfig legacy_lapis_ores = new SingleOrePlacedFeatureConfig(false, 8, 9, 0, 20);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig dandelion_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, 30, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig rose_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, 30, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig poppy_1_7 = new SinglePlacedFeatureChanceConfig(false, 30, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig brown_mushroom_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, 30, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig red_mushroom_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, 30, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);
    }

    public static class SinglePlacedFeatureConfig {
        @SafeVarargs
        public SinglePlacedFeatureConfig(boolean generate, int triesPerChunk, RegistryKey<Biome>... generateIn) {
            this.generate = generate;
            this.triesPerChunk = triesPerChunk;
            String[] SgenerateIn = new String[generateIn.length];
            for (int i = 0; i < generateIn.length; i++) {
                SgenerateIn[i] = generateIn[i].getValue().toString();
            }
            this.generateIn = SgenerateIn;
        }

        @ConfigEntry.Gui.RequiresRestart
        public boolean generate;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int triesPerChunk;

        @ConfigEntry.Gui.RequiresRestart
        public String[] generateIn;

        @SuppressWarnings("unchecked")
        public RegistryKey<Biome>[] getGenerateIn() {
            RegistryKey<Biome>[] output = new RegistryKey[generateIn.length];
            for (int i = 0; i < generateIn.length; i++) {
                output[i] = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(generateIn[i]));
            }
            return output;
        }
    }

    public static class SinglePlacedFeatureChanceConfig {
        @SafeVarargs
        public SinglePlacedFeatureChanceConfig(boolean generate, int chance, RegistryKey<Biome>... generateIn) {
            this.generate = generate;
            this.chance = chance;
            String[] SgenerateIn = new String[generateIn.length];
            for (int i = 0; i < generateIn.length; i++) {
                SgenerateIn[i] = generateIn[i].getValue().toString();
            }
            this.generateIn = SgenerateIn;
        }

        @ConfigEntry.Gui.RequiresRestart
        public boolean generate;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        public int chance;

        @ConfigEntry.Gui.RequiresRestart
        public String[] generateIn;

        @SuppressWarnings("unchecked")
        public RegistryKey<Biome>[] getGenerateIn() {
            RegistryKey<Biome>[] output = new RegistryKey[generateIn.length];
            for (int i = 0; i < generateIn.length; i++) {
                output[i] = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(generateIn[i]));
            }
            return output;
        }
    }

    public static class SingleOrePlacedFeatureConfig {
        public SingleOrePlacedFeatureConfig(boolean generate, int triesPerChunk, int size, int minY, int maxY) {
            this.generate = generate;
            this.triesPerChunk = triesPerChunk;
            this.size = size;
            this.minY = minY;
            this.maxY = maxY;
        }

        @ConfigEntry.Gui.RequiresRestart
        public boolean generate;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 0, max = 20)
        public int triesPerChunk;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 4, max = 20)
        public int size;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = -64, max = 319)
        public int minY;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = -64, max = 319)
        public int maxY;
    }

    public static class VillagerConfig {
        @ConfigEntry.Gui.RequiresRestart
        public boolean blocktopiaVillagers = true;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 1, max = 100000)
        public int maxUses = 12;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Change the Workstation of the Legacy Villager Profession (requires the id of the block: <namespace>:<block id>)")
        public String legacyVillagerWorkstation = "blocktopia:crafting_table_in20100131";

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Change the Workstation of the Beekeeper Villager Profession (requires the id of the block: <namespace>:<block id>)")
        public String beekeeperVillagerWorkstation = "minecraft:honey_block";

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Change the Workstation of the Miner Villager Profession (requires the id of the block: <namespace>:<block id>)")
        public String minerVillagerWorkstation = "minecraft:stone";

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Only works with More Tools and Armor")
        public boolean opTrades = false;
    }
}
