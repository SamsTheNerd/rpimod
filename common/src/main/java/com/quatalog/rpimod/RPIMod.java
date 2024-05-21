package com.quatalog.rpimod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * It seems to be tradition to name your entrypoint class just the name of your mod. 
 * 
 * Since we're working in multi-loader, this isn't a formal entrypoint, the loaders don't call it directly,
 * instead you'll see the actual entrypoint (RPIModFabric or RPIModForge) calling it when they're initialized.
 * 
 * Generally everything here is gonna be static and you won't ever have an instance of this class.
 * 
 * Usually this class will just call other, more specific, classes and tell them it's time to initialize.
 * Sometimes you'll see fields for objects that get accessed a lot throughout the mod, like a logger or MOD_ID
 * 
 * NOTE: This is called on both the server and client.
 */
public final class RPIMod {
    // your mod has a modid that works as a unique identifier for it. 
    // You'll use this as the namespace for Identifiers (you'll sometimes see them called ResLocs since Mojmap kinda cooked with that)
    // NOTE: this needs to follow id rules, so lowercase, numbers, and ._- only
    public static final String MOD_ID = "rpimod";

    // This lets you print to the console while the game runs with RPIMod.LOGGER.info(..) (or .error(..) or .debug(..) )
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // We'll call this in our loader specific entrypoints when it's initialization time.
    public static void init() {

    }
}
