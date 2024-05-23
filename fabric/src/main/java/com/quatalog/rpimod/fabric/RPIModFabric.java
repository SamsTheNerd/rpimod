package com.quatalog.rpimod.fabric;

import com.quatalog.rpimod.RPIMod;

import net.fabricmc.api.ModInitializer;

/*
 * This is our Fabric entrypoint, as defined in our fabric.mod.json
 * 
 * You'll see that the onInitialize() method is not static like it is in common, 
 * as far as I know, this is just so that it can implement the ModInitializer interface, 
 * so you can still just use statics for fields you'd like to access from other classes.
 * 
 * NOTE: this is called on both the server and client.
 */
public final class RPIModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        RPIMod.LOGGER.info("Hi hi from fabric !");

        // Run our common setup.
        RPIMod.init();
    }
}
