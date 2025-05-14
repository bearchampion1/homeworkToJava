package IDChecker;

import java.util.Random;
public class ID {
	// 變數區
	private static String back_value,gender;// back_value: 儲存區域代碼, gender: 儲存性別
	private static char eng_code;// 身份證字母代碼
	private static char charArray[] = new char[11]  ; // charArray: 儲存輸入的身份證號碼
	private static int Integerarray[] = new int[11],make_number[] = new int[11];// Integerarray: 存放數字化的身份證號碼, make_number: 用來產生身份證號碼
	private static boolean checkID ;// 驗證身份證號碼是否正確
	public static String region;  // 存放身份證對應的地區名稱
	// 驗證身份證字號
	public static void verify (String id) {
		if (id.length() != 10) {// 檢查身份證字號長度是否為 10
			System.out.println("格式錯誤");
			return;
		}
		id.getChars(0, 1, charArray, 0);// 取得身份證的第一個字母
		boolean result2 = id.matches("[A-Z][1-2]\\d*+"); // 使用正規化表達式檢查格式
		if ((!result2)) { 
			System.out.println("格式錯誤");
			return;
		}
		// 取得對應的區域代碼
		back_value = CheckRegion(charArray[0]);
		back_value.getChars(0, 2, charArray, 0);
		id.getChars(1, 10, charArray, 2);
		// 轉換成數字陣列
		for(int i =0 ; i<Integerarray.length;i++) {
			Integerarray[i] = Character.getNumericValue(charArray[i]);
		}
		// 判斷性別
		if (Integerarray[2] == 1){
			gender = "男性";
		}else if(Integerarray[2] == 2) {
			gender = "女性";
		}
		// 驗證身份證字號是否有效
		checkID = countValue(Integerarray);
		
		if (checkID) {
			System.out.printf("是位出生於%s的%s\n",region,gender);
		}
		else {
			System.out.println("身份證字號錯誤\r\n");
		}
		
		
	}
	public static void generator(String city, String gender) {
		
		if(gender.equals("男") ) {
			make_number[2] = 1; 
		}else if(gender.equals("女")) {
			make_number[2] = 2; 
		}else {
			System.out.println("性別錯誤\r\n");
			return;
		}
		 // 設定區域碼
		EnterRegion(city);
		make_new_number(gender); // 產生完整的身份證號碼;
		System.out.print("產生的身份證字號為: "+eng_code);
		for(int i = 2 ; i<11 ; i++) {
			System.out.print(make_number[i]); // 印出產生的身份證號碼
		}
		System.out.println();
	}
	public static String CheckRegion(char eng) {//檢查地區代碼對應的區域
		String value ;
		switch (eng){
		case 'A':value = "10";region = "臺北市";break;
		case 'B':value = "11";region = "臺中市";break;
		case 'C':value = "12";region = "基隆市";break;
		case 'D':value = "13";region = "臺南市";break;
		case 'E':value = "14";region = "高雄市";break;
		case 'F':value = "15";region = "新北市";	break;
		case 'G':value = "16";region = "宜蘭縣";	break;
		case 'H':value = "17";region = "桃園市";break;
		case 'I':value = "34";region = "嘉義市";break;
		case 'J':value = "18";region = "新竹縣";break;
		case 'K':value = "19";region = "苗栗縣";break;
		case 'L':value = "20";region = "臺中縣";break;
		case 'M':value = "21";region = "南投縣";break;
		case 'N':value = "22";region = "彰化縣";break;
		case 'O':value = "35";region = "新竹市";break;
		case 'P':value = "23";region = "雲林縣";break;
		case 'Q':value = "24";region = "嘉義縣";break;
		case 'R':value = "25";region = "臺南縣";break;
		case 'S':value = "26";region = "高雄縣";break;
		case 'T':value = "27";region = "屏東縣";break;
		case 'U':value = "28";region = "花蓮縣";break;
		case 'V':value = "29";region = "臺東縣";break;
		case 'W':value = "32";region = "金門縣";break;
		case 'X':value = "30";region = "澎湖縣";break;
		case 'Y':value = "31";region = "陽明山管理局";break;
		case 'Z':value = "33";region = "連江縣";break;
		default:
			System.out.println("程式錯誤");
			return null;
		}
		return value;
	}
	public static boolean countValue(int[] value) {//驗證身份證字號是否合法
		int total = 0 ;
		total += value[0]+value[10];
		for(int i = 9 , j = 1; j<=9; i--,j++) { //i為權重 j是讀取1-9陣列
			total += value[j]*i;
		}
		//System.out.print("\n"+total);
		if (total%10==0) {
			System.out.println("身份證字號正確");
			return true;
		}
		else {
			return false;
		}
	}
	public static void EnterRegion(String InputRegion) {//提供地區對應的代碼
		switch (InputRegion){
		case "臺北市" :
			make_number[0]= 1;
			make_number[1]= 0;
			eng_code = 'A';
			break;
		case "台北市" :
			make_number[0]= 1;
			make_number[1]= 0;
			eng_code = 'A';
			break;
		case "臺中市":
			make_number[0]= 1;
			make_number[1]= 1;
			eng_code = 'B';
			break;
		case "台中市":
			make_number[0]= 1;
			make_number[1]= 1;
			eng_code = 'B';
			break;
		case "基隆市":
			make_number[0]= 1;
			make_number[1]= 2;
			eng_code = 'C';
			break;
		case "臺南市":
			make_number[0]= 1;
			make_number[1]= 3;
			eng_code = 'D';
			break;
		case "台南市":
			make_number[0]= 1;
			make_number[1]= 3;
			eng_code = 'D';
			break;
		case "高雄市":
			make_number[0]= 1;
			make_number[1]= 4;
			eng_code = 'E';
			break;
		case "新北市":
			make_number[0]= 1;
			make_number[1]= 5;
			eng_code = 'F';
			break;
		case "台北縣":
			make_number[0]= 1;
			make_number[1]= 5;
			eng_code = 'F';
			break;
		case "臺北縣":
			make_number[0]= 1;
			make_number[1]= 5;
			eng_code = 'F';
			break;
		case "宜蘭縣":
			make_number[0]= 1;
			make_number[1]= 6;
			eng_code = 'G';
			break;
		case "桃園市":
			make_number[0]= 1;
			make_number[1]= 7;
			eng_code = 'H';
			break;
		case "嘉義市":
			make_number[0]= 3;
			make_number[1]= 4;
			eng_code = 'I';
			break;
		case "新竹縣":
			make_number[0]= 1;
			make_number[1]= 8;
			eng_code = 'J';
			break;
		case "苗栗縣":
			make_number[0]= 1;
			make_number[1]= 9;
			eng_code = 'K';
			break;
		case "臺中縣":
			make_number[0]= 2;
			make_number[1]= 0;
			eng_code = 'L';
			break;
		case "台中縣":
			make_number[0]= 2;
			make_number[1]= 0;
			eng_code = 'L';
			break;
		case "南投縣":
			make_number[0]= 2;
			make_number[1]= 1;
			eng_code = 'M';
			break;
		case  "彰化縣":
			make_number[0]= 2;
			make_number[1]= 2;
			eng_code = 'N';
			break;
		case "新竹市":
			make_number[0]= 3;
			make_number[1]= 5;
			eng_code = 'O';
			break;
		case "雲林縣":
			make_number[0]= 2;
			make_number[1]= 3;
			eng_code = 'P';
			break;
		case "嘉義縣":
			make_number[0]= 2;
			make_number[1]= 4;
			eng_code = 'Q';
			break;
		case "臺南縣":
			make_number[0]= 2;
			make_number[1]= 5;
			eng_code = 'R';
			break;
		case "高雄縣":
			make_number[0]= 2;
			make_number[1]= 6;
			eng_code = 'S';
			break;
		case "屏東縣":
			make_number[0]= 2;
			make_number[1]= 7;
			eng_code = 'T';
			break;
		case "花蓮縣":
			make_number[0]= 2;
			make_number[1]= 8;
			eng_code = 'U';
			break;
		case "臺東縣":
			make_number[0]= 2;
			make_number[1]= 9;
			eng_code = 'V';
			break;
		case "台東縣":
			make_number[0]= 2;
			make_number[1]= 9;
			eng_code = 'V';
			break;
		case "金門縣":
			make_number[0]= 3;
			make_number[1]= 2;
			eng_code = 'W';
			break;
		case "澎湖縣":
			make_number[0]= 3;
			make_number[1]= 0;
			eng_code = 'X';
			break;
		case "陽明山管理局":
			make_number[0]= 3;
			make_number[1]= 1;
			eng_code = 'Y';
			break;
		case "陽明山":
			make_number[0]= 3;
			make_number[1]= 1;
			eng_code = 'Y';
			break;
		case "連江縣":
			make_number[0]= 3;
			make_number[1]= 3;
			eng_code = 'Z';
			break;
		default:
			System.out.println("程式錯誤");
			break;
		}
		return ;
	}
	public static void make_new_number(String gender) {// 產生身份證號碼中的隨機數
		Random random = new Random();
		for( int  i = 3 ; i<10 ; i++ ) {
			make_number[i] = random.nextInt(10); 
		}
		int total = 0 ;
		total += make_number[0];
		for(int i = 9 , j = 1; j<=9; i--,j++) { //i為權重 j是讀取1-9陣列
			total += make_number[j]*i;
		}
		if(total %10 != 0) {
			make_number[10] = (10-total%10);
		}
		else {
			make_number[10] = 0;
		}
		
	}
}
