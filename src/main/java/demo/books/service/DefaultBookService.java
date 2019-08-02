package demo.books.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.books.domain.Book;
import demo.books.domain.BookRepository;
import demo.books.web.api.model.BookModel;
import demo.books.web.api.model.BookModelCollection;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookModel insertByBook(BookModel book) {
        return BookUtil.convertToModel(bookRepository.save(BookUtil.convertToEntity(book)));
    }

    @Override
    public BookModel update(BookModel book) {
        return BookUtil.convertToModel(bookRepository.save(BookUtil.convertToEntity(book)));
    }

    @Override
    public BookModel delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return BookUtil.convertToModel(book);
    }

    @Override
    public BookModel findById(Long id) {
        return BookUtil.convertToModel(bookRepository.findById(id).get());
    }

    @Override
    public BookModelCollection getAllBooks(String authorName) {
        List<Book> books = bookRepository.findAll();
        if (authorName != null) {
            books = books.stream().filter(x -> x.getAuthorName().equals(authorName)).collect(Collectors.toList());
        }
        BookModelCollection booksCollection = new BookModelCollection();
        booksCollection.setBooks(BookUtil.convertToModelCollection(books));
        return booksCollection;
    }
}
