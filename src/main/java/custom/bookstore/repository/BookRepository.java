package custom.bookstore.repository;

import custom.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Book getOne(Long id);
    List<Book> findByIdIn(List<Long> ids);
}
