package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.materials.Materials;
import net.minecraft.block.MaterialColor;

public class BlockFarmland extends BlockBase {
    public BlockFarmland()
    {
        super(Materials.makeWood(MaterialColor.LIME_TERRACOTTA));
    }
}
