package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.data.tags.FluidTagsProvider;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverDataProvider;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class LirothFluidTagDataProvider implements WoverDataProvider<FluidTagsProvider> {
    public LirothFluidTagDataProvider(ModCore core) {
    }

    @Override
    public FluidTagsProvider getProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        return new FluidTagsProvider(output, registriesFuture) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {
                ResourceKey<Fluid> liroth_fluid = ResourceKey.create(Registries.FLUID, Liroth.C.mk("liroth_fluid"));
                ResourceKey<Fluid> molten_spinerios = ResourceKey.create(Registries.FLUID, Liroth.C.mk("molten_spinerios"));
                ResourceKey<Fluid> flowing_liroth_fluid = ResourceKey.create(Registries.FLUID, Liroth.C.mk("flowing_liroth_fluid"));
                ResourceKey<Fluid> flowing_molten_spinerios = ResourceKey.create(Registries.FLUID, Liroth.C.mk("flowing_molten_spinerios"));
                tag(LirothTags.LIROTH_FLUIDS).add(liroth_fluid).add(flowing_liroth_fluid);
                tag(LirothTags.LIROTH_FLUIDS).add(molten_spinerios).add(flowing_molten_spinerios);
                tag(FluidTags.WATER).add(liroth_fluid).add(flowing_liroth_fluid);
                tag(FluidTags.WATER).add(molten_spinerios).add(flowing_molten_spinerios);
            }
        };
    }
}
