package com.ebcho.homecook.config.auth;

import com.ebcho.homecook.domain.member.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig{

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf().disable().headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당옵션을 disable
            .and()
                .authorizeHttpRequests(authorize -> authorize //url별 권한 관리
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER 권한을 가진 사람만 가능
                .anyRequest().authenticated()) //이외 나머지 URL들은 인증된 사용자만 허용
            .logout().logoutSuccessUrl("/") //로그아웃 성공시 /주소로 이동
            .and()
                .oauth2Login() //OAuth2 로그인 기능에 대한 설정의 진입점
                .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
                .userService(customOAuth2UserService); //소셜 로그인 성공이 후속조치를 진행할 UserService인터페이스의 구현체 등록
        return http.build();
    }

}