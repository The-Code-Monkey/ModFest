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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
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

    public static final AstrumTreeFeatureConfig ASTRUM_TREE_FEATURE_CONFIG = new AstrumTreeFeatureConfig(ASTRUM_LOG, ASTRUM_LEAVES, AstrumTreeShape.NORMAL);

    public static final TernarySurfaceConfig ASTRUM_SURFACE = new TernarySurfaceConfig(
            BlocksRegistry.ASTRUM_GRASS.getDefaultState(),
            BlocksRegistry.ASTRUM_DIRT.getDefaultState(),
            BlocksRegistry.METEOR_STONE.getDefaultState()
    );

    public static void addOres(Biome biome) {
        ConfiguredFeature<?, ?> scrapOre = FeaturesRegistry.ALIEN_SCRAP_ORE.configure(ALIENT_SCRAP_ORE);
        ConfiguredDecorator<?> oreDecorator = Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(20, 24, 0, 72));

        biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, scrapOre.createDecoratedFeature(oreDecorator));
    }

    public static void addTrees(Biome biome) {
        ConfiguredFeature<?, ?> tree = FeaturesRegistry.ASTRUM_TREE.configure(ASTRUM_TREE_FEATURE_CONFIG);

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
