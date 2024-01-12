package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.AlertMessage;
import deim.urv.cat.homework2.model.*;
import deim.urv.cat.homework2.model.SignUpAttempts;
import deim.urv.cat.homework2.service.*;
import deim.urv.cat.homework2.model.User;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.binding.BindingResult;
import jakarta.mvc.binding.ParamError;
import jakarta.mvc.security.CsrfProtected;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@Path("SignUp")
public class SignUpFormController {    
    // CDI
    @Inject BindingResult bindingResult;
    @Inject Logger log;
    @Inject UserService service;
    @Inject Models models;
    @Inject AlertMessage flashMessage;
    @Inject SignUpAttempts attempts;
    //@Inject UserService userService;
    @Inject GameService gameService;
    
    @GET
    public String showForm() {
        List<Game> games = gameService.getAllGames();
        models.put("game", games);
        System.out.println("--VIDEOGAMES NUMBER--"+games.size());
        return "signup-form.jsp"; // Injects CRSF token
    }    
    
    @POST
    @UriRef("sign-up")
    @CsrfProtected
    public String signUp(@Valid @BeanParam UserForm userForm) {
        models.put("user", userForm);
        if (bindingResult.isFailed()) {
            AlertMessage alert = AlertMessage.danger("Validation failed!");
            bindingResult.getAllErrors()
                    .stream()
                    .forEach((ParamError t) -> {
                        alert.addError(t.getParamName(), "", t.getMessage());
                    });
            log.log(Level.WARNING, "Data binding for signupFormController failed.");
            models.put("errors", alert);
            return "signup-form.jsp";
        }
        
        if(attempts.hasExceededMaxAttempts()) {
            return "signup-form.jsp";
        }
       
        User user = service.findUserByName(userForm.getEmail());
        if (user != null) {
            // Try again
            log.log(Level.WARNING, "A user with this e-mail address {0} already exists.", userForm.getEmail());
            models.put("message", "A user with this e-mail address already exists!");
            attempts.increment();
            return "signup-form.jsp";
        }
        log.log(Level.INFO, "Redirecting to the success page.");
        service.addUser(userForm);
        attempts.reset();
        return "signup-success.jsp";
    } 
}
