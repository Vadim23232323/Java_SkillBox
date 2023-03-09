import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkFile {


    private static final String pathFile = "src/resources/movementList.csv";

    private static String dateFormat = "dd.MM.yyyy";
    ArrayList<BankStatement> statements = new ArrayList<>();


    public void getPrintBankStatement () {
        try {
            if (statements.size() == 0) {
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.println("Выписка пуста!");
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            } else {

                for (BankStatement lines: statements) {
                    System.out.println("Название компании: " + lines.getOperationDescription() + " Расход: " + lines.getConsumption());
                }
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.print("Сумма доходов: ");
                statements.stream().map(b->b.getComing()).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.print("Сумма расходов: ");
                statements.stream().map(b->b.getConsumption()).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public  ArrayList<BankStatement> loadStaffFromFile()
    {
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(pathFile));
            for(String line : lines)
            {
                String[] fragments = line.split(",");
                if(fragments.length != 8) {
                    System.out.println(line);
                    continue;
                }
                System.out.println(line);
                statements.add(new BankStatement(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
                        fragments[4],
                        fragments[5],
                        Integer.parseInt(fragments[6]),
                        Integer.parseInt(fragments[7])
                ));


            }

            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            System.out.println("Выписка " + pathFile + " загружена!!!");
            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return statements;
    }
}
