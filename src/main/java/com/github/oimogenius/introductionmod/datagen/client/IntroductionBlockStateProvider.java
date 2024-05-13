package com.github.oimogenius.introductionmod.datagen.client;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.IntroductionBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        logBlock((RotatedPillarBlock) IntroductionBlocks.CURSED_LOG.get());
        logBlock((RotatedPillarBlock) IntroductionBlocks.STRIPPED_CURSED_LOG.get());
        axisBlock((RotatedPillarBlock) IntroductionBlocks.CURSED_WOOD.get(),
                blockTexture(IntroductionBlocks.CURSED_LOG.get()),
                blockTexture(IntroductionBlocks.CURSED_LOG.get()));
        axisBlock((RotatedPillarBlock) IntroductionBlocks.STRIPPED_CURSED_WOOD.get(),
                blockTexture(IntroductionBlocks.STRIPPED_CURSED_LOG.get()),
                blockTexture(IntroductionBlocks.STRIPPED_CURSED_LOG.get()));
        item(IntroductionBlocks.CURSED_LOG);
        item(IntroductionBlocks.STRIPPED_CURSED_LOG);
        item(IntroductionBlocks.CURSED_WOOD);
        item(IntroductionBlocks.STRIPPED_CURSED_WOOD);
        cursedLeaves(IntroductionBlocks.CURSED_LEAVES);

        simpleBlockWithItem(IntroductionBlocks.CURSED_PLANKS);
        slabBlock((SlabBlock) IntroductionBlocks.CURSED_SLAB.get(),
                // 二つ重ねたときのテクスチャ
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()),
                // 単体のテクスチャ
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
        stairsBlock((StairBlock) IntroductionBlocks.CURSED_STAIRS.get(),
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
        fenceBlock((FenceBlock) IntroductionBlocks.CURSED_FENCE.get(),
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) IntroductionBlocks.CURSED_FENCE_GATE.get(),
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) IntroductionBlocks.CURSED_DOOR.get(),
                modLoc("block/cursed_door_bottom"),
                modLoc("block/cursed_door_top"),
                "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock)
                        IntroductionBlocks.CURSED_TRAPDOOR.get(),
                modLoc("block/cursed_trapdoor"), true,
                "cutout");
        buttonBlock((ButtonBlock) IntroductionBlocks.CURSED_BUTTON.get(),
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock)
                        IntroductionBlocks.CURSED_PRESSURE_PLATE.get(),
                blockTexture(IntroductionBlocks.CURSED_PLANKS.get()));
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                IntroductionMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 呪われた葉ブロック
    private void cursedLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeTop(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                TextureMapping.getBlockTexture(block.get(), "_side"),
                TextureMapping.getBlockTexture(block.get(), "_top")
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }
}
