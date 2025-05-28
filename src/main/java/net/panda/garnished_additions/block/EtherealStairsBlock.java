package net.panda.garnished_additions.block;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.panda.garnished_additions.init.GarnishedAdditionsBlocksInit;

import java.util.function.Supplier;

public class EtherealStairsBlock extends StairBlock {
    public EtherealStairsBlock(Properties properties) {
        super(GarnishedAdditionsBlocksInit.ETHEREAL_PLANKS.getDefaultState(), properties);
    }
}
