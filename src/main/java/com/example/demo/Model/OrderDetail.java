package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "OrderDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotNull(message = "OrderId không được để trống")
    @Column(name = "OrderId")
    private Long orderId;

    @NotNull(message = "ProductId không được để trống")
    @Column(name = "ProductId")
    private Integer productId;

    @NotNull(message = "Price không được để trống")
    @Column(name = "Price")
    private Double price;

    @NotNull(message = "Quantity không được để trống")
    @Column(name = "Quantity")
    private Integer quantity;
}
