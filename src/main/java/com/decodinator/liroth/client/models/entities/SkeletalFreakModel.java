package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SkeletalFreakModel extends DefaultedEntityGeoModel<SkeletalFreakEntity> {
    public SkeletalFreakModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "skeletal_freak/skeletal"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "skeletal_freak/skeletal_freak"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "skeletal_freak/skeletal"));
    }
}
