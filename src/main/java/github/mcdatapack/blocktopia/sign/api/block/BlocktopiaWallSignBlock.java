package github.mcdatapack.blocktopia.sign.api.block;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class BlocktopiaWallSignBlock extends WallSignBlock implements BlocktopiaSign {
    private final Identifier texture;

    public BlocktopiaWallSignBlock(Identifier texture, Settings settings) {
        super(WoodType.OAK, BlockSettingsLock.lock(settings));
        this.texture = texture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}
