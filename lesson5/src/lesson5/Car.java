package lesson5;

import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

public class Car {
	static String  numberOfCar;
	private String Carnumber ;
	private Date enterTime;
	private int fee;
	public Car(String Carnumber, Date enterTime){
		this.Carnumber = Carnumber;
		this.enterTime = enterTime; 
	}
	public String getCarnumber() {
		return Carnumber;
	}
	public Date getenterTime() {
		return enterTime;
	}
	public static void disposal1(String CarNumber,Scanner sc) {
		System.out.printf("""
				****歡迎%s車主****
				1)離場
				2)查詢提停車時長
				3)回到上一頁
				請選擇[1,2,0]:
				""", CarNumber);
		while(true) {
			int function = sc.nextInt();
			if(function == 1) {
				
			}else if(function == 2) {
				
			}else if(function == 0){
				
			}
			else {
				System.out.printf("請輸入有效數值!!");
				System.out.printf("請選擇[1,2,0]:");
			}
		}
		
	}
	public static int feeCount(Calendar c,Calendar firstTime ,Calendar NowTime ) {
		int changeMinute = 60*(NowTime.get(Calendar.MINUTE) - firstTime .get(Calendar.MINUTE)); 
		int second = NowTime.get(Calendar.SECOND) - firstTime.get(Calendar.SECOND);
		if (second + changeMinute <45) {
			System.out.println("無須繳費");
			return 0 ;
		}
		else {
			int point = (second + changeMinute)/15;
			if(point<6) {
				int fee = 50*point;
				return fee;
			}
			else if(point>=6) {
				return 300;
			}
		}
		return 0;
		
	}
	
}
