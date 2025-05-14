package Bulletin;


import java.util.Scanner;


public class Bulletin {
	public static void main(String args[]) {
		Scanner sc  =  new Scanner(System.in);
		while(true) {// 無限迴圈，直到使用者選擇離開
			System.out.print("""
					≡ Welcome to Bulletin Board ≡
					1)Leave a Comment
					2)List all Comment
					0)Exit
					Please select a number in [1:2:0]:
						""");
				
				int option = sc.nextInt();
				if (option == 1) {
					Comment.writeFile(sc);
				}
				else if(option ==2){
					Comment.readData();
				}
				else if(option ==0){
					System.out.print("Service finish");
					System.exit(0);
				}
				else { // 輸入錯誤時的提示
					System.out.print("input is wrong\n");
				}
		}
		
	}
	
}
