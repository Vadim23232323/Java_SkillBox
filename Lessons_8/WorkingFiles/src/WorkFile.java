import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// --------------------------------------- ������� � 9.3, 9.4  ----------------------------------------------
public class WorkFile {


    private static final String pathCsvFile = "src/resources/movementList.csv";
    private static final String pathHtmlFile = "src/resources/code.html";
    private static String dateFormat = "dd.MM.yyyy";
    private ArrayList<BankStatement> statements = new ArrayList<>();

    private StringBuilder builder = new StringBuilder();


    // ������� ������� ���������� �� �������
    public void getPrintBankStatement () {
        try {
            if (statements.size() == 0) {
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.println("������� �����!");
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            } else {

                for (BankStatement lines: statements) {
                    System.out.println("�������� ��������: " + lines.getOperationDescription() + "        | ������: " + lines.getConsumption());
                }
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.print("����� �������: ");
                statements.stream().map(b->b.getComing()).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.print("����� ��������: ");
                statements.stream().map(b->b.getConsumption()).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // ��������� CSV �������
    public  ArrayList<BankStatement> loadCsvFile()
    {
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(pathCsvFile));
            for(String line : lines)
            {
                String[] fragments = line.split(",");
                if(fragments.length != 8) {
                    System.out.println("�� ������� ��������� ������ �������: " + line);
                    continue;
                }
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
            System.out.println("������� " + pathCsvFile + " ���������!!!");
            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return statements;
    }


    // ��������� � �������� HTML ����
    public String loadHtmlFile(){
        try {
          List<String> lines =  Files.readAllLines(Paths.get(pathHtmlFile));
          lines.forEach(line ->builder.append(line + "\n"));
          lines.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    // ������ HTML ���� � ������� ���������� Jsoup � ������ ������� � �����
    public void parseHtml () {
        Document doc = Jsoup.parse(loadHtmlFile());
        Elements elements =  doc.select("li.start-screen-directions__item");
        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//        elements.forEach(System.out::println);
        elements.forEach(element -> {
            System.out.println(element.text());
        });
        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
    }

    public void parseHtmlOnliner () throws IOException {
        Document doc = Jsoup.connect("https://www.onliner.by//")
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();

        Elements elements =  doc.select("a");
        elements.forEach(System.out::println);
    }


}
