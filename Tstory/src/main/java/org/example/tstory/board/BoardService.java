package site.metacoding.blogv3.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserRepository;
import site.metacoding.blogv3.user.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service // IoC 등록
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<BoardResponse.BoardLsit> boardList(Integer userId) {
         User user = userRepository.findById(userId).orElseThrow();
         List<Board> boards=boardRepository.findByUserId(user.getId());

         return boards.stream().map(BoardResponse.BoardLsit::new).toList();
    }
}
