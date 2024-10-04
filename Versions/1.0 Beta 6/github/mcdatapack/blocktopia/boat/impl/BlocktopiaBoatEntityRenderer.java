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
import net.minecraft.class_1690;
import net.minecraft.class_2960;
import net.minecraft.class_4595;
import net.minecraft.class_554;
import net.minecraft.class_5601;
import net.minecraft.class_5617;
import net.minecraft.class_630;
import net.minecraft.class_7752;
import net.minecraft.class_7753;
import net.minecraft.class_7754;
import net.minecraft.class_881;

@Environment(EnvType.CLIENT)
public class BlocktopiaBoatEntityRenderer extends class_881 {
    private final Map<BlocktopiaBoatType, Pair<class_2960, class_4595<class_1690>>> texturesAndModels;

    public BlocktopiaBoatEntityRenderer(class_5617.class_5618 context, boolean chest) {
        super(context, chest);

        this.texturesAndModels = BlocktopiaBoatTypeRegistry.INSTANCE.method_29722().stream().collect(ImmutableMap.toImmutableMap(entry -> {
            return entry.getValue();
        }, entry -> {
            boolean raft = entry.getValue().isRaft();
            String prefix = raft ? (chest ? "chest_raft/" : "raft/") : (chest ? "chest_boat/" : "boat/");

            class_2960 id = entry.getKey().method_29177();
            class_2960 textureId = id.method_45134(path -> "textures/entity/" + prefix + path + ".png");

            class_5601 layer = BlocktopiaBoatClientHelper.getLayer(id, raft, chest);
            class_4595<class_1690> model = createModel(context.method_32167(layer), raft, chest);

            return new Pair<>(textureId, model);
        }));
    }

    @Override
    public class_2960 method_3891(class_1690 entity) {
        if (entity instanceof BlocktopiaBoatHolder) {
            BlocktopiaBoatType boat = ((BlocktopiaBoatHolder) entity).getBlocktopiaBoat();
            return this.texturesAndModels.get(boat).getFirst();
        }
        return super.method_3891(entity);
    }

    public Pair<class_2960, class_4595<class_1690>> getTextureAndModel(BlocktopiaBoatHolder holder) {
        return this.texturesAndModels.get(holder.getBlocktopiaBoat());
    }

    private class_4595<class_1690> createModel(class_630 part, boolean raft, boolean chest) {
        if (raft) {
            return chest ? new class_7753(part) : new class_7754(part);
        } else {
            return chest ? new class_7752(part) : new class_554(part);
        }
    }
}
