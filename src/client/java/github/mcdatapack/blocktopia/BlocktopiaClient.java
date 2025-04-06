package github.mcdatapack.blocktopia;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import github.mcdatapack.blocktopia.init.*;
import github.mcdatapack.blocktopia.init.blocks.*;
import github.mcdatapack.blocktopia.models.LegacyCutterModel;
import github.mcdatapack.blocktopia.models.MonkeyModel;
import github.mcdatapack.blocktopia.models.SmallChestModel;
import github.mcdatapack.blocktopia.renderer.*;
import github.mcdatapack.blocktopia.screen.LegacyCutterScreen;
import github.mcdatapack.blocktopia.screen.SmallChestInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.text.Text;

import java.awt.*;

public class BlocktopiaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().getModContainer("blocktopia").ifPresent(container -> {
            ResourceManagerHelper.registerBuiltinResourcePack(Blocktopia.id("connected_textures"), container, Text.translatable("resourcepack.blocktopia.connected_textures"), ResourcePackActivationType.NORMAL);
            ResourceManagerHelper.registerBuiltinResourcePack(Blocktopia.id("dark_ui"), container, Text.translatable("resourcepack.blocktopia.dark_ui"), ResourcePackActivationType.NORMAL);
            ResourceManagerHelper.registerBuiltinResourcePack(Blocktopia.id("modified_villages"), container, Text.translatable("datapack.blocktopia.modified_villages"), ResourcePackActivationType.DEFAULT_ENABLED);
            ResourceManagerHelper.registerBuiltinResourcePack(Blocktopia.id("thundering_smite"), container, Text.translatable("datapack.blocktopia.thundering_smite"), ResourcePackActivationType.NORMAL);
            ResourceManagerHelper.registerBuiltinResourcePack(Blocktopia.id("silk_swing"), container, Text.translatable("datapack.blocktopia.silk_swing"), ResourcePackActivationType.NORMAL);
        });

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockInit.PALM_DOOR, BlockInit.PALM_SAPLING,
                BlockInit.POTTED_PALM_SAPLING, BlockInit.PALM_LEAVES, BlockInit.PALM_TRAPDOOR, BlockInit.BANANA_SAPLING, BlockInit.POTTED_BANANA_SAPLING,
                BlockInit.BANANA_LEAVES, BlockInit.FLOWERING_CHERRY_LEAVES, BlockInit.FLOWERING_CHERRY_SAPLING, BlockInit.POTTED_FLOWERING_CHERRY_SAPLING,
                BlockInit.GLOW_FLOWER, BlockInit.POTTED_GLOW_FLOWER, BlockInit.BANANA_DOOR, BlockInit.BANANA_TRAPDOOR,
                BlockInit.CORN_SAPLING, BlockInit.POTTED_CORN_SAPLING, BlockInit.CORN_LEAVES, BlockInit.CORN_DOOR, BlockInit.CORN_TRAPDOOR,
                BlockInit.POISONED_SAPLING, BlockInit.POTTED_POISONED_SAPLING, BlockInit.POISONED_LEAVES, BlockInit.POISONED_DOOR, BlockInit.POISONED_TRAPDOOR, BlockInit.BANANA_CROP,

                LegacyBlocks.SAPLING_RD161348, LegacyBlocks.POTTED_SAPLING_RD161348, LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A,
                LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, LegacyBlocks.DANDELION_C0_0_20A,
                LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A,
                LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, LegacyBlocks.BROWN_MUSHROOM_C0_0_20A,
                LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7,
                LegacyBlocks.LADDER_INF20100607, LegacyBlocks.LADDER_INF20100618, LegacyBlocks.LEAVES_C0_0_14A,
                LegacyBlocks.LEAVES_C0_0_15A, LegacyBlocks.LEAVES_C0_24ST, LegacyBlocks.GLASS_C0_0_19A, LegacyBlocks.TORCH_IN20100124_2,
                LegacyBlocks.WALL_TORCH_IN20100124_2, LegacyBlocks.WOODEN_DOOR_INF20100607, LegacyBlocks.REDSTONE_TORCH_A1_0_1,
                LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), LegacyBlocks.ICE_A1_0_4);

        FluidRenderHandlerRegistry.INSTANCE.register(FluidInit.TROPICAL_WATER, FluidInit.FLOWING_TROPICAL_WATER,
                new SimpleFluidRenderHandler(
                        Blocktopia.id("block/tropical_water_still"),
                        Blocktopia.id("block/tropical_water_flow"),
                        Blocktopia.id("block/tropical_water_overlay"),
                        new Color(0, 255, 234).getRGB()
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), FluidInit.TROPICAL_WATER, FluidInit.FLOWING_TROPICAL_WATER);

        //Model Layers
        TerraformBoatClientHelper.registerModelLayers(BoatInit.PALM_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(BoatInit.BANANA_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(BoatInit.CORN_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(BoatInit.POISONED_BOAT_ID, false);

        EntityModelLayerRegistry.registerModelLayer(SmallChestModel.LAYER, SmallChestModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(LegacyCutterModel.LAYER, LegacyCutterModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(ModelLayerInit.MONKEY, MonkeyModel::getTexturedModelData);

        //BlockEntityRenderers
        BlockEntityRendererFactories.register(BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY, SmallChestBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityTypeInit.XP_TRAP, XPTrapBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityTypeInit.LEGACY_CUTTER, LegacyCutterRenderer::new);

        //Entity Renderers
        EntityRendererRegistry.register(EntityInit.MONKEY, MonkeyRenderer::new);

        EntityRendererRegistry.register(EntityInit.CHAIR, ChairRenderer::new);
        EntityRendererRegistry.register(EntityInit.SPONGE_TNT, SpongeTNTEntityRenderer::new);


        HandledScreens.register(ScreenHandlerTypeInit.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, SmallChestInventoryScreen::new);
        HandledScreens.register(ScreenHandlerTypeInit.LEGACY_CUTTER_INVENTORY_SCREEN_HANDLER, LegacyCutterScreen::new);
    }
}
