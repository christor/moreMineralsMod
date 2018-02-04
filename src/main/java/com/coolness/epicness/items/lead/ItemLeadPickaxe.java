package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemPickaxe;

public class ItemLeadPickaxe extends ItemPickaxe {
	public ItemLeadPickaxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.LEAD_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_PICKAXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
}
