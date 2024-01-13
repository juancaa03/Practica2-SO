/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deim.urv.cat.homework2.controller;

import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@Path("Main")
public class MainController {
    
    @GET
    public String showMain() {
        return "home.jsp";
    }
}
