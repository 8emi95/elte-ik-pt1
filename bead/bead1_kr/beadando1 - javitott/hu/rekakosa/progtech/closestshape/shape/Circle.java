package hu.rekakosa.progtech.closestshape.shape;

import hu.rekakosa.progtech.closestshape.point.Point2D;

public class Circle extends Shape {

	public Circle(Point2D o, double r) {
		super(o, r);
	}

	@Override
	public double distanceFromPoint(Point2D point) {
                if (center.distance(point) > radius) {
			return (center.distance(point) - radius);
		}
		return 0.0;
         }


	@Override
	public String toString() {
		return String.format("circle, center: (%.4f,  %.4f); radius: %.4f.", center.getX(), center.getY(), radius);
	}
}
