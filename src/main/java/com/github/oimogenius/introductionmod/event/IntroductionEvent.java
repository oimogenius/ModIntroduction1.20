package com.github.oimogenius.introductionmod.event;

import com.github.oimogenius.introductionmod.IntroductionMod;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IntroductionMod.MOD_ID)
public class IntroductionEvent {
    @SubscribeEvent
    public static void pickUpItemEvent(EntityItemPickupEvent event) {
        String itemName = event.getItem().getItem().getDisplayName().getString();
        event.getEntity().sendSystemMessage(
                Component.literal(itemName + "を拾ったよ"));
    }

}
