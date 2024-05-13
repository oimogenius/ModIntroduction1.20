package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.worldgen.biome.IntroductionBiomeModifiers;
import com.github.oimogenius.introductionmod.worldgen.features.IntroductionFeatures;
import com.github.oimogenius.introductionmod.worldgen.placement.IntroductionPlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class IntroductionWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, IntroductionFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, IntroductionPlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, IntroductionBiomeModifiers::bootstrap);

    public IntroductionWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(IntroductionMod.MOD_ID));
    }
}
