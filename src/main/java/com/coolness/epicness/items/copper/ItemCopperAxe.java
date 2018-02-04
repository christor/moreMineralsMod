package com.coolness.epicness.items.copper;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.items.ItemModAxe;

import net.minecraft.init.Items;

public class ItemCopperAxe extends ItemModAxe {

	public ItemCopperAxe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.COPPER_AXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_AXE.getRegistryName());
        this.damageVsEntity = 9f;
        this.attackSpeed = -3f;
        setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}

}
