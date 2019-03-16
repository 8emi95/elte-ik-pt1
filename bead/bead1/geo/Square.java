package geo;

import geo.Polygon;

public class Square extends Polygon {
	protected double circumscribingCirlceRadius() {
		return (Math.sqrt(2) * side) / 2;
	}

	public Square(Point center, double side) {
		super(center, side, 4);
	}
}
