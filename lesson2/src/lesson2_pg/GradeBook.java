package lesson2_pg;
import java.util.Scanner;
public class GradeBook {
	private double[] grade;
	
	public GradeBook(int num) {
		grade = new double[num];
		for(int i = 0; i<grade.length ; i++) {
			grade[i] = 0;
		}
		
	}
	public void setGrade() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("請輸入"+grade.length+"位同學成績:");
		for(int i = 0 ; i <grade.length ; i++ ) {
			System.out.print("第"+(i+1)+"位:");
			grade[i] = sc.nextDouble();
			}
	}
	public void showGrade() {
		for(int i = 0; i<grade.length ; i++) {
			System.out.printf("第%d位:%.2f\n",i+1,grade[i]);
		}
		System.out.println();
	}
	public double getMean(){
		double sum  =0;
		for(int i = 0; i<grade.length;i++) {
			sum+=grade[i];
		}
		double mean  =sum / grade.length;
		return mean;
	}
	public double getMax() {
		double max = Double.MIN_VALUE;
		for(int i =0 ; i<grade.length;i++ ) {
			if (grade[i]>max) {
				max = grade[i];
			}
		}
		return max;
	}
	public int getPassCount() {
		int count = 0 ;
		for(int i=0 ; i<grade.length ; i++) {
			if (grade[i]>60) count++;
		}
		return count;
	}
}
