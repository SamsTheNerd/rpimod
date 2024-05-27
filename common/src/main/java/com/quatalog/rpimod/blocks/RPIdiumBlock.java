package com.quatalog.rpimod.blocks;

import net.minecraft.block.Block;

/*
 * This is the class for our RPIdium block. We have a separate class for this so that we can change the `onUse` method.
 */
public class RPIdiumBlock extends Block{
    public RPIdiumBlock(Settings settings){
        super(settings);
    }

    /* [ ADD RIGHT CLICK FUNCTIONALITY ]

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

    */
}
