package home.beav.auth.controller;

import home.beav.auth.service.UserService;
import home.beav.auth.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/join")
    public ResponseEntity<Map<String, String>> join(UserInfo userInfo) {

        Map<String, String> returnMap = new HashMap<>();

        try {
            userService.join(userInfo);
            returnMap.put("cd", "0000");
            returnMap.put("msg", "계정생성 성공");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            returnMap.put("cd", "0001");
            returnMap.put("msg", "계정생성 실패");
            return ResponseEntity.ok().body(returnMap);
        }

        return ResponseEntity.ok().body(returnMap);
    }

    /**
     * 로그인 실패 폼
     * @return
     */
    @GetMapping("/access_denied")
    public String accessDenied() {
        return "user_denied";
    }

}
