package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.registry.LirothParticles;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FungalTorchBlock extends TorchBlock {
    public FungalTorchBlock() {
        super(LirothParticles.GREEN_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).noCollision());
    }
}
