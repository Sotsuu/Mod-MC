package com.sotsuu.mdg.core.init;

import com.sotsuu.mdg.MDG;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MDG.MOD_ID);

	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
}
