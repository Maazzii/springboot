package com.example.project.springboot.web;

import com.example.project.springboot.config.auth.LoginUser;
import com.example.project.springboot.config.auth.dto.SessionUser;
import com.example.project.springboot.service.posts.PostsService;
import com.example.project.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        /*  반복되는 코드를 줄이기 위해 어노테이션 기반으로 개선

            // CustomOAuth2UserService에서 로그인 성공시 Session에 SessionUser를 저장하도록 했으므로
            // 로그인이 성공했을 경우 Session에서 값을 가져올 수 있음
            // 세션에 저장된 값이 있을 때만 userName 이름으로 model에 저장
            // mustache에서 존재 여부를 판단해서 로그인 버튼 혹은 유저 정보 노출
            SessionUser user = (SessionUser) httpSession.getAttribute("user");

         */
        if (user != null) {
            model.addAttribute("loginUserName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    
}
