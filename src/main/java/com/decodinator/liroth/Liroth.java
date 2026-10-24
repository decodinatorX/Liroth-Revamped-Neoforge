package com.decodinator.liroth;

import com.decodinator.datagen.liroth.LirothDatagen;
import com.decodinator.liroth.core.entities.*;
import com.decodinator.liroth.core.blocks.PortalChargeFrameBlock;
import com.decodinator.liroth.core.registry.*;
import com.decodinator.liroth.core.tab.CreativeTabs;
import com.decodinator.liroth.core.worldgen.LirothSeededChunkGenerator;
import de.ambertation.wunderlib.general.Logger;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.betterx.wover.core.api.ModCore;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Liroth.MOD_ID)
public class Liroth {
    public static final String MOD_ID = "liroth";
    private static final int MAX_NATURAL_LIROTH_MOBS_NEAR_SPAWN = 20;
    private static final int NATURAL_LIROTH_MOB_CAP_RADIUS = 128;
    public static final ModCore C = ModCore.create(MOD_ID);
    public static final Logger LOGGER = C.LOG;

    private static final RegistrySetBuilder BUILDER = (new RegistrySetBuilder()).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) LirothConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) LirothPlacedFeatures::bootstrap);

    public Liroth(IEventBus modEventBus, ModContainer modContainer) {
        C.registerDatapackListener(modEventBus);
        modEventBus.addListener(RegisterEvent.class, LirothParticles::onRegister);
        modEventBus.addListener(RegisterEvent.class, LirothMenuTypes::register);
        modEventBus.addListener(RegisterEvent.class, this::ensureBlocksLoaded);
        modEventBus.addListener(RegisterEvent.class, this::ensureItemsLoaded);
        modEventBus.addListener(RegisterEvent.class, LirothBlockEntities::register);
        modEventBus.addListener(RegisterEvent.class, CreativeTabs::onRegister);
        modEventBus.addListener(RegisterEvent.class, LirothFluids::register);
        modEventBus.addListener(RegisterEvent.class, LirothRecipeTypes::register);
        modEventBus.addListener(RegisterEvent.class, LirothEntities::register);
        modEventBus.addListener(RegisterEvent.class, LirothSounds::register);
        modEventBus.addListener(RegisterEvent.class, LirothStructures::register);
        modEventBus.addListener(RegisterEvent.class, this::registerChunkGenerator);
        modEventBus.addListener(RegisterEvent.class, LirothPotions::register);
        NeoForge.EVENT_BUS.addListener(LirothPotions::registerBrewingRecipes);
        modEventBus.addListener(Liroth::registerAttributes);
        modEventBus.addListener(Liroth::registerSpawnPlacements);
        NeoForge.EVENT_BUS.addListener(this::onEntityAttack);
        NeoForge.EVENT_BUS.addListener(this::onPortalFrameDrops);
        NeoForge.EVENT_BUS.addListener(this::limitNaturalLirothMobSpawns);
        modEventBus.addListener(RegisterEvent.class, LirothFeatures::register);
        LirothConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
        LirothPlacedFeatures.PLACED_FEATURES.register(modEventBus);
        Liroth.BUILDER.getEntryKeys();
        if (ModCore.isDatagen()) {
            LirothDatagen datagen = new LirothDatagen();
            modEventBus.addListener(datagen::onGatherData);
        }
        LirothTags.register();
        LirothPortalBuilders.init();
    }

    private void registerChunkGenerator(RegisterEvent event) {
        if (event.getRegistryKey().equals(Registries.CHUNK_GENERATOR)) {
            event.register(Registries.CHUNK_GENERATOR,
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "dimension_seeded"),
                    () -> LirothSeededChunkGenerator.CODEC);
        }
    }

    private static boolean bonemealInitialized = false;

    private void ensureBlocksLoaded(RegisterEvent event) {
        if (event.getRegistryKey().equals(net.minecraft.core.registries.Registries.BLOCK)) {
            try {
                Class.forName("com.decodinator.liroth.core.registry.LirothBlocks");
            } catch (ClassNotFoundException ignored) {
            }
            if (!bonemealInitialized) {
                //    BonemealPlants.init();
                bonemealInitialized = true;
            }
        }
    }

    private void ensureItemsLoaded(RegisterEvent event) {
        if (event.getRegistryKey().equals(net.minecraft.core.registries.Registries.ITEM)) {
            try {
                Class.forName("com.decodinator.liroth.core.registry.LirothItems");
            } catch (ClassNotFoundException ignored) {
            }
            LirothItems.ensureStaticallyLoaded();
            LirothItems.registerCompostableFoods();
        }
    }

    private void onEntityAttack(AttackEntityEvent event) {
        if (event.getEntity().level().isClientSide
                || !(event.getTarget() instanceof ShadeEntity shade)
                || !event.getEntity().getMainHandItem().is(LirothTags.TORCHES)) {
            return;
        }

        shade.kill();
        event.setCanceled(true);
    }

    private void onPortalFrameDrops(BlockDropsEvent event) {
        if (event.getState().getBlock() instanceof PortalChargeFrameBlock frame
                && event.getState().getValue(PortalChargeFrameBlock.CHARGED)) {
            event.getDrops().add(new ItemEntity(
                    event.getLevel(),
                    event.getPos().getX() + 0.5,
                    event.getPos().getY() + 0.5,
                    event.getPos().getZ() + 0.5,
                    new ItemStack(frame.getChargeItem())
            ));
        }
    }

    private void limitNaturalLirothMobSpawns(FinalizeSpawnEvent event) {
        Mob mob = event.getEntity();
        if (event.getSpawnType() != MobSpawnType.NATURAL
                || !mob.getType().builtInRegistryHolder().key().location().getNamespace().equals(MOD_ID)) {
            return;
        }

        double x = event.getX();
        double y = event.getY();
        double z = event.getZ();
        AABB capArea = new AABB(
                x - NATURAL_LIROTH_MOB_CAP_RADIUS, y - NATURAL_LIROTH_MOB_CAP_RADIUS, z - NATURAL_LIROTH_MOB_CAP_RADIUS,
                x + NATURAL_LIROTH_MOB_CAP_RADIUS, y + NATURAL_LIROTH_MOB_CAP_RADIUS, z + NATURAL_LIROTH_MOB_CAP_RADIUS);
        long nearbyLirothMobs = event.getLevel().getEntitiesOfClass(Mob.class, capArea,
                nearby -> nearby.isAlive()
                        && nearby.getType().builtInRegistryHolder().key().location().getNamespace().equals(MOD_ID))
                .size();

        if (nearbyLirothMobs >= MAX_NATURAL_LIROTH_MOBS_NEAR_SPAWN) {
            event.setSpawnCancelled(true);
        }
    }

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(LirothEntities.FORSAKEN_CORPSE, ForsakenCorpseEntity.createForsakenCorpseAttributes().build());
        event.put(LirothEntities.FUNGAL_FIEND, FungalFiendEntity.createFungalFiendAttributes().build());
        event.put(LirothEntities.SKELETAL_FREAK, SkeletalFreakEntity.createSkeletalFreakAttributes().build());
        event.put(LirothEntities.WARP, WarpEntity.createWarpAttributes().build());
        event.put(LirothEntities.SOUL_ARACHNID, SoulArachnidEntity.createSoulArachnidAttributes().build());
        event.put(LirothEntities.PIER_PEEP, PierPeepEntity.createPierPeepAttributes().build());
        event.put(LirothEntities.SHADE, ShadeEntity.createShadeAttributes().build());
        event.put(LirothEntities.LIROTHIAN_MIMIC, LirothianMimicEntity.createLirothianMimicAttributes().build());
        event.put(LirothEntities.PROWLER, ProwlerEntity.createProwlerAttributes().build());
        event.put(LirothEntities.FREAKSHOW, FreakshowEntity.createFreakshowAttributes().build());
        event.put(LirothEntities.VILE_SHARK, VileSharkEntity.createVileSharkAttributes().build());
    }

    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(LirothEntities.FORSAKEN_CORPSE,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.FUNGAL_FIEND,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.SKELETAL_FREAK,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.WARP,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.SOUL_ARACHNID,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.PIER_PEEP,
                SpawnPlacementTypes.NO_RESTRICTIONS,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.SHADE,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.LIROTHIAN_MIMIC,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.PROWLER,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.FREAKSHOW,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);
        event.register(LirothEntities.VILE_SHARK,
                SpawnPlacementTypes.NO_RESTRICTIONS,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, level, spawnType, pos, random) -> {
                    var fluidAtSpawn = level.getFluidState(pos).getType();
                    var fluidAbove = level.getFluidState(pos.above()).getType();
                    boolean spawnInLirothFluid = fluidAtSpawn == LirothFluids.LIROTH_FLUID
                            || fluidAtSpawn == LirothFluids.FLOWING_LIROTH_FLUID;
                    boolean fluidAboveIsLiroth = fluidAbove == LirothFluids.LIROTH_FLUID
                            || fluidAbove == LirothFluids.FLOWING_LIROTH_FLUID;
                    return spawnInLirothFluid && fluidAboveIsLiroth;
                },
                RegisterSpawnPlacementsEvent.Operation.AND);
    }
}
