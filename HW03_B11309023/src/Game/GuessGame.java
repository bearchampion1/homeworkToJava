package Game;
import java.util.Scanner;
import java.util.Random;

public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int try_count , play_count = 0;
		boolean continue_play = true ; // 歡迎訊息與設定最大嘗試次數
		System.out.printf("********** Welcome to GuessGame **********\r\n"
				+ "The answer's range is between 1 to 100\r\n"
				+ "Please set the maximum tries:\r\n"
				+ "");
		try_count = sc.nextInt(); // 使用者輸入嘗試次數
		while(continue_play) {        // 遊戲主迴圈
			while(play_count>0 && continue_play) { // 如果已經玩過至少一次，詢問是否要更改嘗試次數
				System.out.println("You want to change your guess turn?(Y/n)");
				char change_guess = sc.next().charAt(0);
				if (change_guess == 'Y'|| change_guess == 'y') {
					System.out.print("Please set the maximum tries:");
					try_count = sc.nextInt();  // 使用者選擇更改最大嘗試次數
					while(try_count<=0) {
						System.out.printf("Maximum tries cannot be zero or negative, please provide a positive number: \r\n"
								+ "");
						try_count = sc.nextInt();// 防止輸入0或負數
						
					}
					continue_play = playGame(sc,try_count); // 執行遊戲
					play_count++;
				}
				else {
					continue_play = playGame(sc,try_count);// 不更改嘗試次數，直接進行遊戲
				}
			}
			if(try_count>0 ) {  // 初次進入遊戲
				if (continue_play == false)//try_count 合法後的檢查
					break;
				continue_play = playGame(sc,try_count);
				play_count++;
			}
			else {
				System.out.printf("Maximum tries cannot be zero or negative, please provide a positive number: \r\n"
						+ "");// 如果 try_count 非法，要求重新輸入
				try_count = sc.nextInt();
			}
		}
		System.out.print("Thanks your play!");
		System.exit(0); // 結束程式
	}
	public static boolean playGame(Scanner sc,int try_count) { // 遊戲邏輯
		Random random = new Random();
		char continue_play;
		int answer = random.nextInt(100) + 1 , apply = 0;// 隨機生成 1 到 100 之間的數字
		System.out.printf("You'll have %d turns.",try_count);
		for(int try_times = 1;try_times<=try_count ; try_times++) {// 猜數字迴圈
	
			if (try_times == try_count) {
				System.out.println("This is your last chance! Last try: "+ "");
				// 最後一次嘗試的提示
			}else {// 其他次數提示
				System.out.printf("You have %d turns left, %d try:\r\n" + "",try_count-try_times,try_times);
			}
			apply = sc.nextInt();// 使用者輸入猜測
			
			while(!(apply<=100 && apply>=1)) { // 檢查是否在 1 到 100 的範圍內
				if (apply>100) { // 提示猜測結果
					System.out.printf("Out of range. Please think a number between 1 to 100 and try again: \r\n"+ "");
					apply = sc.nextInt();
					}
				if(apply<1) {
					System.out.println("Please input a positive number: "+ "");
					apply = sc.nextInt();
				}
			}
			
			if(apply<answer) {
				System.out.println("Your guess is smaller than the answer.\r\n"+ "");
				
			}
			else if(apply>answer) {
				System.out.println("Your guess is larger than the answer.\r\n"+ "");
			}
			else if(apply == answer) {
				System.out.printf("It took you %d turn to guess the answer, which was %d.\n", try_times , answer);
				break;
			}
			
		}
		if (apply == answer) {
			
		}else {// 若未猜中
			System.out.printf("Oops!! No turns left. The number was %d\r\n",answer);
		}
		System.out.printf("Do you want to play again? (Y/n) \r\n"+ ""); // 詢問是否重新遊玩
		continue_play = sc.next().charAt(0);
		boolean check = true;
		while(check){
			if(continue_play == 'Y' || continue_play == 'y') 
				return true; // 再玩一次
			else if(continue_play == 'N' || continue_play == 'n') 
				return false;// 不玩了
			System.out.printf("Please enter Y or n :\n");
			continue_play = sc.next().charAt(0);
		}
		return false;
	}

}
