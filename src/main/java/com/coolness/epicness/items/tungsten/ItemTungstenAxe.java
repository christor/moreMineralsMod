package com.coolness.epicness.items.tungsten;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.items.ItemModAxe;

import net.minecraft.item.Item.ToolMaterial;

public class ItemTungstenAxe extends ItemModAxe {
	public ItemTungstenAxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.TUNGSTEN_AXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.TUNGSTEN_AXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
        this.damageVsEntity = 10f;
        this.attackSpeed = -3f;
	}
}
