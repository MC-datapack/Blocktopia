package github.mcdatapack.blocktopia.boat.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.TexturedModelDataProvider;
import net.minecraft.class_2960;
import net.minecraft.class_554;
import net.minecraft.class_5601;
import net.minecraft.class_7752;
import net.minecraft.class_7753;
import net.minecraft.class_7754;

@Environment(EnvType.CLIENT)
public final class BlocktopiaBoatClientHelper {
    private BlocktopiaBoatClientHelper() {
        return;
    }
    private static class_2960 getLayerId(class_2960 boatId, boolean raft, boolean chest) {
        String prefix = raft ? (chest ? "chest_raft/" : "raft/") : (chest ? "chest_boat/" : "boat/");
        return boatId.method_45138(prefix);
    }
    public static class_5601 getLayer(class_2960 boatId, boolean raft, boolean chest) {
        return new class_5601(getLayerId(boatId, raft, chest), "main");
    }

    private static TexturedModelDataProvider getTexturedModelDataProvider(boolean raft, boolean chest) {
        if (raft) {
            return chest ? class_7753::method_45709 : class_7754::method_45714;
        } else {
            return chest ? class_7752::method_45708 : class_554::method_31985;
        }
    }
    private static void registerModelLayer(class_2960 boatId, boolean raft, boolean chest) {
        EntityModelLayerRegistry.registerModelLayer(getLayer(boatId, raft, chest), getTexturedModelDataProvider(raft, chest));
    }
    public static void registerModelLayers(class_2960 boatId, boolean raft) {
        registerModelLayer(boatId, raft, false);
        registerModelLayer(boatId, raft, true);
    }
}
