package geo;

import geo.Shape;

public class Circle extends Shape {
	public Circle(Point center, double side) {
		super(center, side);
	}

	@Override
	public boolean Contains(Point p) {
		if (Math.pow(center.x - p.x, 2) + Math.pow(center.y - p.y, 2) < Math.pow(side, 2)) {
			return true;
		} else {
			return false;
		}
	}
}