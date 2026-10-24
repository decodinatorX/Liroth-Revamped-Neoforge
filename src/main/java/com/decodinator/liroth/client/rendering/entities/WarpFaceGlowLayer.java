package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.decodinator.liroth.core.entities.WarpEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class WarpFaceGlowLayer extends GeoRenderLayer<WarpEntity> {
    private static final ResourceLocation FACE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/warp/warp_glow.png");

    public WarpFaceGlowLayer(GeoEntityRenderer<WarpEntity> renderer) {
        super(renderer);
    }

    // this is our little rendering cheat code :3
    @Override
    public void render(PoseStack poseStack, WarpEntity animatable, BakedGeoModel bakedModel,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType faceRenderType = RenderType.entityTranslucentEmissive(FACE_TEXTURE);
        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, faceRenderType,
                bufferSource.getBuffer(faceRenderType), partialTick, 15728640, packedOverlay,
                getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
    }
}
