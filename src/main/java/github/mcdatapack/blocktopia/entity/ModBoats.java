package github.mcdatapack.blocktopia.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public abstract class ModBoats {
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

    public static final Identifier POISONED_BOAT_ID = Blocktopia.id("poisoned_boat");
    public static final Identifier POISONED_CHEST_BOAT_ID = Blocktopia.id("poisoned_chest_boat");
    public static final RegistryKey<TerraformBoatType> POISONED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(POISONED_BOAT_ID);
    public static TerraformBoatType POISONED_TYPE;

    public static final Identifier MAHOGANY_BOAT_ID = Blocktopia.id("mahogany_boat");
    public static final Identifier MAHOGANY_CHEST_BOAT_ID = Blocktopia.id("mahogany_chest_boat");
    public static final RegistryKey<TerraformBoatType> MAHOGANY_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MAHOGANY_BOAT_ID);
    public static TerraformBoatType MAHOGANY_TYPE;

    public static TerraformBoatType register(RegistryKey<TerraformBoatType> key, TerraformBoatType type) {
        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void load() {
        PALM_TYPE = register(PALM_BOAT_KEY, new TerraformBoatType.Builder().item(ModItems.PALM_BOAT).chestItem(ModItems.PALM_CHEST_BOAT)
                .planks(ModBlocks.PALM_PLANKS.asItem()).build());

        BANANA_TYPE = register(BANANA_BOAT_KEY, new TerraformBoatType.Builder().item(ModItems.BANANA_BOAT).chestItem(ModItems.BANANA_CHEST_BOAT)
                .planks(ModBlocks.BANANA_PLANKS.asItem()).build());

        CORN_TYPE = register(CORN_BOAT_KEY, new TerraformBoatType.Builder().item(ModItems.CORN_BOAT).chestItem(ModItems.CORN_CHEST_BOAT)
                .planks(ModBlocks.CORN_PLANKS.asItem()).build());
        POISONED_TYPE = register(POISONED_BOAT_KEY, new TerraformBoatType.Builder().item(ModItems.POISONED_BOAT).chestItem(ModItems.POISONED_CHEST_BOAT)
                .planks(ModBlocks.POISONED_PLANKS.asItem()).build());
        MAHOGANY_TYPE = register(MAHOGANY_BOAT_KEY, new TerraformBoatType.Builder().item(ModItems.MAHOGANY_BOAT).chestItem(ModItems.MAHOGANY_CHEST_BOAT)
                .planks(ModBlocks.MAHOGANY_PLANKS.asItem()).build());
    }
}
