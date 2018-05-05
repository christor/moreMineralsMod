package com.coolness.epicness.init;

import com.coolness.epicness.blocks.BlockAtomBonder;
import com.coolness.epicness.blocks.BlockBomb;
import com.coolness.epicness.blocks.BlockConcrete;
import com.coolness.epicness.blocks.BlockConcretePowder;
import com.coolness.epicness.blocks.BlockCopper;
import com.coolness.epicness.blocks.BlockCopperOre;
import com.coolness.epicness.blocks.BlockLead;
import com.coolness.epicness.blocks.BlockLeadOre;
import com.coolness.epicness.blocks.BlockNetherGoldOre;
import com.coolness.epicness.blocks.BlockNuclearWaste;
import com.coolness.epicness.blocks.BlockRadiationReceiver;
import com.coolness.epicness.blocks.BlockRadiationSender;
import com.coolness.epicness.blocks.BlockSulfur;
import com.coolness.epicness.blocks.BlockSulfurOre;
import com.coolness.epicness.blocks.BlockTungsten;
import com.coolness.epicness.blocks.BlockTungstenOre;
import com.coolness.epicness.blocks.BlockUranium;
import com.coolness.epicness.blocks.BlockUraniumOre;
import com.coolness.epicness.init.Reference.ConcreteTypes;
import com.coolness.epicness.items.other.ItemConcrete;
import com.coolness.epicness.items.other.ItemConcretePowder;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static Block atom_bonder;
	public static Block lead_ore;
	public static Block lead_block;
	public static Block sulfur_ore;
	public static Block sulfur_block;
	public static Block copper_ore;
	public static Block copper_block;
	public static Block tungsten_ore;
	public static Block tungsten_block;

	public static Block uranium_block;
	public static Block uranium_ore;
	public static Block nuclear_waste;
	
	public static Block bomb;
	public static Block nether_gold_ore;
	public static Block concrete;
	public static ItemBlock concrete_item;
	public static Block concrete_powder;
	public static ItemBlock concrete_powder_item;
	
	public static Block radiation_sender;
	public static Block radiation_receiver;

	public static void init() {
		atom_bonder = new BlockAtomBonder();
		lead_ore = new BlockLeadOre();
		lead_block = new BlockLead();
		sulfur_ore = new BlockSulfurOre();
		sulfur_block = new BlockSulfur();
		copper_ore = new BlockCopperOre();
		tungsten_ore = new BlockTungstenOre();
		copper_block = new BlockCopper();
		tungsten_block = new BlockTungsten();

		bomb = new BlockBomb();
		uranium_ore = new BlockUraniumOre();
		uranium_block = new BlockUranium();
		nuclear_waste = new BlockNuclearWaste();
		nether_gold_ore = new BlockNetherGoldOre(); 
		
		concrete = new BlockConcrete();
		concrete_item = new ItemConcrete(concrete);
		
		concrete_powder = new BlockConcretePowder();
		concrete_powder_item = new ItemConcretePowder(concrete_powder);
		radiation_sender = new BlockRadiationSender();
		radiation_receiver = new BlockRadiationReceiver();
	}

	public static void register() {
		registerBlock(atom_bonder);
		registerBlock(lead_block);
		registerBlock(lead_ore);
		registerBlock(copper_block);
		registerBlock(copper_ore);
		registerBlock(tungsten_ore);
		registerBlock(tungsten_block);
		registerBlock(sulfur_ore);
		registerBlock(sulfur_block);
		registerBlock(uranium_ore);
		registerBlock(uranium_block);
		registerBlock(nuclear_waste);
		registerBlock(nether_gold_ore);
		
		registerBlock(bomb);
		GameRegistry.register(concrete);
		GameRegistry.register(concrete_item);
		GameRegistry.register(concrete_powder);
		GameRegistry.register(concrete_powder_item);
		registerBlock(radiation_sender);
		registerBlock(radiation_receiver);
	}

	public static void registerRenders() {
		registerRender(atom_bonder);
		registerRender(lead_block);
		registerRender(lead_ore);
		registerRender(sulfur_ore);
		registerRender(sulfur_block);
		registerRender(copper_ore);
		registerRender(tungsten_ore);
		registerRender(copper_block);
		registerRender(tungsten_block);

		registerRender(uranium_ore);
		registerRender(uranium_block);
		registerRender(nuclear_waste);
		registerRender(nether_gold_ore);
		registerRender(concrete);
		for (int i = 0; i < ConcreteTypes.values().length; i++) {
			System.out.println(i + ": concrete_" + ConcreteTypes.values()[i].getName() + " has been registered!!!");
			registerRenderItem(concrete_item, i, "item/concrete_" + ConcreteTypes.values()[i].getName());
		}
		registerRender(concrete_powder);
		for (int i = 0; i < ConcreteTypes.values().length; i++) {
			System.out.println(i + ": concrete_item_" + ConcreteTypes.values()[i].getName() + " has been registered!!!");
			registerRenderItem(concrete_powder_item, i, "item/concrete_powder_" + ConcreteTypes.values()[i].getName());
		}
		registerRender(radiation_receiver);
		registerRender(radiation_sender);
		registerRender(bomb);
	}
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}

	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	private static void registerRenderItem(Item item, int meta, String fileName) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta,
				new ModelResourceLocation(fileName, "inventory"));
	}
//	private static void registerRenderItemWithDamage(Item item, int meta, String fileName) {
//		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
//	}

	public static CreativeTabs tabMineralsBlocks = new CreativeTabs("tab_minerals_blocks") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(copper_block);
		}
	};
}
