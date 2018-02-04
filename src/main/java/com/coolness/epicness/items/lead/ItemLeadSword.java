package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemLeadSword extends ItemSword {
	public ItemLeadSword(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.LEAD_SWORD.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_SWORD.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsCombat);
	}
}
