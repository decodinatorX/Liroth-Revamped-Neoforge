package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class FungalFiendFaceGlowLayer extends GeoRenderLayer<FungalFiendEntity> {
    private static final ResourceLocation FACE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/fungal_fiend/fungal_fiend_face.png");

    public FungalFiendFaceGlowLayer(GeoEntityRenderer<FungalFiendEntity> renderer) {
        super(renderer);
    }

    // this is our little rendering cheat code :3
    @Override
    public void render(PoseStack poseStack, FungalFiendEntity animatable, BakedGeoModel bakedModel,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType faceRenderType = RenderType.entityTranslucentEmissive(FACE_TEXTURE);
        float swell = Mth.clamp(animatable.getSwelling(partialTick), 0.0F, 1.0F);
        int color = getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt();
        int alpha = Mth.floor((0.35F + swell * 0.35F) * 255.0F);
        color = (color & 0x00FFFFFF) | (alpha << 24);
        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, faceRenderType,
                bufferSource.getBuffer(faceRenderType), partialTick, 15728640, packedOverlay,
                color);
    }
}
