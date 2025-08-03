package github.mcdatapack.blocktopia.mixin.block;

import github.mcdatapack.blocktopia.config.BlocktopiaConfig;
import net.minecraft.network.packet.c2s.play.UpdateStructureBlockC2SPacket;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpdateStructureBlockC2SPacket.class)
public class UpdateStructureBlockC2SPacketMixin {
    @Redirect(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(III)I"))
    private int clamp(int value, int min, int max) {
        return MathHelper.clamp(value, min == 0 ? 0 : -(BlocktopiaConfig.getConfig().structureBlockMax), BlocktopiaConfig.getConfig().structureBlockMax);
    }
}
