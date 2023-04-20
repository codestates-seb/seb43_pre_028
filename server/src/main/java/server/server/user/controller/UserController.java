package server.server.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.dto.SingleResponseDto;
import server.server.user.dto.UserPostDto;
import server.server.user.entity.User;
import server.server.user.mapper.UserMapper;
import server.server.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@Validated
@Slf4j
public class UserController {

    private UserService userService;
    private UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    //회원가입
    @PostMapping("/sign-up")
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userDto) {
        User user = mapper.userPostDtoToUser(userDto);//id,pass 유효성검증 뒤, 전달
        User createdUser = userService.createUser(user);//이미 있는 이메일인지 확인 뒤, 데이터베이스에 저장
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.userToUserResponseDto(createdUser)), HttpStatus.CREATED);
    }
    //회원의 정보를 전달
    @GetMapping("/user")
    public ResponseEntity getUser(){
        User user =  userService.getLoginUser();
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.userToUserResponseDto(user)), HttpStatus.OK);
    }

}
