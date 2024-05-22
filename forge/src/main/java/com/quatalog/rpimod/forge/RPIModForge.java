package com.quatalog.rpimod.forge;

import com.quatalog.rpimod.RPIMod;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/*
 * This is the forge entrypoint-ish, defined by the @Mod annotation
 * 
 * A single instance of this class gets made, you can then use the Event Bus system
 * to run your code on various events, including client setup.
 */
@Mod(RPIMod.MOD_ID)
public final class RPIModForge {
    public RPIModForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(RPIMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        RPIMod.init();
    }
}
