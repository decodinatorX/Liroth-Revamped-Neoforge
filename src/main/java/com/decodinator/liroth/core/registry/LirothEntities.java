package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.projectiles.LevoArrow;
import com.decodinator.liroth.core.entities.*;
import com.decodinator.liroth.core.entities.projectiles.BeamLaserProjectileEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.RegisterEvent;

public class LirothEntities {

    public static EntityType<BeamLaserProjectileEntity> BEAM_LASER_PROJECTILE;
    public static EntityType<LevoArrow> LEVO_ARROW;

    public static EntityType<ForsakenCorpseEntity> FORSAKEN_CORPSE;
    public static EntityType<FungalFiendEntity> FUNGAL_FIEND;
    public static EntityType<SkeletalFreakEntity> SKELETAL_FREAK;
    public static EntityType<WarpEntity> WARP;
    public static EntityType<SoulArachnidEntity> SOUL_ARACHNID;
    public static EntityType<PierPeepEntity> PIER_PEEP;
    public static EntityType<ShadeEntity> SHADE;
    public static EntityType<LirothianMimicEntity> LIROTHIAN_MIMIC;
    public static EntityType<ProwlerEntity> PROWLER;
    public static EntityType<FreakshowEntity> FREAKSHOW;
    public static EntityType<VileSharkEntity> VILE_SHARK;


    public static void register(RegisterEvent event) {
        if (!event.getRegistryKey().equals(Registries.ENTITY_TYPE)) return;
        event.register(Registries.ENTITY_TYPE, helper -> {
            BEAM_LASER_PROJECTILE = EntityType.Builder.of(
                            BeamLaserProjectileEntity::new,
                            MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "beam_laser_projectile_entity").toString());
            helper.register(Liroth.C.mk("beam_laser_projectile_entity"), BEAM_LASER_PROJECTILE);
            LEVO_ARROW = EntityType.Builder.<LevoArrow>of(LevoArrow::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "levo_arrow").toString());
            helper.register(Liroth.C.mk("levo_arrow"), LEVO_ARROW);

            FORSAKEN_CORPSE = EntityType.Builder.of(
                    ForsakenCorpseEntity::new,
                    MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "forsaken_corpse").toString());
            helper.register(Liroth.C.mk("forsaken_corpse"), FORSAKEN_CORPSE);
            FUNGAL_FIEND = EntityType.Builder.of(
                            FungalFiendEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.6f, 2f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend").toString());
            helper.register(Liroth.C.mk("fungal_fiend"), FUNGAL_FIEND);
            SKELETAL_FREAK = EntityType.Builder.of(
                            SkeletalFreakEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "skeletal_freak").toString());
            helper.register(Liroth.C.mk("skeletal_freak"), SKELETAL_FREAK);
            WARP = EntityType.Builder.of(
                    WarpEntity::new,
                    MobCategory.MONSTER)
                    .sized(0.6f, 2.9f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp").toString());
            helper.register(Liroth.C.mk("warp"), WARP);
            SOUL_ARACHNID = EntityType.Builder.of(
                            SoulArachnidEntity::new,
                            MobCategory.MONSTER)
                    .sized(1.25f, 0.5f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "soul_arachnid").toString());
            helper.register(Liroth.C.mk("soul_arachnid"), SOUL_ARACHNID);
            PIER_PEEP = EntityType.Builder.of(
                            PierPeepEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.5f, 0.5f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "pier_peep").toString());
            helper.register(Liroth.C.mk("pier_peep"), PIER_PEEP);
            SHADE = EntityType.Builder.of(
                            ShadeEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "shade").toString());
            helper.register(Liroth.C.mk("shade"), SHADE);
            LIROTHIAN_MIMIC = EntityType.Builder.of(
                            LirothianMimicEntity::new,
                            MobCategory.MONSTER)
                    .sized(1.25f, 0.5f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "lirothian_mimic").toString());
            helper.register(Liroth.C.mk("lirothian_mimic"), LIROTHIAN_MIMIC);
            PROWLER = EntityType.Builder.of(
                            ProwlerEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.6f, 2.9f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "prowler").toString());
            helper.register(Liroth.C.mk("prowler"), PROWLER);
            FREAKSHOW = EntityType.Builder.of(
                            FreakshowEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.6f, 2.9f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "freakshow").toString());
            helper.register(Liroth.C.mk("freakshow"), FREAKSHOW);
            VILE_SHARK = EntityType.Builder.of(
                            VileSharkEntity::new,
                            MobCategory.MONSTER)
                    .sized(1.25f, 0.5f)
                    .build(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "vile_shark").toString());
            helper.register(Liroth.C.mk("vile_shark"), VILE_SHARK);
        });
    }
}
