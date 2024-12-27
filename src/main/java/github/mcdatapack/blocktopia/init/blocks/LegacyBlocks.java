package github.mcdatapack.blocktopia.init.blocks;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.SpongeBlockClassic;
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

import static net.minecraft.block.AbstractBlock.Settings.*;
import static net.minecraft.block.Blocks.*;

public class LegacyBlocks {
    public static final Block COBBLESTONE_RD20090515 = registerC("cobblestone_rd20090515", COBBLESTONE);
    public static final Block COBBLESTONE_C_0_0_14A = registerC("cobblestone_c_0_0_14a", COBBLESTONE);
    public static final Block COBBLESTONE_B1_7 = registerC("cobblestone_b1_7", COBBLESTONE);
    public static final Block WOODEN_PLANKS_RD20090515 = registerC("wooden_planks_rd20090515", OAK_PLANKS);
    public static final Block WOODEN_PLANKS_RD161348 = registerC("wooden_planks_rd161348", OAK_PLANKS);
    public static final Block WOODEN_PLANKS_C0_0_14A = registerC("wooden_planks_c0_0_14a", OAK_PLANKS);
    public static final Block WOODEN_PLANKS_C0_0_15A = registerC("wooden_planks_c0_0_15a", OAK_PLANKS);
    public static final Block WOODEN_PLANKS_B1_9PRE5 = registerC("wooden_planks_b1_9pre5", OAK_PLANKS);
    public static final Block LOG_C0_0_14A = register("log_c0_0_14a", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN));
    public static final LeavesBlock LEAVES_C0_0_14A = register("leaves_c0_0_14a", new LeavesBlock(copy(OAK_LEAVES)));
    public static final LeavesBlock LEAVES_C0_0_15A = register("leaves_c0_0_15a", new LeavesBlock(copy(OAK_LEAVES)));
    public static final LeavesBlock LEAVES_C0_24ST = register("leaves_c0_24st", new LeavesBlock(copy(OAK_LEAVES)));
    public static final FlowerBlock SAPLING_RD161348 = register("sapling_rd161348", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F,
            copy(OAK_SAPLING)));
    public static final Block POTTED_SAPLING_RD161348 = register("potted_sapling_rd161348", createFlowerPotBlock(OAK_SAPLING));
    public static final FlowerBlock SAPLING_C0_0_13A = register("sapling_c0_0_13a", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F, copy(OAK_SAPLING)));
    public static final Block POTTED_SAPLING_C0_0_13A = register("potted_sapling_c0_0_13a", createFlowerPotBlock(SAPLING_C0_0_13A));
    public static final SaplingBlock SAPLING_C0_24ST = register("sapling_c0_24st", new SaplingBlock(new SaplingGenerator(Blocktopia.id("sapling").toString(),
            0.1F,
            Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY),
            Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY),
            Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY), Optional.of(ConfiguredFeatureInit.TREE_C0_24ST_KEY)),
            copy(OAK_SAPLING)));
    public static final Block POTTED_SAPLING_C0_24ST = registerWithoutItem("potted_sapling_c0_24st", createFlowerPotBlock(SAPLING_C0_24ST));
    public static final Block BEDROCK_C0_0_12A = registerC("bedrock_c0_0_12a", BEDROCK);
    public static final FallingBlock SAND_C0_0_14A = register("sand_c0_0_14a", new FallingBlock(copy(SAND)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock SAND_C0_0_15A = register("sand_c0_0_15a", new FallingBlock(copy(SAND)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock SAND_B1_9PRE6 = register("sand_b1_9pre6", new FallingBlock(copy(SAND)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock GRAVEL_C0_0_14A = register("gravel_c0_0_14a", new FallingBlock(copy(GRAVEL)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock GRAVEL_C0_0_15A = register("gravel_c0_0_15a", new FallingBlock(copy(GRAVEL)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock GRAVEL_B1_9PRE5 = register("gravel_b1_9pre5", new FallingBlock(copy(GRAVEL)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock GRAVEL_1_3 = register("gravel_1_3", new FallingBlock(copy(GRAVEL)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final ExperienceDroppingBlock COAL_ORE_C0_0_14A = register("coal_ore_c0_0_14a",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), copy(COAL_ORE)));
    public static final ExperienceDroppingBlock COAL_ORE_1_14 = register("coal_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), copy(COAL_ORE)));
    public static final Block IRON_ORE_C0_0_14A = registerC("iron_ore_c0_0_14a", IRON_ORE);
    public static final Block IRON_ORE_1_14 = registerC("iron_ore_1_14", IRON_ORE);
    public static final Block IRON_ORE_1_14_1 = registerC("iron_ore_1_14_1", IRON_ORE);
    public static final Block GOLD_ORE_C0_0_14A = registerC("gold_ore_c0_0_14a", GOLD_ORE);
    public static final Block GOLD_ORE_C0_26ST = registerC("gold_ore_c0_26st", GOLD_ORE);
    public static final Block GOLD_ORE_1_14 = registerC("gold_ore_1_14", GOLD_ORE);
    public static final SpongeBlockClassic SPONGE_C0_0_19A = register("sponge_c0_0_19a", new SpongeBlockClassic(copy(SPONGE)));
    public static final SpongeBlock_1_8 SPONGE_1_8 = register("sponge_1_8", new SpongeBlock_1_8(copy(SPONGE)));
    public static final WetSpongeBlock_1_8 WET_SPONGE_1_8 = register("wet_sponge_1_8", new WetSpongeBlock_1_8(copy(WET_SPONGE)));
    public static final TransparentBlock GLASS_C0_0_19A = register("glass_c0_0_19a", new TransparentBlock(copy(GLASS)));
    public static final Block WHITE_CLOTH = registerC("withe_cloth", WHITE_WOOL);
    public static final Block LIGHT_GRAY_CLOTH_C0_0_20A = registerC("light_gray_cloth_c0_0_20a", LIGHT_GRAY_WOOL);
    public static final Block LIGHT_GRAY_CLOTH_C0_28A = registerC("light_gray_cloth_c0_28a", LIGHT_GRAY_WOOL);
    public static final Block DARK_GRAY_CLOTH_C0_0_20A = registerC("dark_gray_cloth_c0_0_20a", GRAY_WOOL);
    public static final Block DARK_GRAY_CLOTH_C0_28A = registerC("dark_gray_cloth_c0_28a", GRAY_WOOL);
    public static final Block RED_CLOTH = registerC("red_cloth", RED_WOOL);
    public static final Block ORANGE_CLOTH = registerC("orange_cloth", ORANGE_WOOL);
    public static final Block YELLOW_CLOTH = registerC("yellow_cloth", YELLOW_WOOL);
    public static final Block CHARTREUSE_CLOTH = registerC("chartreuse_cloth", LIME_WOOL);
    public static final Block SPRING_GREEN_CLOTH = registerC("spring_green_cloth", GREEN_WOOL);
    public static final Block CYAN_CLOTH = registerC("cyan_cloth", CYAN_WOOL);
    public static final Block CAPRI_CLOTH = registerC("capri_cloth", LIGHT_BLUE_WOOL);
    public static final Block ULTRAMARINE_CLOTH = registerC("ultramarine_cloth", BLUE_WOOL);
    public static final Block VIOLET_CLOTH = registerC("violet_cloth", PURPLE_WOOL);
    public static final Block PURPLE_CLOTH = registerC("purple_cloth", PURPLE_WOOL);
    public static final Block MAGENTA_CLOTH = registerC("magenta_cloth", MAGENTA_WOOL);
    public static final Block ROSE_CLOTH = registerC("rose_cloth", PINK_WOOL);
    public static final Block GOLD_BLOCK_C0_0_20A = registerC("gold_block_c0_0_20a", GOLD_BLOCK);
    public static final Block GOLD_BLOCK_C0_26ST = registerC("gold_block_c0_26st", GOLD_BLOCK);
    public static final Block GOLD_BLOCK_A1_2_0 = registerC("gold_block_a1_2_0", GOLD_BLOCK);
    public static final Block GOLD_BLOCK_B1_9PRE5 = registerC("gold_block_b1_9pre5", GOLD_BLOCK);
    public static final FlowerBlock DANDELION_C0_0_20A = register("dandelion_c0_0_20a", new FlowerBlock(StatusEffects.SATURATION, 0.35F, copy(DANDELION)));
    public static final Block POTTED_DANDELIONS_C0_0_20A = registerWithoutItem("potted_dandelion_c0_0_20a", createFlowerPotBlock(DANDELION_C0_0_20A));
    public static final FlowerBlock ROSE_C0_0_20A = register("rose_c0_0_20a", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, copy(POPPY)));
    public static final Block POTTED_ROSE_C0_0_20A = registerWithoutItem("potted_rose_c0_0_20a", createFlowerPotBlock(ROSE_C0_0_20A));
    public static final FlowerBlock POPPY_1_7 = register("poppy_1_7", new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, copy(POPPY)));
    public static final Block POTTED_POPPY_1_7 = registerWithoutItem("potted_poppy_1_7", createFlowerPotBlock(POPPY_1_7));
    public static final MushroomBlock BROWN_MUSHROOM_C0_0_20A = register("brown_mushroom_c0_0_20a", new MushroomBlock(copy(BROWN_MUSHROOM)), new Item.Settings().food(FoodList.BROWN_MUSHROOM_C0_0_20A_SETTINGS));
    public static final Block POTTED_BROWN_MUSHROOM_C0_0_20A = registerWithoutItem("potted_brown_mushroom_c0_0_20a", createFlowerPotBlock(BROWN_MUSHROOM_C0_0_20A));
    public static final MushroomBlock RED_MUSHROOM_C0_0_20A = register("red_mushroom_c0_0_20a", new MushroomBlock(copy(RED_MUSHROOM)), new Item.Settings().food(FoodList.RED_MUSHROOM_C0_0_20A_SETTINGS));
    public static final Block POTTED_RED_MUSHROOM_C0_0_20A = registerWithoutItem("potted_red_mushroom_c0_0_20a", createFlowerPotBlock(RED_MUSHROOM_C0_0_20A));
    public static final SlabBlock STONE_SLAB_C0_26ST = register("stone_slab_c0_26st", new SlabBlock(copy(SMOOTH_STONE_SLAB)));
    public static final Block IRON_BLOCK_C0_26ST = registerC("iron_block_c0_26st", IRON_BLOCK);
    public static final Block IRON_BLOCK_A1_2_0 = registerC("iron_block_a1_2_0", IRON_BLOCK);
    public static final Block IRON_BLOCK_B1_9PRE5 = registerC("iron_block_b1_9pre5", IRON_BLOCK);
    public static final TntBlock TNT_C0_26ST = register("tnt_c0_26st", new TntBlock(copy(TNT)));
    public static final TntBlock TNT_C0_28A = register("tnt_c0_28a", new TntBlock(copy(TNT)));
    public static final Block MOSSY_COBBLESTONE_C0_26ST = registerC("mossy_cobblestone_c0_26st", MOSSY_COBBLESTONE);
    public static final Block MOSSY_COBBLESTONE_B1_8 = registerC("mossy_cobblestone_b1_8", MOSSY_COBBLESTONE);
    public static final Block BRICKS_C0_26ST = registerC("bricks_c0_26st", BRICKS);
    public static final Block BRICKS_A1_0_11 = registerC("bricks_a1_0_11", BRICKS);
    public static final Block BOOKSHELF_C0_26ST = registerC("bookshelf_c0_26st", BOOKSHELF);
    public static final Block BOOKSHELF_B1_9PRE5 = registerC("bookshelf_b1_9pre5", BOOKSHELF);
    public static final Block OBSIDIAN_C0_28A = registerC("obsidian_c0_28a", OBSIDIAN);
    public static final ExperienceDroppingBlock DIAMOND_ORE_IN20100128 = register("diamond_ore_in20100128",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), copy(DIAMOND_ORE)));
    public static final ExperienceDroppingBlock DIAMOND_ORE_1_14 = register("diamond_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), copy(DIAMOND_ORE)));
    public static final Block DIAMOND_BLOCK_IN20100128 = registerC("diamond_block_in20100128", DIAMOND_BLOCK);
    public static final Block DIAMOND_BLOCK_A1_2_0 = registerC("diamond_block_a1_2_0", DIAMOND_BLOCK);
    public static final Block DIAMOND_BLOCK_B1_9PRE5 = registerC("diamond_block_b1_9pre5", DIAMOND_BLOCK);
    public static final Block CRAFTING_TABLE_IN20100131 = registerC("crafting_table_in20100131", CRAFTING_TABLE);
    public static final Block CRAFTING_TABLE_1_14 = registerC("crafting_table_1_14", CRAFTING_TABLE);
    public static final Block FURNACE_IN20100219 = register("furnace_in20100219", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)));
    public static final Block LIT_FURNACE_IN20100219 = register("lit_furnace_in20100219", new Block(AbstractBlock.Settings.create().
            mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F).luminance((state) -> 13)));
    public static final Block FURNACE_B1_2  = registerC("furnace_b1_2", FURNACE_IN20100219);
    public static final Block LIT_FURNACE_B1_2 = registerC("lit_furnace_b1_2", LIT_FURNACE_IN20100219);
    public static final LadderBlock LADDER_INF20100607 = register("ladder_inf20100607", new LadderBlock(copy(LADDER)));
    public static final LadderBlock LADDER_INF20100618 = register("ladder_inf20100618", new LadderBlock(copy(LADDER)));
    public static final StairsBlock WOODEN_STAIRS_RD20090515 = register("wooden_stairs_rd20090515", new StairsBlock(WOODEN_PLANKS_RD20090515.getDefaultState(), copy(OAK_STAIRS)));
    public static final StairsBlock WOODEN_STAIRS_RD161348 = register("wooden_stairs_rd161348", new StairsBlock(WOODEN_PLANKS_RD161348.getDefaultState(), copy(OAK_STAIRS)));
    public static final StairsBlock WOODEN_STAIRS_C0_0_14A = register("wooden_stairs_c0_0_14a", new StairsBlock(WOODEN_PLANKS_C0_0_14A.getDefaultState(), copy(OAK_STAIRS)));
    public static final StairsBlock WOODEN_STAIRS_INF20100629 = register("wooden_stairs_inf20100629", new StairsBlock(WOODEN_PLANKS_C0_0_15A.getDefaultState(), copy(OAK_STAIRS)));
    public static final StairsBlock WOODEN_STAIRS_B1_9PRE5 = register("wooden_stairs_b1_9pre5", new StairsBlock(WOODEN_PLANKS_B1_9PRE5.getDefaultState(), copy(OAK_STAIRS)));
    public static final StairsBlock COBBLESTONE_STAIRS_RD20090515 = register("cobblestone_stairs_rd20090515", new StairsBlock(COBBLESTONE_RD20090515.getDefaultState(), copy(COBBLESTONE_STAIRS)));
    public static final StairsBlock COBBLESTONE_STAIRS_C0_0_14A = register("cobblestone_stairs_c0_0_14a", new StairsBlock(COBBLESTONE_C_0_0_14A.getDefaultState(), copy(COBBLESTONE_STAIRS)));
    public static final StairsBlock COBBLESTONE_STAIRS_B1_7 = register("cobblestone_stairs_b1_7", new StairsBlock(COBBLESTONE_B1_7.getDefaultState(), copy(COBBLESTONE_STAIRS)));
    public static Identifier SIGN_INF20100607_TEXTURE = Blocktopia.id("entity/signs/wooden_c0_0_15a");
    public static final TorchBlock TORCH_IN20100124_2 = registerWithoutItem("torch_in20100124_2", new TorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final WallTorchBlock WALL_TORCH_IN20100124_2 = registerWithoutItem("wall_torch_in20100124_2", new WallTorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final BlocktopiaSignBlock SIGN_INF20100607 = registerWithoutItem("sign_inf20100607", new BlocktopiaSignBlock(SIGN_INF20100607_TEXTURE, AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaWallSignBlock WALL_SIGN_INF20100607 = registerWithoutItem("wall_sign_inf20100607", new BlocktopiaWallSignBlock(SIGN_INF20100607_TEXTURE, AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final DoorBlock WOODEN_DOOR_INF20100607 = register("wooden_door_inf20100607", new DoorBlock(BlockSetTypeList.WOODEN_C0_0_15A, copy(OAK_DOOR)));
    public static final RedstoneOreBlock REDSTONE_ORE_A1_0_1 = register("redstone_ore_a1_0_1", new RedstoneOreBlock(copy(REDSTONE_ORE)));
    public static final RedstoneOreBlock REDSTONE_ORE_1_14 = register("redstone_ore_1_14", new RedstoneOreBlock(copy(REDSTONE_ORE)));
    public static final RedstoneTorchBlock REDSTONE_TORCH_A1_0_1 = registerWithoutItem("redstone_torch_a1_0_1", new RedstoneTorchBlock(copy(REDSTONE_TORCH)));
    public static final WallRedstoneTorchBlock REDSTONE_WALL_TORCH_A1_0_1 = registerWithoutItem("redstone_wall_torch_a1_0_1", new WallRedstoneTorchBlock(copy(REDSTONE_WALL_TORCH).dropsLike(REDSTONE_TORCH_A1_0_1)));
    public static final SnowBlock SNOW_A1_0_4 = register("snow_a1_0_4", new SnowBlock(copy(SNOW)));
    public static final Block ICE_A1_0_4 = registerC("ice_a1_0_4", ICE);
    public static final Block SNOW_BLOCK_A1_0_5 = registerC("snow_block_a1_0_5", SNOW_BLOCK);
    public static final Block CLAY_BLOCK_A1_0_11 = registerC("clay_block_a1_0_11", CLAY);
    public static final FenceBlock WOODEN_FENCE_RD20090515 = register("wooden_fence_rd20090515", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceBlock WOODEN_FENCE_RD161348 = register("wooden_fence_rd161348", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceBlock WOODEN_FENCE_C0_0_14A = register("wooden_fence_c0_0_14a", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceBlock WOODEN_FENCE_A1_0_17 = register("wooden_fence_a1_0_17", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceBlock WOODEN_FENCE_B1_9PRE5 = register("wooden_fence_b1_9pre5", new FenceBlock(AbstractBlock.Settings.create().solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block NETHERRACK_A1_2_0 = registerC("netherrack_a1_2_0", NETHERRACK);
    public static final Block NETHERRACK_B1_9PRE5 = registerC("netherrack_b1_9pre5", NETHERRACK);
    public static final SoulSandBlock SOUL_SAND_A1_2_0 = register("soul_sand_a1_2_0", new SoulSandBlock(copy(SOUL_SAND)));
    public static final Block GLOWSTONE_A1_2_0 = registerC("glowstone_a1_2_0", GLOWSTONE);
    public static final Block GLOWSTONE_B1_9PRE5 = registerC("glowstone_b1_9pre5", GLOWSTONE);
    public static final CarvedPumpkinBlock CARVED_PUMPKIN_A1_2_0 = register("carved_pumpkin_a1_2_0", new CarvedPumpkinBlock(copy(CARVED_PUMPKIN)));
    public static final CarvedPumpkinBlock JACK_O_LANTERN_A1_2_0 = register("jack_o_lantern_a1_2_0", new CarvedPumpkinBlock(copy(JACK_O_LANTERN)));

    /*public static final Block LIGHT_GRAY_WOOL_B1_2 = registerC("light_gray_wool_b1_2", WHITE_WOOL);
    public static final Block GRAY_WOOL_B1_2 = registerC("gray_wool_b1_2", GRAY_WOOL);
    public static final Block BLACK_WOOL_B1_2 = registerC("black_wool_b1_2", BLACK_WOOL);
    public static final Block BROWN_WOOL_B1_2 = registerC("brown_wool_b1_2", BROWN_WOOL);
    public static final Block RED_WOOL_B1_2 = registerC("red_wool_b1_2", RED_WOOL);
    public static final Block ORANGE_WOOL_B1_2 = registerC("orange_wool_b1_2", ORANGE_WOOL);
    public static final Block YELLOW_WOOL_B1_2 = registerC("yellow_wool_b1_2", YELLOW_WOOL);
    public static final Block LIME_WOOL_B1_2 = registerC("lime_wool_b1_2", LIME_WOOL);
    public static final Block GREEN_WOOL_B1_2 = registerC("green_wool_b1_2", GREEN_WOOL);
    public static final Block CYAN_WOOL_B1_2 = registerC("cyan_wool_b1_2", CYAN_WOOL);
    public static final Block LIGHT_BLUE_WOOL_B1_2 = registerC("light_blue_wool_b1_2", LIGHT_BLUE_WOOL);
    public static final Block BLUE_WOOL_B1_2 = registerC("blue_wool_b1_2", BLUE_WOOL);
    public static final Block PURPLE_WOOL_B1_2 = registerC("purple_wool_b1_2", PURPLE_WOOL);
    public static final Block MAGENTA_WOOL_B1_2 = registerC("magenta_wool_b1_2", MAGENTA_WOOL);
    public static final Block PINK_WOOL_B1_2 = registerC("pink_wool_b1_2", PINK_WOOL);
    public static final Block LIGHT_GRAY_WOOL_1_2_4 = registerC("light_gray_wool_1_2_4", WHITE_WOOL);
    public static final Block GRAY_WOOL_1_2_4 = registerC("gray_wool_1_2_4", GRAY_WOOL);
    public static final Block BLACK_WOOL_1_2_4 = registerC("black_wool_1_2_4", BLACK_WOOL);
    public static final Block BROWN_WOOL_1_2_4 = registerC("brown_wool_1_2_4", BROWN_WOOL);
    public static final Block RED_WOOL_1_2_4 = registerC("red_wool_1_2_4", RED_WOOL);
    public static final Block ORANGE_WOOL_1_2_4 = registerC("orange_wool_1_2_4", ORANGE_WOOL);
    public static final Block YELLOW_WOOL_1_2_4 = registerC("yellow_wool_1_2_4", YELLOW_WOOL);
    public static final Block LIME_WOOL_1_2_4 = registerC("lime_wool_1_2_4", LIME_WOOL);
    public static final Block GREEN_WOOL_1_2_4 = registerC("green_wool_1_2_4", GREEN_WOOL);
    public static final Block CYAN_WOOL_1_2_4 = registerC("cyan_wool_1_2_4", CYAN_WOOL);
    public static final Block LIGHT_BLUE_WOOL_1_2_4 = registerC("light_blue_wool_1_2_4", LIGHT_BLUE_WOOL);
    public static final Block BLUE_WOOL_1_2_4 = registerC("blue_wool_1_2_4", BLUE_WOOL);
    public static final Block PURPLE_WOOL_1_2_4 = registerC("purple_wool_1_2_4", PURPLE_WOOL);
    public static final Block MAGENTA_WOOL_1_2_4 = registerC("magenta_wool_1_2_4", MAGENTA_WOOL);
    public static final Block PINK_WOOL_1_2_4 = registerC("pink_wool_1_2_4", PINK_WOOL);
    public static final CakeBlock CAKE_B1_2 = register("cake_b1_2", new CakeBlock(copy(CAKE)));
    public static final ExperienceDroppingBlock LAPIS_ORE_B1_2 = register("lapis_ore_b1_2",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), copy(LAPIS_ORE)));
    public static final ExperienceDroppingBlock LAPIS_ORE_1_14 = register("lapis_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), copy(LAPIS_ORE)));
    public static final Block LAPIS_BLOCK_B1_2 = registerC("lapis_block_b1_2", LAPIS_BLOCK);
    public static final Block LAPIS_BLOCK_1_6 = registerC("lapis_block_1_6", LAPIS_BLOCK);
    public static final NoteBlock NOTE_BLOCK_B1_2 = register("note_block_b1_2", new NoteBlock(copy(NOTE_BLOCK)));
    public static final Block SANDSTONE_B1_2 = registerC("sandstone_b1_2", SANDSTONE);
    public static final Block SANDSTONE_1_2_4 = registerC("sandstone_1_2_4", SANDSTONE);
    public static final Block BIRCH_LOG_B1_2 = register("brich_log_b1_2", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE));
    public static final Block BIRCH_LOG_1_7 = register("birch_log_1_7", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE));
    public static final ExtendedLeavesBlock BIRCH_LEAVES_B1_2 = register("birch_leaves_b1_2", new ExtendedLeavesBlock(copy(BIRCH_LEAVES)));
    public static final Block SPRUCE_LOG_B1_2 = register("spuce_log_b1_2", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN));
    public static final Block SPRUCE_LOG_1_7 = register("spruce_log_1_7", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN));
    public static final ExtendedLeavesBlock SPRUCE_LEAVES_B1_2 = register("spruce_leaves_b1_2", new ExtendedLeavesBlock(copy(SPRUCE_LEAVES)));
    public static final SlabBlock COBBLESTONE_SLAB_RD20090515 = register("cobblestone_slab_rd20090515", new SlabBlock(copy(COBBLESTONE_SLAB)));
    public static final SlabBlock COBBLESTONE_SLAB_B1_3 = register("cobblestone_slab_b1_3", new SlabBlock(copy(COBBLESTONE_SLAB)));
    public static final SlabBlock COBBLESTONE_SLAB_B1_7 = register("cobblestone_slab_b1_7", new SlabBlock(copy(COBBLESTONE_SLAB)));
    public static final SlabBlock WOODEN_SLAB_RD20090515 = register("wooden_slab_rd20090515", new SlabBlock(copy(PETRIFIED_OAK_SLAB)));
    public static final SlabBlock WOODEN_SLAB_RD161348 = register("wooden_slab_rd161348", new SlabBlock(copy(PETRIFIED_OAK_SLAB)));
    public static final SlabBlock WOODEN_SLAB_C0_0_14A = register("wooden_slab_c0_0_14a", new SlabBlock(copy(PETRIFIED_OAK_SLAB)));
    public static final SlabBlock WOODEN_SLAB_B1_3 = register("wooden_slab_b1_3", new SlabBlock(copy(PETRIFIED_OAK_SLAB)));
    public static final SlabBlock WOODEN_SLAB_B1_9PRE5 = register("wooden_slab_b1_9pre5", new SlabBlock(copy(PETRIFIED_OAK_SLAB)));
    public static final SlabBlock SANDSTONE_SLAB_B1_2 = register("sandstone_slab_b1_2", new SlabBlock(copy(SANDSTONE_SLAB)));
    public static final SlabBlock SANDSTONE_SLAB_1_2_4 = register("sandstone_slab_1_2_4", new SlabBlock(copy(SANDSTONE_SLAB)));
    public static final Block SMOOTH_STONE_B1_3 = registerC("smooth_stone_b1_3", SMOOTH_STONE);
    public static final SaplingBlock BIRCH_SAPLING_B1_5 = register("birch_sapling_b1_5", new SaplingBlock(new SaplingGenerator(Blocktopia.id("birch_b1_5").toString(),
            0.1F, Optional.empty(), Optional.empty(), Optional.of(ConfiguredFeatureInit.BIRCH_B1_5_KEY),
            Optional.empty(), Optional.empty(), Optional.empty()), copy(BIRCH_SAPLING)));
    public static final SaplingBlock SPRUCE_SAPLING_B1_5 = register("spruce_sapling_b1_5", new SaplingBlock(new SaplingGenerator(Blocktopia.id("spruce_b1_5").toString(),
            0.1F, Optional.empty(), Optional.empty(), Optional.of(ConfiguredFeatureInit.SPRUCE_B1_5_KEY),
            Optional.empty(), Optional.empty(), Optional.empty()), copy(SPRUCE_SAPLING)));
    public static final TrapdoorBlock TRAPDOOR_B1_5 = register("trapdoor_b1_5", new TrapdoorBlock(BlockSetTypeList.WOODEN_C0_0_15A, copy(OAK_TRAPDOOR)));*/



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
    public static Block registerC(String name, Block copy) {
        return register(name, new Block(AbstractBlock.Settings.copy(copy)), new Item.Settings());
    }

    public static void load() {}
}
