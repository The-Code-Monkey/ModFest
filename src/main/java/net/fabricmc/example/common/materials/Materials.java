package net.fabricmc.example.common.materials;

import net.fabricmc.example.ModMain;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class Materials {
    public static final Material COMMON_WOOD = new Material.Builder(MaterialColor.WOOD).build();
    public static final Material COMMON_GRASS = new Material.Builder(MaterialColor.FOLIAGE).allowsMovement().notSolid().replaceable().build();

    public static FabricBlockSettings makeWood(MaterialColor color) {
        return FabricBlockSettings.of(COMMON_WOOD)
                .sounds(BlockSoundGroup.WOOD)
                .breakByTool(FabricToolTags.AXES)
                .hardness(1)
                .materialColor(color);
    }

    public static FabricBlockSettings makeGrass(MaterialColor color) {
        return FabricBlockSettings.of(COMMON_GRASS)
                .sounds(BlockSoundGroup.CROP)
                .materialColor(color)
                .noCollision()
                .breakInstantly();
    }

    public static AbstractBlock.Settings makeLeaves(MaterialColor color) {
        return FabricBlockSettings.of(COMMON_WOOD, color)
                .breakByHand(true)
                .breakByTool(ModMain.SHEARS)
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque()
                .strength(0.2F, 0F);
    }
}
