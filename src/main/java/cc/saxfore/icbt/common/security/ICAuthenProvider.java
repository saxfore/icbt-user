package cc.saxfore.icbt.common.security;

import cc.saxfore.icbt.common.entity.role.IcRole;
import cc.saxfore.icbt.common.entity.user.IcUser;
import cc.saxfore.icbt.common.util.ICStringUtil;
import cc.saxfore.icbt.service.IcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICAuthenProvider
 * 类 描 述：TODO
 * 创建时间：2019/9/16 7:12 PM
 * 创 建 人：wangjiang
 */
//@Component
public class ICAuthenProvider implements AuthenticationProvider {

    private final String secutiry_role_peffix = "ROLE_";

    @Autowired
    IcUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

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


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
