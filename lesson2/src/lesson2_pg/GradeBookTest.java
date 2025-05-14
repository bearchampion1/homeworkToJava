package lesson2_pg;
import java.util.Scanner;

public class GradeBookTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入人數:");
		int num = sc.nextInt();
		
		GradeBook gb = new GradeBook(num);
		gb.setGrade();
		System.out.println("***********************************");
		gb.showGrade();
		System.out.println("平均:"+gb.getMean()+"分");
		System.out.println("最大值:"+gb.getMax()+"分");
		System.out.println("及格人數:"+gb.getPassCount()+"人																				");
		
	}	
}
