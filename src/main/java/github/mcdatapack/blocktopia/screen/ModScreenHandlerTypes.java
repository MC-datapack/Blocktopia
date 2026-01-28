package github.mcdatapack.blocktopia.screen;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.network.BlockPosPayload;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.*;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public interface ModScreenHandlerTypes {
    ScreenHandlerType<SmallChestInventoryScreenHandler> SMALL_CHEST_INVENTORY_SCREEN_HANDLER =
            register("small_chest_inventory", SmallChestInventoryScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    ScreenHandlerType<LegacyCutterScreenHandler> LEGACY_CUTTER_INVENTORY_SCREEN_HANDLER = register("legacy_cutter_inventory", LegacyCutterScreenHandler::new);
    ScreenHandlerType<WoodCutterScreenHandler> WOOD_CUTTER_INVENTORY_SCREEN_HANDLER = register("wood_cutter_inventory", WoodCutterScreenHandler::new);
    ScreenHandlerType<DuperScreenHandler> DUPER_INVENTORY_SCREEN_HANDLER =
            register("duper_inventory", DuperScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    ScreenHandlerType<FluidTankScreenHandler> FLUID_TANK =
            register("fluid_tank", FluidTankScreenHandler::new, BlockPosPayload.PACKET_CODEC);
    ScreenHandlerType<GoldAnvilScreenHandler> GOLD_ANVIL = register("gold_anvil", GoldAnvilScreenHandler::new);
    ScreenHandlerType<DiamondAnvilScreenHandler> DIAMOND_ANVIL = register("diamond_anvil", DiamondAnvilScreenHandler::new);
    ScreenHandlerType<NetheriteAnvilScreenHandler> NETHERITE_ANVIL = register("netherite_anvil", NetheriteAnvilScreenHandler::new);


    private static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, Blocktopia.id(name), new ExtendedScreenHandlerType<>(factory, codec));
    }
    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }
    static void load() {}
}
