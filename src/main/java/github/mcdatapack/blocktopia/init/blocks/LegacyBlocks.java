package github.mcdatapack.blocktopia.init.blocks;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.SpongeBlock_1_8;
import github.mcdatapack.blocktopia.block.WetSpongeBlock_1_8;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.list.BlockSetTypeList;
import github.mcdatapack.blocktopia.list.FoodList;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallSignBlock;
import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import static net.minecraft.block.Blocks.*;

public class LegacyBlocks {
    public static final Block COBBLESTONE_RD20090515;
    public static final Block COBBLESTONE_C_0_0_14A;
    public static final Block COBBLESTONE_B1_7;
    public static final Block WOODEN_PLANKS_RD20090515;
    public static final Block WOODEN_PLANKS_RD161348;
    public static final Block WOODEN_PLANKS_C0_0_14A;
    public static final Block WOODEN_PLANKS_C0_0_15A;
    public static final Block WOODEN_PLANKS_B1_9PRE5;
    public static final Block LOG_C0_0_14A;
    public static final LeavesBlock LEAVES_C0_0_14A;
    public static final LeavesBlock LEAVES_C0_0_15A;
    public static final LeavesBlock LEAVES_C0_24ST;
    public static final FlowerBlock SAPLING_RD161348;
    public static final Block POTTED_SAPLING_RD161348;
    public static final FlowerBlock SAPLING_C0_0_13A;
    public static final Block POTTED_SAPLING_C0_0_13A;
    public static final SaplingBlock SAPLING_C0_24ST;
    public static final Block POTTED_SAPLING_C0_24ST;
    public static final Block BEDROCK_C0_0_12A;
    public static final FallingBlock SAND_C0_0_14A;
    public static final FallingBlock SAND_C0_0_15A;
    public static final FallingBlock SAND_B1_9PRE6;
    public static final FallingBlock GRAVEL_C0_0_14A;
    public static final FallingBlock GRAVEL_C0_0_15A;
    public static final FallingBlock GRAVEL_B1_9PRE5;
    public static final FallingBlock GRAVEL_1_3;
    public static final ExperienceDroppingBlock COAL_ORE_C0_0_14A;
    public static final ExperienceDroppingBlock COAL_ORE_1_14;
    public static final Block IRON_ORE_C0_0_14A;
    public static final Block IRON_ORE_1_14;
    public static final Block IRON_ORE_1_14_1;
    public static final Block GOLD_ORE_C0_0_14A;
    public static final Block GOLD_ORE_C0_26ST;
    public static final Block GOLD_ORE_1_14;
    public static final SpongeBlock SPONGE_C0_0_19A;
    public static final SpongeBlock_1_8 SPONGE_1_8;
    public static final WetSpongeBlock_1_8 WET_SPONGE_1_8;
    public static final TransparentBlock GLASS_C0_0_19A;
    public static final Block WHITE_CLOTH;
    public static final Block LIGHT_GRAY_CLOTH_C0_0_20A;
    public static final Block LIGHT_GRAY_CLOTH_C0_28A;
    public static final Block DARK_GRAY_CLOTH_C0_0_20A;
    public static final Block DARK_GRAY_CLOTH_C0_28A;
    public static final Block RED_CLOTH;
    public static final Block ORANGE_CLOTH;
    public static final Block YELLOW_CLOTH;
    public static final Block CHARTREUSE_CLOTH;
    public static final Block SPRING_GREEN_CLOTH;
    public static final Block CYAN_CLOTH;
    public static final Block CAPRI_CLOTH;
    public static final Block ULTRAMARINE_CLOTH;
    public static final Block VIOLET_CLOTH;
    public static final Block PURPLE_CLOTH;
    public static final Block MAGENTA_CLOTH;
    public static final Block ROSE_CLOTH;
    public static final Block GOLD_BLOCK_C0_0_20A;
    public static final Block GOLD_BLOCK_C0_26ST;
    public static final Block GOLD_BLOCK_A1_2_0;
    public static final Block GOLD_BLOCK_B1_9PRE5;
    public static final FlowerBlock DANDELION_C0_0_20A;
    public static final Block POTTED_DANDELIONS_C0_0_20A;
    public static final FlowerBlock ROSE_C0_0_20A;
    public static final Block POTTED_ROSE_C0_0_20A;
    public static final FlowerBlock POPPY_1_7;
    public static final Block POTTED_POPPY_1_7;
    public static final MushroomBlock BROWN_MUSHROOM_C0_0_20A;
    public static final Block POTTED_BROWN_MUSHROOM_C0_0_20A;
    public static final MushroomBlock RED_MUSHROOM_C0_0_20A;
    public static final Block POTTED_RED_MUSHROOM_C0_0_20A;
    public static final SlabBlock STONE_SLAB_C0_26ST;
    public static final Block IRON_BLOCK_C0_26ST;
    public static final Block IRON_BLOCK_A1_2_0;
    public static final Block IRON_BLOCK_B1_9PRE5;
    public static final TntBlock TNT_C0_26ST;
    public static final TntBlock TNT_C0_28A;
    public static final Block MOSSY_COBBLESTONE_C0_26ST;
    public static final Block MOSSY_COBBLESTONE_B1_8;
    public static final Block BRICKS_C0_26ST;
    public static final Block BRICKS_A1_0_11;
    public static final Block BOOKSHELF_C0_26ST;
    public static final Block BOOKSHELF_B1_9PRE5;
    public static final Block OBSIDIAN_C0_28A;
    public static final ExperienceDroppingBlock DIAMOND_ORE_IN20100128;
    public static final ExperienceDroppingBlock DIAMOND_ORE_1_14;
    public static final Block DIAMOND_BLOCK_IN20100128;
    public static final Block DIAMOND_BLOCK_A1_2_0;
    public static final Block DIAMOND_BLOCK_B1_9PRE5;
    public static final Block CRAFTING_TABLE_IN20100131;
    public static final Block CRAFTING_TABLE_1_14;
    public static final Block FURNACE_IN20100219;
    public static final Block LIT_FURNACE_IN20100219;
    public static final Block FURNACE_B1_2;
    public static final Block LIT_FURNACE_B1_2;
    public static final LadderBlock LADDER_INF20100607;
    public static final LadderBlock LADDER_INF20100618;
    public static final StairsBlock WOODEN_STAIRS_RD20090515;
    public static final StairsBlock WOODEN_STAIRS_RD161348;
    public static final StairsBlock WOODEN_STAIRS_C0_0_14A;
    public static final StairsBlock WOODEN_STAIRS_INF20100629;
    public static final StairsBlock WOODEN_STAIRS_B1_9PRE5;
    public static final StairsBlock COBBLESTONE_STAIRS_RD20090515;
    public static final StairsBlock COBBLESTONE_STAIRS_C0_0_14A;
    public static final StairsBlock COBBLESTONE_STAIRS_B1_7;
    public static Identifier SIGN_INF20100607_TEXTURE;
    public static final TorchBlock TORCH_IN20100124_2;
    public static final WallTorchBlock WALL_TORCH_IN20100124_2;
    public static final BlocktopiaSignBlock SIGN_INF20100607;
    public static final BlocktopiaWallSignBlock WALL_SIGN_INF20100607;
    public static final DoorBlock WOODEN_DOOR_INF20100607;
    public static final RedstoneOreBlock REDSTONE_ORE_A1_0_1;
    public static final RedstoneOreBlock REDSTONE_ORE_1_14;
    public static final RedstoneTorchBlock REDSTONE_TORCH_A1_0_1;
    public static final WallRedstoneTorchBlock REDSTONE_WALL_TORCH_A1_0_1;
    public static final SnowBlock SNOW_A1_0_4;
    public static final Block ICE_A1_0_4;
    public static final Block SNOW_BLOCK_A1_0_5;
    public static final Block CLAY_BLOCK_A1_0_11;
    public static final FenceBlock WOODEN_FENCE_RD20090515;
    public static final FenceBlock WOODEN_FENCE_RD161348;
    public static final FenceBlock WOODEN_FENCE_C0_0_14A;
    public static final FenceBlock WOODEN_FENCE_A1_0_17;
    public static final FenceBlock WOODEN_FENCE_B1_9PRE5;
    public static final Block NETHERRACK_A1_2_0;
    public static final Block NETHERRACK_B1_9PRE5;
    public static final SoulSandBlock SOUL_SAND_A1_2_0;
    public static final Block GLOWSTONE_A1_2_0;
    public static final Block GLOWSTONE_B1_9PRE5;
    public static final CarvedPumpkinBlock CARVED_PUMPKIN_A1_2_0;
    public static final CarvedPumpkinBlock JACK_O_LANTERN_A1_2_0;

    public LegacyBlocks() {
    }

    public static <T extends Block> T registerWithoutItem(String name, T block) {
        return Registry.register(Registries.BLOCK, Blocktopia.id(name), block);
    }
    public static <T extends Block> T register(String name, T block, Item.Settings settings) {
        T registered = registerWithoutItem(name, block);
        ItemInit.register(name, new BlockItem(registered, settings));
        return registered;
    }
    public static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings());
    }
    public static void load() {}

    static {
        COBBLESTONE_RD20090515 = register("cobblestone_rd20090515", new Block(AbstractBlock.Settings.copy(COBBLESTONE)));
        COBBLESTONE_C_0_0_14A = register("cobblestone_c_0_0_14a", new Block(AbstractBlock.Settings.copy(COBBLESTONE)));
        COBBLESTONE_B1_7 = register("cobblestone_b1_7", new Block(AbstractBlock.Settings.copy(COBBLESTONE)));
        WOODEN_PLANKS_RD20090515 = register("wooden_planks_rd20090515", new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
        WOODEN_PLANKS_RD161348 = register("wooden_planks_rd161348", new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
        WOODEN_PLANKS_C0_0_14A = register("wooden_planks_c0_0_14a", new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
        WOODEN_PLANKS_C0_0_15A = register("wooden_planks_c0_0_15a", new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
        WOODEN_PLANKS_B1_9PRE5 = register("wooden_planks_b1_9pre5", new Block(AbstractBlock.Settings.copy(OAK_PLANKS)));
        LOG_C0_0_14A = register("log_c0_0_14a", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
        LEAVES_C0_0_14A = register("leaves_c0_0_14a", new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
        LEAVES_C0_0_15A = register("leaves_c0_0_15a", new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
        LEAVES_C0_24ST = register("leaves_c0_24st", new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)));
        SAPLING_RD161348 = register("sapling_rd161348", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F, 
                AbstractBlock.Settings.copy(OAK_SAPLING)));
        POTTED_SAPLING_RD161348 = register("potted_sapling_rd161348", createFlowerPotBlock(OAK_SAPLING));
        SAPLING_C0_0_13A = register("sapling_c0_0_13a", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F, AbstractBlock.Settings.copy(OAK_SAPLING)));
        POTTED_SAPLING_C0_0_13A = register("potted_sapling_c0_0_13a", createFlowerPotBlock(SAPLING_C0_0_13A));
        SAPLING_C0_24ST = register("sapling_c0_24st", new SaplingBlock(new SaplingGenerator(Blocktopia.id("sapling").toString(), 
                0.1F, 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), 
                Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY)), 
                AbstractBlock.Settings.copy(OAK_SAPLING)));
        POTTED_SAPLING_C0_24ST = registerWithoutItem("potted_sapling_c0_24st", createFlowerPotBlock(SAPLING_C0_24ST));
        BEDROCK_C0_0_12A = register("bedrock_c0_0_12a", new Block(AbstractBlock.Settings.copy(BEDROCK)));
        SAND_C0_0_14A = register("sand_c0_0_14a", new FallingBlock(AbstractBlock.Settings.copy(SAND)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        SAND_C0_0_15A = register("sand_c0_0_15a", new FallingBlock(AbstractBlock.Settings.copy(SAND)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        SAND_B1_9PRE6 = register("sand_b1_9pre6", new FallingBlock(AbstractBlock.Settings.copy(SAND)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        GRAVEL_C0_0_14A = register("gravel_c0_0_14a", new FallingBlock(AbstractBlock.Settings.copy(GRAVEL)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        GRAVEL_C0_0_15A = register("gravel_c0_0_15a", new FallingBlock(AbstractBlock.Settings.copy(GRAVEL)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        GRAVEL_B1_9PRE5 = register("gravel_b1_9pre5", new FallingBlock(AbstractBlock.Settings.copy(GRAVEL)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        GRAVEL_1_3 = register("gravel_1_3", new FallingBlock(AbstractBlock.Settings.copy(GRAVEL)) {
            @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
        COAL_ORE_C0_0_14A = register("coal_ore_c0_0_14a", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(COAL_ORE)));
        COAL_ORE_1_14 = register("coal_ore_1_14", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(COAL_ORE)));
        IRON_ORE_C0_0_14A = register("iron_ore_c0_0_14a", new Block(AbstractBlock.Settings.copy(IRON_ORE)));
        IRON_ORE_1_14 = register("iron_ore_1_14", new Block(AbstractBlock.Settings.copy(IRON_ORE)));
        IRON_ORE_1_14_1 = register("iron_ore_1_14_1", new Block(AbstractBlock.Settings.copy(IRON_ORE)));
        GOLD_ORE_C0_0_14A = register("gold_ore_c0_0_14a", new Block(AbstractBlock.Settings.copy(GOLD_ORE)));
        GOLD_ORE_C0_26ST = register("gold_ore_c0_26st", new Block(AbstractBlock.Settings.copy(GOLD_ORE)));
        GOLD_ORE_1_14 = register("gold_ore_1_14", new Block(AbstractBlock.Settings.copy(GOLD_ORE)));
        SPONGE_C0_0_19A = register("sponge_c0_0_19a", new SpongeBlock(AbstractBlock.Settings.copy(SPONGE)));
        SPONGE_1_8 = register("sponge_1_8", new SpongeBlock_1_8(AbstractBlock.Settings.copy(SPONGE)));
        WET_SPONGE_1_8 = register("wet_sponge_1_8", new WetSpongeBlock_1_8(AbstractBlock.Settings.copy(WET_SPONGE)));
        GLASS_C0_0_19A = register("glass_c0_0_19a", new TransparentBlock(AbstractBlock.Settings.copy(GLASS)));
        WHITE_CLOTH = register("withe_cloth", new Block(AbstractBlock.Settings.copy(WHITE_WOOL)));
        LIGHT_GRAY_CLOTH_C0_0_20A = register("light_gray_cloth_c0_0_20a", new Block(AbstractBlock.Settings.copy(LIGHT_GRAY_WOOL)));
        LIGHT_GRAY_CLOTH_C0_28A = register("light_gray_cloth_c0_28a", new Block(AbstractBlock.Settings.copy(LIGHT_GRAY_WOOL)));
        DARK_GRAY_CLOTH_C0_0_20A = register("dark_gray_cloth_c0_0_20a", new Block(AbstractBlock.Settings.copy(GRAY_WOOL)));
        DARK_GRAY_CLOTH_C0_28A = register("dark_gray_cloth_c0_28a", new Block(AbstractBlock.Settings.copy(GRAY_WOOL)));
        RED_CLOTH = register("red_cloth", new Block(AbstractBlock.Settings.copy(RED_WOOL)));
        ORANGE_CLOTH = register("orange_cloth", new Block(AbstractBlock.Settings.copy(ORANGE_WOOL)));
        YELLOW_CLOTH = register("yellow_cloth", new Block(AbstractBlock.Settings.copy(YELLOW_WOOL)));
        CHARTREUSE_CLOTH = register("chartreuse_cloth", new Block(AbstractBlock.Settings.copy(LIME_WOOL)));
        SPRING_GREEN_CLOTH = register("spring_green_cloth", new Block(AbstractBlock.Settings.copy(GREEN_WOOL)));
        CYAN_CLOTH = register("cyan_cloth", new Block(AbstractBlock.Settings.copy(CYAN_WOOL)));
        CAPRI_CLOTH = register("capri_cloth", new Block(AbstractBlock.Settings.copy(LIGHT_BLUE_WOOL)));
        ULTRAMARINE_CLOTH = register("ultramarine_cloth", new Block(AbstractBlock.Settings.copy(BLUE_WOOL)));
        VIOLET_CLOTH = register("violet_cloth", new Block(AbstractBlock.Settings.copy(PURPLE_WOOL)));
        PURPLE_CLOTH = register("purple_cloth", new Block(AbstractBlock.Settings.copy(PURPLE_WOOL)));
        MAGENTA_CLOTH = register("magenta_cloth", new Block(AbstractBlock.Settings.copy(MAGENTA_WOOL)));
        ROSE_CLOTH = register("rose_cloth", new Block(AbstractBlock.Settings.copy(PINK_WOOL)));
        GOLD_BLOCK_C0_0_20A = register("gold_block_c0_0_20a", new Block(AbstractBlock.Settings.copy(GOLD_BLOCK)));
        GOLD_BLOCK_C0_26ST = register("gold_block_c0_26st", new Block(AbstractBlock.Settings.copy(GOLD_BLOCK)));
        GOLD_BLOCK_A1_2_0 = register("gold_block_a1_2_0", new Block(AbstractBlock.Settings.copy(GOLD_BLOCK)));
        GOLD_BLOCK_B1_9PRE5 = register("gold_block_b1_9pre5", new Block(AbstractBlock.Settings.copy(GOLD_BLOCK)));
        DANDELION_C0_0_20A = register("dandelion_c0_0_20a", new FlowerBlock(StatusEffects.SATURATION, 0.35F, AbstractBlock.Settings.copy(DANDELION)));
        POTTED_DANDELIONS_C0_0_20A = registerWithoutItem("potted_dandelion_c0_0_20a", createFlowerPotBlock(DANDELION_C0_0_20A));
        ROSE_C0_0_20A = register("rose_c0_0_20a", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(POPPY)));
        POTTED_ROSE_C0_0_20A = registerWithoutItem("potted_rose_c0_0_20a", createFlowerPotBlock(ROSE_C0_0_20A));
        POPPY_1_7 = register("poppy_1_7", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(POPPY)));
        POTTED_POPPY_1_7 = registerWithoutItem("potted_poppy_1_7", createFlowerPotBlock(POPPY_1_7));
        BROWN_MUSHROOM_C0_0_20A = register("brown_mushroom_c0_0_20a", new MushroomBlock(AbstractBlock.Settings.copy(BROWN_MUSHROOM)), new Item.Settings().food(FoodList.BROWN_MUSHROOM_C0_0_20A_SETTINGS));
        POTTED_BROWN_MUSHROOM_C0_0_20A = registerWithoutItem("potted_brown_mushroom_c0_0_20a", createFlowerPotBlock(BROWN_MUSHROOM_C0_0_20A));
        RED_MUSHROOM_C0_0_20A = register("red_mushroom_c0_0_20a", new MushroomBlock(AbstractBlock.Settings.copy(RED_MUSHROOM)), new Item.Settings().food(FoodList.RED_MUSHROOM_C0_0_20A_SETTINGS));
        POTTED_RED_MUSHROOM_C0_0_20A = registerWithoutItem("potted_red_mushroom_c0_0_20a", createFlowerPotBlock(RED_MUSHROOM_C0_0_20A));
        STONE_SLAB_C0_26ST = register("stone_slab_c0_26st", new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_STONE_SLAB)));
        IRON_BLOCK_C0_26ST = register("iron_block_c0_26st", new Block(AbstractBlock.Settings.copy(IRON_BLOCK)));
        IRON_BLOCK_A1_2_0 = register("iron_block_a1_2_0", new Block(AbstractBlock.Settings.copy(IRON_BLOCK)));
        IRON_BLOCK_B1_9PRE5 = register("iron_block_b1_9pre5", new Block(AbstractBlock.Settings.copy(IRON_BLOCK)));
        TNT_C0_26ST = register("tnt_c0_26st", new TntBlock(AbstractBlock.Settings.copy(TNT)));
        TNT_C0_28A = register("tnt_c0_28a", new TntBlock(AbstractBlock.Settings.copy(TNT)));
        MOSSY_COBBLESTONE_C0_26ST = register("mossy_cobblestone_c0_26st", new Block(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE)));
        MOSSY_COBBLESTONE_B1_8 = register("mossy_cobblestone_b1_8", new Block(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE)));
        BRICKS_C0_26ST = register("bricks_c0_26st", new Block(AbstractBlock.Settings.copy(BRICKS)));
        BRICKS_A1_0_11 = register("bricks_a1_0_11", new Block(AbstractBlock.Settings.copy(BRICKS)));
        BOOKSHELF_C0_26ST = register("bookshelf_c0_26st", new Block(AbstractBlock.Settings.copy(BOOKSHELF)));
        BOOKSHELF_B1_9PRE5 = register("bookshelf_b1_9pre5", new Block(AbstractBlock.Settings.copy(BOOKSHELF)));
        OBSIDIAN_C0_28A = register("obsidian_c0_28a", new Block(AbstractBlock.Settings.copy(OBSIDIAN)));
        DIAMOND_ORE_IN20100128 = register("diamond_ore_in20100128", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(DIAMOND_ORE)));
        DIAMOND_ORE_1_14 = register("diamond_ore_1_14", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(DIAMOND_ORE)));
        DIAMOND_BLOCK_IN20100128 = register("diamond_block_in20100128", new Block(AbstractBlock.Settings.copy(DIAMOND_BLOCK)));
        DIAMOND_BLOCK_A1_2_0 = register("diamond_block_a1_2_0", new Block(AbstractBlock.Settings.copy(DIAMOND_BLOCK)));
        DIAMOND_BLOCK_B1_9PRE5 = register("diamond_block_b1_9pre5", new Block(AbstractBlock.Settings.copy(DIAMOND_BLOCK)));
        CRAFTING_TABLE_IN20100131 = register("crafting_table_in20100131", new Block(AbstractBlock.Settings.copy(CRAFTING_TABLE)));
        CRAFTING_TABLE_1_14 = register("crafting_table_1_14", new Block(AbstractBlock.Settings.copy(CRAFTING_TABLE)));
        FURNACE_IN20100219 = register("furnace_in20100219", new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)));
        LIT_FURNACE_IN20100219 = register("lit_furnace_in20100219", new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F).luminance((state) -> {
            return 13;
        })));
        FURNACE_B1_2 = register("furnace_b1_2", new Block(AbstractBlock.Settings.copy(FURNACE_IN20100219)));
        LIT_FURNACE_B1_2 = register("lit_furnace_b1_2", new Block(AbstractBlock.Settings.copy(LIT_FURNACE_IN20100219)));
        LADDER_INF20100607 = register("ladder_inf20100607", new LadderBlock(AbstractBlock.Settings.copy(LADDER)));
        LADDER_INF20100618 = register("ladder_inf20100618", new LadderBlock(AbstractBlock.Settings.copy(LADDER)));
        WOODEN_STAIRS_RD20090515 = register("wooden_stairs_rd20090515", new StairsBlock(WOODEN_PLANKS_RD20090515.getDefaultState(), AbstractBlock.Settings.copy(OAK_STAIRS)));
        WOODEN_STAIRS_RD161348 = register("wooden_stairs_rd161348", new StairsBlock(WOODEN_PLANKS_RD161348.getDefaultState(), AbstractBlock.Settings.copy(OAK_STAIRS)));
        WOODEN_STAIRS_C0_0_14A = register("wooden_stairs_c0_0_14a", new StairsBlock(WOODEN_PLANKS_C0_0_14A.getDefaultState(), AbstractBlock.Settings.copy(OAK_STAIRS)));
        WOODEN_STAIRS_INF20100629 = register("wooden_stairs_inf20100629", new StairsBlock(WOODEN_PLANKS_C0_0_15A.getDefaultState(), AbstractBlock.Settings.copy(OAK_STAIRS)));
        WOODEN_STAIRS_B1_9PRE5 = register("wooden_stairs_b1_9pre5", new StairsBlock(WOODEN_PLANKS_B1_9PRE5.getDefaultState(), AbstractBlock.Settings.copy(OAK_STAIRS)));
        COBBLESTONE_STAIRS_RD20090515 = register("cobblestone_stairs_rd20090515", new StairsBlock(COBBLESTONE_RD20090515.getDefaultState(), AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)));
        COBBLESTONE_STAIRS_C0_0_14A = register("cobblestone_stairs_c0_0_14a", new StairsBlock(COBBLESTONE_C_0_0_14A.getDefaultState(), AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)));
        COBBLESTONE_STAIRS_B1_7 = register("cobblestone_stairs_b1_7", new StairsBlock(COBBLESTONE_B1_7.getDefaultState(), AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)));
        SIGN_INF20100607_TEXTURE = Blocktopia.id("entity/signs/wooden_c0_0_15a");
        TORCH_IN20100124_2 = registerWithoutItem("torch_in20100124_2", new TorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> {return 14;}).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
        WALL_TORCH_IN20100124_2 = registerWithoutItem("wall_torch_in20100124_2", new WallTorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> {
            return 14;
        }).sounds(BlockSoundGroup.WOOD).dropsLike(TORCH_IN20100124_2).pistonBehavior(PistonBehavior.DESTROY)));
        SIGN_INF20100607 = registerWithoutItem("sign_inf20100607", new BlocktopiaSignBlock(SIGN_INF20100607_TEXTURE, AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
        WALL_SIGN_INF20100607 = registerWithoutItem("wall_sign_inf20100607", new BlocktopiaWallSignBlock(SIGN_INF20100607_TEXTURE, AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).dropsLike(SIGN_INF20100607).burnable()));
        WOODEN_DOOR_INF20100607 = register("wooden_door_inf20100607", new DoorBlock(BlockSetTypeList.WOODEN_C0_0_15A, AbstractBlock.Settings.copy(OAK_DOOR)));
        REDSTONE_ORE_A1_0_1 = register("redstone_ore_a1_0_1", new RedstoneOreBlock(AbstractBlock.Settings.copy(REDSTONE_ORE)));
        REDSTONE_ORE_1_14 = register("redstone_ore_1_14", new RedstoneOreBlock(AbstractBlock.Settings.copy(REDSTONE_ORE)));
        REDSTONE_TORCH_A1_0_1 = registerWithoutItem("redstone_torch_a1_0_1", new RedstoneTorchBlock(AbstractBlock.Settings.copy(REDSTONE_TORCH)));
        REDSTONE_WALL_TORCH_A1_0_1 = registerWithoutItem("redstone_wall_torch_a1_0_1", new WallRedstoneTorchBlock(AbstractBlock.Settings.copy(REDSTONE_WALL_TORCH).dropsLike(REDSTONE_TORCH_A1_0_1)));
        SNOW_A1_0_4 = register("snow_a1_0_4", new SnowBlock(AbstractBlock.Settings.copy(SNOW)));
        ICE_A1_0_4 = register("ice_a1_0_4", new Block(AbstractBlock.Settings.copy(ICE)));
        SNOW_BLOCK_A1_0_5 = register("snow_block_a1_0_5", new Block(AbstractBlock.Settings.copy(SNOW_BLOCK)));
        CLAY_BLOCK_A1_0_11 = register("clay_block_a1_0_11", new Block(AbstractBlock.Settings.copy(CLAY)));
        WOODEN_FENCE_RD20090515 = register("wooden_fence_rd20090515", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
        WOODEN_FENCE_RD161348 = register("wooden_fence_rd161348", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
        WOODEN_FENCE_C0_0_14A = register("wooden_fence_c0_0_14a", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
        WOODEN_FENCE_A1_0_17 = register("wooden_fence_a1_0_17", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
        WOODEN_FENCE_B1_9PRE5 = register("wooden_fence_b1_9pre5", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
        NETHERRACK_A1_2_0 = register("netherrack_a1_2_0", new Block(AbstractBlock.Settings.copy(NETHERRACK)));
        NETHERRACK_B1_9PRE5 = register("netherrack_b1_9pre5", new Block(AbstractBlock.Settings.copy(NETHERRACK)));
        SOUL_SAND_A1_2_0 = register("soul_sand_a1_2_0", new SoulSandBlock(AbstractBlock.Settings.copy(SOUL_SAND)));
        GLOWSTONE_A1_2_0 = register("glowstone_a1_2_0", new Block(AbstractBlock.Settings.copy(GLOWSTONE)));
        GLOWSTONE_B1_9PRE5 = register("glowstone_b1_9pre5", new Block(AbstractBlock.Settings.copy(GLOWSTONE)));
        CARVED_PUMPKIN_A1_2_0 = register("carved_pumpkin_a1_2_0", new CarvedPumpkinBlock(AbstractBlock.Settings.copy(CARVED_PUMPKIN)));
        JACK_O_LANTERN_A1_2_0 = register("jack_o_lantern_a1_2_0", new CarvedPumpkinBlock(AbstractBlock.Settings.copy(JACK_O_LANTERN)));
    }
}
