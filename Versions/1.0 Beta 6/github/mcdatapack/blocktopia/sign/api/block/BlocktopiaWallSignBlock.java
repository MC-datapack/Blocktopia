package github.mcdatapack.blocktopia.sign.api.block;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.class_2551;
import net.minecraft.class_2960;
import net.minecraft.class_4719;

public class BlocktopiaWallSignBlock extends class_2551 implements BlocktopiaSign {
    private final class_2960 texture;

    public BlocktopiaWallSignBlock(class_2960 texture, class_2251 settings) {
        super(class_4719.field_21676, BlockSettingsLock.lock(settings));
        this.texture = texture;
    }

    @Override
    public class_2960 getTexture() {
        return texture;
    }
}
