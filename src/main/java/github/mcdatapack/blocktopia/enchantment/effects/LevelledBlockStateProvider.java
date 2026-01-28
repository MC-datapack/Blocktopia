package github.mcdatapack.blocktopia.enchantment.effects;

import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public interface LevelledBlockStateProvider {
    BlockStateProvider create(int level);
}
