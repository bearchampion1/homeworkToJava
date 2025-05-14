package DrinkStorePlus;
import java.util.Scanner;
public class Store {
	public static int i = 0; // i 表示購物車內的項目數
	public static int j = 0;// j 表示每個項目中欄位的位置（品名、冰量、甜度...）
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			// 顯示主畫面並取得使用者選擇
			String option = FirstDashboard(sc);
			if(option.equals("1")) {
				// 點餐
				OrderDrink(sc);
				continue;
			}
			else if(option.equals("2")) {
				  // 查看購物車
				Item.ShowCart();
			}
			else if(option.equals("0")) {
				 // 結帳並結束程式
				Item.all_of_price();
				System.out.print("Process finish with exit code 0");
				System.exit(0);
			}
			else {
				// 輸入錯誤提示
				System.out.println("僅限輸入數字及範圍內選項!");
			}
		}
		
		
	}
	// 顯示主選單，並回傳使用者選擇
	public static String FirstDashboard(Scanner sc) {
		System.out.print("""
				********歡迎來到大台科飲料店********
				(1)點餐
				(2)查看購物車
				(0)結束並退出系統
				請選擇功能[0,1,2]:
				""");
		String option  = sc.next();
		return option;
			}
		
	   // 處理點餐流程	
	public static void OrderDrink(Scanner sc) {// 顯示飲料菜單
		System.out.printf("""
				%2s%2s%2s%2s%2s%2s%2s%2s菜單%2s%2s%2s%2s%2s%2s%2s%2s
				 編號	 	品名		價格
				 1	 	%s		%s
				 2	 	%s		%s
				 3	 	%s		%s
				 4	 	%s		%s
				%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s\n
				""","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*",Drink.Beverage.BLACK_TEA.getName() , Drink.Beverage.BLACK_TEA.getPrice(),Drink.Beverage.GREEN_TEA.getName(),Drink.Beverage.GREEN_TEA.getPrice(),Drink.Beverage.MILK_TEA.getName(),Drink.Beverage.MILK_TEA.getPrice(),Drink.Beverage.BUBBLE_TEA.getName(),Drink.Beverage.BUBBLE_TEA.getPrice(),"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*");
		System.out.print("請選擇飲料編號:"); // 使用者選擇飲料
		int option_for_drink = sc.nextInt();
		  // 檢查輸入是否正確
		if (option_for_drink != 1 && option_for_drink != 2 && option_for_drink != 3 && option_for_drink != 4 ) {
			System.out.println("輸入錯誤");
			return;
		}
		else {
			// 根據選擇將飲料名稱與價格存入購物車
			if(option_for_drink ==1)
				Item.buyCart[i][j] = Drink.Beverage.BLACK_TEA.getName();
				Item.buyCart[i][j+4] = Drink.Beverage.BLACK_TEA.getPrice();
			if(option_for_drink ==2)
				Item.buyCart[i][j] = Drink.Beverage.GREEN_TEA.getName();
				Item.buyCart[i][j+4] =Drink.Beverage.GREEN_TEA.getPrice();
			if(option_for_drink ==3) 
				Item.buyCart[i][j] = Drink.Beverage.MILK_TEA.getName();
				Item.buyCart[i][j+4] = Drink.Beverage.MILK_TEA.getPrice();
			if(option_for_drink ==4) 
				Item.buyCart[i][j] = Drink.Beverage.BUBBLE_TEA.getName();
				Item.buyCart[i][j+4] =Drink.Beverage.BUBBLE_TEA.getPrice();
			chooseIce(sc,Item.buyCart[i][j+4]); // 進入選擇冰量流程
		}
	}
	 // 選擇冰量
	public static void chooseIce(Scanner sc,String price) {
		while(true) {
			System.out.printf("""
					(%d)%s (%d)%s (%d)%s (%d)%s
					請選擇飲料冰量[1,2,3,4]:
					""", Ice.Ice_quantity.REGULAR.getCodeOfIce(), Ice.Ice_quantity.REGULAR.getChinese(),Ice.Ice_quantity.LITTLE.getCodeOfIce(),Ice.Ice_quantity.LITTLE.getChinese(),Ice.Ice_quantity.LESS.getCodeOfIce(),Ice.Ice_quantity.LESS.getChinese(),Ice.Ice_quantity.FREE.getCodeOfIce(),Ice.Ice_quantity.FREE.getChinese());
			int option_for_Ice = sc.nextInt();
			 // 驗證輸入
			if (option_for_Ice!= 1 && option_for_Ice!= 2 && option_for_Ice != 3 && option_for_Ice != 4 ) {
				System.out.println("請輸入範圍內號碼!!");
				continue;
			}
			else {
				j++;// 進到下一欄
				if(option_for_Ice == Ice.Ice_quantity.REGULAR.getCodeOfIce()) {
					Item.buyCart[i][j] = Ice.Ice_quantity.REGULAR.getChinese();
				}
					
				else if(option_for_Ice == Ice.Ice_quantity.LITTLE.getCodeOfIce()) {
					Item.buyCart[i][j] = Ice.Ice_quantity.LITTLE.getChinese();
				}
					
				else if(option_for_Ice == Ice.Ice_quantity.LESS.getCodeOfIce()) {
					Item.buyCart[i][j] = Ice.Ice_quantity.LESS.getChinese();
				}
					
				else if(option_for_Ice == Ice.Ice_quantity.FREE.getCodeOfIce()) {
					Item.buyCart[i][j] = Ice.Ice_quantity.FREE.getChinese();
				}
				 // 選擇甜度	
				chooseSugar(sc,price);
				break;
			}
			
		}
	}
	public static void chooseSugar(Scanner sc,String price) {
		while(true) {
			System.out.printf("""
					(%d)%s (%d)%s (%d)%s (%d)%s (%d)%s
					請選擇飲料甜度[1,2,3,4,5]:
					""", Sugar.Sugar_level.REGULAR.getLevel(),Sugar.Sugar_level.REGULAR.getChinese(),Sugar.Sugar_level.LESS.getLevel(),Sugar.Sugar_level.LESS.getChinese(),Sugar.Sugar_level.HALF.getLevel(),Sugar.Sugar_level.HALF.getChinese(),Sugar.Sugar_level.QUARTER.getLevel(),Sugar.Sugar_level.QUARTER.getChinese(),Sugar.Sugar_level.FREE.getLevel(),Sugar.Sugar_level.FREE.getChinese());
			int option_for_Sugar = sc.nextInt();
			 // 驗證輸入
			if (option_for_Sugar!= 1 && option_for_Sugar!= 2 && option_for_Sugar != 3 && option_for_Sugar != 4 && option_for_Sugar != 5) {
				System.out.println("請輸入範圍內號碼!!");
				continue;
			}
			else {
				j++;
				if(option_for_Sugar == Sugar.Sugar_level.REGULAR.getLevel()) {
					Item.buyCart[i][j] = Sugar.Sugar_level.REGULAR.getChinese();
				}
				else if(option_for_Sugar == Sugar.Sugar_level.LESS.getLevel()) {
					Item.buyCart[i][j] = Sugar.Sugar_level.LESS.getChinese();
				}
				else if(option_for_Sugar == Sugar.Sugar_level.HALF.getLevel()) {
					Item.buyCart[i][j] = Sugar.Sugar_level.HALF.getChinese();
				}
					
				else if(option_for_Sugar== Sugar.Sugar_level.QUARTER.getLevel()) {
					Item.buyCart[i][j] = Sugar.Sugar_level.QUARTER.getChinese();
				}
				else if(option_for_Sugar == Sugar.Sugar_level.FREE.getLevel()) {
					Item.buyCart[i][j] = Sugar.Sugar_level.FREE.getChinese();
				}
				chooseQuantity(sc,price);
				break;
			}
		}
	}
	public static void chooseQuantity(Scanner sc,String price) {
		while(true) {
			System.out.print("請輸入數量:");
			int quantity = sc.nextInt();
			if (quantity <=0) {
				System.out.println("輸入錯誤");
				continue;
			}
			else {
				j++;
				String quantity_str = quantity+"";
				Item.buyCart[i][j] = quantity_str;
				j+=2; // 跳過單價欄
				TotalCount(quantity,price);
				return;
			}
		}
	}
	// 計算總價並存入購物車
	public static void TotalCount(int quantity, String Price) {
		int price = Integer.parseInt(Price),total = 0;
		total = price*quantity;
		String total_str = total+"";
		Item.buyCart[i][j] = total_str;
		i++; // 完成一筆訂單，i+1
		j=0;// 重置 j，下一筆重新填寫
		
	}
}
