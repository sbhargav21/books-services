package demo.books.service;

import demo.books.web.api.model.BookModel;
import demo.books.web.api.model.BookModelCollection;

public interface BookService {

    public BookModel insertByBook(BookModel book);

    public BookModel update(BookModel book);

    public BookModel delete(Long id);

    public BookModel findById(Long id);
    
    public BookModelCollection getAllBooks(String authorName);
}
