package github.mcdatapack.blocktopia.mixin.entity.villager;

import github.mcdatapack.blocktopia.Blocktopia;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.render.entity.feature.VillagerClothingFeatureRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VillagerClothingFeatureRenderer.class)
public class VillagerClothingFeatureRendererMixin {
    @Shadow @Final @Mutable private static Int2ObjectMap<Identifier> LEVEL_TO_ID = Util.make(new Int2ObjectOpenHashMap<>(), levelToId -> {
        levelToId.put(1, Identifier.ofVanilla("stone"));
        levelToId.put(2, Identifier.ofVanilla("iron"));
        levelToId.put(3, Identifier.ofVanilla("gold"));
        levelToId.put(4, Identifier.ofVanilla("emerald"));
        levelToId.put(5, Identifier.ofVanilla("diamond"));
        levelToId.put(6, Blocktopia.id("deepslate_emerald"));
        levelToId.put(7, Blocktopia.id("sculk_emerald"));
        levelToId.put(8, Blocktopia.id("blackstone_emerald"));
        levelToId.put(9, Blocktopia.id("end_emerald"));
        levelToId.put(10, Blocktopia.id("end_diamond"));
    });
}
