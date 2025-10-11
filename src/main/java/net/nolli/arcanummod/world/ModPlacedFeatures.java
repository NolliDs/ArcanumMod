package net.nolli.arcanummod.world;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.nolli.arcanummod.ArcanumMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SEA_CRYSTAL_ORE_PLACED_KEY = registerKey("sea_crystal_ore_placed");
    public static final RegistryKey<PlacedFeature> WILD_CLOVER_PLACED_KEY = registerKey("wild_clover_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SEA_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SEA_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-20), YOffset.fixed(20))));

        register(context,
                WILD_CLOVER_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_CLOVER_KEY),
                List.of(
                        CountPlacementModifier.of(20), // ile patchy na chunk
                        RarityFilterPlacementModifier.of(1), // jak często
                        SquarePlacementModifier.of(), // nowy odpowiednik InSquarePlacementModifier
                        SurfaceWaterDepthFilterPlacementModifier.of(0), // tylko na powierzchni
                        HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(128)), // zakres wysokości (trawa)
                        BiomePlacementModifier.of() // ogranicz do biomów (forest, plains)
                ));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ArcanumMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
