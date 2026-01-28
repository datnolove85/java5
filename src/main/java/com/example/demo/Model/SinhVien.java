package com.example.demo.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SinhVien {
    @NotBlank(message = "Khoong được để trống!")
    @Email(message ="Không đúng định dạng email!")
    private String id;
    @NotBlank(message = "Khoong được để trống!")
    private String fullName;

    @NotNull(message = "Chuaw chọn giới tính")
    private Boolean gender;


    private String birthday;

    private String photo;
    @Range(min = 0, max = 10, message = "Từ 0-10")
    private Double mark;
}
