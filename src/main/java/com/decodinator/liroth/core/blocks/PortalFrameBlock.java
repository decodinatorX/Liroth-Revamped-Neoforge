package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.registry.LirothPortalBuilders;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.betterx.bclib.blocks.BaseBlock;

import java.util.function.Supplier;

public class PortalFrameBlock extends BaseBlock {
    private final Supplier<LirothPortalBlock> portal;

    public PortalFrameBlock(BlockBehaviour.Properties properties, Supplier<LirothPortalBlock> portal) {
        super(properties);
        this.portal = portal;
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        super.affectNeighborsAfterRemoval(state, level, pos, movedByPiston);
        LirothPortalBuilders.removePortalForFrame(level, pos, portal.get());
    }
}
