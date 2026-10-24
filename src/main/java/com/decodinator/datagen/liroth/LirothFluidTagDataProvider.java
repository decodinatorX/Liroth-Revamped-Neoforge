package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothFluids;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.data.tags.FluidTagsProvider;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverDataProvider;

import java.util.concurrent.CompletableFuture;

public class LirothFluidTagDataProvider implements WoverDataProvider<FluidTagsProvider> {
    public LirothFluidTagDataProvider(ModCore core) {
    }

    @Override
    public FluidTagsProvider getProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture,
            ExistingFileHelper existingFileHelper
    ) {
        return new FluidTagsProvider(output, registriesFuture) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {
                tag(LirothTags.LIROTH_FLUIDS)
                        .add(LirothFluids.LIROTH_FLUID)
                        .add(LirothFluids.FLOWING_LIROTH_FLUID);
                tag(FluidTags.WATER)
                        .add(LirothFluids.LIROTH_FLUID)
                        .add(LirothFluids.FLOWING_LIROTH_FLUID);
            }
        };
    }
}
