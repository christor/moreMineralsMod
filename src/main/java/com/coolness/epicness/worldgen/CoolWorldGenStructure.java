package com.coolness.epicness.worldgen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CoolWorldGenStructure extends WorldGenerator {
	private final IBlockState[][][] blocks;
	private final int width;
	private final int height;
	private final int length;
	/** The number of blocks to generate. */
	private final Predicate<IBlockState> predicate;

	public CoolWorldGenStructure(int l, int h, int w, IBlockState[][][] state) {
		this(l, h, w, state, new CoolWorldGenStructure.StonePredicate());
	}

	public CoolWorldGenStructure(int l, int h, int w, IBlockState state[][][], Predicate<IBlockState> p_i45631_3_) {
		this.blocks = state;
		this.predicate = p_i45631_3_;
		this.width = w;
		this.height = h;
		this.length = l;
	}

	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (short y2 = 255; y2 > 0; y2--) {
			if (worldIn.isAirBlock(new BlockPos(position.getX(), y2, position.getZ()))
					&& !worldIn.isAirBlock(new BlockPos(position.getX(), y2 - 1, position.getZ()))) {
				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						for (int z = 0; z < length; z++) {
							BlockPos pos = new BlockPos(position.getX() + x, y2 + y, position.getZ() + z);
							worldIn.setBlockState(pos, blocks[x][y][z]);
						}
					}
				}
				break;
			}
		}
		return true;
	}

	static class StonePredicate implements Predicate<IBlockState> {
		private StonePredicate() {
		}

		public boolean apply(IBlockState p_apply_1_) {
			if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.STONE) {
				BlockStone.EnumType blockstone$enumtype = (BlockStone.EnumType) p_apply_1_.getValue(BlockStone.VARIANT);
				return blockstone$enumtype.isNatural();
			} else {
				return false;
			}
		}
	}
}