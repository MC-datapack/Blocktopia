package github.mcdatapack.blocktopia.block;

import github.mcdatapack.more_tools_and_armor.item.PaxelItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class StrippableLogBlock extends PillarBlock {
    private final Block strippedState;

    public StrippableLogBlock(Block strippedState, AbstractBlock.Settings settings) {
        super(settings);
        this.strippedState = strippedState;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandStack();
        Item item = itemStack.getItem();

        if (item instanceof AxeItem || item instanceof PaxelItem) {
            world.setBlockState(pos, strippedState.getDefaultState());
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hit);
    }
}
