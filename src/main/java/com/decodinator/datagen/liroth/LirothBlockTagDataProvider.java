package com.decodinator.datagen.liroth;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.registry.LirothBlocks;
import com.decodinator.liroth.core.registry.LirothTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import org.betterx.wover.core.api.ModCore;
import org.betterx.wover.datagen.api.WoverTagProvider;
import org.betterx.wover.tag.api.event.context.TagBootstrapContext;

public class LirothBlockTagDataProvider extends WoverTagProvider.ForBlocks {
    public LirothBlockTagDataProvider(ModCore core) {
        super(core);
    }

    @Override
    public void prepareTags(TagBootstrapContext<Block> context) {
        context.add(LirothTags.DIRT_ORE_REPLACEABLES, LirothBlocks.SPINERIOS_DIRT);
        context.add(LirothTags.DIRT_ORE_REPLACEABLES, LirothBlocks.SOULLESS_SOIL);

        context.add(LirothTags.LIROTH_FARMLANDS, LirothBlocks.LIROTH_FARMLAND_BLOCK);
        context.add(LirothTags.LIROTH_FARMLANDS, LirothBlocks.PIER_FARMLAND_BLOCK);
        context.add(LirothTags.LIROTH_FARMLANDS, LirothBlocks.SPINERIOS_FARMLAND_BLOCK);

        context.add(BlockTags.SAPLINGS, LirothBlocks.LIROTH_SAPLING);
        context.add(BlockTags.SAPLINGS, LirothBlocks.SPICED_SAPLING);
        context.add(BlockTags.SAPLINGS, LirothBlocks.TALLPIER_SAPLING);
        context.add(BlockTags.SAPLINGS, LirothBlocks.DAMNATION_SAPLING);
        context.add(BlockTags.SAPLINGS, LirothBlocks.JAPZ_SAPLING);
        context.add(BlockTags.SAPLINGS, LirothBlocks.KOOLAW_SAPLING);

        context.add(BlockTags.LEAVES, LirothBlocks.DAMNATION_LEAVES);
        context.add(BlockTags.LEAVES, LirothBlocks.JAPZ_LEAVES);
        context.add(BlockTags.LEAVES, LirothBlocks.KOOLAW_LEAVES);
        context.add(BlockTags.LEAVES, LirothBlocks.LIROTH_LEAVES);
        context.add(BlockTags.LEAVES, LirothBlocks.SPICED_LEAVES);
        context.add(BlockTags.LEAVES, LirothBlocks.TALLPIER_LEAVES);

        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_LEAVES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_LEAVES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.KOOLAW_LEAVES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.LIROTH_LEAVES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.SPICED_LEAVES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.TALLPIER_LEAVES);

        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_DAMNATION_FUNGAL_CLUSTER);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_DAMNATION_FUNGUS);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_DAMNATION_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_JAPZ_MINI_TREE);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_JAPZ_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_KOOLAW_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_LIROTH_ROSE);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_LIROTH_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_SPICED_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_TALLPIER_SAPLING);
        context.add(BlockTags.FLOWER_POTS, LirothBlocks.POTTED_WILITING_LIROTH_ROSE);

        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.CHARRED_ACCESSWAY_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DAMNATION_PORTAL_FRAME);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DEVASTATED_PORTAL_FRAME);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JANTIRO_PORTAL_FRAME);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.CHARRED_LIROTH_GEM_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.CHARRED_LIROTH_STONE_BRICK_LOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.CHARRED_LIROTHIAN_COBALT_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.CHARRED_LIROTHIAN_PETROLEUM_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DAMNED_PASSAGEWAY);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DEEPSLATE_LIROTH_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DEEPSLATE_TOURMALINE_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.DIMENSIONAL_COMMUNICATOR);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.END_LIROTH_GEM_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.FUNGAL_LANTERN);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.GATEWAY_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.GLEEMSTONE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.HAUNTED_THROUGHFARE_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_PORTAL_FRAME);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_GEM_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_ORE_STONE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_ORE_DEEPSLATE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.JALSPHIRE_TRACKWAY);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_JAPZ_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.NETHER_LIROTH_GEM_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_LIROTH_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTH_BONE_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTH_PORTAL_FRAME);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTH_GEM_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTH_GLASS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTHIAN_LIROTH_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_LIROTH_ROSE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTH_SPLITTER);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTHIAN_COBALT.pressurePlate);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTHIAN_PETROLEUM_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.LIROTHIAN_PETROLEUM_LANTERN);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.OLDEN_LIROTH_GEM_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.PETRIFIED_DAMNATION_BRICKS);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.PETRIFIED_DAMNATION_BRICK_STAIRS);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.PETRIFIED_DAMNATION_BRICK_SLAB);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.PETRIFIED_DAMNATION_BRICK_WALL);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.PETRIFIED_CRYSTAL_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POINTED_JALSPHIRE_CRYSTAL);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POINTED_PETRIFIED_CRYSTAL);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTESTIUM_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTESTIUM_PLATE_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.QUANTUM_EXTRACTOR);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.QUANTUM_PLATE_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.SOUL_ROD);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.SPINERIOS_ANCIENT_DEBRIS);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.SPINERIOS_STONE_TOURMALINE_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_SPICED_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_TALLPIER_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.TOURMALINE_ORE);
        context.add(BlockTags.MINEABLE_WITH_PICKAXE, LirothBlocks.POTTED_WILITING_LIROTH_ROSE);

        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.BLUE_SAND);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.DAMNATION_SOIL);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.LIROTH_DIRT);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.LIROTH_GRASS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.LIROTH_FARMLAND_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.LIROTH_PATH_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.LIROTH_SOUL_SAND);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.PIER_DIRT);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.PIER_GRASS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.PIER_GRASS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.PIER_FARMLAND_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.PIER_PATH_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.POTESTIUM_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.QUANTUM_DIAMOND_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.RUBY.ore);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.QUANTUM_DIAMOND_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SOULLESS_SOIL);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_COAL_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_COPPER_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_DIAMOND_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_DIRT);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_EMERALD_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_FARMLAND_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_GOLD_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_GRASS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_IRON_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_LAPIS_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_LIROTH_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_PATH_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_QUARTZ_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_REDSTONE_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_STONE_ORE);
        context.add(BlockTags.MINEABLE_WITH_SHOVEL, LirothBlocks.SPINERIOS_TOURMALINE_ORE);

        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_FUNGAL_CLUSTER);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_FUNGUS);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_FUNGAL_FUSS);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_FUNGAL_PATCH);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_FUNGAL_HEAP);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_WART_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_VINES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DAMNATION_VINES_PLANT);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.DEAD_SEA_EYE);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.FUNGAL_LIGHT);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.HILIGHT);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_BLOSSOM);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_MINI_TREE);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_MOSS);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_MOSS_CARPET);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_VINES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.JAPZ_VINES_PLANT);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.KOOLAW_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.LIROTH_ROSE);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.PETRIFIED_MOSS_BLOCK);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.PETRIFIED_MOSS_CARPET);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.PETRIFIED_VINES);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.PETRIFIED_VINES_PLANT);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.SEA_EYE);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.SPICED_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.TALLPIER_SAPLING);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.VILE_TENTACLE);
        context.add(BlockTags.MINEABLE_WITH_HOE, LirothBlocks.VILE_TENTACLE_TIP);

        context.add(BlockTags.MINEABLE_WITH_AXE, LirothBlocks.FUNGAL_CAMPFIRE);
        context.add(BlockTags.MINEABLE_WITH_AXE, LirothBlocks.FUNGAL_TORCH);
        context.add(BlockTags.MINEABLE_WITH_AXE, LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE);
        context.add(BlockTags.MINEABLE_WITH_AXE, LirothBlocks.LIROTHIAN_PETROLEUM_TORCH);

        context.add(BlockTags.DIRT, LirothBlocks.LIROTH_DIRT);
        context.add(BlockTags.DIRT, LirothBlocks.PIER_DIRT);
        context.add(BlockTags.DIRT, LirothBlocks.SPINERIOS_DIRT);
        context.add(BlockTags.DIRT, LirothBlocks.LIROTH_SOUL_SAND);
        context.add(BlockTags.DIRT, LirothBlocks.LIROTH_GRASS_BLOCK);
        context.add(BlockTags.DIRT, LirothBlocks.PIER_GRASS_BLOCK);
        context.add(BlockTags.DIRT, LirothBlocks.SPINERIOS_GRASS_BLOCK);
        context.add(BlockTags.DIRT, LirothBlocks.DAMNATION_SOIL);
        context.add(BlockTags.DIRT, LirothBlocks.SOULLESS_SOIL);

        context.add(BlockTags.ANVIL, LirothBlocks.LIROTHIAN_COBALT.anvilBlock);

        context.add(BlockTags.COAL_ORES, LirothBlocks.SPINERIOS_COAL_ORE);
        context.add(BlockTags.COPPER_ORES, LirothBlocks.SPINERIOS_COPPER_ORE);
        context.add(BlockTags.DIAMOND_ORES, LirothBlocks.SPINERIOS_DIAMOND_ORE);
        context.add(BlockTags.EMERALD_ORES, LirothBlocks.SPINERIOS_EMERALD_ORE);
        context.add(BlockTags.GOLD_ORES, LirothBlocks.SPINERIOS_GOLD_ORE);
        context.add(BlockTags.IRON_ORES, LirothBlocks.SPINERIOS_IRON_ORE);
        context.add(BlockTags.LAPIS_ORES, LirothBlocks.SPINERIOS_LAPIS_ORE);
        context.add(BlockTags.REDSTONE_ORES, LirothBlocks.SPINERIOS_REDSTONE_ORE);

        context.add(BlockTags.FLOWERS, LirothBlocks.LIROTH_ROSE);
        context.add(BlockTags.FLOWERS, LirothBlocks.WILITING_LIROTH_ROSE);

        context.add(BlockTags.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.DEEPSLATE_TOURMALINE_ORE);
        context.add(BlockTags.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.DEEPSLATE_LIROTH_ORE);

        context.add(BlockTags.GUARDED_BY_PIGLINS, LirothBlocks.TOURMALINE.block);

        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.LIROTH_GEM.ore);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.CHARRED_LIROTH_GEM_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.DEEPSLATE_LIROTH_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.NETHER_LIROTH_GEM_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.END_LIROTH_GEM_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.TOURMALINE_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.DEEPSLATE_TOURMALINE_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.SPINERIOS_TOURMALINE_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.SPINERIOS_STONE_TOURMALINE_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.SPINERIOS_LIROTH_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.SPINERIOS_ANCIENT_DEBRIS);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.QUANTUM_DIAMOND_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.POTESTIUM_ORE);

        context.add(BlockTags.NEEDS_IRON_TOOL, LirothBlocks.SPINERIOS_REDSTONE_ORE);
        context.add(BlockTags.NEEDS_IRON_TOOL, LirothBlocks.SPINERIOS_GOLD_ORE);
        context.add(BlockTags.NEEDS_IRON_TOOL, LirothBlocks.SPINERIOS_DIAMOND_ORE);
        context.add(BlockTags.NEEDS_IRON_TOOL, LirothBlocks.SPINERIOS_EMERALD_ORE);

        context.add(BlockTags.NEEDS_STONE_TOOL, LirothBlocks.SPINERIOS_LAPIS_ORE);
        context.add(BlockTags.NEEDS_STONE_TOOL, LirothBlocks.SPINERIOS_COPPER_ORE);
        context.add(BlockTags.NEEDS_STONE_TOOL, LirothBlocks.SPINERIOS_QUARTZ_ORE);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.LIROTH_PORTAL_FRAME);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.DAMNATION_PORTAL_FRAME);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.JANTIRO_PORTAL_FRAME);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.JALSPHIRE_PORTAL_FRAME);
        context.add(BlockTags.NEEDS_DIAMOND_TOOL, LirothBlocks.DEVASTATED_PORTAL_FRAME);

        context.add(BlockTags.MAINTAINS_FARMLAND, LirothBlocks.SPINERIOS_FARMLAND_BLOCK);
        context.add(BlockTags.MAINTAINS_FARMLAND, LirothBlocks.PIER_FARMLAND_BLOCK);
        context.add(BlockTags.MAINTAINS_FARMLAND, LirothBlocks.LIROTH_FARMLAND_BLOCK);

        context.add(BlockTags.PORTALS, LirothBlocks.DAMNATION_DIMENSION_PORTAL);
        context.add(BlockTags.PORTALS, LirothBlocks.DEVASTATED_DIMENSION_PORTAL);
        context.add(BlockTags.PORTALS, LirothBlocks.JALSPHIRE_DIMENSION_PORTAL);
        context.add(BlockTags.PORTALS, LirothBlocks.JANTIRO_DIMENSION_PORTAL);
        context.add(BlockTags.PORTALS, LirothBlocks.LIROTH_DIMENSION_PORTAL);

        context.add(BlockTags.SAND, LirothBlocks.BLUE_SAND);

        context.add(BlockTags.SOUL_SPEED_BLOCKS, LirothBlocks.LIROTH_SOUL_SAND);
        context.add(BlockTags.SOUL_SPEED_BLOCKS, LirothBlocks.SOULLESS_SOIL);

        context.add(BlockTags.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.CHARRED_LIROTH_STONE.stone);
        context.add(BlockTags.STONE_ORE_REPLACEABLES, LirothBlocks.LIROTH_STONE.stone);
        context.add(BlockTags.STONE_ORE_REPLACEABLES, LirothBlocks.SPINERIOS_STONE.stone);

        context.add(BlockTags.DRIPSTONE_REPLACEABLE, LirothBlocks.SPINERIOS_STONE.stone);
        context.add(BlockTags.DRIPSTONE_REPLACEABLE, LirothBlocks.LIROTH_STONE.stone);
        context.add(BlockTags.DRIPSTONE_REPLACEABLE, LirothBlocks.CHARRED_LIROTH_STONE.stone);

        context.add(BlockTags.WALLS, LirothBlocks.PETRIFIED_DAMNATION_BRICK_WALL);

        context.add(Tags.Blocks.COBBLESTONES, LirothBlocks.LIROTH_COBBLESTONE.stone);
        context.add(Tags.Blocks.COBBLESTONES, LirothBlocks.SPINERIOS_COBBLESTONE.stone);
        context.add(Tags.Blocks.COBBLESTONES, LirothBlocks.CHARRED_LIROTH.stone);

        context.add(Tags.Blocks.END_STONES, LirothBlocks.END_LIROTH_GEM_ORE);

        context.add(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, LirothBlocks.DEEPSLATE_TOURMALINE_ORE);
        context.add(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, LirothBlocks.DEEPSLATE_LIROTH_ORE);

        context.add(Tags.Blocks.ORES_IN_GROUND_NETHERRACK, LirothBlocks.NETHER_LIROTH_GEM_ORE);

        context.add(Tags.Blocks.ORES_IN_GROUND_STONE, LirothBlocks.LIROTH_GEM.ore);
        context.add(Tags.Blocks.ORES_IN_GROUND_STONE, LirothBlocks.TOURMALINE.ore);
        context.add(Tags.Blocks.ORES_IN_GROUND_STONE, LirothBlocks.TOURMALINE_ORE);
    }
}
