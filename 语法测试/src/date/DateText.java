package date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("日期： yyyy/MM/D/E " + "  '时间: ' HH:mm:ss");
		System.out.println(d);
		System.out.println(s.format(d));
	}

}
