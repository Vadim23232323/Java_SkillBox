import java.io.File;
import java.util.Scanner;

public class WorkFolder {

    File folder;

    File[] files;

    public File[] loadingFolder() {

        try {

            Scanner scanPathFolder = new Scanner(System.in);

            System.out.println("Введите путь к каталогу:" + "\n Пример: d:\\Java_SkillBox");

            String pathFolder = scanPathFolder.nextLine();

            folder = new File(pathFolder);

            files = folder.listFiles();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return files;
    }


    public void printFolders () {

        double sizeFolders = 0;

        if (files.length > 0) {

            try {
                // Вывод всех катологов директории
                System.out.println(Menu.ANSI_GREEN + "-----------------------------------------------------------------------" + Menu.ANSI_RESET);
                for (File file : files) {
                    System.out.println(file.getAbsoluteFile() + " Размер: " + folder.length() + " byte | " +
                            (folder.length() / (1024)) + " kb | "
                            + (folder.length() / (1024 * 1024)) + " mb | ");
                    System.out.println(Menu.ANSI_GREEN + "-----------------------------------------------------------------------" + Menu.ANSI_RESET);

                    sizeFolders += folder.length();
                }
                System.out.println("Общий размер каталога: " + sizeFolders + " byte | " + (sizeFolders / 1024) + " kb | "
                        + (sizeFolders / (1024 * 1024)) + " mb | " + (sizeFolders / (1024 * 1024 * 1024)) + " gb | ");
                System.out.println(Menu.ANSI_GREEN + "-----------------------------------------------------------------------" + Menu.ANSI_RESET);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Путь к каталогу не задан или неи имеет файлов и каталогов внутри себя!!!");
        }
    }
}


