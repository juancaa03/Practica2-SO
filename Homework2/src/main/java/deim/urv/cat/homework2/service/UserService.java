package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.model.User;
import deim.urv.cat.homework2.controller.UserForm;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;

public class UserService implements Serializable{
    
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/webresources/rest/api/v1/usuari";
    
    public UserService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
                //.path("usuari");
    }
    
    
    public User findUserByName(String name){
        Response response = webTarget/*.path(name)*/
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(User.class);
        }else {
            System.out.println("Error al buscar usuario por nombre. Código de estado: " + response.getStatus());
            System.out.println("Respuesta del servidor: " + response.readEntity(String.class));
        }
        return null;
    }

    public boolean addUser(UserForm user) {
       Response response = webTarget.request(MediaType.APPLICATION_JSON)
               .post(Entity.entity(user, MediaType.APPLICATION_JSON), 
                    Response.class);
     return response.getStatus() == 201;
    }
}
