package github.mcdatapack.blocktopia.worldgen.structure.processor;

import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.worldgen.structure.processor.custom.RandomStateRuleStructureProcessor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessorType;

public interface ModStructureProcessorTypes {
    StructureProcessorType<RandomStateRuleStructureProcessor> RANDOM_STATE_RULE =
            Registry.register(Registries.STRUCTURE_PROCESSOR, Blocktopia.id("random_state_rule"), () -> RandomStateRuleStructureProcessor.CODEC);

    static void load() {}
}
