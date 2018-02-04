package com.coolness.epicness.items.other;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCorn extends ItemFood{

	private PotionEffect[] effects;
	
	public ItemCorn(int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.RedstoneItems.CORN.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.CORN.getRegistryName());
		this.setCreativeTab(ItemRegistry.tabMinerals);
		this.effects = potionEffects;
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World worldin, EntityPlayer player){
		for(PotionEffect effect : effects){
			player.addPotionEffect(effect);
		}
		//EntityVillager
		//worldin.createExplosion(player, (player.posX + (Math.random() * 16)), (player.posY + (Math.random() * 16)), (player.posZ + (Math.random() * 16)), 5.0f, true);
	}

}
