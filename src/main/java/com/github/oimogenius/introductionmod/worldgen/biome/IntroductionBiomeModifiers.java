package com.github.oimogenius.introductionmod.worldgen.biome;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.worldgen.placement.IntroductionPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class IntroductionBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ORIHALCON_ORE =
            createKey("add_orihalcon_ore");
    public static final ResourceKey<BiomeModifier> ADD_CURSED_TREE =
            createKey("add_cursed_tree");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures =
                context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // 鉱石が生成されるバイオームを設定
        context.register(ADD_ORIHALCON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(IntroductionPlacement.ORE_ORIHALCON)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 木が生成されるバイオームを設定
//        context.register(ADD_CURSED_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
//                HolderSet.direct(placedFeatures.getOrThrow(IntroductionPlacement.CURSED_TREE)),
//                GenerationStep.Decoration.VEGETAL_DECORATION
//        ));
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(IntroductionMod.MOD_ID, name));
    }
}
