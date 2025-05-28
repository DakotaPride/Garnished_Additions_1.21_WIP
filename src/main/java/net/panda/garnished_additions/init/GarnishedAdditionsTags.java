package net.panda.garnished_additions.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.panda.garnished_additions.GarnishedAdditionsForgeMain;

public class GarnishedAdditionsTags {
    public static final TagKey<Block> CAN_PLACE_ETHEREAL_PLANT_ON = TagKey.create(Registries.BLOCK,
            GarnishedAdditionsForgeMain.asResource("can_place_ethereal_plant_on"));

    public static void load() {}
}
