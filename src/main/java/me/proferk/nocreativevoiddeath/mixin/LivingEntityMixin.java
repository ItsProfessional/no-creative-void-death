package me.proferk.nocreativevoiddeath.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "tickInVoid()V", at = @At("HEAD"), cancellable = true)
    private void tickInVoid(CallbackInfo ci)
    {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        if(livingEntity instanceof PlayerEntity player)
        {
            if(player.getAbilities().creativeMode) ci.cancel();
        }
    }

}
