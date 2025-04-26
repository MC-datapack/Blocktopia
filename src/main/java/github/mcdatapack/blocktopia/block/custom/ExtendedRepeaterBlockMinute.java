package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;

public class ExtendedRepeaterBlockMinute extends ExtendedRepeaterBlock {
    public static final MapCodec<ExtendedRepeaterBlock> CODEC = createCodec(ExtendedRepeaterBlockMinute::new);

    public ExtendedRepeaterBlockMinute(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ExtendedRepeaterBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected int getUpdateDelayInternal(BlockState state) {
        return state.get(DELAY) * 1200;
    }
}
