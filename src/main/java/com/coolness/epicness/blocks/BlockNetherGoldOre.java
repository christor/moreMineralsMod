package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;

public class BlockNetherGoldOre extends BlockOre{

	public BlockNetherGoldOre() {
		super();
		setUnlocalizedName(Reference.RedstoneBlocks.GOLD_ORE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.GOLD_ORE.getRegistryName());
		setHardness(3.5f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}

}
