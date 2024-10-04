package github.mcdatapack.blocktopia.sign.impl;

import net.minecraft.block.AbstractBlock;

public interface BlockSettingsLock {
    public void lock();
    public static AbstractBlock.Settings lock(AbstractBlock.Settings settings) {
        ((BlockSettingsLock) settings).lock();
        return settings;
    }
}
