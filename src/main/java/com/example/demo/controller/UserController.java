package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;
    private final EmailSenderService emailSenderService;

    private User user = new User();

    public UserController(UserService userService, EmailSenderService emailSenderService) {
        this.userService = userService;
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/user")
    public String addPage() {
        return "user";
    }


    @GetMapping("/confirmation")
    public String getConfirm(@RequestParam("email") String email,
                             @RequestParam("retype_email") String retype_email) {
        user.setEmail(email);
        Random random = new Random();
        String randomCode = String.valueOf(random.nextInt(1000, 2000));
        if (userService.getAllByEmail(email).size() > 0) {
            user.setEmail(email);
            userService.updateStatus("ERROR", userService.getId(email));//not unique email
            userService.updateDescription("Trying to add an existing email address", userService.getId(email));
            return "suchEx";
        }
        if (email.equals(retype_email)
                && email != null
                && retype_email != null) {
            emailSenderService.sendEmail(email, "Comfirm email", "Good day!\n\n"
                    + "Someone is trying to register your email address in our system. \n"
                    + "If this is you - please enter the activation code - " + randomCode
                    + "\nIf this is not you, please do not reply to this email.\n\n"
                    + "Have a good day! 😉");
            user.setActivationCode(randomCode);
            user.setStatus("CONFIRMATION");
            user.setDescription("Email with activation code sent");
            userService.addUser(user);
            return "confirmation_page";
        }
        return "bad_way";
    }

    @GetMapping("/confirmed")
    public String confirmed(@RequestParam("code") String code,
                            @RequestParam("email") String email) {
        if (code.equals(userService.getActivationCode(email))) {
            emailSenderService.sendEmail(email, "GREETINGS!", "Hello!\n\n" +
                    "Your email registered successful!\n\n" +
                    "Best regards!");
            userService.updateStatus("CONFIRMED", userService.getId(email));
            userService.updateDescription("Email sent, activation code put", userService.getId(email));
            return "good_way";
        }
        userService.updateStatus("ERROR", userService.getId(email));//activation code not match
        userService.updateDescription("Activation code entered incorrectly", userService.getId(email));
        return "bad_code";
    }
}
