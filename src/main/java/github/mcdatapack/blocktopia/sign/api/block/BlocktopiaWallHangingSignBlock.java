package github.mcdatapack.blocktopia.sign.api.block;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaHangingSign;
import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class BlocktopiaWallHangingSignBlock extends WallHangingSignBlock implements BlocktopiaHangingSign {
    private final Identifier texture;
    private final Identifier guiTexture;

    public BlocktopiaWallHangingSignBlock(Identifier texture, Identifier guiTexture, Settings settings) {
        super(WoodType.OAK, BlockSettingsLock.lock(settings));
        this.texture = texture;
        this.guiTexture = guiTexture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }

    @Override
    public Identifier getGuiTexture() {
        return guiTexture;
    }
}
