package geo;

import geo.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
	private static final Point POINT = new Point(5.1, 6.3);
	private static final String INPUT_FILE = "e13.txt";

	public static void main(String[] args) {
		try (ShapeParser parser = new ShapeParser(INPUT_FILE)) {
			List<Shape> shapes = parser.parse();
			System.out.println("Number of shapes that the point is inside of: " + count(shapes));
		} catch (IOException | NoSuchElementException | IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private static int count(List<Shape> shapes) {
		int contained = 0;
		for (int i = 0; i < shapes.size(); ++i) {
			if (shapes.get(i).Contains(POINT)) {
				++contained;
			}
		}
		return contained;
	}
}