package kz.baiturinov.callboard.controllers;

import kz.baiturinov.callboard.models.Person;
import kz.baiturinov.callboard.services.RegistrationService;
import kz.baiturinov.callboard.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserController {
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public UserController(PersonValidator personValidator,
                          RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String regUser(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }
        registrationService.register(person);
        return "redirect:/auth/login";
    }
}
