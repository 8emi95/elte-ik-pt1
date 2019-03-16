package geo;

import geo.Polygon;

public class Triangle extends Polygon {
	protected double circumscribingCirlceRadius() {
		return ((Math.sqrt(3) * side) / 3);
	}

	public Triangle(Point center, double side) {
		super(center, side, 3);
	}
}
