package com.coolness.epicness.items.uranium;

import java.util.List;

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

public class ItemUranium extends Item {
	public ItemUranium() {
		setUnlocalizedName(Reference.RedstoneItems.URANIUM.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.URANIUM.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		EntityPlayer player = worldIn.getClosestPlayerToEntity(entityIn, 2);
		if (!player.isCreative()) {
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 3000, 1));
			ItemStack boots = player.inventory.armorItemInSlot(0);
			ItemStack legs = player.inventory.armorItemInSlot(1);
			ItemStack chest = player.inventory.armorItemInSlot(2);
			ItemStack head = player.inventory.armorItemInSlot(3);
			// Radiation Protective Armor(Lead And Tungsten)
			if (!((boots.getItem() == ArmorRegistry.tungsten_boots || boots.getItem() == ArmorRegistry.lead_boots)
					&& (legs.getItem() == ArmorRegistry.tungsten_leggings
							|| legs.getItem() == ArmorRegistry.lead_leggings)
					&& (chest.getItem() == ArmorRegistry.tungsten_chestplate
							|| chest.getItem() == ArmorRegistry.lead_chestplate)
					&& (head.getItem() == ArmorRegistry.tungsten_helmet
							|| head.getItem() == ArmorRegistry.lead_helmet))) {
				// 19 = poison, 20 = wither, 17 = hunger, 18 = weakness, 2 =
				// slowness
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 600, 0));
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 300, 0));
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 1200, 1));
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 1200, 1));
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 3000, 1));
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
}
