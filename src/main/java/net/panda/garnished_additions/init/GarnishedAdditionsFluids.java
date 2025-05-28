package net.panda.garnished_additions.init;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.dakotapride.garnished.registry.Fluids;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.panda.garnished_additions.GarnishedAdditionsNeoForgeMain;

public class GarnishedAdditionsFluids implements Fluids {
    public static final FluidEntry<BaseFlowingFluid.Flowing> ETHEREAL_SAP =
            standardFluid("ethereal_sap", GarnishedFluids.SolidRenderedPlaceableFluidType.create(0xD4DAF3,
                            () -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(BaseFlowingFluid.Source::new)
                    .bucket()
                    .tag(AllTags.commonItemTag("buckets/ethereal_sap"))
                    .build()
                    .register();
    public static final FluidEntry<BaseFlowingFluid.Flowing> ETHEREAL_SYRUP =
            standardFluid("ethereal_syrup", GarnishedFluids.SolidRenderedPlaceableFluidType.create(0x8E3DF6,
                            () -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(BaseFlowingFluid.Source::new)
                    .bucket()
                    .tag(AllTags.commonItemTag("buckets/ethereal_syrup"))
                    .build()
                    .register();

    private static ResourceLocation createLocation(String fluid, boolean isFlowing) {
        String getMotion;
        if (isFlowing) {
            getMotion = "_flow";
        } else {
            getMotion = "_still";
        }

        return GarnishedAdditionsNeoForgeMain.asResource("fluid/" + fluid + getMotion);
    }

    public static FluidBuilder<BaseFlowingFluid.Flowing, CreateRegistrate> standardFluid(String name, FluidBuilder.FluidTypeFactory typeFactory) {
        return GarnishedAdditionsNeoForgeMain.REGISTRATE.fluid(name, createLocation(name, false), createLocation(name, true), typeFactory);
    }

    public static void register() {}

}
