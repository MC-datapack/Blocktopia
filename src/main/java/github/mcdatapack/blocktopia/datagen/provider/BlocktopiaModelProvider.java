package github.mcdatapack.blocktopia.datagen.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlockFamilies;
import github.mcdatapack.blocktopia.block.custom.BananaCropBlock;
import github.mcdatapack.blocktopia.block.custom.ChairBlock;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.LegacyBlocks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

public class BlocktopiaModelProvider extends FabricModelProvider {

    public BlocktopiaModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.BANANA_CROP, BananaCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPONGE_TNT);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PAPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUNPOWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIREWORK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALM_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PALM_SAPLING, ModBlocks.POTTED_PALM_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.PALM_LOG)
                .log(ModBlocks.PALM_LOG).wood(ModBlocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PALM_LOG)
                .log(ModBlocks.STRIPPED_PALM_LOG).wood(ModBlocks.STRIPPED_PALM_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.PALM.getBaseBlock())
                .family(ModBlockFamilies.PALM);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_PALM_LOG, ModBlocks.PALM_HANGING_SIGN, ModBlocks.PALM_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BANANA_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BANANA_SAPLING, ModBlocks.POTTED_BANANA_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.BANANA_LOG)
                .log(ModBlocks.BANANA_LOG).wood(ModBlocks.BANANA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BANANA_LOG)
                .log(ModBlocks.STRIPPED_BANANA_LOG).wood(ModBlocks.STRIPPED_BANANA_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.BANANA.getBaseBlock())
                .family(ModBlockFamilies.BANANA);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_BANANA_LOG, ModBlocks.BANANA_HANGING_SIGN, ModBlocks.BANANA_WALL_HANGING_SIGN);



        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORN_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORN_SAPLING, ModBlocks.POTTED_CORN_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.CORN_LOG)
                .log(ModBlocks.CORN_LOG).wood(ModBlocks.CORN_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CORN_LOG)
                .log(ModBlocks.STRIPPED_CORN_LOG).wood(ModBlocks.STRIPPED_CORN_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.CORN.getBaseBlock())
                .family(ModBlockFamilies.CORN);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_CORN_LOG, ModBlocks.CORN_HANGING_SIGN, ModBlocks.CORN_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POISONED_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.POISONED_SAPLING, ModBlocks.POTTED_POISONED_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.POISONED_LOG)
                .log(ModBlocks.POISONED_LOG).wood(ModBlocks.POISONED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_POISONED_LOG)
                .log(ModBlocks.STRIPPED_POISONED_LOG).wood(ModBlocks.STRIPPED_POISONED_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.POISONED.getBaseBlock())
                .family(ModBlockFamilies.POISONED);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_POISONED_LOG, ModBlocks.POISONED_HANGING_SIGN, ModBlocks.POISONED_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAHOGANY_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MAHOGANY_SAPLING, ModBlocks.POTTED_MAHOGANY_SAPLING, TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.MAHOGANY_LOG)
                .log(ModBlocks.MAHOGANY_LOG).wood(ModBlocks.MAHOGANY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .log(ModBlocks.STRIPPED_MAHOGANY_LOG).wood(ModBlocks.STRIPPED_MAHOGANY_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.MAHOGANY.getBaseBlock())
                .family(ModBlockFamilies.MAHOGANY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MAHOGANY_LOG, ModBlocks.MAHOGANY_HANGING_SIGN, ModBlocks.MAHOGANY_WALL_HANGING_SIGN);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOWERING_CHERRY_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.FLOWERING_CHERRY_SAPLING, ModBlocks.POTTED_FLOWERING_CHERRY_SAPLING, TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GLOW_FLOWER, ModBlocks.POTTED_GLOW_FLOWER, TintType.NOT_TINTED);



        blockStateModelGenerator.registerLog(LegacyBlocks.LOG_C0_0_14A)
                .log(LegacyBlocks.LOG_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LEAVES_C0_24ST);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BEDROCK_C0_0_12A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SAND_B1_9PRE6);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_C0_0_15A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GRAVEL_1_3);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.COAL_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.COAL_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_ORE_1_14_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_C0_0_14A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPONGE_C0_0_19A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPONGE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.WET_SPONGE_1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLASS_C0_0_19A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.WHITE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.LIGHT_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DARK_GRAY_CLOTH_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DARK_GRAY_CLOTH_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.RED_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ORANGE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.YELLOW_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CHARTREUSE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SPRING_GREEN_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CYAN_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CAPRI_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ULTRAMARINE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.VIOLET_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.PURPLE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MAGENTA_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ROSE_CLOTH);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_C0_0_20A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GOLD_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.DANDELION_C0_0_20A, LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.IRON_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.MOSSY_COBBLESTONE_B1_8);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BRICKS_C0_26ST);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.BRICKS_A1_0_11);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.OBSIDIAN_C0_28A);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_IN20100128);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_ORE_1_14);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.DIAMOND_BLOCK_B1_9PRE5);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_RD20080515.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_RD20080515);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_RD161348.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_RD161348);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_C0_0_14A.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_C0_0_14A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_C0_0_15A.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_C0_0_15A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.WOODEN_B1_9PRE5.getBaseBlock())
                .family(ModBlockFamilies.WOODEN_B1_9PRE5);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_RD20090515.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_RD20090515);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_C0_0_14A.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_C0_0_14A);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlockFamilies.COBBLESTONE_B1_7.getBaseBlock())
                .family(ModBlockFamilies.COBBLESTONE_B1_7);
        blockStateModelGenerator.registerTorch(LegacyBlocks.TORCH_IN20100124_2, LegacyBlocks.WALL_TORCH_IN20100124_2);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.REDSTONE_ORE_A1_0_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.REDSTONE_ORE_1_14);
        blockStateModelGenerator.registerTorch(LegacyBlocks.REDSTONE_TORCH_A1_0_1, LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.ICE_A1_0_4);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SNOW_BLOCK_A1_0_5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.CLAY_BLOCK_A1_0_11);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.NETHERRACK_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.NETHERRACK_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.SOUL_SAND_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLOWSTONE_A1_2_0);
        blockStateModelGenerator.registerSimpleCubeAll(LegacyBlocks.GLOWSTONE_B1_9PRE5);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DUPER);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.TROPICAL_MOSS, ModBlocks.TROPICAL_MOSS_CARPET);

        Identifier topTexture = Identifier.ofVanilla("block/sand");
        Identifier sideTexture = Blocktopia.id("block/sandy_dirt");
        Identifier bottomTexture = Identifier.ofVanilla("block/dirt");

        TextureMap textures = new TextureMap()
                .put(TextureKey.TOP, topTexture)
                .put(TextureKey.SIDE, sideTexture)
                .put(TextureKey.BOTTOM, bottomTexture);

        blockStateModelGenerator.registerSingleton(ModBlocks.SANDY_DIRT, textures, Models.CUBE_BOTTOM_TOP);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XP_TRAP);

        registerChair(ModBlocks.OAK_CHAIR);
        registerChair(ModBlocks.SPRUCE_CHAIR);
        registerChair(ModBlocks.BIRCH_CHAIR);
        registerChair(ModBlocks.JUNGLE_CHAIR);
        registerChair(ModBlocks.ACACIA_CHAIR);
        registerChair(ModBlocks.DARK_OAK_CHAIR);
        registerChair(ModBlocks.CRIMSON_CHAIR);
        registerChair(ModBlocks.WARPED_CHAIR);
        registerChair(ModBlocks.MANGROVE_CHAIR);
        registerChair(ModBlocks.BAMBOO_CHAIR);
        registerChair(ModBlocks.CHERRY_CHAIR);
        registerChair(ModBlocks.PALM_CHAIR);
        registerChair(ModBlocks.BANANA_CHAIR);
        registerChair(ModBlocks.CORN_CHAIR);
        registerChair(ModBlocks.POISONED_CHAIR);
        registerChair(ModBlocks.MAHOGANY_CHAIR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DEEPSLATE_EMERALD_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_DEEPSLATE_EMERALD_CHERRY, ModItems.DEEPSLATE_EMERALD_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREATIVE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREATIVE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_COCONUT, ModItems.GOLDEN_COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_CARROT, Items.GOLDEN_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_POTATO, ModItems.GOLDEN_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_BAKED_POTATO, ModItems.GOLDEN_BAKED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALM_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONED_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONED_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAHOGANY_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GIANT_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.ILLUSIONER_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_CHERRY, ModItems.GOLDEN_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_DIAMOND_CHERRY, ModItems.DIAMOND_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_NETHERITE_CHERRY, ModItems.NETHERITE_CHERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.RABBIT_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAT_TRINKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MONKEY_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROPICAL_WATER_BUCKET, Models.GENERATED);
    }

    public static final Model TEMPLATE_SPAWN_EGG = item("template_spawn_egg");
    private static Model item(String parent) {
        return new Model(Optional.of(Identifier.ofVanilla("item/" + parent)), Optional.empty());
    }

    public void registerChair(ChairBlock[] blocks) {
        for (ChairBlock block : blocks) {
            ChairBlockJsonGenerator.generateJsonFiles(block);
        }
    }

    public static class ChairBlockJsonGenerator {

        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        public static void generateJsonFiles(ChairBlock block) {
            Identifier blockId = Registries.BLOCK.getId(block);
            String blockName = blockId.getPath();
            System.out.println("Generating JSON for block: " + blockName);
            generateBlockStateJson(blockName);
            generateBlockModelJson(blockName, Registries.BLOCK.getId(block.plank).toString(), Registries.BLOCK.getId(block.seat).toString());
            generateItemModelJson(blockName);
        }

        private static void generateBlockStateJson(String blockName) {
            BlockStateJson blockStateJson = new BlockStateJson();
            blockStateJson.variants.put("facing=north", new ModelVariant("blocktopia:block/" + blockName));
            blockStateJson.variants.put("facing=south", new ModelVariant("blocktopia:block/" + blockName, 180));
            blockStateJson.variants.put("facing=west", new ModelVariant("blocktopia:block/" + blockName, 270));
            blockStateJson.variants.put("facing=east", new ModelVariant("blocktopia:block/" + blockName, 90));

            writeJsonToFile("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/blockstates/" + blockName + ".json", blockStateJson);
        }

        private static void generateBlockModelJson(String blockName, String plankName, String seatName) {
            plankName = plankName.split(":")[0] + ":block/" + plankName.split(":")[1];
            seatName = seatName.split(":")[0] + ":block/" + seatName.split(":")[1];
            BlockModelJson blockModelJson = new BlockModelJson("blocktopia:block/chair", plankName, seatName);

            writeJsonToFile("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/block/" + blockName + ".json", blockModelJson);
        }

        private static void generateItemModelJson(String blockName) {
            ItemModelJson itemModelJson = new ItemModelJson("blocktopia:block/" + blockName);

            writeJsonToFile("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/item/" + blockName + ".json", itemModelJson);
        }

        private static void writeJsonToFile(String filePath, Object jsonObject) {
            try {
                File file = new File(filePath);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try (FileWriter writer = new FileWriter(file)) {
                    GSON.toJson(jsonObject, writer);
                }
            } catch (IOException ignored) {}
        }

        private static class BlockStateJson {
            private final Map<String, ModelVariant> variants = new HashMap<>();
        }

        private static class ModelVariant {
            private final String model;
            private final int y;

            public ModelVariant(String model) {
                this(model, 0);
            }

            public ModelVariant(String model, int y) {
                this.model = model;
                this.y = y;
            }
        }

        private static class BlockModelJson {
            private final String parent;
            private final Map<String, String> textures = new HashMap<>();

            public BlockModelJson(String parent, String texture, String seatTexture) {
                this.parent = parent;
                this.textures.put("texture", texture);
                this.textures.put("seat_texture", seatTexture);
            }
        }

        private record ItemModelJson(String parent) {}
    }
}
