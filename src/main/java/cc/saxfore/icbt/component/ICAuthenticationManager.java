package cc.saxfore.icbt.component;

import cc.saxfore.icbt.common.entity.IcRole;
import cc.saxfore.icbt.common.entity.IcUser;
import cc.saxfore.icbt.common.exception.ICNotSupportAuthen;
import cc.saxfore.icbt.common.util.ICStringUtil;
import cc.saxfore.icbt.service.IcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICAuthenticationManager
 * 类 描 述：自定义认证
 * 创建时间：2019/9/16 3:05 PM
 * 创 建 人：wangjiang
 */
@Component
public class ICAuthenticationManager implements AuthenticationManager {
    private final String secutiry_role_peffix = "ROLE_";

    @Autowired
    IcUserService userService;

    /**
     * 用户登录时,AuthenticationFilter过滤器会从request中获取username和password放到Authentication中
     * {@link UsernamePasswordAuthenticationFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication instanceof UsernamePasswordAuthenticationToken) {

            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
            String username = String.valueOf(token.getPrincipal());
            String password = String.valueOf(token.getCredentials());

            IcUser icUser = userService.findUserByUserNameAndPassword(username, password);
            if (icUser == null) {
                throw new BadCredentialsException("用户名或密码错误！");
            }

            // 设置权限
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
            List<IcRole> roleList = userService.findRoleByUserName(username);
            if (roleList != null && !roleList.isEmpty()) {
                for (IcRole role : roleList) {
                    String roleName = role.getRoleName();
                    if (!ICStringUtil.isBlank(roleName)) {
                        // spring的Authority必须以ROLE_开头
                        String securityRole = roleName.startsWith(secutiry_role_peffix) ? roleName : secutiry_role_peffix + roleName;
                        authorityList.add(new SimpleGrantedAuthority(securityRole));
                    }
                }
            }

            return new UsernamePasswordAuthenticationToken(username, password, authorityList);
        }

        throw new ICNotSupportAuthen("不支持的认证方式：" + authentication.getClass());
    }
}
