package github.mcdatapack.blocktopia.mixin;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import github.mcdatapack.blocktopia.init.worldgen.BiomeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.logging.Logger;

import static net.minecraft.block.cauldron.CauldronBehavior.emptyCauldron;
import static net.minecraft.block.cauldron.CauldronBehavior.fillCauldron;

@Mixin(CauldronBlock.class)
public abstract class MixinCauldronBlock {

    private static final Logger LOGGER = Logger.getLogger(MixinCauldronBlock.class.getName());

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void registerCustomFluidBehavior(CallbackInfo ci) {
        CauldronBehavior FILL_WITH_TROPICAL_WATER = (state, world, pos, player, hand, stack) -> fillCauldron(
                world, pos, player, hand, stack, BlockInit.TROPICAL_WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY
        );
        Map<Item, CauldronBehavior> map = CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map();
        if (map == null) {
            LOGGER.severe("EMPTY_CAULDRON_BEHAVIOR map is null!");
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

    @Inject(method = "precipitationTick", at = @At("HEAD"), cancellable = true)
    public void onPrecipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation, CallbackInfo ci) {
        LOGGER.info("Mixin applied: Precipitation Tick method called.");
        if (world instanceof ServerWorld) {
            if (this.canFillWithPrecipitation(world, precipitation)) {
                RegistryKey<Biome> biome = world.getBiome(pos).getKeyOrValue().orThrow();

                LOGGER.info("Current biome: " + (biome != null ? biome.getValue().toString() : "null"));

                if (biome == null) {
                    return;
                }

                if (biome.equals(BiomeInit.RAIN_FOREST_KEY) || biome.equals(BiomeInit.PALM_ISLAND_KEY)) {
                    LOGGER.info("Filling cauldron with tropical water in biome: " + biome.getValue().toString());
                    world.setBlockState(pos, BlockInit.TROPICAL_WATER_CAULDRON.getDefaultState());
                    world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
                    ci.cancel();
                } else if (precipitation == Biome.Precipitation.RAIN) {
                    LOGGER.info("Filling cauldron with water in biome: " + biome.getValue().toString());
                    world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState());
                    world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
                } else if (precipitation == Biome.Precipitation.SNOW) {
                    LOGGER.info("Filling cauldron with powder snow in biome: " + biome.getValue().toString());
                    world.setBlockState(pos, Blocks.POWDER_SNOW_CAULDRON.getDefaultState());
                    world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
                }
            }
        }
    }

    protected boolean canFillWithPrecipitation(World world, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return world.getRandom().nextFloat() < 0.05F;
        } else {
            return precipitation == Biome.Precipitation.SNOW ? world.getRandom().nextFloat() < 0.1F : false;
        }
    }
}
