# Items

Items control a lot of the game so it's important to understand how they work.

First there's the difference between the `Item` and `ItemStack` classes. `Item` objects represent item types, so stuff like `DIAMOND`, `STONE_PICKAXE`, or `DIRT_BLOCK`, while `ItemStack` objects refer to specific stacks of items, like ones in your inventory, in a chest, or dropped on the ground. Throughout the rest of this, 'item' will generally refer to a type of item, while 'stack' will be a specific stack of items.

## Adding new features

Only items with no special mechanics or abilities (like sticks or coal) will be made directly with `new Item(..)`, instead you'll usually see items being made from more specific classes that extend `Item`, like `MiningToolItem` for pickaxes, or your own classes for your own items (like `EmpaxelItem` for example). These classes can override many of `Item`'s methods to change the items behavior, like overriding `use(..)` to add special behavior to right clicking. I highly encourage you to poke through `Item` and see all the different methods it has, think about how you can use those as hooks to implement various features.

The other way to add features to an item is with the `Settings` that the `Item` constructor takes in. Here you can tweak common features, like being able to eat the item, the stack size, or if it's fireproof. This is less useful for complicated features, but still, good to know.

Finally, there are `Tags`, these are defined by data packs and can be used to indicate that your item should behave in specific ways in other contexts. For example `minecraft:piglin_loved` is a tag that changes how piglins interact with your item and `create:upright_on_belt` is a tag that changes how the create mod will render your item on conveyor belts. You can also define your own tags to allow easy interop and configuration with other mods and datapacks!

### NBT

A quick note on NBT. Item stacks use nbt to store data about the specific stack, so stuff like the durability, enchantments, custom name, etc. You can store whatever data you need to in nbt, although there's a *very* heavy rework to item nbt in version 1.20.5, so I highly suggest keeping all of your nbt operations abstracted away from your main logic so that it's easier to change in the future. 

## Make items pretty

Items render based on the model with id `[modid]:item/[itemname]`. So `rpimod:empaxel` would render based on `rpimod:item/empaxel`, which we define with `resources/data/rpimod/models/item/empaxel.json`

You can read more about the [model format here](https://minecraft.wiki/w/Model).

Note that BlockItems need an item model too for how they display in your inventory, but you can just have it extend the block model.

Finally, you'll need to give your item a translation. You can do this in `resources/assets/[modid]/lang/en_us.json` (or whatever other languages you speak and want to add translations for).