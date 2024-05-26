# Blocks

Block types are represented as objects of type `Block`. Specific blocks in the world are just refered to by their position and blockstate, and blocks in your inventory are actually just items. 

Block states are a way to store limited state information about a block. Usually with only a couple of possible states per block, such as being powered by redstone or facing a certain direction. Blockstates work by defining some set of properties that the blockstate can represent, with a limited set of possible values for each. When the game starts up, a blockstate is created for every possible combination of these values, so if you need to store many different states, it's probably better to consider using a Block Entity. 

## Adding features

Similarly to Items, you can add features to your block by having your block's class extend the `Block` class and override its methods, use the `Settings` that are passed to each `Block` constructor, or add your block to tags. 

The block settings have a lot more to them than the item settings, you can change the speed of going over the blocks, make them jumpier, change their brightness, change how quickly they can be mined, and quite a good bit more. 

If you want your block to be mineable with a pickaxe or other tool, you'll want to add the block to the `minecraft:blocks/mineable/[tool-type]` tag. And if you want your block to drop anything (including itself) when broken, you'll need to add a loot table for it in `resources/data/[modid]/loot_tables/block/[block_name]`

## Pretty blocks

Blocks use the same [model format](https://minecraft.wiki/w/Model) as items do, but also require a [blockstate json](https://minecraft.wiki/w/Tutorials/Models#Block_states) in `resources/assets/[modid]/blockstates/[block_name]`

If you have a non-full opaque block, such as a slab, glass, or flower pot, you'll need to set the block as `nonOpaque` in the block's settings. And if you want to use transparent or cutout textures like you would with glass or slime, you'd need to set the [render layer for the block](https://fabricmc.net/wiki/tutorial:blockappearance)