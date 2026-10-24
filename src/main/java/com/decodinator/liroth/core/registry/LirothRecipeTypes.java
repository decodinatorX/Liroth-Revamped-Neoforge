package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.recipetypes.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothRecipeTypes {

    public static RecipeType<AbstractSplitterRecipe> LIROTH_SPLITTING;
    public static RecipeType<AbstractQuantumRecipe> QUANTUM_EXTRACTING;
    public static SimpleSplitterSerializer<SplitterRecipe> LIROTH_SPLITTING_S;
    public static SimpleQuantumSerializer<QuantumRecipe> QUANTUM_EXTRACTING_S;

    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.RECIPE_TYPE)) {
            event.register(Registries.RECIPE_TYPE, helper -> {
                LIROTH_SPLITTING = new RecipeType<AbstractSplitterRecipe>() {};
                helper.register(Liroth.C.mk("liroth_splitting"), LIROTH_SPLITTING);
                QUANTUM_EXTRACTING = new RecipeType<AbstractQuantumRecipe>() {};
                helper.register(Liroth.C.mk("quantum_extracting"), QUANTUM_EXTRACTING);
            });
        } else if (event.getRegistryKey().equals(Registries.RECIPE_SERIALIZER)) {
            event.register(Registries.RECIPE_SERIALIZER, helper -> {
                LIROTH_SPLITTING_S = new SimpleSplitterSerializer<>(SplitterRecipe::new, 200);
                helper.register(Liroth.C.mk("liroth_splitting"), LIROTH_SPLITTING_S);
                QUANTUM_EXTRACTING_S = new SimpleQuantumSerializer<>(QuantumRecipe::new, 200);
                helper.register(Liroth.C.mk("quantum_extracting"), QUANTUM_EXTRACTING_S);
            });
        }
    }
}
