package github.mcdatapack.blocktopia.screen.custom.screenhandler;

import github.mcdatapack.blocktopia.block.custom.GoldAnvilBlock;
import github.mcdatapack.blocktopia.screen.ModScreenHandlerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class GoldAnvilScreenHandler extends AbstractExtendedAnvilScreenHandler {
    public GoldAnvilScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, ScreenHandlerContext.EMPTY);
    }

    public GoldAnvilScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext context) {
        super(ModScreenHandlerTypes.GOLD_ANVIL, syncId, inventory, context);
    }

    @Override
    protected int getMaxEnchantmentLevel() {
        return 25;
    }

    @Override
    protected BlockState damageState(BlockState state) {
        return GoldAnvilBlock.getLandingState(state);
    }

    @Override
    protected int getMaxXpLevel() {
        return Short.MAX_VALUE / 4;
    }
}
