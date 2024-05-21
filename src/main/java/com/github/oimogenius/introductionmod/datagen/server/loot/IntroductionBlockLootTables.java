package com.github.oimogenius.introductionmod.datagen.server.loot;

import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
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
        this.add(IntroductionBlocks.ORIHALCON_ORE.get(),
                block -> this.createOreDrop(block, IntroductionItems.RAW_ORIHALCON.get()));
        this.add(IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get(),
                block -> this.createOreDrop(block, IntroductionItems.RAW_ORIHALCON.get()));
        this.dropSelf(IntroductionBlocks.CURSED_LOG.get());
        this.dropSelf(IntroductionBlocks.STRIPPED_CURSED_LOG.get());
        this.dropSelf(IntroductionBlocks.CURSED_WOOD.get());
        this.dropSelf(IntroductionBlocks.STRIPPED_CURSED_WOOD.get());
        this.add(IntroductionBlocks.CURSED_LEAVES.get(), block ->
                createLeavesDrops(block, IntroductionBlocks.CURSED_SAPLING.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(IntroductionBlocks.CURSED_PLANKS.get());
        this.dropSelf(IntroductionBlocks.CURSED_STAIRS.get());
        this.dropSelf(IntroductionBlocks.CURSED_FENCE.get());
        this.dropSelf(IntroductionBlocks.CURSED_FENCE_GATE.get());
        this.dropSelf(IntroductionBlocks.CURSED_TRAPDOOR.get());
        this.dropSelf(IntroductionBlocks.CURSED_BUTTON.get());
        this.dropSelf(IntroductionBlocks.CURSED_PRESSURE_PLATE.get());
        this.add(IntroductionBlocks.CURSED_SLAB.get(),
                createSlabItemTable(IntroductionBlocks.CURSED_SLAB.get()));
        this.add(IntroductionBlocks.CURSED_DOOR.get(),
                createDoorTable(IntroductionBlocks.CURSED_DOOR.get()));

        this.dropSelf(IntroductionBlocks.CURSED_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return IntroductionBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
