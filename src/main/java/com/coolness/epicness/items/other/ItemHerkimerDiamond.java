package com.coolness.epicness.items.other;

import java.util.List;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHerkimerDiamond extends Item {
	public ItemHerkimerDiamond(){
		setUnlocalizedName(Reference.RedstoneItems.HERKIMER_DIAMOND.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.HERKIMER_DIAMOND.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("§9§oShiny...§r");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
