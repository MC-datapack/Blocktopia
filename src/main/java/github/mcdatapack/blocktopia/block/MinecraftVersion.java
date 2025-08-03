package github.mcdatapack.blocktopia.block;

public interface MinecraftVersion {
    String getName();
    default String getRegistryName() {
        return getName().replaceAll("\\.", "_");
    }
}
