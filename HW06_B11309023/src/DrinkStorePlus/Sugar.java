package DrinkStorePlus;

public class Sugar {
	public enum Sugar_level{
		// 定義一個列舉類型 Sugar_level，表示甜度等級
		REGULAR(1, "正常甜"),
		LESS(2,"少糖"),
		HALF(3, "半糖"),
		QUARTER(4,"微糖"),
		FREE(5,"無糖");
		
		private final int level; // 宣告欄位：甜度代碼
		private final String Sugar_Chinese;  // 宣告欄位：中文描述
		// 列舉建構子，給每個甜度選項設定代碼和中文名稱
		Sugar_level(int level, String Sugar_Chinese) {
			this.level = level;
			this.Sugar_Chinese=Sugar_Chinese;
		}
		
		 // 方法：取得甜度的代碼
		public int getLevel() {
			return level;
		}
		// 方法：取得甜度的中文名稱
		public String getChinese() {
			return Sugar_Chinese;
		}
	}
	
}
