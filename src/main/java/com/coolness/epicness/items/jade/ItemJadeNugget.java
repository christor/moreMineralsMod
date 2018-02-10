package com.coolness.epicness.items.copper;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperNugget extends Item {
	public ItemCopperNugget(){
		setUnlocalizedName(Reference.RedstoneItems.COPPER_NUGGET.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_NUGGET.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
}
