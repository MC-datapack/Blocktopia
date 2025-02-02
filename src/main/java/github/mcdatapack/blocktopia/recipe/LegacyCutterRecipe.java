package github.mcdatapack.blocktopia.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class LegacyCutterRecipe implements Recipe<SingleStackRecipeInput> {
    protected final ItemStack output;
    protected final Ingredient recipeItem;

    public LegacyCutterRecipe(Ingredient ingredients, ItemStack itemStack) {
        this.output = itemStack;
        this.recipeItem = ingredients;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return recipeItem.test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(recipeItem);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<LegacyCutterRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "legacy_cutter";
    }

    public interface RecipeFactory {
        LegacyCutterRecipe create(Ingredient ingredient, ItemStack result);
    }

    public static class Serializer implements RecipeSerializer<LegacyCutterRecipe> {
        public static final RecipeSerializer<LegacyCutterRecipe> INSTANCE = new Serializer(LegacyCutterRecipe::new);
        public static final String ID = "legacy_cutter";

        private final RecipeFactory recipeFactory;
        public final MapCodec<LegacyCutterRecipe> codec;
        private final PacketCodec<RegistryByteBuf, LegacyCutterRecipe> packetCodec;

        public Serializer(RecipeFactory factory) {
            this.recipeFactory = factory;
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                    Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.recipeItem),
                    ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result").forGetter(recipe -> recipe.output)
            ).apply(instance, recipeFactory::create));
            this.packetCodec = PacketCodec.ofStatic(this::write, this::read);
        }

        @Override
        public MapCodec<LegacyCutterRecipe> codec() {
            return codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, LegacyCutterRecipe> packetCodec() {
            return packetCodec;
        }

        private LegacyCutterRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack);
        }

        private void write(RegistryByteBuf buf, LegacyCutterRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.recipeItem);
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
        }

        public LegacyCutterRecipe create(Ingredient ingredient, ItemStack result) {
            return this.recipeFactory.create(ingredient, result);
        }
    }
}