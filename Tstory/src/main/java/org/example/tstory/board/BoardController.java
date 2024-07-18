package site.metacoding.blogv3.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import site.metacoding.blogv3.user.UserResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;

    @GetMapping("/")
    public String boardList(HttpServletRequest request) {

        UserResponse.LoginDTO user = (UserResponse.LoginDTO) session.getAttribute("sessionUser");
        List<BoardResponse.BoardLsit> responseDTO= boardService.boardList(user.getId());

        request.setAttribute("boardList", responseDTO);
        System.out.println("Board List: " + responseDTO); // 디버깅을 위한 로그 출력

        return "board/list";
    }



}
