package com.decodinator.liroth.core.recipetypes;

import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import com.decodinator.liroth.util.RandomizedOutputIngredient;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

public class QuantumRecipe extends AbstractQuantumRecipe {
    public QuantumRecipe(String p_250200_, Ingredient p_250340_, ItemStackTemplate p_250306_, RandomizedOutputIngredient bonus, float p_249577_, int p_250030_) {
        super(LirothRecipeTypes.QUANTUM_EXTRACTING, p_250200_, p_250340_, p_250306_, bonus, p_249577_, p_250030_);
    }

    @Override
    public ItemStack assemble(RecipeInput p_44001_) {
        return this.result.create();
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return recipeInput.size() > 0 && this.ingredient.test(recipeInput.getItem(0));
    }

    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.create();
    }

}