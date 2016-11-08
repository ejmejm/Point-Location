//By Edan Meyer
public class Line {
	public int number;
	public Point p1, p2;
	private static int lineCount = 0; //Used to uniquely identify every line
	public static float epsilon = 0.000001f; // Used for comparing floats that
												// might be equal

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		number = lineCount;
		lineCount++;
	}

	public Line(Point p1, Point p2, int number) {
		this.p1 = p1;
		this.p2 = p2;
		this.number = number;
	}

	public boolean colinear(Line other) { //Returns true if two lines are the same
		if (p1 == other.p1 && p2 == other.p2)
			return true;
		return false;
	}

	public float getSlope() { //Returns the slope
		return (p2.y - p1.y) / (p2.x - p1.x);
	}

	public float getYIntercept() { //Returns the Y-Intercept
		return p1.y - (getSlope() * p1.x);
	}

	public Point intersects(Line other) { // Returns intersecting point or returns null if there is no intersection
		float m1 = getSlope();			  // or if it is collinear or if the intersection is not in the box
		float b1 = getYIntercept();
		float m2 = other.getSlope();
		float b2 = other.getYIntercept();
		float x = (b2 - b1) / (m1 - m2);
		float y = x * m1 + b1;
		Point intersection = new Point(x, y);
		if (m1 == m2 || (m1 == m2 && b1 == b2) || x >= 1.0f - epsilon || x <= 0.0f + epsilon || y >= 1.0f - epsilon
				|| y <= 0.0f + epsilon || onSegment(other.p1) || onSegment(other.p2) || other.onSegment(p1)
				|| other.onSegment(p2) || !other.onSegment(intersection) || !onSegment(intersection))// If parallel or same line or don't
										// intersect inside box return null
			return null;

		return new Point(x, y);
	}

	public boolean onSegment(Point point) { // Returns true if the point is in
											// the line segment
		return Math.abs(Math.abs(getSlope() * point.x + getYIntercept()) - Math.abs(point.y)) < epsilon 
				&& Math.abs(p1.dist(p2) - (p1.dist(point) + p2.dist(point))) < epsilon ? true : false;
	}

	public boolean ccw(Point p){ //Check if a point is to the left of a line by using something similar to ray casting
		if((new Line(new Point((p.y-getYIntercept())/getSlope(), p.y), new Point(0.0f, p.y), -1)).onSegment(p))
			return true;
		return false;
	}	
	
	public boolean ccw(Line line){ //Check if a line is left of another line based on its midpoint
		return ccw(new Point((line.p1.x + line.p2.x) / 2, (line.p1.y + line.p2.y) / 2));
	}
	
	public Point ccwPoint(Line other){ //Returns the leftmost of two endpoints of a line segment
		if (other.ccw(p1))
			return p1;
		return p2;
	}

	public Point cwPoint(Line other){ //Returns the rightmost of two endpoints of a line segment
		if (!other.ccw(p1))
			return p1;
		return p2;
	}
}