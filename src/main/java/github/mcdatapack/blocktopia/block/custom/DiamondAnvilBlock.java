package github.mcdatapack.blocktopia.block.custom;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.DiamondAnvilScreenHandler;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondAnvilBlock extends AnvilBlock {
    private static final Text TITLE = Text.translatable("container.repair");

    public DiamondAnvilBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new DiamondAnvilScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE
        );
    }


    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(5.0F, 250);
    }

    @Nullable
    public static BlockState getLandingState(BlockState fallingState) {
        if (fallingState.isOf(ModBlocks.DIAMOND_ANVIL)) {
            return ModBlocks.CHIPPED_DIAMOND_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING));
        } else {
            return fallingState.isOf(ModBlocks.CHIPPED_DIAMOND_ANVIL) ? ModBlocks.DAMAGED_DIAMOND_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING)) : null;
        }
    }
}
