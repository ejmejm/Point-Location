//By Edan Meyer
public class Point {
	public float x, y;
	
	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "[" + x + ", " + y + "]";
	}
	
	public float dist(Point other){
		return (float) Math.pow((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y), 0.5f);
	}
}