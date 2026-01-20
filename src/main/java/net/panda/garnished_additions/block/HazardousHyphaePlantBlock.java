package net.panda.garnished_additions.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

public class HazardousHyphaePlantBlock extends GrowingPlantBodyBlock {
   public static final MapCodec<HazardousHyphaePlantBlock> CODEC = simpleCodec(HazardousHyphaePlantBlock::new);
   public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

   public HazardousHyphaePlantBlock(Properties properties) {
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
      return (GrowingPlantHeadBlock) GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE.get();
   }
}
