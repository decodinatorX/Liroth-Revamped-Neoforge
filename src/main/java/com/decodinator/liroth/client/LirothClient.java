package com.decodinator.liroth.client;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.client.models.entities.FreakshowModel;
import com.decodinator.liroth.client.models.entities.PierPeepModel;
import com.decodinator.liroth.client.models.entities.ShadeModel;
import com.decodinator.liroth.client.models.entities.VileSharkModel;
import com.decodinator.liroth.client.models.entities.projectiles.BeamLaserProjectileModel;
import com.decodinator.liroth.client.particles.LirothPortalParticle;
import com.decodinator.liroth.client.rendering.entities.*;
import com.decodinator.liroth.client.rendering.entities.projectiles.BeamLaserProjectileEntityRenderer;
import com.decodinator.liroth.client.rendering.entities.projectiles.LevoArrowRenderer;
import com.decodinator.liroth.client.rendering.skies.ZenithSkybox;
import com.decodinator.liroth.client.screens.LirothSplitterScreen;
import com.decodinator.liroth.client.screens.QuantumExtractorScreen;
import com.decodinator.liroth.core.registry.*;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.fluid.FluidTintSources;
import net.neoforged.api.distmarker.Dist;
@EventBusSubscriber(modid = Liroth.MOD_ID, value = Dist.CLIENT)
public class LirothClient {

    static {
        ZenithSkybox.register();
    }

    @SubscribeEvent
    private static void registerFluidModels(RegisterFluidModelsEvent event) {
        event.register(
                new FluidModel.Unbaked(
                        new Material(LirothFluids.LIROTH_FLUID_STILL_PROP),
                        new Material(LirothFluids.LIROTH_FLUID_FLOWING_PROP),
                        null,
                        FluidTintSources.constant(0x99FFFFFF)),
                LirothFluids.LIROTH_FLUID,
                LirothFluids.FLOWING_LIROTH_FLUID);
        event.register(
                new FluidModel.Unbaked(
                        new Material(LirothFluids.MOLTEN_SPINERIOS_STILL_PROP),
                        new Material(LirothFluids.MOLTEN_SPINERIOS_FLOWING_PROP),
                        null,
                        null),
                LirothFluids.MOLTEN_SPINERIOS,
                LirothFluids.FLOWING_MOLTEN_SPINERIOS);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(LirothMenuTypes.LIROTH_SPLITTER_MENU, LirothSplitterScreen::new);
        event.register(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU, QuantumExtractorScreen::new);
    }

    @SubscribeEvent
    private static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(LirothParticles.GREEN_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.PURPLE_FLAME, FlameParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.CLOAK, EndRodParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.SPORE, AshParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.LIROTH_PORTAL, LirothPortalParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.DAMNATION_PORTAL, LirothPortalParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.JANTIRO_PORTAL, LirothPortalParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.JALSPHIRE_PORTAL, LirothPortalParticle.Provider::new);
        event.registerSpriteSet(LirothParticles.DEVASTATED_PORTAL, LirothPortalParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(LirothEntities.BEAM_LASER_PROJECTILE, BeamLaserProjectileEntityRenderer::new);
        event.registerEntityRenderer(LirothEntities.LEVO_ARROW, LevoArrowRenderer::new);

        event.registerEntityRenderer(LirothEntities.FORSAKEN_CORPSE, ForsakenCorpseRenderer::new);
        event.registerEntityRenderer(LirothEntities.FUNGAL_FIEND, FungalFiendRenderer::new);
        event.registerEntityRenderer(LirothEntities.SKELETAL_FREAK, SkeletalFreakRenderer::new);
        event.registerEntityRenderer(LirothEntities.WARP, WarpRenderer::new);
        event.registerEntityRenderer(LirothEntities.SOUL_ARACHNID, SoulArachnidRenderer::new);
        event.registerEntityRenderer(LirothEntities.PIER_PEEP, PierPeepEntityRenderer::new);
        event.registerEntityRenderer(LirothEntities.SHADE, ShadeEntityRenderer::new);
        event.registerEntityRenderer(LirothEntities.LIROTHIAN_MIMIC, LirothianMimicRenderer::new);
        event.registerEntityRenderer(LirothEntities.PROWLER, ProwlerRenderer::new);
        event.registerEntityRenderer(LirothEntities.FREAKSHOW, FreakshowEntityRenderer::new);
        event.registerEntityRenderer(LirothEntities.VILE_SHARK, VileSharkEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LirothModelLayers.BEAM_LASER_PROJECTILE, BeamLaserProjectileModel::createBodyLayer);
        event.registerLayerDefinition(LirothModelLayers.PIER_PEEP, PierPeepModel::getTexturedModelData);
        event.registerLayerDefinition(LirothModelLayers.SHADE, ShadeModel::getTexturedModelData);
        event.registerLayerDefinition(LirothModelLayers.FREAKSHOW, FreakshowModel::getTexturedModelData);
        event.registerLayerDefinition(LirothModelLayers.VILE_SHARK, VileSharkModel::getTexturedModelData);
    }
}
