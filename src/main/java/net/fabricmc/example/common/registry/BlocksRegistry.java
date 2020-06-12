package net.fabricmc.example.common.registry;

import net.fabricmc.example.ModMain;
import net.fabricmc.example.common.tab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {

    public static void register() {}

    private static Block registerBlock(String name, Block block)
    {
        Registry.register(Registry.BLOCK, new Identifier(ModMain.MOD_ID, name), block);
        ItemsRegistry.registerItem(name, new BlockItem(block, new Item.Settings().group(CreativeTab.TAB)));
        return block;
    }

    private static Block registerBlockNI(String name, Block block)
    {
        Registry.register(Registry.BLOCK, new Identifier(ModMain.MOD_ID, name), block);
        return block;
    }
}
