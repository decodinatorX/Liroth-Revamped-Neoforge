package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.recipetypes.QuantumRecipe;
import com.decodinator.liroth.core.recipetypes.SplitterRecipe;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

@JeiPlugin
public class LirothJEI implements IModPlugin {
    public final static ResourceLocation PLUGIN_ID = ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "jei_plugin");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IModPlugin.super.registerCategories(registration);

        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        registration.addRecipeCategories(new QuantumCategory(guiHelper));
        registration.addRecipeCategories(new SplitterCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IModPlugin.super.registerRecipes(registration);
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }

        List<SplitterRecipe> recipes = level.getRecipeManager()
                .getAllRecipesFor(LirothRecipeTypes.LIROTH_SPLITTING)
                .stream()
                .map(RecipeHolder::value)
                .filter(SplitterRecipe.class::isInstance)
                .map(SplitterRecipe.class::cast)
                .toList();
        registration.addRecipes(SplitterCategory.TYPE, recipes);

        List<QuantumRecipe> quantumRecipes = level.getRecipeManager()
                .getAllRecipesFor(LirothRecipeTypes.QUANTUM_EXTRACTING)
                .stream()
                .map(RecipeHolder::value)
                .filter(QuantumRecipe.class::isInstance)
                .map(QuantumRecipe.class::cast)
                .toList();
        registration.addRecipes(QuantumCategory.TYPE, quantumRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(
                new ItemStack(LirothBlocks.QUANTUM_EXTRACTOR),
                QuantumCategory.TYPE
        );
        registration.addRecipeCatalyst(
                new ItemStack(LirothBlocks.LIROTH_SPLITTER),
                SplitterCategory.TYPE
        );
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        IModPlugin.super.registerRecipeTransferHandlers(registration);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }
}
