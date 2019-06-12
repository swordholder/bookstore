package custom.bookstore.service;

import custom.bookstore.repository.BookViewRepository;
import custom.bookstore.model.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookViewService {

    @Autowired
    private BookViewRepository bookViewRepository;

    public List<BookView> getAll(){
        return bookViewRepository.findAll();
    }

    public BookView findOne(Long id){
        return bookViewRepository.getOne(id);
    }

    public List<BookView> findByBookId(Long bookId){
        return bookViewRepository.findByBookId(bookId);
    }

    public BookView save(BookView bookView){
        return bookViewRepository.saveAndFlush(bookView);
    }
}
