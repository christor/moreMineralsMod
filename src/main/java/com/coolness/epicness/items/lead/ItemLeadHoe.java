package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemHoe;

public class ItemLeadHoe extends ItemHoe{

	public ItemLeadHoe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.LEAD_HOE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_HOE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}

}
