package net.astrum.common.blocks.base;

import jdk.internal.jline.internal.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Arrays;
import java.util.List;

public class CactusBase extends BlockBaseNotFull {
    public List<Block> CAN_PLACE_ON_BLOCKS = Arrays.asList(Blocks.SAND, Blocks.RED_SAND);
    public float damage = 1.0F;

    public CactusBase(Settings settings, @Nullable Float damage, @Nullable List<Block> canPlaceOnBlocks) {
        super(settings);
        if (canPlaceOnBlocks != null) {
            CAN_PLACE_ON_BLOCKS = canPlaceOnBlocks;
        }
        if (damage != null) {
            setDamage(damage);
        }
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Block down = world.getBlockState(pos.down()).getBlock();
        return down == Blocks.SAND;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(DamageSource.CACTUS, damage);
    }
}
