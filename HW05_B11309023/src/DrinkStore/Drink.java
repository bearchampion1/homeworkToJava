package DrinkStore;
//定義 Drink 類別
public class Drink {
	// 定義一個枚舉類別 (Enum) Beverage，表示不同種類的飲料
	public  enum Beverage{    
		BLACK_TEA(20, "紅茶"),
		GREEN_TEA(20, "綠茶"),   
		MILK_TEA(25, "奶茶");
		
		private final int price;
		private final String beverage;
		
		// 建構子，初始化列舉項目時傳入價格和名稱
		Beverage(int price, String beverage) {
			this.price = price;
			this.beverage=beverage;
		}
		
		// 取得飲料的價格
		public int getPrice() {
			return price;
		}
		// 取得飲料的名稱
		public String getBeverage() {
			return beverage;
		}
	}


}
