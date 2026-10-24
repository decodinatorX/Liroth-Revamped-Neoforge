package com.decodinator.datagen.liroth;

import com.decodinator.liroth.core.registry.LirothJukeboxSongs;
import com.decodinator.liroth.core.registry.LirothSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverRegistryContentProvider;

public class LirothJukeboxSongProvider extends WoverRegistryContentProvider<JukeboxSong> {
    public LirothJukeboxSongProvider(ModCore core) {
        super(core, "Liroth Jukebox Songs", Registries.JUKEBOX_SONG);
    }

    @Override
    protected void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, LirothJukeboxSongs.LIROTH, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_LIROTH), 158, 1);
        register(context, LirothJukeboxSongs.PIER, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_PIER), 148, 2);
        register(context, LirothJukeboxSongs.SPICED, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_SPICED), 482, 3);
        register(context, LirothJukeboxSongs.DAMNATION, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_DAMNATION), 224, 4);
        register(context, LirothJukeboxSongs.ESCAPE, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_ESCAPE), 202, 5);
        register(context, LirothJukeboxSongs.SPITE, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_SPITE), 302, 6);
        register(context, LirothJukeboxSongs.DESOLATION, context.lookup(Registries.SOUND_EVENT).getOrThrow(LirothSounds.KEY_DESOLATION), 144, 7);
    }
    private static void register(
            BootstrapContext<JukeboxSong> context,
            ResourceKey<JukeboxSong> key,
            Holder<SoundEvent> soundEvent,
            float lengthInSeconds,
            int comparatorOutput
    ) {
        context.register(
                key,
                new JukeboxSong(
                        soundEvent,
                        Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())),
                        lengthInSeconds,
                        comparatorOutput
                )
        );
    }
}
