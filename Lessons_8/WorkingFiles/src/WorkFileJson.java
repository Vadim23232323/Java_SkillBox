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
    private static final ArrayList<JsonLine> lines = new ArrayList<>();
    private static final String pathJson = "src\\resources\\map.json";
    private static final String pathMetroSite = "https://skillbox-java.github.io/";
    private final String REGEX = "[0-9][0-9]?.";
    Document docMetro;
    Element metrodata;
    private static JsonMetro metro;


    // Печать станций и линий метро
    public void getPrintMetro() {

        System.out.println("--------------------- Список станций ---------------------");
        System.out.println("");

        for (JsonStation station : stations) {
            System.out.println(station.getNumberStation() + "  " + station.getNameStation());
        }

        System.out.println("");
        System.out.println("--------------------- Список линий ---------------------");
        System.out.println("");

        for (JsonLine line : lines) {
            System.out.println(line.getNumberLine() + "  " + line.getNameLine());
        }
    }


    // Парсим HTML код страницы с помощью библиотеки Jsoup
    public void parseHtmlSite() throws IOException {
        docMetro = Jsoup.connect(pathMetroSite)
                .maxBodySize(0)
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();
        metrodata = docMetro.getElementById("metrodata");
        Elements elementsOfStations = metrodata.getElementsByClass("js-metro-stations");
        addStations(elementsOfStations);

        //parseStations();
        parseLine();
    }

    public void addStations(Elements elements) {
        elements.forEach(
                st -> stations.add(new JsonStation( st.attr("data-line"), st.text().replaceAll(REGEX, ""))));
        getPrintMetro();
    }

    public void createJsonFile() throws IOException {
        JSONObject jsonObject = new JSONObject();
        String key1 = "stantions";
        JSONObject object = new JSONObject();
        Map<String, List<String>> stationsMetro = new TreeMap<>();

        for (int i = 0; i < lines.size(); i++) {
            JSONArray array = new JSONArray();
            String str = stations.get(i).getNameStation();
            String REGEX_FOR_STATIONS = "[\\s][\\s]";
            String[] fragments = str.split(REGEX_FOR_STATIONS);
            for (String fragment : fragments) {
                array.add(fragment.trim());
            }
            stationsMetro.put(lines.get(i).getNumberLine(), array);
        }

        metro = new JsonMetro(lines,stationsMetro);
        try (FileWriter file = new FileWriter(pathJson)) {
            file.write(GSON.toJson(metro));
        }

    }

//    // Парсим из HTML кода страницы станции метро
//    public void parseStations() {
//        Elements elementsStations = docMetro.select("p.single-station");
//
//        for (Element element : elementsStations) {
//
//            try {
//                String numStation = element.select("span.num").text();
//                String nameStation = element.select("span.name").text();
//                stations.add(new JsonStation(numStation, nameStation));
//            } catch (Exception ex) {
//                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
//            }
//        }
//    }

    // Парсим из HTML кода страницы линии метро
    public void parseLine() {
        Elements elementsLine = docMetro.select("span.js-metro-line");
        for (Element element : elementsLine) {
            try {
                String numberLine = element.attr("data-line");
                String nameLine = element.text();
                lines.add(new JsonLine(numberLine, nameLine));

            } catch (Exception ex) {
                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
            }
        }
    }


//    // Создаем json файл метро
//    public void createJsonFile() throws IOException {
//
//        metro = new JsonMetro(lines,stations);
//        try (FileWriter file = new FileWriter(pathJson)) {
//            file.write(GSON.toJson(metro));
//        }
//    }


    static String parseFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> sb.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void JsonParser() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(parseFile(pathJson));

       ArrayList<String> stations = (ArrayList<String>) jsonObject.get("stations");
        for (String station : stations) {
            JSONArray stationsArray = (JSONArray) stations;
            for (JsonLine line : metro.getLines()) {
                if (line.getNumberLine().equals(line.getNumberLine())) {
                    System.out.println("Линия " + line.getNumberLine() + " " + line.getNameLine() + " -> количество станций: " + stationsArray.size());

                }
            }
        }
    }
}
