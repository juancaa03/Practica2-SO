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
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Controller
@Path("gameDetail")
public class GameController {
    
    @Inject
    private GameService gameService;

    @Inject
    private Models models;

    @QueryParam("id")
    private Long gameId;

    @GET
    @View("gameDetail.jsp")
    public void showGameDetail() {
        Game game = gameService.getGameById(gameId);
        models.put("game", game);
    }
}
