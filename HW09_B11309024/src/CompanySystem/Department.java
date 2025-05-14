package CompanySystem;
//定義部門相關資料的類別
public class Department {
	// 使用 enum 列舉定義三個部門：IT（資訊部門）、HR（人力資源）、MA（行銷部門）
	public enum DepartmentList{
		IT(1,"資訊部門"),
		HR(2,"人力資源"),
		MA(3,"行銷部門");
		// 成員變數：部門的代號（數字）與中文名稱
		private int number;
		private String Department_chinese;
		// 列舉的建構子，用來初始化每個部門的屬性
		DepartmentList(int number , String Department_chinese){
			this.number = number;
			this.Department_chinese = Department_chinese;
		}
		// Getter 方法：取得部門的數字代號
		public int getNumber() {
			return number;
		}
		// Getter 方法：取得部門的中文名稱
		public String getDepartment_chinese() {
			return Department_chinese;
		}
		
		
	}
}
