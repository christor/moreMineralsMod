package com.coolness.epicness;

import java.util.List;

import com.coolness.epicness.Elements.Element;
import com.coolness.epicness.radiation.RadiationWorldSavedData;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.ChunkEvent.Load;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {
	@SubscribeEvent
	public void onWorldLoadEvent(Load event) {
		if(!event.getWorld().isRemote) {
			MoreMineralsMod.radiationWorldSavedData = RadiationWorldSavedData.get(event.getWorld());
		}
	}
	@SubscribeEvent
	public void tooltipEvent(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		List<String> tooltip = event.getToolTip();
		Item item = stack.getItem();

		int tooltipPos = 1;
		if (Elements.mineralComponents.containsKey(item)) {
			tooltip.add(tooltipPos++, getDescription(item.getUnlocalizedName()));
			for (Element element : Elements.mineralComponents.get(item)) {
				tooltip.add(tooltipPos++, "§o§8" + getName(element.unlocalizedName) + ":§r");
				tooltip.add(tooltipPos++, Elements.atomic_symbol + element.atomicSymbol + "§r");
				tooltip.add(tooltipPos++, Elements.atomic_number + element.atomicNumber + "§r");
			}
		}
	}

	public String getName(String s) {
		return I18n.format("table." + s + ".name");
	}

	public String getDescription(String s) {
		return I18n.format("table.description." + s);
	}
}
