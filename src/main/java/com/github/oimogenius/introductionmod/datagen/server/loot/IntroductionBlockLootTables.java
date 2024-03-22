package com.github.oimogenius.introductionmod.datagen.server.loot;

import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class IntroductionBlockLootTables extends BlockLootSubProvider {
    protected IntroductionBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(IntroductionBlocks.ORIHALCON_BLOCK.get());
        this.dropSelf(IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return IntroductionBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
