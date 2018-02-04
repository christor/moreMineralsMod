package com.coolness.epicness.items.mithril;

import java.util.List;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMithrilIngot extends Item{
	public ItemMithrilIngot(){
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_INGOT.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_INGOT.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
//	@Override
//	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
//		tooltip.add("§6§o§lMithril!§r§6 All folk desired it. It could be beaten like copper, and polished like glass; and the Dwarves could make of it a metal, light and yet harder than tempered steel. Its beauty was like to that of common silver, but the beauty of mithril did not tarnish or grow dim§r");
//		super.addInformation(stack, playerIn, tooltip, advanced);
//	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}

}
