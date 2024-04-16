package com.github.oimogenius.introductionmod.datagen.client;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionBlockStateProvider extends BlockStateProvider {
    public IntroductionBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IntroductionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(IntroductionBlocks.ORIHALCON_BLOCK);
        simpleBlockWithItem(IntroductionBlocks.RAW_ORIHALCON_BLOCK);
        simpleBlockWithItem(IntroductionBlocks.ORIHALCON_ORE);
        simpleBlockWithItem(IntroductionBlocks.DEEPSLATE_ORIHALCON_ORE);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
