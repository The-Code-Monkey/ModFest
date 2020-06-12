package net.astrum.common.blocks.base;

import net.astrum.common.materials.Materials;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;

public class PillarBase extends PillarBlock {
    public PillarBase(Settings settings) {
        super(settings);
    }

    public PillarBase(Block block) {
        super(FabricBlockSettings.copy(block));
    }

    public PillarBase(MaterialColor color) {
        super(Materials.makeWood(color));
    }
}
