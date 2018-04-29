package com.coolness.epicness;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.material.Material;

public class Length {
	protected long lengthPico;
	protected Unit unit;
	protected int count;

	public Length(Unit unit, int count) {
		this.unit = unit;
		this.count = count;
		this.lengthPico = (long) (count * unit.getToMeter() * Unit.PICOMETER.getToMeter());
	}

	public boolean equals(Length l) {
		return l.lengthPico == lengthPico;
	}

	public long getLengthPico() {
		return lengthPico;
	}

	public Unit getUnit() {
		return unit;
	}

	public int getCount() {
		return count;
	}
	public int toMeters() {
		return (int) (unit.getOfMeter() * count);
	}
}
