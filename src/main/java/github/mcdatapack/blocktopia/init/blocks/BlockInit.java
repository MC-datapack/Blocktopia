package github.mcdatapack.blocktopia.init.blocks;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.*;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.list.BlockSetTypeList;
import github.mcdatapack.blocktopia.list.WoodTypeList;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaHangingSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallHangingSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallSignBlock;
import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

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
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));
    public static final SaplingBlock FLOWERING_CHERRY_SAPLING = register("flowering_cherry_sapling", new SaplingBlock(
            new SaplingGenerator("flowering_cherry", 0.1F,
                    Optional.of(ConfiguredFeatureInit.FLOWERING_CHERRY_KEY), Optional.empty(),
                    Optional.of(TreeConfiguredFeatures.CHERRY), Optional.empty(),
                    Optional.of(TreeConfiguredFeatures.CHERRY_BEES_005), Optional.empty()), AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));
    public static final Block POTTED_FLOWERING_CHERRY_SAPLING = register("potted_flowering_cherry_sapling", Blocks.createFlowerPotBlock(FLOWERING_CHERRY_SAPLING));

    public static final FlowerBlock GLOW_FLOWER = register("glow_flower", new FlowerBlock(StatusEffects.GLOWING, 60.5F, AbstractBlock.Settings.create()
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance((state) -> 15)));
    public static final Block POTTED_GLOW_FLOWER = registerWithoutItem("potted_glow_flower", Blocks.createFlowerPotBlock(GLOW_FLOWER));


    public static final Block STRIPPED_PALM_LOG =  register("stripped_palm_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block PALM_LOG = register("palm_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_PALM_LOG));
    public static final Block STRIPPED_PALM_WOOD = register("stripped_palm_wood", createWoodBlock(MapColor.BROWN));
    public static final Block PALM_WOOD = register("palm_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_PALM_WOOD));
    public static final ExtendedLeavesBlock PALM_LEAVES = register("palm_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final SaplingBlock PALM_SAPLING = register("palm_sapling", new SaplingBlock(new SaplingGenerator(Blocktopia.id("palm").toString(),
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

    private static final Identifier PALM_SIGN_TEXTURE = Blocktopia.id("entity/signs/palm");
    private static final Identifier PALM_HANGING_SIGN_TEXTURE = Blocktopia.id("entity/signs/hanging/palm");
    private static final Identifier PALM_HANGING_SIGN_GUI_TEXTURE = Blocktopia.id("textures/gui/hanging_signs/palm");

    public static final BlocktopiaSignBlock PALM_SIGN = registerWithoutItem("palm_sign", new BlocktopiaSignBlock(PALM_SIGN_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaWallSignBlock PALM_WALL_SIGN = registerWithoutItem("palm_wall_sign", new BlocktopiaWallSignBlock(PALM_SIGN_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaHangingSignBlock PALM_HANGING_SIGN = registerWithoutItem("palm_hanging_sign", new BlocktopiaHangingSignBlock(PALM_HANGING_SIGN_TEXTURE, PALM_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaWallHangingSignBlock PALM_WALL_HANGING_SIGN = registerWithoutItem("palm_wall_hanging_sign", new BlocktopiaWallHangingSignBlock(PALM_HANGING_SIGN_TEXTURE, PALM_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));


    public static final Block STRIPPED_BANANA_LOG =  register("stripped_banana_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block BANANA_LOG = register("banana_log", createStrippableLogBlock(MapColor.BROWN, MapColor.BROWN, STRIPPED_BANANA_LOG));
    public static final Block STRIPPED_BANANA_WOOD = register("stripped_banana_wood", createWoodBlock(MapColor.BROWN));
    public static final Block BANANA_WOOD = register("banana_wood", createStrippableWoodBlock(MapColor.BROWN, STRIPPED_BANANA_WOOD));
    public static final ExtendedLeavesBlock BANANA_LEAVES = register("banana_leaves", new ExtendedLeavesBlock(AbstractBlock.Settings.create()
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final SaplingBlock BANANA_SAPLING = register("banana_sapling", new SaplingBlock(new SaplingGenerator(Blocktopia.id("banana").toString(),
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

    private static final Identifier BANANA_SIGN_TEXTURE = Blocktopia.id("entity/signs/banana");
    private static final Identifier BANANA_HANGING_SIGN_TEXTURE = Blocktopia.id("entity/signs/hanging/banana");
    private static final Identifier BANANA_HANGING_SIGN_GUI_TEXTURE = Blocktopia.id("textures/gui/hanging_signs/banana");

    public static final BlocktopiaSignBlock BANANA_SIGN = registerWithoutItem("banana_sign", new BlocktopiaSignBlock(BANANA_SIGN_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaWallSignBlock BANANA_WALL_SIGN = registerWithoutItem("banana_wall_sign", new BlocktopiaWallSignBlock(BANANA_SIGN_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaHangingSignBlock BANANA_HANGING_SIGN = registerWithoutItem("banana_hanging_sign", new BlocktopiaHangingSignBlock(BANANA_HANGING_SIGN_TEXTURE, BANANA_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final BlocktopiaWallHangingSignBlock BANANA_WALL_HANGING_SIGN = registerWithoutItem("banana_wall_hanging_sign", new BlocktopiaWallHangingSignBlock(BANANA_HANGING_SIGN_TEXTURE, BANANA_HANGING_SIGN_GUI_TEXTURE, AbstractBlock.Settings.create()
            .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));


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

    public static void load() {}
}
