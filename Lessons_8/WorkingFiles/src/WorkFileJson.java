import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WorkFileJson {
    private ArrayList<JsonStation> stations = new ArrayList<>();

    public void getPrintStation () {
        for (JsonStation station: stations) {
            System.out.println("����� �������: " + station.getNumberStation() + " �������� �������: " + station.getNameStation());
            System.out.println("-----------------------------------------------------");
        }
    }


    // ������ HTML ��� �������� � ������� ���������� Jsoup � ������ ������� � �����
    public ArrayList<JsonStation> parseHtmlSite () throws IOException {
        Document doc = Jsoup.connect("https://skillbox-java.github.io/")
                .maxBodySize(0)
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();

        Elements elements =  doc.select("p.single-station");

        for (Element element: elements) {
            String numStation = element.select("span.num").text();
            String nameStation = element.select("span.name").text();
            stations.add(new JsonStation(numStation,nameStation));
            try {
                 System.out.println(numStation + nameStation);

            } catch (Exception ex) {
                System.out.println("��������� ������ ��� ������ URL, �������� �� ����� ���������!");
            }

        }
        return stations;
    }




    // ��������� CSV �������
//    public  ArrayList<BankStatement> loadCsvFile()
//    {
//        try
//        {
//            List<String> lines = Files.readAllLines(Paths.get(pathCsvFile));
//            for(String line : lines)
//            {
//                String[] fragments = line.split(",");
//                if(fragments.length != 8) {
//                    System.out.println("�� ������� ��������� ������ �������: " + line);
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
//            System.out.println("������� " + pathCsvFile + " ���������!!!");
//            System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return statements;
//    }


}
