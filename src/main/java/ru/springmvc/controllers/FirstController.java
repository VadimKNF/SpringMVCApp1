package ru.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        String message = "Hello, " + name + " " + surname;

        model.addAttribute("message", message);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        List<String> actions = new ArrayList<>();
        actions.add(0, "multiplication");
        actions.add(1, "addition");
        actions.add(2, "subtraction");
        actions.add(3, "division");
        double result;

        if (action.equals(actions.get(0))) {
            result = a * b;
        } else if (action.equals(actions.get(1))) {
            result = a + b;
        } else if (action.equals(actions.get(2))) {
            result = a - b;
        } else if (action.equals(actions.get(3))) {
            result = a / (double) b;
        } else {
            result = 0;
        }

        String message = "result = " + result;
        model.addAttribute("message", message);

        return "first/calculator";
    }

}
