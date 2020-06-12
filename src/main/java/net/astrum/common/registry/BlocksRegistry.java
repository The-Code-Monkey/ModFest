package net.astrum.common.registry;

import net.astrum.ModMain;
import net.astrum.common.blocks.base.*;
import net.astrum.common.tab.CreativeTab;
import net.astrum.common.blocks.base.*;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {

    public static final Block GRASS = registerBlock("astrum_grass", new GrassBase());

    public static void register() {
        makeWoodenBlocks(ModMain.MOD_ID, MaterialColor.BLUE_TERRACOTTA);
    }

    private static void makeWoodenBlocks(String name, MaterialColor color) {
        final Block STRIPPED_LOG = registerBlock(name + "_stripped_log", new PillarBase(color));
        final Block LOG = registerBlock(name + "_log", new LogStripableBase(color, STRIPPED_LOG));
        final Block LEAVES = registerBlock(name + "_leaves", new LeavesBase(MaterialColor.BLUE, LOG, STRIPPED_LOG));
        final Block PLANKS = registerBlock(name + "_planks", new PlankBase(color));
        final Block STAIRS = registerBlock(name + "_stairs", new StairsBase(PLANKS));
        final Block SLAB = registerBlock(name + "_slab", new SlabBase(PLANKS));
        final Block PRESSURE_PLATE = registerBlock(name + "_plate", new PressurePlateBase(PressurePlateBlock.ActivationRule.EVERYTHING, PLANKS));
        final Block DOOR = registerBlock(name + "_door", new DoorBase(PLANKS));
        final Block TRAP_DOOR = registerBlock(name + "_trapdoor", new TrapdoorBase(PLANKS));
        final Block BUTTON = registerBlock(name + "_button", new WoodenButtonBase(PLANKS));
        final Block FENCE = registerBlock(name + "_fence", new FenceBase(PLANKS));
        final Block GATE = registerBlock(name + "_gate", new GateBase(PLANKS));
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
