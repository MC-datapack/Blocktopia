package github.mcdatapack.blocktopia.block.custom.property;

import net.minecraft.registry.Registries;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Optional;

public class PotionProperty extends Property<Identifier> {
    public PotionProperty(String name) {
        super(name, Identifier.class);
    }

    @Override
    public Collection<Identifier> getValues() {
        return Registries.POTION.getIds();
    }

    @Override
    public String name(Identifier value) {
        return value.toString();
    }

    @Override
    public Optional<Identifier> parse(String name) {
        return Optional.of(Identifier.of(name));
    }
}
