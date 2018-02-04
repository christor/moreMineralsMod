package com.coolness.epicness.items.other;

import java.util.List;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSulfur extends Item {
	public ItemSulfur(){
		setUnlocalizedName(Reference.RedstoneItems.SULFUR.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.SULFUR.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("§c§oSmells Like Rotten Eggs...§r");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
