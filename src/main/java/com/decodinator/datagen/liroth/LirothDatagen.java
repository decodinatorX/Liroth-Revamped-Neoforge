package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.PackBuilder;
import org.betterx.wover.datagen.api.WoverDataGenEntryPoint;

import java.util.concurrent.CompletableFuture;

public class LirothDatagen extends WoverDataGenEntryPoint {
    @Override
    protected  void onInitializeProviders(PackBuilder pack) {
        pack.addProvider(LirothJukeboxSongProvider::new);
        pack.addProvider(LirothBlockTagDataProvider::new);
        pack.addProvider(LirothItemTagDataProvider::new);
        pack.addProvider(LirothFluidTagDataProvider::new);
        pack.addProvider(LirothBiomeTagDataProvider::new);
    }

    @Override
    protected void onBuildRegistry(RegistrySetBuilder builder) {

    }

    @Override
    protected ModCore modCore() {
        return Liroth.C;
    }
}
