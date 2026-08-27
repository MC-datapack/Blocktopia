package github.mcdatapack.blocktopia.block;

import com.mojang.datafixers.util.Either;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public interface MinecraftVersion {
    Map<Block, Either<MinecraftVersion, Range>> VERSION_MAP = new HashMap<>();

    record Range(MinecraftVersion from, MinecraftVersion to) {
        public boolean contains(MinecraftVersion version) {
            return version.compareTo(from) <= 0 && version.compareTo(to) >= 0;
        }
    }

    enum Type {
        LEGACY, FUTURE
    }

    String getName();
    int getIndex();
    default int compareTo(MinecraftVersion version) {
        return version.getIndex() - getIndex();
    }
    default Type getType() {
        return compareTo(MinecraftVersions._1_21_1) > 0 ? Type.LEGACY : Type.FUTURE;
    }
    default String getRegistryName() {
        return getName().replaceAll("\\.", "_");
    }
}
