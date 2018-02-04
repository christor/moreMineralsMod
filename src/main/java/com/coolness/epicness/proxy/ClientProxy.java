package com.coolness.epicness.proxy;

import com.coolness.epicness.FuelHandler;
import com.coolness.epicness.worldgen.CoolWorldGen;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy implements CommonProxy {

	public void Init() {
		GameRegistry.registerFuelHandler(new FuelHandler());
		System.out.println("Client Proxy Initialized!");
	}

}
