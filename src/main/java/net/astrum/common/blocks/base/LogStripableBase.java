package net.astrum.common.blocks.base;

import net.astrum.common.materials.Materials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LogStripableBase extends PillarBase {
    Block result;

    public LogStripableBase(Block source, Block result) {
        super(source);
        setResult(result);
    }

    public LogStripableBase(MaterialColor color, Block result) {
        super(Materials.makeWood(color));
        setResult(result);
    }

    public void setResult(Block result) {
        this.result = result;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().getItem() instanceof AxeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClient) {
                world.setBlockState(pos, result.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)), 11);
                if (!player.isCreative()) {
                    player.getMainHandStack().damage(1, world.random, (ServerPlayerEntity) player);
                }
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

}
