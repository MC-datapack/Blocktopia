package github.mcdatapack.blocktopia.worldgen.tree.sapling;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public abstract class ExtendedSaplingGenerator extends SaplingGenerator {
    public ExtendedSaplingGenerator(String id, Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant) {super(id, megaVariant, regularVariant, beesVariant);}
    public ExtendedSaplingGenerator(String id, float rareChance, Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMegaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBeesVariant) {super(id, rareChance, megaVariant, rareMegaVariant, regularVariant, rareRegularVariant, beesVariant, rareBeesVariant);}

    public static class Builder {
        private float rareChance = 0;
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> regular = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegular = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMega = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> bees = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBees = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3 = Optional.empty();
        private Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMega3x3 = Optional.empty();

        public Builder rareChance(float chance) {
            this.rareChance = chance;
            return this;
        }

        public Builder regularVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.regular = Optional.of(feature);
            return this;
        }

        public Builder rareRegularVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.rareRegular = Optional.of(feature);
            return this;
        }

        public Builder megaVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.mega = Optional.of(feature);
            return this;
        }

        public Builder rareMegaVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.rareMega = Optional.of(feature);
            return this;
        }

        public Builder beesVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.bees = Optional.of(feature);
            return this;
        }

        public Builder rareBeesVariant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.rareBees = Optional.of(feature);
            return this;
        }

        public Builder mega3x3Variant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.mega3x3 = Optional.of(feature);
            return this;
        }

        public Builder rareMega3x3Variant(RegistryKey<ConfiguredFeature<?, ?>> feature) {
            this.rareMega3x3 = Optional.of(feature);
            return this;
        }

        public SaplingGenerator build(Identifier id) {
            return mega3x3.isEmpty() && rareMega3x3.isEmpty() ?
                    new SaplingGenerator(id.toString(), rareChance, mega, rareMega, regular, rareRegular, bees, rareBees) :
                    new ExtendedSaplingGenerator$3x3(id.toString(), rareChance, mega, rareMega, regular, rareRegular, bees, rareBees, mega3x3, rareMega3x3);
        }
    }

    public static class ExtendedSaplingGenerator$3x3 extends ExtendedSaplingGenerator {
        private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant, rareMega3x3Variant;

        public ExtendedSaplingGenerator$3x3(String id,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant) {
            this(id, 0.0F,
                    megaVariant, Optional.empty(),
                    regularVariant, Optional.empty(),
                    beesVariant, Optional.empty(),
                    mega3x3Variant, Optional.empty());
        }

        public ExtendedSaplingGenerator$3x3(String id, float rareChance,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMegaVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegularVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBeesVariant,
                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMega3x3Variant) {
            super(id, rareChance, megaVariant, rareMegaVariant, regularVariant, rareRegularVariant, beesVariant, rareBeesVariant);
            this.mega3x3Variant = mega3x3Variant;
            this.rareMega3x3Variant = rareMega3x3Variant;
        }

        @Nullable
        private RegistryKey<ConfiguredFeature<?, ?>> getMega3x3Variant(Random random) {
            return this.rareMega3x3Variant.isPresent() && random.nextFloat() < this.rareChance ? this.rareMega3x3Variant.get() : this.mega3x3Variant.orElse(null);
        }

        @Override
        public boolean generate(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random random) {
            System.out.println("Using Extended Sapling Generator");
            RegistryKey<ConfiguredFeature<?, ?>> registryKey = this.getMega3x3Variant(random);
            if (registryKey != null) {
                RegistryEntry<ConfiguredFeature<?, ?>> registryEntry = world.getRegistryManager()
                        .get(RegistryKeys.CONFIGURED_FEATURE)
                        .getEntry(registryKey)
                        .orElse(null);
                if (registryEntry != null) {
                    for (int i = 1; i >= -1; i--) {
                        for (int j = 1; j >= -1; j--) {
                            if (canGenerate3x3Tree(state, world, pos, i, j)) {
                                ConfiguredFeature<?, ?> configuredFeature = registryEntry.value();
                                BlockState blockState = Blocks.AIR.getDefaultState();
                                world.setBlockState(pos.add(i, 0, j), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 1), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 1), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j + 1), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 2), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 2), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j + 2), blockState, Block.NO_REDRAW);
                                if (configuredFeature.generate(world, chunkGenerator, random, pos.add(i, 0, j))) {
                                    return true;
                                }

                                world.setBlockState(pos.add(i, 0, j), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 1), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 1), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j + 1), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 2), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 2), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 2, 0, j + 2), state, Block.NO_REDRAW);
                                return false;
                            }
                        }
                    }
                }
            }

            RegistryKey<ConfiguredFeature<?, ?>> registryKey1 = this.getMegaTreeFeature(random);
            if (registryKey1 != null) {
                RegistryEntry<ConfiguredFeature<?, ?>> registryEntry = world.getRegistryManager()
                        .get(RegistryKeys.CONFIGURED_FEATURE)
                        .getEntry(registryKey1)
                        .orElse(null);
                if (registryEntry != null) {
                    for (int i = 0; i >= -1; i--) {
                        for (int j = 0; j >= -1; j--) {
                            if (canGenerateLargeTree(state, world, pos, i, j)) {
                                ConfiguredFeature<?, ?> configuredFeature = registryEntry.value();
                                BlockState blockState = Blocks.AIR.getDefaultState();
                                world.setBlockState(pos.add(i, 0, j), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 1), blockState, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 1), blockState, Block.NO_REDRAW);
                                if (configuredFeature.generate(world, chunkGenerator, random, pos.add(i, 0, j))) {
                                    return true;
                                }

                                world.setBlockState(pos.add(i, 0, j), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i, 0, j + 1), state, Block.NO_REDRAW);
                                world.setBlockState(pos.add(i + 1, 0, j + 1), state, Block.NO_REDRAW);
                                return false;
                            }
                        }
                    }
                }
            }

            RegistryKey<ConfiguredFeature<?, ?>> registryKey2 = this.getSmallTreeFeature(random, this.areFlowersNearby(world, pos));
            if (registryKey2 == null) {
                return false;
            } else {
                RegistryEntry<ConfiguredFeature<?, ?>> registryEntry2 = world.getRegistryManager()
                        .get(RegistryKeys.CONFIGURED_FEATURE)
                        .getEntry(registryKey2)
                        .orElse(null);
                if (registryEntry2 == null) {
                    return false;
                } else {
                    ConfiguredFeature<?, ?> configuredFeature2 = registryEntry2.value();
                    BlockState blockState2 = world.getFluidState(pos).getBlockState();
                    world.setBlockState(pos, blockState2, Block.NO_REDRAW);
                    if (configuredFeature2.generate(world, chunkGenerator, random, pos)) {
                        if (world.getBlockState(pos) == blockState2) {
                            world.updateListeners(pos, state, blockState2, Block.NOTIFY_LISTENERS);
                        }

                        return true;
                    } else {
                        world.setBlockState(pos, state, Block.NO_REDRAW);
                        return false;
                    }
                }
            }
        }

        private static boolean canGenerate3x3Tree(BlockState state, BlockView world, BlockPos pos, int x, int z) {
            Block block = state.getBlock();
            return world.getBlockState(pos.add(x, 0, z)).isOf(block)
                    && world.getBlockState(pos.add(x + 1, 0, z)).isOf(block)
                    && world.getBlockState(pos.add(x + 2, 0, z)).isOf(block)
                    && world.getBlockState(pos.add(x, 0, z + 1)).isOf(block)
                    && world.getBlockState(pos.add(x + 1, 0, z)).isOf(block)
                    && world.getBlockState(pos.add(x + 1, 0, z + 1)).isOf(block)
                    && world.getBlockState(pos.add(x + 1, 0, z + 2)).isOf(block)
                    && world.getBlockState(pos.add(x + 2, 0, z)).isOf(block)
                    && world.getBlockState(pos.add(x + 2, 0, z + 1)).isOf(block)
                    && world.getBlockState(pos.add(x + 2, 0, z + 2)).isOf(block);
        }
    }

    //public static class ExtendedSaplingGenerator$4x4 extends ExtendedSaplingGenerator$3x3 {
    //    private final Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega4x4Variant, rareMega4x4Variant;
//
    //    public ExtendedSaplingGenerator$4x4(String id,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega4x4Variant) {
    //        this(id, 0.0F, megaVariant, megaVariant, regularVariant, regularVariant, beesVariant, beesVariant, mega3x3Variant, mega3x3Variant, mega4x4Variant, mega4x4Variant);
    //    }
//
    //    public ExtendedSaplingGenerator$4x4(String id, float rareChance,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> megaVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMegaVariant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> regularVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareRegularVariant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> beesVariant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareBeesVariant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega3x3Variant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMega3x3Variant,
    //                                        Optional<RegistryKey<ConfiguredFeature<?, ?>>> mega4x4Variant, Optional<RegistryKey<ConfiguredFeature<?, ?>>> rareMega4x4Variant) {
    //        super(id, rareChance, megaVariant, rareMegaVariant, regularVariant, rareRegularVariant, beesVariant, rareBeesVariant, mega3x3Variant, rareMega3x3Variant);
    //        this.mega4x4Variant = mega4x4Variant;
    //        this.rareMega4x4Variant = rareMega4x4Variant;
    //    }
    //}
}
