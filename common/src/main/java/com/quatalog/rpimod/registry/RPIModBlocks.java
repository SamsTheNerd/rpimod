package com.quatalog.rpimod.registry;

import java.util.function.Supplier;

import com.quatalog.rpimod.RPIMod;
import com.quatalog.rpimod.blocks.RPIdiumBlock;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/*
 * This is where we register our blocks
 */
public class RPIModBlocks {

    // this is architectury's deferred register, specifically for blocks from our mod.
    private static DeferredRegister<Block> blocks = DeferredRegister.create(RPIMod.MOD_ID, RegistryKeys.BLOCK);

    public static final RegistrySupplier<Block> RPIDIUM_BLOCK = block("rpidium_block",
        () -> new RPIdiumBlock( // block's class is RPIdiumBlock, our own class which extends Block
            AbstractBlock.Settings.create() // need to have some block settings. check out that class to see what else you can do !
                .mapColor(MapColor.BRIGHT_RED) // this is just the color that shows up on the map for the block
                .requiresTool() // only drops if mined with the correct tool (defined using Tags)
                .strength(3.0F, 3.0F) // defines how long it will take to mine and how easy to explode it is
        ));

    // register an ore block with the id `rpimod:rpidium_ore`
    // stored as a RegistrySupplier. It won't give you the block until it's actually registered.
    public static final RegistrySupplier<Block> RPIDIUM_ORE_BLOCK = block("rpidium_ore", 
        () -> new ExperienceDroppingBlock( // block's class is ExperienceDroppingBlock, a vanilla class that extends Block
            AbstractBlock.Settings.create()
                .mapColor(MapColor.STONE_GRAY)
                .requiresTool()
                .strength(3.0F, 3.0F),
            UniformIntProvider.create(3, 7) // drop somewhere between 3 and 7 exp
        ));

    /*
     * A helper method we'll use for registering our blocks and their corresponding block item.
     */
    public static <T extends Block> RegistrySupplier<T> block(String name, Supplier<T> block, Item.Settings settings) {
        RegistrySupplier<T> blockRegistered = blockNoItem(name, block);
        RPIModItems.item(name, () -> new BlockItem(blockRegistered.get(), settings));
		return blockRegistered;
	}

    // Another helper method but uses the default item settings.
    public static <T extends Block> RegistrySupplier<T> block(String name, Supplier<T> block) {
        return block(name, block, RPIModItems.defaultSettings());
	}

    // Registers only the block, not the block item.
    public static <T extends Block> RegistrySupplier<T> blockNoItem(String name, Supplier<T> block) {
		return blocks.register(new Identifier(RPIMod.MOD_ID, name), block);
	}

    // tells the registry that we're ready for registering. shouldn't add any more after calling this.
    // note that this should be called before calling RPIModItems.register()
    public static void register(){
        blocks.register();
    }
}
