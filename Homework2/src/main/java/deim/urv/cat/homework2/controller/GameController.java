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
import jakarta.mvc.View;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Controller
@Path("gameDetail")
public class GameController {
    
    @Inject
    private GameService gameService;
    
    @Inject
    private UserService userService;

    @Inject
    private Models models;

    @QueryParam("id")
    private Long gameId;

    @QueryParam("addedToCart")
    private boolean addedToCart;
    
    @QueryParam("userName")
    private String userName;
    
    @GET
    @View("gameDetail.jsp")
    public void showGameDetail() {
        Game game = gameService.getGameById(gameId);
        models.put("game", game);
        models.put("addedToCart", addedToCart);
        models.put("userName", userName);
        
        //System.out.println("DATOS VIDEOJUEGO: nom: "+game.getNom()+" tipus: "+game.getTipus()+" desc: "+game.getDescripcio());
    }
    
    @POST
    @UriRef("addToCart")
    public String addToCart(@FormParam("gameId") Long gameId, @FormParam("userName") String userName) {
        System.out.println("GAMEID|ADDTOCART: " + gameId);
        System.out.println("USERNAMEADDTOCART!: "+ userName);
        if (userName == null || userName.isEmpty()) {
            // Si el usuario no ha iniciado sesión, redirigir a la página de inicio de sesión con información adicional
            
            return "redirect:/Login?gameId=" + gameId;
        } else {
            // Usuario ya ha iniciado sesión, realizar la lógica de agregar al carrito
            // Puedes agregar aquí tu lógica actual para agregar al carrito
            return "redirect:/gameDetail?id=" + gameId + "&addedToCart=true";
        }
        //return "redirect:/gameDetail?id=" + gameId + "&addedToCart=true";//&userName=" + userName
    }
}
