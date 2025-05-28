package net.panda.garnished_additions.compat.jei;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.ConversionRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.panda.garnished_additions.GarnishedAdditionsNeoForgeMain;
import net.panda.garnished_additions.init.GarnishedAdditionsItemsInit;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.simibubi.create.compat.jei.category.MysteriousItemConversionCategory.RECIPES;

@JeiPlugin
@SuppressWarnings({"unused", "inline", "all"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GarnishedAdditionsJEI implements IModPlugin {

    private static final ResourceLocation ID = GarnishedAdditionsNeoForgeMain.asResource("jei_plugin");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        RECIPES.add(ConversionRecipe.create(GarnishedAdditionsItemsInit.CHROMATIC_COMPOUND.asStack(), AllItems.SHADOW_STEEL.asStack()));
        RECIPES.add(ConversionRecipe.create(GarnishedAdditionsItemsInit.CHROMATIC_COMPOUND.asStack(), AllItems.REFINED_RADIANCE.asStack()));
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
