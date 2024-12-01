package github.mcdatapack.blocktopia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;

public class ExtendedRepeaterAssetsGenerator {
    private static final Logger logger = LoggerFactory.getLogger("Assets Generator");
    private static final String[] resourceDirectories = {
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/textures/block/extended_repeater/tick",
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/textures/block/extended_repeater/second",
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/textures/block/extended_repeater/minute"
    };
    private static final String[] jsonDirectories = {
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/block/extended_repeater/tick",
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/block/extended_repeater/second",
            "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/block/extended_repeater/minute"
    };
    private static final String[] items = {
            "extended_repeater_tick", "extended_repeater_second", "extended_repeater_minute"
    };
    private static final String[] modelDictionary = {
            "blocktopia:block/extended_repeater/tick", "blocktopia:block/extended_repeater/second", "blocktopia:block/extended_repeater/minute"
    };
    private static final String[] units = {
            "T", "S", "M"
    };
    private static final int states = 256;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args){
        for (int i = 0; i < resourceDirectories.length; i++) {
            checkDictionaries(resourceDirectories[i], jsonDirectories[i]);
            generateImagesAndModels(resourceDirectories[i], jsonDirectories[i], units[i]);
            generateBlockstates(items[i], modelDictionary[i]);
        }
    }

    private static void checkDictionaries(String resourceDirectory, String jsonDirectory) {
        if (!new File(resourceDirectory).isDirectory()) {
            logger.error("The specified path is not a directory: {}", resourceDirectory);
            new File(resourceDirectory).mkdirs();
        }

        if (!new File(jsonDirectory).isDirectory()) {
            logger.error("The specified path is not a directory: {}", jsonDirectory);
            new File(jsonDirectory).mkdirs();
        }
    }

    private static void generateImagesAndModels(String resourceDirectory, String jsonDirectory, String unit) {
        final File directory = new File(resourceDirectory);
        for (int i = 1; i <= states ; i++) {
            try {
                final Path path = Path.of("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/textures/block/extended_repeater/default.png");
                final Path target = Path.of(resourceDirectory + "/state_" + i + ".png");
                if (Files.exists(target)) {
                    Files.delete(target);
                    logger.debug("Deleted {}/default.png", resourceDirectory);
                }
                Files.copy(path, target);
                logger.debug("Copied File from {}/default.png to {}/state_{}.png", resourceDirectory, resourceDirectory, i);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile() && file.getName().endsWith(".png") && !file.getName().equals("default.png")) {
                String fileName = file.getName();
                String[] parts = fileName.split("_");
                if (parts.length > 1) {
                    String numberToWrite = parts[1].replace(".png", "") + unit; // Extract the number part

                    try {
                        BufferedImage image = ImageIO.read(file);
                        Graphics2D g2d = image.createGraphics();

                        // Set the font and color
                        Font font = new Font("Arial", Font.BOLD, 12);
                        g2d.setFont(font);
                        g2d.setColor(Color.BLUE);

                        // Get font metrics
                        FontMetrics metrics = g2d.getFontMetrics(font);
                        int x = (image.getWidth() - metrics.stringWidth(numberToWrite)) / 2;
                        int y = ((image.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

                        logger.debug("Writing \"{}\" at ({}, {}) on {}", numberToWrite, x, y, fileName);

                        // Write the number onto the image
                        g2d.drawString(numberToWrite, x, y);
                        g2d.dispose();

                        // Save the modified image back to the same directory
                        File outputFile = new File(directory, fileName);
                        ImageIO.write(image, "png", outputFile);
                        logger.debug("Modified and saved: {}", outputFile.getPath());
                        
                        String givenUnit = null;
                        switch (unit) {
                            case "T" -> givenUnit = "tick";
                            case "S" -> givenUnit = "second";
                            case "M" -> givenUnit = "minute";
                        }

                        generateModels(fileName, jsonDirectory, givenUnit);
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        }
    }

    private static void generateModels(String fileName, String jsonDirectory, String unit) {
        fileName = fileName.replace(".png", "");
        File jsonFile1 = new File(jsonDirectory, fileName + ".json");
        File jsonFile2 = new File(jsonDirectory, fileName + "_on.json");
        File jsonFile3 = new File(jsonDirectory, fileName + "_locked.json");
        File jsonFile4 = new File(jsonDirectory, fileName + "_on_locked.json");

        Model jsonContent1 = new Model(
                "blocktopia:block/extended_repeater_temp",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/smooth_stone",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/redstone_torch_off"
        );
        Model jsonContent2 = new Model(
                "blocktopia:block/extended_repeater_temp_on",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/smooth_stone",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/redstone_torch"
        );
        Model jsonContent3 = new Model(
                "blocktopia:block/extended_repeater_temp_locked",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/smooth_stone",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/redstone_torch_off"
        );
        Model jsonContent4 = new Model(
                "blocktopia:block/extended_repeater_temp_on_locked",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/smooth_stone",
                "blocktopia:block/extended_repeater/" + unit + "/" + fileName,
                "minecraft:block/redstone_torch"
        );

        try (FileWriter writer = new FileWriter(jsonFile1)) {
            gson.toJson(jsonContent1, writer);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try (FileWriter writer2 = new FileWriter(jsonFile2)) {
            gson.toJson(jsonContent2, writer2);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try (FileWriter writer3 = new FileWriter(jsonFile3)) {
            gson.toJson(jsonContent3, writer3);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        try (FileWriter writer4 = new FileWriter(jsonFile4)) {
            gson.toJson(jsonContent4, writer4);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private static void generateBlockstates(String item, String modelDictionary) {
        BlockstateFormat blockstate = new BlockstateFormat();

        for (int i = 1; i <= states; i++) {
            addRepeaterVariant(blockstate, i, "east", false, false, 270, modelDictionary);
            addRepeaterVariant(blockstate, i, "east", true, false, 270, modelDictionary);
            addRepeaterVariant(blockstate, i, "east", false, true, 270, modelDictionary);
            addRepeaterVariant(blockstate, i, "east", true, true, 270, modelDictionary);
            addRepeaterVariant(blockstate, i, "north", false, false, 180, modelDictionary);
            addRepeaterVariant(blockstate, i, "north", true, false, 180, modelDictionary);
            addRepeaterVariant(blockstate, i, "north", false, true, 180, modelDictionary);
            addRepeaterVariant(blockstate, i, "north", true, true, 180, modelDictionary);
            addRepeaterVariant(blockstate, i, "west", false, false, 90, modelDictionary);
            addRepeaterVariant(blockstate, i, "west", true, false, 90, modelDictionary);
            addRepeaterVariant(blockstate, i, "west", false, true, 90, modelDictionary);
            addRepeaterVariant(blockstate, i, "west", true, true, 90, modelDictionary);
            addRepeaterVariant(blockstate, i, "south", false, false, 0, modelDictionary);
            addRepeaterVariant(blockstate, i, "south", true, false, 0, modelDictionary);
            addRepeaterVariant(blockstate, i, "south", false, true, 0, modelDictionary);
            addRepeaterVariant(blockstate, i, "south", true, true, 0, modelDictionary);
        }

        try (FileWriter writer = new FileWriter("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/blockstates/" + item + ".json")) {
            gson.toJson(blockstate, writer);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private static void addRepeaterVariant(BlockstateFormat blockstate, int delay, String facing, boolean powered, boolean locked, int rotation, String modelDictionary) {
        String stateSuffix = (powered ? "_on" : "") + (locked ? "_locked" : "");
        String model = modelDictionary + "/state_" + delay + stateSuffix;
        blockstate.addVariant(delay, facing, powered, locked, new BlockstateFormat.Variant(model, rotation));
    }

    private static class Model {
        private String parent;
        private Map<String, String> textures = new HashMap<>();
        public Model(String parent, String particle, String slab, String top, String torch) {
            this.parent = parent;
            this.textures.put("particle", particle);
            this.textures.put("slab", slab);
            this.textures.put("top", top);
            this.textures.put("torch", torch);
        }
    }

    private static class BlockstateFormat {
        private LinkedHashMap<String, Variant> variants = new LinkedHashMap<>();
        public void addVariant(int delay, String facing, boolean powered, boolean locked, Variant variant) {
            variants.put("delay=" + delay + ",facing=" + facing + ",powered=" + powered + ",locked=" + locked, variant);
        }
        public static class Variant {
            private String model;
            private int y;

            public Variant(String model, int rotation) {
                this.model = model;
                this.y = rotation;
            }
        }
    }
}
