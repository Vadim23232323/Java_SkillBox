import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // --------------------------------------- ���� File ----------------------------------------------

//        File folder = new File("src\\resources");
//
//        File[] files = folder.listFiles();
//
//        // �������� ��������
//        folder.mkdir();
//
//        // �������� ��������
//        folder.delete();
//
//        // ����� ���� ��������� ����������
//        for (File file : files) {
//            System.out.println(file.getAbsoluteFile());
//        }


        // --------------------- ������ ������ � ������� FileInputStream ----------------------------------

//        StringBuilder builder = new StringBuilder();
//
//        try {
//            FileInputStream is  = new FileInputStream("src\\resources\\Data.txt");
//            for (;;) {
//                int code = is.read();
//                if (code == -1) {
//                    break;
//                }
//                char ch = (char) code;
//                builder.append(ch);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        System.out.println(builder.toString());

        // --------------------- ������ ������ � ������� BufferedReader ----------------------------------

//        StringBuilder builder = new StringBuilder();
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("src\\resources\\Data.txt"));
//            for(;;) {
//                String line = br.readLine();
//                if (line ==null) {
//                    break;
//                }
//                builder.append(line + "\n");
//            }
//        } catch (Exception ex ) {
//            ex.printStackTrace();
//        }
//        System.out.println(builder.toString());


        // --------------------------------------- ���� Files ----------------------------------------------
//
//        StringBuilder builder = new StringBuilder();
//
//        try {
//
//            List<String> Lines = Files.readAllLines(Paths.get("src\\resources\\Data.txt"));
//            Lines.forEach(line -> builder.append(line + "\n"));
//
//            } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println(builder.toString());

        // --------------------------------------- ������� � 9.1 ----------------------------------------------

        Menu menu = new Menu();
        menu.getMenu();

    }
}
