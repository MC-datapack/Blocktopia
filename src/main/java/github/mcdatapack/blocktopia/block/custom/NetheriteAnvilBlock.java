package github.mcdatapack.blocktopia.block.custom;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.screen.custom.screenhandler.NetheriteAnvilScreenHandler;
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

public class NetheriteAnvilBlock extends AnvilBlock {
    private static final Text TITLE = Text.translatable("container.repair");

    public NetheriteAnvilBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new NetheriteAnvilScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE
        );
    }


    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(10.0F, 5000);
    }

    @Nullable
    public static BlockState getLandingState(BlockState fallingState) {
        if (fallingState.isOf(ModBlocks.NETHERITE_ANVIL)) {
            return ModBlocks.CHIPPED_NETHERITE_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING));
        } else {
            return fallingState.isOf(ModBlocks.CHIPPED_NETHERITE_ANVIL) ? ModBlocks.DAMAGED_NETHERITE_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING)) : null;
        }
    }
}
