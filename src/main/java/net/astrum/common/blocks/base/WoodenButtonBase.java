package net.astrum.common.blocks.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.WoodButtonBlock;

public class WoodenButtonBase extends WoodButtonBlock {
    public WoodenButtonBase(Block block) {
        super(FabricBlockSettings.copy(block).nonOpaque());
    }
}
