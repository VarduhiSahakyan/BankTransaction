package com.spring.bank.service.implementation;

import com.spring.bank.dto.UserDto;
import com.spring.bank.entity.User;
import com.spring.bank.mapper.UserMapper;
import com.spring.bank.repository.UserRepository;
import com.spring.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.acl.Owner;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getById(int id) {
        User user = userRepository.getById(id);
        return UserMapper.mapToDto(user);
    }

    @Override
    public Integer createUser(UserDto userDto) {
        return userRepository.save(UserMapper.mapToEntity(userDto)).getId();
    }



    @Override
    public void delete(UserDto userDto) {
        User user = UserMapper.mapToEntity(userDto);
        userRepository.delete(user);
    }

    @Override
    public void update(UserDto userDto) {
        User user = UserMapper.mapToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
       User user = userRepository.getById(id);
       userRepository.delete(user);

    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return UserMapper.mapToDto(user);
    }
}
