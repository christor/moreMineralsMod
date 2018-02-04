package com.coolness.epicness.blocks;

import java.util.Random;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockConcretePowder extends BlockColored {
	public static boolean fallInstantly;

	// BlockColored BlockFalling
	public BlockConcretePowder() {
		super(Material.SAND);
		setUnlocalizedName(Reference.RedstoneBlocks.CONCRETE_POWDER.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.CONCRETE_POWDER.getRegistryName());
		setHardness(0.5f);
		setHarvestLevel("shovel", 0);
		setSoundType(SoundType.SAND);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setResistance(2.5f);
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile
	 * Entity is set
	 */
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	/**
	 * Called when a neighboring block was changed and marks that this state
	 * should perform any checks during a neighbor change. Cases may include
	 * when redstone power is updated, cactus blocks popping off due to a
	 * neighboring solid block, etc.
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	public void updateTick(World worldIn, BlockPos blockPos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			this.checkFallable(worldIn, blockPos);
		}
		BlockPos pos = new BlockPos(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ());
		if (checkWater(worldIn, pos, blockPos)) {
			pos = new BlockPos(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ());
			if (checkWater(worldIn, pos, blockPos)) {
				pos = new BlockPos(blockPos.getX(), blockPos.getY() - 1, blockPos.getZ());
				if (checkWater(worldIn, pos, blockPos)) {
					pos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1);
					if (checkWater(worldIn, pos, blockPos)) {
						pos = new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1);
						checkWater(worldIn, pos, blockPos);
					}
				}
			}
		}
	}

	private boolean checkWater(World worldIn, BlockPos pos, BlockPos concretePos) {
		if (worldIn.getBlockState(pos).getMaterial() == Material.WATER) {
			worldIn.setBlockState(concretePos, BlockRegistry.concrete.getStateFromMeta(
					BlockRegistry.concrete_powder.getMetaFromState(worldIn.getBlockState(concretePos))));
			return false;
		}
		return true;
	}

	private void checkFallable(World worldIn, BlockPos pos) {
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) {
			int i = 32;

			if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
				if (!worldIn.isRemote) {
					EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double) pos.getX() + 0.5D,
							(double) pos.getY(), (double) pos.getZ() + 0.5D, worldIn.getBlockState(pos));
					this.onStartFalling(entityfallingblock);
					worldIn.spawnEntity(entityfallingblock);
				}
			} else {
				IBlockState state = worldIn.getBlockState(pos);
				worldIn.setBlockToAir(pos);
				BlockPos blockpos;

				for (blockpos = pos
						.down(); (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn.getBlockState(blockpos)))
								&& blockpos.getY() > 0; blockpos = blockpos.down()) {
					;
				}

				if (blockpos.getY() > 0) {
					worldIn.setBlockState(blockpos.up(), state); // Forge: Fix
																	// loss of
																	// state
																	// information
																	// during
																	// world
																	// gen.
				}
			}
		}
	}

	protected void onStartFalling(EntityFallingBlock fallingEntity) {
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World worldIn) {
		return 2;
	}

	public static boolean canFallThrough(IBlockState state) {
		Block block = state.getBlock();
		Material material = state.getMaterial();
		return block == Blocks.FIRE || material == Material.AIR || material == Material.WATER
				|| material == Material.LAVA;
	}

	public void onEndFalling(World worldIn, BlockPos pos) {
	}

	public void onBroken(World p_190974_1_, BlockPos p_190974_2_) {
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(16) == 0) {
			BlockPos blockpos = pos.down();

			if (canFallThrough(worldIn.getBlockState(blockpos))) {
				double d0 = (double) ((float) pos.getX() + rand.nextFloat());
				double d1 = (double) pos.getY() - 0.05D;
				double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
				worldIn.spawnParticle(EnumParticleTypes.FALLING_DUST, d0, d1, d2, 0.0D, 0.0D, 0.0D,
						new int[] { Block.getStateId(stateIn) });
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState p_189876_1_) {
		return -16777216;
	}
}
