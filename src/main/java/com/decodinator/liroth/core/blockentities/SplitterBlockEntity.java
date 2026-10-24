package com.decodinator.liroth.core.blockentities;

import com.decodinator.liroth.core.recipetypes.AbstractSplitterRecipe;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

public class SplitterBlockEntity extends LirothSplitterBlockEntity {

    public SplitterBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
        super(p_155545_, p_155546_, (RecipeType<? extends AbstractSplitterRecipe>) LirothRecipeTypes.LIROTH_SPLITTING);
    }
}