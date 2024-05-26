package com.quatalog.rpimod.blocks;

import com.quatalog.rpimod.registry.RPIModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/*
 * This is the class for our RPIdium block. We have a separate class for this so that we can change the `onUse` method.
 */
public class RPIdiumBlock extends Block{
    public RPIdiumBlock(Settings settings){
        super(settings);
    }

    // this runs when you right click the block
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // only run on the server
        if(world.isClient){
            return ActionResult.SUCCESS; // on the client just swing the arm
        }
        
        // launch an rpidium crystal out the top of the block
        ItemStack crystalItem = RPIModItems.RPIDIUM_CRYSTAL_ITEM.get().getDefaultStack();
        ItemEntity itemEnt = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, crystalItem, 0, 0.25, 0);
        world.spawnEntity(itemEnt);

        return ActionResult.SUCCESS;
    }
}
