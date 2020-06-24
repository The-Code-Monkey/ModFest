package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.decorators.AstrumTreeDecorator;
import net.astrum.common.features.AlienScrapOreConfig;
import net.astrum.common.features.AlienScrapOreFeature;
import net.astrum.common.features.trees.AstrumTreeFeature;
import net.astrum.common.features.trees.AstrumTreeFeatureConfig;
import net.astrum.common.surface_builders.AstrumSurfaceBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class FeaturesRegistry {
    public static final Decorator<ChanceDecoratorConfig> ASTRUM_TREE_DECORATOR = new AstrumTreeDecorator(ChanceDecoratorConfig.field_24980);
    public static final Feature<AstrumTreeFeatureConfig> ASTRUM_TREE = new AstrumTreeFeature(AstrumTreeFeatureConfig.CODEC);

    public static final Feature<AlienScrapOreConfig> ALIEN_SCRAP_ORE = new AlienScrapOreFeature(AlienScrapOreConfig.CODEC);

    public static final SurfaceBuilder<TernarySurfaceConfig> ASTRUM_BIOME = new AstrumSurfaceBuilder(TernarySurfaceConfig.CODEC);

    public static void register() {
        Registry.register(Registry.DECORATOR, new Identifier(AstrumCore.MOD_ID, "astrum_tree_decorator"), ASTRUM_TREE_DECORATOR);
        Registry.register(Registry.FEATURE, new Identifier(AstrumCore.MOD_ID, "astrum_tree"), ASTRUM_TREE);

        Registry.register(Registry.SURFACE_BUILDER, new Identifier(AstrumCore.MOD_ID, "astrum_biome"), ASTRUM_BIOME);
    }
}
