package com.quatalog.rpimod.forge.client;

import com.quatalog.rpimod.RPIMod;
import com.quatalog.rpimod.client.RPIModClient;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/*
 * This is our forge client entrypoint-ish. 
 * 
 * The @Mod.EventBusSubscriber annotation subscribes this class to the event bus, in this case our client mod bus
 */
@Mod.EventBusSubscriber(value=Dist.CLIENT, modid=RPIMod.MOD_ID, bus=Bus.MOD)
public class RPIModForgeClient {
    // this is called on FMLClientSetupEvent
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) { 

        RPIMod.LOGGER.info("hi from forge client !");

        // init our common client code
        RPIModClient.init();
    }
}
