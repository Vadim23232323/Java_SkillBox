import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // --------------------------------------- Клас File ----------------------------------------------

//        File folder = new File("src\\resources");
//
//        File[] files = folder.listFiles();
//
//        // Создание каталога
//        folder.mkdir();
//
//        // Удаление каталога
//        folder.delete();
//
//        // Вывод всех катологов директории
//        for (File file : files) {
//            System.out.println(file.getAbsoluteFile());
//        }


        // --------------------- Чтение файлов с помощью FileInputStream ----------------------------------

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

        // --------------------- Чтение файлов с помощью BufferedReader ----------------------------------

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


        // --------------------------------------- Клас Files ----------------------------------------------
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

        // --------------------------------------- Задание № 9.1 ----------------------------------------------

//        Menu menu = new Menu();
//        menu.getMenu();


        // --------------------------------------- Запись в файл ----------------------------------------------

//        try {
//            PrintWriter writer = new PrintWriter("src\\resources\\Data.txt", true);
//
//            BufferedWriter bufferWriter = new BufferedWriter(writer);
//
//            writer.write("Дубовский Вадим Александрович 11");
//
//            writer.flush();
//
//            writer.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        // --------------------------------------- До запись в файл ----------------------------------------------

//        try {
//            FileWriter writer = new FileWriter("src\\resources\\Data.txt", true);
//            BufferedWriter bufferWriter = new BufferedWriter(writer);
//            bufferWriter.write("\nСеменов Егор Александрович");
//            bufferWriter.close();
//        }
//        catch (IOException e) {
//            System.out.println(e);
//        }

        // --------------------------------------- Задание № 9.2 ----------------------------------------------

        Menu menu = new Menu();
        menu.getMenu();

    }
}
