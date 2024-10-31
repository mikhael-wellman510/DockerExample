package com.example.dockerTest.Service;

import com.example.dockerTest.DTO.UserRequest;
import com.example.dockerTest.DTO.UserResponse;
import com.example.dockerTest.Entity.User;
import com.example.dockerTest.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {

        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .build();

        User saveUser = userRepository.save(user);

        return UserResponse.builder()
                .id(saveUser.getId())
                .name(saveUser.getName())
                .age(saveUser.getAge())
                .address(saveUser.getAddress())
                .build();
    }

    @Override
    public List<UserResponse> findAllUser() {

        List<User> getAll = userRepository.findAll();


        return getAll.stream().map(val -> UserResponse.builder()
                .id(val.getId())
                .name(val.getName())
                .age(val.getAge())
                .address(val.getAddress())
                .build()).toList();
    }
}
