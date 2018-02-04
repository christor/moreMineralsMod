package com.coolness.epicness.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class Structure {
	private static IBlockState[][][] structure;
	public static IBlockState[][][] setToAir(IBlockState[][][] states, int xSize, int ySize, int zSize){
		for(int x = 0; x < xSize; x++){
			for(int y = 0; y < ySize; y++){
				for(int z = 0; z < zSize; z++){
					states[x][y][z] = Blocks.AIR.getDefaultState();
				}
			}	
		}
		structure = states;
		return states;
	}
}
