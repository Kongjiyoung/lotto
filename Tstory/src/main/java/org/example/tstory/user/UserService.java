package site.metacoding.blogv3.user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // IoC 등록
public class UserService {

    // DI
    private final UserRepository userRepository;

    @Transactional
    public void 패스워드초기화() {

    } // 더티체킹 (update)

    @Transactional
    public void join(UserRequest.JoinDTO requestDTO) {

        userRepository.save(requestDTO.toEntity());

    }

    public void 유저네임중복체크(UserRequest.JoinDTO requestDTO) {



    }

    public UserResponse.LoginDTO login(UserRequest.LoginDTO requestDTO) {

        User user=userRepository.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword()).orElseThrow();

        return new UserResponse.LoginDTO(user);
    }
}
