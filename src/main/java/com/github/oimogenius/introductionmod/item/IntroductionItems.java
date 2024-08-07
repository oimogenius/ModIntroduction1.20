package com.github.oimogenius.introductionmod.item;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.entity.IntroductionEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class IntroductionItems {
    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IntroductionMod.MOD_ID);

    // レジストリにアイテムを追加
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHEEP_SLIME_SPAWN_EGG = ITEMS.register(
            "sheep_slime_spawn_egg",
            () -> new ForgeSpawnEggItem(IntroductionEntities.SHEEP_SLIME,
                    Color.MAGENTA.getRGB(), Color.lightGray.getRGB(),
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventBus);
    }
}
