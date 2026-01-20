package net.panda.garnished_additions.block;

import net.dakotapride.garnished.block.IDesolateSpread;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.panda.garnished_additions.GarnishedAdditionsTags;

public class EtherealGrowthBlock extends SaplingBlock implements BonemealableBlock, IDesolateSpread {
   public EtherealGrowthBlock(Properties properties) {
      super(EtherealTreeGrower.ETHEREAL, properties);
   }

   @Override
   protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
      return pState.is(GarnishedAdditionsTags.BlockTags.CAN_PLACE_ETHEREAL_PLANT_ON.getTag());
   }

   @Override
   public boolean isValidTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
      return true;
   }

   @Override
   public boolean isSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return level.random.nextFloat() < 0.45D;
   }

   @Override
   public void performSpread(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      this.advanceTree(serverLevel, blockPos, blockState, randomSource);
   }

   @Override
   public SimpleParticleType getParticle() {
      return ParticleTypes.PORTAL;
   }
}
