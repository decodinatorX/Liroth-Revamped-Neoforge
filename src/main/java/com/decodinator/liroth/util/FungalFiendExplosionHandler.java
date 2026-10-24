package com.decodinator.liroth.util;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.decodinator.liroth.core.registry.LirothBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ExplosionEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = Liroth.MOD_ID)
public final class FungalFiendExplosionHandler {
    private FungalFiendExplosionHandler() {}

    @SubscribeEvent
    public static void onFungalFiendExplosion(ExplosionEvent.Detonate event) {
        if (!(event.getExplosion().getDirectSourceEntity() instanceof FungalFiendEntity) || event.getLevel().isClientSide) {
            return;
        }

        Level level = event.getLevel();
        Set<BlockPos> blastBlocks = new HashSet<>(event.getAffectedBlocks());
        Set<BlockPos> exposedBlocks = new HashSet<>();
        for (BlockPos blastPos : blastBlocks) {
            for (Direction direction : Direction.values()) {
                BlockPos neighbor = blastPos.relative(direction);
                if (!blastBlocks.contains(neighbor)) {
                    exposedBlocks.add(neighbor);
                }
            }
        }

        for (BlockPos pos : exposedBlocks) {
            var state = level.getBlockState(pos);
            if (!state.isAir() && state.isSolid()) {
                level.setBlock(pos, LirothBlocks.DAMNATION_SOIL.defaultBlockState(), 3);
            }
        }
    }
}
