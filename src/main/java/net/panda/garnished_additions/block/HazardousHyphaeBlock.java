package net.panda.garnished_additions.block;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.block.ISenileSpread;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

import java.util.Optional;

public class HazardousHyphaeBlock extends GrowingPlantHeadBlock implements ISenileSpread {
   public static final MapCodec<HazardousHyphaeBlock> CODEC = simpleCodec(HazardousHyphaeBlock::new);
   protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);
   public HazardousHyphaeBlock(Properties properties) {
      super(Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.GRASS)
                      .instabreak().speedFactor(0.6F).jumpFactor(0.6F).noCollission().offsetType(OffsetType.NONE).pushReaction(PushReaction.DESTROY),
              Direction.DOWN, SHAPE, false, 0.1D);
   }

   @Override
   protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
      return CODEC;
   }

   @Override
   public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
      return false;
   }

   @Override
   protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
      return NetherVines.getBlocksToGrowWhenBonemealed(random);
   }

   @Override
   protected Block getBodyBlock() {
      return GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE_PLANT.get();
   }

   @Override
   protected boolean canGrowInto(BlockState state) {
      return NetherVines.isValidGrowthState(state);
   }

   @Override
   public boolean isValidTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
      return this.canGrowInto(blockGetter.getBlockState(blockPos.relative(this.growthDirection)));
   }

   @Override
   public boolean isSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return true;
   }

   @Override
   public void performSpread(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      BlockPos blockpos = blockPos.relative(this.growthDirection);
      int i = Math.min(blockState.getValue(AGE) + 1, 25);
      int j = this.getBlocksToGrowWhenBonemealed(randomSource);

      for(int k = 0; k < j && this.canGrowInto(serverLevel.getBlockState(blockpos)); ++k) {
         serverLevel.setBlockAndUpdate(blockpos, blockState.setValue(AGE, Integer.valueOf(i)));
         blockpos = blockpos.relative(this.growthDirection);
         i = Math.min(i + 1, 25);
      }
   }

   @Override
   public SimpleParticleType getParticle() {
      return ParticleTypes.SOUL;
   }
}