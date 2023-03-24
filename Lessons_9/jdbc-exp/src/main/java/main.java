import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {

        // -------------------------- jdbc ����������, �������, ��������� ������ �� �� --------------------------------
//        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String pass = "11111111";
//        try {
//            Connection conection = DriverManager.getConnection(url, user, pass);
//            System.out.println("---------------------------------");
//            System.out.println("���������� ������� �����������!!!");
//            System.out.println("---------------------------------");
//            Statement statement = conection.createStatement();
//            statement.execute("UPDATE Courses SET name='��� ����������� c ���� �� PRO' where id ='1'");
//            String search = "Frontend-�����������";
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses WHERE name='" + search + "'");
//            while (resultSet.next()) {
//                String courseName = resultSet.getString("name");
//                String courseDescription = resultSet.getString("description");
//                System.out.println("��������� ������: " + courseName + " - " + courseDescription);
//            }
//            resultSet.close();
//            statement.close();
//            resultSet.close();
//        } catch (Exception ex) {
//
//        }

        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "11111111";
        try {
            Connection conection = DriverManager.getConnection(url, user, pass);
            System.out.println("---------------------------------");
            System.out.println("���������� ������� �����������!!!");
            System.out.println("---------------------------------");
            Statement statement = conection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, MONTH(subscription_date) FROM purchaselist WHERE course_name = 'Frontend-�����������' ORDER BY purchaselist.subscription_date");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String courseDate = resultSet.getString("subscription_date");
                System.out.println(courseName + " - " + courseDate);
            }
            resultSet.close();
            statement.close();
            resultSet.close();
        } catch (Exception ex) {

        }

    }
}
