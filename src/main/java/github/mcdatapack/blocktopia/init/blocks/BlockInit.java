package github.mcdatapack.blocktopia.init.blocks;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.*;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.list.BlockSetTypeList;
import github.mcdatapack.blocktopia.list.WoodTypeList;
import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import static github.mcdatapack.blocktopia.Blocktopia.LOGGER;

public class BlockInit {
    public static final ColoredFallingBlock PAPER_BLOCK = register("paper_block",
            new ColoredFallingBlock(new ColorCode(16777215), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)));
    public static final ColoredFallingBlock GUNPOWDER_BLOCK = register("gunpowder_block",
            new ColoredFallingBlock(new ColorCode(4276545), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)));
    public static final ColoredFallingBlock FIREWORK_BLOCK = register("firework_block",
            new ColoredFallingBlock(new ColorCode(16728385), AbstractBlock.Settings.copy(Blocks.SAND).strength(0.4F, 0.0F)));
    public static final SmallChestBlock SMALL_CHEST = register("small_chest", new SmallChestBlock(AbstractBlock.Settings.create()
            .strength(2.5F).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS).burnable()));
    public static final ExtendedRepeaterBlock EXTENDED_REPEATER_TICK = register("extended_repeater_tick",
            new ExtendedRepeaterBlock(AbstractBlock.Settings.create()
            .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    public static final ExtendedRepeaterBlockSecond EXTENDED_REPEATER_SECOND = register("extended_repeater_second",
            new ExtendedRepeaterBlockSecond(AbstractBlock.Settings.create()
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    public static final ExtendedRepeaterBlockMinute EXTENDED_REPEATER_MINUTE = register("extended_repeater_minute",
            new ExtendedRepeaterBlockMinute(AbstractBlock.Settings.create()
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));

    public static final ExtendedLeavesBlock FLOWERING_CHERRY_LEAVES = register("flowering_cherry_leaves", new ExtendedLeavesBlock(
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES).luminance(state -> Blocktopia.glowFloweringCherry)));
    public static final FloorExtendedSaplingBlock FLOWERING_CHERRY_SAPLING = register("flowering_cherry_sapling", new FloorExtendedSaplingBlock(
            new SaplingGenerator("flowering_cherry", 0.1F,
                    Optional.of(ConfiguredFeatureInit.FLOWERING_CHERRY_KEY), Optional.empty(),
                    Optional.of(TreeConfiguredFeatures.CHERRY), Optional.empty(),
                    Optional.of(TreeConfiguredFeatures.CHERRY_BEES_005), Optional.empty()), AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));
    public static final Block POTTED_FLOWERING_CHERRY_SAPLING = register("potted_flowering_cherry_sapling", Blocks.createFlowerPotBlock(FLOWERING_CHERRY_SAPLING));

    public static final Block SANDY_DIRT = register("sandy_dirt", new Block(AbstractBlock.Settings.copy(Blocks.DIRT)));

    public static final FlowerBlock GLOW_FLOWER = register("glow_flower", new FlowerBlock(StatusEffects.GLOWING, 60.5F, AbstractBlock.Settings.create()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance((state) -> 15)));
    public static final Block POTTED_GLOW_FLOWER = registerWithoutItem("potted_glow_flower", createGlowingFlowerPotBlock(15, GLOW_FLOWER));


    public static final Block STRIPPED_PALM_LOG =  register("stripped_palm_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block PALM_LOG = register("palm_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_PALM_LOG));
    public static final Block STRIPPED_PALM_WOOD = register("stripped_palm_wood", createWoodBlock(MapColor.BROWN));
    public static final Block PALM_WOOD = register("palm_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_PALM_WOOD));
    public static final ExtendedLeavesBlock PALM_LEAVES = register("palm_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final FloorExtendedSaplingBlock PALM_SAPLING = register("palm_sapling", new FloorExtendedSaplingBlock(new SaplingGenerator(Blocktopia.id("palm").toString(),
            0.1F, Optional.empty(), Optional.empty(), Optional.of(ConfiguredFeatureInit.PALM_TREE_KEY),
            Optional.empty(), Optional.empty(), Optional.empty()), AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    public static final Block POTTED_PALM_SAPLING = registerWithoutItem("potted_palm_sapling", Blocks.createFlowerPotBlock(PALM_SAPLING));
    public static final Block PALM_PLANKS = register("palm_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final DoorBlock PALM_DOOR = register("palm_door", new DoorBlock(BlockSetTypeList.PALM, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    public static final FenceBlock PALM_FENCE = register("palm_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceGateBlock PALM_FENCE_GATE = register("palm_fence_gate", new FenceGateBlock(WoodTypeList.PALM, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final StairsBlock PALM_STAIRS = register("palm_stairs", new StairsBlock(PALM_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    public static final SlabBlock PALM_SLAB = register("palm_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final PressurePlateBlock PALM_PRESSURE_PLATE = register("palm_pressure_plate", new PressurePlateBlock(BlockSetTypeList.PALM, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PALM_BUTTON = register("palm_button", Blocks.createWoodenButtonBlock(BlockSetTypeList.PALM));
    public static final TrapdoorBlock PALM_TRAPDOOR = register("palm_trapdoor", new TrapdoorBlock(BlockSetTypeList.PALM, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    public static final Block STRIPPED_BANANA_LOG =  register("stripped_banana_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block BANANA_LOG = register("banana_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_BANANA_LOG));
    public static final Block STRIPPED_BANANA_WOOD = register("stripped_banana_wood", createWoodBlock(MapColor.BROWN));
    public static final Block BANANA_WOOD = register("banana_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_BANANA_WOOD));
    public static final ExtendedLeavesBlock BANANA_LEAVES = register("banana_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> Blocktopia.glowBanana)));
    public static final FloorExtendedSaplingBlock BANANA_SAPLING = register("banana_sapling", new FloorExtendedSaplingBlock(new SaplingGenerator(Blocktopia.id("banana").toString(),
            0.1F, Optional.of(ConfiguredFeatureInit.BANANA_TREE_KEY), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty()), AbstractBlock.Settings.create()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    public static final Block POTTED_BANANA_SAPLING = registerWithoutItem("potted_banana_sapling", Blocks.createFlowerPotBlock(BANANA_SAPLING));
    public static final Block BANANA_PLANKS = register("banana_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final DoorBlock BANANA_DOOR = register("banana_door", new DoorBlock(BlockSetTypeList.BANANA, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    public static final FenceBlock BANANA_FENCE = register("banana_fence", new FenceBlock(AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final FenceGateBlock BANANA_FENCE_GATE = register("banana_fence_gate", new FenceGateBlock(WoodTypeList.BANANA, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final StairsBlock BANANA_STAIRS = register("banana_stairs", new StairsBlock(BANANA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    public static final SlabBlock BANANA_SLAB = register("banana_slab", new SlabBlock(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final PressurePlateBlock BANANA_PRESSURE_PLATE = register("banana_pressure_plate", new PressurePlateBlock(BlockSetTypeList.BANANA, AbstractBlock.Settings.create()
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BANANA_BUTTON = register("banana_button", Blocks.createWoodenButtonBlock(BlockSetTypeList.BANANA));
    public static final TrapdoorBlock BANANA_TRAPDOOR = register("banana_trapdoor", new TrapdoorBlock(BlockSetTypeList.BANANA, AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    public static final ChairBlock OAK_CHAIR = register("oak_chair", new ChairBlock(Blocks.OAK_PLANKS, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final ChairBlock SPRUCE_CHAIR = register("spruce_chair", new ChairBlock(Blocks.SPRUCE_PLANKS, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final ChairBlock BIRCH_CHAIR = register("birch_chair", new ChairBlock(Blocks.BIRCH_PLANKS, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final ChairBlock JUNGLE_CHAIR = register("jungle_chair", new ChairBlock(Blocks.JUNGLE_PLANKS, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final ChairBlock ACACIA_CHAIR = register("acacia_chair", new ChairBlock(Blocks.ACACIA_PLANKS, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final ChairBlock DARK_OAK_CHAIR = register("dark_oak_chair", new ChairBlock(Blocks.DARK_OAK_PLANKS, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final ChairBlock CRIMSON_CHAIR = register("crimson_chair", new ChairBlock(Blocks.CRIMSON_PLANKS, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final ChairBlock WARPED_CHAIR = register("warped_chair", new ChairBlock(Blocks.WARPED_PLANKS, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final ChairBlock MANGROVE_CHAIR = register("mangrove_chair", new ChairBlock(Blocks.MANGROVE_PLANKS, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final ChairBlock CHERRY_CHAIR = register("cherry_chair", new ChairBlock(Blocks.CHERRY_PLANKS, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final ChairBlock PALM_CHAIR = register("palm_chair", new ChairBlock(PALM_PLANKS, AbstractBlock.Settings.copy(PALM_PLANKS)));
    public static final ChairBlock BANANA_CHAIR = register("banana_chair", new ChairBlock(BANANA_PLANKS, AbstractBlock.Settings.copy(BANANA_PLANKS)));

    public static final XPTrapBlock XP_TRAP = register("xp_trap", new XPTrapBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));


    public static final LeveledCauldronBlock TROPICAL_WATER_CAULDRON = BlockInit.registerWithoutItem("tropical_water_cauldron",
            new LeveledCauldronBlock(Biome.Precipitation.RAIN, CauldronBehavior.WATER_CAULDRON_BEHAVIOR, AbstractBlock.Settings.copy(Blocks.CAULDRON)));


    public static <T extends Block> T registerWithoutItem(String name, T block) {
        return Registry.register(Registries.BLOCK, Blocktopia.id(name), block);
    }

    public static <T extends Block> T register(String name, T block, Item.Settings Settings) {
        T registered = registerWithoutItem(name, block);
        ItemInit.register(name, new BlockItem(registered, Settings));
        return registered;
    }

    public static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings());
    }

    public static Block createStrippableLogBlock(MapColor topMapColor, MapColor sideMapColor, Block stripped) {
        return new StrippableLogBlock(
                stripped, AbstractBlock.Settings.create()
                        .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sounds(BlockSoundGroup.WOOD)
                        .burnable()
        );
    }

    public static Block createWoodBlock(MapColor color) {
        return new PillarBlock(
                AbstractBlock.Settings.create()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }

    public static Block createStrippableWoodBlock(MapColor color, Block stripped) {
        return new StrippableLogBlock(
                stripped, AbstractBlock.Settings.create()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable()
        );
    }

    public static Block createGlowingFlowerPotBlock(int luminance,Block flower) {
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)
                .luminance((state) -> luminance));
    }

    public static void load() {}
}
