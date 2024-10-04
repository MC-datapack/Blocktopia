package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screenhandler.SmallChestInventoryScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.class_1703;
import net.minecraft.class_2378;
import net.minecraft.class_3917;
import net.minecraft.class_7923;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public class ScreenHandlerTypeInit {
    public static final class_3917<SmallChestInventoryScreenHandler> SMALL_CHEST_INVENTORY_SCREEN_HANDLER =
            register("small_chest_invetory", SmallChestInventoryScreenHandler::new, BlockPosPayload.PACKET_CODEC);


    public static <T extends class_1703, D extends class_8710> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, class_9139<? super class_9129, D> codec) {
        return class_2378.method_10230(class_7923.field_41187, Blocktopia.id(name), new ExtendedScreenHandlerType<>(factory, codec));
    }
    public static void load() {}
}
