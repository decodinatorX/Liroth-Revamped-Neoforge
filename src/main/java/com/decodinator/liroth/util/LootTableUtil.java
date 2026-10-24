package com.decodinator.liroth.util;

import com.decodinator.liroth.Liroth;
import org.betterx.wover.loot.api.LootTableManager;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;

public class LootTableUtil {
    public static final ResourceKey<LootTable> VILLAGE_LOOT = LootTableManager.createLootTableKey(Liroth.C, "chests/end_village_loot");
    public static final ResourceKey<LootTable> VILLAGE_TEMPLATE_LOOT = LootTableManager.createLootTableKey(Liroth.C, "chests/end_village_template_loot");
    public static final ResourceKey<LootTable> VILLAGE_BONUS_LOOT = LootTableManager.createLootTableKey(Liroth.C, "chests/end_village_bonus_loot");
    public static final ResourceKey<LootTable> COMMON = LootTableManager.createLootTableKey(Liroth.C, "chests/common");
    public static final ResourceKey<LootTable> BIOME_CHEST = LootTableManager.createLootTableKey(Liroth.C, "chests/biome");
    public static final ResourceKey<LootTable> FISHING_FISH = LootTableManager.createLootTableKey(Liroth.C, "gameplay/fishing/fish");
    public static final ResourceKey<LootTable> FISHING_TREASURE = LootTableManager.createLootTableKey(Liroth.C, "gameplay/fishing/treasure");
    public static final ResourceKey<LootTable> FISHING_JUNK = LootTableManager.createLootTableKey(Liroth.C, "gameplay/fishing/junk");

//    public static final ResourceKey<LootTable> EXAMPLE_BIOME = LootTableManager.createLootTableKey(Liroth.C, "chests/example_biome");
//    public static final ResourceKey<LootTable> EXAMPLE_BIOME_2 = LootTableManager.createLootTableKey(Liroth.C, "chests/example_biome_2");

    public static void init() {
        NeoForge.EVENT_BUS.addListener(LootTableUtil::onLootTableLoad);
    }

    private static void onLootTableLoad(LootTableLoadEvent event) {
        final ResourceLocation id = event.getName();
        final LootTable table = event.getTable();

        final LootItemCondition.Builder IN_END = LocationCheck.checkLocation(LocationPredicate.Builder
                .location()
                .setDimension(Level.END));

        if (BuiltInLootTables.END_CITY_TREASURE.equals(id)) {
            LootPool.Builder builder = LootPool.lootPool();
            builder.setRolls(ConstantValue.exactly(1));
            builder.when(LootItemRandomChanceCondition.randomChance(0.2f));
            builder.add(LootItem.lootTableItem(Items.GHAST_TEAR));
            table.addPool(builder.build());

            builder = LootPool.lootPool();
            builder.setRolls(UniformGenerator.between(0, 3));
          //  builder.add(LootItem.lootTableItem(LirothItems.EXAMPLE_ITEM));
            table.addPool(builder.build());

            table.addPool(LootPool
                    .lootPool()
                    .setRolls(UniformGenerator.between(2, 4))
                    .add(EmptyLootItem.emptyItem().setWeight(12))
            //        .add(LootItem.lootTableItem(LirothItems.EXAMPLE_ITEM).setWeight(3))
                    .build());
        } else if (BuiltInLootTables.FISHING.equals(id)) {
            table.addPool(LootPool.lootPool().when(IN_END).setRolls(ConstantValue.exactly(1.0F))
                    .add(NestedLootTable.lootTableReference(FISHING_FISH)
                            .setWeight(85)
                            .setQuality(-1))
                    .add(NestedLootTable.lootTableReference(FISHING_TREASURE)
                            .setWeight(5)
                            .setQuality(2))
                    .add(NestedLootTable.lootTableReference(FISHING_JUNK)
                            .setWeight(10)
                            .setQuality(-2)).build());
        }
    }

    public static ResourceKey<LootTable> getTable(Holder<Biome> biome) {
        ;
        if (biome.unwrapKey().isPresent()) {
         //   if (biome.is(LirothBiomes.EXAMPLE_BIOME.key)) {
         //       return EXAMPLE_BIOME;
         //   } else if (biome.is(LirothBiomes.EXAMPLE_BIOME_2.key)) {
         //       return EXAMPLE_BIOME_2;
         //   }
        }
        return COMMON;
    }

}