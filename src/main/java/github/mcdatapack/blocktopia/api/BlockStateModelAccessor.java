package github.mcdatapack.blocktopia.api;

import net.minecraft.block.Block;
import net.minecraft.data.client.TexturedModel;

import java.util.Map;

public interface BlockStateModelAccessor {
    Map<Block, TexturedModel> blocktopia$getTextureModels();
    void blocktopia$setTextureModels(Map<Block, TexturedModel> blockTexturedModelMap);
}
