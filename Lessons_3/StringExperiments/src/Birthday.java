import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Birthday {

    public void getBirthday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date();
        System.out.println("������� ���� � �����: " + dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(1993, 11, 16);

        System.out.println("��� ���� ��������: " + dateFormat.format(calendar.getTime()));

        for (int i = 1; i <= 29; i++) {
            calendar.add(Calendar.YEAR, 1);
            System.out.println("��� " + i + " ���� ��������: " + dateFormat.format(calendar.getTime()));
        }

    }

}
