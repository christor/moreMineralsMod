package com.coolness.epicness.items.copper;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemCopperSword extends ItemSword {
	public ItemCopperSword(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.COPPER_SWORD.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_SWORD.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsCombat);
	}
}
