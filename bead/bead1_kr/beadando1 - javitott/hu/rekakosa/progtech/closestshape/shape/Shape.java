package hu.rekakosa.progtech.closestshape.shape;

import hu.rekakosa.progtech.closestshape.point.Point2D;

public abstract class Shape {
	
	protected final Point2D center;
	protected double radius;

        public Point2D getCenter() {
            double x = center.getX();
            double y = center.getY();
            Point2D copyPoint = new Point2D(x, y);
            return copyPoint;
        }

     public double getRadius() {
            return radius;
        }

	public Shape(Point2D center, double radius) {
            this.center = center;
            this.radius = radius; 
        }
        
	public abstract double distanceFromPoint(Point2D point);
}