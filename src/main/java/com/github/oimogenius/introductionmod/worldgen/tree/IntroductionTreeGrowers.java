package com.github.oimogenius.introductionmod.worldgen.tree;

import com.github.oimogenius.introductionmod.worldgen.features.IntroductionFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class IntroductionTreeGrowers {
    public static final TreeGrower CURSED_TREE = new TreeGrower(
            "cursed_tree", Optional.empty(),
            Optional.of(IntroductionFeatures.CURSED_TREE_KEY),
            Optional.empty());
}
