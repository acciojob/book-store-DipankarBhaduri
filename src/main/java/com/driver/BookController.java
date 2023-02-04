package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById (@PathVariable("id") String bookid){
        return new ResponseEntity<>( bookService.findBookById(bookid) , HttpStatus.FOUND) ;
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById ( @PathVariable("id") String bookid){
        bookService.deleteBookById(bookid);
        return new ResponseEntity( null , HttpStatus.NOT_FOUND) ;
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks (){
        return new ResponseEntity<>( bookService.findAllBooks() , HttpStatus.FOUND) ;
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks (){
        bookService.deleteAllBooks();
        return new ResponseEntity<>( null , HttpStatus.FOUND) ;
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor ( @RequestParam("author") String name ){
        return new ResponseEntity<>( bookService.findBooksByAuthor(name) , HttpStatus.FOUND) ;
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre ( @RequestParam("author") String name ){
        return new ResponseEntity<>( bookService.findBooksByGenre(name) , HttpStatus.FOUND) ;
    }

}
