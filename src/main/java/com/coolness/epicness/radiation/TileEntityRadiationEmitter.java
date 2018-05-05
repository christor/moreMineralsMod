package com.coolness.epicness.radiation;

import com.coolness.epicness.Elements.RadiationTypes;
import com.coolness.epicness.Length;
import com.coolness.epicness.Unit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRadiationEmitter extends TileEntity {
	protected long amplitude;
	protected long wavelength;
	protected RadiationTypes type;
	
	public TileEntityRadiationEmitter() {
		System.out.println("Tile Entity has no data :(");
	}
	public TileEntityRadiationEmitter(long amplitude, long wavelength) {
		this.amplitude = amplitude;
		this.wavelength = wavelength;
	    for(RadiationTypes t : RadiationTypes.values()) {
	    	// check if it is in range of t
			if(t.inRange(new Length(wavelength))) {
				this.type = t;
				break;
			}
	    }
	}
	public TileEntityRadiationEmitter (long amplitude, long wavelength, RadiationTypes type) {
		this.amplitude = amplitude;
		this.wavelength = wavelength;
		this.type = type;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.amplitude = nbt.getLong("Amplitude");
		this.amplitude = nbt.getLong("Wavelength");
		this.type = RadiationTypes.values()[nbt.getInteger("Type")];
		super.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setLong("Amplitude", amplitude);
		nbt.setLong("Wavelength", wavelength);
		nbt.setInteger("Type", type.ordinal());
		System.out.println("NBT " + nbt);
		System.out.println("SUPER ");
		return super.writeToNBT(nbt);
	}
}
