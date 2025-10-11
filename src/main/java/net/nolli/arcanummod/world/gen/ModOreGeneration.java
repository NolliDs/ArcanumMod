package net.nolli.arcanummod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.nolli.arcanummod.world.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {

        //Wszystkie w overworld
        //BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        //        ModPlacedFeatures.SEA_CRYSTAL_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.OCEAN,
                        BiomeKeys.DEEP_OCEAN,
                        BiomeKeys.COLD_OCEAN,
                        BiomeKeys.DEEP_COLD_OCEAN,
                        BiomeKeys.FROZEN_OCEAN,
                        BiomeKeys.DEEP_FROZEN_OCEAN,
                        BiomeKeys.LUKEWARM_OCEAN,
                        BiomeKeys.DEEP_LUKEWARM_OCEAN,
                        BiomeKeys.WARM_OCEAN),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.SEA_CRYSTAL_ORE_PLACED_KEY);

    }
}
