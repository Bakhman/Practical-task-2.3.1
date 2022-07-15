package com.bakh.practice.controller;

import com.bakh.practice.model.User;
import com.bakh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, User user) {
        userService.editUser(user);
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.editUser(user);
        return  modelAndView;
    }

    @GetMapping("/add")
    public String pageForAdd(User user) {
        return "pageForAddUser";
    }

    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.add(user);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

}
