package com.coolness.epicness.items.tungsten;

import java.util.List;

import com.coolness.epicness.VanillaTooltipManager;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTungstenIngot extends Item{
	public ItemTungstenIngot(){
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_INGOT.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_INGOT.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
}
