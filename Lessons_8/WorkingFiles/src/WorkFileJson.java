import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WorkFileJson {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final ArrayList<JsonStation> stations = new ArrayList<>();
    private static ArrayList<JsonLine> lines = new ArrayList<>();
    private static final String pathJson = "src\\resources\\map.json";
    private static final String pathMetroSite = "https://skillbox-java.github.io/";
    private final String REGEX = "[0-9][0-9]?.";
    Document docMetro;
    Element metrodata;
    private static JsonMetro metro;


    // Парсим HTML код страницы с помощью библиотеки Jsoup
    public void parseHtmlSite() throws IOException {
        docMetro = Jsoup.connect(pathMetroSite)
                .maxBodySize(0)
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();
        metrodata = docMetro.getElementById("metrodata");
        parseStations();
        parseLine();
        getPrintMetro();
    }


    // Парсим из HTML кода страницы станции метро
    public void parseStations() {

        Elements elementsOfStations = metrodata.getElementsByClass("js-metro-stations");

        for (Element element : elementsOfStations) {

            try {
                String numberLine = element.attr("data-line");
                String nameStation = element.text().replaceAll(REGEX, "");
                stations.add(new JsonStation(numberLine, nameStation));
            } catch (Exception ex) {
                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
            }
        }
    }

    // Парсим (читаем) из HTML кода страницы линии метро
    public void parseLine() {
        Elements elementsOfLines = metrodata.getElementsByClass("js-metro-line");
        for (Element element : elementsOfLines) {
            try {
                String numberLine = element.attr("data-line");
                String nameLine = element.text();
                lines.add(new JsonLine(numberLine, nameLine));

            } catch (Exception ex) {
                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
            }
        }
    }

    // Печать станций и линий метро
    public void getPrintMetro() {

        System.out.println("--------------------- Список станций ---------------------");
        System.out.println("");

        for (JsonStation station : stations) {
            System.out.println(station.getNumberLine() + "  " + station.getNameStation());
        }

        System.out.println("");
        System.out.println("--------------------- Список линий ---------------------");
        System.out.println("");

        for (JsonLine line : lines) {
            System.out.println(line.getNumberLine() + "  " + line.getNameLine());
        }
    }

    // Создаем json файл метро
    public void createJsonFile() throws IOException {
        TreeMap<String, List<String>> station = new TreeMap<>();

        for (int i = 0; i < lines.size(); i++) {
            JSONArray array = new JSONArray();
            String str = stations.get(i).getNameStation();
            String REGEX_FOR_STATIONS = "[\\s][\\s]";
            String[] fragments = str.split(REGEX_FOR_STATIONS);
            for (String fragment : fragments) {
                array.add(fragment.trim());
            }
            station.put(lines.get(i).getNumberLine(), array);
        }

        metro = new JsonMetro(station, lines);
        try (FileWriter file = new FileWriter(pathJson)) {
            file.write(GSON.toJson(metro));
            System.out.println("Json файл успешно создан");
        }
    }

    // Парсим (читаем) Json файл
    public String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line));
            System.out.println("Json файл успешно прочитан " + pathJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    // Печатаем Json файл
    public void JsonParser() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(parseFile(pathJson));

        Map<String, List<String>> stations = (Map<String, List<String>>) jsonData.get("stations");

        for (String line : stations.keySet()) {
            ArrayList<String> nameStations = (ArrayList<String>) stations.get(line);
            System.out.println("Номер линии: " + line);
            for (String nameStation : nameStations) {
                System.out.println("Назавание станции: " + nameStation);
            }

        }

    }

}
