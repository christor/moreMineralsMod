package com.coolness.epicness.items.tungsten;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemTungstenShovel extends ItemSpade {
	public ItemTungstenShovel(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_SHOVEL.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
}
