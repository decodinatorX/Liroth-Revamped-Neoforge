package com.decodinator.liroth.client.screens;

import com.decodinator.liroth.core.registry.LirothMenuTypes;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class LirothSplitterMenu extends LirothSplitterScreenHandler {
    public LirothSplitterMenu(int containerId, Inventory playerInventory) {
        super(LirothMenuTypes.LIROTH_SPLITTER_MENU, LirothRecipeTypes.LIROTH_SPLITTING, containerId, playerInventory);
    }

    public LirothSplitterMenu(int containerId, Inventory playerInventory, Container furnaceContainer, ContainerData furnaceData) {
        super(LirothMenuTypes.LIROTH_SPLITTER_MENU, LirothRecipeTypes.LIROTH_SPLITTING, containerId, playerInventory, furnaceContainer, furnaceData);
    }

    public LirothSplitterMenu(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        super(LirothMenuTypes.LIROTH_SPLITTER_MENU, LirothRecipeTypes.LIROTH_SPLITTING, i, inventory);

    }
}
