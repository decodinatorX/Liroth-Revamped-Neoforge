package com.decodinator.liroth.client.screens;

import com.decodinator.liroth.core.recipetypes.AbstractSplitterRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class LirothSplitterScreenHandler extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    private final RecipeType<? extends AbstractSplitterRecipe> recipeType;


    public LirothSplitterScreenHandler(MenuType<?> menuType, RecipeType<? extends AbstractSplitterRecipe> recipeType, int containerId, Inventory playerInventory) {
        this(menuType, recipeType, containerId, playerInventory, new SimpleContainer(5), new SimpleContainerData(4));
    }

    protected LirothSplitterScreenHandler(
            MenuType<?> menuType,
            RecipeType<? extends AbstractSplitterRecipe> recipeType,
            int containerId,
            Inventory playerInventory,
            Container container,
            ContainerData data
    ) {
        super(menuType, containerId);
        this.recipeType = recipeType;
        checkContainerSize(container, 5);
        checkContainerDataCount(data, 4);
        this.container = container;
        this.data = data;
        this.level = playerInventory.player.level();

        // Our Slots
        this.addSlot(new Slot(container, 0, 52, 16) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return container.canPlaceItem(0, stack);
            }
        });
        this.addSlot(new Slot(container, 1, 52, 52) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return container.canPlaceItem(1, stack);
            }
        });
        this.addSlot(new Slot(container, 2, 112, 8) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });
        this.addSlot(new Slot(container, 3, 112, 34) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });
        this.addSlot(new Slot(container, 4, 112, 60) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        if (invSlot < 0 || invSlot >= this.slots.size()) {
            return ItemStack.EMPTY;
        }

        Slot slot = this.slots.get(invSlot);
        if (!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack originalStack = slot.getItem();
        ItemStack movedStack = originalStack.copy();
        int machineSlots = this.container.getContainerSize();
        if (invSlot < machineSlots) {
            if (!this.moveItemStackTo(originalStack, machineSlots, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else {
            boolean movedToMachine;
            if (this.container.canPlaceItem(1, originalStack)) {
                movedToMachine = this.moveItemStackTo(originalStack, 1, 2, false);
            } else if (this.container.canPlaceItem(0, originalStack)) {
                movedToMachine = this.moveItemStackTo(originalStack, 0, 1, false);
            } else {
                movedToMachine = false;
            }
            if (!movedToMachine) {
                return ItemStack.EMPTY;
            }
        }

        if (originalStack.getCount() == movedStack.getCount()) {
            return ItemStack.EMPTY;
        }
        if (originalStack.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }
        slot.onTake(player, originalStack);
        return movedStack;
    }

    @OnlyIn(Dist.CLIENT)
    public int getCookProgress(int pixels) {
        int time = data.get(2);
        int timeTotal = data.get(3);
        return timeTotal != 0 && time != 0 ? time * pixels / timeTotal : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getFuelProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }
        return this.data.get(0) * 13 / i;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isBurning() {
        return this.data.get(0) > 0;
    }
}
