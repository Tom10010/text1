package date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("���ڣ� yyyy/MM/D/E " + "  'ʱ��: ' HH:mm:ss");
		System.out.println(d);
		System.out.println(s.format(d));
	}

}
