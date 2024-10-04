package github.mcdatapack.blocktopia.sign.api.block;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaHangingSign;
import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_7715;

public class BlocktopiaWallHangingSignBlock extends class_7715 implements BlocktopiaHangingSign {
    private final class_2960 texture;
    private final class_2960 guiTexture;

    public BlocktopiaWallHangingSignBlock(class_2960 texture, class_2960 guiTexture, class_2251 settings) {
        super(class_4719.field_21676, BlockSettingsLock.lock(settings));
        this.texture = texture;
        this.guiTexture = guiTexture;
    }

    @Override
    public class_2960 getTexture() {
        return texture;
    }

    @Override
    public class_2960 getGuiTexture() {
        return guiTexture;
    }
}
