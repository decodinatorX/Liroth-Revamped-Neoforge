package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.features.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothFeatures {

    public static Feature<?> OBSIDIAN_SPIKE;
    public static Feature<?> VILE_TENTACLE;
    public static Feature<?> LIROTH_BONE_CLAW;
    public static Feature<?> LIROTH_BONE_MUSHROOM;
    public static Feature<?> LIROTH_BONE_TREE;
    public static Feature<?> JALSPHIRE_CRYSTAL_CLUSTER;
    public static Feature<?> PETRIFIED_CRYSTAL_CLUSTER;
    public static Feature<?> DAMNATION_VINES;
    public static Feature<?> WILTING_LIROTH_ROSES;
    public static Feature<?> GLEEMSTONE_PILLAR;

    public static void register(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.FEATURE)) {
            event.register(Registries.FEATURE, helper -> {
                OBSIDIAN_SPIKE = new ObsidianSpikeFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("obsidian_spike"), OBSIDIAN_SPIKE);
                VILE_TENTACLE = new VileTentacleFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("vile_tentacle"), VILE_TENTACLE);
                LIROTH_BONE_CLAW = new LirothBoneClawFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_claw"), LIROTH_BONE_CLAW);
                LIROTH_BONE_MUSHROOM = new LirothBoneMushroomFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_mushroom"), LIROTH_BONE_MUSHROOM);
                LIROTH_BONE_TREE = new LirothBoneTreeFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("liroth_bone_tree"), LIROTH_BONE_TREE);
                JALSPHIRE_CRYSTAL_CLUSTER = new PointedJalsphireCrystalFeature(PointedDripstoneConfiguration.CODEC);
                helper.register(Liroth.C.mk("pointed_jalsphire_crystal"), JALSPHIRE_CRYSTAL_CLUSTER);
                PETRIFIED_CRYSTAL_CLUSTER = new PointedPetrifiedCrystalFeature(PointedDripstoneConfiguration.CODEC);
                helper.register(Liroth.C.mk("pointed_petrified_crystal"), PETRIFIED_CRYSTAL_CLUSTER);
                DAMNATION_VINES = new DamnationVinesFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("damnation_vines"), DAMNATION_VINES);
                WILTING_LIROTH_ROSES = new RandomPatchFeature(RandomPatchConfiguration.CODEC);
                helper.register(Liroth.C.mk("wilting_liroth_roses"), WILTING_LIROTH_ROSES);
                Feature<?> gleemstoneShard = new PointedJalsphireCrystalFeature(
                        PointedDripstoneConfiguration.CODEC,
                        LirothBlocks.POINTED_GLEEMSTONE_SHARD,
                        LirothBlocks.GLEEMSTONE
                );
                helper.register(Liroth.C.mk("pointed_gleemstone_shard"), gleemstoneShard);
                GLEEMSTONE_PILLAR = new GleemstonePillarFeature(NoneFeatureConfiguration.CODEC);
                helper.register(Liroth.C.mk("gleemstone_pillar"), GLEEMSTONE_PILLAR);
            });
        }
    }
}
