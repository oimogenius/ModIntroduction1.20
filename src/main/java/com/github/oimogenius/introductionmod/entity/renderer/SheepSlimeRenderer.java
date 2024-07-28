package com.github.oimogenius.introductionmod.entity.renderer;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.entity.custom.SheepSlime;
import com.github.oimogenius.introductionmod.entity.model.SheepSlimeModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Slime;
import org.jetbrains.annotations.Nullable;

public class SheepSlimeRenderer extends MobRenderer<SheepSlime, SheepSlimeModel<SheepSlime>> {
    private static final ResourceLocation SHEEP_SLIME_LOCATION =
            new ResourceLocation(IntroductionMod.MOD_ID,
                    "textures/entity/sheep_slime.png");

    public SheepSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,
                new SheepSlimeModel<>(pContext.bakeLayer(SheepSlimeModel.LAYER_LOCATION)),
                0.25f);
    }

    public void render(SheepSlime pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = 0.25F * (float)pEntity.getSize();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    protected void scale(SheepSlime pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float f = 0.999F;
        pPoseStack.scale(0.999F, 0.999F, 0.999F);
        pPoseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)pLivingEntity.getSize();
        float f2 = Mth.lerp(pPartialTickTime, pLivingEntity.oSquish, pLivingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        pPoseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Nullable
    @Override
    protected RenderType getRenderType(SheepSlime pLivingEntity, boolean pBodyVisible, boolean pTranslucent, boolean pGlowing) {
        ResourceLocation resourceLocation =
                this.getTextureLocation(pLivingEntity);
        return RenderType.entityTranslucent(resourceLocation, true);
    }

    @Override
    public ResourceLocation getTextureLocation(SheepSlime pEntity) {
        return SHEEP_SLIME_LOCATION;
    }
}
