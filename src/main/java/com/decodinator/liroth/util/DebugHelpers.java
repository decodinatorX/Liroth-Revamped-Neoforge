package com.decodinator.liroth.util;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothItems;
import com.decodinator.liroth.core.world.structures.village.VillagePools;
import org.betterx.bclib.items.DebugDataItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class DebugHelpers {
    private static boolean didCreateDebugItems = false;

    public static void generateDebugItems() {
        if (didCreateDebugItems) return;
        didCreateDebugItems = true;
        Liroth.LOGGER.warn("Generating Debug Helpers");

        LirothItems.registerItem(
                "debug/village_loot",
                DebugDataItem.forLootTable(LootTableUtil.VILLAGE_LOOT, Items.IRON_INGOT)
        );

        LirothItems.registerItem(
                "debug/village_bonus",
                DebugDataItem.forLootTable(LootTableUtil.VILLAGE_BONUS_LOOT, Items.DIAMOND)
        );

        LirothItems.registerItem(
                "debug/village_template",
                DebugDataItem.forLootTable(LootTableUtil.VILLAGE_TEMPLATE_LOOT, Items.GOLD_INGOT)
        );

        LirothItems.registerItem(
                "debug/biome_loot",
                DebugDataItem.forLootTable(LootTableUtil.BIOME_CHEST, Items.OAK_LEAVES)
        );

        LirothItems.registerItem(
                "debug/jigsaw_entrance",
                DebugDataItem.forHouseEntranceJigSaw(Liroth.MOD_ID, null, Items.OAK_DOOR)
        );

        LirothItems.registerItem(
                "debug/jigsaw_street_entrance",
                DebugDataItem.forHouseEntranceJigSaw(Liroth.MOD_ID, VillagePools.HOUSES_KEY.key, Items.IRON_DOOR)
        );

        LirothItems.registerItem(
                "debug/jigsaw_street",
                DebugDataItem.forSteetJigSaw(
                        Liroth.MOD_ID,
                        VillagePools.STREET_KEY.key,
                        Items.ENDER_PEARL
                )
        );

        LirothItems.registerItem(
                "debug/jigsaw_street_deco",
                DebugDataItem.forStreetDecorationJigSaw(
                        Liroth.MOD_ID,
                        VillagePools.STREET_DECO_KEY.key,
                        Items.ENDER_EYE
                )
        );
        LirothItems.registerItem(
                "debug/jigsaw_street_big_deco",
                DebugDataItem.forDecorationJigSaw(
                        Liroth.MOD_ID,
                        VillagePools.DECORATIONS_KEY.key,
                        Items.SLIME_BALL
                )
        );

        LirothItems.registerItem(
                "debug/jigsaw_big_deco",
                DebugDataItem.forDecorationJigSaw(
                        Liroth.MOD_ID,
                        null,
                        Items.TURTLE_HELMET
                )
        );

        LirothItems.registerItem(
                "debug/jigsaw_deco",
                DebugDataItem.forStreetDecorationJigSaw(
                        Liroth.MOD_ID,
                        null,
                        Items.LANTERN
                )
        );

        LirothItems.registerItem(
                "debug/fill_base_void",
                new DebugDataItem((player, entity, useOnContext) -> DebugDataItem.fillStructureEntityBounds(
                        useOnContext, entity,
                        state -> state.is(Blocks.END_STONE),
                        Blocks.STRUCTURE_VOID.defaultBlockState(),
                        false
                ), false, BuiltInRegistries.ITEM.getKey(Items.WATER_BUCKET))
        );

        Item item = LirothItems.registerItem(
                "debug/fill_air",
                new DebugDataItem((player, entity, useOnContext) -> DebugDataItem.fillStructureEntityBounds(
                        useOnContext, entity,
                        state -> state.isAir() || state.is(Blocks.STRUCTURE_VOID),
                        Blocks.STRUCTURE_VOID.defaultBlockState(),
                        true
                ), false, BuiltInRegistries.ITEM.getKey(Items.BUCKET))
        );
    }

}