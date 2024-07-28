package com.github.oimogenius.introductionmod;

import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import com.github.oimogenius.introductionmod.entity.IntroductionEntities;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import com.github.oimogenius.introductionmod.item.IntroductionTabs;
import com.github.oimogenius.introductionmod.loot.IntroductionLootModifiers;
import com.github.oimogenius.introductionmod.worldgen.biome.IntroductionOverworldRegion;
import com.github.oimogenius.introductionmod.worldgen.biome.IntroductionSurfaceRuleData;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(IntroductionMod.MOD_ID)
public class IntroductionMod {
    public static final String MOD_ID = "introductionmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IntroductionMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // アイテムレジストリをイベントバスに登録
        IntroductionItems.register(modEventBus);
        // クリエイティブタブレジストリをイベントバスに登録
        IntroductionTabs.register(modEventBus);
        // ブロックレジストリをイベントバスに登録
        IntroductionBlocks.register(modEventBus);
        // GlobalLootModifierレジストリをイベントバスに登録
        IntroductionLootModifiers.register(modEventBus);
        // エンティティレジストリをイベントバスに登録
        IntroductionEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Modのロード時に、RegionとSurfaceRuleを読み込ませる
            Regions.register(new IntroductionOverworldRegion(
                    new ResourceLocation(
                            IntroductionMod.MOD_ID, "overworld"
                    ), 5));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,
                    MOD_ID, IntroductionSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // 材料タブにオリハルコンを追加
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(IntroductionItems.RAW_ORIHALCON);
            event.accept(IntroductionItems.ORIHALCON_INGOT);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
