package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class ProwlerFaceGlowLayer extends GeoRenderLayer<ProwlerEntity> {
    private static final ResourceLocation FACE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/prowler/prowler_glow.png");

    public ProwlerFaceGlowLayer(GeoEntityRenderer<ProwlerEntity> renderer) {
        super(renderer);
    }

    // this is our little rendering cheat code :3
    @Override
    public void render(PoseStack poseStack, ProwlerEntity animatable, BakedGeoModel bakedModel,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType faceRenderType = RenderType.entityTranslucentEmissive(FACE_TEXTURE);
        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, faceRenderType,
                bufferSource.getBuffer(faceRenderType), partialTick, 15728640, packedOverlay,
                getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
    }
}
