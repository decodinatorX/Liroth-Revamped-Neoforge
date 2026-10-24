package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothItems;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.ItemTagBootstrapContext;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

public class LirothItemTagDataProvider extends WoverTagProvider.ForItems {
    public LirothItemTagDataProvider(ModCore core) {
        super(core);
    }

    @Override
    public void prepareTags(ItemTagBootstrapContext context) {
        context.add(ItemTags.ARROWS, LirothItems.LEVO_ARROW);

        context.add(LirothTags.TORCHES, Items.TORCH);
        context.add(LirothTags.TORCHES, Items.SOUL_TORCH);
        context.add(LirothTags.TORCHES, Items.REDSTONE_TORCH);
        context.add(LirothTags.TORCHES, LirothBlocks.FUNGAL_TORCH.asItem());
        context.add(LirothTags.TORCHES, LirothBlocks.LIROTHIAN_PETROLEUM_TORCH.asItem());

        context.add(ItemTags.SAPLINGS, LirothBlocks.TALLPIER_SAPLING.asItem());
        context.add(ItemTags.SAPLINGS, LirothBlocks.SPICED_SAPLING.asItem());
        context.add(ItemTags.SAPLINGS, LirothBlocks.LIROTH_SAPLING.asItem());
        context.add(ItemTags.SAPLINGS, LirothBlocks.KOOLAW_SAPLING.asItem());
        context.add(ItemTags.SAPLINGS, LirothBlocks.JAPZ_SAPLING.asItem());
        context.add(ItemTags.SAPLINGS, LirothBlocks.DAMNATION_SAPLING.asItem());

        context.add(ItemTags.COALS, LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK.asItem());
        context.add(ItemTags.COALS, LirothItems.LIROTHIAN_PETROLEUM);

        context.add(ItemTags.FLOWERS, LirothBlocks.LIROTH_ROSE.asItem());
        context.add(ItemTags.FLOWERS, LirothBlocks.WILITING_LIROTH_ROSE.asItem());

        context.add(ItemTags.WOLF_FOOD, LirothItems.BLOODY_ENTRAILS);

        context.add(ItemTags.ANVIL, LirothBlocks.LIROTHIAN_COBALT.anvilBlock.asItem());

        context.add(Tags.Items.FOODS_BERRY, LirothItems.LIROTH_BERRY);

        context.add(Tags.Items.GEMS, LirothItems.JALSPHIRE_GEM);
        context.add(Tags.Items.GEMS, LirothBlocks.LIROTH_GEM.ingot);
        context.add(Tags.Items.GEMS, LirothBlocks.RUBY.ingot);

        context.add(Tags.Items.FOODS_BREAD, LirothItems.LIROTH_COATED_BREAD);

        context.add(Tags.Items.MUSIC_DISCS, LirothItems.DAMNATION_MUSIC_DISC);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.DESOLATION_MUSIC_DIST);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.ESCAPE_MUSIC_DISC);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.LIROTH_MUSIC_DISC);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.PIER_MUSIC_DISC);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.SPICED_MUSIC_DISC);
        context.add(Tags.Items.MUSIC_DISCS, LirothItems.SPITE_MUSIC_DISC);

        context.add(Tags.Items.NETHERRACKS, LirothBlocks.NETHER_LIROTH_GEM_ORE);
    }
}
