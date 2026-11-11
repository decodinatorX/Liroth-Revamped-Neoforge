package com.decodinator.liroth.core.registry;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.items.*;
import com.decodinator.liroth.core.items.material.LirothArmorMaterial;
import com.decodinator.liroth.core.items.material.LirothToolMaterial;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import org.betterx.bclib.api.v2.ComposterAPI;
import org.betterx.bclib.behaviours.BehaviourBuilders;
import org.betterx.bclib.items.BaseDiscItem;
import org.betterx.bclib.items.BaseSpawnEggItem;
import org.betterx.bclib.items.ModelProviderItem;
import org.betterx.bclib.models.RecordItemModelProvider;
import org.betterx.wover.item.api.ItemRegistry;
import org.betterx.wover.tag.api.predefined.CommonItemTags;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LirothItems {
    public static List<Item> ITEMS = new ArrayList<>();
    public static List<Item> EQUIPMENT = new ArrayList<>();
    public static List<Item> ENTITIES = new ArrayList<>();
    private static final List<CompostableFood> COMPOSTABLE_FOODS = new ArrayList<>();

    private static ItemRegistry ITEMS_REGISTRY;

    private record CompostableFood(Item item, float chance) {}

    public final static Item ANOMALY_CHARGE = registerItem("anomaly_charge");

    public final static Item BLOODY_ENTRAILS = registerFood("bloody_entrails", Foods.ROTTEN_FLESH);

    public final static Item COOL_BEAM = registerArmorItem("cool_beam", BeamItem::new);

    public final static Item DAMNATION_CHARGE = registerItem("damnation_charge");

    public final static Item DAMNATION_FUNGAL_CLUSTER = registerBlockItem(LirothBlocks.DAMNATION_FUNGAL_CLUSTER, "damnation_fungal_cluster", new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_BLAZE_ROD));
    public final static Item DAMNATION_FUNGUS = registerBlockItem(LirothBlocks.DAMNATION_FUNGUS, "damnation_fungus", new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_COAL));

    public final static Item EMBUED_LIROTH_GEM = registerItem("embued_liroth_gem");

    public final static Item GLEEMSTONE_DUST = registerItem("gleemstone_dust");

    public final static Item JALSPHIRE_CHARGE = registerItem("jalsphire_charge");
    public final static Item JALSPHIRE_DUST = registerItem("jalsphire_dust");
    public final static Item JALSPHIRE_DUST_HEAP = registerItem("jalsphire_dust_heap");
    public final static Item JALSPHIRE_GEM = registerItem("jalsphire_gem");

    public final static Item JANTIRO_CHARGE = registerItem("jantiro_charge");

    public final static Item LEVO_ARROW = registerItem("levo_arrow", LevoArrowItem::new);

    public final static Item LIROTH_CHARGE = registerItem("liroth_charge");

    public final static Item LIROTH_BERRY = registerFood("liroth_berry", Foods.SWEET_BERRIES);

    public final static Item LIROTH_BLASTER = registerArmorItem("liroth_blaster", () -> new LirothBlaster(new Item.Properties().stacksTo(1)));

    public final static Item LIROTH_BONE = registerItem("liroth_bone");

    public final static Item LIROTH_COATED_BREAD = registerFood("liroth_coated_bread", Foods.ENCHANTED_GOLDEN_APPLE);

    public final static Item LIROTH_DUST_ANSALUM = registerItem("liroth_dust_ansalum");
    public final static Item LIROTH_DUST_LUX = registerItem("liroth_dust_lux");
    public final static Item LIROTH_DUST_SALEM = registerItem("liroth_dust_salem");

    public final static Item LIROTHIAN_DUNGEON_KEY = registerItem("lirothian_dungeon_key", LirothKeyItem::new);

    public final static Item LIROTHIAN_COBALT_HORSE_ARMOR = registerArmorItem("lirothian_cobalt_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.LIROTHIAN_COBALT.value())));
    public final static Item LIROTH_HORSE_ARMOR = registerArmorItem("liroth_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.LIROTH.value())));
    public final static Item QUANTUM_HORSE_ARMOR = registerArmorItem("quantum_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.QUANTUM_LIROTH.value())));
    public final static Item RUBY_HORSE_ARMOR = registerArmorItem("ruby_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.RUBY.value())));
    public final static Item POTESTIUM_HORSE_ARMOR = registerArmorItem("potestium_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.POTESTIUM_LIROTH.value())));
    public final static Item TOURMALINE_HORSE_ARMOR = registerArmorItem("tourmaline_horse_armor", () -> new Item(new Item.Properties().horseArmor(LirothArmorMaterial.TOURMALINE.value())));
//    public final static Item NETHERITE_HORSE_ARMOR = registerArmorItem("netherite_horse_armor", () -> new Item(new Item.Properties().horseArmor(ArmorMaterials.NETHERITE)));
    public final static Item LIROTH_NAUTILUS_ARMOR = registerArmorItem("liroth_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.LIROTH.value())));
    public final static Item LIROTHIAN_COBALT_NAUTILUS_ARMOR = registerArmorItem("lirothian_cobalt_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.LIROTHIAN_COBALT.value())));
//    public final static Item LIROTH_GEM_ANSALUM_NAUTILUS_ARMOR = registerArmorItem("liroth_gem_ansalum_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.LIROTH_ANSALUM.value())));
//    public final static Item LIROTH_GEM_LUX_NAUTILUS_ARMOR = registerArmorItem("liroth_gem_lux_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.LIROTH_LUX.value())));
//    public final static Item LIROTH_GEM_SALEM_NAUTILUS_ARMOR = registerArmorItem("liroth_gem_salem_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.LIROTH_SALEM.value())));
    public final static Item TOURMALINE_NAUTILUS_ARMOR = registerArmorItem("tourmaline_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.TOURMALINE.value())));
    public final static Item RUBY_NAUTILUS_ARMOR = registerArmorItem("ruby_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.RUBY.value())));
    public final static Item QUANTUM_LIROTH_NAUTILUS_ARMOR = registerArmorItem("quantum_liroth_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.QUANTUM_LIROTH.value())));
    public final static Item POTESTIUM_LIROTH_NAUTILUS_ARMOR = registerArmorItem("potestium_liroth_nautilus_armor", () -> new Item(new Item.Properties().nautilusArmor(LirothArmorMaterial.POTESTIUM_LIROTH.value())));

    public final static Item LIROTHIAN_PETROLEUM = registerItem("lirothian_petroleum", () -> new Item(new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_COAL)));
    public final static Item LIROTHIAN_PETROLEUM_BLOCK = registerBlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK, "lirothian_petroleum_block", new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_COAL_BLOCK));

    public final static Item LIROTH_SHEILD = registerArmorItem("liroth_shield", () -> new CustomShieldItem(new Item.Properties().stacksTo(1), LirothToolMaterial.LIROTH.getUses()));
    public final static Item ANSALUM_LIROTH_SHEILD = registerArmorItem("ansalum_liroth_shield", () -> new CustomShieldItem(new Item.Properties().stacksTo(1), LirothToolMaterial.LIROTH.getUses()));
    public final static Item LUX_LIROTH_SHEILD = registerArmorItem("lux_liroth_shield", () -> new CustomShieldItem(new Item.Properties().stacksTo(1), LirothToolMaterial.LIROTH.getUses()));
    public final static Item SALEM_LIROTH_SHEILD = registerArmorItem("salem_liroth_shield", () -> new CustomShieldItem(new Item.Properties().stacksTo(1), LirothToolMaterial.LIROTH.getUses()));
    public final static Item QUANTUM_LIROTH_SHEILD = registerArmorItem("quantum_liroth_shield", () -> new CustomShieldItem(new Item.Properties().stacksTo(1), LirothToolMaterial.QUANTUM_LIROTH.getUses()));

    public final static Item LIROTH_SMITHING_UPGRADE_TEMPLATE = registerItem("liroth_upgrade_smithing_template");

    public final static Item LIROTH_SOUL_DUST = registerItem("liroth_soul_dust");

    public final static Item LIROTH_TEAR = registerItem("liroth_tear");

    public final static Item PURPETUATED_AMETHYST_SHARD = registerItem("purpetuated_amethyst_shard");

    public final static Item QUANTUM_DIAMOND = registerItem("quantum_diamond");
    public final static Item QUANTUM_PLATE = registerItem("quantum_plate");

    public final static Item POTESTIUM_SHARD = registerItem("potestium_shard");
    public final static Item POTESTIUM_PLATE = registerItem("potestium_plate");

    public final static Item SPINERIOS_STONE_PEBBLE = registerItem("spinerios_stone_pebble");

    public final static Item SWAP_UPGRADE_SMITHING_TEMPLATE = registerItem("swap_upgrade_smithing_template");

    public final static Item QUANTUM_SMITHING_UPGRADE_TEMPLATE = registerItem("quantum_upgrade_smithing_template");

    public static Item POTESTIUM_SCYTHE;

    public final static Item QUANTUM_LIROTH_HELMET = registerArmorItem("quantum_liroth_helmet", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.QUANTUM_LIROTH.value(), ArmorType.HELMET)));
    public final static Item QUANTUM_LIROTH_CHESTPLATE = registerArmorItem("quantum_liroth_chestplate", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.QUANTUM_LIROTH.value(), ArmorType.CHESTPLATE)));
    public final static Item QUANTUM_LIROTH_LEGGINGS = registerArmorItem("quantum_liroth_leggings", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.QUANTUM_LIROTH.value(), ArmorType.LEGGINGS)));
    public final static Item QUANTUM_LIROTH_BOOTS = registerArmorItem("quantum_liroth_boots", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.QUANTUM_LIROTH.value(), ArmorType.BOOTS)));

    public final static Item POTESTIUM_LIROTH_HELMET = registerArmorItem("potestium_liroth_helmet", PotestiumHelmetItem::new);
    public final static Item POTESTIUM_LIROTH_CHESTPLATE = registerArmorItem("potestium_liroth_chestplate", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.POTESTIUM_LIROTH.value(), ArmorType.CHESTPLATE)));
    public final static Item POTESTIUM_LIROTH_LEGGINGS = registerArmorItem("potestium_liroth_leggings", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.POTESTIUM_LIROTH.value(), ArmorType.LEGGINGS)));
    public final static Item POTESTIUM_LIROTH_BOOTS = registerArmorItem("potestium_liroth_boots", () -> new Item(new Item.Properties().humanoidArmor(LirothArmorMaterial.POTESTIUM_LIROTH.value(), ArmorType.BOOTS)));

    public static Item QUANTUM_LIROTH_SWORD;
    public static Item QUANTUM_LIROTH_SHOVEL;
    public static Item QUANTUM_LIROTH_PICKAXE;
    public static Item QUANTUM_LIROTH_AXE;
    public static Item QUANTUM_LIROTH_HOE;
    public static Item LIROTH_SPEAR;
    public static Item LIROTHIAN_COBALT_SPEAR;
    public static Item QUANTUM_SPEAR;
    public static Item POTESTIUM_SPEAR;
    public static Item RUBY_SPEAR;
    public static Item TOURMALINE_SPEAR;

    public static void registerDeferredToolItems() {
        POTESTIUM_SCYTHE = registerTool(
                "potestium_scythe",
                LirothToolMaterial.POTESTIUM_LIROTH,
                BlockTags.MINEABLE_WITH_HOE,
                2.0F,
                -1.2F,
                new Item.Properties()
        );
        QUANTUM_LIROTH_SWORD = registerSwordTool(
                "quantum_liroth_sword", LirothToolMaterial.QUANTUM_LIROTH, 3.0F, -2.4F, new Item.Properties());
        QUANTUM_LIROTH_SHOVEL = registerTool(
                "quantum_liroth_shovel", LirothToolMaterial.QUANTUM_LIROTH,
                BlockTags.MINEABLE_WITH_SHOVEL, 1.5F, -3.0F, new Item.Properties());
        QUANTUM_LIROTH_PICKAXE = registerTool(
                "quantum_liroth_pickaxe", LirothToolMaterial.QUANTUM_LIROTH,
                BlockTags.MINEABLE_WITH_PICKAXE, 1.0F, -2.8F, new Item.Properties());
        QUANTUM_LIROTH_AXE = registerTool(
                "quantum_liroth_axe", LirothToolMaterial.QUANTUM_LIROTH,
                BlockTags.MINEABLE_WITH_AXE, 6.0F, -3.0F, new Item.Properties());
        QUANTUM_LIROTH_HOE = registerTool(
                "quantum_liroth_hoe", LirothToolMaterial.QUANTUM_LIROTH,
                BlockTags.MINEABLE_WITH_HOE, -3.0F, 0.0F, new Item.Properties());
        LIROTH_SPEAR = registerSpearTool("liroth_spear", LirothToolMaterial.LIROTH, 1.15F, 1.2F);
        LIROTHIAN_COBALT_SPEAR = registerSpearTool("lirothian_cobalt_spear", LirothToolMaterial.LIROTHIAN_COBALT, 0.85F, 0.82F);
        QUANTUM_SPEAR = registerSpearTool("quantum_spear", LirothToolMaterial.QUANTUM_LIROTH, 1.15F, 1.2F);
        POTESTIUM_SPEAR = registerSpearTool("potestium_spear", LirothToolMaterial.POTESTIUM_LIROTH, 1.15F, 1.2F);
        RUBY_SPEAR = registerSpearTool("ruby_spear", LirothToolMaterial.RUBY, 1.05F, 1.075F);
        TOURMALINE_SPEAR = registerSpearTool("tourmaline_spear", LirothToolMaterial.TOURMALINE, 1.05F, 1.075F);
        FORSAKEN_CORPSE_SPAWN_EGG = registerEgg("forsaken_corpse_spawn_egg", LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525);
        FUNGAL_FIEND_SPAWN_EGG = registerEgg("fungal_fiend_spawn_egg", LirothEntities.FUNGAL_FIEND, 1315860, 2031360);
        SKELETAL_FREAK_SPAWN_EGG = registerEgg("skeletal_freak_spawn_egg", LirothEntities.SKELETAL_FREAK, 1513239, 16711900);
        WARP_SPAWN_EGG = registerEgg("warp_spawn_egg", LirothEntities.WARP, 524305, 4260003);
        SOUL_ARACHNID_SPAWN_EGG = registerEgg("soul_arachnid_spawn_egg", LirothEntities.WARP, 73758, 5078138);
        PIER_PEEP_SPAWN_EGG = registerEgg("pier_peep_spawn_egg", LirothEntities.PIER_PEEP, 1638400, 11665663);
        SHADE_SPAWN_EGG = registerEgg("shade_spawn_egg", LirothEntities.SHADE, 328965, 1579032);
        PROWLER_SPAWN_EGG = registerEgg("prowler_spawn_egg", LirothEntities.PROWLER, 16312063, 4260003);
        FREAKSHOW_SPAWN_EGG = registerEgg("freakshow_spawn_egg", LirothEntities.FREAKSHOW, 524305, 1579032);
        LIROTHIAN_MIMIC_SPAWN_EGG = registerEgg("lirothian_mimic_spawn_egg", LirothEntities.LIROTHIAN_MIMIC, 41655, 10551525);
        VILE_SHARK_SPAWN_EGG = registerEgg("vile_shark_spawn_egg", LirothEntities.VILE_SHARK, 5963996, 7667865);
    }

    public static void registerDeferredItems(net.neoforged.neoforge.registries.RegisterEvent event) {
        registerDeferredToolItems();
        event.register(net.minecraft.core.registries.Registries.ITEM, helper -> {
            helper.register(Liroth.C.mk("potestium_scythe"), POTESTIUM_SCYTHE);
            helper.register(Liroth.C.mk("quantum_liroth_sword"), QUANTUM_LIROTH_SWORD);
            helper.register(Liroth.C.mk("quantum_liroth_shovel"), QUANTUM_LIROTH_SHOVEL);
            helper.register(Liroth.C.mk("quantum_liroth_pickaxe"), QUANTUM_LIROTH_PICKAXE);
            helper.register(Liroth.C.mk("quantum_liroth_axe"), QUANTUM_LIROTH_AXE);
            helper.register(Liroth.C.mk("quantum_liroth_hoe"), QUANTUM_LIROTH_HOE);
            helper.register(Liroth.C.mk("liroth_spear"), LIROTH_SPEAR);
            helper.register(Liroth.C.mk("lirothian_cobalt_spear"), LIROTHIAN_COBALT_SPEAR);
            helper.register(Liroth.C.mk("quantum_spear"), QUANTUM_SPEAR);
            helper.register(Liroth.C.mk("potestium_spear"), POTESTIUM_SPEAR);
            helper.register(Liroth.C.mk("ruby_spear"), RUBY_SPEAR);
            helper.register(Liroth.C.mk("tourmaline_spear"), TOURMALINE_SPEAR);
            helper.register(Liroth.C.mk("forsaken_corpse_spawn_egg"), FORSAKEN_CORPSE_SPAWN_EGG);
            helper.register(Liroth.C.mk("fungal_fiend_spawn_egg"), FUNGAL_FIEND_SPAWN_EGG);
            helper.register(Liroth.C.mk("skeletal_freak_spawn_egg"), SKELETAL_FREAK_SPAWN_EGG);
            helper.register(Liroth.C.mk("warp_spawn_egg"), WARP_SPAWN_EGG);
            helper.register(Liroth.C.mk("soul_arachnid_spawn_egg"), SOUL_ARACHNID_SPAWN_EGG);
            helper.register(Liroth.C.mk("pier_peep_spawn_egg"), PIER_PEEP_SPAWN_EGG);
            helper.register(Liroth.C.mk("shade_spawn_egg"), SHADE_SPAWN_EGG);
            helper.register(Liroth.C.mk("prowler_spawn_egg"), PROWLER_SPAWN_EGG);
            helper.register(Liroth.C.mk("freakshow_spawn_egg"), FREAKSHOW_SPAWN_EGG);
            helper.register(Liroth.C.mk("lirothian_mimic_spawn_egg"), LIROTHIAN_MIMIC_SPAWN_EGG);
            helper.register(Liroth.C.mk("vile_shark_spawn_egg"), VILE_SHARK_SPAWN_EGG);
        });
    }

    public static Item FORSAKEN_CORPSE_SPAWN_EGG;
    public static Item FUNGAL_FIEND_SPAWN_EGG;
    public static Item SKELETAL_FREAK_SPAWN_EGG;
    public static Item WARP_SPAWN_EGG;
    public static Item SOUL_ARACHNID_SPAWN_EGG;
    public static Item PIER_PEEP_SPAWN_EGG;
    public static Item SHADE_SPAWN_EGG;
    public static Item PROWLER_SPAWN_EGG;
    public static Item FREAKSHOW_SPAWN_EGG;
    public static Item LIROTHIAN_MIMIC_SPAWN_EGG;
    public static Item VILE_SHARK_SPAWN_EGG;

    public final static Item LIROTH_MUSIC_DISC = registerDisc("liroth_music_disc", LirothJukeboxSongs.LIROTH);
    public final static Item PIER_MUSIC_DISC = registerDisc("pier_music_disc", LirothJukeboxSongs.PIER);
    public final static Item SPICED_MUSIC_DISC = registerDisc("spiced_music_disc", LirothJukeboxSongs.SPICED);
    public final static Item DAMNATION_MUSIC_DISC = registerDisc("damnation_music_disc", LirothJukeboxSongs.DAMNATION);
    public final static Item ESCAPE_MUSIC_DISC = registerDisc("escape_music_disc", LirothJukeboxSongs.ESCAPE);
    public final static Item SPITE_MUSIC_DISC = registerDisc("spite_music_disc", LirothJukeboxSongs.SPITE);
    public final static Item DESOLATION_MUSIC_DIST = registerDisc("desolation_music_disc", LirothJukeboxSongs.DESOLATION);

    public final static Item LIROTH_FLUID_BUCKET = registerItem("liroth_fluid_bucket", () -> new BucketItem(LirothFluids.LIROTH_FLUID.getSource(), new Item.Properties()));
    public final static Item MOLTEN_SPINERIOS_BUCKET = registerItem("molten_spinerios_bucket", () -> new BucketItem(LirothFluids.MOLTEN_SPINERIOS.getSource(), new Item.Properties()));

    public final static Item FUNGAL_TORCH = registerItem(
            "fungal_torch",
            () -> new StandingAndWallBlockItem(
                    LirothBlocks.FUNGAL_TORCH,
                    LirothBlocks.WALL_FUNGAL_TORCH,
                    Direction.DOWN,
                    new Item.Properties()));
    public final static Item LIROTHIAN_PETROLEUM_TORCH = registerItem(
            "lirothian_petroleum_torch",
            () -> new StandingAndWallBlockItem(
                    LirothBlocks.LIROTHIAN_PETROLEUM_TORCH,
                    LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH,
                    Direction.DOWN,
                    new Item.Properties()));

    public static List<Item> getModItems() {
        return getItemRegistry().allItems().toList();
    }

    public static void registerCompostableFoods() {
        COMPOSTABLE_FOODS.forEach(food -> ComposterAPI.allowCompost(food.chance(), food.item()));
    }

    public static Item registerDisc(String name, ResourceKey<JukeboxSong> sound) {
        Item item = ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> BaseDiscItem.create(sound, BehaviourBuilders.createDisc()));
        RecordItemModelProvider.add(item);
        getItemRegistry().register(name, item, CommonItemTags.MUSIC_DISCS);
        ITEMS.add(item);
        return item;
    }

    public static Item registerItem(String name) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerItem(name, new ModelProviderItem(makeItemSettings())));
    }

    public static Item registerBlockItem(Block block, String name, Item.Properties properties) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerBlockItem(name, new BlockItem(block, properties)));
    }

    public static Item registerItem(String name, Item item) {
        ITEMS.add(item);
        return getItemRegistry().register(name, item);
    }

    public static Item registerBlockItem(String name, BlockItem item) {
        return getItemRegistry().register(name, item);
    }

    public static Item registerItem(String name, Supplier<? extends Item> factory) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerItem(name, factory.get()));
    }

    public static Item registerArmorItem(String name, Supplier<? extends Item> factory) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerArmorItem(name, factory.get()));
    }

    public static Item registerArmorItem(String name, Item item) {
        EQUIPMENT.add(item);
        return getItemRegistry().register(name, item);
    }

    public static Item registerTool(String name, Item item) {
        EQUIPMENT.add(item);
        return getItemRegistry().registerAsTool(name, item);
    }

    public static Item registerTool(String name, LirothToolMaterial material, TagKey<Block> minesEfficiently, float attackDamageBaseline, float attackSpeedBaseline, Item.Properties properties) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerTool(name, new Item(material.applyToolProperties(properties, minesEfficiently, attackDamageBaseline, attackSpeedBaseline, 0.0F))));
    }

    public static Item registerTool(String name, LirothToolMaterial material, TagKey<Block> minesEfficiently, float attackDamageBaseline, float attackSpeedBaseline, Item.Properties properties, Item repairItem) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerTool(name, new Item(material.applyToolProperties(properties, minesEfficiently, attackDamageBaseline, attackSpeedBaseline, 0.0F, repairItem))));
    }

    public static Item registerSwordTool(String name, LirothToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline, Item.Properties properties) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerTool(name, new Item(material.applySwordProperties(properties, attackDamageBaseline, attackSpeedBaseline))
        ));
    }

    public static Item registerSwordTool(String name, LirothToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline, Item.Properties properties, Item repairItem) {
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerTool(name, new Item(material.applySwordProperties(properties, attackDamageBaseline, attackSpeedBaseline, repairItem))
        ));
    }

    private static Item registerSpearTool(String name, LirothToolMaterial material, float attackDuration, float damageMultiplier) {
        ToolMaterial spearMaterial = new ToolMaterial(
                material.getIncorrectBlocksForDrops(),
                material.getUses(),
                material.getSpeed(),
                material.getAttackDamageBonus(),
                material.getEnchantmentValue(),
                ItemTags.DIAMOND_TOOL_MATERIALS
        );
        Item.Properties properties = new Item.Properties()
                .spear(spearMaterial, attackDuration, damageMultiplier, 0.5F, 3.0F, 10.0F, 6.5F, 5.1F, 10.0F, 4.6F)
                .repairable(material.repairItem());
        return ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> registerTool(name, new Item(properties)));
    }

    public static Item registerEgg(String name, EntityType<? extends Mob> type, int background, int dots) {
        Item item = ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> getItemRegistry().registerEgg(name, new BaseSpawnEggItem(type, background, dots, makeItemSettings())));
        ENTITIES.add(item);
        return item;
    }

    public static Item registerFood(String name, FoodProperties foodComponent) {
        Item item = ItemRegistry.withConstructionId(Liroth.C.mk(name), () -> getItemRegistry().register(name, new ModelProviderItem(getItemRegistry()
                        .createDefaultItemSettings()
                        .food(foodComponent))));
        ITEMS.add(item);
        addCompostableFood(item, foodComponent.nutrition() * foodComponent.saturation() * 0.18F);
        return item;
    }

    private static void addCompostableFood(Item item, float chance) {
        COMPOSTABLE_FOODS.add(new CompostableFood(item, chance));
    }

    public static Item.Properties makeItemSettings() {
        return new Item.Properties();
    }

    @NotNull
    public static ItemRegistry getItemRegistry() {
        if (ITEMS_REGISTRY == null) {
            ITEMS_REGISTRY = ItemRegistry.forMod(Liroth.C);
        }
        return ITEMS_REGISTRY;
    }

    public static Item.Properties defaultSettings() {
        return new Item.Properties();
    }
}
