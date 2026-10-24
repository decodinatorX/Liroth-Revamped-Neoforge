package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.core.recipetypes.SplitterRecipe;
import com.decodinator.liroth.core.registry.LirothBlocks;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import org.jetbrains.annotations.NotNull;

public class SplitterCategory extends AbstractSplitterCategory<SplitterRecipe> {
    public static final RecipeType<SplitterRecipe> TYPE = RecipeType.create(
            "liroth",
            "liroth_splitting",
            SplitterRecipe.class
    );

    public SplitterCategory(IGuiHelper guiHelper) {
        super(guiHelper, LirothBlocks.LIROTH_SPLITTER, "gui.jei.category." + JEILirothConstants.GEM_SPLITTER, 200);
    }

    @Override
    public @NotNull RecipeType<SplitterRecipe> getRecipeType() {
        return TYPE;
    }
}
