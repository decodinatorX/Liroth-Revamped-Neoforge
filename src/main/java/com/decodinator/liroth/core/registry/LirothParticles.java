package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.betterx.bclib.particles.BCLParticleType;

public class LirothParticles {
    private static boolean registered = false;

    public static SimpleParticleType GREEN_FLAME;
    public static SimpleParticleType PURPLE_FLAME;
    public static SimpleParticleType CLOAK;
    public static SimpleParticleType SPORE;

    public static SimpleParticleType LIROTH_PORTAL;
    public static SimpleParticleType DAMNATION_PORTAL;
    public static SimpleParticleType JANTIRO_PORTAL;
    public static SimpleParticleType JALSPHIRE_PORTAL;
    public static SimpleParticleType DEVASTATED_PORTAL;

    public static void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.PARTICLE_TYPE)) {
            return;
        }
        registerTypes();
    }

    private static void registerTypes() {
        if (registered) return;
        registered = true;

        GREEN_FLAME = register("green_flame");
        PURPLE_FLAME = register("purple_flame");
        CLOAK = register("cloak");
        SPORE = register("green_spore");

        LIROTH_PORTAL = register("liroth_portal");
        DAMNATION_PORTAL = register("damnation_portal");
        JANTIRO_PORTAL = register("jantiro_portal");
        JALSPHIRE_PORTAL = register("jalsphire_portal");
        DEVASTATED_PORTAL = register("devastated_portal");
    }

    private static SimpleParticleType register(String name) {
        return BCLParticleType.register(Liroth.C.mk(name));
    }
}
