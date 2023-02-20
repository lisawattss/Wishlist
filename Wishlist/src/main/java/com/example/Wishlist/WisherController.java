package com.example.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WisherController {

    @Autowired
    private WisherRepo wisherRepo;

    // Start
    @GetMapping("/uwish")
    public String start() {
        return "start";
    }

    // Sign Up - not connected to database yet, doesn't work
    @GetMapping("/uwish/signup")
    public String signup(Model model) {
        model.addAttribute("wisher", new Wisher());
        return "signup";
    }
    @PostMapping("/uwish/savewisher")
    public String saveWisher(@ModelAttribute Wisher wisher) {
        wisherRepo.save(wisher);
        return "redirect:/uwish/wishlist";
    }

    // Login - not connected to database yet, works with hardcoded users
    @GetMapping("/uwish/login")
    public String login() {
        return "login";
    }
    @PostMapping("/uwish/login")
    public String login(HttpSession session, @RequestParam String usn, @RequestParam String psw){
        Wisher wisher = wisherRepo.getWisherByUsnAndPsw(usn,psw).get();
        return "wishlist";
    }

    // Logout
    @GetMapping("/uwish/logout")
    public String logout() {
        return "login";
    }
}