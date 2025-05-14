package DrinkStore;
import java.util.Scanner;// 匯入 Scanner 類別，用來讀取使用者輸入
import java.util.concurrent.TimeUnit;// 匯入 TimeUnit，用來設定程式暫停時間
public class DStore {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int AltCode = -1 , quantity = 0 , total = 0  ;// 變數：選項代號、數量、總金額
		while(true){// 無限迴圈，直到使用者選擇離開
			 showMenu(); // 顯示選單
			 AltCode = sc.nextInt();// 讀取使用者輸入的選項代號
			 // 根據使用者選擇的選項，處理對應的飲料
			 if (AltCode ==1) {
				 String item1 = Drink.Beverage.BLACK_TEA.getBeverage();// 取得飲料名稱
				 quantity = enterQuantity(sc);// 讓使用者輸入數量
				 total += quantity*Drink.Beverage.BLACK_TEA.getPrice();// 計算總價
				 System.out.printf("已將 %d 杯%s加入購物車\n",quantity,item1);
				 TimeUnit.SECONDS.sleep(2); // 暫停 2 秒，模擬購物流程
			 }
			 if (AltCode ==2) {
				 String item2 = Drink.Beverage.GREEN_TEA.getBeverage();
				 quantity = enterQuantity(sc);
				 total += quantity*Drink.Beverage.GREEN_TEA.getPrice();
				 System.out.printf("已將 %d 杯%s加入購物車\n",quantity,item2); 
				 TimeUnit.SECONDS.sleep(2);
			 }
			 if (AltCode ==3) {
				 String item3 = Drink.Beverage.MILK_TEA.getBeverage();
				 quantity = enterQuantity(sc);
				 total += quantity*Drink.Beverage.MILK_TEA.getPrice();
				 System.out.printf("已將 %d 杯%s加入購物車\n",quantity,item3); 
				 TimeUnit.SECONDS.sleep(2);
			 }
				 
			 else if (AltCode == 0) { // 使用者選擇離開
				 System.out.printf("謝謝光臨，一共是："+total+ " 元");
				 break; // 結束迴圈
			 }
			 else if(AltCode !=1 & AltCode !=2 & AltCode !=3 & AltCode !=0) {// 處理無效輸入
				 System.out.println("無此選項！！");
				 TimeUnit.SECONDS.sleep(2);
			 }
			 
		}
		
		
	}
	// 顯示選單的方法
	public static void showMenu() {
		System.out.print("""
＊＊＊＊＊＊＊＊ 歡迎光臨 ＊＊＊＊＊＊＊＊
編號		品名		價格
				""");
		System.out.printf("1		%s  		$ %d\n",Drink.Beverage.BLACK_TEA.getBeverage(),Drink.Beverage.BLACK_TEA.getPrice());
		System.out.printf("2		%s  		$ %d\n",Drink.Beverage.GREEN_TEA.getBeverage(),Drink.Beverage.GREEN_TEA.getPrice());
		System.out.printf("3		%s  		$ %d\n",Drink.Beverage.MILK_TEA.getBeverage(),Drink.Beverage.MILK_TEA.getPrice());
		System.out.print("""
				＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊
				－－－－－ 開始點餐 －－－－－
				請輸入代號 (輸入 0 離開)：
				"""		);
	}
	public static int enterQuantity(Scanner sc) {
		int  quantity;
		while(true){
			 System.out.println("請輸入數量：");
			 quantity = sc.nextInt();
			 if (quantity <=0) { // 確保數量為正數
				 System.out.println("數量不能是負的或是0");
				 continue;// 重新輸入
			 }
			 else {
				 return quantity;// 回傳有效的數量
			 }
		}
	}

}
