package net.panda.garnished_additions.item;

import net.dakotapride.garnished.block.IDesolateSpread;
import net.dakotapride.garnished.block.ISenileSpread;
import net.dakotapride.garnished.registry.GarnishedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;
import org.jetbrains.annotations.NotNull;

// Return to this
public class BiocharItem extends BoneMealItem {
   public BiocharItem(Properties properties) {
      super(properties);
   }

   public @NotNull InteractionResult useOn(UseOnContext ctx) {
      Level level = ctx.getLevel();
      BlockPos pos = ctx.getClickedPos();
      if (this.applySenileSpread(ctx.getItemInHand(), level, pos)) {
         getSenileParticles(level, pos, 0);
         return InteractionResult.sidedSuccess(level.isClientSide);
      } else if (this.applyDesolateSpread(ctx.getItemInHand(), level, pos)) {
         getDesolateParticles(level, pos, 0);
         return InteractionResult.sidedSuccess(level.isClientSide);
      } else {
         BlockState state = level.getBlockState(pos);
         if (state.getBlock() instanceof BonemealableBlock) {
            if (state.getBlock() instanceof CropBlock cropBlock) {
               if (!cropBlock.isMaxAge(state)) {
                  level.setBlock(pos, cropBlock.getStateForAge(cropBlock.getMaxAge()), 2);

                  if (level instanceof ServerLevel server)
                     server.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                             pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                             10, 0.3, 0.3, 0.3, 0.0);

                  if (ctx.getPlayer() != null && !ctx.getPlayer().isCreative()) {
                     ctx.getItemInHand().shrink(1);
                  }
               } else {
                  return InteractionResult.PASS;
               }
            } else if (state.is(Blocks.PITCHER_CROP)) {
               PitcherCropBlock pitcherCropBlock = (PitcherCropBlock) state.getBlock();
               if (!isPitcherAtMaxAge(state)) {
                  //level.setBlock(pos, pitcherCropBlock.defaultBlockState().setValue(PitcherCropBlock.AGE, 4), 2);
                  if (level instanceof ServerLevel server) {
                     int maxAge = PitcherCropBlock.MAX_AGE;
                     int currentAge = pitcherCropBlock.defaultBlockState().getValue(PitcherCropBlock.AGE);
                     int ageIncrement = maxAge - currentAge;
                     grow(server, state, pos, ageIncrement);
                     server.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                             pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                             10, 0.3, 0.3, 0.3, 0.0);
                  }

                  if (ctx.getPlayer() != null && !ctx.getPlayer().isCreative()) {
                     ctx.getItemInHand().shrink(1);
                  }
               } else {
                  return InteractionResult.PASS;
               }
            } else if (applyBonemeal(ctx.getItemInHand(), level, pos, ctx.getPlayer())) {
               if (!level.isClientSide) {
                  ctx.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                  level.levelEvent(1505, pos, 15);
               } else {
                  return InteractionResult.PASS;
               }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
         } else {
            BlockState blockstate = level.getBlockState(pos);
            BlockPos pos1 = pos.relative(ctx.getClickedFace());
            boolean flag = blockstate.isFaceSturdy(level, pos, ctx.getClickedFace());
            if (flag && growWaterPlant(ctx.getItemInHand(), level, pos1, ctx.getClickedFace())) {
               if (!level.isClientSide) {
                  ctx.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                  level.levelEvent(1505, pos1, 15);
               }

               return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
               return InteractionResult.PASS;
            }
         }
      }
   }

   public boolean isSuccessful() {
      return true;
   }

   // Pitcher Plant
   private boolean isPitcherAtMaxAge(BlockState state) {
      return state.getValue(PitcherCropBlock.AGE) >= 4;
   }

   private void grow(ServerLevel level, BlockState state, BlockPos pos, int ageIncrement) {
      int i = Math.min(state.getValue(PitcherCropBlock.AGE) + ageIncrement, 4);
      if (canGrow(level, pos, state, i)) {
         BlockState blockstate = state.setValue(PitcherCropBlock.AGE, Integer.valueOf(i));
         level.setBlock(pos, blockstate, 2);
         if (isDouble(i)) {
            level.setBlock(pos.above(), blockstate.setValue(PitcherCropBlock.HALF, DoubleBlockHalf.UPPER), 3);
         }
      }
   }

   private boolean canGrow(LevelReader reader, BlockPos pos, BlockState state, int age) {
      return !(state.getValue(PitcherCropBlock.AGE) >= 4) && CropBlock.hasSufficientLight(reader, pos) && (!isDouble(age) || canPitcherCropGrowInto(reader, pos.above()));
   }

   private static boolean canPitcherCropGrowInto(LevelReader level, BlockPos pos) {
      BlockState blockstate = level.getBlockState(pos);
      return blockstate.isAir() || blockstate.is(Blocks.PITCHER_CROP);
   }

   private static boolean isDouble(int age) {
      return age >= 3;
   }

   // Desolate Spread Behaviour
   public boolean applyDesolateSpread(ItemStack stack, Level level, BlockPos pos) {
      BlockState blockstate = level.getBlockState(pos);
      if (level.getBlockState(pos.above()).is(Blocks.AIR) && (blockstate.getBlock().defaultBlockState().is(Blocks.END_STONE) || blockstate.getBlock().defaultBlockState().is(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get()))) {
         if (level instanceof ServerLevel) {
            if (this.isSuccessful()) {
               this.performDesolateSpread((ServerLevel)level, level.random, pos);
            }

            stack.shrink(1);
         }

         return true;
      } else {
         Block var6 = blockstate.getBlock();
         if (var6 instanceof IDesolateSpread spreadableBlock) {
             if (spreadableBlock.isValidTarget(level, pos, blockstate, level.isClientSide)) {
               if (level instanceof ServerLevel) {
                  if (spreadableBlock.isSuccess(level, level.random, pos, blockstate)) {
                     spreadableBlock.performSpread((ServerLevel)level, level.random, pos, blockstate);
                  }

                  stack.shrink(1);
               }

               return true;
            }
         }

         return false;
      }
   }

   public void performDesolateSpread(ServerLevel level, RandomSource random, BlockPos pos) {
      BlockState blockstate = level.getBlockState(pos);
      BlockPos blockpos = pos.above();
      ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
      Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
      if (blockstate.is(Blocks.END_STONE) || blockstate.is(GarnishedAdditionsBlocksInit.ROOTED_END_STONE.get())) {
         this.place(registry, level, chunkgenerator, random, blockpos);
      }

   }

   private void place(Registry<ConfiguredFeature<?, ?>> registry, ServerLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos) {
      registry.getHolder(GarnishedFeatures.END_STONE_VEGETATION_SPREAD_CONFIGURED).ifPresent((value) -> (value.value()).place(level, generator, random, pos));
   }

   public static void getDesolateParticles(LevelAccessor level, BlockPos pos, int data) {
      if (data == 0) {
         data = 15;
      }

      BlockState blockstate = level.getBlockState(pos);
      if (!blockstate.isAir()) {
         double d0 = 0.5F;
         double d1;
         if (blockstate.isSolidRender(level, pos)) {
            pos = pos.above();
            data *= 3;
            d0 = 3.0F;
            d1 = 1.0F;
         } else {
            d1 = blockstate.getShape(level, pos).max(Direction.Axis.Y);
         }

         Block var9 = blockstate.getBlock();
         if (var9 instanceof IDesolateSpread spreadableBlock) {
             level.addParticle(spreadableBlock.getParticle(), (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, (double)0.0F, (double)0.0F, (double)0.0F);
            RandomSource randomsource = level.getRandom();

            for(int i = 0; i < data; ++i) {
               double d2 = randomsource.nextGaussian() * 0.02;
               double d3 = randomsource.nextGaussian() * 0.02;
               double d4 = randomsource.nextGaussian() * 0.02;
               double d5 = (double)0.5F - d0;
               double d6 = (double)pos.getX() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               double d7 = (double)pos.getY() + randomsource.nextDouble() * d1;
               double d8 = (double)pos.getZ() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               if (!level.getBlockState((new BlockPos((int)d6, (int)d7, (int)d8)).below()).isAir()) {
                  level.addParticle(spreadableBlock.getParticle(), d6, d7, d8, d2, d3, d4);
               }
            }
         } else {
            level.addParticle(ParticleTypes.PORTAL, (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, (double)0.0F, (double)0.0F, (double)0.0F);
            RandomSource randomsource = level.getRandom();

            for(int i = 0; i < data; ++i) {
               double d2 = randomsource.nextGaussian() * 0.02;
               double d3 = randomsource.nextGaussian() * 0.02;
               double d4 = randomsource.nextGaussian() * 0.02;
               double d5 = (double)0.5F - d0;
               double d6 = (double)pos.getX() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               double d7 = (double)pos.getY() + randomsource.nextDouble() * d1;
               double d8 = (double)pos.getZ() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               if (!level.getBlockState((new BlockPos((int)d6, (int)d7, (int)d8)).below()).isAir()) {
                  level.addParticle(ParticleTypes.PORTAL, d6, d7, d8, d2, d3, d4);
               }
            }
         }
      }

   }

   // Senile Spread Behaviour
   public boolean applySenileSpread(ItemStack stack, Level level, BlockPos pos) {
      BlockState blockstate = level.getBlockState(pos);
      if (!level.getBlockState(pos.above()).is(Blocks.AIR) || !blockstate.getBlock().defaultBlockState().is(BlockTags.SOUL_FIRE_BASE_BLOCKS) && !blockstate.getBlock().defaultBlockState().is(Blocks.WARPED_NYLIUM) && !blockstate.getBlock().defaultBlockState().is(Blocks.CRIMSON_NYLIUM)) {
         Block var6 = blockstate.getBlock();
         if (var6 instanceof ISenileSpread spreadableBlock) {
             if (spreadableBlock.isValidTarget(level, pos, blockstate, level.isClientSide)) {
               if (level instanceof ServerLevel) {
                  if (spreadableBlock.isSuccess(level, level.random, pos, blockstate)) {
                     spreadableBlock.performSpread((ServerLevel)level, level.random, pos, blockstate);
                  }

                  stack.shrink(1);
               }

               return true;
            }
         }

         return false;
      } else {
         if (level instanceof ServerLevel) {
            if (this.isSuccessful()) {
               this.performSenileSpread((ServerLevel)level, level.random, pos);
            }

            stack.shrink(1);
         }

         return true;
      }
   }

   public void performSenileSpread(ServerLevel level, RandomSource random, BlockPos pos) {
      BlockState blockstate = level.getBlockState(pos);
      BlockPos blockpos = pos.above();
      ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
      Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
      if (blockstate.is(BlockTags.SOUL_FIRE_BASE_BLOCKS) || blockstate.is(Blocks.WARPED_NYLIUM) || blockstate.is(Blocks.CRIMSON_NYLIUM)) {
         this.place(blockstate, registry, level, chunkgenerator, random, blockpos);
      }

   }

   private void place(BlockState blockstate, Registry<ConfiguredFeature<?, ?>> registry, ServerLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos) {
      if (blockstate.is(BlockTags.SOUL_FIRE_BASE_BLOCKS)) {
         registry.getHolder(GarnishedFeatures.SOUL_SAND_VEGETATION_SPREAD_CONFIGURED).ifPresent((feature) -> (feature.value()).place(level, generator, random, pos));
      } else if (blockstate.is(Blocks.WARPED_NYLIUM)) {
         registry.getHolder(GarnishedFeatures.WARPED_VEGETATION_SPREAD_CONFIGURED).ifPresent((feature) -> (feature.value()).place(level, generator, random, pos));
      } else if (blockstate.is(Blocks.CRIMSON_NYLIUM)) {
         registry.getHolder(GarnishedFeatures.CRIMSON_VEGETATION_SPREAD_CONFIGURED).ifPresent((feature) -> (feature.value()).place(level, generator, random, pos));
      }

   }

   public static void getSenileParticles(LevelAccessor level, BlockPos pos, int data) {
      if (data == 0) {
         data = 15;
      }

      BlockState blockstate = level.getBlockState(pos);
      if (!blockstate.isAir()) {
         double d0 = 0.5F;
         double d1;
         if (blockstate.isSolidRender(level, pos)) {
            pos = pos.above();
            data *= 3;
            d0 = 3.0F;
            d1 = 1.0F;
         } else {
            d1 = blockstate.getShape(level, pos).max(Direction.Axis.Y);
         }

         Block var9 = blockstate.getBlock();
         if (var9 instanceof ISenileSpread spreadableBlock) {
             level.addParticle(spreadableBlock.getParticle(), (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, (double)0.0F, (double)0.0F, (double)0.0F);
            RandomSource randomsource = level.getRandom();

            for(int i = 0; i < data; ++i) {
               double d2 = randomsource.nextGaussian() * 0.02;
               double d3 = randomsource.nextGaussian() * 0.02;
               double d4 = randomsource.nextGaussian() * 0.02;
               double d5 = (double)0.5F - d0;
               double d6 = (double)pos.getX() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               double d7 = (double)pos.getY() + randomsource.nextDouble() * d1;
               double d8 = (double)pos.getZ() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               if (!level.getBlockState((new BlockPos((int)d6, (int)d7, (int)d8)).below()).isAir()) {
                  level.addParticle(spreadableBlock.getParticle(), d6, d7, d8, d2, d3, d4);
               }
            }
         } else {
            level.addParticle(ParticleTypes.SOUL, (double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, (double)0.0F, (double)0.0F, (double)0.0F);
            RandomSource randomsource = level.getRandom();

            for(int i = 0; i < data; ++i) {
               double d2 = randomsource.nextGaussian() * 0.02;
               double d3 = randomsource.nextGaussian() * 0.02;
               double d4 = randomsource.nextGaussian() * 0.02;
               double d5 = (double)0.5F - d0;
               double d6 = (double)pos.getX() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               double d7 = (double)pos.getY() + randomsource.nextDouble() * d1;
               double d8 = (double)pos.getZ() + d5 + randomsource.nextDouble() * d0 * (double)2.0F;
               if (!level.getBlockState((new BlockPos((int)d6, (int)d7, (int)d8)).below()).isAir()) {
                  level.addParticle(ParticleTypes.SOUL, d6, d7, d8, d2, d3, d4);
               }
            }
         }
      }

   }
}
