package com.example.securitydemo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebServerConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authorizeHttpRequests) ->{
                    try {
                        authorizeHttpRequests
                                //針對登入頁做放行
                                .requestMatchers("/login.html").permitAll()
                                .requestMatchers("/index").permitAll()
                                .anyRequest()
                                //任何請求皆驗證
                                .authenticated()
                                //並且使用form表單登入
                                .and()
                                .formLogin()
                                //設置登入頁面為templates中的login.html
                                //從formlogin源碼得知,需滿足下列條件
                                //api path為login 並且為form表單且method為post
                                //預設inputName loginName=username loginPassword = password
                                .loginPage("/login.html")
                                //指定處理登入的url
                                .loginProcessingUrl("/dologin")
                                //更改input欄位的名稱
                                .usernameParameter("uName")
                                .passwordParameter("pd")
                                //以下三個method適用於傳統web開發
                                //成功導入 forward
//                                .successForwardUrl("/index") //始終在認證成功後跳轉到指定的路徑
                                //重定向 redirect 會根據上一次保存的請求對應做跳轉 有多載布林 為true時與上方相同
                                .defaultSuccessUrl("/index")
                                .failureForwardUrl("/login")
                                //禁止csrf跨站請求登入
                                .and().csrf().disable();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("123456")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}
