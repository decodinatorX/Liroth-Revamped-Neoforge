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
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;

@JeiPlugin
public class LirothJEI implements IModPlugin {
    public final static Identifier PLUGIN_ID = Identifier.fromNamespaceAndPath(Liroth.MOD_ID, "jei_plugin");
    private static List<SplitterRecipe> splitterRecipes = List.of();
    private static List<QuantumRecipe> quantumRecipes = List.of();

    public LirothJEI() {
        NeoForge.EVENT_BUS.addListener(this::onRecipesReceived);
    }

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
        registration.addRecipes(SplitterCategory.TYPE, splitterRecipes);
        registration.addRecipes(QuantumCategory.TYPE, quantumRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addCraftingStation(QuantumCategory.TYPE, LirothBlocks.QUANTUM_EXTRACTOR);
        registration.addCraftingStation(SplitterCategory.TYPE, LirothBlocks.LIROTH_SPLITTER);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        IModPlugin.super.registerRecipeTransferHandlers(registration);
    }

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }

    private void onRecipesReceived(RecipesReceivedEvent event) {
        RecipeMap recipeMap = event.getRecipeMap();
        splitterRecipes = recipesOfType(recipeMap, LirothRecipeTypes.LIROTH_SPLITTING, SplitterRecipe.class);
        quantumRecipes = recipesOfType(recipeMap, LirothRecipeTypes.QUANTUM_EXTRACTING, QuantumRecipe.class);
    }

    private static <T> List<T> recipesOfType(RecipeMap recipeMap, RecipeType<?> type, Class<T> recipeClass) {
        return recipeMap.values().stream().filter(holder -> holder.value().getType() == type).map(RecipeHolder::value).filter(recipeClass::isInstance).map(recipeClass::cast).toList();
    }
}
