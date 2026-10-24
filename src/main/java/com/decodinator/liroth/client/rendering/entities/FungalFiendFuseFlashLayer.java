package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class FungalFiendFuseFlashLayer extends GeoRenderLayer<FungalFiendEntity> {
    public FungalFiendFuseFlashLayer(GeoEntityRenderer<FungalFiendEntity> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, FungalFiendEntity entity, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        float swell = Mth.clamp(entity.getSwelling(partialTick), 0.0F, 1.0F);
        float flash = (int) (swell * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(swell, 0.5F, 1.0F);
        if (flash <= 0.0F) {
            return;
        }

        RenderType flashType = RenderType.entityTranslucent(getRenderer().getTextureLocation(entity));
        getRenderer().reRender(bakedModel, poseStack, bufferSource, entity, flashType, bufferSource.getBuffer(flashType), partialTick, packedLight, LivingEntityRenderer.getOverlayCoords(entity, flash), 0xFFFFFFFF);
    }
}
