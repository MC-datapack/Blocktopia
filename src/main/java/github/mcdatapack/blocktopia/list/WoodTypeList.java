package github.mcdatapack.blocktopia.list;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class WoodTypeList {
    public static final WoodType PALM = new WoodType(Blocktopia.id("palm").toString(),
            BlockSetTypeList.PALM,
            BlockSoundGroup.WOOD,
            BlockSoundGroup.HANGING_SIGN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_FENCE_GATE_OPEN
    );
    public static final WoodType WOOD_C0_0_15A = new WoodType(Blocktopia.id("wooden_c0_0_15a").toString(),
            BlockSetTypeList.WOODEN_C0_0_15A,
            BlockSoundGroup.WOOD,
            BlockSoundGroup.HANGING_SIGN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_FENCE_GATE_OPEN
    );
}
