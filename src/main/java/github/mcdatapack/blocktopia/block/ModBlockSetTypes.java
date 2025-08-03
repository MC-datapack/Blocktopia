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
    BlockSetType WOOD_RD20090515 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_rd20090515"));
    BlockSetType WOOD_RD161348 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_rd161348"));
    BlockSetType WOOD_C0_0_14A = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_14a"));
    BlockSetType WOOD_C0_0_15A = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_c0_0_15a"));
    BlockSetType WOOD_B1_9PRE5 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("wooden_b1_9pre5"));
    BlockSetType BIRCH_B1_2 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("birch_b1_2"));
    BlockSetType SPRUCE_B1_2 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("spruce_b1_2"));
    BlockSetType JUNGLE_1_2 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("jungle_1_2"));
    BlockSetType ACACIA_1_7 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("acacia_1_7"));
    BlockSetType DARK_OAK_1_7 = new BlockSetTypeBuilder()
            .register(Blocktopia.id("dark_oak_1_7"));
    BlockSetType PALE_OAK = new BlockSetTypeBuilder()
            .register(Blocktopia.id("pale_oak"));
}
