package com.coolness.epicness.items.other;

import java.util.List;
import java.util.Random;

import com.coolness.epicness.CoolSoundHandler;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import cofh.redstoneflux.impl.ItemEnergyContainer;
import net.minecraft.block.BlockMelon;
import net.minecraft.block.BlockStem;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemGeigerCounter extends Item {
	protected int radiation_level;
	protected int tick;
	protected Random rand = new Random();
	
	public ItemGeigerCounter(int radiation_level, int tick){
		setUnlocalizedName(Reference.RedstoneItems.GEIGER_COUNTER.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.GEIGER_COUNTER.getRegistryName());
		setCreativeTab(ItemRegistry.tabMinerals);
		this.radiation_level = radiation_level;
		this.tick = tick;
	}

	public ItemGeigerCounter setRadiationLevel(int radiation_level) {
		this.radiation_level = radiation_level;
		return this;
	}
	public ItemGeigerCounter setTick(int tick) {
		this.tick = tick;
		return this;
	}
	// BlockStem
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		tick++;
		if(isSelected) {
			entityIn.sendMessage(new TextComponentString("§c" + radiation_level + " Sieverts§r"));
			if(tick % radiation_level == 0){
				if(rand.nextInt(10) == 0){
					worldIn.playSound((EntityPlayer)null, entityIn.posX, entityIn.posY, entityIn.posZ, CoolSoundHandler.GEIGER_COUNTER_SOUND_2, SoundCategory.PLAYERS, 1.0F, 1.0F + rand.nextFloat() * 0.3f - 0.15F);
				} else {
					worldIn.playSound((EntityPlayer)null, entityIn.posX, entityIn.posY, entityIn.posZ, CoolSoundHandler.GEIGER_COUNTER_SOUND_1, SoundCategory.PLAYERS, 1.0F, 1.0F + rand.nextFloat() * 0.3f - 0.15F);
				}
				tick = 0;
			}
		}
	}
}
