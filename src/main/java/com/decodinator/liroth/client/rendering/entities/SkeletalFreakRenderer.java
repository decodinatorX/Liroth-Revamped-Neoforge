package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.client.models.entities.ForsakenCorpseModel;
import com.decodinator.liroth.client.models.entities.SkeletalFreakModel;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SkeletalFreakRenderer extends GeoEntityRenderer<SkeletalFreakEntity> {
    public SkeletalFreakRenderer(EntityRendererProvider.Context render) {
        super(render, new SkeletalFreakModel());
        addRenderLayer(new SkeletalFreakFaceGlowLayer(this));
    }
}
