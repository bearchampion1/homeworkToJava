package time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class TimeToolTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input;
		do {
			System.out.println("***Main Manu***");
			System.out.println("1) show the current time");
			System.out.println("2) Leap year");
			System.out.println("0)Exit");
			System.out.println();
			System.out.print("Please enter a number in[1,2,0]:");
			input  = sc.next();
			int num = Integer.parseInt(input);
			switch (num){
			case 1:
				TimeTool.showCurrentTime();
				TimeUnit.SECONDS.sleep(2);
				break;
			case 2:
				System.out.print("Please enter this year:");
				int year = sc.nextInt();
				if (TimeTool.isLeapYear(year)) {
					System.out.println(year +" this year is Leap year!");
					TimeUnit.SECONDS.sleep(2);
				}
				else {
					System.out.println(year +" this year isn't Leap year!");
					TimeUnit.SECONDS.sleep(2);
				}
				break;
			}
		}while(!input.equals("0") );
		sc.close();
		}

}
