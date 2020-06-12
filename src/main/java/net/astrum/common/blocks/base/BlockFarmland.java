package net.astrum.common.blocks.base;

import net.astrum.common.materials.Materials;
import net.minecraft.block.MaterialColor;

public class BlockFarmland extends BlockBase {
    public BlockFarmland()
    {
        super(Materials.makeWood(MaterialColor.LIME_TERRACOTTA));
    }
}
