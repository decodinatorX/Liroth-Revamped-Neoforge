package com.decodinator.liroth.core.world.structures.village;

import com.decodinator.liroth.Liroth;
import org.betterx.wover.feature.api.placed.PlacedFeatureKey;
import org.betterx.wover.feature.api.placed.PlacedFeatureManager;
import org.betterx.wover.structure.api.StructureKeys;
import org.betterx.wover.structure.api.pools.StructurePoolKey;

public class VillagePools {
//    public static final PlacedFeatureKey JAPZ_VILLAGE = PlacedFeatureManager.createKey(Liroth.C.mk("village_japz"));

    public static StructurePoolKey TERMINATORS_KEY = StructureKeys.pool(Liroth.C.mk("village/terminators"));
    public static StructurePoolKey START = StructureKeys.pool(Liroth.C.mk("village/center_piece"));
    public static StructurePoolKey HOUSES_KEY = StructureKeys.pool(Liroth.C.mk("village/houses"));
    public static StructurePoolKey STREET_KEY = StructureKeys.pool(Liroth.C.mk("village/streets"));
    public static StructurePoolKey STREET_DECO_KEY = StructureKeys.pool(Liroth.C.mk("village/street_decorations"));
    public static StructurePoolKey DECORATIONS_KEY = StructureKeys.pool(Liroth.C.mk("village/decorations"));
}