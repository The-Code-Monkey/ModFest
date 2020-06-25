package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.blocks.Astrum.AstrumPlant;
import net.astrum.common.blocks.Astrum.AstrumSapling;
import net.astrum.common.blocks.Astrum.AstrumSaplingGenerator;
import net.astrum.common.blocks.base.*;
import net.astrum.common.tab.CreativeTab;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;

public class BlocksRegistry {

    public static final Block ASTRUM_GRASS = registerBlock("astrum_grass", new GrassBase());
    public static final Block ASTRUM_DIRT = registerBlock("astrum_dirt", new BlockBase(FabricBlockSettings.copyOf(DIRT).breakByTool(FabricToolTags.SHOVELS)));
    public static final Block METEOR_STONE = registerBlock("meteor_stone", new BlockBase(FabricBlockSettings.copy(GRANITE)));
    public static final Block ALIEN_SCRAP_ORE = registerBlock("alien_scrap_ore", new BlockBase(FabricBlockSettings.copy(IRON_ORE).nonOpaque()));
    public static final Block CHISELED_METEOR_STONE = registerBlock("chiseled_meteor_stone", new BlockBase(FabricBlockSettings.copy(CHISELED_STONE_BRICKS)));
    public static final Block METEOR_STONE_BRICKS = registerBlock("meteor_stone_bricks", new BlockBase(FabricBlockSettings.copy(GRANITE)));
    public static final Block ASTRUM_SAPLING = registerBlock("astrum_sapling", new AstrumSapling(new AstrumSaplingGenerator(), FabricBlockSettings.copy(OAK_SAPLING)));
    public static final Block ASTRUM_PLANT = registerBlock("astrum_plant", new AstrumPlant(GRASS));
    //public static final Block FIREMOSS = registerBlock("firemoss", new BlockBase(FabricBlockSettings.copy(VINE)));

    public static final Block ASTRUM_STRIPPED_LOG = registerBlock(AstrumCore.MOD_ID + "_stripped_log", new PillarBase(MaterialColor.BLUE_TERRACOTTA));
    public static final Block ASTRUM_LOG = registerBlock(AstrumCore.MOD_ID + "_log", new LogStripableBase(MaterialColor.BLUE_TERRACOTTA, ASTRUM_STRIPPED_LOG));
    public static final Block ASTRUM_LEAVES = registerBlock(AstrumCore.MOD_ID + "_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block ASTRUM_SAPLING = registerBlock("astrum_sapling", new AstrumSaplingBlock(new AstrumSaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    public static void register() {
        makeWoodenBlocks(AstrumCore.MOD_ID, MaterialColor.BLUE_TERRACOTTA);
    }

    private static void makeWoodenBlocks(String name, MaterialColor color) {
        final Block PLANKS = registerBlock(name + "_planks", new PlankBase(color));
        registerBlock(name + "_stairs", new WoodStairsBase(PLANKS));
        registerBlock(name + "_slab", new WoodSlabBase(PLANKS));
        registerBlock(name + "_plate", new WoodPressurePlateBase(PressurePlateBlock.ActivationRule.EVERYTHING, PLANKS));
        registerBlock(name + "_door", new DoorBase(PLANKS));
        registerBlock(name + "_trapdoor", new TrapdoorBase(PLANKS));
        registerBlock(name + "_button", new WoodButtonBase(PLANKS));
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
