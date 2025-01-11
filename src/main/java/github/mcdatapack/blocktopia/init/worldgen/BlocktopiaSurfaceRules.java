package github.mcdatapack.blocktopia.init.worldgen;

import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class BlocktopiaSurfaceRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);

    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule SAND_BLOCK = makeStateRule(BlockInit.SANDY_DIRT);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isPalmIslandBiome = MaterialRules.biome(BiomeInit.PALM_ISLAND_KEY);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule sandSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, SAND_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeInit.PALM_ISLAND_KEY),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, sandSurface))),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
