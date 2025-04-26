package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.block.custom.ChairBlock;
import github.mcdatapack.blocktopia.item.ModItemGroups;
import github.mcdatapack.blocktopia.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class BlocktopiaLangProvider extends FabricLanguageProvider {
    public BlocktopiaLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder) {
        try {
            builder.add(Path.of(URI.create(String.valueOf(BlocktopiaLangProvider.class.getClassLoader().getResource("assets/blocktopia/notdatagen/lang/en_us.json")))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        builder.add(ModItemGroups.COLORED_BLOCKS_GROUP, "§2§lBlocktopia: §fColored Blocks");
        addChairs(builder, ModBlocks.OAK_CHAIR, "Oak Chair");
        addChairs(builder, ModBlocks.BIRCH_CHAIR, "Birch Chair");
        addChairs(builder, ModBlocks.SPRUCE_CHAIR, "Spruce Chair");
        addChairs(builder, ModBlocks.JUNGLE_CHAIR, "Jungle Chair");
        addChairs(builder, ModBlocks.ACACIA_CHAIR, "Acacia Chair");
        addChairs(builder, ModBlocks.DARK_OAK_CHAIR, "Dark Oak Chair");
        addChairs(builder, ModBlocks.CRIMSON_CHAIR, "Crimson Chair");
        addChairs(builder, ModBlocks.WARPED_CHAIR, "Warped Chair");
        addChairs(builder, ModBlocks.MANGROVE_CHAIR, "Mangrove Chair");
        addChairs(builder, ModBlocks.BAMBOO_CHAIR, "Bamboo Chair");
        addChairs(builder, ModBlocks.CHERRY_CHAIR, "Cherry Chair");
        addChairs(builder, ModBlocks.PALM_CHAIR, "Palm Chair");
        addChairs(builder, ModBlocks.BANANA_CHAIR, "Banana Chair");
        addChairs(builder, ModBlocks.CORN_CHAIR, "Corn Chair");
        addChairs(builder, ModBlocks.POISONED_CHAIR, "Poisoned Chair");
        addChairs(builder, ModBlocks.MAHOGANY_CHAIR, "Mahogany Chair");
    }

    private void addChairs(TranslationBuilder builder, ChairBlock[] blocks, String baseName) {
        builder.add(blocks[0], baseName);
        builder.add(blocks[1], "White " + baseName);
        builder.add(blocks[2], "Orange " + baseName);
        builder.add(blocks[3], "Magenta " + baseName);
        builder.add(blocks[4], "Light Blue " + baseName);
        builder.add(blocks[5], "Yellow " + baseName);
        builder.add(blocks[6], "Lime " + baseName);
        builder.add(blocks[7], "Pink " + baseName);
        builder.add(blocks[8], "Gray " + baseName);
        builder.add(blocks[9], "Light Gray " + baseName);
        builder.add(blocks[10], "Cyan " + baseName);
        builder.add(blocks[11], "Purple " + baseName);
        builder.add(blocks[12], "Blue " + baseName);
        builder.add(blocks[13], "Brown " + baseName);
        builder.add(blocks[14], "Green " + baseName);
        builder.add(blocks[15], "Red " + baseName);
        builder.add(blocks[16], "Black " + baseName);
    }
}
