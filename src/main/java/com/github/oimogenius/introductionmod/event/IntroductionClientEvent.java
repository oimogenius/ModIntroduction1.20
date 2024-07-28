package com.github.oimogenius.introductionmod.event;

import com.github.oimogenius.introductionmod.IntroductionMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IntroductionMod.MOD_ID, value = Dist.CLIENT)
public class IntroductionClientEvent {
    @SubscribeEvent
    public static void mouseDraggedEvent(ScreenEvent.MouseDragged event) {
//        System.out.println("Mouse Dragged!!");
    }

}
