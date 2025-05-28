package net.panda.garnished_additions.init;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.panda.garnished_additions.GarnishedAdditionsNeoForgeMain;
import net.panda.garnished_additions.block.*;

public class GarnishedAdditionsBlocksInit {
    private static final CreateRegistrate REGISTRATE = GarnishedAdditionsNeoForgeMain.REGISTRATE;

    public static final BlockEntry<?> NUTIUM_BLOCK = REGISTRATE.block("nutium_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.NETHER))
            .simpleItem()
            .register();
    public static final BlockEntry<?> ETHEREAL_WOOD = REGISTRATE.block("ethereal_wood", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_LOG = REGISTRATE.block("ethereal_log",
            properties -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_BLACK))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_PLANKS = REGISTRATE.block("ethereal_planks", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_LEAVES = REGISTRATE.block("ethereal_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_STAIRS = REGISTRATE.block("ethereal_stairs", EtherealStairsBlock::new)
            .initialProperties(() -> Blocks.OAK_STAIRS)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_SLAB = REGISTRATE.block("ethereal_slab", SlabBlock::new)
            .initialProperties(() -> Blocks.OAK_SLAB)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_FENCE = REGISTRATE.block("ethereal_fence", FenceBlock::new)
            .initialProperties(() -> Blocks.OAK_FENCE)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_FENCE_GATE = REGISTRATE.block("ethereal_fence_gate", EtherealFenceGateBlock::new)
            .initialProperties(() -> Blocks.OAK_FENCE_GATE)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_PRESSURE_PLATE = REGISTRATE.block("ethereal_pressure_plate", EtherealPressurePlateBlock::new)
            .initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_BUTTON = REGISTRATE.block("ethereal_button",
            properties -> woodenButton(BlockSetType.OAK))
            .initialProperties(() -> Blocks.OAK_BUTTON)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> STRIPPED_ETHEREAL_WOOD = REGISTRATE.block("stripped_ethereal_wood", RotatedPillarBlock::new)
            .simpleItem().register();
    public static final BlockEntry<?> STRIPPED_ETHEREAL_LOG = REGISTRATE.block("stripped_ethereal_log",
            properties -> log(MapColor.COLOR_PURPLE, MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_DOOR = REGISTRATE.block("ethereal_door", EtherealDoorBlock::new)
            .initialProperties(() -> Blocks.OAK_DOOR)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_TRAPDOOR = REGISTRATE.block("ethereal_trapdoor", EtherealTrapdoorBlock::new)
            .initialProperties(() -> Blocks.OAK_TRAPDOOR)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .simpleItem().register();
    public static final BlockEntry<?> ROOTED_END_STONE = REGISTRATE.block("rooted_end_stone", RootedEndStoneBlock::new)
            .initialProperties(() -> Blocks.END_STONE)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_CAKE = REGISTRATE.block("ethereal_cake", EtherealCakeBlock::new)
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_GROWTH = REGISTRATE.block("ethereal_growth", EtherealGrowthBlock::new)
            .simpleItem().register();
    public static final BlockEntry<?> ETHEREAL_BERRY_BUSH = REGISTRATE.block("ethereal_berry_bush", EtherealBerryBushBlock::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE).noOcclusion().noCollission()).register();
    public static final BlockEntry<?> LETHAL_LIANA = REGISTRATE.block("lethal_liana", LethalLianaBlock::new)
            .simpleItem().register();
    public static final BlockEntry<?> LETHAL_LIANA_PLANT = REGISTRATE.block("lethal_liana_plant", LethalLianaPlantBlock::new).register();
    public static final BlockEntry<?> HAZARDOUS_HYPHAE = REGISTRATE.block("hazardous_hyphae", HazardousHyphaeBlock::new)
            .simpleItem().register();
    public static final BlockEntry<?> HAZARDOUS_HYPHAE_PLANT = REGISTRATE.block("hazardous_hyphae_plant", HazardousHyphaePlantBlock::new).register();
    public static final BlockEntry<?> STARDUST_BLOCK = REGISTRATE.block("stardust_block", StardustBlock::new)
            .simpleItem().register();

   private static RotatedPillarBlock log(MapColor topMapColor, MapColor sideMapColor) {
      return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((state) ->
              state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
              .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
   }

   private static ButtonBlock woodenButton(BlockSetType setType, FeatureFlag... requiredFeatures) {
      BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
      if (requiredFeatures.length > 0) {
         blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(requiredFeatures);
      }

      return new ButtonBlock(setType, 30, blockbehaviour$properties);
   }

    public static void register() {}
}
