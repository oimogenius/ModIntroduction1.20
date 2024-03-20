package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;

public class IntroductionRecipeProvider extends RecipeProvider {
    public IntroductionRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC,
                IntroductionItems.ORIHALCON_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                IntroductionBlocks.ORIHALCON_BLOCK.get());
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC,
                IntroductionItems.RAW_ORIHALCON.get(),
                RecipeCategory.BUILDING_BLOCKS,
                IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());
    }

    protected static void nineBlockStorageRecipes(RecipeOutput pRecipeOutput,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pRecipeOutput);
    }
}
