package com.coolness.epicness.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting {

	public static void register(){
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.uranium_block, 1), "UUU","UUU","UUU",'U',ItemRegistry.uranium);
		
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.tungsten_block, 1), "TTT","TTT","TTT",'T',ItemRegistry.tungsten_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_ingot, 1), "CCC","CCC","CCC",'C',ItemRegistry.copper_nugget);
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.copper_block, 1), "CCC","CCC","CCC",'C',ItemRegistry.copper_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_wire, 1), "SSS","CIC","SSS",'S',Blocks.STONE,'C',ItemRegistry.copper_ingot,'I',Blocks.IRON_BARS);
		GameRegistry.addShapelessRecipe( new ItemStack(ItemRegistry.copper_nugget, 9), new ItemStack(ItemRegistry.copper_ingot, 1));

		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_ingot, 1), "LLL","LLL","LLL",'L',ItemRegistry.lead);
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.lead_block, 1), "LLL","LLL","LLL",'L',ItemRegistry.lead_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.sulfur_block, 1), "SSS","SSS","SSS",'S',ItemRegistry.sulfur);
		
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegistry.bomb, 1), "III","TRB","III",'I',Blocks.IRON_BLOCK, 'T', Blocks.TORCH, 'R', Blocks.UNPOWERED_REPEATER, 'B', Blocks.REDSTONE_BLOCK);
		
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.copper_boots, 1), "   ","C C","C C",'C',ItemRegistry.copper_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.copper_leggings, 1), "CCC","C C","C C",'C',ItemRegistry.copper_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.copper_chestplate, 1), "C C","CCC","CCC",'C',ItemRegistry.copper_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.copper_helmet, 1), "CCC","C C","   ",'C',ItemRegistry.copper_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_axe, 1), "CC ","CS "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_axe, 1), " CC"," SC"," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_pickaxe, 1), "CCC"," S "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_hoe, 1), "CC "," S "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_hoe, 1), " CC"," S "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_shovel, 1), " C "," S "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.copper_sword, 1), " C "," C "," S ",'C',ItemRegistry.copper_ingot, 'S',Items.STICK);
		
		
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.tungsten_boots, 1), "   ","C C","C C",'C',ItemRegistry.tungsten_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.tungsten_leggings, 1), "CCC","C C","C C",'C',ItemRegistry.tungsten_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.tungsten_chestplate, 1), "C C","CCC","CCC",'C',ItemRegistry.tungsten_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.tungsten_helmet, 1), "CCC","C C","   ",'C',ItemRegistry.tungsten_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_axe, 1), "CC ","CS "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_axe, 1), " CC"," SC"," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_pickaxe, 1), "CCC"," S "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_hoe, 1), "CC "," S "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_hoe, 1), " CC"," S "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_shovel, 1), " C "," S "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.tungsten_sword, 1), " C "," C "," S ",'C',ItemRegistry.tungsten_ingot, 'S',Items.STICK);
		
		
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.lead_boots, 1), "   ","C C","C C",'C',ItemRegistry.lead_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.lead_leggings, 1), "CCC","C C","C C",'C',ItemRegistry.lead_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.lead_chestplate, 1), "C C","CCC","CCC",'C',ItemRegistry.lead_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ArmorRegistry.lead_helmet, 1), "CCC","C C","   ",'C',ItemRegistry.lead_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_axe, 1), "CC ","CS "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_axe, 1), " CC"," SC"," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_pickaxe, 1), "CCC"," S "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_hoe, 1), "CC "," S "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_hoe, 1), " CC"," S "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_shovel, 1), " C "," S "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.lead_sword, 1), " C "," C "," S ",'C',ItemRegistry.lead_ingot, 'S',Items.STICK);
		
		GameRegistry.addSmelting(ArmorRegistry.copper_boots, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ArmorRegistry.copper_leggings, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ArmorRegistry.copper_chestplate, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ArmorRegistry.copper_helmet, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		
		GameRegistry.addSmelting(ItemRegistry.copper_wire, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.copper_axe, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.copper_hoe, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.copper_pickaxe, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.copper_shovel, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.copper_sword, new ItemStack(ItemRegistry.copper_nugget, 1), 0.1f);
		
		GameRegistry.addSmelting(BlockRegistry.copper_ore, new ItemStack(ItemRegistry.copper_ingot, 1), 0.7f);
		GameRegistry.addSmelting(BlockRegistry.lead_ore, new ItemStack(ItemRegistry.lead_ingot, 1), 0.25f);
		GameRegistry.addSmelting(BlockRegistry.tungsten_ore, new ItemStack(ItemRegistry.tungsten_ingot, 1), 1.5f);
		GameRegistry.addSmelting(BlockRegistry.nether_gold_ore, new ItemStack(Items.GOLD_INGOT, 1), 1f);
		
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 0),  new ItemStack(Items.DYE, 1, 15), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 1),  new ItemStack(Items.DYE, 1, 14), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 2),  new ItemStack(Items.DYE, 1, 13), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 3),  new ItemStack(Items.DYE, 1, 12), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 4),  new ItemStack(Items.DYE, 1, 11), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 5),  new ItemStack(Items.DYE, 1, 10), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 6),  new ItemStack(Items.DYE, 1, 9), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 7),  new ItemStack(Items.DYE, 1, 8), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 8),  new ItemStack(Items.DYE, 1, 7), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 9),  new ItemStack(Items.DYE, 1, 6), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 10),  new ItemStack(Items.DYE, 1, 5), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 11),  new ItemStack(Items.DYE, 1, 4), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 12),  new ItemStack(Items.DYE, 1, 3), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 13),  new ItemStack(Items.DYE, 1, 2), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 14),  new ItemStack(Items.DYE, 1, 1), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		GameRegistry.addShapelessRecipe( new ItemStack(BlockRegistry.concrete_powder, 8, 15),  new ItemStack(Items.DYE, 1, 0), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.GRAVEL));
		
		
		//FurnaceRecipes
	}
}
