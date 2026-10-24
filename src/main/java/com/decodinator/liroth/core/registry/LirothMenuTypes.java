package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.client.screens.LirothSplitterMenu;
import com.decodinator.liroth.client.screens.LirothSplitterScreenHandler;
import com.decodinator.liroth.client.screens.QuantumExtractorMenu;
import com.decodinator.liroth.client.screens.QuantumExtractorScreenHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothMenuTypes {

    public static MenuType<LirothSplitterScreenHandler> LIROTH_SPLITTER_MENU;
    public static MenuType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_MENU;

    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.MENU)) return;
        event.register(Registries.MENU, helper -> {
            LIROTH_SPLITTER_MENU = IMenuTypeExtension.create(LirothSplitterMenu::new);
            helper.register(Liroth.C.mk("liroth_splitter"), LIROTH_SPLITTER_MENU);
            QUANTUM_EXTRACTOR_MENU = IMenuTypeExtension.create(QuantumExtractorMenu::new);
            helper.register(Liroth.C.mk("quantum_extractor"), QUANTUM_EXTRACTOR_MENU);
        });
    }
}
