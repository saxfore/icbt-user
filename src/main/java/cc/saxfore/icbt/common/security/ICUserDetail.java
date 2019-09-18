package cc.saxfore.icbt.common.security;

import cc.saxfore.icbt.common.entity.user.IcUser;
import cc.saxfore.icbt.service.IcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICUserDetail
 * 类 描 述：TODO
 * 创建时间：2019/9/9 5:08 PM
 * 创 建 人：wangjiang
 */
@Component
public class ICUserDetail implements UserDetailsService {

    @Autowired
    private IcUserService icUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        IcUser icUser = icUserService.findUserByUserName(userName);
        if (icUser == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        String password = icUser.getUserPwd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String securityPassword = passwordEncoder.encode(password);

        // 添加权限
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User(userName, securityPassword, authorities);
        return user;
    }

}
