import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.LinkOption.*;
import org.apache.commons.io.FileUtils;

    // --------------------------------------- ������� � 9.1, 9.2  ----------------------------------------------
public class WorkFolder {

    File folder, folderToCopy, folder�reation;
    File[] files;

    public long sizeFolders;

    // ������ ���� � ��������
    public File loadingFolder() {

        try {

            sizeFolders = 0;

            Scanner scanPathFolder = new Scanner(System.in);

            System.out.println("������� ���� � ��������: " + "\t ������: d:\\Java_SkillBox");

            String pathFolder = scanPathFolder.nextLine();

            folder = new File(pathFolder);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return folder;
    }


    // ������ ���� � �������� � ������� �������� �������
    public File loadingFolderToCopy() {

        try {

            Scanner scanPathFolderToCopy = new Scanner(System.in);

            System.out.println("������� ���� � �������� ���� ����� ���������� �������: " + "\t ������: d:\\Java_SkillBox");

            String pathFolderToCopy = scanPathFolderToCopy.nextLine();

            folderToCopy = new File(pathFolderToCopy);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return folderToCopy;
    }

    // ����� ������ ���������� � ������� ������� ����������
    public long getFoldersSize(File folder) {

        files = folder.listFiles();
            try {

                // ����� ���� ��������� ����������
                for (File file : files) {
                    if (file.isDirectory()) {
                        getFoldersSize(file);
                    }
                    // ��������� ������ ��������� � �����
                        sizeFolders += file.length();
                        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" +
                                "-----------------------------------------------" + Menu.ANSI_RESET);
                        System.out.println(file.getAbsoluteFile() + " ������: " + file.length() + " byte | " +
                                (file.length() / (1024)) + " kb | " + (file.length() / (1024 * 1024)) + " mb | ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return sizeFolders;
    }


    // ����� ������� ��������
    public void printSizeFolder() {

        System.out.println(Menu.ANSI_GREEN + "----------------------------------------------------------------------------------------------" +
                "---------------------------------------------" + Menu.ANSI_RESET);
        System.out.println("����� ������ ��������: " + sizeFolders + " byte | " + (sizeFolders / 1024) + " kb | "
                + (sizeFolders / (1024 * 1024)) + " mb | " + (sizeFolders / (1024 * 1024 * 1024)) + " gb | ");
        System.out.println(Menu.ANSI_GREEN + "----------------------------------------------------------------------------------------------" +
                "---------------------------------------------" + Menu.ANSI_RESET);
    }


    // ����������� ��������� � ������

    public boolean copyFolder(File folder, File folderToCopy) {

        files = folder.listFiles();

        try {

            // � ����� ��������� ����� ��� ����, ���� ���� ��� ��������, ���� ����� �� �������� ������ ��� ����
            for (File file : files) {
                if (file.isDirectory()) {
                    folder�reation = new File(folderToCopy +"\\" +  file.getName());
                    folder�reation.mkdir();
                    copyFolder(file,folder�reation);
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


    // ��������� �����������
    public void resultCopy () {

        if (copyFolder(folder, folderToCopy)) {

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("����� ������� �����������!!!");
            System.out.println("-------------------------------------------------------------------------------------");

    } else {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("�� ��� ����� �����������!");
            System.out.println("-------------------------------------------------------------------------------------");
        }
}

}




