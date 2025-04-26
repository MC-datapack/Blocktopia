package github.mcdatapack.blocktopia.worldgen.structure.processor.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.rule.*;
import net.minecraft.structure.rule.blockentity.RuleBlockEntityModifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.structure.processor.StructureProcessorRule.DEFAULT_BLOCK_ENTITY_MODIFIER;

public class RandomStateStructureProcessorRule  {
    public static final Codec<RandomStateStructureProcessorRule> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            RuleTest.TYPE_CODEC.fieldOf("input_predicate").forGetter(rule -> rule.inputPredicate),
                            RuleTest.TYPE_CODEC.fieldOf("location_predicate").forGetter(rule -> rule.locationPredicate),
                            PosRuleTest.BASE_CODEC.lenientOptionalFieldOf("position_predicate", AlwaysTruePosRuleTest.INSTANCE).forGetter(rule -> rule.positionPredicate),
                            BlockState.CODEC.listOf().fieldOf("output_states").forGetter(rule -> rule.states),
                            RuleBlockEntityModifier.TYPE_CODEC
                                    .lenientOptionalFieldOf("block_entity_modifier", DEFAULT_BLOCK_ENTITY_MODIFIER)
                                    .forGetter(rule -> rule.blockEntityModifier)
                    )
                    .apply(instance, RandomStateStructureProcessorRule::new)
    );

    private final List<BlockState> states;
    public final RuleTest inputPredicate;
    public final RuleTest locationPredicate;
    public final PosRuleTest positionPredicate;
    public final RuleBlockEntityModifier blockEntityModifier;

    public RandomStateStructureProcessorRule(RuleTest inputPredicate, RuleTest locationPredicate, List<BlockState> states) {
        this(inputPredicate, locationPredicate, AlwaysTruePosRuleTest.INSTANCE, states);
    }

    public RandomStateStructureProcessorRule(RuleTest inputPredicate, RuleTest locationPredicate, PosRuleTest positionPredicate, List<BlockState> states) {
        this(inputPredicate, locationPredicate, positionPredicate, states, DEFAULT_BLOCK_ENTITY_MODIFIER);
    }

    public RandomStateStructureProcessorRule(RuleTest inputPredicate, RuleTest locationPredicate, PosRuleTest positionPredicate, List<BlockState> states, RuleBlockEntityModifier blockEntityModifier) {
        this.inputPredicate = inputPredicate;
        this.locationPredicate = locationPredicate;
        this.positionPredicate = positionPredicate;
        this.blockEntityModifier = blockEntityModifier;
        this.states = states;
    }

    public RandomStateStructureProcessorRule(RuleTest inputPredicate, RuleTest locationPredicate, Block[] blocks) {
        this.inputPredicate = inputPredicate;
        this.locationPredicate = locationPredicate;
        this.positionPredicate = AlwaysTruePosRuleTest.INSTANCE;
        this.blockEntityModifier = DEFAULT_BLOCK_ENTITY_MODIFIER;
        BlockState[] blockStates = new BlockState[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            blockStates[i] = blocks[i].getDefaultState();
        }
        this.states = List.of(blockStates);
    }

    public boolean test(BlockState input, BlockState currentState, BlockPos originalPos, BlockPos currentPos, BlockPos pivot, Random random) {
        return this.inputPredicate.test(input, random)
                && this.locationPredicate.test(currentState, random)
                && this.positionPredicate.test(originalPos, currentPos, pivot, random);
    }

    public BlockState getOutputState(Random random) {
        return Util.getRandom(states, random);
    }

    @Nullable
    public NbtCompound getOutputNbt(Random random, @Nullable NbtCompound nbt) {
        return this.blockEntityModifier.modifyBlockEntityNbt(random, nbt);
    }
}
