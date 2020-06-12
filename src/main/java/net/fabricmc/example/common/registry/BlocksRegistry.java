package net.fabricmc.example.common.registry;

import net.fabricmc.example.ModMain;
import net.fabricmc.example.common.blocks.base.*;
import net.fabricmc.example.common.tab.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {

    public static final Block GRASS = registerBlock("test_grass", new GrassBase());

    public static void register() {
        makeWoodenBlocks("test", MaterialColor.PURPLE_TERRACOTTA);
    }

    private static void makeWoodenBlocks(String name, MaterialColor color) {
        final Block STRIPPED_LOG = registerBlock(name + "_stripped_log", new PillarBase(color));
        final Block LOG = registerBlock(name + "_log", new LogStripableBase(color, STRIPPED_LOG));
        final Block PLANKS = registerBlock(name + "_planks", new PlankBase(color));
        final Block STAIRS = registerBlock(name + "_stairs", new StairsBase(PLANKS));
        final Block SLAB = registerBlock(name + "_slab", new SlabBase(PLANKS));
    }

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
