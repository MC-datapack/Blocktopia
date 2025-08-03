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

import java.awt.*;

@Config(name = "blocktopia")
public class BlocktopiaConfigData implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    public WorldgenConfig worldgenConfig = new WorldgenConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    public VillagerConfig villagerConfig = new VillagerConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    public LegacyCutterConfig legacyCutterConfig = new LegacyCutterConfig();

    //@ConfigEntry.Gui.TransitiveObject
    //@ConfigEntry.Category("server")
    //@Comment("1 Bucket = 81000, 1 Bottle = 27000")
    public long fluidTankCapacity = 810000;

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

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Category("server")
    @Comment("Turn it down to 0 to disable it")
    @ConfigEntry.BoundedDiscrete(max = 15)
    public int glowingCornLeaves = 4;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    @Comment("Turn it down to 0 to disable it")
    @ConfigEntry.BoundedDiscrete(max = 15)
    public int glowingPoisonedLeaves = 6;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("server")
    @Comment("Turn it down to 0 to disable it")
    @ConfigEntry.BoundedDiscrete(max = 15)
    public int glowingMahoganyLeaves = 2;


    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("server")
    @ConfigEntry.BoundedDiscrete(min = 20, max = 250)
    public int spongeAbsorb = 60;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("server")
    @ConfigEntry.BoundedDiscrete(min = 4, max = 150)
    @Comment("4 is the default Explosion Power of TNT")
    public int spongeTntExplosionPower = 12;

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("server")
    @ConfigEntry.BoundedDiscrete(min = 48, max = 120)
    public int structureBlockMax = 48;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("client")
    public SmallChestConfig smallChestConfig = new SmallChestConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("client")
    public LegacyCutterClientConfig legacyCutterClientConfig = new LegacyCutterClientConfig();

    @ConfigEntry.Category("server")
    public DuperConfig duperConfig = new DuperConfig();

    public static class SmallChestConfig {
        @ConfigEntry.Gui.TransitiveObject
        public boolean renderItems = true;

        @ConfigEntry.Gui.TransitiveObject
        @ConfigEntry.BoundedDiscrete(min = 1, max = 1000)
        @Comment("The higher the value the longer it takes to fully open and close")
        public int closingSpeed = 12;
    }

    public static class LegacyCutterConfig {
        @ConfigEntry.Gui.TransitiveObject
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public int processingTime = 10;
    }

    public static class DuperConfig {
        public int processingTime = 20;
    }

    public static class LegacyCutterClientConfig {
        @ConfigEntry.Gui.TransitiveObject
        public boolean renderItems = true;

        @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
        @Comment("Set it to Custom to use the option below.")
        public Colors arrowColor = Colors.Blue;

        @ConfigEntry.Gui.CollapsibleObject
        public CustomColor customArrowColor = new CustomColor();

        public Color getColor() {
            return arrowColor == Colors.Custom ? new Color(customArrowColor.red,customArrowColor.green, customArrowColor.blue, customArrowColor.alpha) : arrowColor.color;
        }

        public static class CustomColor {
            @ConfigEntry.Gui.TransitiveObject
            @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
            public int red = 0;

            @ConfigEntry.Gui.TransitiveObject
            @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
            public int green = 0;

            @ConfigEntry.Gui.TransitiveObject
            @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
            public int blue = 255;

            @ConfigEntry.Gui.TransitiveObject
            @ConfigEntry.BoundedDiscrete(min = 0, max = 255)
            public int alpha = 0;
        }

        public enum Colors {
            White(Color.WHITE),
            Light_Gray(Color.LIGHT_GRAY),
            Gray(Color.GRAY),
            Black(Color.BLACK),
            Blue(Color.BLUE),
            Light_Blue(new Color(0, 215, 253)),
            Cyan(Color.CYAN),
            Lime(new Color(12, 213, 8)),
            Green(new Color(13, 126, 7)),
            Yellow(Color.YELLOW),
            Orange(Color.ORANGE),
            Pink(Color.PINK),
            Magenta(Color.MAGENTA),
            Red(Color.RED),
            Purple(new Color(136, 4, 136)),
            Brown(new Color(159, 70, 5)),
            Custom(new Color(0, 0, 0));

            public final Color color;

            Colors(Color color) {
                this.color = color;
            }
        }
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

        @ConfigEntry.Gui.RequiresRestart
        public boolean tropical_moss_in_rainforest = true;
    }

    public static class PlacedFeatureConfig {
        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig palm = new SinglePlacedFeatureConfig(true, BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig tree_c0_24st = new SinglePlacedFeatureConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig birch_b1_5 = new SinglePlacedFeatureConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig birch_1_7 = new SinglePlacedFeatureConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig spruce_b1_5 = new SinglePlacedFeatureConfig(false, BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig spruce_1_7 = new SinglePlacedFeatureConfig(false, BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig jungle_1_2 = new SinglePlacedFeatureConfig(false, BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig jungle_1_7 = new SinglePlacedFeatureConfig(false, BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig acacia_1_7 = new SinglePlacedFeatureConfig(false, BiomeKeys.SAVANNA, BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.WINDSWEPT_SAVANNA);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig dark_oak_1_7 = new SinglePlacedFeatureConfig(false, BiomeKeys.DARK_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig huge_red_mushroom_b1_8 = new SinglePlacedFeatureConfig(false, BiomeKeys.DARK_FOREST, BiomeKeys.MUSHROOM_FIELDS);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureConfig huge_brown_mushroom_b1_8 = new SinglePlacedFeatureConfig(false, BiomeKeys.DARK_FOREST, BiomeKeys.MUSHROOM_FIELDS);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_coal_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_iron_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_gold_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_diamond_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_lapis_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig ruby_ores = new SingleOrePlacedFeatureConfig(true);

        @ConfigEntry.Gui.CollapsibleObject
        public SingleOrePlacedFeatureConfig legacy_emerald_ores = new SingleOrePlacedFeatureConfig(false);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig dandelion_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig rose_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig poppy_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig brown_mushroom_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig red_mushroom_c0_0_20a = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig allium_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST, BiomeKeys.MEADOW);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig azure_bluet_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST, BiomeKeys.MEADOW);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig blue_orchid_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.SWAMP);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig lilac_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig peony_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig rose_bush_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST, BiomeKeys.FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig sunflower_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.SUNFLOWER_PLAINS);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig oxeye_daisy_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST, BiomeKeys.WINDSWEPT_FOREST);

        @ConfigEntry.Gui.CollapsibleObject
        public SinglePlacedFeatureChanceConfig tulips_1_7 = new SinglePlacedFeatureChanceConfig(false, BiomeKeys.FLOWER_FOREST);

        public static class SinglePlacedFeatureConfig {
            @SafeVarargs
            public SinglePlacedFeatureConfig(boolean generate, RegistryKey<Biome>... generateIn) {
                this.generate = generate;
                String[] SgenerateIn = new String[generateIn.length];
                for (int i = 0; i < generateIn.length; i++) {
                    SgenerateIn[i] = generateIn[i].getValue().toString();
                }
                this.generateIn = SgenerateIn;
            }

            @ConfigEntry.Gui.RequiresRestart
            public boolean generate;

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
            public SinglePlacedFeatureChanceConfig(boolean generate, RegistryKey<Biome>... generateIn) {
                this.generate = generate;
                String[] SgenerateIn = new String[generateIn.length];
                for (int i = 0; i < generateIn.length; i++) {
                    SgenerateIn[i] = generateIn[i].getValue().toString();
                }
                this.generateIn = SgenerateIn;
            }

            @ConfigEntry.Gui.RequiresRestart
            public boolean generate;

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
            public SingleOrePlacedFeatureConfig(boolean generate) {
                this.generate = generate;
            }

            @ConfigEntry.Gui.RequiresRestart
            public boolean generate;
        }
    }

    public static class VillagerConfig {
        @ConfigEntry.Gui.RequiresRestart
        public boolean blocktopiaVillagers = true;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 1, max = 100000)
        public int maxUses = 12;

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Change the Workstation of the Legacy Villager Profession (requires the id of the block: <namespace>:<block id>)")
        public String legacyVillagerWorkstation2 = "blocktopia:legacy_cutter";

        @ConfigEntry.Gui.RequiresRestart
        @Comment("Change the Workstation of the Beekeeper Villager Profession (requires the id of the block: <namespace>:<block id>)")
        public String beekeeperVillagerWorkstation = "minecraft:honey_block";

        @ConfigEntry.Gui.RequiresRestart
        public boolean bananaFarmerTrade = true;
    }
}
