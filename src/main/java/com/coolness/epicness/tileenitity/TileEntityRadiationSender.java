package com.coolness.epicness.tileenitity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRadiationSender extends TileEntity {
	protected float rotX;
	protected float rotY;
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.rotX = nbt.getFloat("rotX");
		this.rotY = nbt.getFloat("rotY");
		super.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setFloat("rotX", rotX);
		nbt.setFloat("rotY", rotY);
		return super.writeToNBT(nbt);
	}
}
