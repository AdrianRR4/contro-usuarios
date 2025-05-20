package _dr21.contro_usuarios.controllers;


import _dr21.contro_usuarios.entities.Book;
import _dr21.contro_usuarios.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService= bookService;
    }

    /*@GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<List<Book>>(bookService.getAll(), HttpStatus.OK);
    }
*/
    @GetMapping("/{nameBook}")
    public ResponseEntity<Optional<Book>> getByNameBook(@PathVariable("nameBook") String nameBook){
        return new ResponseEntity<Optional<Book>>(bookService.getByNameBook(nameBook), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getPagination (@RequestParam(required = false, value = "page", defaultValue = "0")
                                                         int page, @RequestParam (required = false, value ="size", defaultValue = "3") int size){

        return new ResponseEntity<>(bookService.getPagination(page, size), HttpStatus.OK);
    }

}
