package com.coolness.epicness.items.copper;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemSpade;

public class ItemCopperShovel extends ItemSpade{

	public ItemCopperShovel(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.COPPER_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_SHOVEL.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}

}
