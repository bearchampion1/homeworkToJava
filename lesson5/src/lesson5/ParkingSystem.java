package lesson5;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;
import java.util.Scanner;
public class ParkingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss ");
        Calendar c =  Calendar.getInstance();
        Car[] car_read = new Car[5];
        String[] seatOfCar = new String[5];//5個位子
        Date nowTime = new Date();
        int i ;
        while(true) {
        	 int function = -1;
        	 function = enterPoint(sc);
             if (function  == 1) {
            	 boolean check  = CarNumberCheck(sc);
            	 if(check) {
            		 while(true) {
            			 for(int j=0 ;j<seatOfCar.length;j++) {
         					if(seatOfCar[j] != null && seatOfCar[j].equals(Car.numberOfCar)  ) {
               					 Car.disposal1(seatOfCar[j]);
               					 
               				 }
         				}
            			int try_time = 0;
            			i = (int) (Math.random()*4);
            			if (seatOfCar[i] == null ) {
            				seatOfCar[i] = Car.numberOfCar;
            				System.out.printf("****歡迎%s車主****\n",Car.numberOfCar);
                    		System.out.printf("正在為您辦理停車手續，請稍後...\n");
                    		System.out.printf("停車位置為:%d號\n",i+1); 
                    		car_read[i] = new Car(seatOfCar[i] ,nowTime );
                    		System.out.printf("現在時間:%tc\n",nowTime);
            				break;
            			}
            			else if(seatOfCar[i] != null ) {
            				
            				try_time++;
            				continue;
            			}
            			else if(try_time>5) {
            				System.out.printf("目前沒有車位\n");
            				break;
            			}
            		 } 
            		
            		 
            	 }            	
             }
             else if(function  == 2) {
             	
             }
             else if(function  == 0) {
             	System.out.print("程式結束");
             	System.exit(0);
             }else {
            	 System.out.println("請輸入有效功能編號!!");
             }
        }
       
        
	}
	public static int enterPoint(Scanner sc) {
		int function ;
		System.out.print("""
				****歡迎進入停車系統****
				1)輸入車牌
				2)管理員
				3)離開
				請選擇[1,2,0]:
				""");
		function = sc.nextInt()	;
		return function;
	}
	public static void disposalOfCar() {
		
	}
	public static boolean CarNumberCheck(Scanner sc) {
		 do{
   		 System.out.print("請輸入你的車牌:");
   		 Car.numberOfCar = sc.next() ;
       	 	if(!(Car.numberOfCar.matches("[A-Z]{3}-[0-9]{4}"))) {
       		 System.out.println("格式錯誤，請重新輸入(格式:三個大寫英文-四個數字)");
       	 	}
       	 	else {
       	 		return true;
       	 	}
		 }while(true) ;
   	 
	}
	
}
