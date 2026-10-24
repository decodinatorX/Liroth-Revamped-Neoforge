package com.decodinator.liroth.core.blocks;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.function.Supplier;

public class CustomPathBlock extends DirtPathBlock {
    private final Supplier<Block> dirtBlock;
    private final Supplier<Block> farmland;

    public CustomPathBlock(BlockBehaviour.Properties settings, Supplier<Block> dirtBlock, Supplier<Block> farmland) {
        super(settings);
        this.dirtBlock = dirtBlock;
        this.farmland = farmland;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos())
                ? Block.pushEntitiesUp(this.defaultBlockState(), dirtBlock.get().defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos())
                : super.getStateForPlacement(p_153131_);
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == ItemAbilities.HOE_TILL) {
            return farmland.get().defaultBlockState();
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
