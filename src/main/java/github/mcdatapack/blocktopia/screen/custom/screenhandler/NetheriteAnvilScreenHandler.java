package github.mcdatapack.blocktopia.screen.custom.screenhandler;

import github.mcdatapack.blocktopia.block.custom.NetheriteAnvilBlock;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class NetheriteAnvilScreenHandler extends AbstractExtendedAnvilScreenHandler {
    public NetheriteAnvilScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, ScreenHandlerContext.EMPTY);
    }

    public NetheriteAnvilScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(ModScreenHandlerTypes.GOLD_ANVIL, syncId, inventory, context);
    }

    @Override
    protected int getMaxEnchantmentLevel() {
        return 255;
    }

    @Override
    protected BlockState damageState(BlockState state) {
        return NetheriteAnvilBlock.getLandingState(state);
    }

    @Override
    protected int getMaxXpLevel() {
        return Short.MAX_VALUE;
    }
}
