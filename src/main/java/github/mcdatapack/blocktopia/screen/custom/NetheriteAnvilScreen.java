package github.mcdatapack.blocktopia.screen.custom;

import github.mcdatapack.blocktopia.screen.custom.screenhandler.NetheriteAnvilScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class NetheriteAnvilScreen extends ExtendedAnvilScreen<NetheriteAnvilScreenHandler> {
    public NetheriteAnvilScreen(NetheriteAnvilScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
