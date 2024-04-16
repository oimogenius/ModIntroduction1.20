package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class IntroductionRecipeProvider extends RecipeProvider {
    // オリハルコンインゴットを生成できるアイテムのリスト
    private static final List<ItemLike> ORIHALCON_SMELTABLE =
            List.of(IntroductionItems.RAW_ORIHALCON.get(),
                    IntroductionBlocks.ORIHALCON_ORE.get(),
                    IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get());

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
        oreSmelting(pRecipeOutput, ORIHALCON_SMELTABLE, RecipeCategory.MISC,
                IntroductionItems.ORIHALCON_INGOT.get(),
                1.0f, 200, "orihalcon");
        oreBlasting(pRecipeOutput, ORIHALCON_SMELTABLE, RecipeCategory.MISC,
                IntroductionItems.ORIHALCON_INGOT.get(),
                1.0f, 100, "orihalcon");
    }

    // かまど用のレシピ
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    // 溶鉱炉用のレシピ
    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput,
                            IntroductionMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
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
