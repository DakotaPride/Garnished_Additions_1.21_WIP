package net.panda.garnished_additions;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.Locale;

public class GarnishedAdditionsTags {
    public enum BlockTags {
        CAN_PLACE_LETHAL_LIANA_ON(),
        CAN_PLACE_HAZARDOUS_HYPHAE_ON(),
        CAN_PLACE_ETHEREAL_PLANT_ON(),


        ;

        public TagKey<Block> tagKey;

        BlockTags() {
            this.tagKey = TagKey.create(Registries.BLOCK, GarnishedAdditionsNeoForgeMain.asResource(this.name().toLowerCase(Locale.ROOT)));
        }

        public TagKey<Block> getTag() {
            return tagKey;
        }
    }
    public static void load() {}
}
