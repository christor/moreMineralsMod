package com.coolness.epicness.items.lead;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;

public class ItemLeadArmor extends ItemArmor{

	public ItemLeadArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(Reference.MODID,unlocalizedName));
		setCreativeTab(MoreMineralsMod.tabMineralsCombat);
	}

}
