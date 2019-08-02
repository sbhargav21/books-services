package demo.books.service;

import java.util.List;
import java.util.stream.Collectors;

import demo.books.domain.Book;
import demo.books.web.api.model.BookModel;

public class BookUtil {

    public static BookModel convertToModel(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setId("" + book.getId());
        bookModel.setName(book.getName());
        bookModel.setDescription(book.getDescription());
        bookModel.setAuthorName(book.getAuthorName());
        return bookModel;
    }

    public static List<BookModel> convertToListModel(List<Book> books) {
        return books.stream().map((book) -> BookUtil.convertToModel(book)).collect(Collectors.toList());
    }

    public static Book convertToEntity(BookModel book) {
        Book bookModel = new Book();
        if (book.getId() != null) {
            bookModel.setId(Long.valueOf(book.getId()));
        }
        bookModel.setName(book.getName());
        bookModel.setDescription(book.getDescription());
        bookModel.setAuthorName(book.getAuthorName());
        return bookModel;
    }

    public static List<BookModel> convertToModelCollection(List<Book> books) {
        return books.stream().map((book) -> BookUtil.convertToModel(book)).collect(Collectors.toList());
    }
}
