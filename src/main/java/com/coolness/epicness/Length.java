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
		this.lengthPico = (long) (count * unit.getToMeter() * Unit.PICOMETER.getOfMeter());
	}

	public Length(long lengthPico) {
		this.lengthPico = lengthPico;
		this.unit = Unit.PICOMETER;
		this.count = (int) lengthPico;
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
	public double to(Unit unit) {
		// return 1 * unit.getToMeter();
		return (this.unit.getToMeter() * count) * unit.getOfMeter();
	}
}
