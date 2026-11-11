package com.decodinator.liroth.core.recipetypes;

import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import com.decodinator.liroth.util.RandomizedOutputIngredient;
import com.decodinator.liroth.util.RandomizedOutputIngredient2;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.Identifier;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

public class SplitterRecipe extends AbstractSplitterRecipe {
    public SplitterRecipe(Identifier p_249157_, String p_250200_, Ingredient p_250340_, ItemStackTemplate p_250306_, RandomizedOutputIngredient bonus, RandomizedOutputIngredient2 bonus2, float p_249577_, int p_250030_) {
        super(LirothRecipeTypes.LIROTH_SPLITTING, p_249157_, p_250200_, p_250340_, p_250306_, bonus, bonus2, p_249577_, p_250030_);
    }

    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.create();
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return this.ingredient.test((recipeInput.getItem(0)));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput) {
        return this.result.create();
    }

}