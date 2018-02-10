package com.coolness.epicness.items.copper;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemPickaxe;

public class ItemCopperPickaxe extends ItemPickaxe{

	public ItemCopperPickaxe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.COPPER_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_PICKAXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
	
}
