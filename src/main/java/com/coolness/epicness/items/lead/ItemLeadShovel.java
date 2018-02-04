package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemLeadShovel extends ItemSpade {
	public ItemLeadShovel(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.LEAD_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_SHOVEL.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
}
