import Bank.BankStatement;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// --------------------------------------- ������� � 9.3, 9.4  ----------------------------------------------
public class WorkFile {


    private static final String pathCsvFile = "src/resources/movementList.csv";
    private static final String pathHtmlFile = "src/resources/code.html";
    private static final String pathConfigFile = "src/resources/config.properties";
    private static String dateFormat = "dd.MM.yyyy";
    private ArrayList<BankStatement> statements = new ArrayList<>();
    private StringBuilder builder = new StringBuilder();
    Properties properties = new Properties();


    // ������� ������� ���������� �� �������
    public void getPrintBankStatement() {
        try {
            if (statements.size() == 0) {
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.println("������� �����!");
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            } else {

                for (BankStatement lines : statements) {
                    System.out.println("�������� ��������: " + lines.getOperationDescription() + "        | ������: " + lines.getConsumption());
                }
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
                System.out.print("����� �������: ");
                statements.stream().map(b -> b.getComing()).reduce((s1, s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.print("����� ��������: ");
                statements.stream().map(b -> b.getConsumption()).reduce((s1, s2) -> s1 + s2).ifPresent(System.out::println);
                System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // ��������� CSV �������
    public ArrayList<BankStatement> loadCsvFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathCsvFile));
            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length != 8) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return statements;
    }


    // ��������� � �������� HTML ����
    public String loadHtmlFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathHtmlFile));
            lines.forEach(line -> builder.append(line + "\n"));
            lines.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    // ������ HTML ���� � ������� ���������� Jsoup � ������ ������� � �����
    public void parseHtmlFile() {
        Document doc = Jsoup.parse(loadHtmlFile());
        Elements elements = doc.select("li.start-screen-directions__item");
        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//        elements.forEach(System.out::println);
        elements.forEach(element -> {
            System.out.println(element.text());
        });
        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
    }

    // ������ HTML ��� �������� � ������� ���������� Jsoup � ������ ������� � �����
    public void parseHtmlSite() throws IOException {
        Document doc = Jsoup.connect("https://money.onliner.by/2023/03/13/")
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();

        Elements elements = doc.select("img");

        for (Element element : elements) {
            Element link = element;
            String absSrc = link.attr("abs:src");

            try {
                if (absSrc.length() > 0) {
                    System.out.println("-------------------------");
                    System.out.println(absSrc);
                    downloadImage(absSrc, "image/");
                }
            } catch (Exception ex) {
                System.out.println("��������� ������ ��� ������ URL, �������� �� ����� ���������!");
            }

        }
    }


    // ��������� ��� ����������� �� HTML ��������
    public static void downloadImage(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException {
        URL imageUrl = new URL(sourceUrl);
        try (InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
             OutputStream imageWriter = new BufferedOutputStream(
                     new FileOutputStream(targetDirectory + File.separator
                             + FilenameUtils.getName(sourceUrl)));) {
            int readByte;

            while ((readByte = imageReader.read()) != -1) {
                imageWriter.write(readByte);
            }
        }
    }

    // �������� ����� ������������
    public void createConfigurationFile() {

        properties.setProperty("timeout", "3600");
        properties.setProperty("cacheSize", "10000");

        try {
            properties.store(new FileOutputStream(pathConfigFile), "FIRST CONFIG");
            System.out.println("���� " + pathConfigFile + " ������������ ������� ������!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ������ � �������� ���� ������������
    public void printConfigurationFile() {
        try {
            properties.load(new FileInputStream(pathConfigFile));
            System.out.println("���� " + pathConfigFile + " ������� ��������!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.toString());
        System.out.println("�������� ����� timeout: " + properties.getProperty("timeout"));

    }

}
