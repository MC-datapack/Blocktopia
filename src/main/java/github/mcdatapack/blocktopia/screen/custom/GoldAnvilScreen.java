package github.mcdatapack.blocktopia.screen.custom;

import github.mcdatapack.blocktopia.screen.custom.screenhandler.GoldAnvilScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class GoldAnvilScreen extends ExtendedAnvilScreen<GoldAnvilScreenHandler> {
    public GoldAnvilScreen(GoldAnvilScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
