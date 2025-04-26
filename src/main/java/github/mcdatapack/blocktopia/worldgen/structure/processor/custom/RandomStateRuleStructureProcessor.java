package github.mcdatapack.blocktopia.worldgen.structure.processor.custom;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.worldgen.structure.processor.ModStructureProcessorTypes;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RandomStateRuleStructureProcessor extends StructureProcessor {
    public static final MapCodec<RandomStateRuleStructureProcessor> CODEC = RandomStateStructureProcessorRule.CODEC
            .listOf()
            .fieldOf("rules")
            .xmap(RandomStateRuleStructureProcessor::new, processor -> processor.rules);

    private final List<RandomStateStructureProcessorRule> rules;

    public RandomStateRuleStructureProcessor(List<RandomStateStructureProcessorRule> rules) {
        this.rules = rules;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(
            WorldView world,
            BlockPos pos,
            BlockPos pivot,
            StructureTemplate.StructureBlockInfo originalBlockInfo,
            StructureTemplate.StructureBlockInfo currentBlockInfo,
            StructurePlacementData data
    ) {
        Random random = Random.create(MathHelper.hashCode(currentBlockInfo.pos()));
        BlockState blockState = world.getBlockState(currentBlockInfo.pos());

        for (RandomStateStructureProcessorRule structureProcessorRule : this.rules) {
            if (structureProcessorRule.test(currentBlockInfo.state(), blockState, originalBlockInfo.pos(), currentBlockInfo.pos(), pivot, random)) {
                return new StructureTemplate.StructureBlockInfo(
                        currentBlockInfo.pos(), structureProcessorRule.getOutputState(random), structureProcessorRule.getOutputNbt(random, currentBlockInfo.nbt())
                );
            }
        }

        return currentBlockInfo;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModStructureProcessorTypes.RANDOM_STATE_RULE;
    }
}
