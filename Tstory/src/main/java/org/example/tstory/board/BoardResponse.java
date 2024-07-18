package site.metacoding.blogv3.board;

import lombok.Data;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;

public class BoardResponse {
    @Data
    public static class BoardLsit {
        private Integer id;
        private String title;
        private LocalDateTime createdAt;

        public BoardLsit(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.createdAt = board.getCreateAt();
        }
    }

}
