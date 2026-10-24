package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.core.recipetypes.QuantumRecipe;
import com.decodinator.liroth.core.registry.LirothBlocks;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

public class QuantumCategory extends AbstractQuantumCategory<QuantumRecipe> {
    public static final RecipeType<QuantumRecipe> TYPE = RecipeType.create(
            "liroth",
            "quantum_extracting",
            QuantumRecipe.class
    );

    public QuantumCategory(IGuiHelper guiHelper) {
        super(guiHelper, LirothBlocks.QUANTUM_EXTRACTOR, "gui.jei.category." + JEILirothConstants.QUANTUM_EXTRACTOR, 200);
    }

    @Override
    public RecipeType<QuantumRecipe> getRecipeType() {
        return TYPE;
    }
}
