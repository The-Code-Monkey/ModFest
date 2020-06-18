package net.astrum.common.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class AlienScrapOreConfig implements FeatureConfig {
    public final int size;
    public final BlockState state;

    public static final Codec<AlienScrapOreConfig> CODEC = RecordCodecBuilder
            .create(instance -> instance.group(BlockState.CODEC.fieldOf("state").forGetter(config -> config.state), Codec.INT.fieldOf("size").withDefault(0).forGetter(config -> config.size)).apply(instance, AlienScrapOreConfig::new));

    public AlienScrapOreConfig(BlockState state, int size) {
        this.size = size;
        this.state = state;
    }
}
