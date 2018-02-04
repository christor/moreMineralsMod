package com.coolness.epicness.items.mithril;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMithrilHoe extends ItemHoe{

	public ItemMithrilHoe(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_HOE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_HOE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}
