package github.mcdatapack.blocktopia.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import github.mcdatapack.blocktopia.block.MinecraftVersion;
import github.mcdatapack.blocktopia.entity.ModBoats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Function;

import static github.mcdatapack.blocktopia.block.MinecraftVersions._1_21_4;
import static github.mcdatapack.blocktopia.block.MinecraftVersions._1_21_9;

public interface FutureItems {
    Item PALE_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALE_OAK_BOAT_ID, ModBoats.PALE_OAK_BOAT_KEY, false);
    Item PALE_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.PALE_OAK_CHEST_BOAT_ID, ModBoats.PALE_OAK_BOAT_KEY, true);
    Item RESIN_CLUMP = register("resin_clump", _1_21_4);
    Item RESIN_BRICK = register("resin_brick", _1_21_4);
    Item COPPER_NUGGET = register("copper_nugget", _1_21_9);

    private static Item register(String name, MinecraftVersion since) {
        return register(name, settings -> settings, since);
    }

    private static Item register(String name, Function<Item.Settings, Item.Settings> settings, MinecraftVersion since) {
        return ModItems.register(name, settings.apply(new Item.Settings()), itemSettings -> new Item(itemSettings) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("blocktopia.tooltip.future"));
                tooltip.add(Text.literal(since.getName() + "+"));
            }
        });
    }

    static void load() {}
}
