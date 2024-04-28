package com.github.oimogenius.introductionmod.item;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionTabs {
    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntroductionMod.MOD_ID);

    // レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> INTRODUCTION_TAB = TABS.register("introduction_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.introduction_tab"))
                    .icon(IntroductionItems.RAW_ORIHALCON.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(IntroductionItems.RAW_ORIHALCON.get());
                        pOutput.accept(IntroductionItems.ORIHALCON_INGOT.get());
                        pOutput.accept(IntroductionBlocks.ORIHALCON_BLOCK.get());
                        pOutput.accept(IntroductionBlocks.RAW_ORIHALCON_BLOCK.get());
                        pOutput.accept(IntroductionBlocks.ORIHALCON_ORE.get());
                        pOutput.accept(IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE.get());
                        pOutput.accept(IntroductionBlocks.CURSED_LOG.get());
                        pOutput.accept(IntroductionBlocks.STRIPPED_CURSED_LOG.get());
                        pOutput.accept(IntroductionBlocks.CURSED_WOOD.get());
                        pOutput.accept(IntroductionBlocks.STRIPPED_CURSED_WOOD.get());
                        pOutput.accept(IntroductionBlocks.CURSED_LEAVES.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        // クリエイティブタブをイベントバスに登録
        TABS.register(eventBus);
    }
}
