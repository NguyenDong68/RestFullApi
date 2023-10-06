package com.example.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter //trả về giá trị của thuộc tính
@Setter //lấy một tham số và gán nó cho thuộc tính.
@AllArgsConstructor // Hàm khởi tạo chứa tất cả thuộc tính
@NoArgsConstructor // Hàm khởi tạo rỗng
public class User {
    private int id;
    private String name;
    private String email;
    private String avatar;
    private String phone;
    private String password;
}
