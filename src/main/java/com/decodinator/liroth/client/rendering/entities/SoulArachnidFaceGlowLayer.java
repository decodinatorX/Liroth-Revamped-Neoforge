package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SoulArachnidFaceGlowLayer extends GeoRenderLayer<SoulArachnidEntity> {
    private static final ResourceLocation FACE_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/soul_arachnid/soul_arachnid_glow.png");

    public SoulArachnidFaceGlowLayer(GeoEntityRenderer<SoulArachnidEntity> renderer) {
        super(renderer);
    }

    // this is our little rendering cheat code :3
    @Override
    public void render(PoseStack poseStack, SoulArachnidEntity animatable, BakedGeoModel bakedModel,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType faceRenderType = RenderType.entityTranslucentEmissive(FACE_TEXTURE);
        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, faceRenderType,
                bufferSource.getBuffer(faceRenderType), partialTick, 15728640, packedOverlay,
                getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
    }
}
