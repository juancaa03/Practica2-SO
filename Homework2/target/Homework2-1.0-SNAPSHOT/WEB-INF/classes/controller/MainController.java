/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.*;
import deim.urv.cat.homework2.service.*;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.List;


@Controller
@Path("Main")
public class MainController {
    //CDI
    @Inject GameService gameService;
    @Inject Models models;
    @Inject UserService userService;
    
    @QueryParam("userName")
    private String userName;
            
    @GET
    public String showMain() {
        List<Game> games = gameService.getAllGames();
        models.put("games", games);
        
        boolean isLoggedIn = userName != null && !userName.isEmpty();
        
        if(isLoggedIn) {
            User usuari = userService.findUserByNameInList(userName);
            models.put("usuari", usuari);
        }
        models.put("isLoggedIn", isLoggedIn);
        return "home.jsp";
    }
}
