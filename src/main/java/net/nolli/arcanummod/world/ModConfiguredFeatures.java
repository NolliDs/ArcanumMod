package net.nolli.arcanummod.world;

import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.nolli.arcanummod.ArcanumMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SEA_CRYSTAL_ORE_KEY = registerKey("sea_crystal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_CLOVER_KEY = registerKey("wild_clover");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSeaCrystalOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SEA_CRYSTAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE.getDefaultState()));

        register(context, SEA_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSeaCrystalOres, 3));

        RandomPatchFeatureConfig cloverPatchConfig = new RandomPatchFeatureConfig(256, 10, 3,
                        PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_CLOVER))));

        register(context, WILD_CLOVER_KEY, Feature.RANDOM_PATCH, cloverPatchConfig);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ArcanumMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
