package com.github.oimogenius.introductionmod.block.custom;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

// 原木、木用のクラス
public class IntroductionStrippableLogBlock extends IntroductionLogBlock{
    private final Supplier<Block> strippedLog;

    public IntroductionStrippableLogBlock(Properties pProperties, Supplier<Block> strippedLog) {
        super(pProperties);
        this.strippedLog = strippedLog;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        // 斧で右クリックした場合、樹皮を剥いだ原木に変更
        if (toolAction == ToolActions.AXE_STRIP) {
            return strippedLog.get().defaultBlockState()
                    .setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
