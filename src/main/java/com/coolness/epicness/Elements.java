package com.coolness.epicness;

import java.util.HashMap;
import java.util.List;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	};

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

	public static Element silver = new Element(47, "Ag", "silver");
	public static Element cadmium = new Element(48, "Cd", "cadmium");
	public static Element indium = new Element(49, "In", "indium");

	public static Element tin = new Element(50, "Sn", "tin");
	public static Element antimony = new Element(51, "Sb", "antimony");
	public static Element tellurium = new Element(52, "Te", "tellurium");
	public static Element iodine = new Element(53, "I", "iodine");
	public static Element xenon = new Element(54, "Xe", "xenon");
	public static Element cesium = new Element(55, "Cs", "cesium");
	public static Element barium = new Element(56, "Ba", "barium");
	public static Element lanthanum = new Element(57, "L", "lanthanum");
	public static Element cerium = new Element(58, "Ce", "cerium");
	public static Element praseodymium = new Element(59, "Pr", "praseodymium");

	public static Element neodymium = new Element(60, "Nd", "neodymium");
	public static Element promethium = new Element(61, "Pm", "promethium");
	public static Element samarium = new Element(62, "Sm", "samarium");
	public static Element europium = new Element(63, "Eu", "europium");
	public static Element gadolinium = new Element(64, "Gd", "gadolinium");
	public static Element terbium = new Element(65, "Tb", "terbium");
	public static Element dysprosium = new Element(66, "Dy", "dysprosium");
	public static Element holmium = new Element(67, "Ho", "holmium");
	public static Element erbium = new Element(68, "Er", "erbium");
	public static Element thulium = new Element(69, "Tm", "thulium");

	public static Element ytterbium = new Element(70, "Yb", "ytterbium");
	public static Element lutetium = new Element(71, "Lu", "lutetium");
	public static Element hafnium = new Element(72, "Hf", "hafnium");
	public static Element tantalum = new Element(73, "Ta", "tantalum");
	public static Element tungsten = new Element(74, "W", "tungsten");
	public static Element rhenium = new Element(75, "Re", "rhenium");
	public static Element osmium = new Element(76, "Os", "osmium");
	public static Element iridium = new Element(77, "Ir", "iridium");
	public static Element platinum = new Element(78, "Pt", "platinum");
	public static Element gold = new Element(79, "Au", "gold");

	public static Element mercury = new Element(80, "Hg", "mercury");
	public static Element thallium = new Element(81, "Th", "thallium");
	public static Element lead = new Element(82, "Pb", "lead");
	public static Element bismuth = new Element(83, "Bi", "bismuth");
	public static Element polonium = new Element(84, "Po", "polonium");
	public static Element astatine = new Element(85, "At", "astatine");
	public static Element radon = new Element(86, "Rn", "radon");
	public static Element francium = new Element(87, "Fr", "francium");
	public static Element radium = new Element(88, "Ra", "radium");
	public static Element actinium = new Element(89, "Ac", "actinium");

	public static Element thorium = new Element(90, "Th", "thorium");
	public static Element protactinium = new Element(91, "Pa", "protactinium");
	public static Element uranium = new Element(92, "U", "uranium");
	public static Element neptunium = new Element(93, "Np", "neptunium");
	public static Element plutonium = new Element(94, "Pu", "plutonium");
	public static Element americium = new Element(95, "Am", "americium");
	public static Element curium = new Element(96, "Cm", "curium");
	public static Element berkelium = new Element(97, "Bk", "berkelium");
	public static Element californium = new Element(98, "Cf", "californium");
	public static Element einsteinium = new Element(99, "Es", "einsteinium");

	public static Element fermium = new Element(100, "Fm", "fermium");
	public static Element mendelevium = new Element(101, "Md", "mendelevium");
	public static Element nobelium = new Element(102, "No", "nobelium");
	public static Element lawrencium = new Element(103, "Lr", "lawrencium");
	public static Element rutherfordium = new Element(104, "Rf", "rutherfordium");
	public static Element dubnium = new Element(105, "Db", "dubnium");
	public static Element seaborgium = new Element(106, "Sg", "seaborgium");
	public static Element bohrium = new Element(107, "Bh", "bohrium");
	public static Element hassium = new Element(108, "Hs", "hassium");
	public static Element meitnerium = new Element(109, "Mt", "meitnerium");

	public static Element darmstadtium = new Element(110, "Ds", "darmstadtium");
	public static Element roentgenium = new Element(111, "Rg", "roentgenium");
	public static Element copernicium = new Element(112, "Cn", "copernicium");
	public static Element nihonium = new Element(113, "Nh", "nihonium");
	public static Element flerovium = new Element(114, "Fl", "flerovium");
	public static Element moscovium = new Element(115, "Mc", "moscovium");
	public static Element livermorium = new Element(116, "Lv", "livermorium");
	public static Element tennessine = new Element(117, "Ts", "tennessine");
	public static Element oganesson = new Element(118, "Og", "oganesson");

	public static Element[] elements = { hydrogen, helium, lithium, beryllium, boron, carbon, nitrogen, oxygen,
			fluorine, neon, sodium, magnesium, aluminum, silicon, phosphorus, sulfur, chlorine, argon, potassium,
			calcium, scandium, titanium, vanadium, chromium, manganese, iron, cobalt, nickel, copper, zinc, gallium,
			germanium, arsenic, selenium, bromine, krypton, rubidium, strontium, yttrium, zirconium, niobium,
			molybdenum, technetium, ruthenium, rhodium, palladium, silver, cadmium, indium, tin, antimony, tellurium,
			iodine, xenon, cesium, barium, lanthanum, cerium, praseodymium, neodymium, promethium, samarium, europium,
			gadolinium, terbium, dysprosium, holmium, erbium, thulium, ytterbium, lutetium, hafnium, tantalum, tungsten,
			rhenium, osmium, iridium, platinum, gold, mercury, thallium, lead, bismuth, polonium, astatine, radon,
			francium, radium, actinium, thorium, protactinium, uranium, neptunium, plutonium, americium, curium,
			berkelium, californium, einsteinium, fermium, mendelevium, nobelium, lawrencium, rutherfordium, dubnium,
			seaborgium, bohrium, hassium, meitnerium, darmstadtium, roentgenium, copernicium, nihonium, flerovium,
			moscovium, livermorium, tennessine, oganesson };

	public static class Element {
		public int atomicNumber;
		public String atomicSymbol;
		public String unlocalizedName;
		// public List<Isotope> isotopes;

		public Element(int atomicNumber, String atomicSymbol,
				String unlocalizedName/* , List<Isotope> isotopes */) {
			this.atomicNumber = atomicNumber;
			this.atomicSymbol = atomicSymbol;
			this.unlocalizedName = unlocalizedName;
			// this.isotopes = isotopes;
		}
	}

	public static CreativeTabs tabElements = new CreativeTabs("tab_elements") {
		public boolean hasSearchBar() {
			return true;
		};

		public int getSearchbarWidth() {
			return 89;
		};
		public String getBackgroundImageName() {
			return Reference.MODID + ":textures/gui/container/creative_inventory/tab_item_search.png";
		};
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.atom);
		}
	};
	public static CreativeTabs tabIons = new CreativeTabs("tab_ions") {
		public boolean hasSearchBar() {
			return true;
		};

		public int getSearchbarWidth() {
			return 89;
		};
		public String getBackgroundImageName() {
			return Reference.MODID + ":textures/gui/container/creative_inventory/tab_item_search.png";
		};
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.atom);
		}
	};
	public static enum RadiationTypes {
		RADIO(new Length(Unit.MILLIMETER, 1),new Length(Unit.KILOMETER, 100)),
		MICROWAVE(new Length(Unit.MILLIMETER, 10),new Length(Unit.METER, 1)),
		INFRARED(new Length(Unit.NANOMETER, 700),new Length(Unit.MILLIMETER, 1)),
		VISIBLE(new Length(Unit.NANOMETER, 390),new Length(Unit.NANOMETER, 700)),
		ULTRAVIOLET(new Length(Unit.NANOMETER, 100),new Length(Unit.NANOMETER, 390)),
		XRAY(new Length(Unit.PICOMETER,10),new Length(Unit.NANOMETER,10)),
		GAMMA(new Length(Unit.PICOMETER,0),new Length(Unit.PICOMETER,10));

		private Length waveLengthMin;
		private Length waveLengthMax;

		RadiationTypes(Length waveLengthMin, Length waveLengthMax) {
			this.waveLengthMin = waveLengthMin;
			this.waveLengthMin = waveLengthMax;
		}

		public Length getWaveLengthMin(){
			return waveLengthMin;
		}
		
		public Length getWaveLengthMax(){
			return waveLengthMax;
		}
	};
	// ItemBow
}
