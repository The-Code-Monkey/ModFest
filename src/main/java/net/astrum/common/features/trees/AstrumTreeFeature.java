package net.astrum.common.features.trees;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.Random;

public class AstrumTreeFeature extends AbstractAstrumTreeFeature<AstrumTreeFeatureConfig> {
    public AstrumTreeFeature(Codec<AstrumTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ServerWorldAccess world, StructureAccessor accessor, ChunkGenerator generator, Random random, BlockPos pos, AstrumTreeFeatureConfig config) {
        if (!this.canGenerateAt(world, pos)) {
            return false;
        }

        int[] shape = config.shape.chooseShape(random);
        int height = shape.length - 2 - random.nextInt(2);

        placeHardcodedShape(world, random, pos, config, shape, height);
        trySetToDirt(world, pos.down());
        return true;
    }
}
