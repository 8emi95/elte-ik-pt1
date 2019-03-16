package hu.rekakosa.progtech;

import hu.rekakosa.progtech.closestshape.shape.Shape;
import hu.rekakosa.progtech.closestshape.shape.Polygon;
import hu.rekakosa.progtech.closestshape.shape.Circle;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hu.rekakosa.progtech.closestshape.Parser;
import hu.rekakosa.progtech.closestshape.point.Point2D;


public class Main {
	public static void main(String[] args) {
                Point2D point;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter the position of the point.");
                System.out.print("First coordinate: x = ");
                try {
                        String xCoord = br.readLine();
                        System.out.print("Second coordinate: y = ");
                        String yCoord = br.readLine();
                        System.out.print("\nEnter a filename: ");
                        String filename = br.readLine();
                        Parser parser = new Parser(filename);
                        parser.parse();
                        ArrayList<Shape> shapes = parser.getShapes();
                        point = parser.parsePoint(xCoord, yCoord);
                        
                    if ((shapes != null) && (point != null)) {
                       
                            double smallestDistance = Point2D.round(shapes.get(0).distanceFromPoint(point)); 
                            int indexOfClosestShape = 0;
                            
                            int i = 1;
                            for (Shape actualShape : shapes) {
                                    double actualDistance = Point2D.round((actualShape.distanceFromPoint(point)));
                                    String typeOfShape;
                                    //ArrayList sides =  new ArrayList();
                                    if (actualShape instanceof Circle) {
                                        typeOfShape = "circle";
                                    } else {
                                        typeOfShape = "polygon";
                                        
                                    }
                                    System.out.println("\n" + i + ". SHAPE: " + typeOfShape);
                                    System.out.println(" - Position of center: " + actualShape.getCenter());
                                    System.out.println(" - Length of radius: " + actualShape.getRadius());
                                    if (actualShape instanceof Polygon) {
                                        Polygon polygon = (Polygon)actualShape;
                                        System.out.println(" - Number of angles: " + polygon.getNumberOfAngles());
                                        System.out.println(" - Positions of vertices: " + polygon.verticesToString());
                                    }
                                    System.out.println(" => Distance from the point: " + actualDistance);
                                    if (actualDistance < smallestDistance) {
                                            smallestDistance = actualDistance;
                                            indexOfClosestShape = shapes.indexOf(actualShape);
                                    }
                                    ++i;
                            }

                            System.out.println("\n\nThe closest object is a " + shapes.get(indexOfClosestShape));
                    }
                } catch(IOException e) {
                    System.err.println("SOME ERROR OCCURED DURING READING");
                }			
	}
}