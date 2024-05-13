package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.tag.IntroductionTags;
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
                        IntroductionBlocks.RAW_ORIHALCON_BLOCK.get(),
                        IntroductionBlocks.ORIHALCON_ORE.get(),
                        IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get()
                );
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(IntroductionBlocks.ORIHALCON_BLOCK.get(),
                        IntroductionBlocks.ORIHALCON_ORE.get(),
                        IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get()
                );
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());

        // 板材のレシピを作るときに使う
        this.tag(IntroductionTags.Blocks.CURSED_LOG)
                .add(IntroductionBlocks.CURSED_LOG.get())
                .add(IntroductionBlocks.STRIPPED_CURSED_LOG.get())
                .add(IntroductionBlocks.CURSED_WOOD.get())
                .add(IntroductionBlocks.STRIPPED_CURSED_WOOD.get());
        // 原木を使うレシピや、地面かどうかの判定処理に使われる
        this.tag(BlockTags.LOGS)
                .add(IntroductionBlocks.CURSED_LOG.get())
                .add(IntroductionBlocks.STRIPPED_CURSED_LOG.get());
        // 焼くと木炭になる
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(IntroductionBlocks.CURSED_LOG.get())
                .add(IntroductionBlocks.STRIPPED_CURSED_LOG.get())
                .add(IntroductionBlocks.CURSED_WOOD.get())
                .add(IntroductionBlocks.STRIPPED_CURSED_WOOD.get());
        // 地面かどうかの判定に使われたり、ハサミで回収できるようになったりする
        this.tag(BlockTags.LEAVES)
                .add(IntroductionBlocks.CURSED_LEAVES.get());

        this.tag(BlockTags.PLANKS).add(IntroductionBlocks.CURSED_PLANKS.get());
        this.tag(BlockTags.SLABS).add(IntroductionBlocks.CURSED_SLAB.get());
        this.tag(BlockTags.STAIRS).add(IntroductionBlocks.CURSED_STAIRS.get());
        this.tag(BlockTags.FENCES).add(IntroductionBlocks.CURSED_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(IntroductionBlocks.CURSED_FENCE_GATE.get());
        this.tag(BlockTags.DOORS).add(IntroductionBlocks.CURSED_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(IntroductionBlocks.CURSED_TRAPDOOR.get());
        this.tag(BlockTags.BUTTONS).add(IntroductionBlocks.CURSED_BUTTON.get());
        this.tag(BlockTags.PRESSURE_PLATES).add(IntroductionBlocks.CURSED_PRESSURE_PLATE.get());



    }
}
