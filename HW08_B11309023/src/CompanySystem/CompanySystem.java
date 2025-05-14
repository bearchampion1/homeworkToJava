package CompanySystem;
import java.io.File;
import java.util.Scanner;
public class CompanySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int order;// 使用者輸入的選項
		
		String input ;// 使用者輸入的登入資訊
		Scanner sc = new Scanner(System.in);
		while(true) {// 系統主選單無限迴圈
			System.out.print("""
					****歡迎進入公司系統****
					1) 登入
					2) 註冊
					0) 離開
					請輸入你的選擇[1,2,0]:
					""");
			order = sc.nextInt();// 讀取使用者選項
			if (order == 1) { // 登入流程
				while(true) {
					System.out.print("請輸入工號(部門-號碼):");
					sc.nextLine();// 清除上一個 nextInt 的換行
					input = sc.nextLine();// 讀取完整工號輸入
					if(!(input.matches("[A-Z]{2}+-+\\d{6}"))) {// 檢查格式是否符合：部門2碼英文 + "-" + 6位數字（如：IT-000001）
						System.out.println("格式錯誤");
						break;// 錯誤就跳出當前登入流程回到主選單
					}
					else {
						String[] employee=input.split("-");// 將輸入的字串用 "-" 分割成 [部門, 編號]
						MemberService.Login(employee[0] , employee[1] ,sc);// 呼叫 MemberService 的登入方法
						break;// 完成一次登入流程後跳出迴圈回主選單
					}
				}
			}
			else if (order == 2) {// 註冊流程
				File dir = new File("C:\\"+"data");
				if(dir.isDirectory()) {
				}else {
					dir.mkdir(); /// 檢查 C:\data 資料夾是否存在，若否則建立
					}
				MemberService.register(sc);
			}
			else if (order == 0) { // 離開系統
				System.out.print("系統運作結束");
				System.exit(0);
			}
			else { // 無效輸入處理
				System.out.println("無此選項，請重新輸入");
			}

		}
	}

}
