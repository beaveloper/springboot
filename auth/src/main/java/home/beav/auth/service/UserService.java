package home.beav.auth.service;

import home.beav.auth.mapper.UserInfoMapper;
import home.beav.auth.vo.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserInfoMapper userMapper;

    @Transactional
    public void join(UserInfo joinInfo) {

        log.info("[FLOW] 신규유저생성 id: {}, pw: {}", joinInfo.getUserId(), joinInfo.getUserPw());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        LocalDateTime now = LocalDateTime.now();

        UserInfo newUser = UserInfo.builder()
                .userId(joinInfo.getUserId())
                .userPw(passwordEncoder.encode(joinInfo.getUserPw()))
                .lastLoginDate(now)
                .lastModPwDate(now)
                .loginFailCnt(0)
                .regDate(now)
                .modDate(now)
                .build();

        userMapper.saveUser(newUser);
    }

    @Override
    public UserInfo loadUserByUsername(String userId) throws UsernameNotFoundException {

        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserInfo user = userMapper.findUserAccount(userId);
        if (user == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return user;
    }

}
