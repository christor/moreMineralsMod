package com.coolness.epicness;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.math.Fraction;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Magenta;

import com.coolness.epicness.init.ItemRegistry;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

public class Elements {
	public static String atomic_number = I18n.format("table.atomic_number");
	public static String atomic_symbol = I18n.format("table.atomic_symbol");
	public static HashMap<Item, List<Element>> mineralComponents = new HashMap<Item, List<Element>>();

	public static void registerMineralComponents() {
		mineralComponents.put(ItemRegistry.tungsten_ingot, Arrays.asList(new Element[] { tungsten }));
		mineralComponents.put(ItemRegistry.copper_ingot, Arrays.asList(new Element[] { tungsten }));
		mineralComponents.put(ItemRegistry.copper_nugget, Arrays.asList(new Element[] { tungsten }));
		mineralComponents.put(ItemRegistry.sulfur, Arrays.asList(new Element[] { sulfur }));
		mineralComponents.put(ItemRegistry.lead_ingot, Arrays.asList(new Element[] { lead }));
		mineralComponents.put(ItemRegistry.lead, Arrays.asList(new Element[] { lead }));
		mineralComponents.put(ItemRegistry.uranium, Arrays.asList(new Element[] { uranium }));
		mineralComponents.put(ItemRegistry.lead, Arrays.asList(new Element[] { tungsten }));
		mineralComponents.put(Items.COAL, Arrays.asList(new Element[] { hydrogen, carbon, nitrogen, oxygen, sulfur }));
		mineralComponents.put(Items.DIAMOND, Arrays.asList(new Element[] { carbon }));
		mineralComponents.put(Items.IRON_INGOT, Arrays.asList(new Element[] { iron }));
		mineralComponents.put(Items.field_191525_da, Arrays.asList(new Element[] { iron }));
		mineralComponents.put(Items.GOLD_INGOT, Arrays.asList(new Element[] { gold }));
		mineralComponents.put(Items.GOLD_NUGGET, Arrays.asList(new Element[] { gold }));
		mineralComponents.put(Items.EMERALD, Arrays.asList(new Element[] { beryllium, aluminum, chromium }));
	}

	public static Element hydrogen = new Element(1, "H", "hydrogen");
	public static Element helium = new Element(2, "He", "helium");
	public static Element lithium = new Element(3, "Li", "lithium");
	public static Element beryllium = new Element(4, "Be", "beryllium");
	public static Element boron = new Element(5, "B", "boron");
	public static Element carbon = new Element(6, "C", "carbon");
	public static Element nitrogen = new Element(7, "N", "nitrogen");
	public static Element oxygen = new Element(8, "O", "oxygen");
	public static Element fluorine = new Element(9, "F", "fluorine");
	public static Element neon = new Element(10, "Ne", "neon");
	public static Element sodium = new Element(11, "Na", "sodium");
	public static Element magnesium = new Element(12, "Na", "magnesium");
	public static Element aluminum = new Element(13, "Al", "aluminum");
	public static Element silicon = new Element(14, "Si", "silicon");
	public static Element phosphorus = new Element(15, "P", "phosphorus");
	public static Element sulfur = new Element(16, "S", "sulfur");
	public static Element chlorine = new Element(17, "Cl", "chlorine");
	public static Element argon = new Element(18, "Ar", "argon");
	public static Element potassium = new Element(19, "K", "potassium");
	public static Element calcium = new Element(20, "Ca", "calcium");
	public static Element scandium = new Element(21, "Sc", "scandium");
	public static Element titanium = new Element(22, "Ti", "titanium");
	public static Element vanadium = new Element(23, "V", "vanadium");
	public static Element chromium = new Element(24, "Cr", "chromium");
	public static Element manganese = new Element(25, "Mn", "manganese");
	public static Element iron = new Element(26, "Fe", "iron");
	
	public static Element cobalt = new Element(27, "Co", "cobalt");
	public static Element nickel = new Element(28, "Ni", "nickel");
	public static Element copper = new Element(29, "Cu", "copper");
	public static Element zinc = new Element(30, "Zn", "zinc");
	public static Element gallium = new Element(31, "Ga", "gallium");
	public static Element germanium = new Element(32, "Ge", "germanium");
	public static Element arsenic = new Element(33, "As", "arsenic");
	public static Element selenium = new Element(34, "Se", "selenium");
	public static Element bromine = new Element(35, "Br", "bromine");
	public static Element krypton = new Element(36, "Kr", "krypton");
	public static Element rubidium = new Element(37, "Rb", "rubidium");
	public static Element strontium = new Element(38, "Sr", "strontium");
	public static Element yttrium = new Element(39, "Y", "yttrium");
	public static Element zirconium = new Element(40, "Zr", "zirconium");
	public static Element niobium = new Element(41, "Nb", "niobium");
	public static Element molybdenum = new Element(42, "Mo", "molybdenum");
	public static Element technetium = new Element(43, "Tc", "technetium");
	public static Element ruthenium = new Element(44, "Ru", "ruthenium");
	public static Element rhodium = new Element(45, "Rh", "rhodium");
	public static Element palladium = new Element(46, "Pd", "palladium");
	
	public static Element tungsten = new Element(74, "W", "tungsten");
	public static Element gold = new Element(79, "Au", "gold");
	
	public static Element lead = new Element(82, "Pb", "lead");

	public static Element uranium = new Element(92, "U", "uranium");
	
	public static Element[] elements = { hydrogen, helium, lithium, beryllium, boron, carbon, nitrogen, oxygen,
			fluorine, neon, sodium, magnesium, aluminum, silicon, phosphorus, sulfur, chlorine, argon, potassium,
			calcium, scandium, titanium, vanadium, chromium, manganese, iron, cobalt, nickel, copper, zinc, gallium,
			germanium, arsenic, selenium, bromine, krypton, rubidium, strontium, yttrium, zirconium, niobium, molybdenum,
			technetium, ruthenium, rhodium, palladium,

			tungsten, gold, lead, uranium };

	public static class Element {
		public int atomicNumber;
		public String atomicSymbol;
		public String unlocalizedName;

		public Element(int atomicNumber, String atomicSymbol, String unlocalizedName) {
			this.atomicNumber = atomicNumber;
			this.atomicSymbol = atomicSymbol;
			this.unlocalizedName = unlocalizedName;
		}
	}
	public static CreativeTabs tabElements = new CreativeTabs("tab_elements") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.atom);
		}
	};
}
