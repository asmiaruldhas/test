
package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private  List<Book> books = new ArrayList<>();
    Book b = new Book(1l,"Asmi","java");
//    books.add(b);

    public List<Book> getAllBooks() {

        books.add(b);
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
