package com.github.oimogenius.introductionmod.datagen.server;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import com.github.oimogenius.introductionmod.loot.AddItemModifier;
import com.github.oimogenius.introductionmod.loot.ReplaceItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class IntroductionGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public IntroductionGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookUpProvider) {
        super(output, IntroductionMod.MOD_ID, lookUpProvider);
    }

    @Override
    protected void start() {
        // 廃ポータルのチェスト
        add("orihalcon_ingot_from_ruined_portal", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()
        }, IntroductionItems.ORIHALCON_INGOT.get()));
        // ゾンビのドロップ
        add("orihalcon_ingot_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, IntroductionItems.ORIHALCON_INGOT.get()));
        // スニッファーの掘り出し物
        add("orihalcon_ingot_from_sniffer_digging", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build()
        }, IntroductionItems.ORIHALCON_INGOT.get(), 0.5f));
        // 怪しげな砂
        add("orihalcon_ingot_from_sus_sand", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("archaeology/desert_pyramid")).build()
        }, IntroductionItems.ORIHALCON_INGOT.get(), 0.5f));
    }
}
