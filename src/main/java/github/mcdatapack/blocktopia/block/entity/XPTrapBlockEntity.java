package github.mcdatapack.blocktopia.block.entity;

import github.mcdatapack.blocktopia.init.BlockEntityTypeInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class XPTrapBlockEntity extends BlockEntity {
    private BlockState copiedBlockState = BlockInit.XP_TRAP.getDefaultState();

    public XPTrapBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypeInit.XP_TRAP, pos, state);
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
        tag.putString("CopiedBlock", Registries.BLOCK.getId(copiedBlockState.getBlock()).toString());
    }

    @Override
    public void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(tag, lookup);
        Identifier blockId = Identifier.of(tag.getString("CopiedBlock"));
        copiedBlockState = Registries.BLOCK.get(blockId).getDefaultState();
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup lookup) {
        NbtCompound tag = new NbtCompound();
        this.writeNbt(tag, lookup);
        return tag;
    }
}
