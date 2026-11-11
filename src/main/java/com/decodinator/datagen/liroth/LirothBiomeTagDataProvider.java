package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

public class LirothBiomeTagDataProvider extends WoverTagProvider.ForBiomes {
    public LirothBiomeTagDataProvider(ModCore core) {
        super(core);
    }

    @Override
    public void prepareTags(TagBootstrapContext<Biome> context) {
        addBiomes(context,
                biome("liroth_biome"),
                biome("spiced_desert"),
                biome("tallpier"),
                biome("damnation_biome"),
                biome("jantiros_biome"),
                biome("japz_lush_caves"),
                biome("petrified_desert"),
                biome("fungal_caverns"),
                biome("jalsphire_plains"),
                biome("devastated_plains"),
                biome("vile_sea")
        );
    }

    @SafeVarargs
    private static void addBiomes(TagBootstrapContext<Biome> context, ResourceKey<Biome>... biomes) {
        context.addOptional(LirothTags.LIROTH_BIOMES, biomes);
    }

    private static ResourceKey<Biome> biome(String name) {
        return ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Liroth.MOD_ID, name));
    }
}
