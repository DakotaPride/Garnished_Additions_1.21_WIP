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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

import java.util.Optional;

public class LethalLianaPlantBlock extends GrowingPlantBodyBlock implements ISenileSpread {
   public static final MapCodec<LethalLianaPlantBlock> CODEC = simpleCodec(LethalLianaPlantBlock::new);
   public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

   public LethalLianaPlantBlock(Properties properties) {
      super(Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.GRASS)
              .instabreak().speedFactor(0.6F).jumpFactor(0.6F).noCollission().offsetType(OffsetType.NONE).pushReaction(PushReaction.DESTROY),
              Direction.DOWN, SHAPE, false);
   }

   @Override
   protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
      return CODEC;
   }

   @Override
   public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState) {
      return false;
   }

   @Override
   protected GrowingPlantHeadBlock getHeadBlock() {
      return (GrowingPlantHeadBlock) GarnishedAdditionsBlocksInit.LETHAL_LIANA.get();
   }

   @Override
   public boolean isValidTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
      Optional<BlockPos> optional = this.getHeadPos(blockGetter, blockPos, blockState.getBlock());
      return optional.isPresent() && NetherVines.isValidGrowthState(blockGetter.getBlockState(optional.get().relative(this.growthDirection)));
   }

   @Override
   public boolean isSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return true;
   }

   @Override
   public void performSpread(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      Optional<BlockPos> optional = this.getHeadPos(serverLevel, blockPos, blockState.getBlock());
      if (optional.isPresent()) {
         BlockState blockstate = serverLevel.getBlockState(optional.get());
         ((GrowingPlantHeadBlock)blockstate.getBlock()).performBonemeal(serverLevel, randomSource, optional.get(), blockstate);
      }
   }

   private Optional<BlockPos> getHeadPos(BlockGetter pLevel, BlockPos pPos, Block pBlock) {
      return BlockUtil.getTopConnectedBlock(pLevel, pPos, pBlock, this.growthDirection, this.getHeadBlock());
   }

   @Override
   public SimpleParticleType getParticle() {
      return ParticleTypes.SOUL;
   }
}
