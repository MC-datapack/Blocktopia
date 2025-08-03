package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.block.LegacyBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(NetherPortal.class)
public class NetherPortalMixin {
    @Shadow @Mutable private static AbstractBlock.ContextPredicate IS_VALID_FRAME_BLOCK = (state, world, pos) ->
            state.isOf(Blocks.OBSIDIAN) || state.isOf(LegacyBlocks.OBSIDIAN_C0_28A) || state.isOf(Blocks.CRYING_OBSIDIAN) || state.isOf(LegacyBlocks.CRYING_OBSIDIAN_B1_3);
}
