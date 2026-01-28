package github.mcdatapack.blocktopia;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import github.mcdatapack.blocktopia.block.FutureBlocks;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.LegacyBlocks;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import github.mcdatapack.blocktopia.block.entity.renderer.*;
import github.mcdatapack.blocktopia.entity.ModBoats;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import github.mcdatapack.blocktopia.entity.model.ToucanModel;
import github.mcdatapack.blocktopia.entity.renderer.ChairRenderer;
import github.mcdatapack.blocktopia.entity.renderer.MonkeyRenderer;
import github.mcdatapack.blocktopia.entity.renderer.SpongeTNTEntityRenderer;
import github.mcdatapack.blocktopia.entity.renderer.ToucanRenderer;
import github.mcdatapack.blocktopia.fluid.ModFluids;
import github.mcdatapack.blocktopia.block.entity.model.DuperModel;
import github.mcdatapack.blocktopia.block.entity.model.LegacyCutterModel;
import github.mcdatapack.blocktopia.entity.model.MonkeyModel;
import github.mcdatapack.blocktopia.block.entity.model.SmallChestModel;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import github.mcdatapack.blocktopia.screen.custom.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.biome.GrassColors;

import java.awt.*;

import static github.mcdatapack.blocktopia.Blocktopia.id;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.BLACK_STAINED_GLASS_PANE_1_7;
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

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.PALM_DOOR, ModBlocks.PALM_SAPLING,
                ModBlocks.POTTED_PALM_SAPLING, ModBlocks.PALM_LEAVES, ModBlocks.PALM_TRAPDOOR, ModBlocks.BANANA_SAPLING, ModBlocks.POTTED_BANANA_SAPLING,
                ModBlocks.BANANA_LEAVES, ModBlocks.FLOWERING_CHERRY_LEAVES, ModBlocks.FLOWERING_CHERRY_SAPLING, ModBlocks.POTTED_FLOWERING_CHERRY_SAPLING,
                ModBlocks.GLOW_FLOWER, ModBlocks.POTTED_GLOW_FLOWER, ModBlocks.BANANA_DOOR, ModBlocks.BANANA_TRAPDOOR,
                ModBlocks.CORN_SAPLING, ModBlocks.POTTED_CORN_SAPLING, ModBlocks.CORN_LEAVES, ModBlocks.CORN_DOOR, ModBlocks.CORN_TRAPDOOR,
                ModBlocks.POISONED_SAPLING, ModBlocks.POTTED_POISONED_SAPLING, ModBlocks.POISONED_LEAVES, ModBlocks.POISONED_DOOR, ModBlocks.POISONED_TRAPDOOR, ModBlocks.BANANA_CROP,
                ModBlocks.MAHOGANY_SAPLING, ModBlocks.POTTED_MAHOGANY_SAPLING, ModBlocks.MAHOGANY_LEAVES, ModBlocks.MAHOGANY_DOOR, ModBlocks.MAHOGANY_TRAPDOOR, ModBlocks.FLUID_TANK,

                FutureBlocks.PALE_HANGING_MOSS, FutureBlocks.CLOSED_EYEBLOSSOM, FutureBlocks.OPEN_EYEBLOSSOM, FutureBlocks.WILDFLOWERS, FutureBlocks.LEAF_LITTERS,
                FutureBlocks.SHORT_DRY_GRASS, FutureBlocks.PALE_OAK_LEAVES, FutureBlocks.PALE_OAK_SAPLING, ModBlocks.WOODCUTTER,

                LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A,
                LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, LegacyBlocks.DANDELION_C0_0_20A,
                LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A,
                LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, LegacyBlocks.BROWN_MUSHROOM_C0_0_20A,
                LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7,
                LegacyBlocks.LADDER_INF20100607, LegacyBlocks.LADDER_INF20100618, LegacyBlocks.LEAVES_C0_0_14A,
                LegacyBlocks.LEAVES_C0_0_15A, LegacyBlocks.LEAVES_C0_24ST, LegacyBlocks.GLASS_C0_0_19A, LegacyBlocks.TORCH_IN20100124_2,
                LegacyBlocks.WALL_TORCH_IN20100124_2, LegacyBlocks.WOODEN_DOOR_INF20100607, LegacyBlocks.REDSTONE_TORCH_A1_0_1,
                LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1, LegacyBlocks.RAIL_INF20100618, LegacyBlocks.POWERED_RAIL_B1_5, LegacyBlocks.DETECTOR_RAIL_B1_5, LegacyBlocks.TRAPDOOR_B1_6,
                LegacyBlocks.FERN_B1_6, LegacyBlocks.SHRUB_B1_6, LegacyBlocks.SHORT_GRASS_B1_6, LegacyBlocks.DEAD_BUSH_B1_6, LegacyBlocks.GLASS_PANE_B1_8,
                LegacyBlocks.VINES_B1_8, LegacyBlocks.SPRUCE_LEAVES_B1_2, LegacyBlocks.SPRUCE_SAPLING_B1_5, LegacyBlocks.BIRCH_LEAVES_B1_2, LegacyBlocks.BIRCH_SAPLING_B1_5, LegacyBlocks.COBWEB_B1_5,
                LegacyBlocks.LILY_PAD_B1_9PRE, LegacyBlocks.JUNGLE_LEAVES_1_2, LegacyBlocks.JUNGLE_SAPLING_1_2, LegacyBlocks.ACTIVATOR_RAIL_1_5,
                ACACIA_LEAVES_1_7, ACACIA_SAPLING_1_7, DARK_OAK_SAPLING_1_7, DARK_OAK_LEAVES_1_7,
                ALLIUM_1_7, AZURE_BLUET_1_7, BLUE_ORCHID_1_7, LILAC_1_7, PEONY_1_7, ROSE_BUSH_1_7, SUNFLOWER_1_7, OXEYE_DAISY_1_7, RED_TULIP_1_7, ORANGE_TULIP_1_7, WHITE_TULIP_1_7, PINK_TULIP_1_7, LARGE_FERN_1_7, TALL_GRASS_1_7, PACKED_ICE_1_7,
                WHITE_STAINED_GLASS_1_7, ORANGE_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_1_7, LIME_STAINED_GLASS_1_7, PINK_STAINED_GLASS_1_7, GRAY_STAINED_GLASS_1_7, LIGHT_GRAY_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_1_7, BLUE_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_1_7, RED_STAINED_GLASS_1_7, BLACK_STAINED_GLASS_1_7,
                WHITE_STAINED_GLASS_PANE_1_7, ORANGE_STAINED_GLASS_PANE_1_7, MAGENTA_STAINED_GLASS_PANE_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7, YELLOW_STAINED_GLASS_PANE_1_7, LIME_STAINED_GLASS_PANE_1_7, PINK_STAINED_GLASS_PANE_1_7, GRAY_STAINED_GLASS_PANE_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7, CYAN_STAINED_GLASS_PANE_1_7, PURPLE_STAINED_GLASS_PANE_1_7, BLUE_STAINED_GLASS_PANE_1_7, BROWN_STAINED_GLASS_PANE_1_7, GREEN_STAINED_GLASS_PANE_1_7, RED_STAINED_GLASS_PANE_1_7, BLACK_STAINED_GLASS_PANE_1_7
        );
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), LegacyBlocks.ICE_A1_0_4,
                WHITE_STAINED_GLASS_1_7, ORANGE_STAINED_GLASS_1_7, MAGENTA_STAINED_GLASS_1_7, LIGHT_BLUE_STAINED_GLASS_1_7, YELLOW_STAINED_GLASS_1_7, LIME_STAINED_GLASS_1_7, PINK_STAINED_GLASS_1_7, GRAY_STAINED_GLASS_1_7, LIGHT_GRAY_STAINED_GLASS_1_7, CYAN_STAINED_GLASS_1_7, PURPLE_STAINED_GLASS_1_7, BLUE_STAINED_GLASS_1_7, BROWN_STAINED_GLASS_1_7, GREEN_STAINED_GLASS_1_7, RED_STAINED_GLASS_1_7,
                BLACK_STAINED_GLASS_1_7, WHITE_STAINED_GLASS_PANE_1_7, ORANGE_STAINED_GLASS_PANE_1_7, MAGENTA_STAINED_GLASS_PANE_1_7, LIGHT_BLUE_STAINED_GLASS_PANE_1_7, YELLOW_STAINED_GLASS_PANE_1_7, LIME_STAINED_GLASS_PANE_1_7, PINK_STAINED_GLASS_PANE_1_7, GRAY_STAINED_GLASS_PANE_1_7, LIGHT_GRAY_STAINED_GLASS_PANE_1_7, CYAN_STAINED_GLASS_PANE_1_7, PURPLE_STAINED_GLASS_PANE_1_7, BLUE_STAINED_GLASS_PANE_1_7, BROWN_STAINED_GLASS_PANE_1_7, GREEN_STAINED_GLASS_PANE_1_7, RED_STAINED_GLASS_PANE_1_7, BLACK_STAINED_GLASS_PANE_1_7
        );

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER,
                new SimpleFluidRenderHandler(
                        id("block/tropical_water_still"),
                        id("block/tropical_water_flow"),
                        id("block/tropical_water_overlay")
                ));

        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor(),
                LegacyBlocks.FERN_B1_6, LegacyBlocks.SHORT_GRASS_B1_6, LegacyBlocks.VINES_B1_8, LegacyBlocks.TALL_GRASS_1_7, LegacyBlocks.LARGE_FERN_1_7);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> FoliageColors.getSpruceColor(), LegacyBlocks.SPRUCE_LEAVES_B1_2);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> FoliageColors.getBirchColor(), LegacyBlocks.BIRCH_LEAVES_B1_2);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
                world != null && pos != null ? -14647248 : -9321636, LegacyBlocks.LILY_PAD_B1_9PRE);
        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor(),
                LegacyBlocks.JUNGLE_LEAVES_1_2, LegacyBlocks.ACACIA_LEAVES_1_7, LegacyBlocks.DARK_OAK_LEAVES_1_7);

        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> {
                    BlockState blockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                    return ColorProviderRegistry.BLOCK.get(blockState.getBlock()).getColor(blockState, null, null, tintIndex);
                },
                LegacyBlocks.SPRUCE_LEAVES_B1_2, LegacyBlocks.BIRCH_LEAVES_B1_2, LegacyBlocks.FERN_B1_6, LegacyBlocks.SHORT_GRASS_B1_6, LegacyBlocks.VINES_B1_8, LegacyBlocks.LILY_PAD_B1_9PRE,
                LegacyBlocks.JUNGLE_LEAVES_1_2, TALL_GRASS_1_7, LARGE_FERN_1_7, ACACIA_LEAVES_1_7, DARK_OAK_LEAVES_1_7);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.TROPICAL_WATER, ModFluids.FLOWING_TROPICAL_WATER);

        //Model Layers
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

        //BlockEntityRenderers
        BlockEntityRendererFactories.register(ModBlockEntityTypes.SMALL_CHEST_BLOCK_ENTITY, SmallChestBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.XP_TRAP, XPTrapBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.DUPER, DuperRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntityTypes.FLUID_TANK, FluidTankBlockEntityRenderer::new);

        //Entity Renderers
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
    }
}
