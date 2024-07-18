package site.metacoding.blogv3.user;

import lombok.Data;

import java.time.LocalDateTime;

public class UserRequest {

    @Data
    public class LoginDTO{
        private String username;
        private String password;

    }

    @Data
    public class JoinDTO{
        private String username;
        private String password;
        private String passwordCheck;
        private String email;

        public User toEntity(){
            return User.builder()
                    .username(this.username)
                    .password(this.password)
                    .email(this.email)
                    .build();
        }
    }
}
