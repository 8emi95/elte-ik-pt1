package hu.rekakosa.progtech.closestshape;

import hu.rekakosa.progtech.closestshape.shape.Shape;
import hu.rekakosa.progtech.closestshape.shape.Polygon;
import hu.rekakosa.progtech.closestshape.shape.Circle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import hu.rekakosa.progtech.closestshape.point.Point2D;

public class Parser {

	private ArrayList<Shape> shapes;
	private final String filename;

	public Parser(String file) {
		filename = file;
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void parse() {
                try (Scanner sc = new Scanner(new File(filename))) {
                    if (sc.hasNextLine()) {
                            Integer count = parseCount(sc.nextLine());
                    
                            if(sc.hasNextLine() && count != null) {
                                shapes = new ArrayList(count);
                            }

                            while (sc.hasNextLine()) {
                                processFileLineByLine(sc.nextLine());
                            }
                    } else {
                        System.err.println("FILE IS EMPTY");
                    }
                }

                catch(FileNotFoundException e) {
                    System.err.println("CANNOT FIND OR OPEN FILE");
                }
	}
        
        private void processFileLineByLine(String line) {
            String[] data = (line.split(","));
            if (data.length == 4) {
                Integer id = parseID(data[0]);
                Point2D center = parsePoint(data[1], data[2]);
                Double radius = parseRadius(data[3]);

                if ((id != null) && (radius != null) && (center != null)) {
                    if (id == 0) {
                        shapes.add(new Circle(center, radius));
                    } else {
                        shapes.add(new Polygon(center, radius, id));
                    }
                }
            }
        }
        
	public Integer parseCount(String data) {
		int count;
		try {
			count = Integer.parseInt(data);
			if (count >= 0) {
				return count;
                        }
                } 
                 catch (NumberFormatException nfe) {
				System.err.println("THE NUMBER OF POLYGONS IS NOT NONNEGATIVE");
			}
		return null;
	}

	public Integer parseID(String data) {
		int id;
		try {
			id = Integer.parseInt(data);
			if ((id == 0) || (id == 3) || (id == 4) || (id == 6)) {
				return id;
			}
                } catch (NumberFormatException nfe) {
				System.err.println("ID IS NOT CORRECT (0, 3, 4 OR 6 EXPECTED)");
			}
		return null;
	}

	public Point2D parsePoint(String data1, String data2) {
		double x;
                double y;
		try {
			x = Double.parseDouble(data1);
			y = Double.parseDouble(data2);
                        return new Point2D(x, y);
			
                        
		} catch (NumberFormatException nfe) {
                        System.err.println("POINT CANNOT BE CREATED");
                        return null;
                }  
        }

	public Double parseRadius(String data) {
		double radius;
		try {
			radius = Double.parseDouble(data);
			if (radius >= 0) {
				return radius;
			}
                } catch (NumberFormatException nfe) {
                                System.err.println("RADIUS IS NOT NONNEGATIVE");
			}
		return null;
	}
}