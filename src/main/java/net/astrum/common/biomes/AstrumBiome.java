package net.astrum.common.biomes;

import net.astrum.common.registry.BlocksRegistry;
import net.astrum.common.registry.EntityRegistry;
import net.astrum.common.registry.FeaturesRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class AstrumBiome extends Biome {
    public AstrumBiome(){
        super(new Biome.Settings()
                .configureSurfaceBuilder(FeaturesRegistry.ASTRUM_BIOME, AstrumBiomeFeatures.ASTRUM_SURFACE)
                .precipitation(Biome.Precipitation.RAIN)
                .category(Category.NONE)
                .depth(1.24F)
                .scale(0.2F)
                .temperature(0.6F)
                .downfall(0.7F)
                .effects(new BiomeEffects.Builder()
                        .fogColor(0xC0D8FF)
                        .waterColor(0x3D57D6)
                        .waterFogColor(0x050533)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .parent(null));

        AstrumBiomeFeatures.addOres(this);
        AstrumBiomeFeatures.addTrees(this);
        DefaultBiomeFeatures.addLandCarvers(this);

        this.addFeature(
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                        new OreFeatureConfig(
                                OreFeatureConfig.Target.NATURAL_STONE,
                                BlocksRegistry.METEOR_STONE.getDefaultState(),
                                50
                        )
                ).createDecoratedFeature(
                        Decorator.COUNT_RANGE.configure(
                                new RangeDecoratorConfig(
                                        50,
                                        50,
                                        0,
                                        200
                                )
                        )
                )
        );

        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(EntityRegistry.TRIFFID, 10, 1, 3));
    }
}
