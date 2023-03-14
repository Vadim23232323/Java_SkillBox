import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WorkFileJson {





//    // Парсим HTML файл с помощью библиотеки Jsoup и делаем выборку в файле
//    public void parseHtmlFile () {
//        Document doc = Jsoup.parse(loadHtmlFile());
//        Elements elements =  doc.select("li.start-screen-directions__item");
//        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
////        elements.forEach(System.out::println);
//        elements.forEach(element -> {
//            System.out.println(element.text());
//        });
//        System.out.println(Menu.ANSI_GREEN + "--------------------------------------------------------" + Menu.ANSI_RESET);
//    }

//    // Парсим HTML код страницы с помощью библиотеки Jsoup и делаем выборку в файле
//    public void parseHtmlSite () throws IOException {
//        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines")
//                .maxBodySize(0)
//                .userAgent("Chrome/110.0.5481.180")
//                .referrer("http://www.google.com")
//                .get();
//        Elements elements =  doc.select("div#metrodata ");
//
//        for (Element element: elements) {
//            try {
//                    System.out.println(element.text());
//
//            } catch (Exception ex) {
//                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
//            }
//
//        }
//    }


    // Парсим HTML код страницы с помощью библиотеки Jsoup и делаем выборку в файле
    public void parseHtmlSite () throws IOException {
        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines")
                .userAgent("Chrome/110.0.5481.180")
                .referrer("http://www.google.com")
                .get();

        Elements elements =  doc.select("span.name");

        for (Element element: elements) {
            Element link = element;
            String absSrc = link.text();

            try {
                if (absSrc.length() > 0) {
                    System.out.println("-------------------------");
                    System.out.println(absSrc);
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка при чтении URL, картинка не будет загружена!");
            }

        }
    }


}
