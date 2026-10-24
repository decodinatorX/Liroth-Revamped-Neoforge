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
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = Liroth.MOD_ID, value = Dist.CLIENT)
public class LirothClient {

    static {
        ZenithSkybox.register();
    }

    @SubscribeEvent
    private static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return LirothFluids.LIROTH_FLUID_STILL_PROP;
            }
            @Override
            public ResourceLocation getFlowingTexture() {
                return LirothFluids.LIROTH_FLUID_FLOWING_PROP;
            }
            @Override
            public int getTintColor() {
                return 0x99FFFFFF;
            }
        }, LirothFluids.LIROTH_FLUID_TYPE);

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return LirothFluids.MOLTEN_SPINERIOS_STILL_PROP;
            }
            @Override
            public ResourceLocation getFlowingTexture() {
                return LirothFluids.MOLTEN_SPINERIOS_FLOWING_PROP;
            }
        }, LirothFluids.MOLTEN_SPINERIOS_TYPE);

        event.registerFluidType(IClientFluidTypeExtensions.of(LirothFluids.LIROTH_FLUID_TYPE), new FluidType(FluidType.Properties.create()));
        event.registerFluidType(IClientFluidTypeExtensions.of(LirothFluids.MOLTEN_SPINERIOS_TYPE), new FluidType(FluidType.Properties.create()));
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            event.register(LirothMenuTypes.LIROTH_SPLITTER_MENU, LirothSplitterScreen::new);
            event.register(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU, QuantumExtractorScreen::new);
        }
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
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.LIROTH_FLUID, RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.FLOWING_LIROTH_FLUID, RenderType.translucent());
        });
        registerLayerDefinitions(ClientHooks::registerLayerDefinition);
    }

    @SubscribeEvent
    private static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
        DimensionSpecialEffects cloudlessOverworld = new CloudlessOverworldEffects();
        event.register(Liroth.C.mk("damnation"), cloudlessOverworld);
        event.register(Liroth.C.mk("jalsphire"), cloudlessOverworld);
        event.register(Liroth.C.mk("devastation"), cloudlessOverworld);
    }

    private static final class CloudlessOverworldEffects extends DimensionSpecialEffects.OverworldEffects {
        @Override
        public boolean renderClouds(ClientLevel level, int ticks, float partialTick, PoseStack poseStack, double camX, double camY, double camZ, Matrix4f modelViewMatrix, Matrix4f projectionMatrix) {
            return true;
        }
    }

    public static void registerLayerDefinitions(final BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        consumer.accept(LirothModelLayers.BEAM_LASER_PROJECTILE, BeamLaserProjectileModel::createBodyLayer);
        consumer.accept(LirothModelLayers.PIER_PEEP, PierPeepModel::getTexturedModelData);
        consumer.accept(LirothModelLayers.SHADE, ShadeModel::getTexturedModelData);
        consumer.accept(LirothModelLayers.FREAKSHOW, FreakshowModel::getTexturedModelData);
        consumer.accept(LirothModelLayers.VILE_SHARK, VileSharkModel::getTexturedModelData);
    }
}
