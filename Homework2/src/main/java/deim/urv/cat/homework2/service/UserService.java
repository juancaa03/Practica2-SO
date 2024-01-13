package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.model.User;
import deim.urv.cat.homework2.controller.UserForm;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserService implements Serializable{
    
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/webresources/rest/api/v1/usuari";
    
    private User loggedInUser;
    
    public UserService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
                //.path("usuari");
    }
    
    public User findUserByNameInList(String name) {
    // Obtener la lista completa de usuarios
        List<User> userList = getAllUsers();

        // Filtrar la lista por el nombre de usuario
        Optional<User> userOptional = userList.stream()
            .filter(user -> user.getNomUsuari().equals(name))
            .findFirst();

        // Devolver el usuario si se encuentra, o null si no
        return userOptional.orElse(null);
    }
    
    private List<User> getAllUsers() {

    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
        return response.readEntity(new GenericType<List<User>>() {});
    }

    // Handle other status codes if needed
    return Collections.emptyList();
}
    
    /*public User findUserByEmail(String email){
        Response response = webTarget.path(email)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(User.class);
        }else {
            System.out.println("ERROR ->"+response.getStatus());
            System.out.println("SERVER RESPONSE"+response.readEntity(String.class));
        }
        return null;
    }
    
    public User findUserByName(String name){
        Response response = webTarget.path(name)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            return response.readEntity(User.class);
        }else {
            System.out.println("Error al buscar usuario por nombre. Código de estado: " + response.getStatus());
            System.out.println("Respuesta del servidor: " + response.readEntity(String.class));
        }
        return null;
    }*/

    public boolean addUser(UserForm user) {
       Response response = webTarget.request(MediaType.APPLICATION_JSON)
               .post(Entity.entity(user, MediaType.APPLICATION_JSON), 
                    Response.class);
       if(response.getStatus() == 201){
           loggedInUser = response.readEntity(User.class);
           return true;
       }
       return false;
    }
    
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
