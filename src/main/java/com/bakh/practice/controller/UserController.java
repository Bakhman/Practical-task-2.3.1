package com.bakh.practice.controller;

import com.bakh.practice.model.User;
import com.bakh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author Bakhmai Begaev
 */
@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "editPage";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user){
        userService.editUser(user);
        return  "redirect:/users";
    }

    @GetMapping("add")
    public String editPage(User user, Model model) {
        model.addAttribute(user);
        return "editPage";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
