package com.coolness.epicness;

public enum Unit {
		PICOMETER(10000000000000D, 0.000000000001D),
		NANOMETER(10000000000D, 0.000000001D),
		MICROMETER(10000000, 0.000001D),
		MILLIMETER(1000D, 0.001D),
		CENTIMETER(100D, 0.01D),
		DECIMETER(10D, 0.1D),
		METER(1D,1D),
		DECAMETER(0.1D, 10D),
		HECTOMETER(0.01D, 100D),
		KILOMETER(0.001D, 1000D),
		MEGAMETER(0.000001D, 10000000),
		GIGAMETER(0.000000001D, 10000000000D),
		TERAMETER(0.000000000001D, 10000000000000D);

		private double ofMeter;
		private double toMeter;

		Unit(double ofMeter, double toMeter) {
			this.ofMeter = ofMeter;
			this.toMeter = toMeter;
		}

		public double getToMeter(){
			return ofMeter;
		}
		public double getOfMeter(){
			return toMeter;
		}
	}