package com.example.StudentApp.entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username is required")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Password is required")
    private String username;
    @Column(nullable = false)
    private String password;
    @NotBlank(message = "Role is required")
    @Column(nullable = false)
    private String role;
}
