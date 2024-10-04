package github.mcdatapack.blocktopia.boat.impl;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatClientHelper;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatType;
import github.mcdatapack.blocktopia.boat.api.BlocktopiaBoatTypeRegistry;
import github.mcdatapack.blocktopia.boat.impl.entity.BlocktopiaBoatHolder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.minecraft.client.render.entity.model.ChestRaftEntityModel;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.RaftEntityModel;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BlocktopiaBoatEntityRenderer extends BoatEntityRenderer {
    private final Map<BlocktopiaBoatType, Pair<Identifier, CompositeEntityModel<BoatEntity>>> texturesAndModels;

    public BlocktopiaBoatEntityRenderer(EntityRendererFactory.Context context, boolean chest) {
        super(context, chest);

        this.texturesAndModels = BlocktopiaBoatTypeRegistry.INSTANCE.getEntrySet().stream().collect(ImmutableMap.toImmutableMap(entry -> {
            return entry.getValue();
        }, entry -> {
            boolean raft = entry.getValue().isRaft();
            String prefix = raft ? (chest ? "chest_raft/" : "raft/") : (chest ? "chest_boat/" : "boat/");

            Identifier id = entry.getKey().getValue();
            Identifier textureId = id.withPath(path -> "textures/entity/" + prefix + path + ".png");

            EntityModelLayer layer = BlocktopiaBoatClientHelper.getLayer(id, raft, chest);
            CompositeEntityModel<BoatEntity> model = createModel(context.getPart(layer), raft, chest);

            return new Pair<>(textureId, model);
        }));
    }

    @Override
    public Identifier getTexture(BoatEntity entity) {
        if (entity instanceof BlocktopiaBoatHolder) {
            BlocktopiaBoatType boat = ((BlocktopiaBoatHolder) entity).getBlocktopiaBoat();
            return this.texturesAndModels.get(boat).getFirst();
        }
        return super.getTexture(entity);
    }

    public Pair<Identifier, CompositeEntityModel<BoatEntity>> getTextureAndModel(BlocktopiaBoatHolder holder) {
        return this.texturesAndModels.get(holder.getBlocktopiaBoat());
    }

    private CompositeEntityModel<BoatEntity> createModel(ModelPart part, boolean raft, boolean chest) {
        if (raft) {
            return chest ? new ChestRaftEntityModel(part) : new RaftEntityModel(part);
        } else {
            return chest ? new ChestBoatEntityModel(part) : new BoatEntityModel(part);
        }
    }
}
