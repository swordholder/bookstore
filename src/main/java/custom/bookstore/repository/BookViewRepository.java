package custom.bookstore.repository;

import custom.bookstore.model.BookView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookViewRepository extends JpaRepository<BookView, Long> {

    List<BookView> findAll();
    BookView getOne(Long id);
    List<BookView> findByBookId(Long id);
    BookView saveAndFlush(BookView bookView);
}
