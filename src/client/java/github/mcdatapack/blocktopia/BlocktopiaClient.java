package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatClientHelper;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatEntityRenderer;
import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import github.mcdatapack.blocktopia.init.BoatInit;
import github.mcdatapack.blocktopia.init.EntityInit;
import github.mcdatapack.blocktopia.init.ScreenHandlerTypeInit;
import github.mcdatapack.blocktopia.init.blocks.*;
import github.mcdatapack.blocktopia.models.SmallChestModel;
import github.mcdatapack.blocktopia.renderer.*;
import github.mcdatapack.blocktopia.screen.SmallChestInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BlocktopiaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockInit.PALM_DOOR, BlockInit.PALM_SAPLING,
                BlockInit.POTTED_PALM_SAPLING, BlockInit.PALM_LEAVES, BlockInit.PALM_TRAPDOOR, BlockInit.BANANA_SAPLING, BlockInit.POTTED_BANANA_SAPLING,
                BlockInit.BANANA_LEAVES, BlockInit.FLOWERING_CHERRY_LEAVES, BlockInit.FLOWERING_CHERRY_SAPLING, BlockInit.POTTED_FLOWERING_CHERRY_SAPLING,
                BlockInit.GLOW_FLOWER, BlockInit.POTTED_GLOW_FLOWER, BlockInit.BANANA_DOOR, BlockInit.BANANA_TRAPDOOR, BlockInit.BANANA_CROP,

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

        //Model Layers
        BlocktopiaBoatClientHelper.registerModelLayers(BoatInit.PALM_BOAT_ID, false);
        BlocktopiaBoatClientHelper.registerModelLayers(BoatInit.BANANA_BOAT_ID, false);

        EntityModelLayerRegistry.registerModelLayer(SmallChestModel.LAYER, SmallChestModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(ModelLayerInit.MONKEY, MonkeyModel::getTexturedModelData);

        //BlockEntityRenderers
        BlockEntityRendererFactories.register(BlockEntityTypeInit.SMALL_CHEST_BLOCK_ENTITY, SmallChestBlockEntityRenderer::new);

        //Entity Renderers
        EntityRendererRegistry.register(EntityInit.MONKEY, MonkeyRenderer::new);

        EntityRendererRegistry.register(EntityInit.CHAIR, ChairRenderer::new);


        HandledScreens.register(ScreenHandlerTypeInit.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, SmallChestInventoryScreen::new);

        EntityRendererRegistry.register(Blocktopia.BOAT, (context) -> new BlocktopiaBoatEntityRenderer(context, false));
        EntityRendererRegistry.register(Blocktopia.CHEST_BOAT, (context) -> new BlocktopiaBoatEntityRenderer(context, true));
    }
}
