package com.example.restfulapi.Controller;

import com.example.restfulapi.Service.UserService;
import com.example.restfulapi.entity.User;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.request.CreateUserRequest;
import com.example.restfulapi.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //Định nghĩa phần chung cho Url
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser(); //Usercontroller gọi sang Service lấy ra danh sách user rồi trả ra cho client
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto result = userService.getUserById(id);
        return  ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(name = "keyword",required = false, defaultValue = "") String name){
        //Request param để binding dữ liệu
        List<UserDto> users = userService.searchUser(name);
        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserRequest req){
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Validated @RequestBody UpdateUserRequest req, @PathVariable int id){
        UserDto result =  userService.updateUser(req);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Xoá thành công user");
    }
}
