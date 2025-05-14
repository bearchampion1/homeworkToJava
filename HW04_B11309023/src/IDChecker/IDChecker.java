package IDChecker;
import java.util.Scanner;
import java.util.InputMismatchException;
public class IDChecker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int prompt = -1;// 存放使用者選擇的選單項目
		boolean check_process1 = false;// 存放使用者選擇的選單項目
		String toInputID , InputRegion , Inputgender; // 定義變數來儲存使用者輸入的身份證字號、區域及性別
		while(true) {// 無限迴圈，直到使用者選擇離開
			System.out.print("""
					＊＊＊＊＊＊＊＊ Menu ＊＊＊＊＊＊＊＊
					1)    驗證身分證字號
					2)    產生身份證字號
					0)    離開
					＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
					請選擇：
					""");
			prompt = sc.nextInt();
			if (prompt == 1) { // 如果使用者選擇 "驗證身份證字號"
				System.out.print("請輸入身分證字號：");
				toInputID = sc.next();
				ID.verify(toInputID);// 呼叫 ID 類別的 verify 方法進行驗證
				Thread.sleep(3000);
			}
			else if (prompt == 2) {// 如果使用者選擇 "產生身份證字號"
				System.out.println("請輸入縣市：");
				InputRegion = sc.next();
				// 檢查輸入是否為中文（\u4E00-\u9FA5 為 Unicode 的中文字範圍）
				if (!(InputRegion.matches("[\\u4E00-\\u9FA5]*"))) {
					System.out.println("縣市錯誤\r\n");// 提示錯誤訊息
					
				}else{
					check_process1 = true;
				}
				
				if(check_process1) {
					System.out.print("請輸入性別(男/女)： ");
					Inputgender = sc.next();
					ID.generator(InputRegion, Inputgender);// 呼叫 ID 類別的 generator 方法來產生身份證字號
				}
				Thread.sleep(1000);// 程式暫停 1 秒
			}
			else if(prompt == 0) {// 如果使用者選擇 "離開"
				System.out.print("程式結束");
				System.exit(0);
			}else {// 若輸入無效
				System.out.print("無此選項！\n");
				Thread.sleep(1000);
			}
		}
		
		
	}

}
