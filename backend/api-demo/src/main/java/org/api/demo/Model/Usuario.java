package org.api.demo.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;
    private String email;
    private String password;

    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public Integer getId(){
        return id;
    }
    
}
