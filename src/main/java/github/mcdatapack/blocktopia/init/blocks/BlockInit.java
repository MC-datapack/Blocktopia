package github.mcdatapack.blocktopia.init.blocks;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockInit {
    public static final FallingBlock PAPER_BLOCK = register("paper_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)) {
                @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock GUNPOWDER_BLOCK = register("gunpowder_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F)) {
                @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
    public static final FallingBlock FIREWORK_BLOCK = register("firework_block",
            new FallingBlock(AbstractBlock.Settings.copy(Blocks.SAND).strength(0.4F, 0.0F)) {
        @Override protected MapCodec<? extends FallingBlock> getCodec() {return null;}});
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

    public static final Block PALM_LOG = register("palm_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block STRIPPED_PALM_LOG =  register("stripped_palm_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final PillarBlock PALM_WOOD = register("palm_wood", new PillarBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS).burnable()));
    public static final PillarBlock STRIPPED_PALM_WOOD = register("stripped_palm_wood", new PillarBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0F).instrument(NoteBlockInstrument.BASS).burnable()));
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


    public static final Block BANANA_LOG = register("banana_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final Block STRIPPED_BANANA_LOG =  register("stripped_banana_log", Blocks.createLogBlock(MapColor.BROWN, MapColor.BROWN));
    public static final PillarBlock BANANA_WOOD = register("banana_wood", new PillarBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).strength(2.0F).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS).burnable()));
    public static final PillarBlock STRIPPED_BANANA_WOOD = register("stripped_banana_wood", new PillarBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0F).instrument(NoteBlockInstrument.BASS).burnable()));
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
    public static void load() {}
}
