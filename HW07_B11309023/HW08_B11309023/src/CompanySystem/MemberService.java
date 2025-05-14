package CompanySystem;
import java.io.*;
import java.util.Scanner;



public class MemberService {
	// 用來補零的陣列，例如將數字5變成00005
	static String[] zero = {"00000","0000","000","00","0"};
	public static void register(Scanner sc)  {// 註冊方法，處理使用者註冊流程
		ObjectOutputStream output ;
		String unicode;
		System.out.print("請輸入姓名:");// 輸入使用者姓名與密碼
		sc.nextLine();
		String staff_name = sc.nextLine();
		System.out.print("請輸入密碼:");
		String password = sc.nextLine();
		// 顯示部門選單
		System.out.printf("""
				%d) %s\n
				%d) %s\n
				%d) %s\n
				請選擇部門:
				""",Department.DepartmentList.IT.getNumber() ,Department.DepartmentList.IT.getDepartment_chinese() ,Department.DepartmentList.HR.getNumber() , Department.DepartmentList.HR.getDepartment_chinese(),Department.DepartmentList.MA.getNumber(),Department.DepartmentList.MA.getDepartment_chinese() );
		int option = sc.nextInt();
		try {// 根據部門選項建立資料夾與檔案
			if(option == Department.DepartmentList.IT.getNumber()) {
				boolean create_dir =false;
				int count = 1;
				File dir = new File("C:\\data\\"+"IT");
				if(dir.isDirectory()) {
					create_dir = true;
				}else {
					dir.mkdir();// 不存在就創建資料夾
					}
				if(create_dir) {
					File[] folders = dir.listFiles();
					for(File file : folders) {
						count++;// 計算已有的員工數量
					}
					// 產生員工編號與資料檔案
					unicode = createFileNum(count, "IT",sc);
					File file_path = new File("C:\\data\\IT\\"+unicode);
					
					output = new ObjectOutputStream(new FileOutputStream(file_path));
					GeneralStaff outputObject = new GeneralStaff(staff_name , password ,"IT",  unicode );
					output.writeObject(outputObject);// 寫入檔案
					System.out.println("註冊成功");
					output.close();
				
					}
			}
			// 以下 HR、MA 部門與 IT 相同邏輯
			else if(option == Department.DepartmentList.HR.getNumber()) {
				boolean create_dir =false;
				int count = 1;
				File dir = new File("C:\\data\\"+"HR");
				if(dir.isDirectory()) {
					create_dir = true;
				}else {
					dir.mkdir(); // 如果不存在就創一個
					}
				if(create_dir) {
					File[] folders = dir.listFiles();
					for(File file : folders) {
						count++;
					}
					unicode  = createFileNum(count, "HR",sc);
					File file_path = new File("C:\\data\\HR\\"+unicode);
					output = new ObjectOutputStream(new FileOutputStream(file_path));
					GeneralStaff outputObject = new GeneralStaff(staff_name , password ,"HR",  unicode );
					output.writeObject(outputObject);
					System.out.println("註冊成功");
					output.close();
					
					}
			}
			else if(option == Department.DepartmentList.MA.getNumber()) {
				boolean create_dir =false;
				int count = 1;
				File dir = new File("C:\\data\\"+"MA");
				if(dir.isDirectory()) {
					create_dir = true;
				}else {
					dir.mkdir(); // 如果不存在就創一個
					}
				if(create_dir) {
					File[] folders = dir.listFiles();
					for(File file : folders) {
						count++;
					}
					unicode  = createFileNum(count, "MA",sc);
					File file_path = new File("C:\\data\\MA\\"+unicode);
					
					output = new ObjectOutputStream(new FileOutputStream(file_path));
					GeneralStaff outputObject = new GeneralStaff(staff_name , password ,"MA",  unicode );
					output.writeObject(outputObject);
					System.out.println("註冊成功");
					output.close();
				
				}		
			}
		}
		catch(IOException e) {
			System.out.println("註冊失敗");
		
		}
	}
	// 根據員工數產生固定格式的工號（例如 00005）
	public static String createFileNum(int count ,String dep, Scanner sc) {
		String number="" ;
		if(count<10) {
			number = zero[0]+count;
		}
		else if(count<100 && count>10) {
			number = zero[1]+count;
		}
		else if(count<1000 && count>100) {
			number = zero[2]+count;
		}
		else if(count<10000 && count>1000) {
			number = zero[3]+count;
		}
		else if(count<100000 && count>10000) {
			number = zero[4]+count;
		}
		else if(count<1000000 && count>10000) {
			number = ""+count;
		}
		File file = new File("C:\\data\\"+dep+"\\"+number);
		return number ; 
	}
	// 登入方法，檢查帳號密碼是否正確
	public static void Login(String dep , String unicode ,Scanner sc)  {
		ObjectInputStream input = null;
		GeneralStaff obj = null;
		File file_path = null;
		try {// 根據部門組合檔案路徑
		while(true) {
			if (dep.equals("IT")) {
				file_path = new File("C:\\data\\IT\\"+unicode);
				input = new  ObjectInputStream(new FileInputStream("C:\\data\\IT\\"+unicode));
				break;
			}
			else if (dep.equals("HR")) {
				file_path = new File("C:\\data\\HR\\"+unicode);
				input = new  ObjectInputStream(new FileInputStream("C:\\data\\HR\\"+unicode));
				break;
			}
			else if (dep.equals("MA")) {
				 file_path = new File("C:\\data\\MA\\"+unicode);
				 
					input = new  ObjectInputStream(new FileInputStream("C:\\data\\MA\\"+unicode));
					break;
				}
			else {
				System.out.println("部門錯誤");
				return;
			}
				
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("無此員工");
				return;
			
		}
		
		try {// 檔案存在就嘗試讀取物件
			if (file_path.exists()) {	
				try{
					while(true) { 
					obj = (GeneralStaff) input.readObject();// 讀取序列化物件
					if(obj.getNumber().equals(unicode)) {
					String password;
					System.out.print("請輸入密碼:");
					password = sc.nextLine();
					if(obj.getPassword().equals(password)) {
						System.out.println("姓名:"+obj.getStaffName());
						System.out.println("部門:"+ obj.getDepartment());
						System.out.println("工號:"+ obj.getNumber());
							return;
							}
								else {
									System.out.println("密碼錯誤");
									return;
								}
							}
							}
						}catch(EOFException eof){

					}
						
				}
			
		}
		catch(Exception e){
			System.out.println("reading object is failed");
			// 讀到檔案結尾
		}
		return ;
	}
	

}
