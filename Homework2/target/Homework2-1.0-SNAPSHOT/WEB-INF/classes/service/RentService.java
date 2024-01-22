/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.service;

import deim.urv.cat.homework2.controller.UserForm;
import deim.urv.cat.homework2.model.LloguerRequest;
import deim.urv.cat.homework2.model.RebutLloguer;
import deim.urv.cat.homework2.model.Rental;
import deim.urv.cat.homework2.model.User;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


public class RentService {
    private final WebTarget webTarget;
    private final jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/webresources/rest/api/v1";
    
    public RentService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("lloguer");
    }
    
    public Rental getRentById(Long id) {
        try {
            Response response = webTarget.path(String.valueOf(id))
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(Rental.class);
            }
            // Handle other status codes if needed
        } finally {
            client.close();
        }
        return null;
    }

    public List<Rental> getAllRents() {
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(new GenericType<List<Rental>>() {});
            }
            // Handle other status codes if needed
        } finally {
            client.close();
        }
        return null;
    }
    
    public RebutLloguer rentVideojocs(LloguerRequest lloguerRequest) {
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(lloguerRequest, MediaType.APPLICATION_JSON));

            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                // Si la respuesta es exitosa (código 201 CREATED), lee y devuelve el cuerpo en formato JSON
                return response.readEntity(RebutLloguer.class);
            } else {
                // Si la respuesta es diferente de 201, maneja el error según tus necesidades
                // Puedes lanzar una excepción, loggear un mensaje, etc.
                System.out.println("Error en la respuesta: " + response.getStatusInfo().getReasonPhrase());
                System.out.println("Cuerpo de la respuesta: " + response.readEntity(String.class));
                return null; // O lanza una excepción si prefieres
            }
        }catch (Exception e) {
            // Manejar la excepción y devolver el código de error correspondiente
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }
    //public User findUserByEmail(String email){
    //    Response response = webTarget.path(email)
    //            .request(MediaType.APPLICATION_JSON)
    //            .get();
    //    if (response.getStatus() == 200) {
    //        return response.readEntity(User.class);
    //    }
    //    return null;
    //}


    //public boolean addUser(UserForm user) {
    //   Response response = webTarget.request(MediaType.APPLICATION_JSON)
    //           .post(Entity.entity(user, MediaType.APPLICATION_JSON), 
    //                Response.class);
    // return response.getStatus() == 201;
    //}
}
