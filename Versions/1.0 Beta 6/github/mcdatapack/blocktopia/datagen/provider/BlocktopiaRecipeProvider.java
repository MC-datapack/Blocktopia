package github.mcdatapack.blocktopia.datagen.provider;

import github.mcdatapack.blocktopia.init.ItemInit;
import github.mcdatapack.blocktopia.init.blocks.BlockInit;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.class_1792;
import net.minecraft.class_1935;
import net.minecraft.class_2446;
import net.minecraft.class_2447;
import net.minecraft.class_2450;
import net.minecraft.class_3489;
import net.minecraft.class_5794;
import net.minecraft.class_6862;
import net.minecraft.class_7225;
import net.minecraft.class_7699;
import net.minecraft.class_7800;
import net.minecraft.class_8790;

import static github.mcdatapack.blocktopia.init.blocks.LegacyBlocks.*;
import static github.mcdatapack.blocktopia.list.TagList.Items.*;
import static net.minecraft.class_1802.*;

import org.jetbrains.annotations.NotNull;

public class BlocktopiaRecipeProvider extends FabricRecipeProvider {
    public BlocktopiaRecipeProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void method_10419(class_8790 exporter) {
        class_2450.method_10448(class_7800.field_40642, field_8695, 9)
                .method_10446(GOLDEN_BLOCKS)
                .method_10442(method_32807(field_8695), method_10426(field_8695))
                .method_10431(exporter);
        class_2450.method_10448(class_7800.field_40642, field_8620, 9).method_10446(IRON_BLOCKS)
                .method_10442(method_32807(field_8620), method_10426(field_8620))
                .method_10431(exporter);
        class_2450.method_10448(class_7800.field_40642, field_8477, 9)
                .method_10446(DIAMOND_BLOCKS)
                .method_10442(method_32807(field_8477), method_10426(field_8477))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40642, BlockInit.GUNPOWDER_BLOCK)
                .method_10434('A', field_8054)
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8054), method_10426(field_8054))
                .method_10431(exporter);
        class_2450.method_10448(class_7800.field_40642, field_8054, 9)
                .method_10454(BlockInit.GUNPOWDER_BLOCK)
                .method_10442(method_32807(field_8054), method_10426(field_8054))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40642, BlockInit.PAPER_BLOCK)
                .method_10434('A', field_8407)
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8407), method_10426(field_8407))
                .method_10431(exporter);
        class_2450.method_10448(class_7800.field_40642, field_8407, 9)
                .method_10454(BlockInit.PAPER_BLOCK)
                .method_10442(method_32807(field_8407), method_10426(field_8407))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40642, BlockInit.SMALL_CHEST)
                .method_10433('A', class_3489.field_15534)
                .method_10439("AAA")
                .method_10439("A A")
                .method_10439("AAA")
                .method_10429(hasTag(class_3489.field_15534), method_10420(class_3489.field_15534))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, field_8367)
                .method_10433('A', GOLDEN_BLOCKS)
                .method_10434('B', field_8279)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8279), method_10426(field_8279))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO)
                .method_10434('A', field_8695)
                .method_10434('B', field_8512)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8567), method_10426(field_8567))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.GOLDEN_BAKED_POTATO)
                .method_10434('A', field_8397)
                .method_10434('B', field_8512)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8567), method_10426(field_8567))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.ENCHANTED_GOLDEN_CARROT)
                .method_10434('A', field_8695)
                .method_10434('B', field_8179)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8179), method_10426(field_8179))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.ENCHANTED_GOLDEN_COCONUT)
                .method_10434('A', field_8494)
                .method_10434('B', ItemInit.COCONUT)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(ItemInit.COCONUT), method_10426(ItemInit.COCONUT))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.GOLDEN_COCONUT)
                .method_10434('A', field_8695)
                .method_10434('B', ItemInit.COCONUT)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(ItemInit.COCONUT), method_10426(ItemInit.COCONUT))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.ENCHANTED_GOLDEN_POTATO)
                .method_10434('A', field_8695)
                .method_10434('B', field_8567)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8567), method_10426(field_8567))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40640, ItemInit.GOLDEN_POTATO)
                .method_10434('A', field_8397)
                .method_10434('B', field_8567)
                .method_10439("AAA")
                .method_10439("ABA")
                .method_10439("AAA")
                .method_10429(method_32807(field_8567), method_10426(field_8567))
                .method_10431(exporter);
        List<class_1935> golden_potato = List.of(ItemInit.GOLDEN_POTATO);
        List<class_1935> enchanted_golden_potato = List.of(ItemInit.ENCHANTED_GOLDEN_POTATO);
        class_2446.method_36233(exporter, golden_potato, class_7800.field_40640, ItemInit.GOLDEN_BAKED_POTATO, 1.0F, 200, "golden_baked_potato");
        class_2446.method_36233(exporter, enchanted_golden_potato, class_7800.field_40640, ItemInit.ENCHANTED_GOLDEN_BAKED_POTATO, 1.0F, 200, "enchanted_golden_baked_potato");
        class_2450.method_10448(class_7800.field_40634, BlockInit.PALM_PLANKS, 4)
                .method_10446(PALM_LOGS)
                .method_10442(hasTag(PALM_LOGS), method_10420(PALM_LOGS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40634, BlockInit.PALM_SLAB, 6)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("AAA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40634, BlockInit.PALM_STAIRS, 4)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("A  ").method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40634, BlockInit.PALM_FENCE, 3)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, BlockInit.PALM_FENCE_GATE)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("BAB")
                .method_10439("BAB")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40634, BlockInit.PALM_DOOR, 3)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("AA")
                .method_10439("AA")
                .method_10439("AA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40634, BlockInit.PALM_TRAPDOOR, 2)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40636, BlockInit.PALM_BUTTON)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("A")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40636, BlockInit.PALM_PRESSURE_PLATE)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("AA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40635, BlockInit.PALM_SIGN, 3)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10439(" B ")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10436(class_7800.field_40635, BlockInit.PALM_HANGING_SIGN, 6)
                .method_10434('A', BlockInit.STRIPPED_PALM_LOG)
                .method_10433('B', ConventionalItemTags.CHAINS)
                .method_10439("B B")
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40637, ItemInit.PALM_BOAT)
                .method_10434('A', BlockInit.PALM_PLANKS)
                .method_10439("A A")
                .method_10439("AAA")
                .method_10429(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10431(exporter);
        class_2450.method_10447(class_7800.field_40637, ItemInit.PALM_CHEST_BOAT)
                .method_10454(ItemInit.PALM_BOAT)
                .method_10446(ConventionalItemTags.WOODEN_CHESTS)
                .method_10442(method_32807(BlockInit.PALM_PLANKS), method_10426(BlockInit.PALM_PLANKS))
                .method_10442(method_32807(field_8106), method_10426(field_8106)).method_10431(exporter);
        var palmFamaly = new class_5794.class_5795(BlockInit.PALM_PLANKS)
                .method_33482(BlockInit.PALM_BUTTON)
                .method_33490(BlockInit.PALM_FENCE)
                .method_33491(BlockInit.PALM_FENCE_GATE)
                .method_33494(BlockInit.PALM_PRESSURE_PLATE)
                .method_33483(BlockInit.PALM_SIGN, BlockInit.PALM_WALL_SIGN)
                .method_33492(BlockInit.PALM_SLAB)
                .method_33493(BlockInit.PALM_STAIRS)
                .method_33489(BlockInit.PALM_DOOR)
                .method_33496(BlockInit.PALM_TRAPDOOR)
                .method_33484("wooden")
                .method_33487("has_planks")
                .method_33481();
        method_33535(exporter, palmFamaly, class_7699.method_45397());
        class_2446.method_33717(exporter, class_7800.field_40634, COBBLESTONE_RD20090515, field_20412);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20412, COBBLESTONE_RD20090515);
        class_2446.method_33717(exporter, class_7800.field_40634, COBBLESTONE_C_0_0_14A, field_20412);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20412, COBBLESTONE_C_0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, COBBLESTONE_B1_7, field_20412);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20412, COBBLESTONE_B1_7);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_PLANKS_RD20090515, field_8118);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8118, WOODEN_PLANKS_RD20090515);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_PLANKS_RD161348, field_8118);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8118, WOODEN_PLANKS_RD161348);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_PLANKS_C0_0_14A, field_8118);
        class_2450.method_10448(class_7800.field_40634, WOODEN_PLANKS_C0_0_14A, 4)
                .method_10454(LOG_C0_0_14A)
                .method_10442(method_32807(LOG_C0_0_14A), method_10426(LOG_C0_0_14A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8118, WOODEN_PLANKS_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_PLANKS_C0_0_15A, field_8118);
        class_2450.method_10448(class_7800.field_40634, WOODEN_PLANKS_C0_0_15A, 8)
                .method_10454(LOG_C0_0_14A)
                .method_10454(LOG_C0_0_14A)
                .method_10442(method_32807(LOG_C0_0_14A), method_10426(LOG_C0_0_14A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8118, WOODEN_PLANKS_C0_0_15A);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_PLANKS_B1_9PRE5, field_8118);
        class_2450.method_10448(class_7800.field_40634, WOODEN_PLANKS_B1_9PRE5, 12)
                .method_10454(LOG_C0_0_14A)
                .method_10454(LOG_C0_0_14A)
                .method_10454(LOG_C0_0_14A)
                .method_10442(method_32807(LOG_C0_0_14A), method_10426(LOG_C0_0_14A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8118, WOODEN_PLANKS_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, LOG_C0_0_14A, field_8583);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8583, LOG_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, LEAVES_C0_0_14A, field_17503);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17503, LEAVES_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, LEAVES_C0_0_15A, field_17503);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17503, LEAVES_C0_0_15A);
        class_2446.method_33717(exporter, class_7800.field_40634, LEAVES_C0_24ST, field_17503);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17503, LEAVES_C0_24ST);
        class_2446.method_33717(exporter, class_7800.field_40634, SAPLING_RD161348, field_17535);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17535, SAPLING_RD161348);
        class_2446.method_33717(exporter, class_7800.field_40634, SAPLING_C0_0_13A, field_17535);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17535, SAPLING_C0_0_13A);
        class_2446.method_33717(exporter, class_7800.field_40634, SAPLING_C0_24ST, field_17535);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17535, SAPLING_C0_24ST);
        class_2446.method_33717(exporter, class_7800.field_40634, BEDROCK_C0_0_12A, field_8542);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8542, BEDROCK_C0_0_12A);
        class_2446.method_33717(exporter, class_7800.field_40634, SAND_C0_0_14A, field_8858);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8858, SAND_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, SAND_C0_0_15A, field_8858);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8858, SAND_C0_0_15A);
        class_2446.method_33717(exporter, class_7800.field_40634, SAND_B1_9PRE6, field_8858);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8858, SAND_B1_9PRE6);
        class_2446.method_33717(exporter, class_7800.field_40634, GRAVEL_C0_0_14A, field_8110);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8110, GRAVEL_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, GRAVEL_C0_0_15A, field_8110);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8110, GRAVEL_C0_0_15A);
        class_2446.method_33717(exporter, class_7800.field_40634, GRAVEL_B1_9PRE5, field_8110);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8110, GRAVEL_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, GRAVEL_1_3, field_8110);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8110, GRAVEL_1_3);
        class_2446.method_33717(exporter, class_7800.field_40634, COAL_ORE_C0_0_14A, field_8476);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8476, COAL_ORE_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, COAL_ORE_1_14, field_8476);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8476, COAL_ORE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_ORE_C0_0_14A, field_8599);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8599, IRON_ORE_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_ORE_1_14, field_8599);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8599, IRON_ORE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_ORE_1_14_1, field_8599);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8599, IRON_ORE_1_14_1);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_ORE_C0_0_14A, field_8775);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8775, GOLD_ORE_C0_0_14A);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_ORE_C0_26ST, field_8775);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8775, GOLD_ORE_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_ORE_1_14, field_8775);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8775, GOLD_ORE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, SPONGE_C0_0_19A, field_8535);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8535, SPONGE_C0_0_19A);
        class_2446.method_33717(exporter, class_7800.field_40634, SPONGE_1_8, field_8535);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8535, SPONGE_1_8);
        class_2446.method_33717(exporter, class_7800.field_40634, WET_SPONGE_1_8, field_8554);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8554, WET_SPONGE_1_8);
        class_2446.method_33717(exporter, class_7800.field_40634, GLASS_C0_0_19A, field_8280);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8280, GLASS_C0_0_19A);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_BLOCK_C0_0_20A, field_8494);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8494, GOLD_BLOCK_C0_0_20A);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_BLOCK_C0_26ST, field_8494);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8494, GOLD_BLOCK_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_BLOCK_A1_2_0, field_8494);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8494, GOLD_BLOCK_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, GOLD_BLOCK_B1_9PRE5, field_8494);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8494, GOLD_BLOCK_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, DANDELION_C0_0_20A, field_8491);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8491, DANDELION_C0_0_20A);
        class_2446.method_33717(exporter, class_7800.field_40634, ROSE_C0_0_20A, field_8880);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8880, ROSE_C0_0_20A);
        class_2446.method_33717(exporter, class_7800.field_40634, POPPY_1_7, field_8880);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8880, POPPY_1_7);
        class_2446.method_33717(exporter, class_7800.field_40634, BROWN_MUSHROOM_C0_0_20A, field_17516);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17516, BROWN_MUSHROOM_C0_0_20A);
        class_2446.method_33717(exporter, class_7800.field_40634, RED_MUSHROOM_C0_0_20A, field_17517);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17517, RED_MUSHROOM_C0_0_20A);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_BLOCK_C0_26ST, field_8773);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8773, IRON_BLOCK_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_BLOCK_A1_2_0, field_8773);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8773, IRON_BLOCK_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, IRON_BLOCK_B1_9PRE5, field_8773);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8773, IRON_BLOCK_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, TNT_C0_26ST, field_8626);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8626, TNT_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, TNT_C0_28A, field_8626);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8626, TNT_C0_28A);
        class_2446.method_33717(exporter, class_7800.field_40634, MOSSY_COBBLESTONE_C0_26ST, field_20392);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20392, MOSSY_COBBLESTONE_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, MOSSY_COBBLESTONE_B1_8, field_20392);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20392, MOSSY_COBBLESTONE_B1_8);
        class_2446.method_33717(exporter, class_7800.field_40634, BRICKS_C0_26ST, field_20390);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20390, BRICKS_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, BRICKS_A1_0_11, field_20390);
        class_2446.method_33717(exporter, class_7800.field_40634, field_20390, BRICKS_A1_0_11);
        class_2446.method_33717(exporter, class_7800.field_40634, BOOKSHELF_C0_26ST, field_8536);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8536, BOOKSHELF_C0_26ST);
        class_2446.method_33717(exporter, class_7800.field_40634, BOOKSHELF_B1_9PRE5, field_8536);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8536, BOOKSHELF_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, OBSIDIAN_C0_28A, field_8281);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8281, OBSIDIAN_C0_28A);
        class_2446.method_33717(exporter, class_7800.field_40634, DIAMOND_ORE_IN20100128, field_8787);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8787, DIAMOND_ORE_IN20100128);
        class_2446.method_33717(exporter, class_7800.field_40634, DIAMOND_ORE_1_14, field_8787);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8787, DIAMOND_ORE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, DIAMOND_BLOCK_IN20100128, field_8603);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8603, DIAMOND_BLOCK_IN20100128);
        class_2446.method_33717(exporter, class_7800.field_40634, DIAMOND_BLOCK_A1_2_0, field_8603);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8603, DIAMOND_BLOCK_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, DIAMOND_BLOCK_B1_9PRE5, field_8603);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8603, DIAMOND_BLOCK_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, CRAFTING_TABLE_IN20100131, field_8465);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8465, CRAFTING_TABLE_IN20100131);
        class_2446.method_33717(exporter, class_7800.field_40634, CRAFTING_TABLE_1_14, field_8465);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8465, CRAFTING_TABLE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, FURNACE_IN20100219, field_8732);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8732, FURNACE_IN20100219);
        class_2450.method_10447(class_7800.field_40634, LIT_FURNACE_IN20100219)
                .method_10454(FURNACE_IN20100219)
                .method_10454(field_8713)
                .method_10442(method_32807(FURNACE_IN20100219), method_10426(FURNACE_IN20100219))
                .method_10431(exporter);
        class_2450.method_10447(class_7800.field_40634, FURNACE_IN20100219)
                .method_10454(LIT_FURNACE_IN20100219)
                .method_10454(field_8705)
                .method_10442(method_32807(FURNACE_IN20100219), method_10426(FURNACE_IN20100219))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, FURNACE_B1_2, field_8732);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8732, FURNACE_B1_2);
        class_2450.method_10447(class_7800.field_40634, LIT_FURNACE_B1_2)
                .method_10454(FURNACE_B1_2)
                .method_10454(field_8713)
                .method_10442(method_32807(FURNACE_B1_2), method_10426(FURNACE_B1_2))
                .method_10431(exporter);
        class_2450.method_10447(class_7800.field_40634, FURNACE_B1_2)
                .method_10454(LIT_FURNACE_B1_2)
                .method_10454(field_8705)
                .method_10442(method_32807(FURNACE_B1_2), method_10426(FURNACE_B1_2))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, LADDER_INF20100607, field_8121);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8121, LADDER_INF20100607);
        class_2446.method_33717(exporter, class_7800.field_40634, LADDER_INF20100618, field_8121);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8121, LADDER_INF20100618);
        class_2447.method_10437(class_7800.field_40634, WOODEN_STAIRS_RD20090515)
                .method_10434('A', WOODEN_PLANKS_RD20090515)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(WOODEN_PLANKS_RD20090515), method_10426(WOODEN_PLANKS_RD20090515))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, WOODEN_STAIRS_RD161348)
                .method_10434('A', WOODEN_PLANKS_RD161348)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(WOODEN_PLANKS_RD161348), method_10426(WOODEN_PLANKS_RD161348))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, WOODEN_STAIRS_C0_0_14A)
                .method_10434('A', WOODEN_PLANKS_C0_0_14A)
                .method_10439("A  ").method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_14A), method_10426(WOODEN_PLANKS_C0_0_14A))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, WOODEN_STAIRS_INF20100629)
                .method_10434('A', WOODEN_PLANKS_C0_0_15A)
                .method_10439("A  ").method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_15A), method_10426(WOODEN_PLANKS_C0_0_15A))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, WOODEN_STAIRS_B1_9PRE5)
                .method_10434('A', WOODEN_PLANKS_B1_9PRE5)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(WOODEN_PLANKS_B1_9PRE5), method_10426(WOODEN_PLANKS_B1_9PRE5))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, COBBLESTONE_STAIRS_RD20090515)
                .method_10434('A', COBBLESTONE_RD20090515)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(COBBLESTONE_RD20090515), method_10426(COBBLESTONE_RD20090515))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, COBBLESTONE_STAIRS_C0_0_14A)
                .method_10434('A', COBBLESTONE_C_0_0_14A)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(COBBLESTONE_C_0_0_14A), method_10426(COBBLESTONE_C_0_0_14A))
                .method_10431(exporter);
        class_2447.method_10437(class_7800.field_40634, COBBLESTONE_STAIRS_B1_7)
                .method_10434('A', COBBLESTONE_B1_7)
                .method_10439("A  ")
                .method_10439("AA ")
                .method_10439("AAA")
                .method_10429(method_32807(COBBLESTONE_B1_7), method_10426(COBBLESTONE_B1_7))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, ItemInit.TORCH_IN20100124_2, field_8810);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8810, ItemInit.TORCH_IN20100124_2);
        class_2446.method_33717(exporter, class_7800.field_40634, ItemInit.SIGN_INF20100607, field_8788);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8788, ItemInit.SIGN_INF20100607);
        class_2447.method_10437(class_7800.field_40634, ItemInit.SIGN_INF20100607)
                .method_10434('A', WOODEN_PLANKS_C0_0_15A)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("AAA")
                .method_10439("AAA")
                .method_10439(" B ")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_15A), method_10426(WOODEN_PLANKS_C0_0_15A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_DOOR_INF20100607, field_8691);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8691, WOODEN_DOOR_INF20100607);
        class_2447.method_10437(class_7800.field_40634, WOODEN_DOOR_INF20100607)
                .method_10434('A', WOODEN_PLANKS_C0_0_15A)
                .method_10439("AA")
                .method_10439("AA")
                .method_10439("AA")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_15A), method_10426(WOODEN_PLANKS_C0_0_15A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, REDSTONE_ORE_A1_0_1, field_8604);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8604, REDSTONE_ORE_A1_0_1);
        class_2446.method_33717(exporter, class_7800.field_40634, REDSTONE_ORE_1_14, field_8604);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8604, REDSTONE_ORE_1_14);
        class_2446.method_33717(exporter, class_7800.field_40634, REDSTONE_TORCH_A1_0_1, field_8530);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8530, REDSTONE_TORCH_A1_0_1);
        class_2446.method_33717(exporter, class_7800.field_40634, SNOW_A1_0_4, field_8749);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8749, SNOW_A1_0_4);
        class_2446.method_33717(exporter, class_7800.field_40634, SNOW_BLOCK_A1_0_5, field_8246);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8246, SNOW_BLOCK_A1_0_5);
        class_2446.method_33717(exporter, class_7800.field_40634, ICE_A1_0_4, field_8426);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8426, ICE_A1_0_4);
        class_2446.method_33717(exporter, class_7800.field_40634, CLAY_BLOCK_A1_0_11, field_19060);
        class_2446.method_33717(exporter, class_7800.field_40634, field_19060, CLAY_BLOCK_A1_0_11);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_FENCE_RD20090515, field_8792);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8792, WOODEN_FENCE_RD20090515);
        class_2447.method_10437(class_7800.field_40634, WOODEN_FENCE_RD20090515)
                .method_10434('A', WOODEN_PLANKS_RD20090515)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(WOODEN_PLANKS_RD20090515), method_10426(WOODEN_PLANKS_RD20090515))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_FENCE_RD161348, field_8792);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8792, WOODEN_FENCE_RD161348);
        class_2447.method_10437(class_7800.field_40634, WOODEN_FENCE_RD161348)
                .method_10434('A', WOODEN_PLANKS_RD161348)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(WOODEN_PLANKS_RD161348), method_10426(WOODEN_PLANKS_RD161348))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_FENCE_C0_0_14A, field_8792);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8792, WOODEN_FENCE_C0_0_14A);
        class_2447.method_10437(class_7800.field_40634, WOODEN_FENCE_C0_0_14A)
                .method_10434('A', WOODEN_PLANKS_C0_0_14A)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_14A), method_10426(WOODEN_PLANKS_C0_0_14A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_FENCE_A1_0_17, field_8792);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8792, WOODEN_FENCE_A1_0_17);
        class_2447.method_10437(class_7800.field_40634, WOODEN_FENCE_A1_0_17)
                .method_10434('A', WOODEN_PLANKS_C0_0_15A)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(WOODEN_PLANKS_C0_0_15A), method_10426(WOODEN_PLANKS_C0_0_15A))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, WOODEN_FENCE_B1_9PRE5, field_8792);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8792, WOODEN_FENCE_B1_9PRE5);
        class_2447.method_10437(class_7800.field_40634, WOODEN_FENCE_B1_9PRE5)
                .method_10434('A', WOODEN_PLANKS_B1_9PRE5)
                .method_10433('B', ConventionalItemTags.WOODEN_RODS)
                .method_10439("ABA")
                .method_10439("ABA")
                .method_10429(method_32807(WOODEN_PLANKS_B1_9PRE5), method_10426(WOODEN_PLANKS_B1_9PRE5))
                .method_10431(exporter);
        class_2446.method_33717(exporter, class_7800.field_40634, NETHERRACK_A1_2_0, field_8328);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8328, NETHERRACK_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, NETHERRACK_B1_9PRE5, field_8328);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8328, NETHERRACK_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, SOUL_SAND_A1_2_0, field_8067);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8067, SOUL_SAND_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, GLOWSTONE_A1_2_0, field_8801);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8801, GLOWSTONE_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, GLOWSTONE_B1_9PRE5, field_8801);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8801, GLOWSTONE_B1_9PRE5);
        class_2446.method_33717(exporter, class_7800.field_40634, CARVED_PUMPKIN_A1_2_0, field_17519);
        class_2446.method_33717(exporter, class_7800.field_40634, field_17519, CARVED_PUMPKIN_A1_2_0);
        class_2446.method_33717(exporter, class_7800.field_40634, JACK_O_LANTERN_A1_2_0, field_8693);
        class_2446.method_33717(exporter, class_7800.field_40634, field_8693, JACK_O_LANTERN_A1_2_0);
    }

    private static @NotNull String hasTag(@NotNull class_6862<class_1792> tag) {
        return "has_" + tag.comp_327().toString();
    }
}
