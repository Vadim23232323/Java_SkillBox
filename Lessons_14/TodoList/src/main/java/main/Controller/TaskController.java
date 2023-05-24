package main.Controller;

import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todos/", method = RequestMethod.GET)
    public List<Todo> list() {
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();
        for(Todo todo : todoIterable){
            todos.add(todo);
        }
        return todos;
    }

    @PostMapping(value = "/todos/")
    public int add (Todo todo){
        Todo newTodo = todoRepository.save(todo);
        return newTodo.getId();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            todoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleting task by ID = " + id);
        }
    }

    @DeleteMapping("/todos/")
    public ResponseEntity<String> deleteAllTasks() {
        todoRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Deleting all tasks");
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity get(@PathVariable int id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (!optionalTodo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return  new ResponseEntity(optionalTodo.get(), HttpStatus.OK);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Todo updatedTodo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (!optionalTodo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Todo existingTodo = optionalTodo.get();
        existingTodo.setId(updatedTodo.getId());
        existingTodo.setName(updatedTodo.getName());
        existingTodo.setDescription(updatedTodo.getDescription());

        todoRepository.save(existingTodo);

        return ResponseEntity.status(HttpStatus.OK).body("Updating task by ID = " + id);
    }


}
