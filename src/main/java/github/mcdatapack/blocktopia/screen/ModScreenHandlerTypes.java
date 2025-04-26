package github.mcdatapack.blocktopia.screen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.DuperScreenHandler;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.LegacyCutterScreenHandler;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.SmallChestInventoryScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public interface ModScreenHandlerTypes {
    ScreenHandlerType<SmallChestInventoryScreenHandler> SMALL_CHEST_INVENTORY_SCREEN_HANDLER =
            register("small_chest_invetory", SmallChestInventoryScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    ScreenHandlerType<LegacyCutterScreenHandler> LEGACY_CUTTER_INVENTORY_SCREEN_HANDLER =
            register("legacy_cutter_inventory", LegacyCutterScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    ScreenHandlerType<DuperScreenHandler> DUPER_INVENTORY_SCREEN_HANDLER =
            register("duper_inventory", DuperScreenHandler::new, BlockPosPayload.PACKET_CODEC);


    private static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, Blocktopia.id(name), new ExtendedScreenHandlerType<>(factory, codec));
    }
    static void load() {}
}
