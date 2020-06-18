package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.blocks.base.*;
import net.astrum.common.tab.CreativeTab;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;

public class BlocksRegistry {

    public static final Block ASTRUM_GRASS = registerBlock("astrum_grass", new GrassBase());
    public static final Block ASTRUM_DIRT = registerBlock("astrum_dirt", new BlockBase(FabricBlockSettings.copyOf(DIRT).breakByTool(FabricToolTags.SHOVELS)));
    public static final Block METEOR_STONE = registerBlock("meteor_stone", new BlockBase(FabricBlockSettings.copy(GRANITE)));
    public static final Block ALIEN_SCRAP_ORE = registerBlock("alien_scrap_ore", new BlockBase(FabricBlockSettings.copy(IRON_ORE)));


    public static void register() {
        makeWoodenBlocks(AstrumCore.MOD_ID, MaterialColor.BLUE_TERRACOTTA);
    }

    private static void makeWoodenBlocks(String name, MaterialColor color) {
        final Block STRIPPED_LOG = registerBlock(name + "_stripped_log", new PillarBase(color));
        final Block LOG = registerBlock(name + "_log", new LogStripableBase(color, STRIPPED_LOG));
        final Block PLANKS = registerBlock(name + "_planks", new PlankBase(color));
        registerBlock(name + "_leaves", new LeavesBase(MaterialColor.BLUE, LOG, STRIPPED_LOG));
        registerBlock(name + "_stairs", new StairsBase(PLANKS));
        registerBlock(name + "_slab", new SlabBase(PLANKS));
        registerBlock(name + "_plate", new PressurePlateBase(PressurePlateBlock.ActivationRule.EVERYTHING, PLANKS));
        registerBlock(name + "_door", new DoorBase(PLANKS));
        registerBlock(name + "_trapdoor", new TrapdoorBase(PLANKS));
        registerBlock(name + "_button", new WoodenButtonBase(PLANKS));
        registerBlock(name + "_fence", new FenceBase(PLANKS));
        registerBlock(name + "_gate", new GateBase(PLANKS));
    }

    private static Block registerBlock(String name, Block block)
    {
        Registry.register(Registry.BLOCK, new Identifier(AstrumCore.MOD_ID, name), block);
        ItemsRegistry.registerItem(name, new BlockItem(block, new Item.Settings().group(CreativeTab.TAB)));
        return block;
    }

    // private static Block registerBlockNI(String name, Block block)
    // {
    //     Registry.register(Registry.BLOCK, new Identifier(AstrumCore.MOD_ID, name), block);
    //     return block;
    // }
}
