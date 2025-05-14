package DrinkStorePlus;

public class Ice {
	// 定義一個列舉類型 Ice_quantity，表示冰量選項
	public enum Ice_quantity{
		REGULAR(1, "正常冰"),
		LITTLE(2,"少冰"),
		LESS(3,"微冰"),
		FREE(4,"去冰");
		
		private final int quantity_code;// 宣告欄位：冰量代碼
		private final String Ice_Chinese;// 宣告欄位：中文描述
		 // 列舉建構子，給每個列舉成員設定代碼和中文名稱
		Ice_quantity(int quantity_code, String Ice_Chinese) {
			this.quantity_code = quantity_code;
			this.Ice_Chinese=Ice_Chinese;
		}
		
		 // 方法：取得冰量的代碼
		public int getCodeOfIce() {
			return quantity_code;
		}
		// 方法：取得冰量的中文名稱
		public String getChinese() {
			return Ice_Chinese;
		}
	}
	
}

