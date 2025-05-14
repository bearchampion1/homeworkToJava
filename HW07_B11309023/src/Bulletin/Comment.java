package Bulletin;
import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
//自定義一個 ObjectOutputStream，不要每次寫都加 header
class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    // 覆寫 header 的寫入，改成 reset()，跳過寫入新的 stream header
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
//定義可以被序列化 (Serializable) 的類別，代表一則留言
class WriteObject implements Serializable{
	private String name;
	private String message;
	private Date date;
	// 建構子：給名字、訊息、時間
	public WriteObject(String name , String message , Date date){
		this.name = name;
		this.message = message;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return date;
	}
}
//主程式區塊
public class Comment {
	 // 寫入留言的方法
	public static void writeFile(Scanner sc){
		String name , message;
		Date timestamp = new Date();
		ObjectOutputStream output;
		boolean create_dir = false ;// 先檢查 D:\data 資料夾有沒有存在
		try {
			File dir = new File("C:\\"+"data");
			if(dir.isDirectory()) {
				create_dir = true;
			}else {
				create_dir = dir.mkdir(); // 如果不存在就創一個
			}
			if(create_dir) {
				System.out.print("What's your name:");
				sc.nextLine();
				name = sc.nextLine();
				
				File file_path = new File("C:\\data\\"+name);
				if (file_path.exists()) {// 如果檔案已經存在，代表要"追加"寫入
					output = new MyObjectOutputStream(new FileOutputStream(file_path, true));
				}
				else { // 如果是新的檔案，正常寫入 (會寫 header)
					output = new ObjectOutputStream(new FileOutputStream("C:\\data\\"+name));
				}
				System.out.println("Leave your message here:");
				message = sc.nextLine();
				 // 建立一個 WriteObject 物件，寫進檔案
				WriteObject outputObject = new WriteObject(name , message , timestamp);
				output.writeObject(outputObject);
				output.close();
				System.out.println("Your Comment was Saved!");
				
				}
			}
			catch(Exception e){
			      System.out.println("Writing object is failed.");
		    }
	}
	 // 讀取所有留言的方法
	public static void readData()  {
		ObjectInputStream input = null;
		WriteObject obj = null;
		File name_file = new File("C:\\data");
		try {
			if (name_file.isDirectory()) {
				String directory[] = name_file.list(); // 把資料夾底下所有檔案列出來
				for(String directoryname:directory) {// 逐一處理每個檔案
					System.out.println("*****************************");
					input = new ObjectInputStream(new FileInputStream("C:\\data\\"+directoryname));
					try{
						while(true) { // 讀取檔案中所有的留言物件
						obj = (WriteObject) input.readObject();//強制轉型(要先做)
						System.out.println("Name:"+obj.getName());
						System.out.println("Date:"+obj.getTime());
						System.out.println("Message:"+obj.getMessage());
						}
					}catch(EOFException eof){
						continue; // 讀到檔案結束 (End Of File) 就跳出迴圈
					}	
				}
			}				
		}
		catch(Exception e){
			System.out.println("reading object is failed");

		}
	}
	
}

