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
import java.util.Collections;
import java.util.List;



public class GameService {
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/webresources/rest/api/v1";
    
    public GameService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("videojoc");
    }
    
    public List<Game> getAllGames() {
        try {
        System.out.println("--ANTES DE LA LLAMADA A LA API--");
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        System.out.println("--DESPUES DE LA LLAMADA A LA API--");

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(new GenericType<List<Game>>() {});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Collections.emptyList();
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
}
