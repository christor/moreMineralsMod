package com.coolness.epicness.blocks;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCorn extends BlockCrops{
	//Block
	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D)};

	
	public BlockCorn(){
		setUnlocalizedName(Reference.RedstoneBlocks.CORN.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.CORN.getRegistryName());
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
	
	@Override
	protected Item getSeed(){
		return ItemRegistry.corn_seeds;
	}
	@Override
	protected Item getCrop(){
		return ItemRegistry.corn;
	}
//	@Override
//	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
//		super.onBlockClicked(worldIn, pos, playerIn);
//		worldIn.setWorldTime(18000);
//		worldIn.newExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 5f, true, true);
//		
//	}
}
