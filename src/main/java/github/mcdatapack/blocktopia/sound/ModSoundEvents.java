package github.mcdatapack.blocktopia.sound;

import github.mcdatapack.blocktopia.Blocktopia;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public interface ModSoundEvents {
    //TODO: Shelfs
    //SoundEvent BLOCK_SHELF_ACTIVATE = register("block.shelf.activate");
    //SoundEvent BLOCK_SHELF_BREAK = register("block.shelf.break");
    //SoundEvent BLOCK_SHELF_DEACTIVATE = register("block.shelf.deactivate");
    //SoundEvent BLOCK_SHELF_FALL = register("block.shelf.fall");
    //SoundEvent BLOCK_SHELF_HIT = register("block.shelf.hit");
    //SoundEvent BLOCK_SHELF_MULTI_SWAP = register("block.shelf.multi_swap");
    //SoundEvent BLOCK_SHELF_PLACE = register("block.shelf.place");
    //SoundEvent BLOCK_SHELF_PLACE_ITEM = register("block.shelf.place_item");
    //SoundEvent BLOCK_SHELF_SINGLE_SWAP = register("block.shelf.single_swap");
    //SoundEvent BLOCK_SHELF_STEP = register("block.shelf.step");
    //SoundEvent BLOCK_SHELF_TAKE_ITEM = register("block.shelf.take_item");

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, Blocktopia.id(id), SoundEvent.of(Blocktopia.id(id)));
    }
}
