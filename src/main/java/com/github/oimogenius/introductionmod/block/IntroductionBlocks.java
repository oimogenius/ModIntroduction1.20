package com.github.oimogenius.introductionmod.block;

import com.github.oimogenius.introductionmod.IntroductionMod;
import com.github.oimogenius.introductionmod.block.custom.IntroductionLeavesBlock;
import com.github.oimogenius.introductionmod.block.custom.IntroductionLogBlock;
import com.github.oimogenius.introductionmod.block.custom.IntroductionStrippableLogBlock;
import com.github.oimogenius.introductionmod.item.IntroductionItems;
import com.github.oimogenius.introductionmod.worldgen.tree.IntroductionTreeGrowers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> RAW_ORIHALCON_BLOCK = registerBlockItem(
            "raw_orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> ORIHALCON_ORE = registerBlockItem("orihalcon_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_ORIHALCON_ORE = registerBlockItem(
            "deepslate_orihalcon_ore",
            () -> new DropExperienceBlock(UniformInt.of(0, 0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    // 呪われた木
    public static final RegistryObject<Block> STRIPPED_CURSED_LOG = registerBlockItem(
            "stripped_cursed_log",
            () -> new IntroductionLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> STRIPPED_CURSED_WOOD = registerBlockItem(
            "stripped_cursed_wood",
            () -> new IntroductionLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> CURSED_LOG = registerBlockItem(
            "cursed_log",
            () -> new IntroductionStrippableLogBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_LOG));
    public static final RegistryObject<Block> CURSED_WOOD = registerBlockItem(
            "cursed_wood",
            () -> new IntroductionStrippableLogBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_WOOD));
    public static final RegistryObject<Block> CURSED_LEAVES = registerBlockItem(
            "cursed_leaves",
            () -> new IntroductionLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    // 板材
    public static final RegistryObject<Block> CURSED_PLANKS = registerBlockItem(
            "cursed_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // ハーフブロック
    public static final RegistryObject<Block> CURSED_SLAB = registerBlockItem(
            "cursed_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // 階段
    public static final RegistryObject<Block> CURSED_STAIRS = registerBlockItem(
            "cursed_stairs",
            () -> new StairBlock(IntroductionBlocks.CURSED_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // フェンス
    public static final RegistryObject<Block> CURSED_FENCE = registerBlockItem(
            "cursed_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // フェンスゲート
    public static final RegistryObject<Block> CURSED_FENCE_GATE = registerBlockItem(
            "cursed_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS),
                    SoundEvents.BONE_BLOCK_PLACE, SoundEvents.SHEEP_DEATH));
    // ドア
    public static final RegistryObject<Block> CURSED_DOOR = registerBlockItem(
            "cursed_door",
            () -> new DoorBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // トラップドア
    public static final RegistryObject<Block> CURSED_TRAPDOOR = registerBlockItem(
            "cursed_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    // ボタン
    public static final RegistryObject<Block> CURSED_BUTTON = registerBlockItem(
            "cursed_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // 感圧板
    public static final RegistryObject<Block> CURSED_PRESSURE_PLATE = registerBlockItem(
            "cursed_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // 苗木
    public static final RegistryObject<Block> CURSED_SAPLING = registerBlockItem(
            "cursed_sapling",
            () -> new SaplingBlock(IntroductionTreeGrowers.CURSED_TREE,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


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
