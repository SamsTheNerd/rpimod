# Common Code

All of your common java code goes in here (if you use kotlin it'll be in a separate directory). The specifics of how the code is organized is mostly up to you, but there are some standards you'll see. 

Usually the only actual file you'll see in here will be the entrypoint-ish one with the name of the mod, so in this case `RPIMod.java`, everything else usually goes in a subdirectory. You'll often see a `registry` folder for all of files dealing with registering items, blocks, entities, and whatnot, and then separate folders such as `items` or `blocks` for the actual classes backing the items, blocks, etc. Some other common folders you'll see are `network`, `renderers`, `entities`, `blockentities`, and `client`, although again, these are just common practice and there's nothing special to the names.

The only folder you have to be a bit careful about is your `mixin` folder, which doesn't *have* to be named `mixin`, it's just whatever package you put in your `[modid-or-something].mixins.json`. This folder can only contain mixin classes and all mixin classes in this subproject must go in this folder or a subfolder of it.

Otherwise though, how you organize your code is entirely up to you. Following these conventions can make it easier for others to quickly understand your project setup, but as long as there's some organizational structure to it, it's fine.