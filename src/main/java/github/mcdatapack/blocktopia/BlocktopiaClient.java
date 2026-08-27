package github.mcdatapack.blocktopia;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.block.entity.renderer.*;
import github.mcdatapack.blocktopia.entity.ModBoats;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.entity.custom.MonkeyEntity;
import github.mcdatapack.blocktopia.entity.model.ToucanModel;
import github.mcdatapack.blocktopia.entity.renderer.*;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.block.entity.model.DuperModel;
import github.mcdatapack.blocktopia.block.entity.model.LegacyCutterModel;
import github.mcdatapack.blocktopia.entity.model.MonkeyModel;
import github.mcdatapack.blocktopia.block.entity.model.SmallChestModel;
import github.mcdatapack.blocktopia.item.ModItems;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import github.mcdatapack.blocktopia.screen.custom.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.BlockItem;
import net.minecraft.world.biome.GrassColors;

import static github.mcdatapack.blocktopia.Blocktopia.id;
import static github.mcdatapack.blocktopia.block.FutureBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.BLACK_STAINED_GLASS_PANE_1_7;
import static github.mcdatapack.blocktopia.block.ModBlocks.*;
import static net.fabricmc.fabric.api.resource.ResourceManagerHelper.registerBuiltinResourcePack;
import static net.fabricmc.fabric.api.resource.ResourcePackActivationType.*;
import static net.minecraft.text.Text.translatable;

public class BlocktopiaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().getModContainer("blocktopia").ifPresent(container -> {
            registerBuiltinResourcePack(id("connected_textures"), container, translatable("resourcepack.blocktopia.connected_textures"), NORMAL);
            registerBuiltinResourcePack(id("dark_ui"), container, translatable("resourcepack.blocktopia.dark_ui"), NORMAL);
            registerBuiltinResourcePack(id("modified_villages"), container, translatable("datapack.blocktopia.modified_villages"), DEFAULT_ENABLED);
            registerBuiltinResourcePack(id("thundering_smite"), container, translatable("datapack.blocktopia.thundering_smite"), NORMAL);
            registerBuiltinResourcePack(id("silk_swing"), container, translatable("datapack.blocktopia.silk_swing"), NORMAL);
            registerBuiltinResourcePack(id("bow_looting"), container, translatable("datapack.blocktopia.bow_looting"), DEFAULT_ENABLED);
        });

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), PALM_DOOR, PALM_SAPLING,
                POTTED_PALM_SAPLING, PALM_LEAVES, PALM_TRAPDOOR, BANANA_SAPLING, POTTED_BANANA_SAPLING, BANANA_LEAVES, FLOWERING_CHERRY_LEAVES, FLOWERING_CHERRY_SAPLING, POTTED_FLOWERING_CHERRY_SAPLING,
                GLOW_FLOWER, POTTED_GLOW_FLOWER, BANANA_DOOR, BANANA_TRAPDOOR, CORN_SAPLING, POTTED_CORN_SAPLING, CORN_LEAVES, CORN_DOOR, CORN_TRAPDOOR, POISONED_SAPLING, POTTED_POISONED_SAPLING,
                POISONED_LEAVES, POISONED_DOOR, POISONED_TRAPDOOR, BANANA_CROP, MAHOGANY_SAPLING, POTTED_MAHOGANY_SAPLING, MAHOGANY_LEAVES, MAHOGANY_DOOR, MAHOGANY_TRAPDOOR, FLUID_TANK,
                WILDFLOWERS, LEAF_LITTERS, SHORT_DRY_GRASS, PALE_HANGING_MOSS, CLOSED_EYEBLOSSOM, OPEN_EYEBLOSSOM, WILDFLOWERS, LEAF_LITTERS, SHORT_DRY_GRASS, PALE_OAK_LEAVES, PALE_OAK_SAPLING, WOODCUTTER,

                SAPLING_RD161348, POTTED_SAPLING_RD161348, SAPLING_C0_0_13A, POTTED_SAPLING_C0_0_13A, SAPLING_C0_24ST, POTTED_SAPLING_C0_24ST, DANDELION_C0_0_20A, POTTED_DANDELIONS_C0_0_20A,
                ROSE_C0_0_20A, POTTED_ROSE_C0_0_20A, RED_MUSHROOM_C0_0_20A, POTTED_RED_MUSHROOM_C0_0_20A, BROWN_MUSHROOM_C0_0_20A, POTTED_BROWN_MUSHROOM_C0_0_20A, POPPY_1_7, POTTED_POPPY_1_7,
                LADDER_INF20100607, LADDER_INF20100618, LEAVES_C0_0_14A, LEAVES_C0_0_15A, LEAVES_C0_24ST, GLASS_C0_0_19A, TORCH_IN20100124_2, WALL_TORCH_IN20100124_2, WOODEN_DOOR_INF20100607,
                REDSTONE_TORCH_A1_0_1, REDSTONE_WALL_TORCH_A1_0_1, RAIL_INF20100618, POWERED_RAIL_B1_5, DETECTOR_RAIL_B1_5, TRAPDOOR_B1_6, FERN_B1_6, SHRUB_B1_6, SHORT_GRASS_B1_6, DEAD_BUSH_B1_6,
                GLASS_PANE_B1_8, VINES_B1_8, SPRUCE_LEAVES_B1_2, SPRUCE_SAPLING_B1_5, BIRCH_LEAVES_B1_2, BIRCH_SAPLING_B1_5, COBWEB_B1_5, LILY_PAD_B1_9PRE, JUNGLE_LEAVES_1_2, JUNGLE_SAPLING_1_2,
                ACTIVATOR_RAIL_1_5, ACACIA_LEAVES_1_7, ACACIA_SAPLING_1_7, DARK_OAK_SAPLING_1_7, DARK_OAK_LEAVES_1_7, ALLIUM_1_7, AZURE_BLUET_1_7, BLUE_ORCHID_1_7, LILAC_1_7, PEONY_1_7, ROSE_BUSH_1_7,
                SUNFLOWER_1_7, OXEYE_DAISY_1_7, RED_TULIP_1_7, ORANGE_TULIP_1_7, WHITE_TULIP_1_7, PINK_TULIP_1_7, LARGE_FERN_1_7, TALL_GRASS_1_7, PACKED_ICE_1_7, WHITE_STAINED_GLASS_1_7,
                ORANGE_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_1_7, LIME_STAINED_GLASS_1_7, PINK_STAINED_GLASS_1_7, GRAY_STAINED_GLASS_1_7,
                LIGHT_GRAY_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_1_7, BLUE_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_1_7, RED_STAINED_GLASS_1_7,
                BLACK_STAINED_GLASS_1_7, WHITE_STAINED_GLASS_PANE_1_7, ORANGE_STAINED_GLASS_PANE_1_7, MAGENTA_STAINED_GLASS_PANE_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7, YELLOW_STAINED_GLASS_PANE_1_7,
                LIME_STAINED_GLASS_PANE_1_7, PINK_STAINED_GLASS_PANE_1_7, GRAY_STAINED_GLASS_PANE_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7, CYAN_STAINED_GLASS_PANE_1_7, PURPLE_STAINED_GLASS_PANE_1_7,
                BLUE_STAINED_GLASS_PANE_1_7, BROWN_STAINED_GLASS_PANE_1_7, GREEN_STAINED_GLASS_PANE_1_7, RED_STAINED_GLASS_PANE_1_7, BLACK_STAINED_GLASS_PANE_1_7,
                GOLDEN_DANDELION, COPPER_TORCH, WALL_COPPER_TORCH, POTTED_BIRCH_SAPLING_B1_5, POTTED_SPRUCE_SAPLING_B1_5,
                POTTED_JUNGLE_SAPLING_1_2, POTTED_ACACIA_SAPLING_1_7, POTTED_DARK_OAK_SAPLING_1_7, POTTED_SHRUB_B1_6, POTTED_DEAD_BUSH_B1_6, POTTED_FERN_B1_6,
                POTTED_ALLIUM_1_7, POTTED_AZURE_BLUET_1_7, POTTED_BLUE_ORCHID_1_7, POTTED_OXEYE_DAISY_1_7, POTTED_RED_TULIP_1_7, POTTED_ORANGE_TULIP_1_7, POTTED_WHITE_TULIP_1_7,
                POTTED_PINK_TULIP_1_7,
                COPPER_BARS, WAXED_COPPER_BARS, WEATHERED_COPPER_BARS, WAXED_WEATHERED_COPPER_BARS, EXPOSED_COPPER_BARS, WAXED_EXPOSED_COPPER_BARS, OXIDIZED_COPPER_BARS, WAXED_OXIDIZED_COPPER_BARS,
                COPPER_CHAIN, WAXED_COPPER_CHAIN, WEATHERED_COPPER_CHAIN, WAXED_WEATHERED_COPPER_CHAIN, EXPOSED_COPPER_CHAIN, WAXED_EXPOSED_COPPER_CHAIN, OXIDIZED_COPPER_CHAIN, WAXED_OXIDIZED_COPPER_CHAIN,
                COPPER_LANTERN, WAXED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN, WAXED_WEATHERED_COPPER_LANTERN, EXPOSED_COPPER_LANTERN, WAXED_EXPOSED_COPPER_LANTERN, OXIDIZED_COPPER_LANTERN, WAXED_OXIDIZED_COPPER_LANTERN,
                BANANA_HANGING_MOSS, CORN_HANGING_MOSS, POISONED_HANGING_MOSS, MAHOGANY_HANGING_MOSS, FLOWERING_CHERRY_HANGING_MOSS
        );
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ICE_A1_0_4,
                WHITE_STAINED_GLASS_1_7, ORANGE_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_1_7, LIME_STAINED_GLASS_1_7, PINK_STAINED_GLASS_1_7,
                GRAY_STAINED_GLASS_1_7, LIGHT_GRAY_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_1_7, BLUE_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_1_7,
                RED_STAINED_GLASS_1_7, BLACK_STAINED_GLASS_1_7, WHITE_STAINED_GLASS_PANE_1_7, ORANGE_STAINED_GLASS_PANE_1_7, MAGENTA_STAINED_GLASS_PANE_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7,
                YELLOW_STAINED_GLASS_PANE_1_7, LIME_STAINED_GLASS_PANE_1_7, PINK_STAINED_GLASS_PANE_1_7, GRAY_STAINED_GLASS_PANE_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7, CYAN_STAINED_GLASS_PANE_1_7,
                PURPLE_STAINED_GLASS_PANE_1_7, BLUE_STAINED_GLASS_PANE_1_7, BROWN_STAINED_GLASS_PANE_1_7, GREEN_STAINED_GLASS_PANE_1_7, RED_STAINED_GLASS_PANE_1_7, BLACK_STAINED_GLASS_PANE_1_7
        );

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER,
                new SimpleFluidRenderHandler(
                        id("block/tropical_water_still"),
                        id("block/tropical_water_flow"),
                        id("block/tropical_water_overlay")
                ));

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor(),
                FERN_B1_6, POTTED_FERN_B1_6, SHORT_GRASS_B1_6, VINES_B1_8, TALL_GRASS_1_7, LARGE_FERN_1_7);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> -10380959, SPRUCE_LEAVES_B1_2);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> -8345771, BIRCH_LEAVES_B1_2);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? -14647248 : -9321636, LILY_PAD_B1_9PRE);
        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : -12012264,
                JUNGLE_LEAVES_1_2, ACACIA_LEAVES_1_7, DARK_OAK_LEAVES_1_7);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> {
                    BlockState blockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                    return ColorProviderRegistry.BLOCK.get(blockState.getBlock()).getColor(blockState, null, null, tintIndex);
                },
                SPRUCE_LEAVES_B1_2, BIRCH_LEAVES_B1_2, FERN_B1_6, SHORT_GRASS_B1_6, VINES_B1_8, LILY_PAD_B1_9PRE,
                JUNGLE_LEAVES_1_2, TALL_GRASS_1_7, LARGE_FERN_1_7, ACACIA_LEAVES_1_7, DARK_OAK_LEAVES_1_7);


        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.PALM_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.BANANA_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.CORN_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.POISONED_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.MAHOGANY_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.PALE_OAK_BOAT_ID, false);
        EntityModelLayerRegistry.registerModelLayer(SmallChestModel.LAYER, SmallChestModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(LegacyCutterModel.LAYER, LegacyCutterModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DuperModel.LAYER, DuperModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(MonkeyModel.LAYER, MonkeyModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ToucanModel.LAYER, ToucanModel::getTexturedModelData);

        BlockEntityRendererFactories.register(ModBlockEntityTypes.SMALL_CHEST_BLOCK_ENTITY, SmallChestBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.XP_TRAP, XPTrapBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.DUPER, DuperRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.FLUID_TANK, FluidTankBlockEntityRenderer::new);

        EntityRendererRegistry.register(ModEntityTypes.MONKEY, MonkeyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.TOUCAN, ToucanRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SPONGE_TNT, SpongeTNTEntityRenderer::new);
        
        HandledScreens.register(ModScreenHandlerTypes.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, SmallChestInventoryScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.LEGACY_CUTTER_INVENTORY_SCREEN_HANDLER, LegacyCutterScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.WOOD_CUTTER_INVENTORY_SCREEN_HANDLER, WoodCutterScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.DUPER_INVENTORY_SCREEN_HANDLER, DuperScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.FLUID_TANK, FluidTankScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.GOLD_ANVIL, GoldAnvilScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.DIAMOND_ANVIL, DiamondAnvilScreen::new);
        HandledScreens.register(ModScreenHandlerTypes.NETHERITE_ANVIL, NetheriteAnvilScreen::new);

        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.MONKEY_SPAWN_EGG, new MonkeySpawnEggRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.GIANT_SPAWN_EGG, new GiantSpawnEggRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.ILLUSIONER_SPAWN_EGG, new IllusionerSpawnEggRenderer());
        BuiltinItemRendererRegistry.INSTANCE.register(DUPER, new DuperItemRenderer());
    }
}
