package hu.rekakosa.progtech.closestshape.point;

public class Point2D {

	private double x;
	private double y;

	public Point2D(double first, double second) {
		x = first;
		y = second;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
        
	public double distance(Point2D other) {
                
		return Math.sqrt(((x - other.getX())*(x - other.getX())) + ((y - other.getY())*(y - other.getY())));	
        }

	public double distanceFromLine(Point2D point1, Point2D point2) {
                Point2D normalVector = normalVector(point1, point2);
		double a = normalVector.getX();
		double b = normalVector.getY();
		double c = (-1) * ((a * point1.getX()) + (b * point1.getY()));
		return Math.abs((a*x + b*y + c)) / (Math.sqrt(a*a + b*b));
	}
        
	public boolean isPointInRange(Point2D point1, Point2D point2) {
                double[] equationOfSide = new double[2];
                double[] perpendicularOfPoint1 = new double[2];
                double[] perpendicularOfPoint2 = new double[2];
               
                Point2D directionVector = directionVector(point1, point2);
                Point2D tempPoint1 = new Point2D(x, y);
                Point2D tempPoint2 = new Point2D(x, y);
                Point2D tempPoint3 = new Point2D(x, y);
                
                if (directionVector.y == 0) {
                    equationOfSide[0] = 0;
                    equationOfSide[1] = point1.y;
                    
                    perpendicularOfPoint1[0] = 0;
                    perpendicularOfPoint1[1] = point1.x;
                    
                    perpendicularOfPoint2[0] = 0;
                    perpendicularOfPoint2[1] = point2.x;
                    
                    tempPoint2.swapCoordinates();
                    tempPoint3.swapCoordinates();
                    
                    
                } else if (directionVector.x == 0) {
                    equationOfSide[0] = 0;
                    equationOfSide[1] = point1.x;

                    perpendicularOfPoint1[0] = 0;
                    perpendicularOfPoint1[1] = point1.y;
                    
                    perpendicularOfPoint2[0] = 0;
                    perpendicularOfPoint2[1] = point2.y;                    
                    
                    tempPoint1.swapCoordinates();
                    
                } else {
                    equationOfSide[0] = directionVector.y / directionVector.x;
                    equationOfSide[1] = point1.y - (directionVector.y / directionVector.x) * point1.x;
                    
                    perpendicularOfPoint1[0] = (-1) * (directionVector.x / directionVector.y);
                    perpendicularOfPoint1[1] = point1.y + point1.x * (directionVector.x / directionVector.y);
                    
                    perpendicularOfPoint2[0] = (-1) * (directionVector.x / directionVector.y);
                    perpendicularOfPoint2[1] = point2.y + point2.x * (directionVector.x / directionVector.y);      
                }
                
                
                if ((point1.getX() < point2.getX()) && (point1.getY() <= point2.getY())) {
                    flipInequalitySign(tempPoint1, equationOfSide);
                    flipInequalitySign(tempPoint3, perpendicularOfPoint2);

                } else if ((point1.getX() >= point2.getX()) && (point1.getY() < point2.getY())) {
                    flipInequalitySign(tempPoint3, perpendicularOfPoint2);

                } else if ((point1.getX() > point2.getX()) && (point1.getY() >= point2.getY())) {
                    flipInequalitySign(tempPoint2, perpendicularOfPoint1);

                } else if ((point1.getX() <= point2.getX()) && (point1.getY() > point2.getY())) {
                    flipInequalitySign(tempPoint1, equationOfSide);
                    flipInequalitySign(tempPoint2, perpendicularOfPoint1);
                }
                //default: >
              
                return ((tempPoint1.y > tempPoint1.substituteIntoEquation(equationOfSide)) &&
                        (tempPoint2.y > tempPoint2.substituteIntoEquation(perpendicularOfPoint1)) &&
                        (tempPoint3.y > tempPoint3.substituteIntoEquation(perpendicularOfPoint2)));
        }
        
        private void swapCoordinates() {
            double tmp = x;
            x = y;
            y = tmp;
        }
        private double substituteIntoEquation(double[] coefficients) {
            return (x * coefficients[0] + coefficients[1]); 
        }
        
        private void flipInequalitySign(Point2D point, double[] line) {
                for (int i = 0; i < line.length; ++i) {
                      line[i] = (-1) * line[i];
                }
                point.y *= -1;
        }
        
        private Point2D directionVector(Point2D point1, Point2D point2) {
                return new Point2D(point2.getX() - point1.getX(), point2.getY() - point1.getY());
        }
        
        private Point2D normalVector(Point2D point1, Point2D point2) {
                Point2D directionVector = directionVector(point1, point2);
                double normalX = directionVector.getY();
                double normalY = (-1) * directionVector.getX();
                return new Point2D(normalX, normalY);
            }
        
	public double minimalDistance(Point2D[] points) {
		double minimalDistance = distance(points[0]);
		for (Point2D actualPoint : points) {
			if (distance(actualPoint) < minimalDistance) {
				minimalDistance = distance(actualPoint);
			}
		}
		return minimalDistance;
	}

	public void rotateAboutPoint(Point2D point, double angle) {
		translateToOrigin(point.getX(), point.getY());
		rotateAboutOrigin(angle);
                translate(point.getX(), point.getY());
	}

	public void translateToOrigin(double dx, double dy) {
		x -= dx;
		y -= dy;
	}

	public void rotateAboutOrigin(double angle) {
                double tempX = x * Math.cos(Math.toRadians(angle)) - y * Math.sin(Math.toRadians(angle));
                double tempY = x * Math.sin(Math.toRadians(angle)) + y * Math.cos(Math.toRadians(angle));
                x = round(tempX);
                y = round(tempY);
	}
        
        public static double round(double coord) {
            return Math.round(coord * 10000.0) / 10000.0;
        }
        
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}
        
        @Override
        public String toString() {
            return String.format("(%.4f, %.4f)", getX(), getY());
        }
}
