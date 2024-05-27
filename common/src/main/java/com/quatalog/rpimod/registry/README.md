# Registries

Registries are quite simple but can trip people up when they're first starting. 

They exist to keep track of Things, whether that's blocks, items, entity types, dimensions, or whatever else. They're functionally quite similar to Maps but with a few extra rules, for one you can usually only register your Thing as the game is starting up (before you call your `someRegistry.register()`), after that the registry is frozen and you'll get an error if you try to register anything else. You'll also have to use a valid [identifier](https://minecraft.wiki/w/Resource_location) for the id/key. 

Once your Thing is registered, it'll be added to the game! So registering an item will allow it to exist in game for example. You'll need to do a few extra steps for it to look and behave how you want it to, but that's the next step. Architectury keeps your registered Things wrapped in `RegistrySupplier`s, so you'll need to use `.get()` to access them - although this may be null during setup. You can also search a registry itself and retrieve the Thing registered to a specific ID.

One tricky bit of the modding vocab is that for some registry types you register a `Thing` and for others you register a `ThingType`, for example you register a `Block` or `Item` and a `EntityType` or `BlockEntityType`. It turns out, in all cases you're really registering something Type-like, but some types have instances represented as java objects and some don't. For example, `Blocks.DIAMOND_BLOCK` is an object of type `Block`, and only this one object exists no matter how many diamond blocks are placed in the world. To refer to a specific block placed in the world, you'd just refer to it by its position. Similarly with items, each item type exists as a single object of type `Item`, while individual stacks are accessed by `ItemStack`s, which are mostly just wrappers around `NBT` data. Compare these to entities (like a sheep) and block entities (like a chest) which have a java object for each individual one. So `Entity` refers to a *specific* entity, like a zombie chasing you, or your pet axolotl, and therefore `EntityType` is needed to refer to the general type. 

## Deferred Registries / "why am i only crashing on forge"

Deferred registries are a little silly. The basic idea is that everything gets queued up to be registered and then is registered all at once when it's the proper time. This means that there's a period of time during setup when you may be able to access the `RegistrySupplier` without it being properly registered yet, and accessing it during this time can return null and give you a crash. To get around this you can usually just use `.listen()` to attach a callback for when it gets registered.

This behavior only really happens on forge though, since fabric is happy to register your Thing the second it gets it, and so you may get crashes on forge while it runs fine on fabric. 