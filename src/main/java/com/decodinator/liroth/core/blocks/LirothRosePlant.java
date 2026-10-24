package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.Tags;
import org.betterx.bclib.behaviours.interfaces.BehaviourPlant;

public class LirothRosePlant extends BlockCommonPlant implements BehaviourPlant {
    public LirothRosePlant(MapColor color) {
        super(color);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState belowBlockState = world.getBlockState(blockpos);
        net.neoforged.neoforge.common.util.TriState soilDecision = belowBlockState.canSustainPlant(world, blockpos, Direction.UP, state);
        if (!soilDecision.isDefault()) return soilDecision.isTrue();
        return this.mayPlaceOn(belowBlockState, world, blockpos);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.is(Tags.Blocks.VILLAGER_FARMLANDS) || state.is(LirothTags.LIROTH_FARMLANDS);
    }
}
