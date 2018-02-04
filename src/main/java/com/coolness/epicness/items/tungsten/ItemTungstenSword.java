package com.coolness.epicness.items.tungsten;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemTungstenSword extends ItemSword {
	public ItemTungstenSword(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_SWORD.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_SWORD.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsCombat);
	}
}
