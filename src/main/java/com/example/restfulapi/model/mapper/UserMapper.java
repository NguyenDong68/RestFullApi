package com.example.restfulapi.model.mapper;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.request.CreateUserRequest;

public class UserMapper { // chứa các hàm convert dữ liệu từ User sang UserDto. Mục đích là để tái sử dụng code
    public static UserDto toUserDto(User user){
        UserDto tmp =  new UserDto(); //tạo đối tượng UserDto mới và gán các thuộc tính tương ứng, sau đó trả về
        tmp.setId(user.getId()); // gán thuôc tính id,name,email,avatar,phone của đối tượng user cho đối tượng Userdto mới
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setAvatar(user.getAvatar());
        tmp.setPhone(user.getPhone());

         return tmp;
    }

    public static User toUser(CreateUserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());

        return user;
    }
}
