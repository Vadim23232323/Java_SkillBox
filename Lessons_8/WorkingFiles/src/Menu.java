import java.io.IOException;
import java.util.Scanner;

public class Menu {
    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    WorkFolder folder = new WorkFolder();

    WorkFile file = new WorkFile();

    WorkFileJson json = new WorkFileJson();

    int command;

    // Меню
    public void getMenu() {
        System.out.println("Меню команд работы с файлами: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "Задайте каталог." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "Дерево каталога." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "Размер каталога." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "Копирование каталогов." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "Прочитать банковскую выписку CSV." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "Сводная информация по банковской выписке." +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "Прочитать HTML файл." +
                ANSI_GREEN + "\" \n\t 8. " + ANSI_RESET + "Прочитать код страницы сайта." +
                ANSI_GREEN + "\" \n\t 9. " + ANSI_RESET + "Прочитать код страницы сайта карты метро г.Москва." +
                ANSI_GREEN + "\" \n\t 10. " + ANSI_RESET + "Создать json файл карты метро" +
                ANSI_GREEN + "\" \n\t 11. " + ANSI_RESET + "Прочитать json файл карты метро" +
                ANSI_GREEN + "\" \n\t 12. " + ANSI_RESET + "Выход.");
        setCommand();
    }

    //Ввод с консоли номера команды
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        int command = 0;

        System.out.println("Введите № команды: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                folder.loadingFolder();
                getMenu();
            case 2:
                folder.getFoldersSize(folder.folder);
                getMenu();
            case 3:
                folder.printSizeFolder();
                getMenu();
            case 4:
                folder.copyFolder(folder.folder, folder.loadingFolderToCopy());
                folder.resultCopy();
                getMenu();
            case 5:
                file.loadCsvFile();
                getMenu();
            case 6:
                file.getPrintBankStatement();
                getMenu();
            case 7:
                file.parseHtmlFile();
                getMenu();
            case 8:
                try {
                    file.parseHtmlSite();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                getMenu();
            case 9:
                try {
                    json.parseHtmlSite();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                getMenu();
            case 10:
                try {
                    json.createJsonFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                getMenu();
            case 11:
                try {
                    json.JsonParser();
                } catch (Exception ex) {
                    // throw new RuntimeException(ex);
                    System.out.println("Ошибка 2");
                }
                getMenu();
            case 12:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                System.exit(0);
                break;
            default:
                if (command < 1 || command > 12) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }
}
