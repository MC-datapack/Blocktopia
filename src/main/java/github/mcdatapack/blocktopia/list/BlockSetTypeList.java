package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;

public class BlockSetTypeList {
    public static final BlockSetType PALM = new BlockSetTypeBuilder()
            .register(Blocktopia.id("palm"));
    public static final BlockSetType BANANA = new BlockSetTypeBuilder()
            .register(Blocktopia.id("banana"));
    public static final BlockSetType CORN = new BlockSetTypeBuilder()
            .register(Blocktopia.id("corn"));
    public static final BlockSetType POISONED = new BlockSetTypeBuilder()
            .register(Blocktopia.id("poisoned"));
    public static final BlockSetType WOODEN_C0_0_15A = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"));
}
