package github.mcdatapack.blocktopia.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.*;
import github.mcdatapack.blocktopia.worldgen.tree.sapling.ModSaplingGenerators;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.item.ModItems;

import java.util.function.BiFunction;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;

public interface ModBlocks {
    CarpetBlock TROPICAL_MOSS_CARPET = register("tropical_moss_carpet", new CarpetBlock(AbstractBlock.Settings.copy(Blocks.MOSS_CARPET)));
    TropicalMossBlock TROPICAL_MOSS = register("tropical_moss", new TropicalMossBlock(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)));

    ColoredFallingBlock PAPER_BLOCK = register("paper_block",
            new ColoredFallingBlock(new ColorCode(16777215), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)));
    ColoredFallingBlock GUNPOWDER_BLOCK = register("gunpowder_block",
            new ColoredFallingBlock(new ColorCode(4276545), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)));
    ColoredFallingBlock FIREWORK_BLOCK = register("firework_block",
            new ColoredFallingBlock(new ColorCode(16728385), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.4F, 0.0F)));
    SmallChestBlock SMALL_CHEST = register("small_chest", new SmallChestBlock(AbstractBlock.Settings.create()
            .strength(2.5F).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS).burnable()));
    ExtendedRepeaterBlock EXTENDED_REPEATER_TICK = register("extended_repeater_tick",
            new ExtendedRepeaterBlock(AbstractBlock.Settings.create()
            .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    ExtendedRepeaterBlockSecond EXTENDED_REPEATER_SECOND = register("extended_repeater_second",
            new ExtendedRepeaterBlockSecond(AbstractBlock.Settings.create()
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    ExtendedRepeaterBlockMinute EXTENDED_REPEATER_MINUTE = register("extended_repeater_minute",
            new ExtendedRepeaterBlockMinute(AbstractBlock.Settings.create()
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    LegacyCutterBlock LEGACY_CUTTER = register("legacy_cutter", new LegacyCutterBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER)));
    SpongeTNTBlock SPONGE_TNT = register("sponge_tnt", new SpongeTNTBlock(AbstractBlock.Settings.copy(Blocks.TNT)));
    DuperBlock DUPER = register("duper", new DuperBlock(AbstractBlock.Settings.copy(Blocks.BEDROCK).strength(5000)));

    BananaCropBlock BANANA_CROP = register("banana_crop", new BananaCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)),
            new Item.Settings(), AliasedBlockItem::new);

    ExtendedLeavesBlock FLOWERING_CHERRY_LEAVES = register("flowering_cherry_leaves", new ExtendedLeavesBlock(
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES).luminance(state -> BlocktopiaConfig.getConfig().glowingFloweringCherryLeaves)));
    FloorExtendedSaplingBlock FLOWERING_CHERRY_SAPLING = register("flowering_cherry_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.FLOWERING_CHERRY, 
            AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));
    Block POTTED_FLOWERING_CHERRY_SAPLING = register("potted_flowering_cherry_sapling", Blocks.createFlowerPotBlock(FLOWERING_CHERRY_SAPLING));

    Block SANDY_DIRT = register("sandy_dirt", new Block(AbstractBlock.Settings.copy(Blocks.DIRT)));

    FlowerBlock GLOW_FLOWER = register("glow_flower", new FlowerBlock(StatusEffects.GLOWING, 60.5F, AbstractBlock.Settings.create()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance((state) -> 15)));
    Block POTTED_GLOW_FLOWER = registerWithoutItem("potted_glow_flower", createGlowingFlowerPotBlock(15, GLOW_FLOWER));


    Block STRIPPED_PALM_LOG =  register("stripped_palm_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    Block PALM_LOG = register("palm_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_PALM_LOG));
    Block STRIPPED_PALM_WOOD = register("stripped_palm_wood", createWoodBlock(MapColor.BROWN));
    Block PALM_WOOD = register("palm_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_PALM_WOOD));
    ExtendedLeavesBlock PALM_LEAVES = register("palm_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    FloorExtendedSaplingBlock PALM_SAPLING = register("palm_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.PALM, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_PALM_SAPLING = registerWithoutItem("potted_palm_sapling", Blocks.createFlowerPotBlock(PALM_SAPLING));
    Block PALM_PLANKS = register("palm_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    DoorBlock PALM_DOOR = register("palm_door", new DoorBlock(ModBlockSetTypes.PALM, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock PALM_FENCE = register("palm_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock PALM_FENCE_GATE = register("palm_fence_gate", new FenceGateBlock(ModWoodSetTypes.PALM, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock PALM_STAIRS = register("palm_stairs", new StairsBlock(PALM_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    SlabBlock PALM_SLAB = register("palm_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock PALM_PRESSURE_PLATE = register("palm_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.PALM, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block PALM_BUTTON = register("palm_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.PALM));
    TrapdoorBlock PALM_TRAPDOOR = register("palm_trapdoor", new TrapdoorBlock(ModBlockSetTypes.PALM, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_BANANA_LOG =  register("stripped_banana_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    Block BANANA_LOG = register("banana_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_BANANA_LOG));
    Block STRIPPED_BANANA_WOOD = register("stripped_banana_wood", createWoodBlock(MapColor.BROWN));
    Block BANANA_WOOD = register("banana_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_BANANA_WOOD));
    ExtendedLeavesBlock BANANA_LEAVES = register("banana_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingBananaLeaves)));
    FloorExtendedSaplingBlock BANANA_SAPLING = register("banana_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.BANANA, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_BANANA_SAPLING = registerWithoutItem("potted_banana_sapling", Blocks.createFlowerPotBlock(BANANA_SAPLING));
    Block BANANA_PLANKS = register("banana_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    DoorBlock BANANA_DOOR = register("banana_door", new DoorBlock(ModBlockSetTypes.BANANA, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock BANANA_FENCE = register("banana_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock BANANA_FENCE_GATE = register("banana_fence_gate", new FenceGateBlock(ModWoodSetTypes.BANANA, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock BANANA_STAIRS = register("banana_stairs", new StairsBlock(BANANA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    SlabBlock BANANA_SLAB = register("banana_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock BANANA_PRESSURE_PLATE = register("banana_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.BANANA, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block BANANA_BUTTON = register("banana_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.BANANA));
    TrapdoorBlock BANANA_TRAPDOOR = register("banana_trapdoor", new TrapdoorBlock(ModBlockSetTypes.BANANA, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_CORN_LOG =  register("stripped_corn_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    Block CORN_LOG = register("corn_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_CORN_LOG));
    Block STRIPPED_CORN_WOOD = register("stripped_corn_wood", createWoodBlock(MapColor.BROWN));
    Block CORN_WOOD = register("corn_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_CORN_WOOD));
    ExtendedLeavesBlock CORN_LEAVES = register("corn_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingCornLeaves)));
    FloorExtendedSaplingBlock CORN_SAPLING = register("corn_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.CORN, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_CORN_SAPLING = registerWithoutItem("potted_corn_sapling", Blocks.createFlowerPotBlock(CORN_SAPLING));
    Block CORN_PLANKS = register("corn_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    DoorBlock CORN_DOOR = register("corn_door", new DoorBlock(ModBlockSetTypes.CORN, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock CORN_FENCE = register("corn_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock CORN_FENCE_GATE = register("corn_fence_gate", new FenceGateBlock(ModWoodSetTypes.CORN, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock CORN_STAIRS = register("corn_stairs", new StairsBlock(CORN_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    SlabBlock CORN_SLAB = register("corn_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock CORN_PRESSURE_PLATE = register("corn_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.CORN, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block CORN_BUTTON = register("corn_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.CORN));
    TrapdoorBlock CORN_TRAPDOOR = register("corn_trapdoor", new TrapdoorBlock(ModBlockSetTypes.CORN, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));


    Block STRIPPED_POISONED_LOG =  register("stripped_poisoned_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    Block POISONED_LOG = register("poisoned_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_POISONED_LOG));
    Block STRIPPED_POISONED_WOOD = register("stripped_poisoned_wood", createWoodBlock(MapColor.BROWN));
    Block POISONED_WOOD = register("poisoned_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_POISONED_WOOD));
    ExtendedLeavesBlock POISONED_LEAVES = register("poisoned_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingPoisonedLeaves)));
    FloorExtendedSaplingBlock POISONED_SAPLING = register("poisoned_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.POISONED, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_POISONED_SAPLING = registerWithoutItem("potted_poisoned_sapling", Blocks.createFlowerPotBlock(POISONED_SAPLING));
    Block POISONED_PLANKS = register("poisoned_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    DoorBlock POISONED_DOOR = register("poisoned_door", new DoorBlock(ModBlockSetTypes.POISONED, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock POISONED_FENCE = register("poisoned_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock POISONED_FENCE_GATE = register("poisoned_fence_gate", new FenceGateBlock(ModWoodSetTypes.POISONED, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock POISONED_STAIRS = register("poisoned_stairs", new StairsBlock(POISONED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    SlabBlock POISONED_SLAB = register("poisoned_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock POISONED_PRESSURE_PLATE = register("poisoned_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.POISONED, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block POISONED_BUTTON = register("poisoned_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.POISONED));
    TrapdoorBlock POISONED_TRAPDOOR = register("poisoned_trapdoor", new TrapdoorBlock(ModBlockSetTypes.POISONED, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_MAHOGANY_LOG =  register("stripped_mahogany_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    Block MAHOGANY_LOG = register("mahogany_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_MAHOGANY_LOG));
    Block STRIPPED_MAHOGANY_WOOD = register("stripped_mahogany_wood", createWoodBlock(MapColor.BROWN));
    Block MAHOGANY_WOOD = register("mahogany_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_MAHOGANY_WOOD));
    ExtendedLeavesBlock MAHOGANY_LEAVES = register("mahogany_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingMahoganyLeaves)));
    FloorExtendedSaplingBlock MAHOGANY_SAPLING = register("mahogany_sapling", new FloorExtendedSaplingBlock(ModSaplingGenerators.MAHOGANY, AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_MAHOGANY_SAPLING = registerWithoutItem("potted_mahogany_sapling", Blocks.createFlowerPotBlock(MAHOGANY_SAPLING));
    Block MAHOGANY_PLANKS = register("mahogany_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    DoorBlock MAHOGANY_DOOR = register("mahogany_door", new DoorBlock(ModBlockSetTypes.MAHOGANY, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock MAHOGANY_FENCE = register("mahogany_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock MAHOGANY_FENCE_GATE = register("mahogany_fence_gate", new FenceGateBlock(ModWoodSetTypes.MAHOGANY, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock MAHOGANY_STAIRS = register("mahogany_stairs", new StairsBlock(MAHOGANY_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    SlabBlock MAHOGANY_SLAB = register("mahogany_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock MAHOGANY_PRESSURE_PLATE = register("mahogany_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.MAHOGANY, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block MAHOGANY_BUTTON = register("mahogany_button", Blocks.createWoodenButtonBlock(ModBlockSetTypes.MAHOGANY));
    TrapdoorBlock MAHOGANY_TRAPDOOR = register("mahogany_trapdoor", new TrapdoorBlock(ModBlockSetTypes.MAHOGANY, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    ChairBlock[] OAK_CHAIR = register("oak_chair", ChairBlock.ChairBlocks.create(Blocks.OAK_PLANKS));
    ChairBlock[] SPRUCE_CHAIR = register("spruce_chair", ChairBlock.ChairBlocks.create(Blocks.SPRUCE_PLANKS));
    ChairBlock[] BIRCH_CHAIR = register("birch_chair", ChairBlock.ChairBlocks.create(Blocks.BIRCH_PLANKS));
    ChairBlock[] JUNGLE_CHAIR = register("jungle_chair", ChairBlock.ChairBlocks.create(Blocks.JUNGLE_PLANKS));
    ChairBlock[] ACACIA_CHAIR = register("acacia_chair", ChairBlock.ChairBlocks.create(Blocks.ACACIA_PLANKS));
    ChairBlock[] DARK_OAK_CHAIR = register("dark_oak_chair", ChairBlock.ChairBlocks.create(Blocks.DARK_OAK_PLANKS));
    ChairBlock[] CRIMSON_CHAIR = register("crimson_chair", ChairBlock.ChairBlocks.create(Blocks.CRIMSON_PLANKS));
    ChairBlock[] WARPED_CHAIR = register("warped_chair", ChairBlock.ChairBlocks.create(Blocks.WARPED_PLANKS));
    ChairBlock[] MANGROVE_CHAIR = register("mangrove_chair", ChairBlock.ChairBlocks.create(Blocks.MANGROVE_PLANKS));
    ChairBlock[] BAMBOO_CHAIR = register("bamboo_chair", ChairBlock.ChairBlocks.create(Blocks.BAMBOO_PLANKS));
    ChairBlock[] CHERRY_CHAIR = register("cherry_chair", ChairBlock.ChairBlocks.create(Blocks.CHERRY_PLANKS));
    ChairBlock[] PALM_CHAIR = register("palm_chair", ChairBlock.ChairBlocks.create(PALM_PLANKS));
    ChairBlock[] BANANA_CHAIR = register("banana_chair", ChairBlock.ChairBlocks.create(BANANA_PLANKS));
    ChairBlock[] CORN_CHAIR = register("corn_chair", ChairBlock.ChairBlocks.create(CORN_PLANKS));
    ChairBlock[] POISONED_CHAIR = register("poisoned_chair", ChairBlock.ChairBlocks.create(POISONED_PLANKS));
    ChairBlock[] MAHOGANY_CHAIR = register("mahogany_chair", ChairBlock.ChairBlocks.create(MAHOGANY_PLANKS));

    XPTrapBlock XP_TRAP = register("xp_trap", new XPTrapBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));

    WallSignBlock PALM_WALL_SIGN = registerWithoutItem("palm_wall_sign", new TerraformWallSignBlock(Blocktopia.id("entity/signs/palm"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    SignBlock PALM_SIGN = register("palm_sign", new TerraformSignBlock(Blocktopia.id("entity/signs/palm"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new SignItem(settings, block, PALM_WALL_SIGN));
    WallSignBlock BANANA_WALL_SIGN = registerWithoutItem("banana_wall_sign", new TerraformWallSignBlock(Blocktopia.id("entity/signs/banana"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    SignBlock BANANA_SIGN = register("banana_sign", new TerraformSignBlock(Blocktopia.id("entity/signs/banana"), ModWoodSetTypes.BANANA, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new SignItem(settings, block, BANANA_WALL_SIGN));
    WallSignBlock CORN_WALL_SIGN = registerWithoutItem("corn_wall_sign", new TerraformWallSignBlock(Blocktopia.id("entity/signs/corn"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    SignBlock CORN_SIGN = register("corn_sign", new TerraformSignBlock(Blocktopia.id("entity/signs/corn"), ModWoodSetTypes.CORN, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new SignItem(settings, block, CORN_WALL_SIGN));
    WallSignBlock POISONED_WALL_SIGN = registerWithoutItem("poisoned_wall_sign", new TerraformWallSignBlock(Blocktopia.id("entity/signs/poisoned"), ModWoodSetTypes.POISONED, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    SignBlock POISONED_SIGN = register("poisoned_sign", new TerraformSignBlock(Blocktopia.id("entity/signs/poisoned"), ModWoodSetTypes.POISONED, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new SignItem(settings, block, POISONED_WALL_SIGN));
    WallSignBlock MAHOGANY_WALL_SIGN = registerWithoutItem("mahogany_wall_sign", new TerraformWallSignBlock(Blocktopia.id("entity/signs/mahogany"), ModWoodSetTypes.MAHOGANY, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    SignBlock MAHOGANY_SIGN = register("mahogany_sign", new TerraformSignBlock(Blocktopia.id("entity/signs/mahogany"), ModWoodSetTypes.MAHOGANY, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new SignItem(settings, block, MAHOGANY_WALL_SIGN));

    WallHangingSignBlock PALM_WALL_HANGING_SIGN = registerWithoutItem("palm_wall_hanging_sign", new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/palm"), Blocktopia.id("textures/gui/hanging_signs/palm"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock PALM_HANGING_SIGN = register("palm_hanging_sign", new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/palm"), Blocktopia.id("textures/gui/hanging_signs/palm"), ModWoodSetTypes.PALM, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new HangingSignItem(block, PALM_WALL_HANGING_SIGN, settings));
    WallHangingSignBlock BANANA_WALL_HANGING_SIGN = registerWithoutItem("banana_wall_hanging_sign", new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/banana"), Blocktopia.id("textures/gui/hanging_signs/banana"), ModWoodSetTypes.BANANA, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock BANANA_HANGING_SIGN = register("banana_hanging_sign", new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/banana"), Blocktopia.id("textures/gui/hanging_signs/banana"), ModWoodSetTypes.BANANA, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new HangingSignItem(block, BANANA_WALL_HANGING_SIGN, settings));
    WallHangingSignBlock CORN_WALL_HANGING_SIGN = registerWithoutItem("corn_wall_hanging_sign", new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/corn"), Blocktopia.id("textures/gui/hanging_signs/corn"), ModWoodSetTypes.CORN, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock CORN_HANGING_SIGN = register("corn_hanging_sign", new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/corn"), Blocktopia.id("textures/gui/hanging_signs/corn"), ModWoodSetTypes.CORN, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new HangingSignItem(block, CORN_WALL_HANGING_SIGN, settings));
    WallHangingSignBlock POISONED_WALL_HANGING_SIGN = registerWithoutItem("poisoned_wall_hanging_sign", new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/poisoned"), Blocktopia.id("textures/gui/hanging_signs/poisoned"), ModWoodSetTypes.POISONED, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock POISONED_HANGING_SIGN = register("poisoned_hanging_sign", new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/poisoned"), Blocktopia.id("textures/gui/hanging_signs/poisoned"), ModWoodSetTypes.POISONED, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new HangingSignItem(block, POISONED_WALL_HANGING_SIGN, settings));
    WallHangingSignBlock MAHOGANY_WALL_HANGING_SIGN = registerWithoutItem("mahogany_wall_hanging_sign", new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/mahogany"), Blocktopia.id("textures/gui/hanging_signs/mahogany"), ModWoodSetTypes.MAHOGANY, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    HangingSignBlock MAHOGANY_HANGING_SIGN = register("mahogany_hanging_sign", new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/mahogany"), Blocktopia.id("textures/gui/hanging_signs/mahogany"), ModWoodSetTypes.MAHOGANY, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)),
            new Item.Settings().maxCount(16), (block, settings) -> new HangingSignItem(block, MAHOGANY_WALL_HANGING_SIGN, settings));



    LeveledCauldronBlock TROPICAL_WATER_CAULDRON = ModBlocks.registerWithoutItem("tropical_water_cauldron",
            new LeveledCauldronBlock(Biome.Precipitation.RAIN, CauldronBehavior.WATER_CAULDRON_BEHAVIOR, AbstractBlock.Settings.copy(Blocks.CAULDRON)));


    static <T extends Block> T registerWithoutItem(String name, T block) {
        return Registry.register(Registries.BLOCK, Blocktopia.id(name), block);
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
            return register(name, block, settings, BlockItem::new);
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings, BiFunction<Block, Item.Settings, BlockItem> item) {
        T registered = registerWithoutItem(name, block);
        ModItems.register(name, item.apply(registered, settings));
        return registered;
    }

    static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings());
    }

    static ChairBlock[] register(String name, ChairBlock[] blocks) {
        for (ChairBlock block : blocks) {
            register((block.seat != block.plank ? Registries.BLOCK.getId(block.seat).getPath().split("wool")[0] : "") + name, block);
        }
        return blocks;
    }

    static Block createStrippableLogBlock(MapColor topMapColor, MapColor sideMapColor, Block stripped) {
        return new StrippableLogBlock(
                stripped, AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()
        );
    }

    static Block createWoodBlock(MapColor color) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }

    static Block createStrippableWoodBlock(MapColor color, Block stripped) {
        return new StrippableLogBlock(
                stripped, AbstractBlock.Settings.create()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }

    static Block createGlowingFlowerPotBlock(int luminance,Block flower) {
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)
                .luminance((state) -> luminance));
    }


    static void load() {}
}
