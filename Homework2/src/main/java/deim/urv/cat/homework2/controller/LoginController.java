/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.User;
import deim.urv.cat.homework2.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


//@Named
@RequestScoped
@Controller
@Path("Login")
public class LoginController {

    @Inject
    private UserService userService;
    @Inject
    private Models models;
    @Inject UserForm userForm;

    // Otros métodos y lógica de autenticación...
    // LoginController.java
    // Después de verificar las credenciales y autenticar al usuario con éxito
    //return "redirect:/Main?userName=" + userName;
    
    @GET
    @View("loginForm.jsp")
    public void showLogin() {
        
    }
    
    @POST
    public String login() {
        if (userForm.isValid()) {
            // Lógica de autenticación
            boolean isValidUser = userService.isValidUser(userForm.getUserName(), userForm.getPassword());

            if (isValidUser) {
                // Autenticación exitosa, realiza las acciones necesarias (por ejemplo, establecer la sesión)
                return "redirect:Main?userName=" + userForm.getUserName();
            } else {
                // Usuario no válido, puedes manejarlo de la manera que desees (mostrar mensaje de error, etc.)
                models.put("error", "Usuario o contraseña incorrectos");
                return "login.jsp";
            }
        }

        // Si el formulario no es válido, puedes manejarlo de acuerdo a tus necesidades
        return null; // O tal vez redirigir a la misma página con un mensaje de error
    }
}

