package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.core.blockentities.QuantumExtractorBlockEntity;
import com.decodinator.liroth.core.recipetypes.AbstractQuantumRecipe;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractQuantumCategory<T extends AbstractQuantumRecipe> extends FurnaceVariantCategory<T> {
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    private final IDrawable background;
    private final IDrawable icon;
    private final Component title;
    private final int regularCookTime;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public AbstractQuantumCategory(IGuiHelper guiHelper, Block icon, String translationKey, int regularCookTime) {
        super(guiHelper);
        this.staticFlame = guiHelper.createDrawable(JEILirothConstants.RECIPE_GUI_LIROTH_MOD, 79, 184, 14, 14);
        this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        title = Component.translatable(LirothBlocks.QUANTUM_EXTRACTOR.getDescriptionId());
        this.background = guiHelper.createDrawable(JEILirothConstants.RECIPE_GUI_LIROTH_MOD, 0, 198, 79, 54);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(LirothBlocks.QUANTUM_EXTRACTOR));
        this.regularCookTime = regularCookTime;
        I18n.get("gui.jei.category." + JEILirothConstants.QUANTUM_EXTRACTOR);
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public @NotNull IDrawableAnimated load(@NotNull Integer cookTime) {
                        return guiHelper.drawableBuilder(JEILirothConstants.RECIPE_GUI_VANILLA, 82, 128, 24, 17)
                                .buildAnimated(QuantumExtractorBlockEntity.totalTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });	}

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return this.background.getWidth();
    }

    @Override
    public int getHeight() {
        return this.background.getHeight();
    }

    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }

    @Override
    public @NotNull Component getTitle() {
        return title;
    }

    protected IDrawableAnimated getArrow(AbstractQuantumRecipe recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    protected static final int inputSlot_0 = 0;
    protected static final int inputSlot_1 = 1;
    protected static final int outputSlot_0 = 2;
    protected static final int outputSlot_1 = 3;

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AbstractQuantumRecipe recipe, @NotNull IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.at(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 37).addItemStack(Blocks.REDSTONE_BLOCK.asItem().getDefaultInstance());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 5).addItemStack(recipe.getResultItem());
        if (!recipe.bonus.bonus.isEmpty()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 33).addItemStack(recipe.bonus.bonus);
        }
    }
}
