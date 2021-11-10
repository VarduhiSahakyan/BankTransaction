package com.spring.bank.service;

import com.spring.bank.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto getById(long id);

    static Integer save(UserDto userDto) {
        return userDto.getId();
    }

    void delete(UserDto userDto);

    void update(UserDto userDto);

    void delete(Integer id);

    UserDto getUserByUsername(String username);

}
