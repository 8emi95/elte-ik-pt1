package geo;

import geo.Polygon;

public class Hexagon extends Polygon {
	protected double circumscribingCirlceRadius() {
		return side;
	}

	public Hexagon(Point center, double side) {
		super(center, side, 6);
	}
}
