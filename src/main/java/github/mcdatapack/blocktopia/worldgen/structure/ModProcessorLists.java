package github.mcdatapack.blocktopia.worldgen.structure;

import com.google.common.collect.ImmutableList;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.worldgen.structure.processor.custom.RandomStateRuleStructureProcessor;
import github.mcdatapack.blocktopia.worldgen.structure.processor.custom.RandomStateStructureProcessorRule;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;

import java.util.List;

public interface ModProcessorLists {
    RegistryKey<StructureProcessorList> RANDOM_CHAIR = key("random_chair");
    RegistryKey<StructureProcessorList> RANDOM_STONE = key("random_stone");

    RegistryKey<StructureProcessorList> BANANA_PROCESSOR = key("banana_processor");
    RegistryKey<StructureProcessorList> CHAIR_ANVIL_PROCESSOR = key("chair_anvil_processor");

    private static RegistryKey<StructureProcessorList> key(String name) {
        return RegistryKey.of(RegistryKeys.PROCESSOR_LIST, Blocktopia.id(name));
    }

    static void bootstrap(Registerable<StructureProcessorList> context) {
        RandomStateRuleStructureProcessor chair = new RandomStateRuleStructureProcessor(
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
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.WOODEN_CHAIR_RD20090515[0]),
                                AlwaysTrueRuleTest.INSTANCE, ModBlocks.WOODEN_CHAIR_RD20090515))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.WOODEN_CHAIR_RD161348[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.WOODEN_CHAIR_RD161348))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.WOODEN_CHAIR_C0_0_14A[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.WOODEN_CHAIR_C0_0_14A))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.WOODEN_CHAIR_C0_0_15A[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.WOODEN_CHAIR_C0_0_15A))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.WOODEN_CHAIR_B1_9PRE5[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.WOODEN_CHAIR_B1_9PRE5))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.BIRCH_CHAIR_1_2_4[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.BIRCH_CHAIR_1_2_4))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.SPRUCE_CHAIR_1_2_4[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.SPRUCE_CHAIR_1_2_4))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.JUNGLE_CHAIR_1_2_4[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.JUNGLE_CHAIR_1_2_4))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.ACACIA_CHAIR_1_7[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.ACACIA_CHAIR_1_7))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(ModBlocks.DARK_OAK_CHAIR_1_7[0]),
                        AlwaysTrueRuleTest.INSTANCE, ModBlocks.DARK_OAK_CHAIR_1_7))
                        .build()
        );
        RandomStateRuleStructureProcessor stone = new RandomStateRuleStructureProcessor(
                new ImmutableList.Builder<RandomStateStructureProcessorRule>()
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(Blocks.STONE_BRICKS),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{Blocks.STONE_BRICKS, Blocks.STONE, Blocks.CRACKED_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS}
                        ))
                        .add(new RandomStateStructureProcessorRule(
                                new BlockMatchRuleTest(Blocks.STONE_BRICK_STAIRS),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{Blocks.STONE_BRICK_STAIRS, Blocks.STONE_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS}
                        ))
                        .build()
        );
        RandomStateRuleStructureProcessor anvil = new RandomStateRuleStructureProcessor(
                new ImmutableList.Builder<RandomStateStructureProcessorRule>()
                        .add(new RandomStateStructureProcessorRule(
                                new RandomBlockMatchRuleTest(Blocks.ANVIL, 0.4f),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{Blocks.DAMAGED_ANVIL}
                        ))
                        .add(new RandomStateStructureProcessorRule(
                                new RandomBlockMatchRuleTest(Blocks.ANVIL, 0.2f),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{Blocks.CHIPPED_ANVIL}
                        ))
                        .add(new RandomStateStructureProcessorRule(
                                new RandomBlockMatchRuleTest(Blocks.ANVIL, 0.15f),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{ModBlocks.DAMAGED_GOLD_ANVIL}
                        ))
                        .add(new RandomStateStructureProcessorRule(
                                new RandomBlockMatchRuleTest(Blocks.ANVIL, 0.1f),
                                AlwaysTrueRuleTest.INSTANCE, new Block[]{ModBlocks.CHIPPED_GOLD_ANVIL}
                        ))
                        .build()
        );

        register(context, RANDOM_CHAIR, ImmutableList.of(chair));
        register(context, RANDOM_STONE, ImmutableList.of(stone));

        register(context, BANANA_PROCESSOR, ImmutableList.of(chair, stone, anvil));
        register(context, CHAIR_ANVIL_PROCESSOR, ImmutableList.of(chair, anvil));
    }


    static void load() {}

    private static void register(Registerable<StructureProcessorList> registerable, RegistryKey<StructureProcessorList> key, List<StructureProcessor> processors) {
        registerable.register(key, new StructureProcessorList(processors));
    }
}
