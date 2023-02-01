import java.util.Scanner;
import java.util.ArrayList;

// Задание 5.4 Создает список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
public class Array_list {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> todoList = new ArrayList<>();
    Scanner scanIndex = new Scanner(System.in);
    Scanner scanElement = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String todoElement;
    int todoIndex = 0, command = 0;

    //Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- Выводит список дел " +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- Добавляет запись в список дел " +
                ANSI_GREEN + "\" \n\t 3. EDIT " + ANSI_RESET + "- Изменяет запись в списке дел " +
                ANSI_GREEN + "\" \n\t 4. DELETE " + ANSI_RESET + "- Удаляет запись списке " +
                ANSI_GREEN + "\" \n\t 5. DELETE-ALL " + ANSI_RESET + "- Удаляет все записи в списке дел" +
                ANSI_GREEN + "\" \n\t 6. EXIT " + ANSI_RESET + "- Выход из приложения.");
        setCommand();
    }

    //Ввод с консоли номера команды
    public void setCommand() {

        command = 0;

        System.out.println("Введите № команды: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                printArrayList();
                break;
            case 2:
                setAddArrayList();
                getMenu();
            case 3:
                setEditArrayList();
                getMenu();
            case 4:
                setDeleteArrayList();
                getMenu();
            case 5:
                setDeleteAllArrayList();
                getMenu();
            case 6:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 0 || command > 6) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }

    // Добавление записи в ArrayList из консоли
    public ArrayList<String> setAddArrayList() {
        System.out.println("Введите № записи");
        todoIndex = scanIndex.nextInt();
        System.out.println("Введите название записи: ");
        todoElement = scanElement.nextLine();
        todoList.add(todoIndex, todoElement);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Запись " + ANSI_GREEN + "№ " + todoIndex + " : " + todoElement + ANSI_RESET + " добавлена в список ");
        System.out.println("-------------------------------------------------------------------");
        command = 0;
        return todoList;
    }

    // Изменение записи в ArrayList из консоли
    public ArrayList<String> setEditArrayList() {

        System.out.println("Введите № записи которую хотите заменить:");
        todoIndex = scanIndex.nextInt();
        System.out.println("Введите новое название записи: ");
        todoElement = scanElement.nextLine();
        todoList.set(todoIndex, todoElement);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Запись " + ANSI_GREEN + todoElement + ANSI_RESET + " заменена в списке ");
        System.out.println("-------------------------------------------------------------------");
        getMenu();
        return todoList;
    }

    // Удаление записи из ArrayList
    public ArrayList<String> setDeleteArrayList() {
        System.out.println("Введите № записи которую хотите удалить:");
        todoIndex = scanIndex.nextInt();
        todoList.remove(todoIndex);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Запись " + ANSI_GREEN + todoElement + ANSI_RESET + " удалена из списка ");
        System.out.println("-------------------------------------------------------------------");
        return todoList;
    }

    // Удаление всех записей из ArrayList
    public ArrayList<String> setDeleteAllArrayList() {
        todoList.removeAll(todoList);
        System.out.println("Список удален ");
        return todoList;
    }

    // Вывод списка в консоль
    public void printArrayList() {

        System.out.println(ANSI_GREEN + " Список дел: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (todoList.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
        } else {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println("Запись №" + i + ": " + todoList.get(i));
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

}
