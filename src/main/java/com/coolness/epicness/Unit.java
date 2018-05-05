package com.coolness.epicness;

public enum Unit {
		PICOMETER(1000000000000D),
		NANOMETER(1000000000D),
		MICROMETER(1000000),
		MILLIMETER(1000D),
		CENTIMETER(100D),
		DECIMETER(10D),
		METER(1D),
		DECAMETER(0.1D),
		HECTOMETER(0.01D),
		KILOMETER(0.001D),
		MEGAMETER(0.000001),
		GIGAMETER(0.000000001D),
		TERAMETER(0.000000000001D);

		private double toMeter;
		private double ofMeter;

		Unit(double toMeter, double ofMeter) {
			this.toMeter = toMeter;
			this.ofMeter = ofMeter;
		}

		Unit(double toMeter) {
			this.ofMeter = 1D / toMeter;
			this.toMeter = toMeter;
		}

		public double getToMeter(){
			return toMeter;
		}
		public double getOfMeter(){
			return ofMeter;
		}
	}