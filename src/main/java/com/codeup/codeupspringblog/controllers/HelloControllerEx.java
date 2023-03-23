package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// states that this is a class
// telling spring to handle
@Controller
public class HelloControllerEx {

    // define a method that should be invoked when a request is received
    @GetMapping("/hello")

    // tell spring what to return to the body of the url
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{firstname}&{lastname}")
    @ResponseBody
    public String helloName(@PathVariable String firstname, @PathVariable String lastname) {
        return "Hello, " + firstname + " " + lastname + "!";
    }

    @GetMapping("/dice")
    @ResponseBody
    public String rollDice() {
        int diceRoll = (int) (Math.random() * 6) + 1;
        return "roll-result: " + diceRoll;
    }
}
