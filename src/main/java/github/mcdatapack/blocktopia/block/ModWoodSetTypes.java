package github.mcdatapack.blocktopia.block;

import github.mcdatapack.blocktopia.Blocktopia;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;

public interface ModWoodSetTypes {
    WoodType PALM = new WoodTypeBuilder()
            .register(Blocktopia.id("palm"), ModBlockSetTypes.PALM);
    WoodType BANANA = new WoodTypeBuilder()
            .register(Blocktopia.id("banana"), ModBlockSetTypes.BANANA);
    WoodType CORN = new WoodTypeBuilder()
            .register(Blocktopia.id("corn"), ModBlockSetTypes.CORN);
    WoodType POISONED = new WoodTypeBuilder()
            .register(Blocktopia.id("poisoned"), ModBlockSetTypes.POISONED);
    WoodType MAHOGANY = new WoodTypeBuilder()
            .register(Blocktopia.id("poisoned"), ModBlockSetTypes.MAHOGANY);
    WoodType WOOD_RD20090515 = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_rd20090515"), ModBlockSetTypes.WOOD_RD20090515);
    WoodType WOOD_RD161348 = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_rd161348"), ModBlockSetTypes.WOOD_RD161348);
    WoodType WOOD_C0_0_14A = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_14a"), ModBlockSetTypes.WOOD_C0_0_14A);
    WoodType WOOD_C0_0_15A = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"), ModBlockSetTypes.WOOD_C0_0_15A);
    WoodType WOOD_B1_9PRE5 = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_b1_9pre5"), ModBlockSetTypes.WOOD_B1_9PRE5);
    WoodType BIRCH_B1_2 = new WoodTypeBuilder()
            .register(Blocktopia.id("birch_b1_2"), ModBlockSetTypes.BIRCH_B1_2);
    WoodType SPRUCE_B1_2 = new WoodTypeBuilder()
            .register(Blocktopia.id("spruce_b1_2"), ModBlockSetTypes.SPRUCE_B1_2);
    WoodType JUNGLE_1_2 = new WoodTypeBuilder()
            .register(Blocktopia.id("jungle_1_2"), ModBlockSetTypes.JUNGLE_1_2);
    WoodType ACACIA_1_7 = new WoodTypeBuilder()
            .register(Blocktopia.id("acacia_1_7"), ModBlockSetTypes.ACACIA_1_7);
    WoodType DARK_OAK_1_7 = new WoodTypeBuilder()
            .register(Blocktopia.id("dark_oak_1_7"), ModBlockSetTypes.DARK_OAK_1_7);
    WoodType PALE_OAK = new WoodTypeBuilder()
            .register(Blocktopia.id("pale_oak"), ModBlockSetTypes.PALE_OAK);
}
