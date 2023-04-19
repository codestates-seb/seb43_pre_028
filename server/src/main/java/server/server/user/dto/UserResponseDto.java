package server.server.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.server.user.entity.User;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

//    private long userId;
    private String displayName;
    private String email;
//    private String password;
    private String image;
    private User.UserStatus userStatus;

}
