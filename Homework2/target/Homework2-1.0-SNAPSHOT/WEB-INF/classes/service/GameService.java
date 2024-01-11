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
import java.util.List;



public class GameService {
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/UserService/rest/api/v1/videojoc";
    
    public GameService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("game");
    }
    
    public List<Game> getAllGames() {
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(new GenericType<List<Game>>() {});
            }
            // Handle other status codes if needed
        } finally {
            client.close();
        }
        return null;
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
