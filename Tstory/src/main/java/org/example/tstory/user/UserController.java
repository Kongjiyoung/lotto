package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/user/{id}")
    public String updateForm(@PathVariable Integer id) {
        return "/user/updateForm";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {
        return "/user/passwordResetForm";
    }


    // ResponseEntity 는 @ResponseBody를 붙이지 않아도 data를 리턴한다.
    @GetMapping("/api/user/username-same-check")
    public ResponseEntity<?> usernameSameCheck(String username) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {

        userService.join(requestDTO);


        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {

        UserResponse.LoginDTO user=userService.login(requestDTO);
        session.setAttribute("sessionUser", user);

        return "redirect:/";
    }

}
