package cc.saxfore.icbt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * 项目名称：icbt-user
 * 类 名 称：WebSecurityConfig
 * 创建时间：2019/9/9 5:01 PM
 * 创 建 人：wangjiang
 * 类 描 述：使用{@link org.springframework.security.authentication.AuthenticationProvider}的方式做权限认证
 * 自定义认证切入时机顺序：ICAuthenticationManager ---> AuthenticationProvider ---> UserDetailsService
 */
//@EnableWebSecurity
public class ICAuthenProviderConfig extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(ICAuthenProviderConfig.class);

    @Autowired
    ICAuthenProvider authenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 权限控制
         */
        http.authorizeRequests()

                // 无需任何权限,也不需要登录就能访问
                .antMatchers("/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png").permitAll()

                // 至少需要游客角色权限
                .antMatchers("/**/*.html").hasAnyRole("GUEST", "USER", "ADMIN")

                // 至少需要user角色才能访问
                .antMatchers("/**/user/**").hasAnyRole("USER", "ADMIN")

                // 需要admin角色才能访问
                .antMatchers("/**/admin/**").hasRole("ADMIN")

                // 除此之外,其他的资源全部需要登录,即使登录用户并未赋予任何角色
                .anyRequest().authenticated();

        /**
         * 登录页面/登录方法/登录成功跳转/登录成功回调某一方法
         */
        http.formLogin()

                // 自定义的登录页面路径
                //.loginPage("")

                // 处理登录逻辑的方法
                //.loginProcessingUrl("")

                // 第二个Boolean参数代表登录成功后总是跳转到home页面, 不带表示跳回之前停留的页面
                .defaultSuccessUrl("/home.html")
                // .defaultSuccessUrl("/home", Boolean.TRUE)

                // 登录成功后将请求转发到哪个controller
                //.successForwardUrl("")

                // 登录成功后执行的回调方法
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    log.info("WebSecurityConfig 登录成功...");
                })

                // 将用户名和密码设置到上下文中
                //.usernameParameter("")
                //.passwordParameter("")

                // 登录失败转发
                //.failureForwardUrl("")

                // 登录失败回调方法
                .failureHandler((httpServletRequest, httpServletResponse, authenticationException) -> {
                    log.info("WebSecurityConfig 登录失败：{}", authenticationException.getMessage());
                })

                // 登录不做权限控制
                .permitAll();


        // 开启注销功能
        http.logout();

    }

    /**
     * 配置自定义认证实现方式
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenProvider);
    }
}
