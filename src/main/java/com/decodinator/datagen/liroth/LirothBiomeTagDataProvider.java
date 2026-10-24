package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

public class LirothBiomeTagDataProvider extends WoverTagProvider.ForBiomes {
    public LirothBiomeTagDataProvider(ModCore core) {
        super(core);
    }

    @Override
    public void prepareTags(TagBootstrapContext<Biome> context) {
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "liroth_biome")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "spiced_desert")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "tallpier")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "damnation_biome")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "jantiros_biome")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "japz_lush_caves")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "petrified_desert")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_caverns")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "jalsphire_plains")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "devastated_plains")));
        context.add(LirothTags.LIROTH_BIOMES, ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "vile_sea")));
    }
}
