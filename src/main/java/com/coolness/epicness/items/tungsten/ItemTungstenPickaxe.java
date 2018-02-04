package com.coolness.epicness.items.tungsten;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemPickaxe;

public class ItemTungstenPickaxe extends ItemPickaxe {
	public ItemTungstenPickaxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_PICKAXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
}
