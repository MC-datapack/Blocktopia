package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;

public class ExtendedRepeaterBlockSecond extends ExtendedRepeaterBlock {
    public static final MapCodec<ExtendedRepeaterBlock> CODEC = createCodec(ExtendedRepeaterBlockSecond::new);
    public ExtendedRepeaterBlockSecond(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ExtendedRepeaterBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected int getUpdateDelayInternal(BlockState state) {
        return state.get(DELAY) * 20;
    }
}