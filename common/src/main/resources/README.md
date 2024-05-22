# Common Resources

This is where all of the mod's resources go. Resources are generally split into either `data` or `assets`, although sometimes you'll see stuff floating around outside of there, like the `rpimod.mixins.json`, for example. 

The `data`/`assets` split corresponds to [data packs](https://minecraft.wiki/w/Data_pack) and [resource packs](https://minecraft.wiki/w/Resource_pack) respectively, meaning `data` is for server resources, while `assets` is for client resources. These generally use the same formats as packs do, so adding recipes and textures and all that for your own mods is the same as making a resource or data pack, just it goes in here instead of in an actual pack !

### General Format

Resource directory paths generally follow the pattern of `resources/assets/[modid]/[resourcetype]/[specific_resource]`. For example, the block texture for rpidium ore is located at `resources/assets/rpimod/textures/block/rpidium_ore.png`. 

When the resource is actually used, either in other parts of the data/resource packs, or in the code, the resource type is generally given by the context, and so the resource's identifier becomes just `modid:specific_resource`. For example, when you're using the rpidium ore texture, it's identifier would be just `rpimod:block/rpidium_ore`. Note that the file extension is removed from it.