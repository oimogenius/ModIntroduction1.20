package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class IntroductionBlockTagsProvider extends BlockTagsProvider {
    public IntroductionBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IntroductionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // 適正ツール：ツルハシ
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(IntroductionBlocks.ORIHALCON_BLOCK.get(),
                        IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(IntroductionBlocks.ORIHALCON_BLOCK.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());
    }
}
