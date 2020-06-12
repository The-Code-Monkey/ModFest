package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.materials.Materials;
import net.minecraft.block.MaterialColor;

public class PlankBase extends BlockBase {
    public PlankBase(MaterialColor color) {
        super(Materials.makeWood(color));
    }
}
