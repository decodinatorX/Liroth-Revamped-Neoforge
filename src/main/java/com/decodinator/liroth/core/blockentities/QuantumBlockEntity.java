package com.decodinator.liroth.core.blockentities;

import com.decodinator.liroth.core.recipetypes.AbstractQuantumRecipe;
import com.decodinator.liroth.core.recipetypes.AbstractSplitterRecipe;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class QuantumBlockEntity extends QuantumExtractorBlockEntity {

    public QuantumBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
        super(p_155545_, p_155546_, (RecipeType<? extends AbstractQuantumRecipe>) LirothRecipeTypes.QUANTUM_EXTRACTING);
    }
}