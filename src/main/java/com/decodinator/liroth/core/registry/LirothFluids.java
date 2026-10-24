package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluid;
import com.decodinator.liroth.core.fluids.MoltenSpinerios;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothFluids {

    public static final ResourceLocation LIROTH_FLUID_STILL_PROP = ResourceLocation.fromNamespaceAndPath( Liroth.MOD_ID,"block/liroth_fluid_still");
    public static final ResourceLocation LIROTH_FLUID_FLOWING_PROP = ResourceLocation.fromNamespaceAndPath( Liroth.MOD_ID,"block/liroth_fluid_flowing");
    public static final ResourceLocation MOLTEN_SPINERIOS_STILL_PROP = ResourceLocation.fromNamespaceAndPath( Liroth.MOD_ID,"block/molten_spinerios_still");
    public static final ResourceLocation MOLTEN_SPINERIOS_FLOWING_PROP = ResourceLocation.fromNamespaceAndPath( Liroth.MOD_ID,"block/molten_spinerios_flowing");

    public static final FluidType LIROTH_FLUID_TYPE = new FluidType(FluidType.Properties.create()
            .lightLevel(0)
            .density(15)
            .viscosity(5)
            .supportsBoating(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY));
    public static final FluidType MOLTEN_SPINERIOS_TYPE = new FluidType(FluidType.Properties.create()
            .lightLevel(0)
            .density(15)
            .viscosity(5)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY));


    public static FlowingFluid LIROTH_FLUID;
    public static FlowingFluid FLOWING_LIROTH_FLUID;
    public static FlowingFluid MOLTEN_SPINERIOS;
    public static FlowingFluid FLOWING_MOLTEN_SPINERIOS;


    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(NeoForgeRegistries.Keys.FLUID_TYPES)) {
            event.register(NeoForgeRegistries.Keys.FLUID_TYPES, helper -> {
                helper.register(Liroth.C.mk("liroth_fluid"), LIROTH_FLUID_TYPE);
                helper.register(Liroth.C.mk("molten_spinerios"), MOLTEN_SPINERIOS_TYPE);
            });
            return;
        }

        if (!event.getRegistryKey().equals(Registries.FLUID)) return;
        event.register(Registries.FLUID, helper -> {
            LIROTH_FLUID = new LirothFluid.Still();
                helper.register(Liroth.C.mk("liroth_fluid"), LIROTH_FLUID);
            FLOWING_LIROTH_FLUID = new LirothFluid.Flowing();
                helper.register(Liroth.C.mk("flowing_liroth_fluid"), FLOWING_LIROTH_FLUID);
            MOLTEN_SPINERIOS = new MoltenSpinerios.Still();
                helper.register(Liroth.C.mk("molten_spinerios"), MOLTEN_SPINERIOS);
            FLOWING_MOLTEN_SPINERIOS = new MoltenSpinerios.Flowing();
                helper.register(Liroth.C.mk("flowing_molten_spinerios"), FLOWING_MOLTEN_SPINERIOS);
        });
    }
}
