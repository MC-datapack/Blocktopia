package github.mcdatapack.blocktopia.init;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BoatInit {
    public static final Identifier PALM_BOAT_ID = Blocktopia.id("palm_boat");
    public static final Identifier PALM_CHEST_BOAT_ID = Blocktopia.id("palm_chest_boat");
    public static final RegistryKey<BlocktopiaBoatType> PALM_BOAT_KEY = BlocktopiaBoatTypeRegistry.createKey(PALM_BOAT_ID);
    public static BlocktopiaBoatType PALM_TYPE;

    public static BlocktopiaBoatType register(RegistryKey<BlocktopiaBoatType> key, BlocktopiaBoatType type) {
        return Registry.register(BlocktopiaBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        PALM_TYPE = register(PALM_BOAT_KEY, new BlocktopiaBoatType.Builder().item(ItemInit.PALM_BOAT).chestItem(ItemInit.PALM_CHEST_BOAT)
                .planks(BlockInit.PALM_PLANKS.asItem()).build());
    }
}
