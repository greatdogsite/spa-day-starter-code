package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User()); // Modelbinding automatically names new object "user"
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());

        model.addAttribute("user", user);

        if (errors.hasErrors()){
            return "user/add";
        }
//        else if (user.getPassword() != verify) {
//            model.addAttribute("verifyMessage", "Your passwords must match.");
//            return "user/add";
//        }
//        if (user.getPassword().equals(user.getVerifyPassword())) {
//           return "user/index";
//        }
//        else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
        return "user/index";
    }


}
