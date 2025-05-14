package time;
import java.util.Date; import java.text.SimpleDateFormat;
public class TimeTool {
	public static void showCurrentTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date now = new Date();
		String strDate = sdFormat.format(now);
		System.out.println(strDate);
	}
	public static boolean isLeapYear(int year) {
		if (year %4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
