package net.astrum.common.registry;

import net.astrum.ModMain;
import net.astrum.common.tab.CreativeTab;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class ItemsRegistry {
    public static final ArrayList<Item> MOD_BLOCKS = new ArrayList<Item>();
    public static final ArrayList<Item> MOD_ITEMS = new ArrayList<Item>();

    public static void register() {}

    public static Item registerItem(String name, Item item)
    {
        Registry.register(Registry.ITEM, new Identifier(ModMain.MOD_ID, name), item);
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
