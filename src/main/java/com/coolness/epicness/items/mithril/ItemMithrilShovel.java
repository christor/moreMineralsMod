package com.coolness.epicness.items.mithril;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemMithrilShovel extends ItemSpade {
	public ItemMithrilShovel(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_SHOVEL.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}
