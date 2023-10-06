package com.example.restfulapi.Service;

import com.example.restfulapi.entity.User;
import com.example.restfulapi.exception.DuplicateRecordException;
import com.example.restfulapi.exception.NotFoundException;
import com.example.restfulapi.model.dto.UserDto;
import com.example.restfulapi.model.mapper.UserMapper;
import com.example.restfulapi.request.CreateUserRequest;
import com.example.restfulapi.request.UpdateUserRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class UserserviceImpl implements UserService{ //UserController lấy users thông qua 1 lớp interface. UserServiceImpl implement UserService và override (ghi đè) chính cái method ở trong interface đó. Nguyên tắc Dependency inversion( đảo ngược sự phụ thuộc)
    private static ArrayList<User> users = new ArrayList<User>();// Tạo mảng user động thay cho database
    static {
        users.add(new User(1,"Nguyễn Văn A","NVA@gmail.com","avatar.jpg","0101010101","123132"));
        users.add(new User(2,"Phạm Văn B","PVB@gmail.com","avatar1.jpg","100210310230","321321"));
        users.add(new User(3,"Lê Văn C","LVC@gmail.com","avatar2.jpg","0123912090","315321"));
        users.add(new User(4,"Nguyễn Thị D","NTD@gmail.com","avatar3.jpg","102312312312","221321"));
        users.add(new User(5,"Lê Văn E","LVE@gmail.com","avatar4.jpg","102312123312312","221321"));
    }
    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users){ //Duyệt mảng user để tìm kiếm thông tin user
            if (user.getId() == id){ //Tìm thấy sẽ ko trả về ngay mà convert sang obj Userdto
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User này ko tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            if(user.getName().contains(keyword)){ //method contains để tìm các user có tên chứa từ khoá
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(CreateUserRequest req) {
        // Kiểm tra xem email có tồn tại hay ko
        for (User user : users) {
            if (user.getEmail().equals(req.getEmail())){
                throw new DuplicateRecordException("User đã tồn tại");
            }
        }

        // Convert CreateUserReq -> User
        User user = UserMapper.toUser(req);
        user.setId(users.size()+1);

        // chèn vào  user
        users.add(user);

        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserRequest req) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        throw new NotFoundException("Không tìm thấy user");
    }
}
