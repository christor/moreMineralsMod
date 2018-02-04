package com.coolness.epicness.items.mithril;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMithrilSword extends ItemSword {
	public ItemMithrilSword(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_SWORD.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_SWORD.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsCombat);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}
