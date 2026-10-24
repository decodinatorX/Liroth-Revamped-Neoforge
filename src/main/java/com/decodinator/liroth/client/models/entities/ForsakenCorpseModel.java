package com.decodinator.liroth.client.models.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ForsakenCorpseModel extends DefaultedEntityGeoModel<ForsakenCorpseEntity> {
    public ForsakenCorpseModel() {
        super(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "forsaken_corpse/corpse"), true);
        withAltTexture(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "forsaken_corpse/forsaken_corpse"));
        withAltAnimations(ResourceLocation.fromNamespaceAndPath(Liroth.MOD_ID, "forsaken_corpse/forsaken"));
    }
}
