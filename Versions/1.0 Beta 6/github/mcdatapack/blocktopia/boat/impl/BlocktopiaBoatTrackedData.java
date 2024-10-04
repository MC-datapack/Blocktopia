package github.mcdatapack.blocktopia.boat.impl;

import java.util.Optional;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;


public final class BlocktopiaBoatTrackedData {
    private BlocktopiaBoatTrackedData() {
        return;
    }

    public static final class_9139<class_9129, Optional<BlocktopiaBoatType>> PACKET_CODEC = class_9135
            .method_56365(BlocktopiaBoatTypeRegistry.INSTANCE.method_30517())
            .method_56433(class_9135::method_56382);

    public static final class_2941<Optional<BlocktopiaBoatType>> HANDLER = class_2941.method_56031(PACKET_CODEC);

    public static void register() {
        class_2943.method_12720(HANDLER);
    }
}
