package net.astrum.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;


public class AstrumBiome extends Biome {
    public AstrumBiome(){
        super(new Biome.Settings().configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NONE
        ).depth(0.24F).scale(0.2F).temperature(0.6F).downfall(0.7F).parent((String)null));
    }
}
