package net.astrum.common.blocks.base;

import net.astrum.common.materials.Materials;
import net.minecraft.block.MaterialColor;

public class PlankBase extends BlockBase {
    public PlankBase(MaterialColor color) {
        super(Materials.makeWood(color));
    }
}
