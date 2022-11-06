package com.michalszekalski.bootcamp_zad_20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final UserRepo userRepo;

    public MainController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @ResponseBody
    @RequestMapping("/users")
    public String users() {

        String users = "";
        for (User user : userRepo.getAll()) {
            users += user.getFirstName() + " " + user.getLastName() + " " + user.getAge() + "<br/>";
        }

        return users;
    }

    @GetMapping("/add")
    public String addUsingGet(@RequestParam(name = "imie", required = false, defaultValue = "") String firstName,
                              @RequestParam(name = "nazwisko", required = false, defaultValue = "") String lastName,
                              @RequestParam(name = "wiek", required = false, defaultValue = "") Integer age) {

        if (firstName.equals("") || lastName.equals("") || age == null) {
            return "err.html";
        } else {
            User user = new User(firstName, lastName, age);
            userRepo.getAll().add(user);
            return "success.html";
        }
    }

    @PostMapping("/add")
    public String addUsingPost(@RequestParam(name = "imie", required = false, defaultValue = "") String firstName,
                               @RequestParam(name = "nazwisko", required = false, defaultValue = "") String lastName,
                               @RequestParam(name = "wiek", required = false, defaultValue = "") Integer age) {

        if (firstName.equals("") || lastName.equals("") || age == null) {
            return "redirect:/err.html";
        } else {
            User user = new User(firstName, lastName, age);
            userRepo.getAll().add(user);
            return "redirect:/success.html";
        }
    }
}
