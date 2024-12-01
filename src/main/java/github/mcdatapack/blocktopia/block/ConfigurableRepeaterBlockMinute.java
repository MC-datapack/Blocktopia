package github.mcdatapack.blocktopia.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;

public class ConfigurableRepeaterBlockMinute extends ConfigurableRepeaterBlock {
    public static final MapCodec<ConfigurableRepeaterBlock> CODEC = createCodec(ConfigurableRepeaterBlockMinute::new);
    public ConfigurableRepeaterBlockMinute(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ConfigurableRepeaterBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected int getUpdateDelayInternal(BlockState state) {
        return state.get(DELAY) * 1200;
    }
}
