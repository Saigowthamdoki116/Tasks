package com.example.taskproject.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password ",nullable = false)
    private String password;


}
