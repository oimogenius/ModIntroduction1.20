package com.github.oimogenius.introductionmod.block;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.custom.IntroductionLeavesBlock;
import com.github.oimogenius.introductionmod.block.custom.IntroductionLogBlock;
import com.github.oimogenius.introductionmod.block.custom.IntroductionStrippableLogBlock;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class IntroductionBlocks {
    // レジストリを作成
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IntroductionMod.MOD_ID);

    // レジストリにブロックを追加
    public static final RegistryObject<Block> ORIHALCON_BLOCK = registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> RAW_ORIHALCON_BLOCK = registerBlockItem(
            "raw_orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ORIHALCON_ORE = registerBlockItem("orihalcon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_ORIHALCON_ORE = registerBlockItem(
            "deepslate_orihalcon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    // 呪われた木
    public static final RegistryObject<Block> STRIPPED_CURSED_LOG = registerBlockItem(
            "stripped_cursed_log",
            () -> new IntroductionLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> STRIPPED_CURSED_WOOD = registerBlockItem(
            "stripped_cursed_wood",
            () -> new IntroductionLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> CURSED_LOG = registerBlockItem(
            "cursed_log",
            () -> new IntroductionStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_LOG));
    public static final RegistryObject<Block> CURSED_WOOD = registerBlockItem(
            "cursed_wood",
            () -> new IntroductionStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_WOOD));
    public static final RegistryObject<Block> CURSED_LEAVES = registerBlockItem(
            "cursed_leaves",
            () -> new IntroductionLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));


    /* ブロックアイテム作成用メソッド */
    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier) {
        // レジストリにブロックを追加
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        // ブロックアイテムをアイテムレジストリに追加
        IntroductionItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        // レジストリをイベントバスに登録
        BLOCKS.register(eventBus);
    }
}
