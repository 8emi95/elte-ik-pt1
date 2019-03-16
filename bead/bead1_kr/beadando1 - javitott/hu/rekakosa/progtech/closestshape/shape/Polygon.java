package hu.rekakosa.progtech.closestshape.shape;

import hu.rekakosa.progtech.closestshape.point.Point2D;

public class Polygon extends Shape {
	private final int numberOfAngles;
	private final Point2D[] vertices;
        
        public int getNumberOfAngles() {
            return numberOfAngles;
        }

	public Polygon(Point2D center, double radius, int angles) {
		super(center, radius);
		numberOfAngles = angles;
                vertices = new Point2D[angles];
		constructPolygon(center, radius, numberOfAngles);
	}
        
        private void constructPolygon(Point2D center, double radius, int numberOfAngles) {
                double angleToRotateWith = 360/numberOfAngles;
                double singleAngle = 180 - angleToRotateWith;

                double x1 = center.getX() - radius * Math.cos(Math.toRadians(singleAngle/2));
                double y1 = center.getY() - radius * Math.sin(Math.toRadians(singleAngle/2));
                vertices[0] = new Point2D(Point2D.round(x1), Point2D.round(y1));
               
                for (int i = 1; i < numberOfAngles; ++i) {
                    Point2D tempPoint = new Point2D(vertices[i - 1].getX(), vertices[i - 1].getY());
                    tempPoint.rotateAboutPoint(center, angleToRotateWith);
                    vertices[i] = tempPoint;
                }
        }
        
	@Override
	public double distanceFromPoint(Point2D point) {
		for (int i = 0; i < numberOfAngles; ++i) {
			if (point.isPointInRange(vertices[i], vertices[(i + 1) % numberOfAngles])) {
				return point.distanceFromLine(vertices[i], vertices[(i + 1) % numberOfAngles]);                                
			}
		}
               
		if (point.distance(center) <= radius) {
			return 0.0;
                }
                
                return point.minimalDistance(vertices);
	}


	@Override
	public String toString() {
		String shape;
                switch (numberOfAngles) {
                    case 3:
                        shape = "triangle";
                        break;
                    case 4:
                        shape = "square";
                        break;
                    default:
                        shape = "hexagon";
                        break;
                }
		return String.format("%s, center: (%.4f,  %.4f); radius: %.4f.", shape, center.getX(), center.getY(), radius);
	}
        
        public String verticesToString() {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < vertices.length; ++i) {
                tmp.append("\n     ");
                tmp.append(i+1);
                tmp.append(". vertice: ");
                tmp.append(vertices[i]);
            }
            return tmp.toString();
        }
}