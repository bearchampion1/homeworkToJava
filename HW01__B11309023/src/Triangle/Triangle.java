package Triangle;

public class Triangle {
	private double first_side,second_side,radians,area,third_side ; 
	public Triangle(double first_side, double second_side, double radians) {
		this.radians = radians;
		this.first_side  = first_side;
		this.second_side = second_side;
	}
	public double getFirst_side() {
		return first_side;
	}
	public double getSecond_side() {
		return second_side;
	}
	public double getRadians() {
		return radians;
	}
	public  void Area_oper(double first_side, double second_side, double radians) {
		radians = Math.toRadians(radians);//度數轉弧度
		area = (first_side*second_side)/2*Math.sin(radians);//計算面積
	}
	public  void Third_side_oper(double first_side, double second_side, double radians) {
		radians = Math.toRadians(radians);
		third_side = Math.pow(first_side, 2)+Math.pow(second_side, 2) - 2*first_side*second_side*Math.cos(radians);//餘弦定理
		third_side = Math.sqrt(third_side);
	}
	public double getArea() {
		return area;
	}
	public double getThird_side() {
		return third_side;
	}
	
}
