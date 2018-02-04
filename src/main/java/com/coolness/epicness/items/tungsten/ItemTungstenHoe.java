package com.coolness.epicness.items.tungsten;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemHoe;

public class ItemTungstenHoe extends ItemHoe{

	public ItemTungstenHoe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_HOE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_HOE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}

}
