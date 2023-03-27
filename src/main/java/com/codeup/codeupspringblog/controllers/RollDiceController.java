package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rolldice")
public class RollDiceController {

    @GetMapping
    public String getRollDicePage() {
        return "rolldice";
    }

    @GetMapping("/{userGuess}")
    public String rollDice(@PathVariable int userGuess, Model model) {
        int actualGuess = (int)Math.floor(Math.random() * 6 + 1);
        model.addAttribute("userGuess", userGuess);
        model.addAttribute("actualGuess", actualGuess);

        if(userGuess == actualGuess) {
            // correct
            model.addAttribute("answerStatus", true);
        } else {
            // incorrect
            model.addAttribute("answerStatus", false);
        }
        return "rolldice";
    }
}
