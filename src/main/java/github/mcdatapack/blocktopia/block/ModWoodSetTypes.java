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
    WoodType WOOD_C0_0_15A = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"), ModBlockSetTypes.WOODEN_C0_0_15A);
}
