package com.coolness.epicness.worldgen.structures;

import com.coolness.epicness.worldgen.Structure;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class Test extends Structure{
	public static final int xSize = 3;
	public static final int ySize = 3;
	public static final int zSize = 3;
	public static IBlockState[][][] states = new IBlockState[xSize][ySize][zSize];
	public static void registerBlocks(){
		states = setToAir(states, xSize, ySize, zSize);
		setBlock(1, 1, 1, Blocks.OBSIDIAN);
		setBlock(1, 2, 1, Blocks.OBSIDIAN);
		setBlock(1, 3, 1, Blocks.OBSIDIAN);
		setBlock(2, 3, 1, Blocks.OBSIDIAN);
		setBlock(3, 3, 1, Blocks.OBSIDIAN);
		setBlock(3, 2, 1, Blocks.OBSIDIAN);
		setBlock(3, 1, 1, Blocks.OBSIDIAN);
		
		setBlock(1, 1, 3, Blocks.OBSIDIAN);
		setBlock(1, 2, 3, Blocks.OBSIDIAN);
		setBlock(1, 3, 3, Blocks.OBSIDIAN);
		setBlock(2, 3, 3, Blocks.OBSIDIAN);
		setBlock(3, 3, 3, Blocks.OBSIDIAN);
		setBlock(3, 2, 3, Blocks.OBSIDIAN);
		setBlock(3, 1, 3, Blocks.OBSIDIAN);
		
		setBlock(2, 3, 1, Blocks.OBSIDIAN);
		setBlock(1, 3, 2, Blocks.OBSIDIAN);
		
		setBlock(2, 1, 2, Blocks.ENCHANTING_TABLE);
	}
	public static void setBlock(int x, int y, int z, Block block){
		x--;
		y--;
		z--;
		states[x][y][z] = block.getDefaultState();
	}
}
