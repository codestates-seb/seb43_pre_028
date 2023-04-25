package server.server.user.mapper;


import org.mapstruct.Mapper;
import server.server.user.dto.UserPatchDto;
import server.server.user.dto.UserPostDto;
import server.server.user.dto.UserResponseDto;
import server.server.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default User userPostDtoToUser(UserPostDto userPostDto) {
        User user = new User();

        user.setUserName(userPostDto.getUserName());
        user.setEmail(userPostDto.getEmail());
        user.setPassword(userPostDto.getPassword());

        return user;
    }

    default User userPatchDtoToUser(User user, UserPatchDto userPatchDto) {
        user.setUserName(userPatchDto.getUserName());
        user.setPassword(userPatchDto.getPassword());
        user.setImage(userPatchDto.getImage());

        return user;
    }

    default UserResponseDto userToUserResponseDto(User user) {

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUserName(user.getUserName());
        userResponseDto.setImage(user.getImage());
        userResponseDto.setUserStatus(user.getUserStatus());

        return userResponseDto;
    }

}