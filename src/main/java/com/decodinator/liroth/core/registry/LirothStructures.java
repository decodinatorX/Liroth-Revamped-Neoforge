package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.structures.LirothFortressStructure;
import com.decodinator.liroth.core.structures.NovaTowerStructure;
import com.decodinator.liroth.core.structures.OldenLirothPortalStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothStructures {
    public static StructureType<LirothFortressStructure> LIROTH_FORTRESS;
    public static StructureType<NovaTowerStructure> NOVA_TOWER;
    public static StructureType<OldenLirothPortalStructure> OLDEN_LIROTH_PORTAL;

    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.STRUCTURE_TYPE)) return;
        event.register(Registries.STRUCTURE_TYPE, helper -> {
            LIROTH_FORTRESS = () -> (MapCodec<LirothFortressStructure>) LirothFortressStructure.CODEC;
            helper.register(Liroth.C.mk("liroth_fortress"), LIROTH_FORTRESS);
            NOVA_TOWER = () -> (MapCodec<NovaTowerStructure>) NovaTowerStructure.CODEC;
            helper.register(Liroth.C.mk("nova_tower"), NOVA_TOWER);
            OLDEN_LIROTH_PORTAL = () -> (MapCodec<OldenLirothPortalStructure>) OldenLirothPortalStructure.CODEC;
            helper.register(Liroth.C.mk("olden_liroth_portal"), OLDEN_LIROTH_PORTAL);
        });
    }
}
