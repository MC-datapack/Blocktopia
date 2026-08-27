package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.api.BlockStateModelAccessor;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TexturedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(BlockStateModelGenerator.class)
public interface BlockStateModelGeneratorAccessor extends BlockStateModelAccessor {
    @Accessor("texturedModels")
    @Override
    Map<Block, TexturedModel> blocktopia$getTextureModels();

    @Accessor("texturedModels")
    @Mutable
    @Override
    void blocktopia$setTextureModels(Map<Block, TexturedModel> blockTexturedModelMap);
}
