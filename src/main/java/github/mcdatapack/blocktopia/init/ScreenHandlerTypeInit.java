package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screenhandler.SmallChestInventoryScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlerTypeInit {
    public static final ScreenHandlerType<SmallChestInventoryScreenHandler> SMALL_CHEST_INVENTORY_SCREEN_HANDLER =
            register("small_chest_invetory", SmallChestInventoryScreenHandler::new, BlockPosPayload.PACKET_CODEC);


    public static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, Blocktopia.id(name), new ExtendedScreenHandlerType<>(factory, codec));
    }
    public static void load() {}
}
