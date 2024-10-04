package github.mcdatapack.blocktopia.network;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.class_2338;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public record BlockPosPayload(class_2338 pos) implements class_8710 {
    public static final class_9154<BlockPosPayload> ID = new class_9154<>(Blocktopia.id("block_pos"));
    public static final class_9139<class_9129, BlockPosPayload> PACKET_CODEC =
            class_9139.method_56434(class_2338.field_48404, BlockPosPayload::pos, BlockPosPayload::new);

    @Override
    public class_9154<? extends class_8710> method_56479() {
        return ID;
    }
}
