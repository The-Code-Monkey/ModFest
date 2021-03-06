package net.astrum.common.registry;

import net.astrum.AstrumCore;
import net.astrum.common.biomes.AstrumBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class BiomesRegistry {
    public static final Biome ASTRUM_BIOME = new AstrumBiome();

    public static void register() {
        Registry.register(Registry.BIOME, new Identifier(AstrumCore.MOD_ID, "astrum"), ASTRUM_BIOME);

        OverworldBiomes.addContinentalBiome(BiomesRegistry.ASTRUM_BIOME, OverworldClimate.TEMPERATE, 1D);
        OverworldBiomes.setRiverBiome(BiomesRegistry.ASTRUM_BIOME, null);
    }
}
