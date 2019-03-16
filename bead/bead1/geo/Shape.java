package geo;

import geo.Point;

public abstract class Shape {
	protected final Point center;
	protected final double side;

	public Shape(Point center, double side) {
		this.center = center;
		this.side = side;
	}

	public abstract boolean Contains(Point p);
}