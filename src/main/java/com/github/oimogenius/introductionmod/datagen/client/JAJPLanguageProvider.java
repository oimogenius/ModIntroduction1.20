package com.github.oimogenius.introductionmod.datagen.client;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, IntroductionMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(IntroductionItems.RAW_ORIHALCON, "オリハルコンの原石");
        addItem(IntroductionItems.ORIHALCON_INGOT, "オリハルコンインゴット");

        add("creativetabs.introduction_tab", "入門");

        addBlock(IntroductionBlocks.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(IntroductionBlocks.RAW_ORIHALCON_BLOCK, "オリハルコンの原石ブロック");
        addBlock(IntroductionBlocks.ORIHALCON_ORE, "オリハルコン鉱石");
        addBlock(IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE, "深層オリハルコン鉱石");

        addBlock(IntroductionBlocks.CURSED_LOG, "呪われた原木");
        addBlock(IntroductionBlocks.STRIPPED_CURSED_LOG, "樹皮を剥いだ呪われた原木");
        addBlock(IntroductionBlocks.CURSED_WOOD, "呪われた木");
        addBlock(IntroductionBlocks.STRIPPED_CURSED_WOOD, "樹皮を剥いだ呪われた木");
        addBlock(IntroductionBlocks.CURSED_LEAVES, "呪われた葉");

        addBlock(IntroductionBlocks.CURSED_PLANKS, "呪われた板材");
        addBlock(IntroductionBlocks.CURSED_SLAB, "呪われたハーフブロック");
        addBlock(IntroductionBlocks.CURSED_STAIRS, "呪われた階段");
        addBlock(IntroductionBlocks.CURSED_FENCE, "呪われたフェンス");
        addBlock(IntroductionBlocks.CURSED_FENCE_GATE, "呪われたフェンスゲート");
        addBlock(IntroductionBlocks.CURSED_DOOR, "呪われたドア");
        addBlock(IntroductionBlocks.CURSED_TRAPDOOR, "呪われたトラップドア");
        addBlock(IntroductionBlocks.CURSED_BUTTON, "呪われたボタン");
        addBlock(IntroductionBlocks.CURSED_PRESSURE_PLATE, "呪われた感圧板");

        addBlock(IntroductionBlocks.CURSED_SAPLING, "呪われた苗木");
    }
}
