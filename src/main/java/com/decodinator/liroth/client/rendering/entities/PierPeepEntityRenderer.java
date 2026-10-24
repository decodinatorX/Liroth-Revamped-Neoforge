package com.decodinator.liroth.client.rendering.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.client.models.entities.PierPeepModel;
import com.decodinator.liroth.core.entities.PierPeepEntity;
import com.decodinator.liroth.core.registry.LirothModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PierPeepEntityRenderer extends MobRenderer<PierPeepEntity, PierPeepModel<PierPeepEntity>> {

    public PierPeepEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new PierPeepModel<>(context.bakeLayer(LirothModelLayers.PIER_PEEP)), 0.5f);
        this.addLayer(new PierPeepFaceGlowLayer<PierPeepEntity>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(PierPeepEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "textures/entity/pier_peep/pier_peep.png");
    }
}
