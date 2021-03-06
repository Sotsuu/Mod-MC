package com.sotsuu.mdg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sotsuu.mdg.core.init.BlockInit;
import com.sotsuu.mdg.core.init.ItemInit;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;

@Mod("mdg")
@Mod.EventBusSubscriber(modid = MDG.MOD_ID, bus = Bus.MOD)
public class MDG {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mdg";

	public MDG() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName(block.getRegistryName()));
		});
	}

}