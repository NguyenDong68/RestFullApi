package com.example.restfulapi.Service;

import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.request.CreateUserRequest;
import com.example.restfulapi.request.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser(); //Khai báo method lấy ra danh sách user với kiểu trả về là List UserDto

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String keyword);

    public UserDto createUser(CreateUserRequest req);

    public UserDto updateUser(UpdateUserRequest req);

    public boolean deleteUser(int id);


}
