package com.coolness.epicness.items.copper;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemHoe;

public class ItemCopperHoe extends ItemHoe{

	public ItemCopperHoe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.COPPER_HOE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_HOE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}

}
