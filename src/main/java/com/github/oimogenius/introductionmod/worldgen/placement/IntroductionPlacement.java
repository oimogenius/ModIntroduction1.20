package com.github.oimogenius.introductionmod.worldgen.placement;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.worldgen.features.IntroductionFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class IntroductionPlacement {
    public static final ResourceKey<PlacedFeature> ORE_ORIHALCON =
            createKey("ore_orihalcon");
    public static final ResourceKey<PlacedFeature> CURSED_TREE =
            createKey("cursed_tree");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        // 鉱石の配置情報を設定
        PlacementUtils.register(context, ORE_ORIHALCON,
                configuredFeatures.getOrThrow(IntroductionFeatures.ORIHALCON_ORE_KEY),
                commonOrePlacement(90,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(112))));
        // 木の配置情報を設定
        PlacementUtils.register(context, CURSED_TREE,
                configuredFeatures.getOrThrow(IntroductionFeatures.CURSED_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(10, 0.1f, 1),
                        IntroductionBlocks.CURSED_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(IntroductionMod.MOD_ID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
