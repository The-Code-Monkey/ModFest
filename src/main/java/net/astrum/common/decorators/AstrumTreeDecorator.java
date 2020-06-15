package net.astrum.common.decorators;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AstrumTreeDecorator extends Decorator<ChanceDecoratorConfig> {
    public AstrumTreeDecorator(Codec<ChanceDecoratorConfig> function) {
        super(function);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldAccess world, ChunkGenerator chunkGenerator, Random random, ChanceDecoratorConfig config, BlockPos pos) {
        return IntStream.range(0, 16).mapToObj((i) -> {
            int j = i / 4;
            int k = i % 4;
            int x = j * 4 + 1 + random.nextInt(3) + pos.getX();
            int z = k * 4 + 1 + random.nextInt(3) + pos.getZ();
            int y = world.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z);
            return random.nextInt(config.chance) != 0 ? null : new BlockPos(x, y, z);
        }).filter(Objects::nonNull);
    }
}
