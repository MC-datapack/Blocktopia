package github.mcdatapack.blocktopia.worldgen.tree.decorator;

import com.mojang.serialization.MapCodec;
import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public interface ModTreeDecoratorTypes {
    TreeDecoratorType<LeavesTreeDecorator> LEAVES_TREE_DECORATOR = register("leaves_tree_decorator", LeavesTreeDecorator.CODEC);
    TreeDecoratorType<PaleMossTreeDecorator> PALE_MOSS_TREE_DECORATOR = register("pale_moss_tree_decorator", PaleMossTreeDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, Blocktopia.id(id), new TreeDecoratorType<>(codec));
    }
    static void load() {}
}
