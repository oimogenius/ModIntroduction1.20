package com.github.oimogenius.introductionmod.worldgen.features;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class IntroductionFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORIHALCON_ORE_KEY =
            createKey("orihalcon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CURSED_TREE_KEY =
            createKey("cursed_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // 鉱石の置換ルールを設定
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> orihalconOres = List.of(
                OreConfiguration.target(stone,
                        IntroductionBlocks.ORIHALCON_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate,
                        IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context, ORIHALCON_ORE_KEY, Feature.ORE,
                new OreConfiguration(orihalconOres, 9));
        FeatureUtils.register(context, CURSED_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(IntroductionBlocks.CURSED_LOG.get()),
                        new ForkingTrunkPlacer(5, 15, 0),
                        BlockStateProvider.simple(IntroductionBlocks.CURSED_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2),
                                ConstantInt.of(0), 2),
                        new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(IntroductionMod.MOD_ID, name));
    }
}
