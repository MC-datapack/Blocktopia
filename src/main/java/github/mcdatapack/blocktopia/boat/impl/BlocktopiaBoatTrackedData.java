package github.mcdatapack.blocktopia.boat.impl;

import java.util.Optional;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;


public final class BlocktopiaBoatTrackedData {
    private BlocktopiaBoatTrackedData() {
        return;
    }

    public static final PacketCodec<RegistryByteBuf, Optional<BlocktopiaBoatType>> PACKET_CODEC = PacketCodecs
            .registryValue(BlocktopiaBoatTypeRegistry.INSTANCE.getKey())
            .collect(PacketCodecs::optional);

    public static final TrackedDataHandler<Optional<BlocktopiaBoatType>> HANDLER = TrackedDataHandler.create(PACKET_CODEC);

    public static void register() {
        TrackedDataHandlerRegistry.register(HANDLER);
    }
}
