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
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;

public class ConfigurableRepeaterAssetsGenerator {
    private static final Logger logger = LoggerFactory.getLogger("Assets Generator");
    public static void main(String[] args){
        // Path to the resource directories
        String resourceDirectory = "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/textures/block/configurable_repeater";
        String jsonDirectory = "M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/models/block/configurable_repeater";

        int states = 1024;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File directory = new File(resourceDirectory);
        if (!directory.isDirectory()) {
            logger.error("The specified path is not a directory: {}", resourceDirectory);
            return;
        }

        File jsonDirectoryF = new File(jsonDirectory);
        if (!jsonDirectoryF.isDirectory()) {
            logger.error("The specified path is not a directory: {}", jsonDirectory);
            return;
        }

        for (int i = 1; i < states + 1; i++) {
            try {
                final Path path = Path.of(resourceDirectory + "/default.png");
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
                    String numberToWrite = parts[1].replace(".png", ""); // Extract the number part

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

                        String jsonFileName = fileName.replace(".png", "");
                        File jsonFile1 = new File(jsonDirectory, jsonFileName + ".json");
                        File jsonFile2 = new File(jsonDirectory, jsonFileName + "_on.json");
                        File jsonFile3 = new File(jsonDirectory, jsonFileName + "_locked.json");
                        File jsonFile4 = new File(jsonDirectory, jsonFileName + "_on_locked.json");

                        Model jsonContent1 = new Model(
                                "blocktopia:block/configurable_repeater_temp",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "block/smooth_stone",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "minecraft:block/redstone_torch_off"
                        );
                        Model jsonContent2 = new Model(
                                "blocktopia:block/configurable_repeater_temp_on",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "block/smooth_stone",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "minecraft:block/redstone_torch"
                        );
                        Model jsonContent3 = new Model(
                                "blocktopia:block/configurable_repeater_temp_locked",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "block/smooth_stone",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "minecraft:block/redstone_torch_off"
                        );
                        Model jsonContent4 = new Model(
                                "blocktopia:block/configurable_repeater_temp_on_locked",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "block/smooth_stone",
                                "blocktopia:block/configurable_repeater/" + jsonFileName,
                                "minecraft:block/redstone_torch"
                        );

                        try (FileWriter writer = new FileWriter(jsonFile1)) {
                            gson.toJson(jsonContent1, writer);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }

                        try (FileWriter writer = new FileWriter(jsonFile2)) {
                            gson.toJson(jsonContent2, writer);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }

                        try (FileWriter writer = new FileWriter(jsonFile3)) {
                            gson.toJson(jsonContent3, writer);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }

                        try (FileWriter writer = new FileWriter(jsonFile4)) {
                            gson.toJson(jsonContent4, writer);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }

                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        }

        BlockstateFormat blockstate = new BlockstateFormat();

        for (int i = 1; i < states + 1; i++) {
            blockstate.addVariant("delay=" + i + ",facing=east,powered=false,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i, 270));
            blockstate.addVariant("delay=" + i + ",facing=east,powered=true,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on", 270));
            blockstate.addVariant("delay=" + i + ",facing=north,powered=false,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i, 180));
            blockstate.addVariant("delay=" + i + ",facing=north,powered=true,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on", 180));
            blockstate.addVariant("delay=" + i + ",facing=west,powered=false,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i, 90));
            blockstate.addVariant("delay=" + i + ",facing=west,powered=true,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on", 90));
            blockstate.addVariant("delay=" + i + ",facing=south,powered=false,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i));
            blockstate.addVariant("delay=" + i + ",facing=south,powered=true,locked=false",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on"));
            blockstate.addVariant("delay=" + i + ",facing=east,powered=false,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_locked", 270));
            blockstate.addVariant("delay=" + i + ",facing=east,powered=true,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on_locked", 270));
            blockstate.addVariant("delay=" + i + ",facing=north,powered=false,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_locked", 180));
            blockstate.addVariant("delay=" + i + ",facing=north,powered=true,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on_locked", 180));
            blockstate.addVariant("delay=" + i + ",facing=west,powered=false,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_locked", 90));
            blockstate.addVariant("delay=" + i + ",facing=west,powered=true,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on_locked", 90));
            blockstate.addVariant("delay=" + i + ",facing=south,powered=false,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_locked"));
            blockstate.addVariant("delay=" + i + ",facing=south,powered=true,locked=true",
                    new BlockstateFormat.Variant("blocktopia:block/configurable_repeater/state_" + i + "_on_locked"));
        }


        try (FileWriter writer = new FileWriter("M:/Mods/Blocktopia/src/main/resources/assets/blocktopia/blockstates/configurable_repeater.json")) {
            gson.toJson(blockstate, writer);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static class Model {
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

    public static class BlockstateFormat {
        private Map<String, Variant> variants = new HashMap<>();
        public void addVariant(String key, Variant variant) {
            variants.put(key, variant);
        }
        public static class Variant {
            private String model;
            private Integer y;
            public Variant(String model, Integer y) {
                this.model = model; this.y = y;
            }
            public Variant(String model) {
                this.model = model;
            }
        }
    }
}
