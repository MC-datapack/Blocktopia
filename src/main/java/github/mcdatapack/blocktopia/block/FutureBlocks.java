package github.mcdatapack.blocktopia.block;

import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Function3;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.custom.CustomMossBlock;
import github.mcdatapack.blocktopia.block.custom.ExtendedLeavesBlock;
import github.mcdatapack.blocktopia.block.custom.FloorExtendedSaplingBlock;
import github.mcdatapack.blocktopia.block.custom.HangingMossBlock;
import github.mcdatapack.blocktopia.worldgen.feature.ModConfiguredFeatures;
import github.mcdatapack.blocktopia.worldgen.tree.sapling.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static github.mcdatapack.blocktopia.block.MinecraftVersions.*;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;

public interface FutureBlocks {
    Block STRIPPED_PALE_OAK_LOG =  register("stripped_pale_oak_log", createLogSettings(MapColor.WHITE, MapColor.WHITE), PillarBlock::new, _1_21_2);
    Block PALE_OAK_LOG = register("pale_oak_log", createLogSettings(MapColor.WHITE, MapColor.WHITE), PillarBlock::new, _1_21_2);
    Block STRIPPED_PALE_OAK_WOOD = register("stripped_pale_oak_wood", createWoodSettings(MapColor.WHITE), PillarBlock::new, _1_21_2);
    Block PALE_OAK_WOOD = register("pale_oak_wood", createWoodSettings(MapColor.WHITE), PillarBlock::new, _1_21_2);
    ExtendedLeavesBlock PALE_OAK_LEAVES = register("pale_oak_leaves", settings -> new ExtendedLeavesBlock(settings
                    .strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)),
            _1_21_2);
    FloorExtendedSaplingBlock PALE_OAK_SAPLING = register("pale_oak_sapling", settings -> new FloorExtendedSaplingBlock(ModSaplingGenerators.PALE_OAK, settings
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never).noCollision()),
            _1_21_2);
    Block POTTED_PALE_OAK_SAPLING = registerWithoutItem("potted_pale_oak_sapling", createFlowerPotSettings(), settings -> new FlowerPotBlock(PALE_OAK_SAPLING, settings));
    Block PALE_OAK_PLANKS = register("pale_oak_planks", AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), Block::new, _1_21_2);
    DoorBlock PALE_OAK_DOOR = register("pale_oak_door", settings -> new DoorBlock(ModBlockSetTypes.PALE_OAK, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().burnable().sounds(BlockSoundGroup.WOOD)), _1_21_2);
    FenceBlock PALE_OAK_FENCE = register("pale_oak_fence", settings -> new FenceBlock(settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    FenceGateBlock PALE_OAK_FENCE_GATE = register("pale_oak_fence_gate", settings -> new FenceGateBlock(ModWoodSetTypes.PALE_OAK, settings
            .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    StairsBlock PALE_OAK_STAIRS = register("pale_oak_stairs", AbstractBlock.Settings.copy(Blocks.OAK_DOOR),
            settings -> new StairsBlock(PALE_OAK_PLANKS.getDefaultState(), settings), _1_21_2);
    SlabBlock PALE_OAK_SLAB = register("pale_oak_slab", settings -> new SlabBlock(settings
            .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()), _1_21_2);
    PressurePlateBlock PALE_OAK_PRESSURE_PLATE = register("pale_oak_pressure_plate", settings -> new PressurePlateBlock(ModBlockSetTypes.PALE_OAK, settings
            .solid().mapColor(MapColor.BROWN).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)), _1_21_2);
    Block PALE_OAK_BUTTON = register("pale_oak_button", createButtonSettings(), settings -> new ButtonBlock(ModBlockSetTypes.PALE_OAK, 30, settings), _1_21_2);
    TrapdoorBlock PALE_OAK_TRAPDOOR = register("pale_oak_trapdoor", settings -> new TrapdoorBlock(ModBlockSetTypes.PALE_OAK, settings
            .mapColor(MapColor.BROWN).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()), _1_21_2);
    WallSignBlock PALE_OAK_WALL_SIGN = registerWithoutItem("pale_oak_wall_sign", AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN),
            settings -> new TerraformWallSignBlock(Blocktopia.id("entity/signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, settings));
    SignBlock PALE_OAK_SIGN = register("pale_oak_sign", AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN),
            settings -> new TerraformSignBlock(Blocktopia.id("entity/signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, settings), settings -> settings.maxCount(16),
            (block, settings, since) -> new HangingSignItem(block, PALE_OAK_WALL_SIGN, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                    tooltip.add(Text.literal(since.getName() + "+"));
                }
            }, _1_21_2);
    WallHangingSignBlock PALE_OAK_WALL_HANGING_SIGN = registerWithoutItem("pale_oak_wall_hanging_sign", AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN),
            settings -> new TerraformWallHangingSignBlock(Blocktopia.id("entity/signs/hanging/pale_oak"), Blocktopia.id("textures/gui/hanging_signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, settings));
    HangingSignBlock PALE_OAK_HANGING_SIGN = register("pale_oak_hanging_sign", AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN),
            settings -> new TerraformHangingSignBlock(Blocktopia.id("entity/signs/hanging/pale_oak"), Blocktopia.id("textures/gui/hanging_signs/pale_oak"),
                    ModWoodSetTypes.PALE_OAK, settings), settings -> settings.maxCount(16),
            (block, settings, since) -> new HangingSignItem(block, PALE_OAK_WALL_HANGING_SIGN, settings) {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                    tooltip.add(Text.literal(since.getName() + "+"));
                }
            }, _1_21_2);

    CarpetBlock PALE_MOSS_CARPET = register("pale_moss_carpet", AbstractBlock.Settings.copy(Blocks.MOSS_CARPET), CarpetBlock::new, _1_21_2);
    CustomMossBlock PALE_MOSS = register("pale_moss", AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK),
            settings -> new CustomMossBlock(ModConfiguredFeatures.PALE_MOSS_PATCH_BONEMEAL_KEY, settings), _1_21_2);
    HangingMossBlock PALE_HANGING_MOSS = register("pale_hanging_moss", settings -> new HangingMossBlock(settings
            .mapColor(MapColor.STONE_GRAY).noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY)), _1_21_2);
    FlowerBlock CLOSED_EYEBLOSSOM = register("closed_eyeblossom", AbstractBlock.Settings.copy(Blocks.POPPY),
            settings -> new FlowerBlock(StatusEffects.NAUSEA, 7, settings), _1_21_2);
    FlowerPotBlock POTTED_CLOSED_EYEBOSSOM = registerWithoutItem("potted_closed_eyeblossom", createFlowerPotSettings(),
            settings -> new FlowerPotBlock(CLOSED_EYEBLOSSOM, settings));
    FlowerBlock OPEN_EYEBLOSSOM = register("open_eyeblossom", AbstractBlock.Settings.copy(Blocks.POPPY),
            settings -> new FlowerBlock(StatusEffects.BLINDNESS, 11, settings), _1_21_2);
    FlowerPotBlock POTTED_OPEN_EYEBOSSOM = registerWithoutItem("potted_open_eyeblossom", createFlowerPotSettings(),
            settings -> new FlowerPotBlock(OPEN_EYEBLOSSOM, settings));
    Block RESIN_BLOCK = register("resin_block", settings -> new Block(settings.breakInstantly()), _1_21_4);
    Block RESIN_BRICKS = register("resin_bricks", settings -> new Block(settings.strength(1.5F, 6)), _1_21_4);
    StairsBlock RESIN_BRICK_STAIRS = register("resin_brick_stairs", settings -> new StairsBlock(RESIN_BRICKS.getDefaultState(), settings.strength(1.5F, 6)), _1_21_4);
    SlabBlock RESIN_BRICK_SLAB = register("resin_brick_slab", settings -> new SlabBlock(settings.strength(1.5F, 6)), _1_21_4);
    WallBlock RESIN_BRICK_WALL = register("resin_brick_wall", settings -> new WallBlock(settings.strength(1.5F, 6)), _1_21_4);
    Block CHISELED_RESIN_BRICKS = register("chiseled_resin_bricks", settings -> new Block(settings.strength(1.5F, 6)), _1_21_4);

    FlowerbedBlock WILDFLOWERS = register("wildflowers", AbstractBlock.Settings.copy(Blocks.PINK_PETALS), FlowerbedBlock::new, _1_21_5);
    FlowerbedBlock LEAF_LITTERS = register("leaf_litter", AbstractBlock.Settings.copy(Blocks.PINK_PETALS), FlowerbedBlock::new, _1_21_5);
    DeadBushBlock SHORT_DRY_GRASS = register("short_dry_grass", AbstractBlock.Settings.copy(Blocks.SHORT_GRASS), DeadBushBlock::new, _1_21_5);

    WallTorchBlock WALL_COPPER_TORCH = registerWithoutItem("wall_copper_torch", settings -> new WallTorchBlock(ParticleTypes.ASH, settings
            .breakInstantly()
            .luminance(value -> 14)));
    TorchBlock COPPER_TORCH = register("copper_torch", AbstractBlock.Settings.create().breakInstantly().luminance(value -> 14), 
            settings -> new TorchBlock(ParticleTypes.ASH, settings), settings -> settings, 
            (block, settings, since) -> new VerticallyAttachableBlockItem(block, WALL_COPPER_TORCH, settings, Direction.DOWN) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                    tooltip.add(Text.literal(since.getName() + "+"));
                }
    }, _1_21_9);

    LanternBlock COPPER_LANTERN = register("copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock EXPOSED_COPPER_LANTERN = register("exposed_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock WEATHERED_COPPER_LANTERN = register("weathered_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock OXIDIZED_COPPER_LANTERN = register("oxidized_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock WAXED_COPPER_LANTERN = register("waxed_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock WAXED_EXPOSED_COPPER_LANTERN = register("waxed_exposed_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock WAXED_WEATHERED_COPPER_LANTERN = register("waxed_weathered_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);
    LanternBlock WAXED_OXIDIZED_COPPER_LANTERN = register("waxed_oxidized_copper_lantern", AbstractBlock.Settings.copy(Blocks.LANTERN), LanternBlock::new, _1_21_9);

    PaneBlock COPPER_BARS = register("copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock EXPOSED_COPPER_BARS = register("exposed_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock WEATHERED_COPPER_BARS = register("weathered_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock OXIDIZED_COPPER_BARS = register("oxidized_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock WAXED_COPPER_BARS = register("waxed_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock WAXED_EXPOSED_COPPER_BARS = register("waxed_exposed_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock WAXED_WEATHERED_COPPER_BARS = register("waxed_weathered_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);
    PaneBlock WAXED_OXIDIZED_COPPER_BARS = register("waxed_oxidized_copper_bars", AbstractBlock.Settings.copy(Blocks.IRON_BARS), PaneBlock::new, _1_21_9);

    ChainBlock COPPER_CHAIN = register("copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock EXPOSED_COPPER_CHAIN = register("exposed_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock WEATHERED_COPPER_CHAIN = register("weathered_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock OXIDIZED_COPPER_CHAIN = register("oxidized_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock WAXED_COPPER_CHAIN = register("waxed_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock WAXED_EXPOSED_COPPER_CHAIN = register("waxed_exposed_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock WAXED_WEATHERED_COPPER_CHAIN = register("waxed_weathered_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);
    ChainBlock WAXED_OXIDIZED_COPPER_CHAIN = register("waxed_oxidized_copper_chain", AbstractBlock.Settings.copy(Blocks.CHAIN), ChainBlock::new, _1_21_9);

    LightningRodBlock EXPOSED_LIGHTNING_ROD = register("exposed_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock WEATHERED_LIGHTNING_ROD = register("weathered_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock OXIDIZED_LIGHTNING_ROD = register("oxidized_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock WAXED_LIGHTNING_ROD = register("waxed_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock WAXED_EXPOSED_LIGHTNING_ROD = register("waxed_exposed_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock WAXED_WEATHERED_LIGHTNING_ROD = register("waxed_weathered_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);
    LightningRodBlock WAXED_OXIDIZED_LIGHTNING_ROD = register("waxed_oxidized_lightning_rod", AbstractBlock.Settings.copy(Blocks.LIGHTNING_ROD), LightningRodBlock::new, _1_21_9);

    FlowerBlock GOLDEN_DANDELION = register("golden_dandelion", AbstractBlock.Settings.copy(Blocks.DANDELION),
            settings -> new FlowerBlock(StatusEffects.SATURATION, 0.35F, settings), _26_1);

    private static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, T> block,
                                                Function<Item.Settings, Item.Settings> itemSettings, Function3<Block, Item.Settings, MinecraftVersion, BlockItem> item, MinecraftVersion since) {
        T registered = ModBlocks.register(name, settings, block, itemSettings, (block1, settings1) -> item.apply(block1, settings1, since));
        MinecraftVersion.VERSION_MAP.put(registered, Either.right(new MinecraftVersion.Range(since, MinecraftVersions.getNewest())));
        return registered;
    }
    
    private static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, T> block, MinecraftVersion since) {
        return register(name, settings, block, itemSettings -> itemSettings, since);
    }

    private static <T extends Block> T register(String name, AbstractBlock.Settings settings, Function<AbstractBlock.Settings, T> block, Function<Item.Settings, Item.Settings> itemSettings, MinecraftVersion since) {
        T registered = ModBlocks.register(name, settings, block, itemSettings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                tooltip.add(Text.literal(since.getName() + "+"));
            }
        });
        MinecraftVersion.VERSION_MAP.put(registered, Either.right(new MinecraftVersion.Range(since, MinecraftVersions.getNewest())));
        return registered;
    }
    private static <T extends Block> T register(String name, Function<AbstractBlock.Settings, T> block, MinecraftVersion since) {
        return register(name, block, itemSettings -> itemSettings, since);
    }

    private static <T extends Block> T register(String name, Function<AbstractBlock.Settings, T> block, Function<Item.Settings, Item.Settings> itemSettings, MinecraftVersion since) {
        T registered = ModBlocks.register(name, block, itemSettings, (block1, settings1) -> new BlockItem(block1, settings1) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                tooltip.add(Text.literal(since.getName() + "+"));
            }
        });
        MinecraftVersion.VERSION_MAP.put(registered, Either.right(new MinecraftVersion.Range(since, MinecraftVersions.getNewest())));
        return registered;
    }

    static void load() {}
}
