package com.coolness.epicness.blocks;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityRadiationSender;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockRadiationSender extends Block {
	public BlockRadiationSender() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.RADIATION_SENDER.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.RADIATION_SENDER.getRegistryName());
		setHardness(4f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(5f);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityRadiationSender();
	}
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
