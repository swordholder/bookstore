package custom.bookstore.controller;

import custom.bookstore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "/task/login", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String authorize(@Valid User user, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "login";
        } else{
            request.getSession().setAttribute("username",user.getEmail());
            return "redirect:/task/books";
        }
    }
}
