package com.github.oimogenius.introductionmod.entity;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.entity.custom.SheepSlime;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
                    IntroductionMod.MOD_ID);
    public static final RegistryObject<EntityType<SheepSlime>> SHEEP_SLIME =
            ENTITY_TYPES.register("sheep_slime",
                    () -> EntityType.Builder.of(SheepSlime::new, MobCategory.MONSTER)
                            .build("sheep_slime"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
