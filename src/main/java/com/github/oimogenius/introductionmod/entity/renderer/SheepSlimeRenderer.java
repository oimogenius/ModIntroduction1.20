package com.github.oimogenius.introductionmod.entity.renderer;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.entity.custom.SheepSlime;
import com.github.oimogenius.introductionmod.entity.model.SheepSlimeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SheepSlimeRenderer extends MobRenderer<SheepSlime, SheepSlimeModel<SheepSlime>> {
    private static final ResourceLocation SHEEP_SLIME_LOCATION =
            new ResourceLocation(IntroductionMod.MOD_ID,
                    "textures/entity/sheep_slime.png");

    public SheepSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,
                new SheepSlimeModel<>(pContext.bakeLayer(SheepSlimeModel.LAYER_LOCATION)),
                0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SheepSlime pEntity) {
        return SHEEP_SLIME_LOCATION;
    }
}
