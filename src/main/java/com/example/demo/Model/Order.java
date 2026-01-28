package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotBlank(message = "Username không được để trống")
    @Column(name = "Username")
    private String username;

    @NotNull(message = "Ngày tạo không được để trống")
    @Column(name = "CreateDate")
    private Date createDate;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Column(name = "Address")
    private String address;
}
