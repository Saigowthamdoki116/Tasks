package com.example.taskproject.serviceImpl;

import com.example.taskproject.entity.Users;
import com.example.taskproject.payload.UserDto;
import com.example.taskproject.repository.UserRepository;
import com.example.taskproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users user=userDtoToEntity(userDto);
        Users savedUser=userRepository.save(user);
        return entityToUserDto(savedUser);
    }
    private Users userDtoToEntity(UserDto userDto){
        Users user=new Users();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto entityToUserDto(Users savedUser){
        UserDto userDto=new UserDto();
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPassword(savedUser.getPassword());
        return userDto;
    }
}
