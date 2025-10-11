package net.nolli.arcanummod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.nolli.arcanummod.world.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(), // wszystkie biomy Overworldu
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.WILD_CLOVER_PLACED_KEY
        );
    }
}
