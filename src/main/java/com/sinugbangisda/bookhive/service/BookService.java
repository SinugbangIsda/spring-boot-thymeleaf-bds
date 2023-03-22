package com.sinugbangisda.bookhive.service;
import com.sinugbangisda.bookhive.entity.Book;
import com.sinugbangisda.bookhive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> fetchAllBooks() {
        return repository.findAll();
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Book bookRequest, long id) {
        Book req = repository.findById(id).get();
        req.setName(bookRequest.getName());
        req.setAuthor(bookRequest.getAuthor());
        req.setGenre(bookRequest.getGenre());
        req.setPrice(bookRequest.getPrice());
        return repository.save(req);
    }

    public Book findBookById(Integer id) {
        return repository.findById(id.longValue()).get();
    }

    public String deleteBook(Integer id) {
        repository.deleteById(id.longValue());
        return "Item deleted.";
    }
}
