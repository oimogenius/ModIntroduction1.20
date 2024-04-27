package com.github.oimogenius.introductionmod.datagen.client;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, IntroductionMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(IntroductionItems.RAW_ORIHALCON, "Raw Orihalcon");
        addItem(IntroductionItems.ORIHALCON_INGOT, "Orihalcon Ingot");

        add("creativetabs.introduction_tab", "Introdution");

        addBlock(IntroductionBlocks.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(IntroductionBlocks.RAW_ORIHALCON_BLOCK, "Raw Orihalcon Block");
        addBlock(IntroductionBlocks.ORIHALCON_ORE, "Orihalcon Ore");
        addBlock(IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE, "Deepslate Orihalcon Ore");
        addBlock(IntroductionBlocks.CURSED_LOG, "Cursed Log");
        addBlock(IntroductionBlocks.STRIPPED_CURSED_LOG, "Stripped Cursed Log");
        addBlock(IntroductionBlocks.CURSED_WOOD, "Cursed Wood");
        addBlock(IntroductionBlocks.STRIPPED_CURSED_WOOD, "Stripped Cursed Wood");
        addBlock(IntroductionBlocks.CURSED_LEAVES, "Cursed Leaves");
    }
}
