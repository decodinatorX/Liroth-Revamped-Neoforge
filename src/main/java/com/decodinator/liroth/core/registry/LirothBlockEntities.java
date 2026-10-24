package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blockentities.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothBlockEntities {
    static {
        LirothBlocks.ensureRegistered();
    }

    public static BlockEntityType<FungalCampfireBlockEntity> FUNGAL_CAMPFIRE;
    public static BlockEntityType<LirothianPetroleumCampfireBlockEntity> LIROTHIAN_PETROLEUM_CAMPFIRE;

    public static BlockEntityType<SplitterBlockEntity> LIROTH_SPLITTER;
    public static BlockEntityType<QuantumBlockEntity> QUANTUM_EXTRACTOR;

    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.BLOCK_ENTITY_TYPE)) return;
        event.register(Registries.BLOCK_ENTITY_TYPE, helper -> {
            FUNGAL_CAMPFIRE = BlockEntityType.Builder.of(
                    FungalCampfireBlockEntity::new,
                    LirothBlocks.FUNGAL_CAMPFIRE
            ).build(null);
            helper.register(Liroth.C.mk("fungal_campfire"), FUNGAL_CAMPFIRE);
            LIROTHIAN_PETROLEUM_CAMPFIRE = BlockEntityType.Builder.of(
                    LirothianPetroleumCampfireBlockEntity::new,
                    LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE
            ).build(null);
            helper.register(Liroth.C.mk("lirothian_petroleum_campfire"), LIROTHIAN_PETROLEUM_CAMPFIRE);
            LIROTH_SPLITTER = BlockEntityType.Builder.of(
                    SplitterBlockEntity::new,
                    LirothBlocks.LIROTH_SPLITTER
            ).build(null);
            helper.register(Liroth.C.mk("liroth_splitter"), LIROTH_SPLITTER);
            QUANTUM_EXTRACTOR = BlockEntityType.Builder.of(
                    QuantumBlockEntity::new,
                    LirothBlocks.QUANTUM_EXTRACTOR
            ).build(null);
            helper.register(Liroth.C.mk("quantum_extractor"), QUANTUM_EXTRACTOR);
        });
    }
}
