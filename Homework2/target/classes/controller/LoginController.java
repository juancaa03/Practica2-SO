/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.Game;
import deim.urv.cat.homework2.model.User;
import deim.urv.cat.homework2.service.GameService;
import deim.urv.cat.homework2.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.mvc.View;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import java.net.URI;


//@Named
@RequestScoped  
@Controller
@Path("Login")
public class LoginController {

    @Inject
    private UserService userService;
    @Inject
    private Models models;
    
    @Inject
    UserForm userForm;
    
    @Inject
    GameService gameService;
    
    @QueryParam("gameId")
    Long gameId;
    
    @Context
    private HttpServletRequest httpRequest;

    // Otros métodos y lógica de autenticación...
    // LoginController.java
    // Después de verificar las credenciales y autenticar al usuario con éxito
    //return "redirect:/Main?userName=" + userName;
    
    @GET
    @View("loginForm.jsp")
    public void showLogin() {
        Game game = gameService.getGameById(gameId);
        models.put("game", game);
    }
    
    @POST
    @UriRef("authenticate")
    public String authenticate(@Valid @BeanParam UserForm userForm, @FormParam("gameId") Long gameId) {
        if (!userForm.isValid()) {
            // Si el formulario no es válido, vuelve a la página de inicio de sesión con un mensaje de error
            models.put("error", "Invalid form data");
            return "loginForm.jsp";
        }

        // Verifica las credenciales del usuario utilizando tu lógica de autenticación
        boolean isValidCredentials = userService.isValidUser(userForm.getUserName(), userForm.getPassword());

        if (isValidCredentials) {
            // Autenticación exitosa
            //return Response.seeOther(URI.create("/Main?userName=" + userForm.getUserName())).build();
            //URI location = UriInfo.getBaseUriBuilder().path("/Main").queryParam("userName", userForm.getUserName()).build();
            //return Response.seeOther(location).build();
            //return "redirect:/Main?userName=" + userForm.getUserName();
            String userName = userForm.getUserName();
            System.out.println("USERNAMEONLOGIN111: "+userName);
            System.out.println("GAMEID|ONLOGIN111: "+gameId);
            models.put("userName", userName);
            System.out.println("USERNAMEONLOGIN222: "+userName);
            System.out.println("GAMEID|ONLOGIN222: "+gameId);
            // Determinar si el usuario proviene de gameDetail
            if (gameId != null) {
                // Redirigir al usuario de vuelta a gameDetail
                return "redirect:/gameDetail?id=" + gameId+ "&userName=" + userName;
            } else {
                // Redirigir al usuario al Main
                return "redirect:/Main?userName=" + userName;
            }
        } else {
            // Autenticación fallida, vuelve a la página de inicio de sesión con un mensaje de error
            models.put("error", "Invalid username or password");
            return "loginForm.jsp";
        }
    }
    
    private boolean userCameFromGameDetail() {
        // Verificar si la URL de referencia contiene "gameDetail"
        String referer = httpRequest.getHeader("Referer");
        return referer != null && referer.contains("/gameDetail");
    }
    /*@POST
    public String login(@FormParam("loginButton") String loginButton) {
        if("Login".equals(loginButton)) {
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
        }
        // Si el formulario no es válido, puedes manejarlo de acuerdo a tus necesidades
        return null; // O tal vez redirigir a la misma página con un mensaje de error
    }*/
}

