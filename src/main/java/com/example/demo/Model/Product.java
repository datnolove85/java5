package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Column(name = "Name")
    private String name;

    @NotBlank(message = "Ảnh không được để trống")
    @Column(name = "Image")
    private String image;

    @NotNull(message = "Giá không được để trống")
    @Column(name = "Price")
    private Double price;

    @NotNull(message = "Ngày tạo không được để trống")
    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate")
    private Date createDate;

    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "Available")
    private Boolean available;

    @NotBlank(message = "Category không được để trống")
    @Column(name = "CategoryId")
    private String categoryId;
}
