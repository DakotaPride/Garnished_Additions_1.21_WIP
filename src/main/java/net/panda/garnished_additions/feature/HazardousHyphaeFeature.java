package net.panda.garnished_additions.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

public class HazardousHyphaeFeature extends Feature<NoneFeatureConfiguration> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public HazardousHyphaeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     * @param ctx A context object with a reference to the level and the position the feature is being placed at
     */
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel worldgenlevel = ctx.level();
        BlockPos blockpos = ctx.origin();
        RandomSource randomsource = ctx.random();
        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if (!blockstate.is(Blocks.SOUL_SAND) && !blockstate.is(Blocks.SOUL_SOIL)) {
                return false;
            } else {
                this.placeRoofHazardousHyphae(worldgenlevel, randomsource, blockpos);
                return true;
            }
        }
    }

    private void placeRoofHazardousHyphae(LevelAccessor level, RandomSource random, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int i = 0; i < 100; i++) {
            blockpos$mutableblockpos.setWithOffset(
                    pos,
                    random.nextInt(8) - random.nextInt(8),
                    random.nextInt(2) - random.nextInt(7),
                    random.nextInt(8) - random.nextInt(8)
            );
            if (level.isEmptyBlock(blockpos$mutableblockpos)) {
                BlockState blockstate = level.getBlockState(blockpos$mutableblockpos.above());
                if (blockstate.is(Blocks.SOUL_SAND) || blockstate.is(Blocks.SOUL_SOIL)) {
                    int j = Mth.nextInt(random, 1, 8);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    placeHazardousHyphaeColumn(level, random, blockpos$mutableblockpos, j, 17, 25);
                }
            }
        }

    }

    public static void placeHazardousHyphaeColumn(LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int height, int minAge, int maxAge) {
        for (int i = 0; i <= height; i++) {
            if (level.isEmptyBlock(pos)) {
                if (i == height || !level.isEmptyBlock(pos.below())) {
                    level.setBlock(
                            pos,
                            GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE
                                    .get().defaultBlockState()
                                    .setValue(GrowingPlantHeadBlock.AGE, Integer.valueOf(Mth.nextInt(random, minAge, maxAge))),
                            2
                    );
                    break;
                }

                level.setBlock(pos, GarnishedAdditionsBlocksInit.HAZARDOUS_HYPHAE_PLANT.get().defaultBlockState(), 2);
            }

            pos.move(Direction.DOWN);
        }

    }
}