package cc.saxfore.icbt.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICNotSupportAuthen
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:08 PM
 * 创 建 人：wangjiang
 */
public class ICNotSupportAuthen extends AuthenticationException {

    public ICNotSupportAuthen(String msg, Throwable t) {
        super(msg, t);
    }


    public ICNotSupportAuthen(String msg) {
        super(msg);
    }
}
