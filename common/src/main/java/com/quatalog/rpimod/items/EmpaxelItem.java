package com.quatalog.rpimod.items;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.tag.BlockTags;

/*
 * This is the class for our Empaxel item. It extends MiningToolItem because that's pretty close to what we want to do.
 */
public class EmpaxelItem extends MiningToolItem {
    public EmpaxelItem(Settings settings){
        // based on a diamond pickaxe, except we want to make it work for pickaxe, axe, and shovel tags
        super(1, -2.8f, ToolMaterials.DIAMOND, BlockTags.PICKAXE_MINEABLE, settings);
    }

    // overriding getMiningSpeedMultiplier and isSuitableFor to check all 3 tags 
    // NOTE: it's generally not ideal to have to reimplement code when you're overriding methods, but sometimes it can't be easily avoided

    private boolean isInEffectiveTags(BlockState state){
        return state.isIn(BlockTags.PICKAXE_MINEABLE) 
            || state.isIn(BlockTags.AXE_MINEABLE)
            || state.isIn(BlockTags.SHOVEL_MINEABLE);
    }

    // this tells the game what speed it should mine at
    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return isInEffectiveTags(state) ? this.miningSpeed : 1.0f;
    }

    // this tells the game what blocks it can effectively mine
    @Override
    public boolean isSuitableFor(BlockState state) {
        int i = this.getMaterial().getMiningLevel();
        if (i < MiningLevels.DIAMOND && state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return false;
        }
        if (i < MiningLevels.IRON && state.isIn(BlockTags.NEEDS_IRON_TOOL)) {
            return false;
        }
        if (i < MiningLevels.STONE && state.isIn(BlockTags.NEEDS_STONE_TOOL)) {
            return false;
        }
        return isInEffectiveTags(state);
    }
}
