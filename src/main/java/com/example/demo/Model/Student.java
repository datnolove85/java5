package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Không để trống mã sinh viên!")
    @Column(name = "StudentCode")
    private String studentCode;

    @NotBlank(message = "Không để trống tên sinh viên!")
    @Column(name = "FullName")
    private String fullName;

    @NotNull(message = "Chưa chọn giới tính!")
    @Column(name = "Gender")
    private String gender;

    @NotBlank(message = "Không để trống email sinh viên!")
    @Email(message = "Không đúng định dạng Email!")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Không để trống SĐT sinh viên!")
    @Column(name = "Phone")
    private String phone;

    @NotBlank(message = "Không để trống chuyên ngành sinh viên!")
    @Column(name = "Major")
    private String major;

    @NotBlank(message = "Không để trống lớp sinh viên!")
    @Column(name = "ClassName")
    private String className;
}
