package com.example.dockerTest.Controller;

import com.example.dockerTest.DTO.CommonResponse;
import com.example.dockerTest.DTO.UserRequest;
import com.example.dockerTest.DTO.UserResponse;
import com.example.dockerTest.Entity.User;
import com.example.dockerTest.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){

        UserResponse userResponse =  userService.addUser(userRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<UserResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Sukses")
                        .data(userResponse)
                        .build()
                );
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(){

        List<UserResponse> userResponse = userService.findAllUser();

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<List<UserResponse>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Sukses Find All Data User bos . Baru di Upgrade ni")
                        .data(userResponse)
                        .build()
                );
    }

}
