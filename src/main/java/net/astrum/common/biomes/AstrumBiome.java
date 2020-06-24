package net.astrum.common.biomes;

import net.astrum.common.registry.EntityRegistry;
import net.astrum.common.registry.FeaturesRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;

public class AstrumBiome extends Biome {
    public AstrumBiome(){
        super(new Biome.Settings()
                .configureSurfaceBuilder(FeaturesRegistry.ASTRUM_BIOME, AstrumBiomeFeatures.ASTRUM_SURFACE)
                .precipitation(Biome.Precipitation.RAIN)
                .category(Category.NONE)
                .depth(0.24F)
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
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(EntityRegistry.TRIFFID, 10, 1, 3));
    }
}
