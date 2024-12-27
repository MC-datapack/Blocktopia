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

    public static final Identifier BANANA_BOAT_ID = Blocktopia.id("banana_boat");
    public static final Identifier BANANA_CHEST_BOAT_ID = Blocktopia.id("banana_chest_boat");
    public static final RegistryKey<BlocktopiaBoatType> BANANA_BOAT_KEY = BlocktopiaBoatTypeRegistry.createKey(BANANA_BOAT_ID);
    public static BlocktopiaBoatType BANANA_TYPE;

    public static BlocktopiaBoatType register(RegistryKey<BlocktopiaBoatType> key, BlocktopiaBoatType type) {
        return Registry.register(BlocktopiaBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        PALM_TYPE = register(PALM_BOAT_KEY, new BlocktopiaBoatType.Builder().item(ItemInit.PALM_BOAT).chestItem(ItemInit.PALM_CHEST_BOAT)
                .planks(BlockInit.PALM_PLANKS.asItem()).build());

        BANANA_TYPE = register(BANANA_BOAT_KEY, new BlocktopiaBoatType.Builder().item(ItemInit.BANANA_BOAT).chestItem(ItemInit.BANANA_CHEST_BOAT)
                .planks(BlockInit.BANANA_PLANKS.asItem()).build());
    }
}
