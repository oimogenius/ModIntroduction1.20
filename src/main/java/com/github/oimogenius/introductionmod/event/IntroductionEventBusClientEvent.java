package com.github.oimogenius.introductionmod.event;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.entity.IntroductionEntities;
import com.github.oimogenius.introductionmod.entity.model.SheepSlimeModel;
import com.github.oimogenius.introductionmod.entity.renderer.SheepSlimeRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IntroductionMod.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD,
    value = Dist.CLIENT)
public class IntroductionEventBusClientEvent {
    @SubscribeEvent
    public static void registerLayerDefinitions(
            EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SheepSlimeModel.LAYER_LOCATION,
                SheepSlimeModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderer(
            EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(IntroductionEntities.SHEEP_SLIME.get(),
                SheepSlimeRenderer::new);
    }
}
