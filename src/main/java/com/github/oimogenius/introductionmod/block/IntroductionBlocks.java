package com.github.oimogenius.introductionmod.block;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
