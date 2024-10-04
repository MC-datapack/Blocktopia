package github.mcdatapack.blocktopia.boat.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry.TexturedModelDataProvider;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.minecraft.client.render.entity.model.ChestRaftEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.RaftEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class BlocktopiaBoatClientHelper {
    private BlocktopiaBoatClientHelper() {
        return;
    }
    private static Identifier getLayerId(Identifier boatId, boolean raft, boolean chest) {
        String prefix = raft ? (chest ? "chest_raft/" : "raft/") : (chest ? "chest_boat/" : "boat/");
        return boatId.withPrefixedPath(prefix);
    }
    public static EntityModelLayer getLayer(Identifier boatId, boolean raft, boolean chest) {
        return new EntityModelLayer(getLayerId(boatId, raft, chest), "main");
    }

    private static TexturedModelDataProvider getTexturedModelDataProvider(boolean raft, boolean chest) {
        if (raft) {
            return chest ? ChestRaftEntityModel::getTexturedModelData : RaftEntityModel::getTexturedModelData;
        } else {
            return chest ? ChestBoatEntityModel::getTexturedModelData : BoatEntityModel::getTexturedModelData;
        }
    }
    private static void registerModelLayer(Identifier boatId, boolean raft, boolean chest) {
        EntityModelLayerRegistry.registerModelLayer(getLayer(boatId, raft, chest), getTexturedModelDataProvider(raft, chest));
    }
    public static void registerModelLayers(Identifier boatId, boolean raft) {
        registerModelLayer(boatId, raft, false);
        registerModelLayer(boatId, raft, true);
    }
}
