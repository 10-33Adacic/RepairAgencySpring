package com.training.RepairAgency.controller;

import com.training.RepairAgency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    //TODO: Delete this if everything works ok
//    private UserService userService;

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("login", logout != null);
        model.addAttribute("error", error != null);
        return "login.html";
    }
}
