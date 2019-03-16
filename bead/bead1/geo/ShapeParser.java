package geo;

import geo.Point;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShapeParser implements Closeable {
	private static final int CIRCLE = 0;
	private static final int TRIANGLE = 1;
	private static final int SQUARE = 2;
	private static final int HEXAGON = 3;

	private Scanner sc;

	public ShapeParser(String filename) throws FileNotFoundException {
		sc = new Scanner(new File(filename));
	}

	public List<Shape> parse() throws NoSuchElementException, NumberFormatException {
		int shapeCount = Integer.parseInt(sc.nextLine());

		List<Shape> shapes = new ArrayList<>();
		for (int i = 0; i < shapeCount; ++i) {
			String line = sc.nextLine();
			String[] splitted = line.split("\\s+");
			shapes.add(createShape(splitted));
		}
		if (sc.hasNextLine()) {
			throw new IllegalArgumentException("More shapes than necessary");
		}
		return shapes;
	}

	private Shape createShape(String[] splitted) throws NoSuchElementException, IllegalArgumentException, NumberFormatException {
		if (splitted.length != 4) {
			throw new NoSuchElementException("Not enough or too much data about the shape");
		}
		else {
			String shapeType = splitted[0];

			if (shapeType.equals("circle")) {
				return createShape(new Point(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])),
									   Double.parseDouble(splitted[3]), CIRCLE);
			} else if (shapeType.equals("triangle")) {
				return createShape(new Point(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])),
									   Double.parseDouble(splitted[3]), TRIANGLE);
			} else if (shapeType.equals("square")) {
				return createShape(new Point(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])),
									   Double.parseDouble(splitted[3]), SQUARE);
			} else if (shapeType.equals("hexagon")) {
				return createShape(new Point(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])),
									   Double.parseDouble(splitted[3]), HEXAGON);
			} else {
				throw new NoSuchElementException("Unknown shape type");
			}
		}
	}

	private Shape createShape(Point center, double side, int type) throws NoSuchElementException, IllegalArgumentException {
		if (side <= 0) {
			throw new IllegalArgumentException("Side length must be positive");
		}
		else {
			if (type == CIRCLE) {
				return new Circle(center, side);
			} else if (type == TRIANGLE) {
				return new Triangle(center, side);
			} else if (type == SQUARE) {
				return new Square(center, side);
			} else if (type == HEXAGON) {
				return new Hexagon(center, side);
			} else {
				throw new NoSuchElementException("Unknown shape type");
			}
		}
	}

	@Override
	public void close() throws IOException {
		sc.close();
	}
}