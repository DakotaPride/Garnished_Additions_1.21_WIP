package net.panda.garnished_additions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EtherealCakeBlock extends Block {
   public static final int MAX_BITES = 6;
   public static final IntegerProperty BITES = BlockStateProperties.BITES;
   public static final int FULL_CAKE_SIGNAL = getOutputSignal(0);
   protected static final float AABB_OFFSET = 1.0F;
   protected static final float AABB_SIZE_PER_BITE = 2.0F;
   protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
           Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
           Block.box(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)
   };

   public EtherealCakeBlock(Properties properties) {
      super(Properties.of().sound(SoundType.WOOL).strength(0.5F).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
      this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      return SHAPE_BY_BITE[state.getValue(BITES)];
   }

   public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
      ItemStack itemstack = player.getItemInHand(hand);
//      Item item = itemstack.getItem();
//      if (itemstack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
//         Block block = Block.byItem(item);
//         if (block instanceof CandleBlock) {
//            if (!player.isCreative()) {
//               itemstack.shrink(1);
//            }
//
//            level.playSound((Player)null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
//            level.setBlockAndUpdate(pos, CandleCakeBlock.byCandle(block));
//            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
//            player.awardStat(Stats.ITEM_USED.get(item));
//            return InteractionResult.SUCCESS;
//         }
//      }

      if (level.isClientSide) {
         if (eat(level, pos, state, player).consumesAction()) {
            return InteractionResult.SUCCESS;
         }

         if (itemstack.isEmpty()) {
            return InteractionResult.CONSUME;
         }
      }

      return eat(level, pos, state, player);
   }

   protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
      if (!player.canEat(false)) {
         return InteractionResult.PASS;
      } else {
         player.awardStat(Stats.EAT_CAKE_SLICE);
         player.getFoodData().eat(2, 0.1F);
         int i = state.getValue(BITES);
         level.gameEvent(player, GameEvent.EAT, pos);
         if (i < 6) {
            level.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
         } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
         }

         return InteractionResult.SUCCESS;
      }
   }

   /**
    * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately returns its solidified counterpart.
    * Note that this method should ideally consider only the specific direction passed in.
    */
   public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
      return facing == Direction.DOWN && !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
   }

   public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
      return level.getBlockState(pos.below()).isSolid();
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
      builder.add(BITES);
   }

   /**
    * Returns the analog signal this block emits. This is the signal a comparator can read from it.
    *
    * @deprecated call via {@link net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getAnalogOutputSignal} whenever possible. Implementing/overriding is fine.
    */
   public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
      return getOutputSignal(blockState.getValue(BITES));
   }

   public static int getOutputSignal(int eaten) {
      return (7 - eaten) * 2;
   }

   /**
    * @deprecated call via {@link net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible. Implementing/overriding is fine.
    */
   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
      return false;
   }
}
