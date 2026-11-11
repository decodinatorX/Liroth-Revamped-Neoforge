package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.features.GleemstonePillarFeature;
import com.decodinator.liroth.core.features.LirothBoneClawFeature;
import com.decodinator.liroth.core.features.LirothBoneMushroomFeature;
import com.decodinator.liroth.core.features.LirothBoneTreeFeature;
import com.decodinator.liroth.core.features.ObsidianSpikeFeature;
import com.decodinator.liroth.core.features.PointedJalsphireCrystalFeature;
import com.decodinator.liroth.core.features.PointedPetrifiedCrystalFeature;
import com.decodinator.liroth.core.features.PointedGleemstoneShardFeature;
import com.decodinator.liroth.core.features.VileTentacleFeature;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.RegisterEvent;

public final class LirothFeatures {
    private LirothFeatures() {
    }

    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.FEATURE_TYPE)) {
            event.register(Registries.FEATURE_TYPE, helper -> {
                helper.register(Liroth.C.mk("obsidian_spike"), ObsidianSpikeFeature.CODEC);
                helper.register(Liroth.C.mk("vile_tentacle"), VileTentacleFeature.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_claw"), LirothBoneClawFeature.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_mushroom"), LirothBoneMushroomFeature.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_tree"), LirothBoneTreeFeature.CODEC);
                helper.register(Liroth.C.mk("pointed_jalsphire_crystal"), PointedJalsphireCrystalFeature.CODEC);
                helper.register(Liroth.C.mk("pointed_petrified_crystal"), PointedPetrifiedCrystalFeature.CODEC);
                helper.register(Liroth.C.mk("pointed_gleemstone_shard"), PointedGleemstoneShardFeature.CODEC);
                helper.register(Liroth.C.mk("gleemstone_pillar"), GleemstonePillarFeature.CODEC);
            });
        }
    }
}
