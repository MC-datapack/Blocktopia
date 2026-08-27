package github.mcdatapack.blocktopia.screen.custom;

import github.mcdatapack.blocktopia.screen.custom.screenhandler.DiamondAnvilScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class DiamondAnvilScreen extends ExtendedAnvilScreen<DiamondAnvilScreenHandler> {
    public DiamondAnvilScreen(DiamondAnvilScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
