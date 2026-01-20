package net.panda.garnished_additions.mixin;

import net.dakotapride.garnished.item.DesolateSpreadItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = DesolateSpreadItem.class, remap = false)
public abstract class DesolateSpreadItemMixin {

    @Shadow public abstract boolean isSuccessful();

    @Shadow public abstract void performSpread(ServerLevel level, RandomSource random, BlockPos pos);

    @Shadow protected abstract void place(Registry<ConfiguredFeature<?, ?>> registry, ServerLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos);

    @Inject(method = "applySpread", at = @At("HEAD"), cancellable = true)
    private void applySpread(ItemStack stack, Level level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.getBlock().defaultBlockState().is(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get())) {
            if (level instanceof ServerLevel) {
                if (this.isSuccessful()) {
                    this.performSpread((ServerLevel)level, level.random, pos);
                }

                stack.shrink(1);
            }

            cir.setReturnValue(true);
        }
    }

    @Inject(method = "performSpread", at = @At("HEAD"))
    private void performSpread(ServerLevel level, RandomSource random, BlockPos pos, CallbackInfo ci) {
        BlockState blockstate = level.getBlockState(pos);
        BlockPos blockpos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        if (blockstate.is(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get())) {
            this.place(registry, level, chunkgenerator, random, blockpos);
        }
    }
}
