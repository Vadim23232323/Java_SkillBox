package main.Controller;

import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public List<Book> list() {
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : bookIterable){
            books.add(book);
        }
        return books;
    }

    @PostMapping(value = "/books/")
    public int add (Book book){
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable int id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            bookRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleting task by ID = " + id);
        }
    }

    @DeleteMapping("/books/")
    public ResponseEntity<String> deleteAllTasks() {
        bookRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Deleting all tasks");
    }

    @GetMapping("/books/{id}")
    public ResponseEntity get(@PathVariable int id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return  new ResponseEntity(optionalBook.get(), HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Book existingBook = optionalBook.get();
        existingBook.setId(updatedBook.getId());
        existingBook.setName(updatedBook.getName());
        existingBook.setDescription(updatedBook.getDescription());

        bookRepository.save(existingBook);

        return ResponseEntity.status(HttpStatus.OK).body("Updating Book by ID = " + id);
    }


}
