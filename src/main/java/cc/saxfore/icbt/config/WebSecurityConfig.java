package cc.saxfore.icbt.config;

import cc.saxfore.icbt.common.util.ICJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import cc.saxfore.icbt.service.impl.WebSecurityUserServiceImpl;


/**
 * 项目名称：icbt-user
 * 类 名 称：WebSecurityConfig
 * 类 描 述：TODO
 * 创建时间：2019/9/9 5:01 PM
 * 创 建 人：wangjiang
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

//    @Autowired
//    WebSecurityUserServiceImpl securityUserService;

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
     * 启用自定义的{@link cc.saxfore.icbt.component.ICAuthenticationManager}做权限认证
     * super.configure(auth) 代表spring从ioc容器中查找权限认证的类
     * <p>
     * 此方法与configure_bak(AuthenticationManagerBuilder auth)等效,区别在于自定义切入时机不同
     * 自定义切入时机顺序：ICAuthenticationManager ---> AuthenticationProvider ---> UserDetailsService
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);


    }

    /**
     * 启用自定义的UserDetailsService做权限认证
     * 启用该方法时修改名称为configure(AuthenticationManagerBuilder auth),
     * 将{@link cc.saxfore.icbt.component.ICAuthenticationManager}从spring容器中移除
     * <p>
     * configure(AuthenticationManagerBuilder auth)等效,区别在于自定义切入时机不同
     * 自定义切入时机顺序：ICAuthenticationManager ---> AuthenticationProvider ---> UserDetailsService
     *
     * @param auth
     * @throws Exception
     */
    // @Override
    protected void configure_bak(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 将用户写入内存中，相当于写死
         *
         * 等价于在application.properties中配置：
         * spring.security.user.name=icbt
         * spring.security.user.password=icbt
         * spring.security.user.roles=ADMIN,USER,GUEST
         */
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN", "USER");

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("wangjiang")
                .password(passwordEncoder.encode("123456"))
                .roles("USER");

        /**
         * 从数据库中加载
         */
//        auth.userDetailsService(securityUserService).passwordEncoder(passwordEncoder);

        /**
         * 获取认证的权限
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication class is {}", authentication.getClass());
        log.info("authentication bean info {}", ICJsonUtil.toJsonString(authentication));

    }
}
