package com.coolness.epicness.items.other.atoms;

import java.util.List;

import com.coolness.epicness.Elements;
import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ItemAtom extends Item {
	public ItemAtom() {
		// setMaxDamage(28);
		setUnlocalizedName(Reference.RedstoneItems.ATOM.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.ATOM.getRegistryName());
		setCreativeTab(Elements.tabElements);
	}

	// tooltip.set(0, I18n.format("table.name." + e.unlocalizedName) + " (" +
	// e.atomicNumber + ")§r");
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		int tooltipPos = 1;
		Elements.Element e = Elements.elements[stack.getItemDamage()];
		tooltip.add(tooltipPos++, "§o§8" + getName(e.unlocalizedName) + ":§r");
		tooltip.add(tooltipPos++, Elements.atomic_symbol + e.atomicSymbol + "§r");
		tooltip.add(tooltipPos++, Elements.atomic_number + e.atomicNumber + "§r");
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int i = 0; i < Elements.elements.length; i++) {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("Color", MoreMineralsMod.atomColors[i]);
			items.add(new ItemStack(item, 1, i, nbt));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for (int i = 0; i < Elements.elements.length; i++) {
			if (stack.getItemDamage() == i) {
				return "table." + Elements.elements[i].unlocalizedName;
			} else {
				continue;
			}
		}
		return "table.name." + Elements.elements[0].unlocalizedName;
	}

	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public int getMetadata(ItemStack stack) {
		if (stack.hasTagCompound()) {
			if (!stack.getTagCompound().hasKey("Color")) {
				int color = MoreMineralsMod.atomColors[stack.getItemDamage()];
				int[] atoms = stack.getTagCompound().getIntArray("Atoms");
				stack.getTagCompound().setInteger("Color", color);
			}
		}
		return super.getMetadata(stack);
	}

	public String getName(String s) {
		return I18n.format("table." + s + ".name");
	}

	public String getDescription(String s) {
		return I18n.format("table.description." + s);
	}
}
