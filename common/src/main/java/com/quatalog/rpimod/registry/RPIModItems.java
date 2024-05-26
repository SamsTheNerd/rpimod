package com.quatalog.rpimod.registry;

import java.util.function.Supplier;

import com.quatalog.rpimod.RPIMod;
import com.quatalog.rpimod.items.EmpaxelItem;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/*
 * This is where we add our items.
 */
public class RPIModItems {
    
    // arch deferred registry for items
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(RPIMod.MOD_ID, RegistryKeys.ITEM);
    // arch deferred registry for tabs
    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(RPIMod.MOD_ID, RegistryKeys.ITEM_GROUP);

    // register an item with nothing particularly special and id `rpimod:rpidium_crystal`
    public static final RegistrySupplier<Item> RPIDIUM_CRYSTAL_ITEM = item("rpidium_crystal",
        () -> new Item(defaultSettings()));

    public static final RegistrySupplier<EmpaxelItem> EMPAXEL_ITEM = item("empaxel",
        () -> new EmpaxelItem(defaultSettings()));

    // make our creative tab.
    public static final RegistrySupplier<ItemGroup> RPI_MOD_GROUP = TABS.register("rpimod_tab", () ->
        CreativeTabRegistry.create(Text.translatable("itemgroup.rpimod.general"),
                () -> new ItemStack(Items.REDSTONE)));

    /*
     * Helper function for registering an item.
     * register the item supplied with the id `rpimod:name`
     */
    public static <T extends Item> RegistrySupplier<T> item(String name, Supplier<T> item) {
		return ITEMS.register(new Identifier(RPIMod.MOD_ID, name), item);
	}

    // returns default item settings, here it just puts the item in rpi mod tab
    public static Item.Settings defaultSettings(){
        return new Item.Settings().arch$tab(RPI_MOD_GROUP);
    }

    // tell the registry that we're ready for registering. 
    // note: should be called after RPIModBlocks.register() since the block items rely on the blocks being registered.
    // 
    public static void register(){
        TABS.register();
        ITEMS.register();
    }
}
