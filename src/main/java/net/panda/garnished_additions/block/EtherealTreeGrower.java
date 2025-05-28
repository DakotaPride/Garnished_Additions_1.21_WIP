package net.panda.garnished_additions.block;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.panda.garnished_additions.init.GarnishedAdditionsFeatures;

import java.util.Optional;

public class EtherealTreeGrower {
    public static final TreeGrower ETHEREAL = new TreeGrower(
            "garnished_additions:ethereal",
            Optional.empty(),
            Optional.of(GarnishedAdditionsFeatures.ETHEREAL_TREE_CONFIGURED),
            Optional.of(GarnishedAdditionsFeatures.ETHEREAL_TREE_CONFIGURED)
    );
}
