package com.spring.bank.service.implementation;

import com.spring.bank.dto.UserDto;
import com.spring.bank.entity.User;
import com.spring.bank.mapper.UserMapper;
import com.spring.bank.repository.UserRepository;
import com.spring.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getById(int id) {
        User user = userRepository.findByid(id);
        return UserMapper.mapToDto(user);
    }

    @Override
    public Integer createUser(UserDto userDto) {
        String encodedString = Base64.getEncoder().encodeToString(UserMapper.
                mapToEntity(userDto).getPassword().getBytes());
        UserMapper.mapToEntity(userDto).setPassword(encodedString);
        LocalDateTime localDateTime = LocalDateTime.now();
        if (userDto.getCreatedAt() == null) {
            userDto.setCreatedAt(localDateTime);
        }
        return userRepository.save(UserMapper.mapToEntity(userDto)).getId();
    }

    @Override
    public void delete(UserDto userDto) {
        userRepository.delete(UserMapper.mapToEntity(userDto));
    }

    @Override
    public void update(UserDto userDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (userDto.getCreatedAt() == null) {
            userDto.setCreatedAt(localDateTime);
        }
        userRepository.save(UserMapper.mapToEntity(userDto));
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
