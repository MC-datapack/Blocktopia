package github.mcdatapack.blocktopia.sign.impl;

import net.minecraft.class_4970;

public interface BlockSettingsLock {
    public void lock();
    public static class_4970.class_2251 lock(class_4970.class_2251 settings) {
        ((BlockSettingsLock) settings).lock();
        return settings;
    }
}
