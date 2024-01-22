/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.controller.UserForm;
import deim.urv.cat.homework2.model.Game;
import deim.urv.cat.homework2.model.User;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



public class GameService {
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/webresources/rest/api/v1";
    
    //private Game shoppingCartItem;
    
    public GameService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("videojoc");
    }
    
    public List<Game> getAllGames() {
        try {
        System.out.println("--ANTES DE LA LLAMADA A LA API--");
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        System.out.println("--DESPUES DE LA LLAMADA A LA API--"+response);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(new GenericType<List<Game>>() {});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Collections.emptyList();
    }
    
    public List<Game> filtrarVideojuegos(String accion, String aventura, String deporte, String gameBoy, String pc, String ps5) {
        
        List<Game> games = getAllGames();  // Deberías tener un método que obtenga todos los juegos
        List<Game> gamesFiltrados = new ArrayList<>();
        
        // Si no hay filtros, devolver la lista completa de juegos
        if (accion == null && aventura == null && deporte == null && gameBoy == null && pc == null && ps5 == null) {
            return games;
        }
        
        for(Game game : games){
            
            boolean tipoCoincide = (accion != null && accion.equals(game.getTipus())) ||
                               (aventura != null && aventura.equals(game.getTipus())) ||
                               (deporte != null && deporte.equals(game.getTipus()));

            // Verificar si la consola del juego coincide con alguno de los filtros seleccionados
            boolean consolaCoincide = (gameBoy != null && gameBoy.equals(game.getVideoconsola())) ||
                                  (pc != null && pc.equals(game.getVideoconsola())) ||
                                  (ps5 != null && ps5.equals(game.getVideoconsola()));

            // Si coincide con los criterios de filtro, agregarlo a la lista de juegos filtrados
            if (tipoCoincide || consolaCoincide) {
                gamesFiltrados.add(game);
            }
            //if ((accion != null && accion.equals(game.getTipus())) ||
            //(aventura != null && aventura.equals(game.getTipus())) ||
            //(deporte != null && deporte.equals(game.getTipus()))) {
            
            // Verificar si la consola del juego coincide con alguno de los filtros seleccionados
            //if ((gameBoy != null && gameBoy.equals(game.getVideoconsola())) ||
            //    (pc != null && pc.equals(game.getVideoconsola())) ||
            //    (ps5 != null && ps5.equals(game.getVideoconsola()))) {
                
                // Si coincide con los criterios de filtro, agregarlo a la lista de juegos filtrados
            //    gamesFiltrados.add(game);
            //}
        }
        
        
        return gamesFiltrados;
    }

    
    public Game getGameById(Long id) {
    // Obtener la lista completa de games
        List<Game> gamesList = getAllGames();

        // Filtrar la lista por el nombre de game
        Optional<Game> gameOptional = gamesList.stream()
            .filter(game -> game.getId().equals(id))
            .findFirst();

        // Devolver el game si se encuentra, o null si no
        return gameOptional.orElse(null);
    }

    public boolean addGame(Game game) {
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(game, MediaType.APPLICATION_JSON));

            return response.getStatus() == Response.Status.CREATED.getStatusCode();
            // Handle other status codes if needed
        } finally {
            client.close();
        }
    }
    
    /*public void addToCart(Game game) {
        shoppingCartItem = game;
    }

    public Game getShoppingCartItem() {
        return shoppingCartItem;
    }

    public void clearShoppingCart() {
        shoppingCartItem = null;
    }*/
}
