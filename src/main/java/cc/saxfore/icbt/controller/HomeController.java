package cc.saxfore.icbt.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目名称：icbt-user
 * 类 名 称：AdminController
 * 类 描 述：TODO
 * 创建时间：2019/9/6 1:47 PM
 * 创 建 人：wangjiang
 */
@Controller
public class HomeController extends BaseController {

    @GetMapping(value = {"/index"})
    public ModelAndView find() {
        Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("username", username);
        return mv;
    }

}
