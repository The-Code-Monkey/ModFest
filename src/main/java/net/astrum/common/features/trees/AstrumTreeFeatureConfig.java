package net.astrum.common.features.trees;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class AstrumTreeFeatureConfig implements FeatureConfig {
    public static final Codec<AstrumTreeFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter((treeFeatureConfig) -> {
            return treeFeatureConfig.trunk;
        }), BlockStateProvider.CODEC.fieldOf("leaves_provider").forGetter((treeFeatureConfig) -> {
            return treeFeatureConfig.leaves;
        })).apply(instance, AstrumTreeFeatureConfig::new);
    });

    public final BlockStateProvider trunk;
    public final BlockStateProvider leaves;

    public AstrumTreeFeatureConfig(BlockStateProvider trunk, BlockStateProvider leaves) {
        this.trunk = trunk;
        this.leaves = leaves;
    }
}
