package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.registry.LirothParticles;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LirothianPetroleumTorchBlock extends TorchBlock {
    public LirothianPetroleumTorchBlock() {
        super(LirothParticles.PURPLE_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).noCollision());
    }
}
