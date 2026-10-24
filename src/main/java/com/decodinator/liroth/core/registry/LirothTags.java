package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import net.minecraft.tags.TagKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import org.betterx.wover.tag.api.TagManager;

public class LirothTags {

    public static final TagKey<Item> TORCHES = TagManager.ITEMS.makeTag(Liroth.C, "torches");
    public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagManager.BLOCKS.makeTag(Liroth.C, "dirt_ore_replaceables");
    public static final TagKey<Block> LIROTH_FARMLANDS = TagManager.BLOCKS.makeTag(Liroth.C, "liroth_farmlands");
    public static final TagKey<Biome> LIROTH_BIOMES = TagManager.BIOMES.makeTag(Liroth.C, "liroth_biomes");
    public static final TagKey<Fluid> LIROTH_FLUIDS = TagKey.create(Registries.FLUID, Liroth.C.mk("liroth_fluids"));

    public static void register(){}
}
