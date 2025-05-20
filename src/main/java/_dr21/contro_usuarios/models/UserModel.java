package _dr21.contro_usuarios.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public class UserModel {

    private Long id;

    @NotBlank(message = "Ingrese su nombre")
    private String name;
    @NotBlank(message = "Ingrese un nombre de usuario")
    private String username;
    @NotBlank(message ="{user.password.notblank}")
    @Size(min=5, max = 8)
    private String password;

    private String role;

    public UserModel() {
    }

    public UserModel(Long id, String name, String username, String role, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.role= role;
        this.password= password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
