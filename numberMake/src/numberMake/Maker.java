package numberMake;
import java.util.Scanner;
public class Maker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		String check;
		System.out.print("""
				這是個序號產生器
				輸入\"1\"開始:			
				""");
		String s = sc.next();
		if (s.equals("1")) {
			do {
				number_manufacture();
				System.out.print("是否繼續產生(Y/N):");
				check = sc.next();
			}while(check.equals("Y")||check.equals("y"));
			
			sc.close();
		}
	}
	public static void number_manufacture() {
		String chars1 = "0123456789",resultString;
		String chars2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String chars3 = "abcdefghijklmnopqrstuvwxyz";
		int i ,j;
		char[] math = new char[4];
		char[] Upper= new char[6],lower= new char[5], result = new char[15];
		System.out.println("序號產生結果:");
		for(i = 0; i<4;i++) {
			math[i] = chars1.charAt((int)(Math.random()*10));
		}
		for(i = 0;i<4;i++) {
			for(j = 0 ;j<4;j++) {
				if (i ==j) {
					
				}else {
					while(math[i] == math[j]) {
						math[i] = chars1.charAt((int)(Math.random()*10));
					}
				}
			}
		}
		for(i = 0; i<6;i++) {
			Upper[i] = chars2.charAt((int)(Math.random()*26));
		}
		for(i = 0;i<6;i++) {
			for(j = 0 ;j<6;j++) {
				if (i ==j) {
					
				}else {
					while(Upper[i] == Upper[j]) {
						Upper[i] = chars2.charAt((int)(Math.random()*26));
					}
				}
			}
		}
		for(i = 0; i<5;i++) {
			lower[i] = chars3.charAt((int)(Math.random()*26));//m
		}
		for(i = 0;i<5;i++) {
			for(j = 0 ;j<5;j++) {
				if (i ==j) {
					
				}else {
					while(lower[i] == lower[j]) {
						lower[i] = chars3.charAt((int)(Math.random()*26));
					}
				}
			}
		}
		/*
		math[0] = chars1.charAt((int)(Math.random()*10));//2
		math[1] = chars1.charAt((int)(Math.random()*10));//4
		Upper[2] = chars2.charAt((int)(Math.random()*26));//J
		Upper[3] = chars2.charAt((int)(Math.random()*26));//G
		lower[4] = chars3.charAt((int)(Math.random()*26));//c
		Upper[5] = chars2.charAt((int)(Math.random()*26));//R
		lower[6] = chars3.charAt((int)(Math.random()*26));//w
		Upper[7] = chars2.charAt((int)(Math.random()*26));//V
		math[2] = chars1.charAt((int)(Math.random()*10));//6
		Upper[9] = chars2.charAt((int)(Math.random()*26));//Y
		lower[10] = chars3.charAt((int)(Math.random()*26));//m
		lower[11] = chars3.charAt((int)(Math.random()*26));//j
		Upper[12] = chars2.charAt((int)(Math.random()*26));//F
		lower[13] = chars3.charAt((int)(Math.random()*26));//m
		math[3] = chars1.charAt((int)(Math.random()*10));//3
		result = String.valueOf(c);
		*/
		for(i = 0; i<2;i++) {
			result[i] = math[i];
		}
		for(i = 2 , j=0; i<4;i++ , j++) {
			result[i] = Upper[j];
		}
		result[4] = lower[0];
		result[5] = Upper[2];
		result[6] = lower[1];
		result[7] = Upper[3];
		result[8] = math[2];
		result[9] = Upper[4];
		for(i = 10 , j=2; i<12;i++ , j++) {
			result[i] = lower[j];
		}
		result[12] = Upper[5];
		result[13] = lower[4];
		result[14] = math[3];
		resultString = String.valueOf(result);
		System.out.println(resultString);
	}
}
