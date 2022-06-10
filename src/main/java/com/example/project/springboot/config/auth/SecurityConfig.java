package com.example.project.springboot.config.auth;

import com.example.project.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity      // Spring Security 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 disable하는 옵션
                .and()
                    .authorizeRequests()    // URL별 권한 관리 설정 옵션 시작 / antMatchers 옵션 사용 가능
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    /*
                    * 권한 관리 대상 지정
                    * URL, HTTP 메소드별로 관리 가능
                    * "/" 등 지정된 URL은 permitAll() 옵션으로 전체 열람 권한
                    * "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능
                    */
                    .anyRequest().authenticated()
                    /*
                    * anyRequest: 설정된 값 이외 나머지 URL
                    * authenticated()를 추가하여 나머지 URL들은 인증된 사용자들(로그인한 사용자)에게만 허용
                     */
                .and()
                    .logout()   // 로그아웃 기능에 대한 설정의 진입
                        .logoutSuccessUrl("/")  // 로그아웃 성공 시 "/" 주소로 이동
                .and()
                    .oauth2Login()  // OAuth2 로그인 기능에 대한 여러 설정의 진입
                    .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                    .userService(customOAuth2UserService);  // 소셜 로그인 성공 시 후속 조치를 진행할 UserService의 구현체 등록
                        // 리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
    }
}
