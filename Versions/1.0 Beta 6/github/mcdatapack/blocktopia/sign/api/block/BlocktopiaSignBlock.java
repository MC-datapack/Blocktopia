package github.mcdatapack.blocktopia.sign.api.block;

import github.mcdatapack.blocktopia.sign.api.BlocktopiaSign;
import github.mcdatapack.blocktopia.sign.impl.BlockSettingsLock;
import net.minecraft.class_2508;
import net.minecraft.class_2960;
import net.minecraft.class_4719;

public class BlocktopiaSignBlock extends class_2508 implements BlocktopiaSign {
    private final class_2960 texture;

    public BlocktopiaSignBlock(class_2960 texture, class_2251 settings) {
        super(class_4719.field_21676, BlockSettingsLock.lock(settings));
        this.texture = texture;
    }

    @Override
    public class_2960 getTexture() {
        return texture;
    }
}
