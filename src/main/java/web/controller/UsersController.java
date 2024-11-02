package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam String last_name, @RequestParam String email) {
        userService.save(name, last_name, email);
        return "redirect:/users";
    }

    @PostMapping("/users/edit")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String last_name, @RequestParam String email) {
        userService.update(id, name, last_name, email);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}