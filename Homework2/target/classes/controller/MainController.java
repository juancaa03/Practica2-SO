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
import jakarta.mvc.UriRef;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
    
    @POST
    @UriRef("filterGames")
    public String filterGames(@FormParam("Acción") String accion,
                          @FormParam("Aventura") String aventura,
                          @FormParam("Deporte") String deporte,
                          @FormParam("Game Boy") String gameBoy,
                          @FormParam("PC") String pc,
                          @FormParam("PS5") String ps5) {

        List<Game> filteredGames = gameService.filtrarVideojuegos(accion, aventura, deporte, gameBoy, pc, ps5);
        System.out.println("PS55555 ("+ps5+")");
        models.put("games", filteredGames);
        System.out.println("GAMES" +filteredGames);
        // También puedes mantener la lógica para el usuario actual aquí si es necesario.

        return "home.jsp";
    }
}
