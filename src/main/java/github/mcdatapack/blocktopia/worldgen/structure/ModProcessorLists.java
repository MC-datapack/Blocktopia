package github.mcdatapack.blocktopia.worldgen.structure;

import com.google.common.collect.ImmutableList;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.worldgen.structure.processor.custom.RandomStateRuleStructureProcessor;
import github.mcdatapack.blocktopia.worldgen.structure.processor.custom.RandomStateStructureProcessorRule;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.BlockMatchRuleTest;

import java.util.List;

public interface ModProcessorLists {
    RegistryKey<StructureProcessorList> RANDOM_CHAIR = key("random_chair");

    private static RegistryKey<StructureProcessorList> key(String name) {
        return RegistryKey.of(RegistryKeys.PROCESSOR_LIST, Blocktopia.id(name));
    }

    static void bootstrap(Registerable<StructureProcessorList> context) {
        register(context, RANDOM_CHAIR, ImmutableList.of(
                new RandomStateRuleStructureProcessor(
                        new ImmutableList.Builder<RandomStateStructureProcessorRule>()
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.OAK_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.OAK_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.SPRUCE_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.SPRUCE_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.BIRCH_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.BIRCH_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.JUNGLE_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.JUNGLE_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.ACACIA_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.ACACIA_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.DARK_OAK_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.DARK_OAK_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.CRIMSON_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.CRIMSON_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.WARPED_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.WARPED_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.MANGROVE_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.MANGROVE_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.BAMBOO_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.BAMBOO_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.CHERRY_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.CHERRY_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.PALM_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.PALM_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.BANANA_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.BANANA_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.CORN_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.CORN_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.POISONED_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.POISONED_CHAIR))
                                .add(new RandomStateStructureProcessorRule(
                                        new BlockMatchRuleTest(ModBlocks.MAHOGANY_CHAIR[0]),
                                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.MAHOGANY_CHAIR))
                                .build()
                        )
                )
        );
    }


    static void load() {}

    private static void register(Registerable<StructureProcessorList> registerable, RegistryKey<StructureProcessorList> key, List<StructureProcessor> processors) {
        registerable.register(key, new StructureProcessorList(processors));
    }
}
