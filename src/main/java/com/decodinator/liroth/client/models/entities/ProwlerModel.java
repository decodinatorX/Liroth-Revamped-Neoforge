package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import com.decodinator.liroth.core.entities.WarpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ProwlerModel extends DefaultedEntityGeoModel<ProwlerEntity> {
    public ProwlerModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "prowler/prowler"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "prowler/prowler"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "prowler/prowler"));
    }
}
