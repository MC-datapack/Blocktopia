package github.mcdatapack.blocktopia.block;

import github.mcdatapack.blocktopia.Blocktopia;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;

public interface ModBlockSetTypes {
    BlockSetType PALM = new BlockSetTypeBuilder()
            .register(Blocktopia.id("palm"));
    BlockSetType BANANA = new BlockSetTypeBuilder()
            .register(Blocktopia.id("banana"));
    BlockSetType CORN = new BlockSetTypeBuilder()
            .register(Blocktopia.id("corn"));
    BlockSetType POISONED = new BlockSetTypeBuilder()
            .register(Blocktopia.id("poisoned"));
    BlockSetType MAHOGANY = new BlockSetTypeBuilder()
            .register(Blocktopia.id("mahogany"));
    BlockSetType WOODEN_C0_0_15A = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"));
}
