package github.mcdatapack.blocktopia.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;

public record FluidInteraction(
        Identifier fluid,
        Identifier neighborBlock,
        Identifier baseBlock,
        Identifier resultBlock
) {
    public static final Codec<FluidInteraction> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Identifier.CODEC.fieldOf("fluid").forGetter(FluidInteraction::fluid),
            Identifier.CODEC.fieldOf("neighbor_block").forGetter(FluidInteraction::neighborBlock),
            Identifier.CODEC.fieldOf("base_block").forGetter(FluidInteraction::baseBlock),
            Identifier.CODEC.fieldOf("result").forGetter(FluidInteraction::resultBlock)
    ).apply(instance, FluidInteraction::new));
}