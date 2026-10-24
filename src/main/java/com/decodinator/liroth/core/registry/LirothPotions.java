package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
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
            STRONGER_LEAPING = new Potion("leaping", new MobEffectInstance(MobEffects.JUMP, 3600, 2));
            helper.register(Liroth.C.mk("stronger_leaping"), STRONGER_LEAPING);
            STRONGER_SWIFTNESS = new Potion("swiftness", new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 2));
            helper.register(Liroth.C.mk("stronger_swiftness"), STRONGER_SWIFTNESS);
            STRONGER_SLOWNESS = new Potion("slowness", new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 800, 5));
            helper.register(Liroth.C.mk("stronger_slowness"), STRONGER_SLOWNESS);
            STRONGER_TURTLE_MASTER = new Potion("turtle_master", new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 800, 7), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800, 5));
            helper.register(Liroth.C.mk("stronger_turtle_master"), STRONGER_TURTLE_MASTER);
            STRONGER_HEALING = new Potion("healing", new MobEffectInstance(MobEffects.HEAL, 1, 2));
            helper.register(Liroth.C.mk("stronger_healing"), STRONGER_HEALING);
            STRONGER_HARMING = new Potion("harming", new MobEffectInstance(MobEffects.HARM, 1, 2));
            helper.register(Liroth.C.mk("stronger_harming"), STRONGER_HARMING);
            STRONGER_POISON = new Potion("poison", new MobEffectInstance(MobEffects.POISON, 1800, 2));
            helper.register(Liroth.C.mk("stronger_poison"), STRONGER_POISON);
            STRONGER_REGENERATION = new Potion("regeneration", new MobEffectInstance(MobEffects.REGENERATION, 1800, 2));
            helper.register(Liroth.C.mk("stronger_regeneration"), STRONGER_REGENERATION);
            STRONGER_STRENGTH = new Potion("strength", new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 2));
            helper.register(Liroth.C.mk("stronger_strength"), STRONGER_STRENGTH);
        });
    }

    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        var builder = event.getBuilder();
        builder.addMix(Potions.STRONG_LEAPING, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_LEAPING));
        builder.addMix(Potions.STRONG_SWIFTNESS, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_SWIFTNESS));
        builder.addMix(Potions.STRONG_SLOWNESS, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_SLOWNESS));
        builder.addMix(Potions.STRONG_TURTLE_MASTER, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_TURTLE_MASTER));
        builder.addMix(Potions.STRONG_HEALING, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_HEALING));
        builder.addMix(Potions.STRONG_HARMING, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_HARMING));
        builder.addMix(Potions.STRONG_POISON, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_POISON));
        builder.addMix(Potions.STRONG_REGENERATION, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_REGENERATION));
        builder.addMix(Potions.STRONG_STRENGTH, LirothItems.GLEEMSTONE_DUST,
                BuiltInRegistries.POTION.wrapAsHolder(STRONGER_STRENGTH));
    }
}
