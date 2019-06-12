package custom.bookstore.utils;

import custom.bookstore.model.Book;
import custom.bookstore.model.BookView;
import custom.bookstore.service.BookService;
import custom.bookstore.service.BookViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookUtils {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookViewService bookViewService;

    public List<Book> getSimilarBooks(Long bookId) {

        List<BookView> bookViews = this.bookViewService.getAll();
        List<Book> books = this.bookService.getAll();

        List<BookView> currentBookViews = bookViews.stream().filter(bookView -> bookView.getBookId() == bookId).collect(Collectors.toList());
        List<BookView> otherBookViews = bookViews.stream().filter(bookView -> bookView.getBookId() != bookId).collect(Collectors.toList());


        Map<Long, List<BookView>> otherBooksMap = this.groupBooksById(otherBookViews);

        List<Long> bookIds = new ArrayList<>();

        for (Long id : otherBooksMap.keySet()) {
            double similarity = this.booksSimilar(currentBookViews, otherBooksMap.get(id));
            if (similarity < 1 && similarity > 0)
                bookIds.add(id);
        }

        if (bookIds.size() > 0)
            return bookService.findByIdIn(bookIds);

        return null;
    }

    private Map<Long, List<BookView>> groupBooksById(List<BookView> bookViews) {
        Map<Long, List<BookView>> group = new HashMap<>();

        for (BookView bookView : bookViews) {
            if (!group.containsKey(bookView.getBookId())) {
                List<BookView> list = new ArrayList<>();
                list.add(bookView);
                group.put(bookView.getBookId(),list);
            }
            else{
                List<BookView> list = group.get(bookView.getBookId());
                list.add(bookView);
                group.put(bookView.getBookId(),list);
            }
        }

        return group;
    }

    private double booksSimilar(List<BookView> currentBookViews, List<BookView> otherBookViews) {

        //didn't have enough time to finish this method, just returning hardcoded value

        return 0.8;
    }



}
