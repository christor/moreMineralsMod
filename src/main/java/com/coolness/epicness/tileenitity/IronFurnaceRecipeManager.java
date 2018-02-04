package com.coolness.epicness.tileenitity;

import com.coolness.epicness.init.ItemRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/** Adds An Iron Furnace Recipe To The Game */
class Recipe { 
	public Item item1;
	public Item item2;
	public ItemStack output;
	
	public Recipe(Item firstItem, Item secondItem, ItemStack outputStack){
		item1 = firstItem;
		item2 = secondItem;
		output = outputStack;
	}
}
/** Adds An Iron Furnace Fuel To The Game */
class Fuel { 
	public Item fuelItem;
	public int burn;
	
	public Fuel(Item fuel, int burnTime){
		fuelItem = fuel;
		burn = burnTime;
	}
}
public class IronFurnaceRecipeManager {
	public static final Recipe[] recipes = {
			new Recipe(ItemRegistry.tungsten_ingot, Items.DIAMOND, new ItemStack(ItemRegistry.mithril_ingot, 1))
			};
	public static final Fuel[] fuels = {
			new Fuel(new ItemStack(Blocks.COAL_BLOCK).getItem(),16000),
			new Fuel(new ItemStack(Blocks.LOG).getItem(),300),
			new Fuel(new ItemStack(Blocks.LOG2).getItem(),300),
			new Fuel(new ItemStack(Blocks.PLANKS).getItem(),300),
			new Fuel(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.TRAPDOOR).getItem(),300),
			new Fuel(new ItemStack(Blocks.CRAFTING_TABLE).getItem(),300),
			new Fuel(new ItemStack(Blocks.BOOKSHELF).getItem(),300),
			new Fuel(new ItemStack(Blocks.CHEST).getItem(),300),
			new Fuel(new ItemStack(Blocks.TRAPPED_CHEST).getItem(),300),
			new Fuel(new ItemStack(Blocks.DAYLIGHT_DETECTOR).getItem(),300),
			new Fuel(new ItemStack(Blocks.JUKEBOX).getItem(),300),
			new Fuel(new ItemStack(Blocks.NOTEBLOCK).getItem(),300),
			new Fuel(new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK).getItem(),300),
			new Fuel(new ItemStack(Blocks.RED_MUSHROOM_BLOCK).getItem(),300),
			new Fuel(new ItemStack(Blocks.STANDING_BANNER).getItem(),300),
			new Fuel(new ItemStack(Blocks.WOODEN_SLAB).getItem(),150),
			new Fuel(new ItemStack(Blocks.LADDER).getItem(),300),
			new Fuel(new ItemStack(Blocks.SAPLING).getItem(),100),
			new Fuel(new ItemStack(Blocks.WOODEN_BUTTON).getItem(),100),
			new Fuel(new ItemStack(Blocks.WOOL).getItem(),100),
			new Fuel(new ItemStack(Blocks.CARPET).getItem(),67),
			
			
			new Fuel(Items.COAL,1600),
			new Fuel(Items.BOWL,100),
			new Fuel(Items.STICK,100),
			new Fuel(Items.SIGN,200),
			
			new Fuel(Items.ACACIA_BOAT,400),
			new Fuel(Items.ACACIA_DOOR,200),
			new Fuel(new ItemStack(Blocks.ACACIA_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.ACACIA_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.ACACIA_STAIRS).getItem(),300),
			
			new Fuel(Items.BOAT,400),
			new Fuel(Items.OAK_DOOR,200),
			new Fuel(new ItemStack(Blocks.OAK_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.OAK_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.OAK_STAIRS).getItem(),300),
			
			new Fuel(Items.DARK_OAK_BOAT,400),
			new Fuel(Items.DARK_OAK_DOOR,200),
			new Fuel(new ItemStack(Blocks.DARK_OAK_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.DARK_OAK_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.DARK_OAK_STAIRS).getItem(),300),
			
			new Fuel(Items.BIRCH_BOAT,400),
			new Fuel(Items.BIRCH_DOOR,200),
			new Fuel(new ItemStack(Blocks.BIRCH_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.BIRCH_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.BIRCH_STAIRS).getItem(),300),
			
			new Fuel(Items.JUNGLE_BOAT,400),
			new Fuel(Items.JUNGLE_DOOR,200),
			new Fuel(new ItemStack(Blocks.JUNGLE_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.JUNGLE_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.JUNGLE_STAIRS).getItem(),300),
			
			new Fuel(Items.SPRUCE_BOAT,400),
			new Fuel(Items.SPRUCE_DOOR,200),
			new Fuel(new ItemStack(Blocks.SPRUCE_FENCE).getItem(),300),
			new Fuel(new ItemStack(Blocks.SPRUCE_FENCE_GATE).getItem(),300),
			new Fuel(new ItemStack(Blocks.SPRUCE_STAIRS).getItem(),300),
			
			
			new Fuel(Items.BOW,300),
			new Fuel(Items.FISHING_ROD,300),
			new Fuel(Items.WOODEN_AXE,200),
			new Fuel(Items.WOODEN_HOE,200),
			new Fuel(Items.WOODEN_PICKAXE,200),
			new Fuel(Items.WOODEN_SHOVEL,200),
			new Fuel(Items.WOODEN_SWORD,200)
			};
}
