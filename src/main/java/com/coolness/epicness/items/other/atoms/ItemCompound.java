package com.coolness.epicness.items.other.atoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.w3c.dom.css.RGBColor;

import com.coolness.epicness.Elements;
import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.Elements.Element;
import com.coolness.epicness.init.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;
import scala.xml.Elem;

public class ItemCompound extends Item {
	// ItemPotion
	protected boolean isFirstTick = true;

	public ItemCompound() {
		setUnlocalizedName(Reference.RedstoneItems.COMPOUND.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COMPOUND.getRegistryName());
		setCreativeTab(Elements.tabIons);
	}

	/*
	 * @Override public int getMetadata(ItemStack stack) { if
	 * (stack.hasTagCompound()) { if (!stack.getTagCompound().hasKey("Color")) {
	 * int color = 0; int[] atoms = stack.getTagCompound().getIntArray("Atoms");
	 * for (int i = 0; i < atoms.length; i++) { byte el1 = decode(atoms[i])[0];
	 * byte c1 = decode(atoms[i])[1]; byte el2 = decode(atoms[i])[2]; byte c2 =
	 * decode(atoms[i])[3]; if (el2 != 127) { color += el1 * c1 / (atoms.length
	 * / 4); color += el2 * c2 / (atoms.length / 4); } else { color += el1 * c1
	 * / atoms.length; } } stack.getTagCompound().setInteger("Color", color); }
	 * } return super.getMetadata(stack); }
	 */
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		if (stack.hasTagCompound()) {
			if (!stack.getTagCompound().hasKey("Color")) {
				System.out.println("Stack no has key, \"Color\" but we're setting it rn lol");
				long color = 0;
				int[] atoms = stack.getTagCompound().getIntArray("Atoms");
				int elementCount = 0;
				for (int i = 0; i < atoms.length; i++) {
					byte el1 = decode(atoms[i])[0];
					byte c1 = decode(atoms[i])[1];
					byte el2 = decode(atoms[i])[2];
					byte c2 = decode(atoms[i])[3];
					color += MoreMineralsMod.atomColors[el1] * c1;
					elementCount += c1;
					if (el2 != 127) {
						color += MoreMineralsMod.atomColors[el2] * c2;
						elementCount += c2;
					}
					
				}
				stack.getTagCompound().setInteger("Color", (int)color/elementCount);
			}
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (stack.getTagCompound() != null) {
			int[] atoms = stack.getTagCompound().getIntArray("Atoms");
			for (int i = 0; i < atoms.length; i++) {
				byte el1 = decode(atoms[i])[0];
				byte c1 = decode(atoms[i])[1];
				byte el2 = decode(atoms[i])[2];
				byte c2 = decode(atoms[i])[3];

				tooltip.add(I18n.format("table." + Elements.elements[el1].unlocalizedName + ".name") + '('
						+ Elements.elements[el1].atomicSymbol + ", " + el1 + ") x" + c1);

				if (el2 != 127) {
					tooltip.add(I18n.format("table." + Elements.elements[el2].unlocalizedName + ".name") + '('
							+ Elements.elements[el2].atomicSymbol + ", " + el2 + ") x" + c2);
				}

			}
		} else {
			System.out.println(
					"Stack has no tag compound, adding NULLLLLLLLL!1!!!!!!11!!1 to tooltip! - addInformation();");
			tooltip.add("NULLLLLLLLL!1!!!!!!11!!1");
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
		for (byte i = 0; i < Elements.elements.length; i++) {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setIntArray("Atoms", new int[] { encode(i, (byte) 1, i, (byte) 1) });
			System.out.println(nbt.getIntArray("Atoms"));
			items.add(new ItemStack(item, 1, 0, nbt));
		}
	}

	public int getAtomColor(Element e) {
		return MoreMineralsMod.atomColors[e.atomicNumber - 1];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		StringBuilder unlocalizedName = new StringBuilder();
		if (stack.getTagCompound() != null) {
			int[] atoms = stack.getTagCompound().getIntArray("Atoms");
			for (int i = 0; i < atoms.length; i++) {
				byte el1 = decode(atoms[i])[0];
				byte c1 = decode(atoms[i])[1];
				byte el2 = decode(atoms[i])[2];
				byte c2 = decode(atoms[i])[3];
				unlocalizedName.append(Elements.elements[el1].atomicSymbol + c1);
				if (el2 != 127) {
					unlocalizedName.append(" " + Elements.elements[el2].atomicSymbol + c2);
				}
			}
			return unlocalizedName.toString();
		} else {
			System.out.println(
					"Stack has no tag compound, setting unlocalizedName to NUUUULLLL! - getUnlocalizedName();");
			return "NUUUULLLL";
		}
	}

	public int encode(byte el1, byte c1, byte el2, byte c2) {
		return el1 | (c1 << 8) | (el2 << 16) | (c2 << 24);
	}

	public byte[] decode(int coded) {
		return new byte[] { (byte) (coded & 0xFF), (byte) ((coded >> 8) & 0xFF), (byte) ((coded >> 16) & 0xFF),
				(byte) ((coded >> 24) & 0xFF) };
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getName(String s) {
		return I18n.format("table." + s + ".name");
	}

	public String getDescription(String s) {
		return I18n.format("table.description." + s);
	}
}
