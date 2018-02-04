package com.coolness.epicness.items.copper;

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

public class ItemCopperWire extends Item {
	public ItemCopperWire(){
		setUnlocalizedName(Reference.RedstoneItems.COPPER_WIRE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COPPER_WIRE.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
		setMaxStackSize(1);
	}
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//		 
//		 return super.onItemRightClick(worldIn, playerIn, handIn);
//		
//	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("§6§oCrafting Ingredient§r");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
