package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;

public class PressurePlateBase extends PressurePlateBlock {
    public PressurePlateBase(ActivationRule rule, Block block) {
        super(rule, FabricBlockSettings.copy(block).nonOpaque());
    }
}
