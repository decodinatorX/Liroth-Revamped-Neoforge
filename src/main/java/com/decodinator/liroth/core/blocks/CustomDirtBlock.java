package com.decodinator.liroth.core.blocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.betterx.bclib.blocks.BaseBlock;

import java.util.function.Supplier;

public class CustomDirtBlock extends BaseBlock {
    private static final ItemAbility HOE_TILL = ItemAbility.get("hoe_till");
    private static final ItemAbility SHOVEL_FLATTEN = ItemAbility.get("shovel_flatten");
    private final Supplier<Block> farmland;
    private final Supplier<Block> path;

    public CustomDirtBlock(BlockBehaviour.Properties properties, Supplier<Block> farmland, Supplier<Block> path) {
        super(properties);
        this.farmland = farmland;
        this.path = path;
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (itemAbility == HOE_TILL) {
            return farmland.get().defaultBlockState();
        }
        if (itemAbility == SHOVEL_FLATTEN) {
            return path.get().defaultBlockState();
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
