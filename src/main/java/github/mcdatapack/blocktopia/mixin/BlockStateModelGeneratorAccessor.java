package github.mcdatapack.blocktopia.mixin;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TexturedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(BlockStateModelGenerator.class)
public interface BlockStateModelGeneratorAccessor {
    @Accessor("texturedModels")
    Map<Block, TexturedModel> getTextureModels();

    @Accessor("texturedModels")
    @Mutable
    void setTextureModels(Map<Block, TexturedModel> blockTexturedModelMap);
}
