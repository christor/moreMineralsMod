package com.coolness.epicness;

import com.coolness.epicness.init.ItemRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == ItemRegistry.sulfur)
			return 900;
		return 0;
	}

}
