package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kosiorski.model.User;
import pl.kosiorski.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/list")
  public String userList(Model model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "user/user_list";
  }

  @GetMapping("/add")
  public String userForm(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "forms/user";
  }

  @PostMapping("/add")
  public String addUser(@Valid User user, BindingResult result) {
    if (result.hasErrors()) {
      return "forms/user";
    }
    userService.saveUser(user);
    return "redirect:/user/list";
  }
}
