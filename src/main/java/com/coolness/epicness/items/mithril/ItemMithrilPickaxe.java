package com.coolness.epicness.items.mithril;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMithrilPickaxe extends ItemPickaxe {
	public ItemMithrilPickaxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_PICKAXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}
