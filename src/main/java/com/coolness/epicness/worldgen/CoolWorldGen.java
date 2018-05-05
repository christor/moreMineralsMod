package com.coolness.epicness.worldgen;

import java.util.Random;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.worldgen.structures.Test;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CoolWorldGen implements IWorldGenerator {

	private WorldGenerator copper_ore_gen;
	private WorldGenerator lead_ore_gen;
	private WorldGenerator tungsten_ore_gen;
	private WorldGenerator sulfur_ore_gen;
	private WorldGenerator uranium_ore_gen;
	
	private WorldGenerator nether_gold_ore_gen;
//
//	private WorldGenerator test_structure;

	public CoolWorldGen() {
		Test.registerBlocks();
		this.copper_ore_gen = new CoolWorldGenMineable(BlockRegistry.copper_ore.getDefaultState(), 5);
		this.tungsten_ore_gen = new CoolWorldGenMineable(BlockRegistry.tungsten_ore.getDefaultState(), 6);
		this.sulfur_ore_gen = new CoolWorldGenMineable(BlockRegistry.sulfur_ore.getDefaultState(), 8);
		this.lead_ore_gen = new CoolWorldGenMineable(BlockRegistry.lead_ore.getDefaultState(), 7);
		this.uranium_ore_gen = new CoolWorldGenMineable(BlockRegistry.uranium_ore.getDefaultState(), 7);
		
		this.nether_gold_ore_gen = new CoolNetherGenMineable(BlockRegistry.nether_gold_ore.getDefaultState(), 7);
		
		//this.test_structure = new CoolWorldGenStructure(Test.xSize, Test.ySize, Test.zSize, Test.states);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
 		switch (world.provider.getDimension()) {
		case 0:
			// this.runGenerator(generator, world, random, chunkX, chunkZ,
			// (veins per chunk), minHeight, maxHeight);
			this.runGenerator(this.lead_ore_gen, world, random, chunkX, chunkZ, 28, 0, 150);
			this.runGenerator(this.copper_ore_gen, world, random, chunkX, chunkZ, 35, 0, 65);
			this.runGenerator(this.tungsten_ore_gen, world, random, chunkX, chunkZ, 1, 0, 25);
			this.runGenerator(this.sulfur_ore_gen, world, random, chunkX, chunkZ, 35, 0, 150);
			this.runGenerator(this.uranium_ore_gen, world, random, chunkX, chunkZ, 15, 0, 50);
			//this.runStructureGenerator(this.test_structure, world, random, chunkX, chunkZ, 0.02D);
		case -1:
			this.runGenerator(this.nether_gold_ore_gen, world, random, chunkX, chunkZ, 28, 0, 150);
		case 1:
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
			int veinsPerChunk, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Minimum Or Maximum Height Out Of Bounds!");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < veinsPerChunk; i++) {
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(x, y, z));
		}
	}

	private void runStructureGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
			double spawnPercentChunk) {
		if (random.nextDouble() < spawnPercentChunk) {
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(x, 0, z));
		}
	}
}
