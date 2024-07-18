package site.metacoding.blogv3.board;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "board_tb")
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String title;

    @Lob // 4GB
    @Column(nullable = true)
    private String content;

    @Column(length = 200, nullable = false)
    private String thumnail; // 사진 섬네일
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Category category;

    @CreationTimestamp // insert 할때만 동작
    private LocalDateTime createAt;

}
