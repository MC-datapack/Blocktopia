package github.mcdatapack.blocktopia.block;

import com.mojang.datafixers.util.Either;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.*;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import github.mcdatapack.blocktopia.worldgen.tree.sapling.ModSaplingGenerators;
import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import github.mcdatapack.blocktopia.item.ModItems;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;
import static github.mcdatapack.blocktopia.block.MinecraftVersions.C0_0_13A_03;

public interface ModBlocks {
    LegacyCutterBlock LEGACY_CUTTER = register("legacy_cutter",
            settings -> new LegacyCutterBlock(settings
                    .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)));
    WoodCutterBlock WOODCUTTER = register("woodcutter", settings -> new WoodCutterBlock(settings
            .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)));

    GoldAnvilBlock GOLD_ANVIL = register("gold_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), GoldAnvilBlock::new);
    GoldAnvilBlock CHIPPED_GOLD_ANVIL = register("chipped_gold_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), GoldAnvilBlock::new);
    GoldAnvilBlock DAMAGED_GOLD_ANVIL = register("damaged_gold_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), GoldAnvilBlock::new);
    DiamondAnvilBlock DIAMOND_ANVIL = register("diamond_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), DiamondAnvilBlock::new);
    DiamondAnvilBlock CHIPPED_DIAMOND_ANVIL = register("chipped_diamond_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), DiamondAnvilBlock::new);
    DiamondAnvilBlock DAMAGED_DIAMOND_ANVIL = register("damaged_diamond_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), DiamondAnvilBlock::new);
    NetheriteAnvilBlock NETHERITE_ANVIL = register("netherite_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), NetheriteAnvilBlock::new);
    NetheriteAnvilBlock CHIPPED_NETHERITE_ANVIL = register("chipped_netherite_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), NetheriteAnvilBlock::new);
    NetheriteAnvilBlock DAMAGED_NETHERITE_ANVIL = register("damaged_netherite_anvil", AbstractBlock.Settings.copy(Blocks.ANVIL), NetheriteAnvilBlock::new);

    FluidTankBlock FLUID_TANK = register("fluid_tank", AbstractBlock.Settings.copy(Blocks.GLASS).strength(2.5f), FluidTankBlock::new);

    CarpetBlock TROPICAL_MOSS_CARPET = register("tropical_moss_carpet", AbstractBlock.Settings.copy(Blocks.MOSS_CARPET), CarpetBlock::new);
    CustomMossBlock TROPICAL_MOSS = register("tropical_moss", AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK),
            settings -> new CustomMossBlock(ModConfiguredFeatures.TROPICAL_MOSS_PATCH_BONEMEAL_KEY, settings));
    TropicalFarmLand TROPICAL_FARM_LAND = register("tropical_farm_land", AbstractBlock.Settings.copy(Blocks.FARMLAND), TropicalFarmLand::new);

    ColoredFallingBlock PAPER_BLOCK = register("paper_block", AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F),
            settings -> new ColoredFallingBlock(new ColorCode(16777215), settings));
    ColoredFallingBlock GUNPOWDER_BLOCK = register("gunpowder_block", AbstractBlock.Settings.copy(Blocks.SAND).strength(0.2F, 0.0F),
            settings -> new ColoredFallingBlock(new ColorCode(4276545), settings));
    ColoredFallingBlock FIREWORK_BLOCK = register("firework_block", AbstractBlock.Settings.copy(Blocks.SAND).strength(0.4F, 0.0F),
            settings -> new ColoredFallingBlock(new ColorCode(16728385), settings));
    SmallChestBlock SMALL_CHEST = register("small_chest", settings -> new SmallChestBlock(settings
            .strength(2.5F).sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BASS).burnable()));
    ExtendedRepeaterBlock EXTENDED_REPEATER_TICK = register("extended_repeater_tick",
            settings -> new ExtendedRepeaterBlock(settings
            .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    ExtendedRepeaterBlockSecond EXTENDED_REPEATER_SECOND = register("extended_repeater_second",
            settings -> new ExtendedRepeaterBlockSecond(settings
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    ExtendedRepeaterBlockMinute EXTENDED_REPEATER_MINUTE = register("extended_repeater_minute",
            settings -> new ExtendedRepeaterBlockMinute(settings
                    .breakInstantly().allowsSpawning(Blocks::never).instrument(NoteBlockInstrument.BASEDRUM).pistonBehavior(PistonBehavior.NORMAL)));
    SpongeTNTBlock SPONGE_TNT = register("sponge_tnt", AbstractBlock.Settings.copy(Blocks.TNT), SpongeTNTBlock::new);
    DuperBlock DUPER = register("duper", AbstractBlock.Settings.copy(Blocks.BEDROCK).strength(5000), DuperBlock::new);

    BananaCropBlock BANANA_CROP = register("banana_crop", AbstractBlock.Settings.copy(Blocks.WHEAT), BananaCropBlock::new,
            settings -> settings, AliasedBlockItem::new);

    ExtendedLeavesBlock FLOWERING_CHERRY_LEAVES = register("flowering_cherry_leaves",
            AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES).luminance(state -> BlocktopiaConfig.getConfig().glowingFloweringCherryLeaves),
            ExtendedLeavesBlock::new);
    FloorExtendedSaplingBlock FLOWERING_CHERRY_SAPLING = register("flowering_cherry_sapling", AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING),
            settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.FLOWERING_CHERRY, settings));
    Block POTTED_FLOWERING_CHERRY_SAPLING = registerWithoutItem("potted_flowering_cherry_sapling", createFlowerPotSettings(),
            settings -> new FlowerPotBlock(FLOWERING_CHERRY_SAPLING, settings));

    Block SANDY_DIRT = register("sandy_dirt", AbstractBlock.Settings.copy(Blocks.SAND), Block::new);

    WaterAllowingFlowerBlock GLOW_FLOWER = register("glow_flower", settings -> new WaterAllowingFlowerBlock(StatusEffects.GLOWING, 60.5F, settings
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance((state) -> 15)));
    Block POTTED_GLOW_FLOWER = registerWithoutItem("potted_glow_flower", createFlowerPotSettings().luminance(state -> 15),
            settings -> new FlowerPotBlock(GLOW_FLOWER, settings));


    Block STRIPPED_PALM_LOG =  register("stripped_palm_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block PALM_LOG = register("palm_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block STRIPPED_PALM_WOOD = register("stripped_palm_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    Block PALM_WOOD = register("palm_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    ExtendedLeavesBlock PALM_LEAVES = register("palm_leaves", settings -> new ExtendedLeavesBlock(settings
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    FloorExtendedSaplingBlock PALM_SAPLING = register("palm_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.PALM, settings
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_PALM_SAPLING = registerWithoutItem("potted_palm_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(PALM_SAPLING, settings));
    Block PALM_PLANKS = register("palm_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new);
    DoorBlock PALM_DOOR = register("palm_door", settings -> new DoorBlock(ModBlockSetTypes.PALM, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock PALM_FENCE = register("palm_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock PALM_FENCE_GATE = register("palm_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.PALM, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock PALM_STAIRS = register("palm_stairs", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS),
            settings -> new StairsBlock(PALM_PLANKS.getDefaultState(), settings));
    SlabBlock PALM_SLAB = register("palm_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock PALM_PRESSURE_PLATE = register("palm_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.PALM, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block PALM_BUTTON = register("palm_button", createButtonSettings(), settings -> new ButtonBlock(ModBlockSetTypes.PALM, 30, settings));
    TrapdoorBlock PALM_TRAPDOOR = register("palm_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.PALM, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_BANANA_LOG =  register("stripped_banana_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block BANANA_LOG = register("banana_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block STRIPPED_BANANA_WOOD = register("stripped_banana_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    Block BANANA_WOOD = register("banana_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    ExtendedLeavesBlock BANANA_LEAVES = register("banana_leaves", settings -> new ExtendedLeavesBlock(settings
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingBananaLeaves)));
    FloorExtendedSaplingBlock BANANA_SAPLING = register("banana_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.BANANA, settings
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_BANANA_SAPLING = registerWithoutItem("potted_banana_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(BANANA_SAPLING, settings));
    Block BANANA_PLANKS = register("banana_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new);
    DoorBlock BANANA_DOOR = register("banana_door", settings -> new DoorBlock(ModBlockSetTypes.BANANA, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock BANANA_FENCE = register("banana_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock BANANA_FENCE_GATE = register("banana_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.BANANA, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock BANANA_STAIRS = register("banana_stairs", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS),
            settings -> new StairsBlock(BANANA_PLANKS.getDefaultState(), settings));
    SlabBlock BANANA_SLAB = register("banana_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock BANANA_PRESSURE_PLATE = register("banana_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.BANANA, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block BANANA_BUTTON = register("banana_button", createButtonSettings(), settings -> new ButtonBlock(ModBlockSetTypes.BANANA, 30, settings));
    TrapdoorBlock BANANA_TRAPDOOR = register("banana_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.BANANA, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_CORN_LOG =  register("stripped_corn_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block CORN_LOG = register("corn_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block STRIPPED_CORN_WOOD = register("stripped_corn_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    Block CORN_WOOD = register("corn_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    ExtendedLeavesBlock CORN_LEAVES = register("corn_leaves", settings -> new ExtendedLeavesBlock(settings
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingCornLeaves)));
    FloorExtendedSaplingBlock CORN_SAPLING = register("corn_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.CORN, settings
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_CORN_SAPLING = registerWithoutItem("potted_corn_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(CORN_SAPLING, settings));
    Block CORN_PLANKS = register("corn_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new);
    DoorBlock CORN_DOOR = register("corn_door", settings -> new DoorBlock(ModBlockSetTypes.CORN, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock CORN_FENCE = register("corn_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock CORN_FENCE_GATE = register("corn_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.CORN, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock CORN_STAIRS = register("corn_stairs", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS),
            settings -> new StairsBlock(CORN_PLANKS.getDefaultState(), settings));
    SlabBlock CORN_SLAB = register("corn_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock CORN_PRESSURE_PLATE = register("corn_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.CORN, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block CORN_BUTTON = register("corn_button", createButtonSettings(), settings -> new ButtonBlock(ModBlockSetTypes.CORN, 30, settings));
    TrapdoorBlock CORN_TRAPDOOR = register("corn_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.CORN, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));


    Block STRIPPED_POISONED_LOG =  register("stripped_poisoned_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block POISONED_LOG = register("poisoned_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block STRIPPED_POISONED_WOOD = register("stripped_poisoned_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    Block POISONED_WOOD = register("poisoned_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    ExtendedLeavesBlock POISONED_LEAVES = register("poisoned_leaves", settings -> new ExtendedLeavesBlock(settings
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingPoisonedLeaves)));
    FloorExtendedSaplingBlock POISONED_SAPLING = register("poisoned_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.POISONED, settings
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_POISONED_SAPLING = registerWithoutItem("potted_poisoned_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(POISONED_SAPLING, settings));
    Block POISONED_PLANKS = register("poisoned_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new);
    DoorBlock POISONED_DOOR = register("poisoned_door", settings -> new DoorBlock(ModBlockSetTypes.POISONED, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock POISONED_FENCE = register("poisoned_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock POISONED_FENCE_GATE = register("poisoned_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.POISONED, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock POISONED_STAIRS = register("poisoned_stairs", AbstractBlock.Settings.copy(Blocks.OAK_DOOR),
            settings -> new StairsBlock(POISONED_PLANKS.getDefaultState(), settings));
    SlabBlock POISONED_SLAB = register("poisoned_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock POISONED_PRESSURE_PLATE = register("poisoned_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.POISONED, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block POISONED_BUTTON = register("poisoned_button", createButtonSettings(), settings -> new ButtonBlock(ModBlockSetTypes.POISONED, 30, settings));

    TrapdoorBlock POISONED_TRAPDOOR = register("poisoned_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.POISONED, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));

    Block STRIPPED_MAHOGANY_LOG =  register("stripped_mahogany_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);

    Block MAHOGANY_LOG = register("mahogany_log", createLogSettings(MapColor.BROWN, MapColor.BROWN), PillarBlock::new);
    Block STRIPPED_MAHOGANY_WOOD = register("stripped_mahogany_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    Block MAHOGANY_WOOD = register("mahogany_wood", createWoodSettings(MapColor.BROWN), PillarBlock::new);
    ExtendedLeavesBlock MAHOGANY_LEAVES = register("mahogany_leaves", settings -> new ExtendedLeavesBlock(settings
            .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)
            .luminance(state -> BlocktopiaConfig.getConfig().glowingMahoganyLeaves)));
    FloorExtendedSaplingBlock MAHOGANY_SAPLING = register("mahogany_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.MAHOGANY, settings
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
            .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()));
    Block POTTED_MAHOGANY_SAPLING = registerWithoutItem("potted_mahogany_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(MAHOGANY_SAPLING, settings));

    Block MAHOGANY_PLANKS = register("mahogany_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new);
    DoorBlock MAHOGANY_DOOR = register("mahogany_door", settings -> new DoorBlock(ModBlockSetTypes.MAHOGANY, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)));
    FenceBlock MAHOGANY_FENCE = register("mahogany_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    FenceGateBlock MAHOGANY_FENCE_GATE = register("mahogany_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.MAHOGANY, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    StairsBlock MAHOGANY_STAIRS = register("mahogany_stairs", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS),
            settings -> new StairsBlock(MAHOGANY_PLANKS.getDefaultState(), settings));
    SlabBlock MAHOGANY_SLAB = register("mahogany_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    PressurePlateBlock MAHOGANY_PRESSURE_PLATE = register("mahogany_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.MAHOGANY, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    Block MAHOGANY_BUTTON = register("mahogany_button", settings -> new ButtonBlock(ModBlockSetTypes.MAHOGANY, 30, settings));
    TrapdoorBlock MAHOGANY_TRAPDOOR = register("mahogany_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.MAHOGANY, settings
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
    ChairBlock[] PALE_OAK_CHAIR = register("pale_oak_chair", ChairBlock.ChairBlocks.create(FutureBlocks.PALE_OAK_PLANKS));
    ChairBlock[] WOODEN_CHAIR_RD20090515 = register("wooden_chair_rd20090515", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.WOODEN_PLANKS_RD20090515, RD20090515, RD160052));
    ChairBlock[] WOODEN_CHAIR_RD161348 = register("wooden_chair_rd161348", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.WOODEN_PLANKS_RD161348, RD161348, C0_0_13A_03));
    ChairBlock[] WOODEN_CHAIR_C0_0_14A = register("wooden_chair_c0_0_14a", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.WOODEN_PLANKS_C0_0_14A, C0_0_14A, C0_0_14A_08));
    ChairBlock[] WOODEN_CHAIR_C0_0_15A = register("wooden_chair_c0_0_15a", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.WOODEN_PLANKS_C0_0_15A, C0_0_15A, B1_9PRE4));
    ChairBlock[] WOODEN_CHAIR_B1_9PRE5 = register("wooden_chair_b1_9pre5", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.WOODEN_PLANKS_B1_9PRE5, B1_9PRE5, _1_13_2));
    ChairBlock[] BIRCH_CHAIR_1_2_4 = register("birch_chair_1_2_4", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.BIRCH_PLANKS_1_2_4, _1_2_4, _1_13_2));
    ChairBlock[] SPRUCE_CHAIR_1_2_4 = register("spruce_chair_1_2_4", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.SPRUCE_PLANKS_1_2_4, _1_2_4, _1_13_2));
    ChairBlock[] JUNGLE_CHAIR_1_2_4 = register("jungle_chair_1_2_4", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.JUNGLE_PLANKS_1_2_4, _1_2_4, _1_13_2));
    ChairBlock[] ACACIA_CHAIR_1_7 = register("acacia_chair_1_7", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.ACACIA_PLANKS_1_7, _1_7, _1_13_2));
    ChairBlock[] DARK_OAK_CHAIR_1_7 = register("dark_oak_chair_1_7", ChairBlock.ChairBlocks.createLegacy(LegacyBlocks.DARK_OAK_PLANKS_1_7, _1_7, _1_13_2));

    XPTrapBlock XP_TRAP = register("xp_trap", settings -> new XPTrapBlock(settings
            .mapColor(MapColor.BLACK)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(50.0F, 1200.0F)));

    WallSignBlock PALM_WALL_SIGN = registerWithoutItem("palm_wall_sign",
            settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/palm"), ModWoodSetTypes.PALM, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    SignBlock PALM_SIGN = register("palm_sign",
            settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/palm"), ModWoodSetTypes.PALM, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16), (block, settings) -> new SignItem(settings, block, PALM_WALL_SIGN));

    WallSignBlock BANANA_WALL_SIGN = registerWithoutItem("banana_wall_sign",
            settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/banana"), ModWoodSetTypes.BANANA, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    SignBlock BANANA_SIGN = register("banana_sign",
            settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/banana"), ModWoodSetTypes.BANANA, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16), (block, settings) -> new SignItem(settings, block, BANANA_WALL_SIGN));

    WallSignBlock CORN_WALL_SIGN = registerWithoutItem("corn_wall_sign",
            settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/corn"), ModWoodSetTypes.CORN, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    SignBlock CORN_SIGN = register("corn_sign",
            settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/corn"), ModWoodSetTypes.CORN, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16), (block, settings) -> new SignItem(settings, block, CORN_WALL_SIGN));

    //WallSignBlock POISONED_WALL_SIGN = registerWithoutItem("poisoned_wall_sign",
    //        settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/poisoned"), ModWoodSetTypes.POISONED, settings
    //                .solid()
    //                .instrument(NoteBlockInstrument.BASS)
    //                .noCollision()
    //                .strength(1.0F)
    //                .burnable()));
    //SignBlock POISONED_SIGN = register("poisoned_sign",
    //        settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/poisoned"), ModWoodSetTypes.POISONED, settings
    //                .solid()
    //                .instrument(NoteBlockInstrument.BASS)
    //                .noCollision()
    //                .strength(1.0F)
    //                .burnable()),
    //        settings -> settings.maxCount(16), (block, settings) -> new SignItem(settings, block, POISONED_WALL_SIGN));

    WallSignBlock MAHOGANY_WALL_SIGN = registerWithoutItem("mahogany_wall_sign",
            settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/mahogany"), ModWoodSetTypes.MAHOGANY, settings
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable()));
    SignBlock MAHOGANY_SIGN = register("mahogany_sign",
            settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/mahogany"), ModWoodSetTypes.MAHOGANY, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16), (block, settings) -> new SignItem(settings, block, MAHOGANY_WALL_SIGN));


    WallHangingSignBlock PALM_WALL_HANGING_SIGN = registerWithoutItem("palm_wall_hanging_sign",
            settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/palm"),
                    Blocktopia.id("textures/gui/hanging_signs/palm"), ModWoodSetTypes.PALM, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    HangingSignBlock PALM_HANGING_SIGN = register("palm_hanging_sign",
            settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/palm"),
                    Blocktopia.id("textures/gui/hanging_signs/palm"), ModWoodSetTypes.PALM, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16),
            (block, settings) -> new HangingSignItem(block, PALM_WALL_HANGING_SIGN, settings));

    WallHangingSignBlock BANANA_WALL_HANGING_SIGN = registerWithoutItem("banana_wall_hanging_sign",
            settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/banana"),
                    Blocktopia.id("textures/gui/hanging_signs/banana"), ModWoodSetTypes.BANANA, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    HangingSignBlock BANANA_HANGING_SIGN = register("banana_hanging_sign",
            settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/banana"),
                    Blocktopia.id("textures/gui/hanging_signs/banana"), ModWoodSetTypes.BANANA, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16),
            (block, settings) -> new HangingSignItem(block, BANANA_WALL_HANGING_SIGN, settings));

    WallHangingSignBlock CORN_WALL_HANGING_SIGN = registerWithoutItem("corn_wall_hanging_sign",
            settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/corn"),
                    Blocktopia.id("textures/gui/hanging_signs/corn"), ModWoodSetTypes.CORN, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()));
    HangingSignBlock CORN_HANGING_SIGN = register("corn_hanging_sign",
            settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/corn"),
                    Blocktopia.id("textures/gui/hanging_signs/corn"), ModWoodSetTypes.CORN, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16),
            (block, settings) -> new HangingSignItem(block, CORN_WALL_HANGING_SIGN, settings));

    //WallHangingSignBlock POISONED_WALL_HANGING_SIGN = registerWithoutItem("poisoned_wall_hanging_sign",
    //        settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/poisoned"),
    //                Blocktopia.id("textures/gui/hanging_signs/poisoned"), ModWoodSetTypes.POISONED, settings
    //                .solid()
    //                .instrument(NoteBlockInstrument.BASS)
    //                .noCollision()
    //                .strength(1.0F)
    //                .burnable()));
    //HangingSignBlock POISONED_HANGING_SIGN = register("poisoned_hanging_sign",
    //        settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/poisoned"),
    //                Blocktopia.id("textures/gui/hanging_signs/poisoned"), ModWoodSetTypes.POISONED, settings
    //                .solid()
    //                .instrument(NoteBlockInstrument.BASS)
    //                .noCollision()
    //                .strength(1.0F)
    //                .burnable()),
    //        settings -> settings.maxCount(16),
    //        (block, settings) -> new HangingSignItem(block, POISONED_WALL_HANGING_SIGN, settings));

    WallHangingSignBlock MAHOGANY_WALL_HANGING_SIGN = registerWithoutItem("mahogany_wall_hanging_sign",
            settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/mahogany"),
                    Blocktopia.id("textures/gui/hanging_signs/mahogany"), ModWoodSetTypes.MAHOGANY, settings
                            .solid()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollision()
                            .strength(1.0F)
                            .burnable()));
    HangingSignBlock MAHOGANY_HANGING_SIGN = register("mahogany_hanging_sign",
            settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/mahogany"),
                    Blocktopia.id("textures/gui/hanging_signs/mahogany"), ModWoodSetTypes.MAHOGANY, settings
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(1.0F)
                    .burnable()),
            settings -> settings.maxCount(16),
            (block, settings) -> new HangingSignItem(block, MAHOGANY_WALL_HANGING_SIGN, settings));

    HangingMossBlock BANANA_HANGING_MOSS = register("banana_hanging_moss", settings -> new HangingMossBlock(settings
            .breakInstantly()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.GRASS)));
    HangingMossBlock CORN_HANGING_MOSS = register("corn_hanging_moss", settings -> new HangingMossBlock(settings
            .breakInstantly()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.GRASS)));
    HangingMossBlock POISONED_HANGING_MOSS = register("poisoned_hanging_moss", settings -> new HangingMossBlock(settings
            .breakInstantly()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.GRASS)));
    HangingMossBlock MAHOGANY_HANGING_MOSS = register("mahogany_hanging_moss", settings -> new HangingMossBlock(settings
            .breakInstantly()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.GRASS)));
    HangingMossBlock FLOWERING_CHERRY_HANGING_MOSS = register("flowering_cherry_hanging_moss", settings -> new HangingMossBlock(settings
            .breakInstantly()
            .noCollision()
            .pistonBehavior(PistonBehavior.DESTROY)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.CHERRY_LEAVES)));


    VerticalSlabBlock VERTICAL_OAK_SLAB = registerVerticalSlab(Blocks.OAK_SLAB);
    VerticalSlabBlock VERTICAL_SPRUCE_SLAB = registerVerticalSlab(Blocks.SPRUCE_SLAB);
    VerticalSlabBlock VERTICAL_BIRCH_SLAB = registerVerticalSlab(Blocks.BIRCH_SLAB);
    VerticalSlabBlock VERTICAL_JUNGLE_SLAB = registerVerticalSlab(Blocks.JUNGLE_SLAB);
    VerticalSlabBlock VERTICAL_ACACIA_SLAB = registerVerticalSlab(Blocks.ACACIA_SLAB);
    VerticalSlabBlock VERTICAL_DARK_OAK_SLAB = registerVerticalSlab(Blocks.DARK_OAK_SLAB);
    VerticalSlabBlock VERTICAL_MANGROVE_SLAB = registerVerticalSlab(Blocks.MANGROVE_SLAB);
    VerticalSlabBlock VERTICAL_CHERRY_SLAB = registerVerticalSlab(Blocks.CHERRY_SLAB);
    VerticalSlabBlock VERTICAL_BAMBOO_SLAB = registerVerticalSlab(Blocks.BAMBOO_SLAB);
    VerticalSlabBlock VERTICAL_BAMBO_MOSAIC_SLAB = registerVerticalSlab(Blocks.BAMBOO_MOSAIC_SLAB);
    VerticalSlabBlock VERTICAL_CRIMSON_SLAB = registerVerticalSlab(Blocks.CRIMSON_SLAB);
    VerticalSlabBlock VERTICAL_WARPED_SLAB = registerVerticalSlab(Blocks.WARPED_SLAB);
    VerticalSlabBlock VERTICAL_STONE_SLAB = registerVerticalSlab(Blocks.STONE_SLAB);
    VerticalSlabBlock VERTICAL_COBBLESTONE_SLAB = registerVerticalSlab(Blocks.COBBLESTONE_SLAB);
    VerticalSlabBlock VERTICAL_MOSSY_COBBLESTONE_SLAB = registerVerticalSlab(Blocks.MOSSY_COBBLESTONE_SLAB);
    VerticalSlabBlock VERTICAL_SMOOTH_STONE_SLAB = registerVerticalSlab(Blocks.SMOOTH_STONE_SLAB);
    VerticalSlabBlock VERTICAL_STONE_BRICK_SLAB = registerVerticalSlab(Blocks.STONE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_MOSSY_STONE_BRICK_SLAB = registerVerticalSlab(Blocks.MOSSY_STONE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_GRANITE_SLAB = registerVerticalSlab(Blocks.GRANITE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_GRANITE_SLAB = registerVerticalSlab(Blocks.POLISHED_GRANITE_SLAB);
    VerticalSlabBlock VERTICAL_DIORITE_SLAB = registerVerticalSlab(Blocks.DIORITE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_DIORITE_SLAB = registerVerticalSlab(Blocks.POLISHED_DIORITE_SLAB);
    VerticalSlabBlock VERTICAL_ANDESITE_SLAB = registerVerticalSlab(Blocks.ANDESITE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_ANDESITE_SLAB = registerVerticalSlab(Blocks.POLISHED_ANDESITE_SLAB);
    VerticalSlabBlock VERTICAL_COBBLED_DEEPSLATE_SLAB = registerVerticalSlab(Blocks.COBBLED_DEEPSLATE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_DEEPSLATE_SLAB = registerVerticalSlab(Blocks.POLISHED_DEEPSLATE_SLAB);
    VerticalSlabBlock VERTICAL_DEEPSLATE_BRICK_SLAB = registerVerticalSlab(Blocks.DEEPSLATE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_DEEPSLATE_TILE_SLAB = registerVerticalSlab(Blocks.DEEPSLATE_TILE_SLAB);
    VerticalSlabBlock VERTICAL_TUFF_SLAB = registerVerticalSlab(Blocks.TUFF_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_TUFF_SLAB = registerVerticalSlab(Blocks.POLISHED_TUFF_SLAB);
    VerticalSlabBlock VERTICAL_TUFF_BRICK_SLAB = registerVerticalSlab(Blocks.TUFF_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_BRICK_SLAB = registerVerticalSlab(Blocks.BRICK_SLAB);
    VerticalSlabBlock VERTICAL_MUD_BRICK_SLAB = registerVerticalSlab(Blocks.MUD_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_SANDSTONE_SLAB = registerVerticalSlab(Blocks.SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_SMOOTH_SANDSTONE_SLAB = registerVerticalSlab(Blocks.SMOOTH_SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_CUT_SANDSTONE_SLAB = registerVerticalSlab(Blocks.CUT_SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_RED_SANDSTONE_SLAB = registerVerticalSlab(Blocks.RED_SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = registerVerticalSlab(Blocks.SMOOTH_RED_SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_CUT_RED_SANDSTONE_SLAB = registerVerticalSlab(Blocks.CUT_RED_SANDSTONE_SLAB);
    VerticalSlabBlock VERTICAL_PRISMARINE_SLAB = registerVerticalSlab(Blocks.PRISMARINE_SLAB);
    VerticalSlabBlock VERTICAL_BRISMARINE_BRICK_SLAB = registerVerticalSlab(Blocks.PRISMARINE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_DARK_PRISMARINE_SLAB = registerVerticalSlab(Blocks.DARK_PRISMARINE_SLAB);
    VerticalSlabBlock VERTICAL_NETHER_BRICK_SLAB = registerVerticalSlab(Blocks.NETHER_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_RED_NETHER_BRICK_SLAB = registerVerticalSlab(Blocks.RED_NETHER_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_BLACKSTONE_SLAB = registerVerticalSlab(Blocks.BLACKSTONE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_BLACKSTONE_SLAB = registerVerticalSlab(Blocks.POLISHED_BLACKSTONE_SLAB);
    VerticalSlabBlock VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = registerVerticalSlab(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_ENDSTONE_BRICK_SLAB = registerVerticalSlab(Blocks.END_STONE_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_PURPUR_SLAB = registerVerticalSlab(Blocks.PURPUR_SLAB);
    VerticalSlabBlock VERTICAL_QUARTZ_SLAB = registerVerticalSlab(Blocks.QUARTZ_SLAB);
    VerticalSlabBlock VERTICAL_SMOOTH_QUARTZ_SLAB = registerVerticalSlab(Blocks.SMOOTH_QUARTZ_SLAB);
    VerticalSlabBlock VERTICAL_CUT_COPPER_SLAB = register("vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock EXPOSED_VERTICAL_CUT_COPPER_SLAB = register("exposed_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock WEATHERED_VERTICAL_CUT_COPPER_SLAB = register("weathered_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock OXIDIZED_VERTICAL_CUT_COPPER_SLAB = register("oxidized_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock WAXED_VERTICAL_CUT_COPPER_SLAB = register("waxed_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock WAXED_EXPOSED_VERTICAL_CUT_COPPER_SLAB = register("waxed_exposed_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock WAXED_WEATHERED_VERTICAL_CUT_COPPER_SLAB = register("waxed_weathered_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock WAXED_OXIDIZED_VERTICAL_CUT_COPPER_SLAB = register("waxed_oxidized_vertical_cut_copper_slab", AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER_SLAB), VerticalSlabBlock::new);
    VerticalSlabBlock VERTICAL_COBBLESTONE_SLAB_RD20090515 = registerLegacyVerticalSlab(LegacyBlocks.COBBLESTONE_SLAB_RD20090515);
    VerticalSlabBlock VERTICAL_COBBLESTONE_SLAB_B1_3 = registerLegacyVerticalSlab(LegacyBlocks.COBBLESTONE_SLAB_B1_3);
    VerticalSlabBlock VERTICAL_COBBLESTONE_SLAB_B1_7 = registerLegacyVerticalSlab(LegacyBlocks.COBBLESTONE_B1_7);
    VerticalSlabBlock VERTICAL_WOODEN_SLAB_RD20090515 = registerLegacyVerticalSlab(LegacyBlocks.WOODEN_SLAB_RD20090515);
    VerticalSlabBlock VERTICAL_WOODEN_SLAB_RD161348 = registerLegacyVerticalSlab(LegacyBlocks.WOODEN_SLAB_RD161348);
    VerticalSlabBlock VERTICAL_WOODEN_SLAB_C0_0_14A = registerLegacyVerticalSlab(LegacyBlocks.WOODEN_SLAB_C0_0_14A);
    VerticalSlabBlock VERTICAL_WOODEN_SLAB_B1_3 = registerLegacyVerticalSlab(LegacyBlocks.WOODEN_SLAB_B1_3);
    VerticalSlabBlock VERTICAL_WOODEN_SLAB_B1_9PRE5 = registerLegacyVerticalSlab(LegacyBlocks.WOODEN_SLAB_B1_9PRE5);
    VerticalSlabBlock VERTICAL_SANDSTONE_SLAB_B1_3 = registerLegacyVerticalSlab(LegacyBlocks.SANDSTONE_SLAB_B1_3);
    VerticalSlabBlock VERTICAL_SANDSTONE_SLAB_1_2_4 = registerLegacyVerticalSlab(LegacyBlocks.SANDSTONE_SLAB_1_2_4);
    VerticalSlabBlock VERTICAL_BRICK_SLAB_C0_26ST = registerLegacyVerticalSlab(LegacyBlocks.BRICK_SLAB_C0_26ST);
    VerticalSlabBlock VERTICAL_BRICK_SLAB_B1_8 = registerLegacyVerticalSlab(LegacyBlocks.BRICK_SLAB_B1_8);
    VerticalSlabBlock VERTICAL_STONE_BRICK_SLAB_B1_8 = registerLegacyVerticalSlab(LegacyBlocks.STONE_BRICK_SLAB_B1_8);
    VerticalSlabBlock VERTICAL_BIRCH_SLAB_1_3 = registerLegacyVerticalSlab(LegacyBlocks.BIRCH_SLAB_1_3);
    VerticalSlabBlock VERTICAL_SPRUCE_SLAB_1_3 = registerLegacyVerticalSlab(LegacyBlocks.SPRUCE_SLAB_1_3);
    VerticalSlabBlock VERTICAL_JUNGLE_SLAB_1_3 = registerLegacyVerticalSlab(LegacyBlocks.JUNGLE_SLAB_1_3);
    VerticalSlabBlock VERTICAL_NETHER_BRICK_SLAB_1_4_6 = registerLegacyVerticalSlab(LegacyBlocks.NETHER_BRICK_SLAB_1_4_6);
    VerticalSlabBlock VERTICAL_RED_SANDSTONE_SLAB_1_8 = registerLegacyVerticalSlab(LegacyBlocks.RED_SANDSTONE_SLAB_1_8);
    VerticalSlabBlock VERTICAL_PURPUR_SLAB_1_9 = registerLegacyVerticalSlab(LegacyBlocks.PURPUR_SLAB_1_9);
    VerticalSlabBlock VERTICAL_PRISMARINE_SLAB_1_13 = registerLegacyVerticalSlab(LegacyBlocks.PRISMARINE_SLAB_1_13);
    VerticalSlabBlock VERTICAL_PALE_OAK_SLAB = registerLegacyVerticalSlab(FutureBlocks.PALE_OAK_SLAB);
    VerticalSlabBlock VERTICAL_RESIN_BRICK_SLAB = registerLegacyVerticalSlab(FutureBlocks.RESIN_BRICK_SLAB);
    VerticalSlabBlock VERTICAL_PALM_SLAB = registerVerticalSlab(PALM_SLAB);
    VerticalSlabBlock VERTICAL_BANANA_SLAB = registerVerticalSlab(BANANA_SLAB);
    VerticalSlabBlock VERTICAL_CORN_SLAB = registerVerticalSlab(CORN_SLAB);
    VerticalSlabBlock VERTICAL_POISONED_SLAB = registerVerticalSlab(POISONED_SLAB);
    VerticalSlabBlock VERTICAL_MAHOGANY_SLAB = registerVerticalSlab(MAHOGANY_SLAB);

    static <T extends Block> T registerWithoutItem(String name, Function<AbstractBlock.Settings, @NotNull T> block) {
        return Registry.register(Registries.BLOCK, Blocktopia.id(name), block.apply(AbstractBlock.Settings.create()));
    }

    static <T extends Block> T registerWithoutItem(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings,  @NotNull T> block) {
        return Registry.register(Registries.BLOCK, Blocktopia.id(name), block.apply(settings));
    }

    static <T extends Block> T register(String name, Function<AbstractBlock.Settings, @NotNull T> block, Function<Item.Settings, Item.Settings> settings) {
        return register(name, block, settings, BlockItem::new);
    }

    static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, @NotNull T> block, Function<Item.Settings, Item.Settings> itemSettings) {
        return register(name, settings, block, itemSettings, BlockItem::new);
    }

    static <T extends Block> T register(String name, Function<AbstractBlock.Settings, @NotNull T> block, Function<Item.Settings, Item.Settings> settings, BiFunction<Block, Item.Settings, BlockItem> item) {
        T registered = registerWithoutItem(name, block);
        ModItems.register(name, settings.apply(new Item.Settings()), settings1 -> item.apply(registered, settings1));
        return registered;
    }

    static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, @NotNull T> block, Function<Item.Settings, Item.Settings> itemSettings, BiFunction<Block, Item.Settings, BlockItem> item) {
        T registered = registerWithoutItem(name, settings, block);
        ModItems.register(name, itemSettings.apply(new Item.Settings()), settings1 -> item.apply(registered, settings1));
        return registered;
    }

    static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, @NotNull T> block) {
        return register(name, settings, block, itemSettings -> itemSettings);
    }

    static <T extends Block> T register(String name, Function<AbstractBlock.Settings, @NotNull T> block) {
        return register(name, block, settings -> settings);
    }

    static ChairBlock[] register(String name, Function[] blocks) {
        ChairBlock[] ret = new ChairBlock[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            Function<AbstractBlock.Settings, ChairBlock> blockFunction = blocks[i];
            ChairBlock block = blockFunction.apply(AbstractBlock.Settings.create());
            ret[i] = register((block.seat != block.plank ?
                    (Registries.BLOCK.getId(block.seat).getPath().contains("wool") ? Registries.BLOCK.getId(block.seat).getPath().split("wool")[0]
                            : Registries.BLOCK.getId(block.seat).getPath().split("cloth")[0]) : "") + name, settings -> block);
        }
        return ret;
    }

    static VerticalSlabBlock registerVerticalSlab(Block slab) {
        String name = Registries.BLOCK.getId(slab).getPath();
        return register("vertical_" + name, AbstractBlock.Settings.copy(slab), VerticalSlabBlock::new);
    }

    static VerticalSlabBlock registerLegacyVerticalSlab(Block slab) {
        String name = Registries.BLOCK.getId(slab).getPath();
        Either<MinecraftVersion, MinecraftVersion.Range> versions = MinecraftVersion.VERSION_MAP.get(slab);
        VerticalSlabBlock registered = register("vertical_" + name, AbstractBlock.Settings.copy(slab), settings -> new VerticalSlabBlock(settings) {
            @Override
            public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                if (versions.left().isPresent()) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                    tooltip.add(Text.literal(versions.left().get().getName()));
                } else if (versions.right().isPresent()) {
                    if (versions.right().get().to().compareTo(_26_1_2) == 0) {
                        tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                        tooltip.add(Text.literal(versions.right().get().from().getName() + "+"));
                    } else {
                        LegacyBlocks.addLegacyTooltip(tooltip, versions.right().get().from(), versions.right().get().to());
                    }
                }
            }
        });
        MinecraftVersion.VERSION_MAP.put(registered, versions);
        return registered;
    }

    static AbstractBlock.Settings createLogSettings(MapColor color, MapColor color1) {
        return AbstractBlock.Settings.create()
             .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? color : color1)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
            .burnable();
    }

    static AbstractBlock.Settings createWoodSettings(MapColor color) {
        return AbstractBlock.Settings.create()
                .mapColor(color)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
                .burnable();
    }

    static AbstractBlock.Settings createFlowerPotSettings() {
        return AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    static AbstractBlock.Settings createButtonSettings() {
        return AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY);
    }

    static void load() {}
}
