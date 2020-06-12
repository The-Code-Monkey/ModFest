package net.fabricmc.example.common.blocks.base;

import net.fabricmc.example.common.enums.ModRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.DyeColor;

public class StainedGlassBase extends GlassBase {
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.of("color", DyeColor.class);

    public StainedGlassBase(Block block) {
        super(block);
        this.setRenderLayer(ModRenderLayer.TRANSLUCENT);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(COLOR);
    }
}
