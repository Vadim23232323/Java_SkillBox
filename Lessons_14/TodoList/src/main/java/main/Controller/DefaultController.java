package main.Controller;

import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class DefaultController {

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    Calendar date = Calendar.getInstance();

    String currentDate;
    @Autowired
    private TodoRepository todoRepository;


    @RequestMapping("/")
    public String index(Model model){
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();
        for(Todo todo : todoIterable){
            todos.add(todo);
        }

        currentDate = format.format(date.getTime());
        model.addAttribute("todos", todos);
        model.addAttribute("todosCount", todos.size());
        model.addAttribute("currentDate", currentDate);
        return "index";
    }
}
