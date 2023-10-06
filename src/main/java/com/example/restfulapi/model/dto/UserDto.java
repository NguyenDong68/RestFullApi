package com.example.restfulapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto { // Dto định nghĩa cấu trúc cho response trả về, chứa toàn bộ trường thông tin trừ trường thông tin password
    private int id;
    private String name;
    private String email;
    private String avatar;
    private String phone;
}
