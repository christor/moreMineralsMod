package com.coolness.epicness.radiation;

import com.coolness.epicness.init.Reference;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

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
		/**Camera.REGISTRY.clear();
		NBTTagList list = (NBTTagList) nbt.getTag("CameraRegistry");
		for (int i=0;i < list.tagCount();i++) {
			NBTTagCompound camnbt = (NBTTagCompound) list.get(0);
			Camera.registerCamera(new Camera(camnbt.getUniqueId("UUID")).readFromNBT(camnbt));
		}**/
		nbt.getString("Moo");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		/**NBTTagList list = new NBTTagList(); 
		for (Camera cam : Camera.REGISTRY.values()) {
			NBTTagCompound camnbt = new NBTTagCompound();
			camnbt.setUniqueId("UUID", cam.getUUID());
			cam.writeToNBT(camnbt);
			list.appendTag(camnbt);
		}
		nbt.setTag("CameraRegistry", list);
		Camera.REGISTRY.clear();
		**/
		nbt.setString("Moo", "MOOP");
		return nbt;
	}
	// BlockStem
	// WorldSavedData methods
}