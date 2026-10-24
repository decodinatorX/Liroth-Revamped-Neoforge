package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.client.models.entities.ForsakenCorpseModel;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ForsakenCorpseRenderer extends GeoEntityRenderer<ForsakenCorpseEntity> {
    public ForsakenCorpseRenderer(EntityRendererProvider.Context render) {
        super(render, new ForsakenCorpseModel());
        addRenderLayer(new ForsakenCorpseFaceGlowLayer(this));
    }
}
