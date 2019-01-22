package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.kosiorski.model.User;
import pl.kosiorski.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

  private final UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = {"/", "/login"})
  public String showLoginPage() {

    return "login";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public ModelAndView registration() {
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    modelAndView.addObject("user", user);
    modelAndView.setViewName("registration");
    return modelAndView;
  }

  @PostMapping(value = "/registration")
  public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();
    User userExists = userService.findByLogin(user.getLogin());
    if (userExists != null) {
      bindingResult.rejectValue(
          "login", "error.user", "There is already a user registered with this login");
    }
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("registration");
    } else {
      userService.saveUser(user);
      modelAndView.addObject("successMessage", "User has been registered successfully");
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("registration");
    }
    return modelAndView;
  }
}
