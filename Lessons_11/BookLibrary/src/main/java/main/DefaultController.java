package main;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    private BookRepository bookRepository;

    @Value("${someParameter}")
    Integer someParametr;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : bookIterable){
            books.add(book);
        }

        model.addAttribute("books", books);
        model.addAttribute("booksCount", books.size());
        model.addAttribute("someParameter", someParametr);
        return "index";
    }
}
