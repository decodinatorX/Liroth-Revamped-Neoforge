package com.decodinator.liroth.core.features;

import com.decodinator.liroth.core.registry.LirothBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public final class PointedGleemstoneShardFeature extends PointedJalsphireCrystalFeature {
    public static final MapCodec<PointedGleemstoneShardFeature> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_taller_dripstone")
                            .forGetter(feature -> feature.chanceOfTallerDripstone),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_directional_spread")
                            .forGetter(feature -> feature.chanceOfDirectionalSpread),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius2")
                            .forGetter(feature -> feature.chanceOfSpreadRadius2),
                    Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius3")
                            .forGetter(feature -> feature.chanceOfSpreadRadius3)
            ).apply(instance, PointedGleemstoneShardFeature::new));

    public PointedGleemstoneShardFeature(float chanceOfTallerDripstone, float chanceOfDirectionalSpread,
                                         float chanceOfSpreadRadius2, float chanceOfSpreadRadius3) {
        super(chanceOfTallerDripstone, chanceOfDirectionalSpread, chanceOfSpreadRadius2, chanceOfSpreadRadius3,
                LirothBlocks.POINTED_GLEEMSTONE_SHARD, LirothBlocks.GLEEMSTONE);
    }

    @Override
    public MapCodec<PointedGleemstoneShardFeature> codec() {
        return CODEC;
    }
}
