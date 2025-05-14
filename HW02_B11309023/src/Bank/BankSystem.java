package Bank;
import java.util.Scanner;
public class BankSystem {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check = false ;
		Scanner sc = new Scanner(System.in);
		Account user1 = new Account("Mary","0000",100);
		Account user2 = new Account("Sam","1234",-10);
		Account user3 = new Account("David","5678",80);
		while(true) {
			check = login(user1, user2 ,user3); // 使用者登入
			if (check) {
				CheckLogin(check,user1, user2 ,user3);
			}
		}
	}
	public static int dashboard() {// 顯示功能選單
		Scanner sc = new Scanner(System.in);
		int mission;
		System.out.println("************Menu************");
		System.out.println("0)Deposit");
		System.out.println("1)WithDraw");
		System.out.println("2)Transfer");
		System.out.println("3)Display Account Information");
		System.out.println("4)Logout");
		System.out.println("****************************");
		System.out.print("please enter a number in [0,1,2,3,4]:");
		mission = sc.nextInt();
		return mission;
	}
	// 登入
	public static boolean  login(Account user1 ,Account user2 ,Account user3) {
		Scanner sc = new Scanner(System.in);
		boolean continue_system;
		boolean IDcheck = false ;
		String  password;
		while(true) {
		System.out.print("please enter the user ID:"); // 輸入帳號與密碼
		Account.ID = sc.nextInt();
		System.out.print("please enter the user password:");
		password = sc.next();
		 // 根據 ID 驗證使用者
		if (Account.ID == 0) {
			IDcheck = true;
			Account.nowuser = user1;
			Account.otheruser1 = user2;
			Account.otheruser2 = user3;
			if (password.equals(user1.getPassword())) {
				return true;
			}
			else {
				continue_system = PasswordError();
				if (continue_system==true) {
					break;// 若密碼錯誤，要求重新登入
				}
				else {
					System.exit(0);
				}
			}
		}
		else if (Account.ID == 1) {
			IDcheck = true;
			Account.nowuser = user2;
			Account.otheruser1 = user1;
			Account.otheruser2 = user3;
			if (password.equals(user2.getPassword())) {
				return true;
			}
			else {
				continue_system = PasswordError();
				if (continue_system==true) {
					break;// 若密碼錯誤，要求重新登入
				}
				else {
					System.exit(0);
				}
			}
		}
		else if (Account.ID == 2) {
			IDcheck = true;
			Account.nowuser = user3;
			Account.otheruser1 = user1;
			Account.otheruser2 = user2;
			if (password.equals(user3.getPassword())) {
				return true;
			}else {
				continue_system = PasswordError();
				if (continue_system==true) {
					break; // 若密碼錯誤，要求重新登入
				}
				else {
					System.exit(0);
				}
			}
			
		}
		 // 若 ID 無效則重新嘗試
		if(Account.ID != 0 || Account.ID != 1 ||Account.ID != 2 ) {
			System.out.println("your enter ID is not true ,please again");
			return false;// 若ID錯誤，要求重新登入
		}
		
		}
		return false;
	}
	public static boolean PasswordError() {
		// 密碼錯誤處理
		Scanner sc = new Scanner(System.in);
		int systemstatic;
		System.out.println("Invalid Password!!!!");
		System.out.println("If you want to keep using this system, please press 1. Otherwise,press 0.");
		systemstatic = sc.nextInt();
		if (systemstatic == 1) {// 若輸入 `1`，則返回 `true`，允許再次嘗試登入
			return true;
		}
		else {
			return false;
		}
	}
	// 執行使用者選擇的功能
	public static boolean CallFunction(int judgement,Account nowuser,Account otheruser1,Account otheruser2,int ID) {
		if (judgement == 0) {
			nowuser.Deposit();
			return true;
		}
		if (judgement == 1) {
			nowuser.WithDraw();
			return true;
		}
		if (judgement == 2) {
			nowuser.Transfer(ID,otheruser1, otheruser2);
			return true;
		}
		if (judgement == 3) {
			nowuser.showData();
			return true;
		}
		if (judgement == 4) {
			Account.nowuser  = null;
			Account.ID = -1;
			return false;
		}
		System.out.println("Your enter prompt is no function");
		return false;
	}
	public static void CheckLogin(boolean check,Account user1 ,Account user2 ,Account user3) {
		// 若登入成功
			while(check) {
				int judgement = dashboard();// 顯示選單並獲取使用者選擇
				boolean con = CallFunction(judgement,Account.nowuser,Account.otheruser1,Account.otheruser2,Account.ID);//con-->是否繼續
				if (con) { // 若返回 true，則繼續執行
					continue;
				}
				else {// 若返回 false，則重新登入
					Account.ID = -1;
					break;
				}
			}
		}
			
	
}
