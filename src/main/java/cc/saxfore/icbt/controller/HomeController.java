package cc.saxfore.icbt.controller;

import cc.saxfore.icbt.common.base.ICResponse;
import cc.saxfore.icbt.common.util.ICRespResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：icbt-user
 * 类 名 称：AdminController
 * 类 描 述：TODO
 * 创建时间：2019/9/6 1:47 PM
 * 创 建 人：wangjiang
 */
@RestController
public class HomeController extends BaseController {

    @GetMapping(value = {"/index", "/home", "/api/home"})
    public ICResponse find() {
        Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ICRespResult.success("欢迎您：" + username);
    }

}
