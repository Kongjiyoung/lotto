package site.metacoding.blogv3.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.metacoding.blogv3.user.User;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {


    @Query("SELECT b FROM Board b JOIN b.user bu WHERE bu.id = :userId")
    List<Board> findByUserId(@Param("userId") Integer userId);


}
