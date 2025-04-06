package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;

public class WoodTypeList {
    public static final WoodType PALM = new WoodTypeBuilder()
            .register(Blocktopia.id("palm"), BlockSetTypeList.PALM);
    public static final WoodType BANANA = new WoodTypeBuilder()
            .register(Blocktopia.id("banana"), BlockSetTypeList.BANANA);
    public static final WoodType CORN = new WoodTypeBuilder()
            .register(Blocktopia.id("corn"), BlockSetTypeList.CORN);
    public static final WoodType POISONED = new WoodTypeBuilder()
            .register(Blocktopia.id("poisoned"), BlockSetTypeList.POISONED);
    public static final WoodType WOOD_C0_0_15A = new WoodTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"), BlockSetTypeList.WOODEN_C0_0_15A);
}
