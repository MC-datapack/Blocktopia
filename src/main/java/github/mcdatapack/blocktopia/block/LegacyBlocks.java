package github.mcdatapack.blocktopia.block;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.ExtendedLeavesBlock;
import github.mcdatapack.blocktopia.block.custom.SpongeBlockClassic;
import github.mcdatapack.blocktopia.block.custom.SpongeBlock_1_8;
import github.mcdatapack.blocktopia.block.custom.WetSpongeBlock_1_8;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import github.mcdatapack.blocktopia.item.ModFoodComponents;

import java.util.List;

import github.mcdatapack.blocktopia.worldgen.tree.sapling.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;
import static net.minecraft.block.Blocks.*;

public interface LegacyBlocks {
    Block COBBLESTONE_RD20090515 = copy("cobblestone_rd20090515", COBBLESTONE, RD20090515, C0_0_13A_03);
    Block COBBLESTONE_C_0_0_14A = copy("cobblestone_c_0_0_14a", COBBLESTONE, C0_0_14A, B1_6_6);
    Block COBBLESTONE_B1_7 = copy("cobblestone_b1_7", COBBLESTONE,B1_7, _1_13_2);
    Block WOODEN_PLANKS_RD20090515 = copy("wooden_planks_rd20090515", OAK_PLANKS, RD20090515, RD160052);
    Block WOODEN_PLANKS_RD161348 = copy("wooden_planks_rd161348", OAK_PLANKS, RD161348, C0_0_13A_03);
    Block WOODEN_PLANKS_C0_0_14A = copy("wooden_planks_c0_0_14a", OAK_PLANKS, C0_0_14A, C0_0_14A_08);
    Block WOODEN_PLANKS_C0_0_15A = copy("wooden_planks_c0_0_15a", OAK_PLANKS, C0_0_15A, B1_9PRE4);
    Block WOODEN_PLANKS_B1_9PRE5 = copy("wooden_planks_b1_9pre5", OAK_PLANKS, B1_9PRE5, _1_13_2);
    Block LOG_C0_0_14A = register("log_c0_0_14a", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN), C0_0_14A, _1_13_2);
    ExtendedLeavesBlock LEAVES_C0_0_14A = register("leaves_c0_0_14a", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)), C0_0_14A, C0_0_14A_08);
    ExtendedLeavesBlock LEAVES_C0_0_15A = register("leaves_c0_0_15a", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)), C0_0_15A, C0_0_23A);
    ExtendedLeavesBlock LEAVES_C0_24ST = register("leaves_c0_24st", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES)), C0_24ST, _1_13_2);
    FlowerBlock SAPLING_RD161348 = register("sapling_rd161348", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F,
            AbstractBlock.Settings.copy(OAK_SAPLING)), RD161348, C0_0_12A_03);
    Block POTTED_SAPLING_RD161348 = ModBlocks.registerWithoutItem("potted_sapling_rd161348", createFlowerPotBlock(SAPLING_RD161348));
    FlowerBlock SAPLING_C0_0_13A = register("sapling_c0_0_13a", new FlowerBlock(StatusEffects.BAD_OMEN, 4.0F, AbstractBlock.Settings.copy(OAK_SAPLING)), 
            C0_0_13A, C0_0_23A);
    Block POTTED_SAPLING_C0_0_13A = ModBlocks.registerWithoutItem("potted_sapling_c0_0_13a", createFlowerPotBlock(SAPLING_C0_0_13A));
    SaplingBlock SAPLING_C0_24ST = register("sapling_c0_24st", new SaplingBlock(ModSaplingGenerators.LEGACY_C0_24ST,
            AbstractBlock.Settings.copy(OAK_SAPLING)), C0_24ST, _1_13_2);
    Block POTTED_SAPLING_C0_24ST = ModBlocks.registerWithoutItem("potted_sapling_c0_24st", createFlowerPotBlock(SAPLING_C0_24ST));
    Block BEDROCK_C0_0_12A = copy("bedrock_c0_0_12a", BEDROCK, C0_0_12A, _1_13_2);
    FallingBlock SAND_C0_0_14A = register("sand_c0_0_14a", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(SAND)),
            C0_0_14A, C0_0_14A_08);
    FallingBlock SAND_C0_0_15A = register("sand_c0_0_15a", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(SAND)),
            C0_0_15A, B1_9PRE5);
    FallingBlock SAND_B1_9PRE6 = register("sand_b1_9pre6", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(SAND)),
            B1_9PRE6, _1_13_2);
    FallingBlock GRAVEL_C0_0_14A = register("gravel_c0_0_14a", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(GRAVEL)),
            C0_0_14A, C0_0_14A_08);
    FallingBlock GRAVEL_C0_0_15A = register("gravel_c0_0_15a", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(GRAVEL)),
            C0_0_15A, B1_9PRE4);
    FallingBlock GRAVEL_B1_9PRE5 = register("gravel_b1_9pre5", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(GRAVEL)),
            B1_9PRE5, _1_2_5);
    FallingBlock GRAVEL_1_3 = register("gravel_1_3", new ColoredFallingBlock(new ColorCode(14406560), AbstractBlock.Settings.copy(GRAVEL)),
            _1_3, _1_13_2);
    ExperienceDroppingBlock COAL_ORE_C0_0_14A = register("coal_ore_c0_0_14a",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(COAL_ORE)), C0_0_14A, _1_13_2);
    ExperienceDroppingBlock COAL_ORE_1_14 = register("coal_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(COAL_ORE)), _1_14, _1_16_5);
    Block IRON_ORE_C0_0_14A = copy("iron_ore_c0_0_14a", IRON_ORE, C0_0_14A, _1_13_2);
    Block IRON_ORE_1_14 = copy("iron_ore_1_14", IRON_ORE, _1_14);
    Block IRON_ORE_1_14_1 = copy("iron_ore_1_14_1", IRON_ORE, _1_14_1, _1_16_5);
    Block GOLD_ORE_C0_0_14A = copy("gold_ore_c0_0_14a", GOLD_ORE, C0_0_14A, C0_25_05ST);
    Block GOLD_ORE_C0_26ST = copy("gold_ore_c0_26st", GOLD_ORE, C0_26ST, _1_13_2);
    Block GOLD_ORE_1_14 = copy("gold_ore_1_14", GOLD_ORE, _1_14, _1_16_5);
    SpongeBlockClassic SPONGE_C0_0_19A = register("sponge_c0_0_19a", new SpongeBlockClassic(AbstractBlock.Settings.copy(SPONGE)), C0_0_19A, _1_7_10);
    SpongeBlock_1_8 SPONGE_1_8 = register("sponge_1_8", new SpongeBlock_1_8(AbstractBlock.Settings.copy(SPONGE)), _1_8, _1_13_2);
    WetSpongeBlock_1_8 WET_SPONGE_1_8 = register("wet_sponge_1_8", new WetSpongeBlock_1_8(AbstractBlock.Settings.copy(WET_SPONGE)), _1_8, _1_13_2);
    TransparentBlock GLASS_C0_0_19A = register("glass_c0_0_19a", new TransparentBlock(AbstractBlock.Settings.copy(GLASS)), C0_0_19A, _1_13_2);
    Block WHITE_CLOTH = copy("withe_cloth", WHITE_WOOL, C0_0_20A, B1_1_02);
    Block LIGHT_GRAY_CLOTH_C0_0_20A = copy("light_gray_cloth_c0_0_20a", LIGHT_GRAY_WOOL, C0_0_20A, B1_1_02);
    Block LIGHT_GRAY_CLOTH_C0_28A = copy("light_gray_cloth_c0_28a", LIGHT_GRAY_WOOL, C0_0_20A, B1_1_02);
    Block DARK_GRAY_CLOTH_C0_0_20A = copy("dark_gray_cloth_c0_0_20a", GRAY_WOOL, C0_0_20A, B1_1_02);
    Block DARK_GRAY_CLOTH_C0_28A = copy("dark_gray_cloth_c0_28a", GRAY_WOOL, C0_0_20A, B1_1_02);
    Block RED_CLOTH = copy("red_cloth", RED_WOOL, C0_0_20A, B1_1_02);
    Block ORANGE_CLOTH = copy("orange_cloth", ORANGE_WOOL, C0_0_20A, B1_1_02);
    Block YELLOW_CLOTH = copy("yellow_cloth", YELLOW_WOOL, C0_0_20A, B1_1_02);
    Block CHARTREUSE_CLOTH = copy("chartreuse_cloth", LIME_WOOL, C0_0_20A, B1_1_02);
    Block SPRING_GREEN_CLOTH = copy("spring_green_cloth", GREEN_WOOL, C0_0_20A, B1_1_02);
    Block CYAN_CLOTH = copy("cyan_cloth", CYAN_WOOL, C0_0_20A, B1_1_02);
    Block CAPRI_CLOTH = copy("capri_cloth", LIGHT_BLUE_WOOL, C0_0_20A, B1_1_02);
    Block ULTRAMARINE_CLOTH = copy("ultramarine_cloth", BLUE_WOOL, C0_0_20A, B1_1_02);
    Block VIOLET_CLOTH = copy("violet_cloth", PURPLE_WOOL, C0_0_20A, B1_1_02);
    Block PURPLE_CLOTH = copy("purple_cloth", PURPLE_WOOL, C0_0_20A, B1_1_02);
    Block MAGENTA_CLOTH = copy("magenta_cloth", MAGENTA_WOOL, C0_0_20A, B1_1_02);
    Block ROSE_CLOTH = copy("rose_cloth", PINK_WOOL, C0_0_20A, B1_1_02);
    Block GOLD_BLOCK_C0_0_20A = copy("gold_block_c0_0_20a", GOLD_BLOCK, C0_0_20A, B1_1_02);
    Block GOLD_BLOCK_C0_26ST = copy("gold_block_c0_26st", GOLD_BLOCK, C0_0_20A, B1_1_02);
    Block GOLD_BLOCK_A1_2_0 = copy("gold_block_a1_2_0", GOLD_BLOCK, C0_0_20A, B1_1_02);
    Block GOLD_BLOCK_B1_9PRE5 = copy("gold_block_b1_9pre5", GOLD_BLOCK, C0_0_20A, B1_1_02);
    FlowerBlock DANDELION_C0_0_20A = register("dandelion_c0_0_20a",
            new FlowerBlock(StatusEffects.SATURATION, 0.35F, AbstractBlock.Settings.copy(DANDELION)), C0_0_20A, _1_13_2);
    Block POTTED_DANDELIONS_C0_0_20A = ModBlocks.registerWithoutItem("potted_dandelion_c0_0_20a", createFlowerPotBlock(DANDELION_C0_0_20A));
    FlowerBlock ROSE_C0_0_20A = register("rose_c0_0_20a",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(POPPY)), C0_0_20A, _1_6_4);
    Block POTTED_ROSE_C0_0_20A = ModBlocks.registerWithoutItem("potted_rose_c0_0_20a", createFlowerPotBlock(ROSE_C0_0_20A));
    FlowerBlock POPPY_1_7 = register("poppy_1_7",
            new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.copy(POPPY)), _1_7, _1_13_2);
    Block POTTED_POPPY_1_7 = ModBlocks.registerWithoutItem("potted_poppy_1_7", createFlowerPotBlock(POPPY_1_7));
    MushroomPlantBlock BROWN_MUSHROOM_C0_0_20A = register("brown_mushroom_c0_0_20a",
            new MushroomPlantBlock(ModConfiguredFeatures.BROWN_MUSHROOM_C0_0_20A_KEY, AbstractBlock.Settings.copy(BROWN_MUSHROOM)),
            new Item.Settings().food(ModFoodComponents.BROWN_MUSHROOM_C0_0_20A_SETTINGS), C0_0_20A, _1_13_2);
    Block POTTED_BROWN_MUSHROOM_C0_0_20A = ModBlocks.registerWithoutItem("potted_brown_mushroom_c0_0_20a", createFlowerPotBlock(BROWN_MUSHROOM_C0_0_20A));
    MushroomPlantBlock RED_MUSHROOM_C0_0_20A = register("red_mushroom_c0_0_20a",
            new MushroomPlantBlock(ModConfiguredFeatures.RED_MUSHROOM_C0_0_20A_KEY, AbstractBlock.Settings.copy(RED_MUSHROOM)),
            new Item.Settings().food(ModFoodComponents.RED_MUSHROOM_C0_0_20A_SETTINGS), C0_0_20A, _1_13_2);
    Block POTTED_RED_MUSHROOM_C0_0_20A = ModBlocks.registerWithoutItem("potted_red_mushroom_c0_0_20a", createFlowerPotBlock(RED_MUSHROOM_C0_0_20A));
    SlabBlock STONE_SLAB_C0_26ST = register("stone_slab_c0_26st", new SlabBlock(AbstractBlock.Settings.copy(SMOOTH_STONE_SLAB)), C0_26ST, _1_13_2);
    Block IRON_BLOCK_C0_26ST = copy("iron_block_c0_26st", IRON_BLOCK, C0_26ST, A1_1_2_01);
    Block IRON_BLOCK_A1_2_0 = copy("iron_block_a1_2_0", IRON_BLOCK, A1_2_0, B1_9PRE4);
    Block IRON_BLOCK_B1_9PRE5 = copy("iron_block_b1_9pre5", IRON_BLOCK, B1_9PRE5, _1_13_2);
    TntBlock TNT_C0_26ST = register("tnt_c0_26st", new TntBlock(AbstractBlock.Settings.copy(TNT)), C0_26ST, C0_27ST);
    TntBlock TNT_C0_28A = register("tnt_c0_28a", new TntBlock(AbstractBlock.Settings.copy(TNT)), C0_28A, _1_13_2);
    Block MOSSY_COBBLESTONE_C0_26ST = copy("mossy_cobblestone_c0_26st", MOSSY_COBBLESTONE, C0_26ST, B1_7_3);
    Block MOSSY_COBBLESTONE_B1_8 = copy("mossy_cobblestone_b1_8", MOSSY_COBBLESTONE, B1_8, _1_13_2);
    Block BRICKS_C0_26ST = copy("bricks_c0_26st", BRICKS, C0_26ST, A1_0_10);
    Block BRICKS_A1_0_11 = copy("bricks_a1_0_11", BRICKS, A1_0_11, _1_13_2);
    Block BOOKSHELF_C0_26ST = copy("bookshelf_c0_26st", BOOKSHELF, C0_26ST, B1_9PRE4);
    Block BOOKSHELF_B1_9PRE5 = copy("bookshelf_b1_9pre5", BOOKSHELF, B1_9PRE5, _1_13_2);
    Block OBSIDIAN_C0_28A = copy("obsidian_c0_28a", OBSIDIAN, C0_28A, _1_13_2);
    ExperienceDroppingBlock DIAMOND_ORE_IN20100128 = register("diamond_ore_in20100128",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(DIAMOND_ORE)), IN20100128, _1_13_2);
    ExperienceDroppingBlock DIAMOND_ORE_1_14 = register("diamond_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(DIAMOND_ORE)), _1_14, _1_16_5);
    Block DIAMOND_BLOCK_IN20100128 = copy("diamond_block_in20100128", DIAMOND_BLOCK, IN20100128, A1_1_2_01);
    Block DIAMOND_BLOCK_A1_2_0 = copy("diamond_block_a1_2_0", DIAMOND_BLOCK, A1_2_0, B1_9PRE4);
    Block DIAMOND_BLOCK_B1_9PRE5 = copy("diamond_block_b1_9pre5", DIAMOND_BLOCK, B1_9PRE5, _1_13_2);
    Block CRAFTING_TABLE_IN20100131 = register("crafting_table_in20100131", new Block(AbstractBlock.Settings.copy(CRAFTING_TABLE)), IN20100131, _1_13_2);
    Block CRAFTING_TABLE_1_14 = copy("crafting_table_1_14", CRAFTING_TABLE, _1_14);
    Block FURNACE_IN20100219 = register("furnace_in20100219", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)), IN20100219, B1_1_02);
    Block LIT_FURNACE_IN20100219 = register("lit_furnace_in20100219", new Block(AbstractBlock.Settings.create().
            mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F).luminance((state) -> 13)),
            IN20100219, B1_1_02);
    Block FURNACE_B1_2  = copy("furnace_b1_2", FURNACE_IN20100219, B1_2, _1_13_2);
    Block LIT_FURNACE_B1_2 = copy("lit_furnace_b1_2", LIT_FURNACE_IN20100219, B1_2, _1_13_2);
    LadderBlock LADDER_INF20100607 = register("ladder_inf20100607", new LadderBlock(AbstractBlock.Settings.copy(LADDER)), INF20100607, INF20100617);
    LadderBlock LADDER_INF20100618 = register("ladder_inf20100618", new LadderBlock(AbstractBlock.Settings.copy(LADDER)), INF20100618, _1_13_2);
    DoorBlock WOODEN_DOOR_INF20100607 = register("wooden_door_inf20100607", new DoorBlock(ModBlockSetTypes.WOODEN_C0_0_15A, AbstractBlock.Settings.copy(OAK_DOOR)),
            INF20100607, _1_13_2);
    TerraformSignBlock SIGN_INF20100607 = register("sign_inf20100607", new TerraformSignBlock(Blocktopia.id("entity/signs/wooden_c0_0_15a"),
            ModWoodSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_SIGN)), INF20100607, _1_13_2);
    StairsBlock WOODEN_STAIRS_RD20090515 = registerFake("wooden_stairs_rd20090515", new StairsBlock(WOODEN_PLANKS_RD20090515.getDefaultState(),
            AbstractBlock.Settings.copy(OAK_STAIRS)), RD20090515, RD160052);
    StairsBlock WOODEN_STAIRS_RD161348 = registerFake("wooden_stairs_rd161348", new StairsBlock(WOODEN_PLANKS_RD161348.getDefaultState(),
            AbstractBlock.Settings.copy(OAK_STAIRS)), RD161348, C0_0_13A_03);
    StairsBlock WOODEN_STAIRS_C0_0_14A = registerFake("wooden_stairs_c0_0_14a", new StairsBlock(WOODEN_PLANKS_C0_0_14A.getDefaultState(),
            AbstractBlock.Settings.copy(OAK_STAIRS)), C0_0_14A, INF20100627);
    StairsBlock WOODEN_STAIRS_INF20100629 = register("wooden_stairs_inf20100629", new StairsBlock(WOODEN_PLANKS_C0_0_15A.getDefaultState(),
            AbstractBlock.Settings.copy(OAK_STAIRS)), INF20100629, B1_9PRE4);
    StairsBlock WOODEN_STAIRS_B1_9PRE5 = register("wooden_stairs_b1_9pre5", new StairsBlock(WOODEN_PLANKS_B1_9PRE5.getDefaultState(),
            AbstractBlock.Settings.copy(OAK_STAIRS)), B1_9PRE5, _1_13_2);
    StairsBlock COBBLESTONE_STAIRS_RD20090515 = registerFake("cobblestone_stairs_rd20090515", new StairsBlock(COBBLESTONE_RD20090515.getDefaultState(),
            AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)), RD20090515, INF20100627);
    StairsBlock COBBLESTONE_STAIRS_INF20100629 = register("cobblestone_stairs_inf20100629", new StairsBlock(COBBLESTONE_C_0_0_14A.getDefaultState(),
            AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)), INF20100629, B1_6_6);
    StairsBlock COBBLESTONE_STAIRS_B1_7 = register("cobblestone_stairs_b1_7", new StairsBlock(COBBLESTONE_B1_7.getDefaultState(),
            AbstractBlock.Settings.copy(COBBLESTONE_STAIRS)), B1_7, _1_13_2);
    WallTorchBlock WALL_TORCH_IN20100124_2 = ModBlocks.registerWithoutItem("wall_torch_in20100124_2", new WallTorchBlock(ParticleTypes.FLAME,
            AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14)
                    .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    TorchBlock TORCH_IN20100124_2 = ModBlocks.register("torch_in20100124_2", new TorchBlock(ParticleTypes.FLAME,
            AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14)
                    .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)), new Item.Settings(),
            (block, settings) -> new VerticallyAttachableBlockItem(block, WALL_TORCH_IN20100124_2, settings, Direction.DOWN) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                    tooltip.add(Text.literal(IN20100124_2.getName() + " - " + _1_13_2.getName()));
                }
            });
    RedstoneOreBlock REDSTONE_ORE_A1_0_1 = register("redstone_ore_a1_0_1", new RedstoneOreBlock(
            AbstractBlock.Settings.copy(REDSTONE_ORE)), A1_0_1, _1_13_2);
    RedstoneOreBlock REDSTONE_ORE_1_14 = register("redstone_ore_1_14", new RedstoneOreBlock(
            AbstractBlock.Settings.copy(REDSTONE_ORE)), _1_14, _1_16_5);
    WallRedstoneTorchBlock REDSTONE_WALL_TORCH_A1_0_1 = ModBlocks.registerWithoutItem("redstone_wall_torch_a1_0_1", new WallRedstoneTorchBlock(
            AbstractBlock.Settings.copy(REDSTONE_WALL_TORCH)));
    RedstoneTorchBlock REDSTONE_TORCH_A1_0_1 = ModBlocks.register("redstone_torch_a1_0_1", new RedstoneTorchBlock(
            AbstractBlock.Settings.copy(REDSTONE_TORCH)), new Item.Settings(),
            (block, settings) -> new VerticallyAttachableBlockItem(block, REDSTONE_WALL_TORCH_A1_0_1, settings, Direction.DOWN) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                    tooltip.add(Text.literal(A1_0_1.getName() + " - " + _1_13_2.getName()));
                }
            });
    SnowBlock SNOW_A1_0_4 = register("snow_a1_0_4", new SnowBlock(AbstractBlock.Settings.copy(SNOW)), A1_0_4, _1_13_2);
    Block ICE_A1_0_4 = copy("ice_a1_0_4", ICE, A1_0_4, _1_13_2);
    Block SNOW_BLOCK_A1_0_5 = copy("snow_block_a1_0_5", SNOW_BLOCK, A1_0_5, _1_13_2);
    Block CLAY_BLOCK_A1_0_11 = copy("clay_block_a1_0_11", CLAY, A1_0_11, _1_13_2);
    FenceBlock WOODEN_FENCE_RD20090515 = registerFake("wooden_fence_rd20090515", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), RD20090515, RD160052);
    FenceBlock WOODEN_FENCE_RD161348 = registerFake("wooden_fence_rd161348", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), RD161348, C0_0_13A_03);
    FenceBlock WOODEN_FENCE_C0_0_14A = registerFake("wooden_fence_c0_0_14a", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), C0_0_14A, A1_0_16);
    FenceBlock WOODEN_FENCE_A1_0_17 = register("wooden_fence_a1_0_17", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), A1_0_17, B1_9PRE4);
    FenceBlock WOODEN_FENCE_B1_9PRE5 = register("wooden_fence_b1_9pre5", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), B1_9PRE5, _1_13_2);
    Block NETHERRACK_A1_2_0 = copy("netherrack_a1_2_0", NETHERRACK, A1_2_0, B1_9PRE4);
    Block NETHERRACK_B1_9PRE5 = copy("netherrack_b1_9pre5", NETHERRACK, B1_9PRE5, _1_13_2);
    SoulSandBlock SOUL_SAND_A1_2_0 = register("soul_sand_a1_2_0", new SoulSandBlock(AbstractBlock.Settings.copy(SOUL_SAND)), A1_2_0, _1_13_2);
    Block GLOWSTONE_A1_2_0 = copy("glowstone_a1_2_0", GLOWSTONE, A1_2_0, B1_9PRE4);
    Block GLOWSTONE_B1_9PRE5 = copy("glowstone_b1_9pre5", GLOWSTONE, B1_9PRE5, _1_13_2);
    CarvedPumpkinBlock CARVED_PUMPKIN_A1_2_0 = register("carved_pumpkin_a1_2_0", new CarvedPumpkinBlock(AbstractBlock.Settings.copy(CARVED_PUMPKIN)), A1_2_0, _1_13_2);
    CarvedPumpkinBlock JACK_O_LANTERN_A1_2_0 = register("jack_o_lantern_a1_2_0", new CarvedPumpkinBlock(AbstractBlock.Settings.copy(JACK_O_LANTERN)), A1_2_0, _1_13_2);

    /*Block LIGHT_GRAY_WOOL_B1_2 = copy("light_gray_wool_b1_2", LIGHT_GRAY_WOOL, B1_2, _1_2_3);
    Block GRAY_WOOL_B1_2 = copy("gray_wool_b1_2", GRAY_WOOL, B1_2, _1_2_3);
    Block BLACK_WOOL_B1_2 = copy("black_wool_b1_2", BLACK_WOOL, B1_2, _1_2_3);
    Block BROWN_WOOL_B1_2 = copy("brown_wool_b1_2", BROWN_WOOL, B1_2, _1_2_3);
    Block RED_WOOL_B1_2 = copy("red_wool_b1_2", RED_WOOL, B1_2, _1_2_3);
    Block ORANGE_WOOL_B1_2 = copy("orange_wool_b1_2", ORANGE_WOOL, B1_2, _1_2_3);
    Block YELLOW_WOOL_B1_2 = copy("yellow_wool_b1_2", YELLOW_WOOL, B1_2, _1_2_3);
    Block LIME_WOOL_B1_2 = copy("lime_wool_b1_2", LIME_WOOL, B1_2, _1_2_3);
    Block GREEN_WOOL_B1_2 = copy("green_wool_b1_2", GREEN_WOOL, B1_2, _1_2_3);
    Block CYAN_WOOL_B1_2 = copy("cyan_wool_b1_2", CYAN_WOOL, B1_2, _1_2_3);
    Block LIGHT_BLUE_WOOL_B1_2 = copy("light_blue_wool_b1_2", LIGHT_BLUE_WOOL, B1_2, _1_2_3);
    Block BLUE_WOOL_B1_2 = copy("blue_wool_b1_2", BLUE_WOOL, B1_2, _1_2_3);
    Block PURPLE_WOOL_B1_2 = copy("purple_wool_b1_2", PURPLE_WOOL, B1_2, _1_2_3);
    Block MAGENTA_WOOL_B1_2 = copy("magenta_wool_b1_2", MAGENTA_WOOL, B1_2, _1_2_3);
    Block PINK_WOOL_B1_2 = copy("pink_wool_b1_2", PINK_WOOL, B1_2, _1_2_3);
    Block LIGHT_GRAY_WOOL_1_2_4 = copy("light_gray_wool_1_2_4", LIGHT_GRAY_WOOL, _1_2_3, _1_11_2);
    Block GRAY_WOOL_1_2_4 = copy("gray_wool_1_2_4", GRAY_WOOL, _1_2_3, _1_11_2);
    Block BLACK_WOOL_1_2_4 = copy("black_wool_1_2_4", BLACK_WOOL, _1_2_3, _1_11_2);
    Block BROWN_WOOL_1_2_4 = copy("brown_wool_1_2_4", BROWN_WOOL, _1_2_3, _1_11_2);
    Block RED_WOOL_1_2_4 = copy("red_wool_1_2_4", RED_WOOL, _1_2_3, _1_11_2);
    Block ORANGE_WOOL_1_2_4 = copy("orange_wool_1_2_4", ORANGE_WOOL, _1_2_3, _1_11_2);
    Block YELLOW_WOOL_1_2_4 = copy("yellow_wool_1_2_4", YELLOW_WOOL, _1_2_3, _1_11_2);
    Block LIME_WOOL_1_2_4 = copy("lime_wool_1_2_4", LIME_WOOL, _1_2_3, _1_11_2);
    Block GREEN_WOOL_1_2_4 = copy("green_wool_1_2_4", GREEN_WOOL, _1_2_3, _1_11_2);
    Block CYAN_WOOL_1_2_4 = copy("cyan_wool_1_2_4", CYAN_WOOL, _1_2_3, _1_11_2);
    Block LIGHT_BLUE_WOOL_1_2_4 = copy("light_blue_wool_1_2_4", LIGHT_BLUE_WOOL, _1_2_3, _1_11_2);
    Block BLUE_WOOL_1_2_4 = copy("blue_wool_1_2_4", BLUE_WOOL, _1_2_3, _1_11_2);
    Block PURPLE_WOOL_1_2_4 = copy("purple_wool_1_2_4", PURPLE_WOOL, _1_2_3, _1_11_2);
    Block MAGENTA_WOOL_1_2_4 = copy("magenta_wool_1_2_4", MAGENTA_WOOL, _1_2_3, _1_11_2);
    Block PINK_WOOL_1_2_4 = copy("pink_wool_1_2_4", PINK_WOOL, _1_2_3, _1_11_2);
    CakeBlock CAKE_B1_2 = register("cake_b1_2", new CakeBlock(AbstractBlock.Settings.copy(CAKE)), B1_2, _1_13_2);
    ExperienceDroppingBlock LAPIS_ORE_B1_2 = register("lapis_ore_b1_2",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(LAPIS_ORE)), B1_2, _1_13_2);
    ExperienceDroppingBlock LAPIS_ORE_1_14 = register("lapis_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(LAPIS_ORE)), _1_14, _1_16_5);
    Block LAPIS_BLOCK_B1_2 = copy("lapis_block_b1_2", LAPIS_BLOCK, B1_2, _1_5_2);
    Block LAPIS_BLOCK_1_6 = copy("lapis_block_1_6", LAPIS_BLOCK, _1_6, _1_13_2);
    NoteBlock NOTE_BLOCK_B1_2 = register("note_block_b1_2", new NoteBlock(AbstractBlock.Settings.copy(NOTE_BLOCK)), B1_2, _1_13_2);
    Block SANDSTONE_B1_2 = copy("sandstone_b1_2", SANDSTONE, B1_2, _1_2_3);
    Block SANDSTONE_1_2_4 = copy("sandstone_1_2_4", SANDSTONE, _1_2_4, _1_13_2);
    Block BIRCH_LOG_B1_2 = register("brich_log_b1_2", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE), B1_2, _1_6_4);
    Block BIRCH_LOG_1_7 = register("birch_log_1_7", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE), _1_7, _1_13_2);
    ExtendedLeavesBlock BIRCH_LEAVES_B1_2 = register("birch_leaves_b1_2", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(BIRCH_LEAVES)), B1_2, _1_13_2);
    Block SPRUCE_LOG_B1_2 = register("spuce_log_b1_2", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN), B1_2, _1_6_4);
    Block SPRUCE_LOG_1_7 = register("spruce_log_1_7", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN), _1_7, _1_13_2);
    ExtendedLeavesBlock SPRUCE_LEAVES_B1_2 = register("spruce_leaves_b1_2", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(SPRUCE_LEAVES)), B1_2, _1_13_2);
    SlabBlock COBBLESTONE_SLAB_RD20090515 = registerFake("cobblestone_slab_rd20090515", new SlabBlock(AbstractBlock.Settings.copy(COBBLESTONE_SLAB)), RD20090515, B1_2_02);
    SlabBlock COBBLESTONE_SLAB_B1_3 = register("cobblestone_slab_b1_3", new SlabBlock(AbstractBlock.Settings.copy(COBBLESTONE_SLAB)), B1_3, B1_6_6);
    SlabBlock COBBLESTONE_SLAB_B1_7 = register("cobblestone_slab_b1_7", new SlabBlock(AbstractBlock.Settings.copy(COBBLESTONE_SLAB)), B1_7, _1_13_2);
    SlabBlock WOODEN_SLAB_RD20090515 = registerFake("wooden_slab_rd20090515", new SlabBlock(AbstractBlock.Settings.copy(PETRIFIED_OAK_SLAB)), RD20090515, RD160052);
    SlabBlock WOODEN_SLAB_RD161348 = registerFake("wooden_slab_rd161348", new SlabBlock(AbstractBlock.Settings.copy(PETRIFIED_OAK_SLAB)), RD161348, C0_0_13A_03);
    SlabBlock WOODEN_SLAB_C0_0_14A = registerFake("wooden_slab_c0_0_14a", new SlabBlock(AbstractBlock.Settings.copy(PETRIFIED_OAK_SLAB)), C0_0_14A, B1_2_02);
    SlabBlock WOODEN_SLAB_B1_3 = register("wooden_slab_b1_3", new SlabBlock(AbstractBlock.Settings.copy(PETRIFIED_OAK_SLAB)), B1_3, B1_9PRE4);
    SlabBlock WOODEN_SLAB_B1_9PRE5 = register("wooden_slab_b1_9pre5", new SlabBlock(AbstractBlock.Settings.copy(PETRIFIED_OAK_SLAB)), B1_9PRE5, _1_13_2);
    SlabBlock SANDSTONE_SLAB_B1_3 = register("sandstone_slab_b1_3", new SlabBlock(AbstractBlock.Settings.copy(SANDSTONE_SLAB)), B1_3, _1_2_3);
    SlabBlock SANDSTONE_SLAB_1_2_4 = register("sandstone_slab_1_2_4", new SlabBlock(AbstractBlock.Settings.copy(SANDSTONE_SLAB)), _1_2_4, _1_13_2);
    Block SMOOTH_STONE_B1_3 = copy("smooth_stone_b1_3", SMOOTH_STONE, B1_3, _1_13_2);
    SaplingBlock BIRCH_SAPLING_B1_5 = register("birch_sapling_b1_5", new SaplingBlock(ModSaplingGenerators.BIRCH_B1_5, AbstractBlock.Settings.copy(BIRCH_SAPLING)),
            B1_5, _1_13_2);
    SaplingBlock SPRUCE_SAPLING_B1_5 = register("spruce_sapling_b1_5", new SaplingBlock(ModSaplingGenerators.SPRUCE_B1_5, AbstractBlock.Settings.copy(SPRUCE_SAPLING)),
            B1_5, _1_13_2);
    RailBlock RAIL_INF20100618 = register("rail_inf20100618", new RailBlock(AbstractBlock.Settings.copy(RAIL)), INF20100618,_1_13_2);
    PoweredRailBlock POWERED_RAIL_B1_5 = register("powered_rail_b1_5", new PoweredRailBlock(AbstractBlock.Settings.copy(POWERED_RAIL)), B1_5, _1_13_2);
    DetectorRailBlock DETECTOR_RAIL_B1_5 = register("detector_rail_b1_5", new DetectorRailBlock(AbstractBlock.Settings.copy(DETECTOR_RAIL)), B1_5, _1_13_2);
    CobwebBlock COBWEB_B1_5 = register("cobweb_b1_5", new CobwebBlock(AbstractBlock.Settings.copy(COBWEB)), B1_6, _1_13_2);
    DeadBushBlock DEAD_BUSH_B1_6 = register("dead_bush_b1_6", new DeadBushBlock(AbstractBlock.Settings.copy(DEAD_BUSH)), B1_6, _1_13_2);
    FlowerBlock SHRUB_B1_6 = register("shrub_b1_6", new FlowerBlock(ModStatusEffects.XP_REMOVER, 4, AbstractBlock.Settings.copy(DEAD_BUSH)),
            B1_6, _1_12_2);
    ShortPlantBlock SHORT_GRASS_B1_6 = register("short_grass_b1_6", new ShortPlantBlock(AbstractBlock.Settings.copy(SHORT_GRASS)), B1_6, _1_13_2);
    ShortPlantBlock FERN_B1_6 = register("fern_b1_6", new ShortPlantBlock(AbstractBlock.Settings.copy(FERN)), B1_6, _1_13_2);
    TrapdoorBlock TRAPDOOR_B1_6 = register("trapdoor_b1_6", new TrapdoorBlock(ModBlockSetTypes.WOODEN_C0_0_15A, AbstractBlock.Settings.copy(OAK_TRAPDOOR)),
            B1_6, _1_13_2);
    //Block STONE_BRICKS_B1_8 = copy("stone_bricks_b1_8", STONE_BRICKS);
    //Block CRACKED_STONE_BRICKS_B1_8 = copy("cracked_stone_bricks_b1_8", CRACKED_STONE_BRICKS);
    //Block MOSSY_STONE_BRICKS_B1_8 = copy("mossy_stone_bricks_b1_8", MOSSY_STONE_BRICKS);
    //SlabBlock BRICK_SLAB_C0_26ST = register("brick_slab_c0_26st", new SlabBlock(AbstractBlock.Settings.copy(BRICK_SLAB)));
    //SlabBlock BRICK_SLAB_A1_0_11 = register("brick_slab_a1_0_11", new SlabBlock(AbstractBlock.Settings.copy(BRICK_SLAB)));*/


    private static Block copy(String name, Block copy, MinecraftVersions only) {
        return register(name, new Block(AbstractBlock.Settings.copy(copy)), only);
    }

    private static Block copy(String name, Block copy, MinecraftVersions from, MinecraftVersions to) {
        return register(name, new Block(AbstractBlock.Settings.copy(copy)), from, to);
    }

    private static <T extends Block> T register(String name, T block, MinecraftVersions only) {
        return register(name, block, new Item.Settings(), only);
    }


    private static <T extends Block> T register(String name, T block, Item.Settings settings, MinecraftVersions only) {
        return ModBlocks.register(name, block, settings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                tooltip.add(Text.literal(only.getName()));
            }
        });
    }

    private static <T extends Block> T register(String name, T block, Item.Settings settings, MinecraftVersions from, MinecraftVersions to) {
        return ModBlocks.register(name, block, settings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                tooltip.add(Text.literal(from.getName() + " - " + to.getName()));
            }
        });
    }

    private static <T extends Block> T registerFake(String name, T block, MinecraftVersions from, MinecraftVersions to) {
        return ModBlocks.register(name, block, new Item.Settings(), (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.fake_legacy"));
                tooltip.add(Text.literal("§4" + from.getName() + " - " + to.getName()));
            }
        });
    }

    private static <T extends Block> T register(String name, T block, MinecraftVersions from, MinecraftVersions to) {
        return register(name, block, new Item.Settings(), from, to);
    }

    static void load() {}
}
