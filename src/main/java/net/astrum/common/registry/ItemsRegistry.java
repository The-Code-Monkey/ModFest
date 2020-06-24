package net.astrum.common.registry;


import net.astrum.AstrumCore;
import net.astrum.common.helpers.MathHelper;
import net.astrum.common.items.*;
import net.astrum.common.tab.CreativeTab;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class ItemsRegistry {

    public static final ArrayList<Item> MOD_BLOCKS = new ArrayList<Item>();
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<Item>();


    public static final Item SPAWN_TRIFFID = registerItem("triffid_spawn_egg", makeEgg(EntityRegistry.TRIFFID, MathHelper.color(12, 12, 12), MathHelper.color(210, 90, 26)));

    public static final Item ALIEN_SCRAP = registerItem("alien_scrap", new Item(new Item.Settings()));
    public static final Item ALIEN_PICKAXE = registerItem("alien_pickaxe", AstrumPickaxe.alienPickaxe);
    public static final Item ALIEN_AXE= registerItem("alien_axe", AstrumAxe.alienAxe);
    public static final Item ALIEN_SHOVEL= registerItem("alien_shovel", AstrumShovel.alienShovel);
    public static final Item ALIEN_HOE= registerItem("alien_hoe", AstrumHoe.alienHoe);
    public static final Item ALIEN_SWORD= registerItem("alien_sword", AstrumSword.alienSword);


    public static void register() {}

    public static Item registerItem(String name, Item item)
    {
        Registry.register(Registry.ITEM, new Identifier(AstrumCore.MOD_ID, name), item);
        if (item instanceof BlockItem)
            MOD_BLOCKS.add(item);
        else
            MOD_ITEMS.add(item);
        return item;
    }

    public static Item.Settings defaultSettings()
    {
        return new Item.Settings().group(CreativeTab.TAB);
    }

    private static SpawnEggItem makeEgg(EntityType<?> type, int background, int dots)
    {
        return new SpawnEggItem(type, background, dots, defaultSettings());
    }
}
