package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.radiation.TileEntityRadiationReceiver;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRadiationReceiver extends Block implements ITileEntityProvider {
	public BlockRadiationReceiver() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.RADIATION_RECEIVER.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.RADIATION_RECEIVER.getRegistryName());
		setHardness(4f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(5f);
	}
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityRadiationReceiver();
	}
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return side == EnumFacing.NORTH;
	}
	private double getPowerInBlock(World worldIn, BlockPos pos){
		return (((TileEntityRadiationReceiver)worldIn.getTileEntity(pos)).getWavelength());
	}
	public void radiationReceived (World worldIn, BlockPos pos, long amplitude, long wavelength){
		System.out.println("AMPLITUDE IS: " + amplitude + "!!!!!!!!!!");
		System.out.println("WAVELENGTH IS: " + wavelength + "!!!!!!!!!!");
		worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 1,pos.getZ()), Blocks.CARPET.getStateFromMeta((int)Math.round(Math.random() * 15)));
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRadiationReceiver();
	}
	@Override
	public boolean hasTileEntity() {
		return true;
	}
}
