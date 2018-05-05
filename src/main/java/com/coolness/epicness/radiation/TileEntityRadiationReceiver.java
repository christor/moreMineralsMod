package com.coolness.epicness.radiation;

import com.coolness.epicness.Elements.RadiationTypes;
import com.coolness.epicness.Length;
import com.coolness.epicness.Unit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRadiationReceiver extends TileEntity {
	protected long amplitude;
	protected long wavelength;
	protected RadiationTypes type;
	protected double sensitivity;
	
	public TileEntityRadiationReceiver() {
		System.out.println("Tile Entity has no data :(");
	}
	public TileEntityRadiationReceiver(long amplitude, long wavelength, double sensitivity) {
		this.amplitude = amplitude;
		this.wavelength = wavelength;
	    for(RadiationTypes t : RadiationTypes.values()) {
	    	// check if it is in range of t
			if(t.inRange(new Length(wavelength))) {
				this.type = t;
				break;
			}
	    }
	    this.sensitivity = sensitivity;
	}
	public TileEntityRadiationReceiver (long amplitude, long wavelength, RadiationTypes type, double sensitivity) {
		this.amplitude = amplitude;
		this.wavelength = wavelength;
		this.type = type;
		this.sensitivity = sensitivity;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.amplitude = nbt.getLong("Amplitude");
		this.amplitude = nbt.getLong("Wavelength");
		this.sensitivity = nbt.getDouble("Sensitivity");
		this.type = RadiationTypes.values()[nbt.getInteger("Type")];
		super.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setLong("Amplitude", amplitude);
		nbt.setLong("Wavelength", wavelength);
		nbt.setDouble("Sensitivity", sensitivity);
		if(type != null)
			nbt.setInteger("Type", type.ordinal());
		System.out.println("NBT " + nbt);
		System.out.println("SUPER ");
		return super.writeToNBT(nbt);
	}
	public long getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(long amplitude) {
		this.amplitude = amplitude;
	}
	public long getWavelength() {
		return wavelength;
	}
	public void setWavelength(long wavelength) {
		this.wavelength = wavelength;
	}
	public RadiationTypes getType() {
		return type;
	}
	public void setType(RadiationTypes type) {
		this.type = type;
	}
	public double getSensitivity() {
		return sensitivity;
	}
	public void setSensitivity(double sensitivity) {
		this.sensitivity = sensitivity;
	}
	
}
