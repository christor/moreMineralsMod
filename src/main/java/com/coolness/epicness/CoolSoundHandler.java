package com.coolness.epicness;

import com.coolness.epicness.init.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class CoolSoundHandler {
	
	private static int size = 0;
	
	public static SoundEvent GEIGER_COUNTER_SOUND_1;
	public static SoundEvent GEIGER_COUNTER_SOUND_2;
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();

		GEIGER_COUNTER_SOUND_1 = register("item.geiger_counter_1");
		GEIGER_COUNTER_SOUND_2 = register("item.geiger_counter_2");
		
	}
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		System.out.println("Registered Sound: " + name);
		return e;
	}
	
}
