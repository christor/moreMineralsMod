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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;
import scala.xml.Elem;

public class ItemMolecule extends Item {
// ItemPotion
	public ItemMolecule() {
		setUnlocalizedName(Reference.RedstoneItems.COMPOUND.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.COMPOUND.getRegistryName());
		setCreativeTab(Elements.tabIons);
	}
	@Override
	public int getMetadata(ItemStack stack) {
		if (!stack.getTagCompound().hasKey("Color1")) {
			int[] atoms = stack.getTagCompound().getIntArray("Atoms");
			byte el1 = decode(atoms[0])[0];
			byte el2 = decode(atoms[0])[2];
			stack.getTagCompound().setInteger("Color1", MoreMineralsMod.atomColors[el1]);
			stack.getTagCompound().setInteger("Color2", MoreMineralsMod.atomColors[el2]);
		}
		return super.getMetadata(stack);
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
		for(byte i = 0; i < Elements.elements.length; i++){
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

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
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
