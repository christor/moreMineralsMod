package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.items.ItemModAxe;

import net.minecraft.item.Item.ToolMaterial;

public class ItemLeadAxe extends ItemModAxe {
	public ItemLeadAxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.LEAD_AXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD_AXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
        this.damageVsEntity = 8f;
        this.attackSpeed = -3f;
	}
}
