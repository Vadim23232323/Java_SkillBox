package main.Controller;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class DefaultController {

    DateFormat format = new SimpleDateFormat("MM.dd.yyyy");
    Calendar date = Calendar.getInstance();

    String currentDate;
    @Autowired
    private BookRepository bookRepository;

    @Value("${someParameter}")
    private Integer someParametr;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : bookIterable){
            books.add(book);
        }

        currentDate = format.format(date.getTime());
        model.addAttribute("books", books);
        model.addAttribute("booksCount", books.size());
        model.addAttribute("currentDate", currentDate);
        return "index";
    }
}
