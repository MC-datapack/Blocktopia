package github.mcdatapack.blocktopia.block;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.*;
import github.mcdatapack.blocktopia.statuseffect.ModStatusEffects;
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
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;
import static github.mcdatapack.blocktopia.block.ModBlocks.createWoodBlock;
import static net.minecraft.block.Blocks.*;

public interface LegacyBlocks {
    Block COBBLESTONE_RD20090515 = copy("cobblestone_rd20090515", COBBLESTONE, RD20090515, C0_0_13A_03);
    Block COBBLESTONE_C0_0_14A = copy("cobblestone_c0_0_14a", COBBLESTONE, C0_0_14A, B1_6_6);
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
    Block WHITE_CLOTH = copy("withe_cloth", WHITE_WOOL, C0_0_20A, _1_11_2);
    Block LIGHT_GRAY_CLOTH_C0_0_20A = copy("light_gray_cloth_c0_0_20a", LIGHT_GRAY_WOOL, C0_0_20A, C0_27ST);
    Block LIGHT_GRAY_CLOTH_C0_28A = copy("light_gray_cloth_c0_28a", LIGHT_GRAY_WOOL, C0_28A, B1_1_02);
    Block DARK_GRAY_CLOTH_C0_0_20A = copy("dark_gray_cloth_c0_0_20a", GRAY_WOOL, C0_0_20A, C0_27ST);
    Block DARK_GRAY_CLOTH_C0_28A = copy("dark_gray_cloth_c0_28a", GRAY_WOOL, C0_28A, B1_1_02);
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
            new MushroomPlantBlock(ModConfiguredFeatures.HUGE_BROWN_MUSHROOM_B1_8_KEY, AbstractBlock.Settings.copy(BROWN_MUSHROOM)),
            new Item.Settings().food(ModFoodComponents.BROWN_MUSHROOM_C0_0_20A_SETTINGS), C0_0_20A, _1_13_2);
    Block POTTED_BROWN_MUSHROOM_C0_0_20A = ModBlocks.registerWithoutItem("potted_brown_mushroom_c0_0_20a", createFlowerPotBlock(BROWN_MUSHROOM_C0_0_20A));
    MushroomPlantBlock RED_MUSHROOM_C0_0_20A = register("red_mushroom_c0_0_20a",
            new MushroomPlantBlock(ModConfiguredFeatures.HUGE_RED_MUSHROOM_B1_8_KEY, AbstractBlock.Settings.copy(RED_MUSHROOM)),
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
    Block FURNACE_B1_2  = copy("furnace_b1_2", FURNACE_IN20100219, B1_2, _1_13_2);
    LadderBlock LADDER_INF20100607 = register("ladder_inf20100607", new LadderBlock(AbstractBlock.Settings.copy(LADDER)), INF20100607, INF20100617);
    LadderBlock LADDER_INF20100618 = register("ladder_inf20100618", new LadderBlock(AbstractBlock.Settings.copy(LADDER)), INF20100618, _1_13_2);
    DoorBlock WOODEN_DOOR_INF20100607 = register("wooden_door_inf20100607", new DoorBlock(ModBlockSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_DOOR)),
            INF20100607, _1_13_2);
    TerraformWallSignBlock WALL_SIGN_INF20100607 = ModBlocks.registerWithoutItem("wall_sign_inf20100607", new TerraformWallSignBlock(Blocktopia.id("entity/signs/wooden_c0_0_15a"),
            ModWoodSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_SIGN)));
    TerraformSignBlock SIGN_INF20100607 = ModBlocks.register("sign_inf20100607", new TerraformSignBlock(Blocktopia.id("entity/signs/wooden_c0_0_15a"),
            ModWoodSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_SIGN)), new Item.Settings(),
            (block, settings) -> new SignItem(settings, block, WALL_SIGN_INF20100607) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, INF20100607, _1_13_2);
                }
            });
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
    StairsBlock COBBLESTONE_STAIRS_INF20100629 = register("cobblestone_stairs_inf20100629", new StairsBlock(COBBLESTONE_C0_0_14A.getDefaultState(),
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
                    addLegacyTooltip(tooltip, IN20100124_2, _1_13_2);
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
                    addLegacyTooltip(tooltip, A1_0_1, _1_13_2);
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

    Block LIGHT_GRAY_WOOL_B1_2 = copy("light_gray_wool_b1_2", LIGHT_GRAY_WOOL, B1_2, _1_2_3);
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
    Block LIGHT_GRAY_WOOL_1_2_4 = copy("light_gray_wool_1_2_4", LIGHT_GRAY_WOOL, _1_2_4, _1_11_2);
    Block GRAY_WOOL_1_2_4 = copy("gray_wool_1_2_4", GRAY_WOOL, _1_2_4, _1_11_2);
    Block BLACK_WOOL_1_2_4 = copy("black_wool_1_2_4", BLACK_WOOL, _1_2_4, _1_11_2);
    Block BROWN_WOOL_1_2_4 = copy("brown_wool_1_2_4", BROWN_WOOL, _1_2_4, _1_11_2);
    Block RED_WOOL_1_2_4 = copy("red_wool_1_2_4", RED_WOOL, _1_2_4, _1_11_2);
    Block ORANGE_WOOL_1_2_4 = copy("orange_wool_1_2_4", ORANGE_WOOL, _1_2_4, _1_11_2);
    Block YELLOW_WOOL_1_2_4 = copy("yellow_wool_1_2_4", YELLOW_WOOL, _1_2_4, _1_11_2);
    Block LIME_WOOL_1_2_4 = copy("lime_wool_1_2_4", LIME_WOOL, _1_2_4, _1_11_2);
    Block GREEN_WOOL_1_2_4 = copy("green_wool_1_2_4", GREEN_WOOL, _1_2_4, _1_11_2);
    Block CYAN_WOOL_1_2_4 = copy("cyan_wool_1_2_4", CYAN_WOOL, _1_2_4, _1_11_2);
    Block LIGHT_BLUE_WOOL_1_2_4 = copy("light_blue_wool_1_2_4", LIGHT_BLUE_WOOL, _1_2_4, _1_11_2);
    Block BLUE_WOOL_1_2_4 = copy("blue_wool_1_2_4", BLUE_WOOL, _1_2_4, _1_11_2);
    Block PURPLE_WOOL_1_2_4 = copy("purple_wool_1_2_4", PURPLE_WOOL, _1_2_4, _1_11_2);
    Block MAGENTA_WOOL_1_2_4 = copy("magenta_wool_1_2_4", MAGENTA_WOOL, _1_2_4, _1_11_2);
    Block PINK_WOOL_1_2_4 = copy("pink_wool_1_2_4", PINK_WOOL, _1_2_4, _1_11_2);
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
    Block BIRCH_LOG_B1_2 = register("birch_log_b1_2", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE), B1_2, _1_6_4);
    Block BIRCH_LOG_1_7 = register("birch_log_1_7", createLogBlock(MapColor.PALE_YELLOW, MapColor.OFF_WHITE), _1_7, _1_13_2);
    ExtendedLeavesBlock BIRCH_LEAVES_B1_2 = register("birch_leaves_b1_2", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(BIRCH_LEAVES)), B1_2, _1_13_2);
    Block SPRUCE_LOG_B1_2 = register("spruce_log_b1_2", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN), B1_2, _1_6_4);
    Block SPRUCE_LOG_1_7 = register("spruce_log_1_7", createLogBlock(MapColor.SPRUCE_BROWN, MapColor.BROWN), _1_7, _1_13_2);
    ExtendedLeavesBlock SPRUCE_LEAVES_B1_2 = register("spruce_leaves_b1_2", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(SPRUCE_LEAVES)), B1_2, _1_13_2);
    CryingObsidianBlock CRYING_OBSIDIAN_B1_3 = register("crying_obsidian_b1_3", new CryingObsidianBlock(AbstractBlock.Settings.copy(CRYING_OBSIDIAN)), B1_3, _1_15_2);
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
    TrapdoorBlock TRAPDOOR_B1_6 = register("trapdoor_b1_6", new TrapdoorBlock(ModBlockSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_TRAPDOOR)),
            B1_6, _1_13_2);
    Block STONE_BRICKS_B1_8 = copy("stone_bricks_b1_8", STONE_BRICKS, B1_8, _1_13_2);
    Block CRACKED_STONE_BRICKS_B1_8 = copy("cracked_stone_bricks_b1_8", CRACKED_STONE_BRICKS, B1_8, _1_13_2);
    Block MOSSY_STONE_BRICKS_B1_8 = copy("mossy_stone_bricks_b1_8", MOSSY_STONE_BRICKS, B1_8, _1_13_2);
    InfestedBlock INFESTED_COBBLESTONE_RD20090515 = registerFake("infested_cobblestone_rd20090515",
            new InfestedBlock(COBBLESTONE_RD20090515, AbstractBlock.Settings.copy(INFESTED_COBBLESTONE)), RD20090515, C0_0_13A_03);
    InfestedBlock INFESTED_COBBLESTONE_C0_0_14A = registerFake("infested_cobblestone_c0_0_14a",
            new InfestedBlock(COBBLESTONE_C0_0_14A, AbstractBlock.Settings.copy(INFESTED_COBBLESTONE)), C0_0_14A, B1_7_3);
    InfestedBlock INFESTED_COBBLESTONE_B1_8 = register("infested_cobblestone_b1_8",
            new InfestedBlock(COBBLESTONE_B1_7, AbstractBlock.Settings.copy(INFESTED_COBBLESTONE)), B1_8, _1_13_2);
    InfestedBlock INFESTED_STONE_BRICKS_B1_8 = register("infested_stone_bricks_b1_8",
            new InfestedBlock(STONE_BRICKS_B1_8, AbstractBlock.Settings.copy(INFESTED_COBBLESTONE)), B1_8, _1_13_2);
    SlabBlock BRICK_SLAB_C0_26ST = registerFake("brick_slab_c0_26st", new SlabBlock(AbstractBlock.Settings.copy(BRICK_SLAB)), C0_26ST, B1_7_3);
    SlabBlock BRICK_SLAB_B1_8 = register("brick_slab_b1_8", new SlabBlock(AbstractBlock.Settings.copy(BRICK_SLAB)), B1_8, _1_13_2);
    SlabBlock STONE_BRICK_SLAB_B1_8 = register("stone_brick_slab_b1_8", new SlabBlock(AbstractBlock.Settings.copy(STONE_BRICKS_B1_8)), B1_8, _1_13_2);
    StairsBlock BRICK_STAIRS_C0_26ST = registerFake("brick_stairs_c0_26st", new StairsBlock(BRICKS_C0_26ST.getDefaultState(),
            AbstractBlock.Settings.copy(BRICK_STAIRS)), C0_26ST, B1_7_3);
    StairsBlock BRICK_STAIRS_B1_8 = register("brick_stairs_b1_8", new StairsBlock(BRICKS_A1_0_11.getDefaultState(),
            AbstractBlock.Settings.copy(BRICK_STAIRS)), B1_8, _1_13_2);
    StairsBlock STONE_BRICK_STAIRS_B1_8 = register("stone_brick_stairs_b1_8", new StairsBlock(STONE_BRICKS_B1_8.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_BRICK_STAIRS)), B1_8, _1_13_2);
    PaneBlock GLASS_PANE_B1_8 = register("glass_pane_b1_8", new PaneBlock(AbstractBlock.Settings.copy(GLASS_PANE)), B1_8, _1_13_2);
    FenceGateBlock WOODEN_FENCE_GATE_RD20090515 = registerFake("wooden_fence_gate_rd20090515",
            new FenceGateBlock(ModWoodSetTypes.WOOD_RD20090515, AbstractBlock.Settings.copy(OAK_FENCE_GATE)), RD20090515, RD160052);
    FenceGateBlock WOODEN_FENCE_GATE_RD161348 = registerFake("wooden_fence_gate_rd161348",
            new FenceGateBlock(ModWoodSetTypes.WOOD_RD161348, AbstractBlock.Settings.copy(OAK_FENCE_GATE)), RD161348, C0_0_13A_03);
    FenceGateBlock WOODEN_FENCE_GATE_C0_0_14A = registerFake("wooden_fence_gate_c0_0_14a",
            new FenceGateBlock(ModWoodSetTypes.WOOD_C0_0_14A, AbstractBlock.Settings.copy(OAK_FENCE_GATE)), C0_0_14A, B1_7_3);
    FenceGateBlock WOODEN_FENCE_GATE_B1_8 = register("wooden_fence_gate_b1_8",
            new FenceGateBlock(ModWoodSetTypes.WOOD_C0_0_15A, AbstractBlock.Settings.copy(OAK_FENCE_GATE)), B1_8, B1_9PRE4);
    FenceGateBlock WOODEN_FENCE_GATE_B1_9PRE5 = register("wooden_fence_gate_b1_9pre5",
            new FenceGateBlock(ModWoodSetTypes.WOOD_B1_9PRE5, AbstractBlock.Settings.copy(OAK_FENCE_GATE)), B1_9PRE5, _1_13_2);
    VineBlock VINES_B1_8 = register("vines_b1_8", new VineBlock(AbstractBlock.Settings.copy(VINE)), B1_8, _1_13_2);
    MushroomBlock MUSHROOM_STEM_B1_8 = register("mushroom_stem_b1_8", new MushroomBlock(AbstractBlock.Settings.copy(MUSHROOM_STEM)), B1_8, _1_13_2);
    MushroomBlock RED_MUSHROOM_BLOCK_B1_8 = register("red_mushroom_block_b1_8", new MushroomBlock(AbstractBlock.Settings.copy(RED_MUSHROOM_BLOCK)), B1_8, _1_13_2);
    MushroomBlock BROWN_MUSHROOM_BLOCK_B1_8 = register("brown_mushroom_block_b1_8", new MushroomBlock(AbstractBlock.Settings.copy(BROWN_MUSHROOM_BLOCK)), B1_8, _1_13_2);
    Block MELON_BLOCK_B1_8 = copy("melon_block_b1_8", MELON, B1_8, _1_13_2);
    Block NETHER_BRICKS_B1_9PRE = copy("nether_bricks_b1_9pre", NETHER_BRICKS, B1_9PRE, _1_13_2);
    StairsBlock NETHER_BRICK_STAIRS_B1_9PRE = register("nether_brick_stairs_b1_9pre",
            new StairsBlock(NETHER_BRICKS_B1_9PRE.getDefaultState(), AbstractBlock.Settings.copy(NETHER_BRICK_STAIRS)), B1_9PRE, _1_13_2);
    FenceBlock NETHER_BRICK_FENCE_B1_9PRE = register("nether_brick_fence_b1_9pre",
            new FenceBlock(AbstractBlock.Settings.copy(NETHER_BRICK_FENCE)), B1_9PRE, _1_13_2);
    LilyPadBlock LILY_PAD_B1_9PRE = ModBlocks.register("lily_pad_b1_9pre", new LilyPadBlock(AbstractBlock.Settings.copy(LILY_PAD)),
            new Item.Settings(), (block, settings) -> new PlaceableOnWaterItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, B1_9PRE, _1_13_2);
                }
            });
    Block ENDSTONE_B1_9PRE4 = copy("endstone_b1_9pre4", END_STONE,B1_9PRE4, _1_13_2);
    Block JUNGLE_LOG_1_2 = register("jungle_log_1_2", createLogBlock(MapColor.DIRT_BROWN, MapColor.SPRUCE_BROWN), _1_2, _1_6_4);
    Block JUNGLE_LOG_1_7 = register("jungle_log_1_7", createLogBlock(MapColor.DIRT_BROWN, MapColor.SPRUCE_BROWN), _1_7, _1_13_2);
    ExtendedLeavesBlock JUNGLE_LEAVES_1_2 = register("jungle_leaves_1_2", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(JUNGLE_LEAVES)), _1_2, _1_13_2);
    SaplingBlock JUNGLE_SAPLING_1_2 = register("jungle_sapling_1_2", new SaplingBlock(ModSaplingGenerators.JUNGLE_1_2, AbstractBlock.Settings.copy(JUNGLE_LEAVES)),
            _1_2, _1_13_2);
    RedstoneLampBlock REDSTONE_LAMP_1_2 = register("redstone_lamp_1_2", new RedstoneLampBlock(AbstractBlock.Settings.copy(REDSTONE_LAMP)), _1_2,_1_13_2);
    Block CHISELED_STONE_BRICKS_1_2 = copy("chiseled_stone_bricks_1_2", CHISELED_STONE_BRICKS, _1_2, _1_13_2);
    Block BIRCH_PLANKS_1_2_4 = copy("birch_planks_1_2_4", BIRCH_PLANKS, _1_2_4, _1_13_2);
    Block SPRUCE_PLANKS_1_2_4 = copy("spruce_planks_1_2_4", SPRUCE_PLANKS, _1_2_4, _1_13_2);
    Block JUNGLE_PLANKS_1_2_4 = copy("jungle_planks_1_2_4", JUNGLE_PLANKS, _1_2_4, _1_13_2);
    Block CUT_SANDSTONE_1_2_4 = copy("cut_sandstone_1_2_4", CUT_SANDSTONE, _1_2_4, _1_13_2);
    Block CHISELED_SANDSTONE_1_2_4 = copy("chiseled_sandstone_1_2_4", CHISELED_SANDSTONE, _1_2_4, _1_13_2);
    SlabBlock BIRCH_SLAB_1_3 = register("birch_slab_1_3", new SlabBlock(AbstractBlock.Settings.copy(BIRCH_SLAB)), _1_3, _1_13_2);
    SlabBlock SPRUCE_SLAB_1_3 = register("spruce_slab_1_3", new SlabBlock(AbstractBlock.Settings.copy(SPRUCE_SLAB)), _1_3, _1_13_2);
    SlabBlock JUNGLE_SLAB_1_3 = register("jungle_slab_1_3", new SlabBlock(AbstractBlock.Settings.copy(JUNGLE_SLAB)), _1_3, _1_13_2);
    CocoaBlock COCOA_1_3 = register("cocoa_1_3", new CocoaBlock(AbstractBlock.Settings.copy(COCOA)), _1_3, _1_13_2);
    ExperienceDroppingBlock RUBY_ORE = register("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(6, 14), AbstractBlock.Settings.copy(EMERALD_ORE)), _1_3);
    ExperienceDroppingBlock EMERALD_ORE_1_3 = register("emerald_ore_1_3",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(EMERALD_ORE)), _1_3, _1_13_2);
    ExperienceDroppingBlock EMERALD_ORE_1_14 = register("emerald_ore_1_14",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(EMERALD_ORE)), _1_14, _1_16_5);
    StairsBlock SANDSTONE_STAIRS_B1_2 = registerFake("sandstone_stairs_b1_2",
            new StairsBlock(SANDSTONE_B1_2.getDefaultState(), AbstractBlock.Settings.copy(SANDSTONE_STAIRS)), B1_2, _1_2_5);
    StairsBlock SANDSTONE_STAIRS_1_3 = register("sandstone_stairs_1_3",
            new StairsBlock(SANDSTONE_1_2_4.getDefaultState(), AbstractBlock.Settings.copy(SANDSTONE_STAIRS)), _1_3, _1_13_2);
    Block EMERALD_BLOCK_1_3 = copy("emerald_block_1_3", EMERALD_BLOCK, _1_3, _1_13_2);
    StairsBlock BIRCH_STAIRS_1_3 = register("birch_stairs_1_3", new StairsBlock(BIRCH_PLANKS_1_2_4.getDefaultState(), AbstractBlock.Settings.copy(BIRCH_STAIRS)), _1_3, _1_13_2);
    StairsBlock SPRUCE_STAIRS_1_3 = register("spruce_stairs_1_3", new StairsBlock(SPRUCE_PLANKS_1_2_4.getDefaultState(), AbstractBlock.Settings.copy(SPRUCE_STAIRS)), _1_3, _1_13_2);
    StairsBlock JUNGLE_STAIRS_1_3 = register("jungle_stairs_1_3", new StairsBlock(JUNGLE_PLANKS_1_2_4.getDefaultState(), AbstractBlock.Settings.copy(JUNGLE_STAIRS)), _1_3, _1_13_2);
    Block OAK_WOOD_1_3 = register("oak_wood_1_3", createWoodBlock(MapColor.OAK_TAN), _1_3, _1_13_2);
    Block BIRCH_WOOD_1_3 = register("birch_wood_1_3", createWoodBlock(MapColor.PALE_YELLOW), _1_3, _1_13_2);
    Block SPRUCE_WOOD_1_3 = register("spruce_wood_1_3", createWoodBlock(MapColor.SPRUCE_BROWN), _1_3, _1_13_2);
    Block JUNGLE_WOOD_1_3 = register("jungle_wood_1_3", createWoodBlock(MapColor.DIRT_BROWN), _1_3, _1_3_2);
    Block WOODEN_BUTTON_RD20090515 = registerFake("wooden_button_rd20090515", createWoodenButtonBlock(ModBlockSetTypes.WOOD_RD20090515), RD20090515, RD160052);
    Block WOODEN_BUTTON_RD161348 = registerFake("wooden_button_rd161348", createWoodenButtonBlock(ModBlockSetTypes.WOOD_RD161348), RD161348, C0_0_13A_03);
    Block WOODEN_BUTTON_C0_0_14A = registerFake("wooden_button_c0_0_14a", createWoodenButtonBlock(ModBlockSetTypes.WOOD_C0_0_15A), C0_0_14A, C0_0_14A_08);
    Block WOODEN_BUTTON_C0_0_15A = registerFake("wooden_button_c0_0_15a", createWoodenButtonBlock(ModBlockSetTypes.WOOD_C0_0_15A), C0_0_15A, _1_3_2);
    Block WOODEN_BUTTON_1_4 = register("wooden_button_1_4", createWoodenButtonBlock(ModBlockSetTypes.WOOD_B1_9PRE5), _1_4, _1_13_2);
    WallBlock COBBLESTONE_WALL_RD20090515 = registerFake("cobblestone_wall_rd20090515", new WallBlock(AbstractBlock.Settings.copy(COBBLESTONE_WALL)), RD20090515, C0_0_13A_03);
    WallBlock COBBLESTONE_WALL_C0_0_14A = registerFake("cobblestone_wall_c0_0_14a", new WallBlock(AbstractBlock.Settings.copy(COBBLESTONE_WALL)), C0_0_14A, _1_3_2);
    WallBlock COBBLESTONE_WALL_1_4 = register("cobblestone_wall_1_4", new WallBlock(AbstractBlock.Settings.copy(COBBLESTONE_WALL)), _1_4, _1_13_2);
    SlabBlock NETHER_BRICK_SLAB_1_4_6 = register("nether_brick_slab_1_4_6", new SlabBlock(AbstractBlock.Settings.copy(NETHER_BRICK_SLAB)), _1_4_6, _1_13_2);
    ExperienceDroppingBlock QUARTZ_ORE_1_5 = register("quartz_ore_1_5",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(NETHER_QUARTZ_ORE)), _1_5, _1_13_2);
    RedstoneBlock REDSTONE_BLOCK_1_5 = register("redstone_block_1_5", new RedstoneBlock(AbstractBlock.Settings.copy(REDSTONE_BLOCK)), _1_5, _1_13_2);
    PoweredRailBlock ACTIVATOR_RAIL_1_5 = register("activator_rail_1_5", new PoweredRailBlock(AbstractBlock.Settings.copy(ACTIVATOR_RAIL)), _1_5, _1_13_2);
    Block QUARTZ_BLOCK_1_5 = copy("quartz_block_1_5", QUARTZ_BLOCK, _1_5, _1_13_2);
    Block CHISELED_QUARTZ_BLOCK_1_5 = copy("chiseled_quartz_1_5", CHISELED_QUARTZ_BLOCK, _1_5, _1_13_2);
    PillarBlock QUARTZ_PILLAR_1_5 = register("quartz_pillar_1_5", new PillarBlock(AbstractBlock.Settings.copy(QUARTZ_PILLAR)), _1_5, _1_13_2);
    SlabBlock QUARTZ_SLAB_1_5 = register("quartz_slab_1_5", new SlabBlock(AbstractBlock.Settings.copy(QUARTZ_SLAB)), _1_5, _1_13_2);
    StairsBlock QUARTZ_STAIRS_1_5 = register("quartz_stairs_1_5", new StairsBlock(QUARTZ_BLOCK_1_5.getDefaultState(),
            AbstractBlock.Settings.copy(QUARTZ_STAIRS)), _1_5, _1_13_2);
    Block SMOOTH_SANDSTONE_1_5 = copy("smooth_sandstone_1_5", SMOOTH_SANDSTONE, _1_5, _1_13_2);
    Block SMOOTH_QUARTZ_1_5 = copy("smooth_quartz_1_5", SMOOTH_QUARTZ, _1_5, _1_13_2);
    CarpetBlock WHITE_CLOTH_CARPET = registerClothCarpet(WHITE_CLOTH);
    CarpetBlock LIGHT_GRAY_CLOTH_CARPET_C0_0_20A = registerClothCarpet(LIGHT_GRAY_CLOTH_C0_0_20A);
    CarpetBlock LIGHT_GRAY_CLOTH_CARPET_C0_28A = registerClothCarpet(LIGHT_GRAY_CLOTH_C0_28A);
    CarpetBlock DARK_GRAY_CLOTH_CARPET_C0_0_20A = registerClothCarpet(DARK_GRAY_CLOTH_C0_0_20A);
    CarpetBlock DARK_GRAY_CLOTH_CARPET_C0_28A = registerClothCarpet(DARK_GRAY_CLOTH_C0_28A);
    CarpetBlock RED_CLOTH_CARPET = registerClothCarpet(RED_CLOTH);
    CarpetBlock ORANGE_CLOTH_CARPET = registerClothCarpet(ORANGE_CLOTH);
    CarpetBlock YELLOW_CLOTH_CARPET = registerClothCarpet(YELLOW_CLOTH);
    CarpetBlock CHARTREUSE_CLOTH_CARPET = registerClothCarpet(CHARTREUSE_CLOTH);
    CarpetBlock SPRING_GREEN_CLOTH_CARPET = registerClothCarpet(SPRING_GREEN_CLOTH);
    CarpetBlock CYAN_CLOTH_CARPET = registerClothCarpet(CYAN_CLOTH);
    CarpetBlock CAPRI_CLOTH_CARPET = registerClothCarpet(CAPRI_CLOTH);
    CarpetBlock ULTRAMARINE_CLOTH_CARPET = registerClothCarpet(ULTRAMARINE_CLOTH);
    CarpetBlock VIOLET_CLOTH_CARPET = registerClothCarpet(VIOLET_CLOTH);
    CarpetBlock PURPLE_CLOTH_CARPET = registerClothCarpet(PURPLE_CLOTH);
    CarpetBlock MAGENTA_CLOTH_CARPET = registerClothCarpet(MAGENTA_CLOTH);
    CarpetBlock ROSE_CLOTH_CARPET = registerClothCarpet(ROSE_CLOTH);
    CarpetBlock LIGHT_GRAY_CARPET_B1_2 = registerBetaCarpet(LIGHT_GRAY_WOOL_B1_2);
    CarpetBlock GRAY_CARPET_B1_2 = registerBetaCarpet(GRAY_WOOL_B1_2);
    CarpetBlock BLACK_CARPET_B1_2 = registerBetaCarpet(BLACK_WOOL_B1_2);
    CarpetBlock BROWN_CARPET_B1_2 = registerBetaCarpet(BROWN_WOOL_B1_2);
    CarpetBlock RED_CARPET_B1_2 = registerBetaCarpet(RED_WOOL_B1_2);
    CarpetBlock ORANGE_CARPET_B1_2 = registerBetaCarpet(ORANGE_WOOL_B1_2);
    CarpetBlock YELLOW_CARPET_B1_2 = registerBetaCarpet(YELLOW_WOOL_B1_2);
    CarpetBlock LIME_CARPET_B1_2 = registerBetaCarpet(LIME_WOOL_B1_2);
    CarpetBlock GREEN_CARPET_B1_2 = registerBetaCarpet(GREEN_WOOL_B1_2);
    CarpetBlock CYAN_CARPET_B1_2 = registerBetaCarpet(CYAN_WOOL_B1_2);
    CarpetBlock LIGHT_BLUE_CARPET_B1_2 = registerBetaCarpet(LIGHT_BLUE_WOOL_B1_2);
    CarpetBlock BLUE_CARPET_B1_2 = registerBetaCarpet(BLUE_WOOL_B1_2);
    CarpetBlock PURPLE_CARPET_B1_2 = registerBetaCarpet(PURPLE_WOOL_B1_2);
    CarpetBlock MAGENTA_CARPET_B1_2 = registerBetaCarpet(MAGENTA_WOOL_B1_2);
    CarpetBlock PINK_CARPET_B1_2 = registerBetaCarpet(PINK_WOOL_B1_2);
    CarpetBlock LIGHT_GRAY_CARPET_1_2_4 = registerCarpet(LIGHT_GRAY_WOOL_1_2_4);
    CarpetBlock GRAY_CARPET_1_2_4 = registerCarpet(GRAY_WOOL_1_2_4);
    CarpetBlock BLACK_CARPET_1_2_4 = registerCarpet(BLACK_WOOL_1_2_4);
    CarpetBlock BROWN_CARPET_1_2_4 = registerCarpet(BROWN_WOOL_1_2_4);
    CarpetBlock RED_CARPET_1_2_4 = registerCarpet(RED_WOOL_1_2_4);
    CarpetBlock ORANGE_CARPET_1_2_4 = registerCarpet(ORANGE_WOOL_1_2_4);
    CarpetBlock YELLOW_CARPET_1_2_4 = registerCarpet(YELLOW_WOOL_1_2_4);
    CarpetBlock LIME_CARPET_1_2_4 = registerCarpet(LIME_WOOL_1_2_4);
    CarpetBlock GREEN_CARPET_1_2_4 = registerCarpet(GREEN_WOOL_1_2_4);
    CarpetBlock CYAN_CARPET_1_2_4 = registerCarpet(CYAN_WOOL_1_2_4);
    CarpetBlock LIGHT_BLUE_CARPET_1_2_4 = registerCarpet(LIGHT_BLUE_WOOL_1_2_4);
    CarpetBlock BLUE_CARPET_1_2_4 = registerCarpet(BLUE_WOOL_1_2_4);
    CarpetBlock PURPLE_CARPET_1_2_4 = registerCarpet(PURPLE_WOOL_1_2_4);
    CarpetBlock MAGENTA_CARPET_1_2_4 = registerCarpet(MAGENTA_WOOL_1_2_4);
    CarpetBlock PINK_CARPET_1_2_4 = registerCarpet(PINK_WOOL_1_2_4);
    PillarBlock HAY_BALE_1_6 = register("hay_bale_1_6", new PillarBlock(AbstractBlock.Settings.copy(HAY_BLOCK)), _1_6, _1_13_2);
    Block TERRACOTTA_1_6 = copy("terracotta_1_6", TERRACOTTA, _1_6, _1_13_2);
    Block COAL_BLOCK_1_6 = copy("coal_block_1_6", COAL_BLOCK, _1_6, _1_13_2);
    FlowerBlock ALLIUM_1_7 = register("allium_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(ALLIUM)),
            _1_7, _1_13_2);
    FlowerBlock AZURE_BLUET_1_7 = register("azure_bluet_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(AZURE_BLUET)),
            _1_7, _1_13_2);
    FlowerBlock BLUE_ORCHID_1_7 = register("blue_orchid_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(BLUE_ORCHID)),
            _1_7, _1_13_2);
    TallFlowerBlock LILAC_1_7 = ModBlocks.register("lilac_1_7", new TallFlowerBlock(AbstractBlock.Settings.copy(LILAC)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    TallFlowerBlock PEONY_1_7 = ModBlocks.register("peony_1_7", new TallFlowerBlock(AbstractBlock.Settings.copy(PEONY)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    TallFlowerBlock ROSE_BUSH_1_7 = ModBlocks.register("rose_bush_1_7", new TallFlowerBlock(AbstractBlock.Settings.copy(ROSE_BUSH)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    TallFlowerBlock SUNFLOWER_1_7 = ModBlocks.register("sunflower_1_7", new TallFlowerBlock(AbstractBlock.Settings.copy(SUNFLOWER)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    FlowerBlock OXEYE_DAISY_1_7 = register("oxeye_daisy_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(OXEYE_DAISY)),
            _1_7, _1_13_2);
    FlowerBlock RED_TULIP_1_7 = register("red_tulip_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(RED_TULIP)),
            _1_7, _1_13_2);
    FlowerBlock ORANGE_TULIP_1_7 = register("orange_tulip_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(ORANGE_TULIP)),
            _1_7, _1_13_2);
    FlowerBlock WHITE_TULIP_1_7 = register("white_tulip_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(WHITE_TULIP)),
            _1_7, _1_13_2);
    FlowerBlock PINK_TULIP_1_7 = register("pink_tulip_1_7", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 1, AbstractBlock.Settings.copy(PINK_TULIP)),
            _1_7, _1_13_2);
    TallPlantBlock LARGE_FERN_1_7 = ModBlocks.register("large_fern_1_7", new TallPlantBlock(AbstractBlock.Settings.copy(LARGE_FERN)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    TallPlantBlock TALL_GRASS_1_7 = ModBlocks.register("tall_grass_1_7", new TallPlantBlock(AbstractBlock.Settings.copy(TALL_GRASS)),
            new Item.Settings(), (block, settings) -> new TallBlockItem(block, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    addLegacyTooltip(tooltip, _1_7, _1_13_2);
                }
            });
    Block PACKED_ICE_1_7 = copy("packed_ice_1_7", PACKED_ICE, _1_7, _1_13_2);
    InfestedBlock INFESTED_CRACKED_STONE_BRICKS_1_7 = register("infested_cracked_stone_bricks_1_7",
            new InfestedBlock(CRACKED_STONE_BRICKS_B1_8, AbstractBlock.Settings.copy(INFESTED_CRACKED_STONE_BRICKS)), _1_7, _1_13_2);
    InfestedBlock INFESTED_MOSSY_STONE_BRICKS_1_7 = register("infested_mossy_stone_bricks_1_7",
            new InfestedBlock(MOSSY_STONE_BRICKS_B1_8, AbstractBlock.Settings.copy(INFESTED_MOSSY_STONE_BRICKS)), _1_7, _1_13_2);
    InfestedBlock INFESTED_CHISELED_STONE_BRICKS_1_7 = register("infested_chiseled_stone_bricks_1_7",
            new InfestedBlock(CHISELED_STONE_BRICKS_1_2, AbstractBlock.Settings.copy(INFESTED_CHISELED_STONE_BRICKS)), _1_7, _1_13_2);
    ColoredFallingBlock RED_SAND_1_7 = register("red_sand_1_7", new ColoredFallingBlock(new ColorCode(11098145), AbstractBlock.Settings.copy(RED_SAND)), _1_7, _1_13_2);
    Block WHITE_STAINED_GLASS_1_7 = register("white_stained_glass_1_7", createStainedGlassBlock(DyeColor.WHITE), _1_7, _1_13_2);
    Block ORANGE_STAINED_GLASS_1_7 = register("orange_stained_glass_1_7", createStainedGlassBlock(DyeColor.ORANGE), _1_7, _1_13_2);
    Block MAGENTA_STAINED_GLASS_1_7 = register("magenta_stained_glass_1_7", createStainedGlassBlock(DyeColor.MAGENTA), _1_7, _1_13_2);
    Block LIGHT_BLUE_STAINED_GLASS_1_7 = register("light_blue_stained_glass_1_7", createStainedGlassBlock(DyeColor.LIGHT_BLUE), _1_7, _1_13_2);
    Block YELLOW_STAINED_GLASS_1_7 = register("yellow_stained_glass_1_7", createStainedGlassBlock(DyeColor.YELLOW), _1_7, _1_13_2);
    Block LIME_STAINED_GLASS_1_7 = register("lime_stained_glass_1_7", createStainedGlassBlock(DyeColor.LIME), _1_7, _1_13_2);
    Block PINK_STAINED_GLASS_1_7 = register("pink_stained_glass_1_7", createStainedGlassBlock(DyeColor.PINK), _1_7, _1_13_2);
    Block GRAY_STAINED_GLASS_1_7 = register("gray_stained_glass_1_7", createStainedGlassBlock(DyeColor.GRAY), _1_7, _1_13_2);
    Block LIGHT_GRAY_STAINED_GLASS_1_7 = register("light_gray_stained_glass_1_7", createStainedGlassBlock(DyeColor.LIGHT_GRAY), _1_7, _1_13_2);
    Block CYAN_STAINED_GLASS_1_7 = register("cyan_stained_glass_1_7", createStainedGlassBlock(DyeColor.CYAN), _1_7, _1_13_2);
    Block PURPLE_STAINED_GLASS_1_7 = register("purple_stained_glass_1_7", createStainedGlassBlock(DyeColor.PURPLE), _1_7, _1_13_2);
    Block BLUE_STAINED_GLASS_1_7 = register("blue_stained_glass_1_7", createStainedGlassBlock(DyeColor.BLUE), _1_7, _1_13_2);
    Block BROWN_STAINED_GLASS_1_7 = register("brown_stained_glass_1_7", createStainedGlassBlock(DyeColor.BROWN), _1_7, _1_13_2);
    Block GREEN_STAINED_GLASS_1_7 = register("green_stained_glass_1_7", createStainedGlassBlock(DyeColor.GREEN), _1_7, _1_13_2);
    Block RED_STAINED_GLASS_1_7 = register("red_stained_glass_1_7", createStainedGlassBlock(DyeColor.RED), _1_7, _1_13_2);
    Block BLACK_STAINED_GLASS_1_7 = register("black_stained_glass_1_7", createStainedGlassBlock(DyeColor.BLACK), _1_7, _1_13_2);
    Block WHITE_STAINED_GLASS_PANE_1_7 = register("white_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.WHITE), _1_7, _1_13_2);
    Block ORANGE_STAINED_GLASS_PANE_1_7 = register("orange_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.ORANGE), _1_7, _1_13_2);
    Block MAGENTA_STAINED_GLASS_PANE_1_7 = register("magenta_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.MAGENTA), _1_7, _1_13_2);
    Block LIGHT_BLUE_STAINED_GLASS_PANE_1_7 = register("light_blue_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.LIGHT_BLUE), _1_7, _1_13_2);
    Block YELLOW_STAINED_GLASS_PANE_1_7 = register("yellow_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.YELLOW), _1_7, _1_13_2);
    Block LIME_STAINED_GLASS_PANE_1_7 = register("lime_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.LIME), _1_7, _1_13_2);
    Block PINK_STAINED_GLASS_PANE_1_7 = register("pink_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.PINK), _1_7, _1_13_2);
    Block GRAY_STAINED_GLASS_PANE_1_7 = register("gray_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.GRAY), _1_7, _1_13_2);
    Block LIGHT_GRAY_STAINED_GLASS_PANE_1_7 = register("light_gray_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.LIGHT_GRAY), _1_7, _1_13_2);
    Block CYAN_STAINED_GLASS_PANE_1_7 = register("cyan_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.CYAN), _1_7, _1_13_2);
    Block PURPLE_STAINED_GLASS_PANE_1_7 = register("purple_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.PURPLE), _1_7, _1_13_2);
    Block BLUE_STAINED_GLASS_PANE_1_7 = register("blue_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.BLUE), _1_7, _1_13_2);
    Block BROWN_STAINED_GLASS_PANE_1_7 = register("brown_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.BROWN), _1_7, _1_13_2);
    Block GREEN_STAINED_GLASS_PANE_1_7 = register("green_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.GREEN), _1_7, _1_13_2);
    Block RED_STAINED_GLASS_PANE_1_7 = register("red_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.RED), _1_7, _1_13_2);
    Block BLACK_STAINED_GLASS_PANE_1_7 = register("black_stained_glass_pane_1_7", createStainedGlassPaneBlock(DyeColor.BLACK), _1_7, _1_13_2);
    Block ACACIA_LOG_1_7 = register("acacia_log_1_7", createLogBlock(MapColor.ORANGE, MapColor.STONE_GRAY), _1_7, _1_13_2);
    Block ACACIA_WOOD_1_7 = register("acacia_wood_1_7", createWoodBlock(MapColor.STONE_GRAY), _1_7, _1_13_2);
    ExtendedLeavesBlock ACACIA_LEAVES_1_7 = register("acacia_leaves_1_7", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(ACACIA_LEAVES)), _1_7, _1_13_2);
    FloorExtendedSaplingBlock ACACIA_SAPLING_1_7 = register("acacia_sapling_1_7",
            new FloorExtendedSaplingBlock(ModSaplingGenerators.ACACIA_1_7, AbstractBlock.Settings.copy(ACACIA_SAPLING)), _1_7, _1_13_2);
    Block DARK_OAK_LOG_1_7 = register("dark_oak_log_1_7", createLogBlock(MapColor.BROWN, MapColor.BROWN), _1_7, _1_13_2);
    Block DARK_OAK_WOOD_1_7 = register("dark_oak_wood_1_7", createWoodBlock(MapColor.BROWN), _1_7, _1_13_2);
    ExtendedLeavesBlock DARK_OAK_LEAVES_1_7 = register("dark_oak_leaves_1_7", new ExtendedLeavesBlock(AbstractBlock.Settings.copy(DARK_OAK_LEAVES)), _1_7, _1_13_2);
    FloorExtendedSaplingBlock DARK_OAK_SAPLING_1_7 = register("dark_oak_sapling_1_7",
            new FloorExtendedSaplingBlock(ModSaplingGenerators.DARK_OAK_1_7, AbstractBlock.Settings.copy(DARK_OAK_SAPLING)), _1_7, _1_13_2);
    Block ACACIA_PLANKS_1_7 = copy("acacia_planks_1_7", ACACIA_PLANKS, _1_7, _1_13_2);
    StairsBlock ACACIA_STAIRS_1_7 = register("acacia_stairs_1_7",
            new StairsBlock(ACACIA_PLANKS_1_7.getDefaultState(), AbstractBlock.Settings.copy(ACACIA_STAIRS)), _1_7, _1_13_2);
    SlabBlock ACACIA_SLAB_1_7 = register("acacia_slab_1_7", new SlabBlock(AbstractBlock.Settings.copy(ACACIA_SLAB)), _1_7, _1_13_2);
    Block DARK_OAK_PLANKS_1_7 = copy("dark_oak_planks_1_7", DARK_OAK_PLANKS, _1_7, _1_13_2);
    StairsBlock DARK_OAK_STAIRS_1_7 = register("dark_oak_stairs_1_7",
            new StairsBlock(DARK_OAK_PLANKS_1_7.getDefaultState(), AbstractBlock.Settings.copy(DARK_OAK_STAIRS)), _1_7, _1_13_2);
    SlabBlock DARK_OAK_SLAB_1_7 = register("dark_oak_slab_1_7", new SlabBlock(AbstractBlock.Settings.copy(DARK_OAK_SLAB)), _1_7, _1_13_2);
    Block GRANITE_1_8 = copy("granite_1_8", GRANITE, _1_8,_1_13_2);
    Block POLISHED_GRANITE_1_8 = copy("polished_granite_1_8", POLISHED_GRANITE, _1_8,_1_13_2);
    Block DIORITE_1_8 = copy("diorite_1_8", DIORITE, _1_8,_1_13_2);
    Block POLISHED_DIORITE_1_8 = copy("polished_diorite_1_8", POLISHED_DIORITE, _1_8,_1_13_2);
    Block ANDESITE_1_8 = copy("andesite_1_8", ANDESITE, _1_8,_1_13_2);
    Block POLISHED_ANDESITE_1_8 = copy("polished_andesite_1_8", POLISHED_ANDESITE, _1_8,_1_13_2);
    SlimeBlock SLIME_BLOCK_1_8 = register("slime_block_1_8", new SlimeBlock(AbstractBlock.Settings.copy(SLIME_BLOCK)), _1_8, _1_13_2);
    Block PRISMARINE_1_8 = copy("prismarine_1_8", PRISMARINE, _1_8, _1_13_2);
    Block PRISMARINE_BRICKS_1_8 = copy("prismarine_bricks_1_8", PRISMARINE_BRICKS, _1_8, _1_13_2);
    Block DARK_PRISMARINE_1_8 = copy("dark_prismarine_1_8", DARK_PRISMARINE, _1_8, _1_13_2);
    Block RED_SANDSTONE_1_8 = copy("red_sandstone_1_8", RED_SANDSTONE, _1_8, _1_13_2);
    Block CUT_RED_SANDSTONE_1_8 = copy("cut_red_sandstone_1_8", CUT_RED_SANDSTONE, _1_8, _1_13_2);
    Block CHISELED_RED_SANDSTONE_1_8 = copy("chiseled_red_sandstone_1_8", CHISELED_RED_SANDSTONE, _1_8, _1_13_2);
    Block SMOOTH_RED_SANDSTONE_1_8 = copy("smooth_red_sandstone_1_8", SMOOTH_RED_SANDSTONE, _1_8, _1_13_2);
    SlabBlock RED_SANDSTONE_SLAB_1_8 = register("red_sandstone_slab_1_8", new SlabBlock(AbstractBlock.Settings.copy(RED_SANDSTONE_SLAB)), _1_8, _1_13_2);
    StairsBlock RED_SANDSTONE_STAIRS_1_8 = register("red_sandstone_stairs_1_8", new StairsBlock(RED_SANDSTONE_1_8.getDefaultState(), AbstractBlock.Settings.copy(RED_SANDSTONE_STAIRS)),
            _1_8, _1_13_2);
    FenceBlock BIRCH_FENCE_1_8 = register("birch_fence_1_8", new FenceBlock(AbstractBlock.Settings.copy(BIRCH_FENCE)), _1_8, _1_13_2);
    FenceBlock SPRUCE_FENCE_1_8 = register("spruce_fence_1_8", new FenceBlock(AbstractBlock.Settings.copy(SPRUCE_FENCE)), _1_8, _1_13_2);
    FenceBlock JUNGLE_FENCE_1_8 = register("jungle_fence_1_8", new FenceBlock(AbstractBlock.Settings.copy(JUNGLE_FENCE)), _1_8, _1_13_2);
    FenceBlock ACACIA_FENCE_1_8 = register("acacia_fence_1_8", new FenceBlock(AbstractBlock.Settings.copy(ACACIA_FENCE)), _1_8, _1_13_2);
    FenceBlock DARK_OAK_FENCE_1_8 = register("dark_oak_fence_1_8", new FenceBlock(AbstractBlock.Settings.copy(DARK_OAK_FENCE)), _1_8, _1_13_2);
    FenceGateBlock BIRCH_FENCE_GATE_1_8 = register("birch_fence_gate_1_8", new FenceGateBlock(ModWoodSetTypes.BIRCH_B1_2, AbstractBlock.Settings.copy(BIRCH_FENCE_GATE)),
            _1_8, _1_13_2);
    FenceGateBlock SPRUCE_FENCE_GATE_1_8 = register("spruce_fence_gate_1_8", new FenceGateBlock(ModWoodSetTypes.SPRUCE_B1_2, AbstractBlock.Settings.copy(SPRUCE_FENCE_GATE)),
            _1_8, _1_13_2);
    FenceGateBlock JUNGLE_FENCE_GATE_1_8 = register("jungle_fence_gate_1_8", new FenceGateBlock(ModWoodSetTypes.JUNGLE_1_2, AbstractBlock.Settings.copy(JUNGLE_FENCE_GATE)),
            _1_8, _1_13_2);
    FenceGateBlock ACACIA_FENCE_GATE_1_8 = register("acacia_fence_gate_1_8", new FenceGateBlock(ModWoodSetTypes.ACACIA_1_7, AbstractBlock.Settings.copy(ACACIA_FENCE_GATE)),
            _1_8, _1_13_2);
    FenceGateBlock DARK_OAK_FENCE_GATE_1_8 = register("dark_oak_fence_gate_1_8", new FenceGateBlock(ModWoodSetTypes.DARK_OAK_1_7, AbstractBlock.Settings.copy(DARK_OAK_FENCE_GATE)),
            _1_8, _1_13_2);
    EndRodBlock END_ROD_1_9 = register("end_rod_1_9", new EndRodBlock(AbstractBlock.Settings.copy(END_ROD)), _1_9, _1_13_2);
    Block ENDSTONE_BRICKS_1_9 = copy("endstone_bricks_1_9", END_STONE_BRICKS, _1_9, _1_13_2);
    Block PURPUR_BLOCK_1_9 = copy("purpur_block_1_9", PURPUR_BLOCK, _1_9, _1_13_2);
    PillarBlock PURPUR_PILLAR_1_9 = register("purpur_pillar_1_9", new PillarBlock(AbstractBlock.Settings.copy(PURPUR_PILLAR)), _1_9, _1_13_2);
    SlabBlock PURPUR_SLAB_1_9 = register("purpur_slab_1_9", new SlabBlock(AbstractBlock.Settings.copy(PURPUR_SLAB)), _1_9, _1_13_2);
    StairsBlock PURPUR_STAIRS_1_9 = register("purpur_stairs_1_9", new StairsBlock(PURPUR_BLOCK_1_9.getDefaultState(), AbstractBlock.Settings.copy(PURPUR_STAIRS)),
            _1_9, _1_13_2);
    PillarBlock BONE_BLOCK_1_10 = register("bone_block_1_10", new PillarBlock(AbstractBlock.Settings.copy(BONE_BLOCK)), _1_10, _1_13_2);
    MagmaBlock MAGMA_BLOCK_1_10 = register("magma_block_1_10", new MagmaBlock(AbstractBlock.Settings.copy(MAGMA_BLOCK)), _1_10, _1_13_2);
    Block NETHER_WART_BLOCK_1_10 = copy("nether_wart_block_1_10", NETHER_WART_BLOCK, _1_10, _1_13_2);
    Block NETHER_WART_BLOCK_1_14 = copy("nether_wart_block_1_14", NETHER_WART_BLOCK, _1_14, _1_15_2);
    Block RED_NETHER_BRICKS_1_10 = copy("red_nether_bricks_1_10", RED_NETHER_BRICKS, _1_10, _1_13_2);
    Block BIRCH_BUTTON_1_13 = register("birch_button_1_13", createWoodenButtonBlock(ModBlockSetTypes.BIRCH_B1_2), _1_13, _1_13_2);
    Block SPRUCE_BUTTON_1_13 = register("spruce_button_1_13", createWoodenButtonBlock(ModBlockSetTypes.SPRUCE_B1_2), _1_13, _1_13_2);
    Block JUNGLE_BUTTON_1_13 = register("jungle_button_1_13", createWoodenButtonBlock(ModBlockSetTypes.JUNGLE_1_2), _1_13, _1_13_2);
    Block ACACIA_BUTTON_1_13 = register("acacia_button_1_13", createWoodenButtonBlock(ModBlockSetTypes.ACACIA_1_7), _1_13, _1_13_2);
    Block DARK_OAK_BUTTON_1_13 = register("dark_oak_button_1_13", createWoodenButtonBlock(ModBlockSetTypes.DARK_OAK_1_7), _1_13, _1_13_2);
    PressurePlateBlock BIRCH_PRESSURE_PLATE_1_13 = register("birch_pressure_plate_1_13",
            new PressurePlateBlock(ModBlockSetTypes.BIRCH_B1_2, AbstractBlock.Settings.copy(BIRCH_PRESSURE_PLATE)), _1_13, _1_13_2);
    PressurePlateBlock SPRUCE_PRESSURE_PLATE_1_13 = register("spruce_pressure_plate_1_13",
            new PressurePlateBlock(ModBlockSetTypes.SPRUCE_B1_2, AbstractBlock.Settings.copy(SPRUCE_PRESSURE_PLATE)), _1_13, _1_13_2);
    PressurePlateBlock JUNGLE_PRESSURE_PLATE_1_13 = register("jungle_pressure_plate_1_13",
            new PressurePlateBlock(ModBlockSetTypes.JUNGLE_1_2, AbstractBlock.Settings.copy(JUNGLE_PRESSURE_PLATE)), _1_13, _1_13_2);
    PressurePlateBlock ACACIA_PRESSURE_PLATE_1_13 = register("acacia_pressure_plate_1_13",
            new PressurePlateBlock(ModBlockSetTypes.ACACIA_1_7, AbstractBlock.Settings.copy(ACACIA_PRESSURE_PLATE)), _1_13, _1_13_2);
    PressurePlateBlock DARK_OAK_PRESSURE_PLATE_1_13 = register("dark_oak_pressure_plate_1_13",
            new PressurePlateBlock(ModBlockSetTypes.DARK_OAK_1_7, AbstractBlock.Settings.copy(DARK_OAK_PRESSURE_PLATE)), _1_13, _1_13_2);
    SlabBlock PRISMARINE_SLAB_1_13 = register("prismarine_slab_1_13", new SlabBlock(AbstractBlock.Settings.copy(PRISMARINE_SLAB)), _1_13, _1_13_2);
    StairsBlock PRISMARINE_STAIRS_1_13 = register("prismarine_stairs_1_13", new StairsBlock(PRISMARINE_1_8.getDefaultState(), AbstractBlock.Settings.copy(PRISMARINE_STAIRS)),
            _1_13, _1_13_2);






    private static Block copy(String name, Block copy, MinecraftVersion only) {
        return register(name, new Block(AbstractBlock.Settings.copy(copy)), only);
    }

    private static Block copy(String name, Block copy, MinecraftVersion from, MinecraftVersion to) {
        return register(name, new Block(AbstractBlock.Settings.copy(copy)), from, to);
    }

    private static <T extends Block> T register(String name, T block, MinecraftVersion only) {
        return register(name, block, new Item.Settings(), only);
    }


    private static <T extends Block> T register(String name, T block, Item.Settings settings, MinecraftVersion only) {
        return ModBlocks.register(name, block, settings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                tooltip.add(Text.literal(only.getName()));
            }
        });
    }

    private static <T extends Block> T register(String name, T block, Item.Settings settings, MinecraftVersion from, MinecraftVersion to) {
        return ModBlocks.register(name, block, settings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                tooltip.add(Text.literal(from.getName() + " - " + to.getName()));
            }
        });
    }

    private static <T extends Block> T registerFake(String name, T block, MinecraftVersion from, MinecraftVersion to) {
        return ModBlocks.register(name, block, new Item.Settings(), (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.fake_legacy"));
                tooltip.add(Text.literal("§4" + from.getName() + " - " + to.getName()));
            }
        });
    }

    private static void addFakeLegacyTooltip(List<Text> tooltip, MinecraftVersion from, MinecraftVersion to) {
        tooltip.add(Text.translatable("blocktopia.tooltip.fake_legacy"));
        tooltip.add(Text.literal("§4" + from.getName() + " - " + to.getName()));
    }


    private static void addLegacyTooltip(List<Text> tooltip, MinecraftVersion from, MinecraftVersion to) {
        tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
        tooltip.add(Text.literal(from.getName() + " - " + to.getName()));
    }

    private static <T extends Block> T register(String name, T block, MinecraftVersion from, MinecraftVersion to) {
        return register(name, block, new Item.Settings(), from, to);
    }

    private static CarpetBlock registerClothCarpet(Block wool) {
        return ModBlocks.register(Registries.BLOCK.getId(wool).getPath() + "_carpet", new CarpetBlock(AbstractBlock.Settings.copy(wool).strength(0.1F)));
    }

    private static CarpetBlock registerBetaCarpet(Block wool) {
        return registerFake(Registries.BLOCK.getId(wool).getPath().split("_wool_b1_2")[0] + "_carpet_b1_2", new CarpetBlock(AbstractBlock.Settings.copy(wool).strength(0.1F)),
                B1_2, _1_2_3);
    }

    private static CarpetBlock registerCarpet(Block wool) {
        return register(Registries.BLOCK.getId(wool).getPath().split("_wool_1_2_4")[0] + "_carpet_1_2_4", new CarpetBlock(AbstractBlock.Settings.copy(wool).strength(0.1F)),
                _1_2_4, _1_11_2);
    }

    private static Block createStainedGlassBlock(DyeColor color) {
        return new StainedGlassBlock(
                color,
                AbstractBlock.Settings.create()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3F)
                        .sounds(BlockSoundGroup.GLASS)
                        .nonOpaque()
                        .allowsSpawning(Blocks::never)
                        .solidBlock(Blocks::never)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
        );
    }

    private static Block createStainedGlassPaneBlock(DyeColor color) {
        return new StainedGlassPaneBlock(
                color,
                AbstractBlock.Settings.create()
                        .mapColor(color)
                        .instrument(NoteBlockInstrument.HAT)
                        .strength(0.3F)
                        .sounds(BlockSoundGroup.GLASS)
                        .nonOpaque()
                        .allowsSpawning(Blocks::never)
                        .solidBlock(Blocks::never)
                        .suffocates(Blocks::never)
                        .blockVision(Blocks::never)
        );
    }


    static void load() {}
}
