/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.controller;

import deim.urv.cat.homework2.model.Game;
import deim.urv.cat.homework2.model.LloguerRequest;
import deim.urv.cat.homework2.model.RebutLloguer;
import deim.urv.cat.homework2.model.User;
import deim.urv.cat.homework2.service.GameService;
import deim.urv.cat.homework2.service.RentService;
import deim.urv.cat.homework2.service.UserService;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.UriRef;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Controller
@Path("Rent")
public class RentController {
    
    @Inject GameService gameService;
    @Inject UserService userService;
    @Inject Models models;
    
    /*@QueryParam("id")
    private Long gameId;
    
    @QueryParam("userName")
    private String userName;*/
    
    @GET
    public String showConfirmation(@QueryParam("gameId") Long gameId, @QueryParam("userName") String userName) {
        Game game = gameService.getGameById(gameId);
        models.put("game", game);
        
        models.put("userName", userName);
        
        models.put("buyConfirmed", false);
        System.out.println("USERNAMEONRENT: "+userName);
        System.out.println("GAMEONRENT: "+gameId);
        return "rentConfirmation.jsp";
    }
    
    @POST
    @UriRef("rent")
    public String rent(@FormParam("gameId") Long gameId, @FormParam("userName") String userName) {
        Game game = gameService.getGameById(gameId);
        
        // Lógica para realizar la renta del juego
        // Puedes agregar código aquí para gestionar la renta, por ejemplo, utilizando el servicio RentService
        LloguerRequest lloguerRequest = new LloguerRequest();
        //new Game(game.getId(), game.getNom(), game.getVideoconsola(), game.isDisponibilitat(), game.getPreuLloguer(), game.getDescripcio(), game.getTipus(), game.getAdrecaBotigues())
        System.out.println("USERNAMEONRENT222: "+userName);
        System.out.println("GAMEONRENT222: "+gameId);
        User user = userService.findUserByNameInList(userName);
        
        lloguerRequest.setGame(game);
        lloguerRequest.setUser(user);
        
        // Llamar al servicio RentService para realizar la renta
        RentService rentService = new RentService();
        Response response = rentService.rentVideojocs(lloguerRequest);
        System.out.println("RESPONSEEE: "+response);
        // Verificar si la renta fue exitosa (puedes ajustar esto según la estructura de tu respuesta)
        if (response != null && response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            // Si la renta es exitosa, redirigir a la página de confirmación
            RebutLloguer rebutLloguer = response.readEntity(RebutLloguer.class);

            // Poner los detalles de la renta en el modelo
            models.put("rebutLloguer", rebutLloguer);
            models.put("buyConfirmed", true);
            return "redirect:/rentConfirmation.jsp";
        } else {
            // Si hay algún problema, puedes redirigir a una página de error o manejarlo de alguna otra manera
            return "redirect:/errorPage.jsp";
        }
    }
}
