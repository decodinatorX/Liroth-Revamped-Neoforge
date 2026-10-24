package com.decodinator.datagen.liroth.recipes;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothBlocks;
import org.betterx.bclib.complexmaterials.ComplexMaterial;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.provider.WoverRecipeProvider;
import org.betterx.wover.recipe.api.CraftingRecipeBuilder;
import org.betterx.wover.recipe.api.RecipeBuilder;
import org.betterx.wover.tag.api.predefined.CommonItemTags;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class LirothCraftingRecipesProvider extends WoverRecipeProvider {
    public LirothCraftingRecipesProvider(ModCore modCore) {
        super(modCore, "Liroth - Crafting Recipes");
    }

    @Override
    protected void bootstrap(HolderLookup.Provider provider, RecipeOutput context) {
        ComplexMaterial.provideAllRecipes(context, Liroth.C);
    }

    private ItemStack waterPotion() {
        return stackFor(Items.POTION, Potions.WATER);
    }


    private static ItemStack stackFor(ItemLike content, Holder<Potion> potion) {
        final var stack = new ItemStack(content);
        stack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
        return stack;
    }
}