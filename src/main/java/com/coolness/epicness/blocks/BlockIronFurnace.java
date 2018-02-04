package com.coolness.epicness.blocks;

import java.util.List;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.client.gui.GuiHandler;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityIronFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockIronFurnace extends Block implements ITileEntityProvider {
	
	public BlockIronFurnace() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.IRON_FURNACE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.IRON_FURNACE.getRegistryName());
		setHardness(6.5f);
		setHarvestLevel("pickaxe", 1);
		setSoundType(SoundType.METAL);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(15.0f);
	}
//	@Override
//	protected BlockStateContainer createBlockState() {
//		return new BlockStateContainer(this, new IProperty[] {FACING});
//	}
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityIronFurnace();
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityIronFurnace();
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityIronFurnace te = (TileEntityIronFurnace)world.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for(int slot = 0; slot < handler.getSlots() - 1; slot++){
			ItemStack stack = handler.getStackInSlot(slot);
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
		super.breakBlock(world, pos, state);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			playerIn.openGui(MoreMineralsMod.instance, GuiHandler.IRON_FURNACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}