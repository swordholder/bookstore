package custom.bookstore.controller;

import custom.bookstore.model.Book;
import custom.bookstore.model.BookView;
import custom.bookstore.service.BookService;
import custom.bookstore.service.BookViewService;
import custom.bookstore.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookViewService bookViewService;
    @Autowired
    private BookUtils bookUtils;

    @RequestMapping(value={"/task/books", "/books"}, method = RequestMethod.GET)
    public String books(Model model){

        model.addAttribute("books",bookService.getAll());
        return "books";
    }

    @RequestMapping(value={"task/details/{id}"}, method = RequestMethod.GET)
    public String book(@PathVariable(value="id") String strId, Model model, HttpServletRequest request){
        Long id = Long.parseLong(strId);
        Book book = bookService.findOne(id);
        model.addAttribute("book",book);

        String username = (String) request.getSession().getAttribute("username");

        if(StringUtils.isEmpty(username))
            return "redirect:/task/login";

        List<Book> similarBooks = bookUtils.getSimilarBooks(id);
        model.addAttribute("similarBooks",similarBooks);

        BookView bookView = new BookView();
        bookView.setBookId(id);
        bookView.setUsername(username);

        bookViewService.save(bookView);

        return "book";
    }
}
