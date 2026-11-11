package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothPotions {

    public static Potion STRONGER_LEAPING;
    public static Potion STRONGER_SWIFTNESS;
    public static Potion STRONGER_SLOWNESS;
    public static Potion STRONGER_TURTLE_MASTER;
    public static Potion STRONGER_HEALING;
    public static Potion STRONGER_HARMING;
    public static Potion STRONGER_POISON;
    public static Potion STRONGER_REGENERATION;
    public static Potion STRONGER_STRENGTH;

    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.POTION)) return;
        event.register(Registries.POTION, helper -> {
            STRONGER_LEAPING = new Potion("leaping", new MobEffectInstance(MobEffects.JUMP_BOOST, 3600, 2));
            helper.register(Liroth.C.mk("stronger_leaping"), STRONGER_LEAPING);
            STRONGER_SWIFTNESS = new Potion("swiftness", new MobEffectInstance(MobEffects.SPEED, 3600, 2));
            helper.register(Liroth.C.mk("stronger_swiftness"), STRONGER_SWIFTNESS);
            STRONGER_SLOWNESS = new Potion("slowness", new MobEffectInstance(MobEffects.SLOWNESS, 800, 5));
            helper.register(Liroth.C.mk("stronger_slowness"), STRONGER_SLOWNESS);
            STRONGER_TURTLE_MASTER = new Potion("turtle_master", new MobEffectInstance(MobEffects.SLOWNESS, 800, 7), new MobEffectInstance(MobEffects.RESISTANCE, 800, 5));
            helper.register(Liroth.C.mk("stronger_turtle_master"), STRONGER_TURTLE_MASTER);
            STRONGER_HEALING = new Potion("healing", new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 2));
            helper.register(Liroth.C.mk("stronger_healing"), STRONGER_HEALING);
            STRONGER_HARMING = new Potion("harming", new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 2));
            helper.register(Liroth.C.mk("stronger_harming"), STRONGER_HARMING);
            STRONGER_POISON = new Potion("poison", new MobEffectInstance(MobEffects.POISON, 1800, 2));
            helper.register(Liroth.C.mk("stronger_poison"), STRONGER_POISON);
            STRONGER_REGENERATION = new Potion("regeneration", new MobEffectInstance(MobEffects.REGENERATION, 1800, 2));
            helper.register(Liroth.C.mk("stronger_regeneration"), STRONGER_REGENERATION);
            STRONGER_STRENGTH = new Potion("strength", new MobEffectInstance(MobEffects.STRENGTH, 3600, 2));
            helper.register(Liroth.C.mk("stronger_strength"), STRONGER_STRENGTH);
        });
    }
}
