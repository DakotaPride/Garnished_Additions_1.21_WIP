package net.panda.garnished_additions.mixin;

import net.dakotapride.garnished.block.sapling.EndPlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EndPlantBlock.class, remap = false)
public class EndPlantBlockMixin {

    @Inject(method = "mayPlaceOn", at = @At("HEAD"), cancellable = true)
    private void mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get()))
            cir.setReturnValue(true);
    }
}
