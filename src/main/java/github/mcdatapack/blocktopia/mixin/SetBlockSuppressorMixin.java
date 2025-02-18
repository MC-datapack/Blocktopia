package github.mcdatapack.blocktopia.mixin;

import org.slf4j.Logger;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Util.class)
public class SetBlockSuppressorMixin {
    @Redirect(method = "error(Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;)V"))
    private static void suppressSetBlockError(Logger logger, String message) {
        if (message.contains("setBlock in a far chunk")) {
            return;
        }
        logger.error(message);
    }

    @Redirect(method = "error(Ljava/lang/String;Ljava/lang/Throwable;)V", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V"))
    private static void suppressSetBlockErrorWithThrowable(Logger logger, String message, Throwable throwable) {
        if (message.contains("setBlock in a far chunk")) {
            return;
        }
        logger.error(message, throwable);
    }
}
