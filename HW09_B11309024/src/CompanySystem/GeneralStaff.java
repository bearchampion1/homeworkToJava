package CompanySystem;

import java.io.*;
//定義一般員工類別，實作 Serializable 介面以支援物件序列化
class GeneralStaff implements Serializable {
		private String Staff_name , password , staff_Department ;// 員工屬性：姓名、密碼、部門、工號
		private  String numberOfStaff;
		// 建構子：用來初始化員工的基本資料
		public GeneralStaff(String Staff_name , String password , String staff_Department , String numberOfStaff){
			this.Staff_name =Staff_name;
			this.password = password;
			this.staff_Department = staff_Department;
			this.numberOfStaff = numberOfStaff;
		}
		

		public String getStaffName() {
			return Staff_name;
		}
		public String getPassword() {
			return password;
		}
		public String getDepartment() {
			return staff_Department;
		}
		public String  getNumber() {
			return numberOfStaff;
		}
		
}
