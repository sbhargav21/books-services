package demo.books.web;

import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import demo.books.service.BookService;
import demo.books.web.api.BooksApi;
import demo.books.web.api.model.BookModel;
import demo.books.web.api.model.BookModelCollection;

@Controller
public class BookController implements BooksApi {

    @Autowired
    BookService bookService;

    @Override
    public ResponseEntity<BookModelCollection> getAllBooks(@RequestParam(value = "authorName", required = false) @Valid String authorName) {
        return ok(bookService.getAllBooks(authorName));
    }
    
    @Override
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel book) {
        BookModel newBook = bookService.insertByBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookModel> updateBook(@PathVariable("id") String id, @RequestBody BookModel book) {
        BookModel newBook = bookService.update(book);
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<BookModel> deleteBook(@PathVariable String id) {
        BookModel newBook = bookService.delete(Long.valueOf(id));
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }

}
