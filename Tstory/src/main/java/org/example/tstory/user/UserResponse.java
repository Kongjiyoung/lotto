package site.metacoding.blogv3.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class LoginDTO {
        private Integer id;
        private String username;

        public LoginDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }
}
