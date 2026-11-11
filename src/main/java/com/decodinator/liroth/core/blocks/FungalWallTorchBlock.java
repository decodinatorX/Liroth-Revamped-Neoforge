package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.registry.LirothParticles;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FungalWallTorchBlock extends WallTorchBlock {
    public FungalWallTorchBlock() {
        super(LirothParticles.GREEN_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).noCollision());
    }
}
