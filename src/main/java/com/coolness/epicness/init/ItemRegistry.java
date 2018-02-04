package com.coolness.epicness.init;

import com.coolness.epicness.Elements;
import com.coolness.epicness.items.ItemModAxe;
import com.coolness.epicness.items.copper.ItemCopperAxe;
import com.coolness.epicness.items.copper.ItemCopperHoe;
import com.coolness.epicness.items.copper.ItemCopperIngot;
import com.coolness.epicness.items.copper.ItemCopperNugget;
import com.coolness.epicness.items.copper.ItemCopperPickaxe;
import com.coolness.epicness.items.copper.ItemCopperShovel;
import com.coolness.epicness.items.copper.ItemCopperSword;
import com.coolness.epicness.items.copper.ItemCopperWire;
import com.coolness.epicness.items.lead.ItemLead;
import com.coolness.epicness.items.lead.ItemLeadAxe;
import com.coolness.epicness.items.lead.ItemLeadHoe;
import com.coolness.epicness.items.lead.ItemLeadIngot;
import com.coolness.epicness.items.lead.ItemLeadPickaxe;
import com.coolness.epicness.items.lead.ItemLeadShovel;
import com.coolness.epicness.items.lead.ItemLeadSword;
import com.coolness.epicness.items.mithril.ItemMithrilAxe;
import com.coolness.epicness.items.mithril.ItemMithrilHoe;
import com.coolness.epicness.items.mithril.ItemMithrilIngot;
import com.coolness.epicness.items.mithril.ItemMithrilPickaxe;
import com.coolness.epicness.items.mithril.ItemMithrilShovel;
import com.coolness.epicness.items.mithril.ItemMithrilSword;
import com.coolness.epicness.items.other.ItemAtom;
import com.coolness.epicness.items.other.ItemCorn;
import com.coolness.epicness.items.other.ItemHerkimerDiamond;
import com.coolness.epicness.items.other.ItemSulfur;
import com.coolness.epicness.items.tungsten.ItemTungstenAxe;
import com.coolness.epicness.items.tungsten.ItemTungstenHoe;
import com.coolness.epicness.items.tungsten.ItemTungstenIngot;
import com.coolness.epicness.items.tungsten.ItemTungstenPickaxe;
import com.coolness.epicness.items.tungsten.ItemTungstenShovel;
import com.coolness.epicness.items.tungsten.ItemTungstenSword;
import com.coolness.epicness.items.uranium.ItemUranium;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	// public static final ToolMaterial toolMaterial =
	// EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency,
	// damage, enchantability);

	public static final ToolMaterial leadMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":lead", 1, 200, 3.5f,
			1.5f, 1);
	public static final ToolMaterial mithrilMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":mithril", 4, 2561,
			12.5f, 5f, 45);
	public static final ToolMaterial tungstenMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":tungsten", 3,
			2061, 13.5f, 4.5f, 30);
	public static final ToolMaterial copperMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":copper", 2, 350,
			6.0f, 2.0f, 8);
	
	public static Item atom;
	
	public static ItemSword copper_sword;
	public static ItemPickaxe copper_pickaxe;
	public static ItemModAxe copper_axe;
	public static ItemHoe copper_hoe;
	public static ItemSpade copper_shovel;

	public static Item copper_ingot;
	public static Item copper_nugget;
	public static Item copper_wire;

	public static ItemSword tungsten_sword;
	public static ItemPickaxe tungsten_pickaxe;
	public static ItemModAxe tungsten_axe;
	public static ItemHoe tungsten_hoe;
	public static ItemSpade tungsten_shovel;

	public static Item tungsten_ingot;

	public static ItemSword mithril_sword;
	public static ItemPickaxe mithril_pickaxe;
	public static ItemModAxe mithril_axe;
	public static ItemHoe mithril_hoe;
	public static ItemSpade mithril_shovel;

	public static Item mithril_ingot;

	public static ItemSword lead_sword;
	public static ItemPickaxe lead_pickaxe;
	public static ItemModAxe lead_axe;
	public static ItemHoe lead_hoe;
	public static ItemSpade lead_shovel;

	public static Item lead_ingot;
	public static ItemFood lead;

	public static Item corn_seeds;
	public static ItemFood corn;

	public static Item herkimer_diamond;
	public static Item sulfur;

	public static Item uranium;

	public static void init() {
		atom = new ItemAtom();
		
		herkimer_diamond = new ItemHerkimerDiamond();
		copper_ingot = new ItemCopperIngot();
		copper_nugget = new ItemCopperNugget();
		copper_wire = new ItemCopperWire();

		copper_sword = new ItemCopperSword(copperMaterial);
		copper_pickaxe = new ItemCopperPickaxe(copperMaterial);
		copper_axe = new ItemCopperAxe(copperMaterial);
		copper_shovel = new ItemCopperShovel(copperMaterial);
		copper_hoe = new ItemCopperHoe(copperMaterial);

		tungsten_ingot = new ItemTungstenIngot();

		tungsten_sword = new ItemTungstenSword(tungstenMaterial);
		tungsten_pickaxe = new ItemTungstenPickaxe(tungstenMaterial);
		tungsten_axe = new ItemTungstenAxe(tungstenMaterial);
		tungsten_shovel = new ItemTungstenShovel(tungstenMaterial);
		tungsten_hoe = new ItemTungstenHoe(tungstenMaterial);

		mithril_ingot = new ItemMithrilIngot();

		mithril_sword = new ItemMithrilSword(mithrilMaterial);
		mithril_pickaxe = new ItemMithrilPickaxe(mithrilMaterial);
		mithril_axe = new ItemMithrilAxe(mithrilMaterial);
		mithril_shovel = new ItemMithrilShovel(mithrilMaterial);
		mithril_hoe = new ItemMithrilHoe(mithrilMaterial);

		lead = new ItemLead(-2, -1, true, new PotionEffect(Potion.getPotionById(9), 300, 1),
				new PotionEffect(Potion.getPotionById(7), 0, 1), new PotionEffect(Potion.getPotionById(2), 2400, 2));
		lead_ingot = new ItemLeadIngot();

		lead_sword = new ItemLeadSword(leadMaterial);
		lead_pickaxe = new ItemLeadPickaxe(leadMaterial);
		lead_axe = new ItemLeadAxe(leadMaterial);
		lead_shovel = new ItemLeadShovel(leadMaterial);
		lead_hoe = new ItemLeadHoe(leadMaterial);

		corn = new ItemCorn(5, 4, false, new PotionEffect(Potion.getPotionById(3), 500, 1));

		corn_seeds = new ItemSeeds(BlockRegistry.corn_block, Blocks.FARMLAND)
				.setUnlocalizedName(Reference.RedstoneItems.CORN_SEEDS.getUnlocalizedName())
				.setRegistryName(Reference.RedstoneItems.CORN_SEEDS.getRegistryName());
		sulfur = new ItemSulfur();
		uranium = new ItemUranium();
	}

	public static void register() {
		GameRegistry.register(atom);
		
		GameRegistry.register(copper_ingot);
		GameRegistry.register(copper_nugget);
		GameRegistry.register(copper_wire);

		GameRegistry.register(copper_sword);
		GameRegistry.register(copper_pickaxe);
		GameRegistry.register(copper_axe);
		GameRegistry.register(copper_shovel);
		GameRegistry.register(copper_hoe);

		GameRegistry.register(tungsten_ingot);

		GameRegistry.register(tungsten_sword);
		GameRegistry.register(tungsten_pickaxe);
		GameRegistry.register(tungsten_axe);
		GameRegistry.register(tungsten_shovel);
		GameRegistry.register(tungsten_hoe);

		GameRegistry.register(mithril_ingot);

		GameRegistry.register(mithril_sword);
		GameRegistry.register(mithril_pickaxe);
		GameRegistry.register(mithril_axe);
		GameRegistry.register(mithril_shovel);
		GameRegistry.register(mithril_hoe);

		GameRegistry.register(lead);
		GameRegistry.register(lead_ingot);

		GameRegistry.register(lead_sword);
		GameRegistry.register(lead_pickaxe);
		GameRegistry.register(lead_axe);
		GameRegistry.register(lead_shovel);
		GameRegistry.register(lead_hoe);

		GameRegistry.register(corn_seeds);
		GameRegistry.register(corn);

		GameRegistry.register(herkimer_diamond);
		GameRegistry.register(sulfur);
		GameRegistry.register(uranium);
	}

	public static void registerRenders() {
		for(int i = 0; i < Elements.elements.length; i++){
			registerRender(atom, i, atom.getRegistryName());
		}
		
		registerRender(copper_ingot);
		registerRender(copper_nugget);
		registerRender(copper_wire);

		registerRender(copper_sword);
		registerRender(copper_pickaxe);
		registerRender(copper_axe);
		registerRender(copper_shovel);
		registerRender(copper_hoe);

		registerRender(tungsten_ingot);

		registerRender(tungsten_sword);
		registerRender(tungsten_pickaxe);
		registerRender(tungsten_axe);
		registerRender(tungsten_shovel);
		registerRender(tungsten_hoe);

		registerRender(mithril_ingot);

		registerRender(mithril_sword);
		registerRender(mithril_pickaxe);
		registerRender(mithril_axe);
		registerRender(mithril_shovel);
		registerRender(mithril_hoe);

		registerRender(lead_ingot);
		registerRender(lead);

		registerRender(lead_sword);
		registerRender(lead_pickaxe);
		registerRender(lead_axe);
		registerRender(lead_shovel);
		registerRender(lead_hoe);

		registerRender(corn_seeds);
		registerRender(corn);

		registerRender(sulfur);
		registerRender(herkimer_diamond);
		registerRender(uranium);
	}

	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	private static void registerRender(Item item, int meta, ResourceLocation resourceLocation) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta,
				new ModelResourceLocation(resourceLocation, "inventory"));
	}
	private static void registerRenderItemWithDamage(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
	}
	public static CreativeTabs tabMinerals = new CreativeTabs("tab_minerals") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(copper_ingot);
		}
	};
}
