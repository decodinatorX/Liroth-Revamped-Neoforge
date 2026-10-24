package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothSounds {

    public static SoundEvent LIROTH_BLASTER_FIRING;

    public static SoundEvent FUNGAL_FIEND_DEATH;
    public static SoundEvent FUNGAL_FIEND_HURT;
    public static SoundEvent FUNGAL_FIEND_FUSE;

    public static SoundEvent WARP_DEATH;
    public static SoundEvent WARP_HURT;
    public static SoundEvent WARP_IDLE;

    public static SoundEvent SHADE_DEATH;
    public static SoundEvent SHADE_HURT;
    public static SoundEvent SHADE_IDLE;

    public static SoundEvent LIROTH;
    public static final ResourceKey<SoundEvent> KEY_LIROTH = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.liroth_biome"));

    public static SoundEvent PIER;
    public static final ResourceKey<SoundEvent> KEY_PIER = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.tallpier_biome"));

    public static SoundEvent SPICED;
    public static final ResourceKey<SoundEvent> KEY_SPICED = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.spiced_desert"));

    public static SoundEvent DAMNATION;
    public static final ResourceKey<SoundEvent> KEY_DAMNATION = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.damnation"));

    public static SoundEvent ESCAPE;
    public static final ResourceKey<SoundEvent> KEY_ESCAPE = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.escape"));

    public static SoundEvent SPITE;
    public static final ResourceKey<SoundEvent> KEY_SPITE = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.jalsphire"));

    public static SoundEvent DESOLATION;
    public static final ResourceKey<SoundEvent> KEY_DESOLATION = ResourceKey.create(Registries.SOUND_EVENT, ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "music.liroth.desolate"));



    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.SOUND_EVENT)) return;
        event.register(Registries.SOUND_EVENT, helper -> {
            LIROTH_BLASTER_FIRING = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "liroth_blaster_firing"));
            helper.register(Liroth.C.mk("liroth_blaster_firing"), LIROTH_BLASTER_FIRING);
            FUNGAL_FIEND_DEATH = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend_death"));
            helper.register(Liroth.C.mk("fungal_fiend_death"), FUNGAL_FIEND_DEATH);
            FUNGAL_FIEND_HURT = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend_hurt"));
            helper.register(Liroth.C.mk("fungal_fiend_hurt"), FUNGAL_FIEND_HURT);
            FUNGAL_FIEND_FUSE = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend_fuse"));
            helper.register(Liroth.C.mk("fungal_fiend_fuse"), FUNGAL_FIEND_FUSE);
            WARP_DEATH = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp_death"));
            helper.register(Liroth.C.mk("warp_death"), WARP_DEATH);
            WARP_HURT = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp_hurt"));
            helper.register(Liroth.C.mk("warp_hurt"), WARP_HURT);
            WARP_IDLE = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp_idle"));
            helper.register(Liroth.C.mk("warp_idle"), WARP_IDLE);
            SHADE_DEATH = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "shade_death"));
            helper.register(Liroth.C.mk("shade_death"), SHADE_DEATH);
            SHADE_HURT = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "shade_hurt"));
            helper.register(Liroth.C.mk("shade_hurt"), SHADE_HURT);
            SHADE_IDLE = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "shade_idle"));
            helper.register(Liroth.C.mk("shade_idle"), SHADE_IDLE);
            LIROTH = SoundEvent.createVariableRangeEvent(KEY_LIROTH.location());
            helper.register(KEY_LIROTH.location(), LIROTH);
            PIER = SoundEvent.createVariableRangeEvent(KEY_PIER.location());
            helper.register(KEY_PIER.location(), PIER);
            SPICED = SoundEvent.createVariableRangeEvent(KEY_SPICED.location());
            helper.register(KEY_SPICED.location(), SPICED);
            DAMNATION = SoundEvent.createVariableRangeEvent(KEY_DAMNATION.location());
            helper.register(KEY_DAMNATION.location(), DAMNATION);
            ESCAPE = SoundEvent.createVariableRangeEvent(KEY_ESCAPE.location());
            helper.register(KEY_ESCAPE.location(), ESCAPE);
            SPITE = SoundEvent.createVariableRangeEvent(KEY_SPITE.location());
            helper.register(KEY_SPITE.location(), SPITE);
            DESOLATION = SoundEvent.createVariableRangeEvent(KEY_DESOLATION.location());
            helper.register(KEY_DESOLATION.location(), DESOLATION);
        });
    }
}
