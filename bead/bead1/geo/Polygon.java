package geo;

import geo.Shape;
import  java.lang.Math;

public abstract class Polygon extends Shape {
	protected int n;
	protected abstract double circumscribingCirlceRadius();

	public Polygon(Point center, double side, int n) {
		super(center, side);
		this.n = n;
	}

	public boolean Contains(Point point) {
		double r = circumscribingCirlceRadius();

		double[] vertx = new double[n];
		double[] verty = new double[n];
		for (int i = 0; i < n; i++) {
			vertx[i] = center.x + r * Math.cos(2 * Math.PI * i / n);
			verty[i] = center.y + r * Math.sin(2 * Math.PI * i / n);
		}

		boolean c = false;
		for (int i = 0, j = n-1; i < n; j = i++) {
			if ( ((verty[i]>point.y) != (verty[j]>point.y)) && (point.x < (vertx[j]-vertx[i]) * (point.y-verty[i]) / (verty[j]-verty[i]) + vertx[i]) ) {
				c = !c;
			}
		}
		return c;
	}
}