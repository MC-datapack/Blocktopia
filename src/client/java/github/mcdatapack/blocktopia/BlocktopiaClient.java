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

    }
}
