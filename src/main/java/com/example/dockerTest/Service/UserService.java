package com.example.dockerTest.Service;

import com.example.dockerTest.DTO.UserRequest;
import com.example.dockerTest.DTO.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);
    List<UserResponse> findAllUser();
}
