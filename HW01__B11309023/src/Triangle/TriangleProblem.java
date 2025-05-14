package Triangle;

import java.util.Scanner;
public class TriangleProblem {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double side_a, side_b , radians;//邊長a, b,角度  
		System.out.println("Input the length of the first side of the triangle(cm):");
		side_a = scan.nextDouble();
		System.out.println("Input the length of the second side of the triangle(cm):");
		side_b = scan.nextDouble();
		if(side_a <=0 || side_b<=0 ) {//if input two of side anyone small than 1, system will stop, because it's not reasonable
			System.out.println("you can't input side small than 1");
			System.exit(1);
		}
		System.out.println("Input the degrees of the triangle(cm):");
		radians = scan.nextDouble();
		Triangle tri_1 = new Triangle(side_a, side_b, radians);//two of side into tri_1(triangle_1) for Triangle class
		tri_1.Area_oper(side_a, side_b, radians);
		tri_1.Third_side_oper(side_a, side_b, radians);
		System.out.printf("the length of the third side of the triangle is: %.2f (cm)\n", tri_1.getThird_side());
		System.out.printf("the area of the triangle is:%.2f (cm2)\n", tri_1.getArea());
		scan.close();
	}	
}
