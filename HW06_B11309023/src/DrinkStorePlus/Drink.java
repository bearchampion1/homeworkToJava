package DrinkStorePlus;

public class Drink {
	public  enum Beverage{    
		BLACK_TEA("20", "紅茶"),
		GREEN_TEA("20", "綠茶"),   
		MILK_TEA("25", "奶茶"),
		BUBBLE_TEA("35", "珍珠奶茶");
		
		private final String price;
		private final String beverage;
		
		// 建構子，初始化列舉項目時傳入價格和名稱
		Beverage(String price, String beverage) {
			this.price = price;
			this.beverage=beverage;
		}
		
		// 取得飲料的價格
		public String getPrice() {
			return price;
		}
		// 取得飲料的名稱
		public String getName() {
			return beverage;
		}
	}
}
