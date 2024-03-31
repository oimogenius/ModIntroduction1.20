package com.github.oimogenius.introductionmod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ReplaceItemModifier extends LootModifier {
    // CODEC：Java <-> JSONへの変換をするための機能
    public static final Supplier<Codec<ReplaceItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item))
            .and(Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance))
            .apply(inst, ReplaceItemModifier::new)));

    private final Item item;
    private final float chance;

    public ReplaceItemModifier(LootItemCondition[] conditionsIn, Item item, float chance) {
        super(conditionsIn);
        this.item = item;
        this.chance = chance;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // 戦利品を追加する条件をチェック
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                // チェックに不合格の場合、追加せずに返却
                return generatedLoot;
            }
        }

        if (context.getRandom().nextFloat() < chance) {
            // チェックに合格した場合、既存のアイテムをクリアして上書き
            generatedLoot.clear();
            generatedLoot.add(new ItemStack(this.item));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
