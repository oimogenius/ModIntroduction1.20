package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import com.github.oimogenius.introductionmod.tag.IntroductionTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
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

        woodFromLogs(pRecipeOutput, IntroductionBlocks.CURSED_WOOD.get(),
                IntroductionBlocks.CURSED_LOG.get());
        woodFromLogs(pRecipeOutput, IntroductionBlocks.STRIPPED_CURSED_WOOD.get(),
                IntroductionBlocks.STRIPPED_CURSED_LOG.get());

        planksFromLog(pRecipeOutput,
                IntroductionBlocks.CURSED_PLANKS.get(),
                IntroductionTags.Items.CURSED_LOG, 4);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS,
                IntroductionBlocks.CURSED_SLAB.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        stairs(pRecipeOutput,
                IntroductionBlocks.CURSED_STAIRS.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        fence(pRecipeOutput,
                IntroductionBlocks.CURSED_FENCE.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        fenceGate(pRecipeOutput,
                IntroductionBlocks.CURSED_FENCE_GATE.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        door(pRecipeOutput,
                IntroductionBlocks.CURSED_DOOR.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        trapdoor(pRecipeOutput,
                IntroductionBlocks.CURSED_TRAPDOOR.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        button(pRecipeOutput,
                IntroductionBlocks.CURSED_BUTTON.get(),
                IntroductionBlocks.CURSED_PLANKS.get());
        pressurePlate(pRecipeOutput,
                IntroductionBlocks.CURSED_PRESSURE_PLATE.get(),
                IntroductionBlocks.CURSED_PLANKS.get());

    }

    // かまど用のレシピ
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    // 溶鉱炉用のレシピ
    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
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

    private static void stairs(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        stairBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fence(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        fenceBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fenceGate(RecipeOutput pRecipeOutput, ItemLike pResult,
                                  ItemLike pIngredient) {
        fenceGateBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void door(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        doorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void trapdoor(RecipeOutput pRecipeOutput, ItemLike pResult,
                                 ItemLike pIngredient) {
        trapdoorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void button(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        buttonBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
}
