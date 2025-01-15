package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;

import static net.minecraft.block.cauldron.CauldronBehavior.emptyCauldron;
import static net.minecraft.block.cauldron.CauldronBehavior.fillCauldron;

@Mixin(LeveledCauldronBlock.class)
public abstract class MixinLeveledCauldronBlock {

    private static final Logger LOGGER = Logger.getLogger(MixinLeveledCauldronBlock.class.getName());

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void registerCustomFluidBehavior(CallbackInfo ci) {
        CauldronBehavior FILL_WITH_TROPICAL_WATER = (state, world, pos, player, hand, stack) -> fillCauldron(
                world, pos, player, hand, stack, BlockInit.TROPICAL_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY
        );
        Map<Item, CauldronBehavior> map = CauldronBehavior.WATER_CAULDRON_BEHAVIOR.map();
        if (map == null) {
            LOGGER.severe("WATER_CAULDRON_BEHAVIOR map is null!");
            return;
        }
        map.put(ItemInit.TROPICAL_WATER_BUCKET, FILL_WITH_TROPICAL_WATER);
        map.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> emptyCauldron(
                state, world, pos, player, hand, stack, new ItemStack(ItemInit.TROPICAL_WATER_BUCKET), statex -> statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL
        ));
        Map<Item, CauldronBehavior> emptyMap = CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map();
        if (emptyMap == null) {
            LOGGER.severe("EMPTY_CAULDRON_BEHAVIOR map is null!");
            return;
        }
        emptyMap.put(ItemInit.TROPICAL_WATER_BUCKET, FILL_WITH_TROPICAL_WATER);
    }
}
