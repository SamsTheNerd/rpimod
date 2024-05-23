package com.quatalog.rpimod.fabric.client;

import com.quatalog.rpimod.RPIMod;
import com.quatalog.rpimod.client.RPIModClient;

import net.fabricmc.api.ClientModInitializer;

/*
 * This is the fabric client entrypoint, also defined in fabric.mod.json
 * 
 * This code is only run on the client, this is where you should initialize client only bits 
 * such as anything rendering related.
 */
public final class RPIModFabricClient implements ClientModInitializer {
    // This is called on the client when the mod is being initalized.
    @Override
    public void onInitializeClient() {

        RPIMod.LOGGER.info("Howdy from fabric client !");

        // initialize our common client code
        RPIModClient.init();
    }
}
