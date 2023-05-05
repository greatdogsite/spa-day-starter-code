package org.launchcode.spaday.controllers;


import org.launchcode.spaday.data.DataClass;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){

        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if (user.getPassword().equals(verify)){
            model.addAttribute("user", user.getUsername());
            DataClass.add(user);
            model.addAttribute("users", DataClass.getAll());
            return "user/index";
        }
        model.addAttribute("error", "Passwords must match");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/add";
    }

    @GetMapping("details")
    public String renderDetailsPage(Model model, @RequestParam Integer id){
        model.addAttribute("user", DataClass.getById(id));
        return "user/details";
    }
}
