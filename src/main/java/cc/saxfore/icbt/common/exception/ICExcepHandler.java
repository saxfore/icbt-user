package cc.saxfore.icbt.common.exception;

import cc.saxfore.icbt.common.base.ICResponse;
import cc.saxfore.icbt.common.util.ICRespResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICExcepHandler
 * 创建时间：2019/8/11 12:10 PM
 * 创 建 人：wangjiang
 * 类 描 述：@RestControllerAdvice只返回数据；@ControllerAdvice可返回视图
 */
@ControllerAdvice
public class ICExcepHandler {
    private static final Logger log = LoggerFactory.getLogger(ICExcepHandler.class);

    /**
     * 处理controller层抛出的异常
     * 类注解使用@RestControllerAdvice则方法上可省略@ResponseBody
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ICResponse dohandler(HttpServletRequest request, Exception e) {
        String reqUrl = request.getRequestURI();
        log.info("----请求异常:{}, 信息：{} ----", reqUrl, e.getMessage());
        log.error("异常信息:", e);
        return ICRespResult.error(e.getMessage());
    }

}
