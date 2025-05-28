package net.panda.garnished_additions.block;

import com.mojang.serialization.MapCodec;
import net.dakotapride.garnished.block.IDesolateSpread;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;
import net.panda.garnished_additions.init.GarnishedAdditionsTags;

public class EtherealBerryBushBlock extends BushBlock implements IDesolateSpread {
   public static final MapCodec<EtherealBerryBushBlock> CODEC = simpleCodec(EtherealBerryBushBlock::new);
   private static final float HURT_SPEED_THRESHOLD = 0.003F;
   public static final int MAX_AGE = 3;
   public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
   private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
   private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

   public EtherealBerryBushBlock(BlockBehaviour.Properties properties) {
      super(properties);
      this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
   }

   @Override
   protected MapCodec<? extends BushBlock> codec() {
      return CODEC;
   }

   protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
      return pState.is(GarnishedAdditionsTags.CAN_PLACE_ETHEREAL_PLANT_ON);
   }

   @Override
   public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
      return new ItemStack(GarnishedAdditionsItemsInit.ETHEREAL_BERRIES.get());
   }

   public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
      if (state.getValue(AGE) == 0) {
         return SAPLING_SHAPE;
      } else {
         return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, level, pos, context);
      }
   }

   /**
    * @return whether this block needs random ticking.
    */
   public boolean isRandomlyTicking(BlockState state) {
      return state.getValue(AGE) < 3;
   }

   /**
    * Performs a random tick on a block.
    */
   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
      int i = state.getValue(AGE);
      if (i < 3 && level.getRawBrightness(pos.above(), 0) >= 9 && net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, random.nextInt(5) == 0)) {
         BlockState blockstate = state.setValue(AGE, Integer.valueOf(i + 1));
         level.setBlock(pos, blockstate, 2);
         net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(level, pos, state);
         level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
      }

   }

   public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
      if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
         entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
         if (!level.isClientSide && state.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
            double d0 = Math.abs(entity.getX() - entity.xOld);
            double d1 = Math.abs(entity.getZ() - entity.zOld);
            if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
               entity.hurt(level.damageSources().sweetBerryBush(), 1.0F);
            }
         }

      }
   }
   @Override
   protected ItemInteractionResult useItemOn(
           ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
   ) {
      int i = state.getValue(AGE);
      boolean flag = i == 3;
      return !flag && stack.is(Items.BONE_MEAL)
              ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION
              : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
   }

   @Override
   protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
      int i = state.getValue(AGE);
      boolean flag = i == 3;
      if (i > 1) {
         int j = 1 + level.random.nextInt(2);
         popResource(level, pos, new ItemStack(GarnishedAdditionsItemsInit.ETHEREAL_BERRIES.get(), j + (flag ? 1 : 0)));
         level.playSound(
                 null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F
         );
         BlockState blockstate = state.setValue(AGE, Integer.valueOf(1));
         level.setBlock(pos, blockstate, 2);
         level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
         return InteractionResult.sidedSuccess(level.isClientSide);
      } else {
         return super.useWithoutItem(state, level, pos, player, hitResult);
      }
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
      builder.add(AGE);
   }

   @Override
   public boolean isValidTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
      return blockState.getValue(AGE) < 3;
   }

   @Override
   public boolean isSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      return true;
   }

   @Override
   public void performSpread(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
      int i = Math.min(3, blockState.getValue(AGE) + 1);
      serverLevel.setBlock(blockPos, blockState.setValue(AGE, Integer.valueOf(i)), 2);
   }

   @Override
   public SimpleParticleType getParticle() {
      return ParticleTypes.PORTAL;
   }
}
