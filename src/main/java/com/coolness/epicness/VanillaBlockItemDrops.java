package com.coolness.epicness;

import com.coolness.epicness.init.ItemRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VanillaBlockItemDrops {
	@SubscribeEvent
	public void yourPlayerHarvestEvent(HarvestDropsEvent event) {
		if (event.getHarvester() != null) {
			
			if (event.getState().getBlock() == Blocks.QUARTZ_ORE) {
				if(Math.random() < 0.01){
					event.setDropChance(1f);
					event.getDrops().add(new ItemStack(ItemRegistry.herkimer_diamond,1));
				}
			}
			
		}
	}
}
