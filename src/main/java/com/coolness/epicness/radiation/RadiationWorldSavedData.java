package com.coolness.epicness.radiation;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.event.world.ChunkEvent.Load;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RadiationWorldSavedData extends WorldSavedData {
	
	private static final String DATA_NAME = Reference.MODID + "_radiation";
	private static final boolean IS_GLOBAL = false;
	
	public static RadiationWorldSavedData get(World world) {
		// The IS_GLOBAL constant is there for clarity, and should be simplified
		// into the right branch.
		MapStorage storage = IS_GLOBAL ? world.getMapStorage() : world.getPerWorldStorage();
		RadiationWorldSavedData instance = (RadiationWorldSavedData) storage
				.getOrLoadData(RadiationWorldSavedData.class, DATA_NAME);

		if (instance == null) {
			instance = new RadiationWorldSavedData();
			storage.setData(DATA_NAME, instance);
		}
		return instance;
	}

	// Required constructors
	public RadiationWorldSavedData() {
		super(DATA_NAME);
	}

	public RadiationWorldSavedData(String s) {
		super(s);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		RadiationManager.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		RadiationManager.writeToNBT(nbt);
		return nbt;
	}
	// BlockStem
	// WorldSavedData methods
}