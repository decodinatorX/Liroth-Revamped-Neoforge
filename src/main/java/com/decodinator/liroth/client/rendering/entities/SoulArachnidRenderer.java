package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.client.models.entities.SkeletalFreakModel;
import com.decodinator.liroth.client.models.entities.SoulArachnidModel;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoulArachnidRenderer extends GeoEntityRenderer<SoulArachnidEntity> {
    public SoulArachnidRenderer(EntityRendererProvider.Context render) {
        super(render, new SoulArachnidModel());
        addRenderLayer(new SoulArachnidFaceGlowLayer(this));
    }
}
