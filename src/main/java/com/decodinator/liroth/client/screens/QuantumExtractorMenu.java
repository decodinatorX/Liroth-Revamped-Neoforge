package com.decodinator.liroth.client.screens;

import com.decodinator.liroth.core.registry.LirothMenuTypes;
import com.decodinator.liroth.core.registry.LirothRecipeTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;

public class QuantumExtractorMenu extends QuantumExtractorScreenHandler {
    public QuantumExtractorMenu(int containerId, Inventory playerInventory) {
        super(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU, LirothRecipeTypes.QUANTUM_EXTRACTING, containerId, playerInventory);
    }

    public QuantumExtractorMenu(int containerId, Inventory playerInventory, Container furnaceContainer, ContainerData furnaceData) {
        super(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU, LirothRecipeTypes.QUANTUM_EXTRACTING, containerId, playerInventory, furnaceContainer, furnaceData);
    }

    public QuantumExtractorMenu(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        super(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU, LirothRecipeTypes.QUANTUM_EXTRACTING, i, inventory);

    }
}
