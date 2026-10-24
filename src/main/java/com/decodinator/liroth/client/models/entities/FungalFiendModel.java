package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.FungalFiendEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FungalFiendModel extends DefaultedEntityGeoModel<FungalFiendEntity> {
    public FungalFiendModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend/fungal"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend/fungal_fiend"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "fungal_fiend/fungal"));
    }
}
