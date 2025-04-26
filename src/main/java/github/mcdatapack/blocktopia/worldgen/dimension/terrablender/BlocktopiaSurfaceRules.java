package github.mcdatapack.blocktopia.worldgen.dimension.terrablender;

import github.mcdatapack.blocktopia.block.ModBlocks;
import github.mcdatapack.blocktopia.worldgen.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public interface BlocktopiaSurfaceRules {
    MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);

    MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    MaterialRules.MaterialRule SANDY_DIRT = makeStateRule(ModBlocks.SANDY_DIRT);
    MaterialRules.MaterialRule MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);
    MaterialRules.MaterialRule TROPICAL_MOSS_BLOCK = makeStateRule(ModBlocks.TROPICAL_MOSS);

    static MaterialRules.MaterialRule palmIslandRule() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isPalmIslandBiome = MaterialRules.biome(ModBiomes.PALM_ISLAND_KEY);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule sandSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, SANDY_DIRT), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(isPalmIslandBiome, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, sandSurface))),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    static MaterialRules.MaterialRule rainForestRule() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition isRainForestBiome = MaterialRules.biome(ModBiomes.RAIN_FOREST_KEY);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), MOSS_BLOCK);
        MaterialRules.MaterialRule mossSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, TROPICAL_MOSS_BLOCK), MOSS_BLOCK);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(isRainForestBiome, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, mossSurface))),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }


    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
