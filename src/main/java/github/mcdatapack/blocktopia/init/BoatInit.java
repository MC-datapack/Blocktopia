package github.mcdatapack.blocktopia.init;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BoatInit {
    public static final Identifier PALM_BOAT_ID = Blocktopia.id("palm_boat");
    public static final Identifier PALM_CHEST_BOAT_ID = Blocktopia.id("palm_chest_boat");
    public static final RegistryKey<TerraformBoatType> PALM_BOAT_KEY = TerraformBoatTypeRegistry.createKey(PALM_BOAT_ID);
    public static TerraformBoatType PALM_TYPE;

    public static final Identifier BANANA_BOAT_ID = Blocktopia.id("banana_boat");
    public static final Identifier BANANA_CHEST_BOAT_ID = Blocktopia.id("banana_chest_boat");
    public static final RegistryKey<TerraformBoatType> BANANA_BOAT_KEY = TerraformBoatTypeRegistry.createKey(BANANA_BOAT_ID);
    public static TerraformBoatType BANANA_TYPE;

    public static final Identifier CORN_BOAT_ID = Blocktopia.id("corn_boat");
    public static final Identifier CORN_CHEST_BOAT_ID = Blocktopia.id("corn_chest_boat");
    public static final RegistryKey<TerraformBoatType> CORN_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CORN_BOAT_ID);
    public static TerraformBoatType CORN_TYPE;

    public static TerraformBoatType register(RegistryKey<TerraformBoatType> key, TerraformBoatType type) {
        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        PALM_TYPE = register(PALM_BOAT_KEY, new TerraformBoatType.Builder().item(ItemInit.PALM_BOAT).chestItem(ItemInit.PALM_CHEST_BOAT)
                .planks(BlockInit.PALM_PLANKS.asItem()).build());

        BANANA_TYPE = register(BANANA_BOAT_KEY, new TerraformBoatType.Builder().item(ItemInit.BANANA_BOAT).chestItem(ItemInit.BANANA_CHEST_BOAT)
                .planks(BlockInit.BANANA_PLANKS.asItem()).build());

        CORN_TYPE = register(CORN_BOAT_KEY, new TerraformBoatType.Builder().item(ItemInit.CORN_BOAT).chestItem(ItemInit.CORN_CHEST_BOAT)
                .planks(BlockInit.CORN_PLANKS.asItem()).build());
    }
}
