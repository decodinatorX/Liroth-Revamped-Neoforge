package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.WarpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class WarpModel extends DefaultedEntityGeoModel<WarpEntity> {
    public WarpModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp/warp"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp/warp"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "warp/warp"));
    }
}
