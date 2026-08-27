package github.mcdatapack.blocktopia.block.entity.custom;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.block.entity.ModBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class XPTrapBlockEntity extends BlockEntity {
    private BlockState copiedBlockState = ModBlocks.XP_TRAP.getDefaultState();

    public XPTrapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.XP_TRAP, pos, state);
    }

    public BlockState getCopiedBlockState() {
        return copiedBlockState;
    }

    public void setCopiedBlockState(BlockState copiedBlockState) {
        this.copiedBlockState = copiedBlockState;
    }

    @Override
    public void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(tag, lookup);
        tag.put("state", NbtHelper.fromBlockState(copiedBlockState));
    }

    @Override
    public void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(tag, lookup);
        copiedBlockState = NbtHelper.toBlockState(lookup.getWrapperOrThrow(RegistryKeys.BLOCK), tag.getCompound("state"));
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup lookup) {
        NbtCompound tag = new NbtCompound();
        this.writeNbt(tag, lookup);
        return tag;
    }
}
