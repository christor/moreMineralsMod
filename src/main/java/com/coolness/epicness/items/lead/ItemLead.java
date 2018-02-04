package com.coolness.epicness.items.lead;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLead extends ItemFood{

	private PotionEffect[] effects;
	
	public ItemLead(int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.RedstoneItems.LEAD.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.LEAD.getRegistryName());
		this.setAlwaysEdible();
		this.setCreativeTab(ItemRegistry.tabMinerals);
		this.effects = potionEffects;
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldin, EntityPlayer player){
		for(PotionEffect effect : effects){
			player.addPotionEffect(effect);
		}
	}

}
