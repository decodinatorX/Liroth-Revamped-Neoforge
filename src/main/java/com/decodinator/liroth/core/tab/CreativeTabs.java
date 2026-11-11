package com.decodinator.liroth.core.tab;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;

import net.neoforged.neoforge.registries.RegisterEvent;

public class CreativeTabs {
    private static boolean registered;

    public static void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.CREATIVE_MODE_TAB)) return;
        if (registered) return;
        registered = true;
        org.betterx.wover.tabs.api.CreativeTabs
                .start(Liroth.C)
                .createTab("blocks")
                .setIcon(LirothBlocks.LIROTH_GEM_BLOCK)
                .setPredicate(item -> item == LirothItems.LIROTHIAN_PETROLEUM_BLOCK
                        || item instanceof BlockItem blockItem
                        && !LirothBlocks.PLANT_BLOCKS.contains(blockItem.getBlock())
                        && item != LirothItems.DAMNATION_FUNGAL_CLUSTER
                        && item != LirothItems.DAMNATION_FUNGUS)
                .buildAndAdd()
                .createTab("plants")
                .setIcon(LirothBlocks.LIROTH_ROSE)
                .setPredicate(item -> item instanceof BlockItem blockItem
                        && (LirothBlocks.PLANT_BLOCKS.contains(blockItem.getBlock())
                        || item == LirothItems.DAMNATION_FUNGAL_CLUSTER
                        || item == LirothItems.DAMNATION_FUNGUS))
                .buildAndAdd()
                .createTab("items")
                .setIcon(LirothBlocks.LIROTH_GEM.ingot)
                .setPredicate(item -> !(item instanceof BlockItem)
                        && !LirothItems.EQUIPMENT.contains(item)
                        && !LirothItems.ENTITIES.contains(item))
                .buildAndAdd()
                .createTab("combat")
                .setIcon(LirothBlocks.LIROTH_GEM.sword)
                .setPredicate(LirothItems.EQUIPMENT::contains)
                .buildAndAdd()
                .createTab("entities")
                .setIcon(LirothItems.FUNGAL_FIEND_SPAWN_EGG)
                .setPredicate(LirothItems.ENTITIES::contains)
                .buildAndAdd()
                .processRegistries()
                .registerAllTabs();

    }

    public static void register() {
    }
}
