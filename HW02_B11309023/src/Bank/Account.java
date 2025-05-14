package Bank;
import java.util.Scanner;
public class Account {
	public  static Account nowuser, otheruser1, otheruser2;// 當前使用者及其他帳戶
	public  static int ID = -1;// 靜態變數 ID，用於識別帳戶
	private String name, password;
	private int balance;
	public Account(String name, String password, int balance) { // 建構子，初始化帳戶名稱、密碼及餘額
		// TODO Auto-generated constructor stub
		this.name =name;
		this.password = password;
		this.balance =  balance;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getBalance() {
		return balance;
	}
	public void Deposit() {// 存款
		long inputMoney;
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter the amount you want to deposit:");
		inputMoney = sc.nextInt() ;
		System.out.printf(name +" Deposit $%d Sucessfully. \n" , inputMoney);
		balance += inputMoney;// 更新餘額
		System.out.println("");
		
	}
	public void WithDraw() { // 提款
		int take_money;
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter the amount you want to withdraw:");
		take_money = sc.nextInt();
		if (balance-take_money<0) { // 檢查餘額是否足夠
			System.out.println("You don't have enough money!.");
		}
		else {
			System.out.printf(name +" WithDraw $%d Sucessfully. \n" , take_money);
			System.out.println("");
			balance -= take_money;// 更新餘額
		}
	}
	public static boolean checkPassword(String Password) {// 驗證密碼，確保輸入的密碼與當前使用者的密碼匹配
		if (Password.equals(nowuser.password)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void showData() {// 顯示帳戶資訊
		System.out.println("Name:" +name);
		System.out.println("Balance:" +balance);
	}
	public int setBalanceByMinus(int minus_amount) {
		balance -= minus_amount;
		return balance;
	}	
	public int setBalanceByPlus(int plus_amount) {
		balance += plus_amount;
		return balance;
	}
	public  void Transfer(int ID,Account otheruser1,Account otheruser2) {// 轉帳功能
		Scanner sc = new Scanner(System.in);
		int ID2 , amount_money;
		System.out.print("please enter the user ID you want to transfer to:");// 輸入轉帳對象
		ID2 = sc.nextInt();
		if (ID == ID2) {
			System.out.println("you can't Transfer to yourself");
			return;
		}
		if (ID2 !=0 && ID2 !=1 && ID2 !=2 ) {
			System.out.println("No find this ID");
			System.out.println("please enter the user ID you want to transfer to again:(if you wantn't to continue,please press 00)");
			ID2 = sc.nextInt();
			if(ID2 == 00) {
				System.out.println("will back to dashboard...");
				return;
			}
		}
		 // 輸入轉帳金額
		System.out.print("please enter the amount you want to transfer:");
		amount_money = sc.nextInt();
		int now_balance =nowuser.setBalanceByMinus(amount_money);
		
		if ( now_balance< 0 ) {
			System.out.println("You don't have enough money");
			return;
		}
		// 執行轉帳
		else {
			if (ID == 0 && ID2 == 1 ) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser1.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser1.setBalanceByPlus(amount_money);
				return;
			}
			
			else if (ID == 0 && ID2 == 2 ) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser2.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser2.setBalanceByPlus(amount_money);
				return;
			}
			else if(ID == 1 && ID2 == 0) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser1.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser1.setBalanceByPlus(amount_money);
				return;
			}
			else if(ID == 1 && ID2 == 2) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser2.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser2.setBalanceByPlus(amount_money);
				return;
			}
			else if(ID == 2 && ID2 == 0) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser1.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser1.setBalanceByPlus(amount_money);
				return;
			}
			else if(ID == 2 && ID2 == 1) {
				System.out.printf(nowuser.getName()+" WithDraw $%d Sucessfully. \n" , amount_money);
				System.out.printf(otheruser2.getName() +" Deposit $%d Sucessfully. \n" , amount_money);
				otheruser2.setBalanceByPlus(amount_money);
				return;
			}
			
		}
	}
}
