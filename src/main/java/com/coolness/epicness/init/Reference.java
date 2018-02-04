package com.coolness.epicness.init;

import net.minecraft.util.IStringSerializable;

public class Reference {

	public static final String MODID = "redstone";
	public static final String NAME = "§l§n§4More Redstone Mod!!!§r";
	public static final String VERSION = "§e1.1§r";
	public static final String ACCEPTED_VERSIONS = "[1.11.2]";

	public static final String CLIENTPROXY = "com.coolness.epicness.proxy.ClientProxy";
	public static final String COMMONPROXY = "com.coolness.epicness.proxy.ServerProxy";
	
	public static enum RedstoneItems {
		COPPER_INGOT("copper_ingot", "copper_ingot"),
		COPPER_NUGGET("copper_nugget", "copper_nugget"),
		COPPER_WIRE("copper_wire", "copper_wire"),
		COPPER_SWORD("copper_sword", "copper_sword"),
		COPPER_PICKAXE("copper_pickaxe", "copper_pickaxe"),
		COPPER_AXE("copper_axe", "copper_axe"),
		COPPER_SHOVEL("copper_shovel", "copper_shovel"),
		COPPER_HOE("copper_hoe", "copper_hoe"),
		
		TUNGSTEN_INGOT("tungsten_ingot", "tungsten_ingot"),
		TUNGSTEN_SWORD("tungsten_sword", "tungsten_sword"),
		TUNGSTEN_PICKAXE("tungsten_pickaxe", "tungsten_pickaxe"),
		TUNGSTEN_AXE("tungsten_axe", "tungsten_axe"),
		TUNGSTEN_SHOVEL("tungsten_shovel", "tungsten_shovel"),
		TUNGSTEN_HOE("tungsten_hoe", "tungsten_hoe"),
		
		LEAD("lead", "lead"),
		LEAD_INGOT("lead_ingot", "lead_ingot"),
		LEAD_SWORD("lead_sword", "lead_sword"),
		LEAD_PICKAXE("lead_pickaxe", "lead_pickaxe"),
		LEAD_AXE("lead_axe", "lead_axe"),
		LEAD_SHOVEL("lead_shovel", "lead_shovel"),
		LEAD_HOE("lead_hoe", "lead_hoe"),
		
		SULFUR("sulfur", "sulfur"),
		URANIUM("uranium", "uranium"),
		
		ATOM("atom", "atom");

		private String unlocalizedName;
		private String registryName;

		RedstoneItems(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum RedstoneBlocks {
		URANIUM_ORE("uranium_ore", "uranium_ore"), 
		URANIUM_BLOCK("uranium_block", "uranium_block"), 
		NUCLEAR_WASTE("nuclear_waste", "nuclear_waste"), 
		COPPER_ORE("copper_ore", "copper_ore"), 
		COPPER_BLOCK("copper_block","copper_block"), 
		TUNGSTEN_ORE("tungsten_ore", "tungsten_ore"), 
		TUNGSTEN_BLOCK("tungsten_block", "tungsten_block"), 
		MITHRIL_ORE("mithril_ore", "mithril_ore"), 
		MITHRIL_BLOCK("mithril_block", "mithril_block"), 
		SULFUR_ORE("sulfur_ore", "sulfur_ore"), 
		SULFUR_BLOCK("sulfur_block", "sulfur_block"), 
		LEAD_ORE("lead_ore", "lead_ore"), 
		IRON_FURNACE("iron_furnace", "iron_furnace"), 
		LEAD_BLOCK("lead_block", "lead_block"),
		CONCRETE("concrete", "concrete"), 
		CONCRETE_POWDER("concrete_powder", "concrete_powder"), 
		GOLD_ORE("nether_gold_ore", "nether_gold_ore"), 
		BOMB("bomb", "bomb"),
		
		ATOM_BONDER("atom_bonder", "atom_bonder");

		private String unlocalizedName;
		private String registryName;

		RedstoneBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

		public String getRegistryName() {
			return registryName;
		}
	}

	public static enum ConcreteTypes implements IStringSerializable {
		WHITE("white", 0), ORANGE("orange", 1), MAGENTA("magenta", 2), LIGHT_BLUE("light_blue", 3), YELLOW("yellow",
				4), LIME("lime", 5), PINK("pink", 6), GRAY("gray", 7), LIGHT_GRAY("light_gray", 8), CYAN("cyan",
						9), PURPLE("purple", 10), BLUE("blue", 11), BROWN("brown", 12), GREEN("green", 13), RED("red",
								14), BLACK("black", 15);

		private int id;
		private String name;

		private ConcreteTypes(String name, int id) {
			this.id = id;
			this.name = name;
		};

		@Override
		public String getName() {
			return this.name;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return getName();
		}

	}
}
