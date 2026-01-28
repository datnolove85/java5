package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @NotBlank(message = "Username không được để trống")
    @Column(name = "Username")
    private String username;

    @NotBlank(message = "Password không được để trống")
    @Column(name = "Password")
    private String password;

    @NotBlank(message = "Họ tên không được để trống")
    @Column(name = "Fullname")
    private String fullname;

    @NotBlank(message = "Email không được để trống")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Photo không được để trống")
    @Column(name = "Photo")
    private String photo;

    @NotNull(message = "Activated không được để trống")
    @Column(name = "Activated")
    private Boolean activated;

    @NotNull(message = "Admin không được để trống")
    @Column(name = "Admin")
    private Boolean admin;
}
