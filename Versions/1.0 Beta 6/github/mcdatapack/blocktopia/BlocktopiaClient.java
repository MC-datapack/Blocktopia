package github.mcdatapack.blocktopia;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatClientHelper;
import github.mcdatapack.blocktopia.boat.impl.BlocktopiaBoatEntityRenderer;
import github.mcdatapack.blocktopia.init.BoatInit;
import github.mcdatapack.blocktopia.init.ScreenHandlerTypeInit;
import github.mcdatapack.blocktopia.init.blocks.*;
import github.mcdatapack.blocktopia.screen.SmallChestInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_1921;
import net.minecraft.class_3929;

public class BlocktopiaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(class_1921.method_23581(), BlockInit.PALM_DOOR, BlockInit.PALM_SAPLING,
                BlockInit.POTTED_PALM_SAPLING, BlockInit.PALM_LEAVES, BlockInit.PALM_TRAPDOOR, LegacyBlocks.SAPLING_RD161348,
                LegacyBlocks.POTTED_SAPLING_RD161348, LegacyBlocks.SAPLING_C0_0_13A, LegacyBlocks.POTTED_SAPLING_C0_0_13A,
                LegacyBlocks.SAPLING_C0_24ST, LegacyBlocks.POTTED_SAPLING_C0_24ST, LegacyBlocks.DANDELION_C0_0_20A,
                LegacyBlocks.POTTED_DANDELIONS_C0_0_20A, LegacyBlocks.ROSE_C0_0_20A, LegacyBlocks.POTTED_ROSE_C0_0_20A,
                LegacyBlocks.RED_MUSHROOM_C0_0_20A, LegacyBlocks.POTTED_RED_MUSHROOM_C0_0_20A, LegacyBlocks.BROWN_MUSHROOM_C0_0_20A,
                LegacyBlocks.POTTED_BROWN_MUSHROOM_C0_0_20A, LegacyBlocks.POPPY_1_7, LegacyBlocks.POTTED_POPPY_1_7,
                LegacyBlocks.LADDER_INF20100607, LegacyBlocks.LADDER_INF20100618, LegacyBlocks.LEAVES_C0_0_14A,
                LegacyBlocks.LEAVES_C0_0_15A, LegacyBlocks.LEAVES_C0_24ST, LegacyBlocks.GLASS_C0_0_19A, LegacyBlocks.TORCH_IN20100124_2,
                LegacyBlocks.WALL_TORCH_IN20100124_2, LegacyBlocks.WOODEN_DOOR_INF20100607, LegacyBlocks.REDSTONE_TORCH_A1_0_1,
                LegacyBlocks.REDSTONE_WALL_TORCH_A1_0_1);
        BlockRenderLayerMap.INSTANCE.putBlocks(class_1921.method_23583(), LegacyBlocks.ICE_A1_0_4);


        BlocktopiaBoatClientHelper.registerModelLayers(BoatInit.PALM_BOAT_ID, false);

        class_3929.method_17542(ScreenHandlerTypeInit.SMALL_CHEST_INVENTORY_SCREEN_HANDLER, SmallChestInventoryScreen::new);

        EntityRendererRegistry.register(Blocktopia.BOAT, (context) -> {
            return new BlocktopiaBoatEntityRenderer(context, false);
        });
        EntityRendererRegistry.register(Blocktopia.CHEST_BOAT, (context) -> {
            return new BlocktopiaBoatEntityRenderer(context, true);
        });
    }
}
