package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.WoodType;

public class WoodTypeList {
    public static final WoodType PALM = WoodType.register(new WoodType(Blocktopia.id("palm").toString(), BlockSetTypeList.PALM));
    public static final WoodType BANANA = WoodType.register(new WoodType(Blocktopia.id("banana").toString(), BlockSetTypeList.BANANA));
    public static final WoodType CORN = WoodType.register(new WoodType(Blocktopia.id("banana").toString(), BlockSetTypeList.CORN));
    public static final WoodType POISONED = WoodType.register(new WoodType(Blocktopia.id("poisoned").toString(), BlockSetTypeList.POISONED));
    public static final WoodType WOOD_C0_0_15A = WoodType.register(new WoodType(Blocktopia.id("wooden_c0_0_15a").toString(), BlockSetTypeList.WOODEN_C0_0_15A));
}
