package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.client.models.entities.VileSharkModel;
import com.decodinator.liroth.core.entities.VileSharkEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VileSharkGlowFeatureRenderer<T extends VileSharkEntity>
        extends EyesLayer<T, VileSharkModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/vile_shark/vile_shark_glow.png"));

    public VileSharkGlowFeatureRenderer(RenderLayerParent<T, VileSharkModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}