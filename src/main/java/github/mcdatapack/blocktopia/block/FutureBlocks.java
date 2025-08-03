package github.mcdatapack.blocktopia.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.*;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import github.mcdatapack.blocktopia.worldgen.tree.sapling.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;

import java.util.List;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;

public interface FutureBlocks {
    Block STRIPPED_PALE_OAK_LOG =  register("stripped_pale_oak_log", Blocks.createLogBlock(MapColor.WHITE, MapColor.WHITE), _1_21_2);
    Block PALE_OAK_LOG = register("pale_oak_log", createStrippableLogBlock(MapColor.WHITE, MapColor.WHITE, STRIPPED_PALE_OAK_LOG), _1_21_2);
    Block STRIPPED_PALE_OAK_WOOD = register("stripped_pale_oak_wood", createWoodBlock(MapColor.WHITE), _1_21_2);
    Block PALE_OAK_WOOD = register("pale_oak_wood", createStrippableWoodBlock(MapColor.WHITE, STRIPPED_PALE_OAK_WOOD), _1_21_2);
    ExtendedLeavesBlock PALE_OAK_LEAVES = register("pale_oak_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)),
            _1_21_2);
    FloorExtendedSaplingBlock PALE_OAK_SAPLING = register("pale_oak_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.PALE_OAK, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()),
            _1_21_2);
    Block POTTED_PALE_OAK_SAPLING = registerWithoutItem("potted_pale_oak_sapling", Blocks.createFlowerPotBlock(PALE_OAK_SAPLING));
    Block PALE_OAK_PLANKS = register("pale_oak_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)), _1_21_2);
    DoorBlock PALE_OAK_DOOR = register("pale_oak_door", new DoorBlock(ModBlockSetTypes.PALE_OAK, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)), _1_21_2);
    FenceBlock PALE_OAK_FENCE = register("pale_oak_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    FenceGateBlock PALE_OAK_FENCE_GATE = register("pale_oak_fence_gate", new FenceGateBlock(ModWoodSetTypes.PALE_OAK, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    StairsBlock PALE_OAK_STAIRS = register("pale_oak_stairs", new StairsBlock(PALE_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)), _1_21_2);
    SlabBlock PALE_OAK_SLAB = register("pale_oak_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    PressurePlateBlock PALE_OAK_PRESSURE_PLATE = register("pale_oak_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.PALE_OAK, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)), _1_21_2);
    Block PALE_OAK_BUTTON = register("pale_oak_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.PALE_OAK), _1_21_2);
    TrapdoorBlock PALE_OAK_TRAPDOOR = register("pale_oak_trapdoor", new TrapdoorBlock(ModBlockSetTypes.PALE_OAK, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()), _1_21_2);
    WallSignBlock PALE_OAK_WALL_SIGN = registerWithoutItem("pale_oak_wall_sign",
            new TerraformWallSignBlock(Blocktopia.id("entity/signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    SignBlock PALE_OAK_SIGN = ModBlocks.register("pale_oak_sign",
            new TerraformSignBlock(Blocktopia.id("entity/signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)), new Item.Settings().maxCount(16),
            (block, settings) -> new HangingSignItem(block, PALE_OAK_WALL_SIGN, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                    tooltip.add(Text.literal(_1_21_2.getName() + "+"));
                }
            });
    WallHangingSignBlock PALE_OAK_WALL_HANGING_SIGN = registerWithoutItem("pale_oak_wall_hanging_sign",
            new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/pale_oak"), Blocktopia.id("textures/gui/hanging_signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock PALE_OAK_HANGING_SIGN = ModBlocks.register("pale_oak_hanging_sign",
            new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/pale_oak"), Blocktopia.id("textures/gui/hanging_signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)), new Item.Settings().maxCount(16),
            (block, settings) -> new HangingSignItem(block, PALE_OAK_WALL_HANGING_SIGN, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                    tooltip.add(Text.literal(_1_21_2.getName() + "+"));
                }
            });

    CarpetBlock PALE_MOSS_CARPET = register("pale_moss_carpet", new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET)), _1_21_2);
    CustomMossBlock PALE_MOSS = register("pale_moss", new CustomMossBlock(ModConfiguredFeatures.PALE_MOSS_PATCH_BONEMEAL_KEY,
            AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)), _1_21_2);
    HangingMossBlock PALE_HANGING_MOSS = register("pale_hanging_moss", new HangingMossBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.STONE_GRAY).noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY)), _1_21_2);
    EyeblossomBlock CLOSED_EYEBLOSSOM = register("closed_eyeblossom", new EyeblossomBlock(EyeblossomBlock.EyeblossomState.CLOSED, AbstractBlock.Settings.copy(Blocks.POPPY)), _1_21_2);
    FlowerPotBlock POTTED_CLOSED_EYEBOSSOM = registerWithoutItem("potted_closed_eyeblossom", new FlowerPotBlock(CLOSED_EYEBLOSSOM, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    EyeblossomBlock OPEN_EYEBLOSSOM = register("open_eyeblossom", new EyeblossomBlock(EyeblossomBlock.EyeblossomState.OPEN, AbstractBlock.Settings.copy(Blocks.POPPY)), _1_21_2);
    FlowerPotBlock POTTED_OPEN_EYEBOSSOM = registerWithoutItem("potted_open_eyeblossom", new FlowerPotBlock(OPEN_EYEBLOSSOM, AbstractBlock.Settings.copy(Blocks.FLOWER_POT)));
    Block RESIN_BLOCK = register("resin_block", new Block(AbstractBlock.Settings.create().breakInstantly()), _1_21_4);
    Block RESIN_BRICKS = register("resin_bricks", new Block(AbstractBlock.Settings.create().strength(1.5F, 6)), _1_21_4);
    StairsBlock RESIN_BRICK_STAIRS = register("resin_brick_stairs", new StairsBlock(RESIN_BRICKS.getDefaultState(), AbstractBlock.Settings.create().strength(1.5F, 6)), _1_21_4);
    SlabBlock RESIN_BRICK_SLAB = register("resin_brick_slab", new SlabBlock(AbstractBlock.Settings.create().strength(1.5F, 6)), _1_21_4);
    WallBlock RESIN_BRICK_WALL = register("resin_brick_wall", new WallBlock(AbstractBlock.Settings.create().strength(1.5F, 6)), _1_21_4);
    Block CHISELED_RESIN_BRICKS = register("chiseled_resin_bricks", new Block(AbstractBlock.Settings.create().strength(1.5F, 6)), _1_21_4);
    FlowerbedBlock WILDFLOWERS = register("wildflowers", new FlowerbedBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)), _1_21_5);
    FlowerbedBlock LEAF_LITTERS = register("leaf_litter", new FlowerbedBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)), _1_21_5);
    DeadBushBlock SHORT_DRY_GRASS = register("short_dry_grass", new DeadBushBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)), _1_21_5);




    private static <T extends Block> T register(String name, T block, MinecraftVersion since) {
        return register(name, block, new Item.Settings(), since);
    }

    private static <T extends Block> T register(String name, T block, Item.Settings settings, MinecraftVersion since) {
        return ModBlocks.register(name, block, settings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                tooltip.add(Text.literal(since.getName() + "+"));
            }
        });
    }

    static void load() {}
}
