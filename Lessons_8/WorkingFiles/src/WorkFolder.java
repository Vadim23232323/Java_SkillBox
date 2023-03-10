import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.LinkOption.*;
import org.apache.commons.io.FileUtils;

    // --------------------------------------- Задание № 9.1, 9.2  ----------------------------------------------
public class WorkFolder {

    File folder, folderToCopy, folderСreation;
    File[] files;

    public long sizeFolders;

    // Задаем путь к каталогу
    public File loadingFolder() {

        try {

            sizeFolders = 0;

            Scanner scanPathFolder = new Scanner(System.in);

            System.out.println("Введите путь к каталогу: " + "\t Пример: d:\\Java_SkillBox");

            String pathFolder = scanPathFolder.nextLine();

            folder = new File(pathFolder);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return folder;
    }


    // Задаем путь к каталогу в который копируем каталог
    public File loadingFolderToCopy() {

        try {

            Scanner scanPathFolderToCopy = new Scanner(System.in);

            System.out.println("Введите путь к каталогу куда будет скопирован каталог: " + "\t Пример: d:\\Java_SkillBox");

            String pathFolderToCopy = scanPathFolderToCopy.nextLine();

            folderToCopy = new File(pathFolderToCopy);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return folderToCopy;
    }

    // Вывод дерева директории и подсчет размера директории
    public long getFoldersSize(File folder) {

        files = folder.listFiles();
            try {

                // Вывод всех каталогов директории
                for (File file : files) {
                    if (file.isDirectory()) {
                        getFoldersSize(file);
                    }
                    // Суммируем размер каталогов и папок
                        sizeFolders += file.length();
                        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" +
                                "-----------------------------------------------" + Menu.ANSI_RESET);
                        System.out.println(file.getAbsoluteFile() + " Размер: " + file.length() + " byte | " +
                                (file.length() / (1024)) + " kb | " + (file.length() / (1024 * 1024)) + " mb | ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return sizeFolders;
    }


    // Вывод размера каталога
    public void printSizeFolder() {

        System.out.println(Menu.ANSI_GREEN + "----------------------------------------------------------------------------------------------" +
                "---------------------------------------------" + Menu.ANSI_RESET);
        System.out.println("Общий размер каталога: " + sizeFolders + " byte | " + (sizeFolders / 1024) + " kb | "
                + (sizeFolders / (1024 * 1024)) + " mb | " + (sizeFolders / (1024 * 1024 * 1024)) + " gb | ");
        System.out.println(Menu.ANSI_GREEN + "----------------------------------------------------------------------------------------------" +
                "---------------------------------------------" + Menu.ANSI_RESET);
    }


    // Копирование каталогов и файлов

    public boolean copyFolder(File folder, File folderToCopy) {

        files = folder.listFiles();

        try {

            // В цикле проверяем папка или файл, если файл ток копируем, если папка то копируем каждый его файл
            for (File file : files) {
                if (file.isDirectory()) {
                    folderСreation = new File(folderToCopy +"\\" +  file.getName());
                    folderСreation.mkdir();
                    copyFolder(file,folderСreation);
                } else {
                    FileUtils.copyFileToDirectory(file, folderToCopy);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    // Результат копирования
    public void resultCopy () {

        if (copyFolder(folder, folderToCopy)) {

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Файлы успешно скопированы!!!");
            System.out.println("-------------------------------------------------------------------------------------");

    } else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Не все файлы скопированы!");
            System.out.println("-------------------------------------------------------------------------------------");
        }
}

}




