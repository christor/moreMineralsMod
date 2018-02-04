package com.coolness.epicness.items.copper;

import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCopperIngot extends Item {
	public ItemCopperIngot() {
		setUnlocalizedName(Reference.RedstoneItems.COPPER_INGOT.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_INGOT.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}
}
