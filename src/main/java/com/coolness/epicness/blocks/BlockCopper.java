package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;

public class BlockCopper extends Block{

	public BlockCopper() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.COPPER_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.COPPER_BLOCK.getRegistryName());
		setHardness(6.5f);
		setHarvestLevel("pickaxe", 1);
		setSoundType(SoundType.METAL);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(15.0f);
	}

}