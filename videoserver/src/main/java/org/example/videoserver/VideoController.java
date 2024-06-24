package org.example.videoserver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class VideoController {


    @GetMapping("/")
    public String getLoginForm(String videoId,String title, String description) {
        // 여기에 메타데이터를 처리하는 로직을 추가합니다.
        System.out.println("Received metadata:");
        System.out.println("Video ID: " + videoId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);

        return "index";
    }
}
