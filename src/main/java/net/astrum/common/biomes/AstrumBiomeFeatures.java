package net.astrum.common.biomes;

import net.astrum.common.features.AlienScrapOreConfig;
import net.astrum.common.features.trees.AstrumTreeFeatureConfig;
import net.astrum.common.features.trees.AstrumTreeShape;
import net.astrum.common.registry.BlocksRegistry;
import net.astrum.common.registry.FeaturesRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Collections;

public class AstrumBiomeFeatures {
    private AstrumBiomeFeatures() {
        throw new UnsupportedOperationException();
    }

    private static final SimpleBlockStateProvider ASTRUM_LOG = new SimpleBlockStateProvider(BlocksRegistry.LOG.getDefaultState());
    private static final SimpleBlockStateProvider ASTRUM_LEAVES = new SimpleBlockStateProvider(BlocksRegistry.LEAVES.getDefaultState());

    public static final AlienScrapOreConfig ALIENT_SCRAP_ORE = new AlienScrapOreConfig(BlocksRegistry.ALIEN_SCRAP_ORE.getDefaultState(), 9);

    public static final AstrumTreeFeatureConfig NORMAL_ASTRUM_TREE = new AstrumTreeFeatureConfig(ASTRUM_LOG, ASTRUM_LEAVES, AstrumTreeShape.NORMAL);

    public static final TernarySurfaceConfig ASTRUM_SURFACE = new TernarySurfaceConfig(
            BlocksRegistry.ASTRUM_GRASS.getDefaultState(),
            BlocksRegistry.ASTRUM_DIRT.getDefaultState(),
            BlocksRegistry.METEOR_STONE.getDefaultState()
    );

    public static void addOres(Biome biome) {
        biome.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                OreFeatureConfig.Target.NATURAL_STONE,
                                BlocksRegistry.ALIEN_SCRAP_ORE.getDefaultState(),
                                3
                        )
                ).createDecoratedFeature(
                        Decorator.COUNT_RANGE.configure(
                                new RangeDecoratorConfig(
                                        10,
                                        50,
                                        0,
                                        20
                                )
                        )
                )
        );
    }

    public static void addTrees(Biome biome) {
        ConfiguredFeature<?, ?> tree = FeaturesRegistry.ASTRUM_TREE.configure(NORMAL_ASTRUM_TREE);

        ConfiguredFeature<?, ?> treeSelector = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
                Collections.singletonList(
                        new RandomFeatureEntry<>(tree, 0.56F)
                ),
                tree
        ));

        ConfiguredDecorator<?> treeDecorator = FeaturesRegistry.ASTRUM_TREE_DECORATOR.configure(new ChanceDecoratorConfig(4));

        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, treeSelector.createDecoratedFeature(treeDecorator));
    }
}
