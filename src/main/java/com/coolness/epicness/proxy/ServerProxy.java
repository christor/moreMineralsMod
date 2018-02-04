package com.coolness.epicness.proxy;

import com.coolness.epicness.FuelHandler;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.worldgen.CoolWorldGen;

import net.minecraft.block.BlockObsidian;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements CommonProxy{
	
	@Override
	public void Init() {
		ItemRegistry.registerRenders();
		BlockRegistry.registerRenders();
		System.out.println("Server Proxy Initialized!");
	}
}
