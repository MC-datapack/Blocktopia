package github.mcdatapack.blocktopia.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import github.mcdatapack.blocktopia.block.MinecraftVersion;
import github.mcdatapack.blocktopia.entity.custom.ChairEntity;
import github.mcdatapack.blocktopia.entity.ModEntityTypes;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static github.mcdatapack.blocktopia.block.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.block.LegacyBlocks.ROSE_CLOTH;

public class ChairBlock extends HorizontalFacingBlock {
    private static final MapCodec<ChairBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Block.CODEC.fieldOf("plank").forGetter(block -> block.plank),
                    Block.CODEC.fieldOf("seat").forGetter(block -> block.seat),
                    Settings.CODEC.fieldOf("settings").forGetter(ChairBlock::getSettings))
                    .apply(instance, ChairBlock::new));
    public final Block plank;
    public final Block seat;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

    public ChairBlock(Block plank, Block seat, Settings settings) {
        super(settings);
        this.plank = plank;
        this.seat = seat;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient() && !player.isSneaking()) {
            Entity entity;
            List<ChairEntity> entities = world.getEntitiesByType(ModEntityTypes.CHAIR, new Box(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntityTypes.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.getFirst();
            }

            player.startRiding(entity);

            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        world.getEntitiesByType(ModEntityTypes.CHAIR, new Box(pos), chair -> true).forEach(Entity::kill);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public static class ChairBlocks {
        public static Function[] create(Block plank) {
            Block[] seats = {
                    plank, Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL,
                    Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL,
                    Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL,
                    Blocks.RED_WOOL, Blocks.BLACK_WOOL, CHARTREUSE_CLOTH, SPRING_GREEN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, ROSE_CLOTH
            };
            return Arrays.stream(seats)
                    .map(seat -> (Function<Settings, ChairBlock>) settings -> new ChairBlock(
                            plank, seat, settings
                            .mapColor(plank.getDefaultMapColor())
                            .strength(plank.getHardness(), plank.getBlastResistance())
                            .sounds(plank.getDefaultState().getSoundGroup())
                            )
                    )
                    .toArray(Function[]::new);
        }

        public static Function[] createLegacy(Block plank, MinecraftVersion from, MinecraftVersion to) {
            class LegacyChairBlock extends ChairBlock {
                public LegacyChairBlock(Block plank, Block seat, Settings settings) {
                    super(plank, seat, settings);
                }

                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("blocktopia.tooltip.legacy"));
                    tooltip.add(Text.literal(from.getName() + " - " + to.getName()));
                }
            }

            Block[] seats = {
                    plank, Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL,
                    Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL,
                    Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL,
                    Blocks.RED_WOOL, Blocks.BLACK_WOOL, CHARTREUSE_CLOTH, SPRING_GREEN_CLOTH, CAPRI_CLOTH, ULTRAMARINE_CLOTH, VIOLET_CLOTH, ROSE_CLOTH
            };
            return Arrays.stream(seats)
                    .map(seat -> (Function<Settings, ChairBlock>) settings -> new LegacyChairBlock(
                                    plank, seat, settings
                                    .mapColor(plank.getDefaultMapColor())
                                    .strength(plank.getHardness(), plank.getBlastResistance())
                                    .sounds(plank.getDefaultState().getSoundGroup())
                            )
                    )
                    .toArray(Function[]::new);
        }
    }
}
