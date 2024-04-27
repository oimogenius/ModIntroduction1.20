package com.github.oimogenius.introductionmod.tag;

import com.github.oimogenius.introductionmod.IntroductionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class IntroductionTags {
    public static class Blocks {
        public static final TagKey<Block> CURSED_LOG = tag("cursed_log");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(IntroductionMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CURSED_LOG = tag("cursed_log");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(IntroductionMod.MOD_ID, name));
        }
    }
}
