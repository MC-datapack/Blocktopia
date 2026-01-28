package github.mcdatapack.blocktopia.enchantment.effects;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class IceLevelledBlockStateProvider implements LevelledBlockStateProvider {
    @Override
    public BlockStateProvider create(int level) {
        if (level < 25)
            return BlockStateProvider.of(Blocks.FROSTED_ICE);
        else if (level < 50)
            return BlockStateProvider.of(Blocks.ICE);
        else if (level < 100)
            return new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(Blocks.ICE.getDefaultState(), 100 - (level - 50))
                    .add(Blocks.PACKED_ICE.getDefaultState(), (level - 50))
                    .build());
        else if (level < 150)
            return BlockStateProvider.of(Blocks.PACKED_ICE);
        else if (level < 200)
            return new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(Blocks.PACKED_ICE.getDefaultState(), 200 - (level - 150))
                    .add(Blocks.BLUE_ICE.getDefaultState(), (level - 150))
                    .build());
        else
            return BlockStateProvider.of(Blocks.BLUE_ICE);
    }
}
