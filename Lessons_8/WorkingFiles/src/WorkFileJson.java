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

public class WorkFileJson {
    private ArrayList<JsonStation> stations = new ArrayList<>();

    public void getPrintStation () {
        for (JsonStation station: stations) {
            System.out.println("Номер: " + station.getNumberStation());
        }
    }


    // Парсим HTML код страницы с помощью библиотеки Jsoup и делаем выборку в файле
    public ArrayList<JsonStation> parseHtmlSite () throws IOException {
        Document doc = Jsoup.connect("https://skillbox-java.github.io/")
                .maxBodySize(0)
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();

        Elements elements =  doc.select("span.num, span.name");

        for (Element element: elements) {
            String nameStation = element.select("span.name").text();
            String numStation = element.select("span.num").text();
            // stations.add(new JsonStation(numStation,nameStation));
            try {
           // System.out.println(numStation + " " + nameStation);
                System.out.println(element.text());

            } catch (Exception ex) {
                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
            }

        }
        return stations;
    }




    // Загружаем CSV выписку
//    public  ArrayList<BankStatement> loadCsvFile()
//    {
//        try
//        {
//            List<String> lines = Files.readAllLines(Paths.get(pathCsvFile));
//            for(String line : lines)
//            {
//                String[] fragments = line.split(",");
//                if(fragments.length != 8) {
//                    System.out.println("Не удается прочитать строку выписки: " + line);
//                    continue;
//                }
//                statements.add(new BankStatement(
//                        fragments[0],
//                        fragments[1],
//                        fragments[2],
//                        (new SimpleDateFormat(dateFormat)).parse(fragments[3]),
//                        fragments[4],
//                        fragments[5],
//                        Integer.parseInt(fragments[6]),
//                        Integer.parseInt(fragments[7])
//                ));
//
//
//            }
//
//            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//            System.out.println("Выписка " + pathCsvFile + " загружена!!!");
//            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return statements;
//    }


}
