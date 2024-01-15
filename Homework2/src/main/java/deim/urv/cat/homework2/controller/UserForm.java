package deim.urv.cat.homework2.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.mvc.binding.MvcBinding;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.FormParam;
import java.io.Serializable;

@Named("userForm")
@RequestScoped
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
        
    // JSR 303 validation
    @NotBlank
    @FormParam("userName")
    @MvcBinding
    @Size(min=2, max=30, message = "First name must be between 2 and 30 characters")
    private String userName;
    
    // JSR 303 validation
    @NotBlank
    @FormParam("password")
    @MvcBinding
    @Size(min=2, max=30, message = "Last name must be between 2 and 30 characters")
    private String password;

    @NotBlank
    @FormParam("email")
    @Email(message = "Email should be valid")
    @MvcBinding
    private String email;
    
    public String getUserName() {
        return fixNull(this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return fixNull(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return fixNull(this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String fixNull(String in) {
        return (in == null) ? "" : in;
    }
    
    public boolean isValid() {
        return userName != null && !userName.isEmpty() && password != null && !password.isEmpty();
    }
}
