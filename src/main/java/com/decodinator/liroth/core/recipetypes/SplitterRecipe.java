package com.decodinator.liroth.core.recipetypes;

import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import com.decodinator.liroth.util.RandomizedOutputIngredient;
import com.decodinator.liroth.util.RandomizedOutputIngredient2;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

public class SplitterRecipe extends AbstractSplitterRecipe {
    public SplitterRecipe(ResourceLocation p_249157_, String p_250200_, Ingredient p_250340_, ItemStack p_250306_, RandomizedOutputIngredient bonus, RandomizedOutputIngredient2 bonus2, float p_249577_, int p_250030_) {
        super(LirothRecipeTypes.LIROTH_SPLITTING, p_249157_, p_250200_, p_250340_, p_250306_, bonus, bonus2, p_249577_, p_250030_);
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.copy();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return this.ingredient.test((recipeInput.getItem(0)));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(LirothBlocks.LIROTH_SPLITTER);
    }

    @Override
    public ItemStack getItem(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}