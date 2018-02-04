package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTungstenOre extends BlockOre {
	//BlockFurnace
	public BlockTungstenOre() {
		super();
		setUnlocalizedName(Reference.RedstoneBlocks.TUNGSTEN_ORE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.TUNGSTEN_ORE.getRegistryName());
		setHardness(4.5f);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}
}
