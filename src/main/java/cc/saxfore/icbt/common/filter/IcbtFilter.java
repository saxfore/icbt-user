package cc.saxfore.icbt.common.filter;

import cc.saxfore.icbt.common.util.ICStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 项目名称：ikms
 * 类 名 称：icbtFilter
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:23 PM
 * 创 建 人：wangjiang
 */
@Component
public class IcbtFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(IcbtFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("icbtFilter init ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("icbtFilter doFilter ...");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Long beginTime = new Date().getTime();
        String reqUrl = httpServletRequest.getRequestURI();
        filterChain.doFilter(servletRequest, servletResponse);
        Long endTime = new Date().getTime();
        log.info("----请求地址:{}, 耗时:{}ms", reqUrl, (endTime - beginTime));
        printRequestParams(httpServletRequest);
    }

    @Override
    public void destroy() {
        log.info("icbtFilter destroy ...");
    }

    /**
     * 打印请求参数
     *
     * @param httpServletRequest
     * @throws IOException
     */
    private void printRequestParams(HttpServletRequest httpServletRequest) throws IOException {
        StringBuilder content = new StringBuilder();

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        if (parameterMap != null && !parameterMap.isEmpty()) {
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                if (entry.getValue() != null)
                    content.append(entry.getKey()).append("=").append(Arrays.toString(entry.getValue())).append(";");
            }
        }

        if (!ICStringUtil.isBlank(content.toString())) {
            String reqParams = "{" + content.toString() + "}";
            log.info("----请求参数:{} ----", reqParams);
        }
    }

}
