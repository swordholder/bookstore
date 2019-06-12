package custom.bookstore.service;

import custom.bookstore.model.Book;
import custom.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book findOne(Long id){
        return bookRepository.getOne(id);
    }

    public List<Book> findByIdIn(List<Long> ids){
        return bookRepository.findByIdIn(ids);
    }
}

