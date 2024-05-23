package com.quatalog.rpimod.client;

import com.quatalog.rpimod.RPIMod;

/*
 * This is where we'll initialize our common client code.
 */
public class RPIModClient {
    // We'll call this from each loader's client entrypoint
    public static void init() {
        RPIMod.LOGGER.info("Hello from common client !");
    }
}
