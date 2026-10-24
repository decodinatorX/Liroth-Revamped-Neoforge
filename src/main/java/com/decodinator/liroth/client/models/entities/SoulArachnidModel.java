package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SoulArachnidModel extends DefaultedEntityGeoModel<SoulArachnidEntity> {
    public SoulArachnidModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "soul_arachnid/soul_arachnid"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "soul_arachnid/soul_arachnid"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "soul_arachnid/soul_arachnid"));
    }
}
