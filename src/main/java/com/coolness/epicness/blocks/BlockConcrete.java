package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockConcrete extends BlockColored
{
	// BlockColored
	public BlockConcrete() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.RedstoneBlocks.CONCRETE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.CONCRETE.getRegistryName());
		setHardness(1.8f);
		setHarvestLevel("pickaxe", 0);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setResistance(9.0f);
	}

}
