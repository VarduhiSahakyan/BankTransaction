package com.spring.bank.service;

import com.spring.bank.dto.UserDto;

public interface UserService {
    UserDto getById(int id);

    Integer createUser(UserDto userDto) ;

    void delete(UserDto userDto);

    void update(UserDto userDto);

    void deleteById(Integer id);

    UserDto getUserByUsername(String username);

}
