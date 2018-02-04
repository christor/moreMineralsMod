package com.coolness.epicness.items.lead;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.Item;

public class ItemLeadIngot extends Item{
	public ItemLeadIngot(){
		setUnlocalizedName(Reference.RedstoneItems.LEAD_INGOT.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_INGOT.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
}
