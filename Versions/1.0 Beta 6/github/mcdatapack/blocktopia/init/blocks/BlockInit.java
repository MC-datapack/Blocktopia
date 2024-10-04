package github.mcdatapack.blocktopia.init.blocks;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import github.mcdatapack.blocktopia.block.SmallChestBlock;
import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.worldgen.ConfiguredFeatureInit;
import github.mcdatapack.blocktopia.list.BlockSetTypeList;
import github.mcdatapack.blocktopia.list.WoodTypeList;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaHangingSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallHangingSignBlock;
import github.mcdatapack.blocktopia.sign.api.block.BlocktopiaWallSignBlock;
import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2323;
import net.minecraft.class_2346;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2378;
import net.minecraft.class_2397;
import net.minecraft.class_2440;
import net.minecraft.class_2465;
import net.minecraft.class_2473;
import net.minecraft.class_2482;
import net.minecraft.class_2498;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_3619;
import net.minecraft.class_3620;
import net.minecraft.class_4970;
import net.minecraft.class_7923;
import net.minecraft.class_8813;

public class BlockInit {
    public static final class_2346 PAPER_BLOCK = register("paper_block",
            new class_2346(class_4970.class_2251.method_9630(class_2246.field_10102).method_9629(0.2F, 0.0F)) {
                @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
    public static final class_2346 GUNPOWDER_BLOCK = register("gunpowder_block",
            new class_2346(class_4970.class_2251.method_9630(class_2246.field_10102).method_9629(0.2F, 0.0F)) {
                @Override protected MapCodec<? extends class_2346> method_53969() {return null;}});
    public static final SmallChestBlock SMALL_CHEST = register("small_chest", new SmallChestBlock(class_4970.class_2251.method_9637()
            .method_9632(2.5F).method_9626(class_2498.field_11547).method_51368(class_2766.field_12651).method_50013()));
    public static final class_2248 PALM_LOG = register("palm_log", class_2246.method_26117(class_3620.field_15977, class_3620.field_15977));
    public static final class_2248 STRIPPED_PALM_LOG =  register("stripped_palm_log", class_2246.method_26117(class_3620.field_15977, class_3620.field_15977));
    public static final class_2465 PALM_WOOD = register("palm_wood", new class_2465(class_4970.class_2251.method_9637()
            .method_31710(class_3620.field_15977).method_9632(2.0F).method_9626(class_2498.field_11547).method_51368(class_2766.field_12651).method_50013()));
    public static final class_2465 STRIPPED_PALM_WOOD = register("stripped_palm_wood", new class_2465(class_4970.class_2251.method_9637()
            .method_31710(class_3620.field_15977).method_9626(class_2498.field_11547).method_9632(2.0F).method_51368(class_2766.field_12651).method_50013()));
    public static final class_2397 PALM_LEAVES = register("palm_leaves", new class_2397(class_4970.class_2251.method_9637()
            .method_9632(0.2F).method_9640().method_9626(class_2498.field_11535).method_22488().method_26235(class_2246::method_26126)
            .method_26243(class_2246::method_26122).method_26245(class_2246::method_26122).method_50013().method_50012(class_3619.field_15971).method_26236(class_2246::method_26122)));
    public static final class_2473 PALM_SAPLING = register("palm_sapling", new class_2473(new class_8813(Blocktopia.id("palm").toString(),
            0.1F, Optional.empty(), Optional.empty(), Optional.of(ConfiguredFeatureInit.PALM_TREE_KEY),
            Optional.empty(), Optional.empty(), Optional.empty()), class_4970.class_2251.method_9637()
            .method_9640().method_9618().method_9626(class_2498.field_11535).method_22488().method_26235(class_2246::method_26126)
            .method_26243(class_2246::method_26122).method_26245(class_2246::method_26122).method_50013().method_50012(class_3619.field_15971).method_26236(class_2246::method_26122).method_9634()));
    public static final class_2248 POTTED_PALM_SAPLING = registerWithoutItem("potted_palm_sapling", class_2246.method_50000(PALM_SAPLING));
    public static final class_2248 PALM_PLANKS = register("palm_planks", new class_2248(class_4970.class_2251.method_9630(class_2246.field_10161)));
    public static final class_2323 PALM_DOOR = register("palm_door", new class_2323(BlockSetTypeList.PALM, class_4970.class_2251.method_9637()
            .method_31710(class_3620.field_15977).method_9632(3.0F).method_22488().method_50013().method_9626(class_2498.field_11547)));
    public static final class_2354 PALM_FENCE = register("palm_fence", new class_2354(class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
    public static final class_2349 PALM_FENCE_GATE = register("palm_fence_gate", new class_2349(WoodTypeList.PALM, class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9632(2.0F).method_9626(class_2498.field_11547).method_50013()));
    public static final class_2510 PALM_STAIRS = register("palm_stairs", new class_2510(PALM_PLANKS.method_9564(), class_4970.class_2251.method_9630(class_2246.field_10149)));
    public static final class_2482 PALM_SLAB = register("palm_slab", new class_2482(class_4970.class_2251.method_9637()
            .method_51368(class_2766.field_12651).method_9629(2.0F, 3.0F).method_9626(class_2498.field_11547).method_50013()));
    public static final class_2440 PALM_PRESSURE_PLATE = register("palm_pressure_plate", new class_2440(BlockSetTypeList.PALM, class_4970.class_2251.method_9637()
            .method_51369().method_31710(class_3620.field_15977).method_9634().method_9632(0.5F).method_50013().method_50012(class_3619.field_15971)));
    public static final class_2248 PALM_BUTTON = register("palm_button", class_2246.method_45451(BlockSetTypeList.PALM));
    public static final class_2533 PALM_TRAPDOOR = register("palm_trapdoor", new class_2533(BlockSetTypeList.PALM, class_4970.class_2251.method_9637()
            .method_31710(class_3620.field_15977).method_9632(3.0F).method_22488().method_26235(class_2246::method_26114).method_50013()));

    private static final class_2960 PALM_SIGN_TEXTURE = Blocktopia.id("entity/signs/palm");
    private static final class_2960 PALM_HANGING_SIGN_TEXTURE = Blocktopia.id("entity/signs/hanging/palm");
    private static final class_2960 PALM_HANGING_SIGN_GUI_TEXTURE = Blocktopia.id("textures/gui/hanging_signs/palm");

    public static final BlocktopiaSignBlock PALM_SIGN = registerWithoutItem("palm_sign", new BlocktopiaSignBlock(PALM_SIGN_TEXTURE, class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_50013()));
    public static final BlocktopiaWallSignBlock PALM_WALL_SIGN = registerWithoutItem("palm_wall_sign", new BlocktopiaWallSignBlock(PALM_SIGN_TEXTURE, class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_50013()));
    public static final BlocktopiaHangingSignBlock PALM_HANGING_SIGN = registerWithoutItem("palm_hanging_sign", new BlocktopiaHangingSignBlock(PALM_HANGING_SIGN_TEXTURE, PALM_HANGING_SIGN_GUI_TEXTURE, class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_50013()));
    public static final BlocktopiaWallHangingSignBlock PALM_WALL_HANGING_SIGN = registerWithoutItem("palm_wall_hanging_sign", new BlocktopiaWallHangingSignBlock(PALM_HANGING_SIGN_TEXTURE, PALM_HANGING_SIGN_GUI_TEXTURE, class_4970.class_2251.method_9637()
            .method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(1.0F).method_50013()));


    public static <T extends class_2248> T registerWithoutItem(String name, T block) {
        return class_2378.method_10230(class_7923.field_41175, Blocktopia.id(name), block);
    }

    public static <T extends class_2248> T register(String name, T block, class_1792.class_1793 Settings) {
        T registered = registerWithoutItem(name, block);
        ItemInit.register(name, new class_1747(registered, Settings));
        return registered;
    }

    public static <T extends class_2248> T register(String name, T block) {
        return register(name, block, new class_1792.class_1793());
    }
    public static void load() {}
}
