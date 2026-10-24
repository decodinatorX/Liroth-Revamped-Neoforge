package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.client.models.entities.PierPeepModel;
import com.decodinator.liroth.core.entities.PierPeepEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PierPeepFaceGlowLayer<T extends PierPeepEntity>
        extends EyesLayer<T, PierPeepModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(ResourceLocation.fromNamespaceAndPath("liroth", "textures/entity/pier_peep/pier_peep_glow.png"));

    public PierPeepFaceGlowLayer(RenderLayerParent<T, PierPeepModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

