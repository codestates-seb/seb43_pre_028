package server.server.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import server.server.dto.SingleResponseDto;
import server.server.user.dto.UserPatchDto;
import server.server.user.dto.UserPostDto;
import server.server.user.entity.User;
import server.server.user.mapper.UserMapper;
import server.server.user.repository.UserRepository;
import server.server.user.service.UserService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Validated
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    private UserService userService;
    private UserMapper mapper;

    public UserController(UserRepository userRepository,UserService userService, UserMapper mapper) {
        this.userRepository = userRepository;
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
        //User findUser=userService.findVerifiedUser(1);
        //return new ResponseEntity<>(new SingleResponseDto<>(mapper.userToUserResponseDto(findUser)), HttpStatus.OK);
    }

    //회원정보수정
    @PatchMapping("/user/patch")
    public ResponseEntity patchUser(@Valid @RequestBody UserPatchDto userDto){
        User user = userService.findVerifiedUser(1);
        //User user =  userService.getLoginUser();
        User user2 = mapper.userPatchDtoToUser(user, userDto);
        User patchUser = userService.patchUser(user2);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.userToUserResponseDto(patchUser)), HttpStatus.OK);
    }
}
