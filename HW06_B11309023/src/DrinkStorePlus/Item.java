package DrinkStorePlus;

public class Item {
	// 定義一個靜態二維陣列 buyCart，用來儲存購物車的內容，每筆資料有6個欄位
	static String[][] buyCart = new String[1000][6]; 
	// 建構子，可以重新定義購物車陣列的大小
	public  Item(int Drink, int detail) {
		buyCart = new String[Drink][detail];
	}
	// 顯示購物車內容的方法
	public static void ShowCart() {
		// 印出購物車表頭
		System.out.printf("%10s\t%8s\t%8s\t%6s\t %4s\t%7s\t\n", "品名", "冰量", "甜度", "數量", "單價", "總價");
		 // 逐筆印出購物車內容
		for (int i = 0; i < Store.i; i++) { // Store.i 代表目前購物車內的飲料數量
		    for (int j = 0; j < 6; j++) {
		        if (j == 0) {// 第一欄是品名
		        	 // 如果品名是珍珠奶茶，特別格式化輸出
		        	if(buyCart[i][j].equals(Drink.Beverage.BUBBLE_TEA.getName())) {
		        		if (j == 0) {
	        	        System.out.printf("%12s\t", buyCart[i][j]); // 品名，左對齊，寬12
		        	    } else if (j == 1) {
		        	        System.out.printf("%8s\t", buyCart[i][j]); // 冰量，左對齊，寬8
		        	    } else if (j == 2) {
		        	        System.out.printf("%-8s\t", buyCart[i][j]); // // 甜度，左對齊，寬8
		        	    } else if (j == 3) {
		        	        System.out.printf("%6s\t", buyCart[i][j]); // 數量，右對齊，寬6
		        	    } else if (j == 4) {
		        	        System.out.printf("%7s\t", "$" + buyCart[i][j]);  // 單價，加上$符號，右對齊，寬7
		        	    } else if (j == 5) {
		        	        System.out.printf("%9s\t", "$" + buyCart[i][j]); // 總價，加上$符號，右對齊，寬9
		        	    }continue;// 處理完這一欄後繼續到下一欄
		        	}
		        	else {
		        		 // 如果不是珍珠奶茶，正常格式化品名
		        		System.out.printf("%10s\t", buyCart[i][j]);
		        	}
		        } else if (j == 1 || j == 2) {// 冰量或甜度欄
		            System.out.printf("%8s\t", buyCart[i][j]);  // 冰量、甜度，右對齊寬8
		        } else if (j == 3) {// 數量欄
		            System.out.printf("%6s\t", buyCart[i][j]);  // 數量，右對齊寬6
		        } else if (j == 4) {// 單價欄
		            System.out.printf("%7s\t", "$" + buyCart[i][j]); // 單價，右對齊寬7
		        } else if (j == 5) { // 總價欄
		            System.out.printf("%9s\t", "$" + buyCart[i][j]); // 總價，右對齊寬9
		        }
		    }
		    System.out.println(); // 每列印完一筆資料就換行
		}
		System.out.println(); // 額外換行，讓畫面更整齊
	}
	// 計算購物車中所有商品的總價的方法
	public static void all_of_price() {
		int total =0;// 總價初始為0
		for(int i=0 ; i<Store.i;i++) {// 遍歷每筆訂單
			total += Integer.parseInt(buyCart[i][5]);// 將第六欄 (總價) 的字串轉成整數累加
		}
	    // 印出最終總價
		System.out.printf("謝謝光臨，一共是:%d元\n",total);
	}
	
}
