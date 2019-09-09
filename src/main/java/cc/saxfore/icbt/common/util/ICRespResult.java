package cc.saxfore.icbt.common.util;

import cc.saxfore.icbt.common.base.ICResponse;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICRespResult
 * 类 描 述：TODO
 * 创建时间：2019/8/9 5:40 PM
 * 创 建 人：wangjiang
 */
public class ICRespResult {

    public static int SUCCESS = 200;

    public static int FAIL = 400;

    public static int ERROR = 500;

    public static <T> ICResponse<T> success() {
        return new ICResponse(SUCCESS, "", "");
    }

    public static <T> ICResponse<T> success(String msg) {
        return new ICResponse(SUCCESS, msg, "");
    }

    public static <T> ICResponse<T> success(T data) {
        return new ICResponse(SUCCESS, "", data);
    }

    public static <T> ICResponse<T> fail(String msg) {
        return new ICResponse(FAIL, msg, "");
    }

    public static <T> ICResponse<T> error(String msg) {
        return new ICResponse(ERROR, msg, "");
    }

    public static <T> void success(HttpServletResponse response, String msg) throws IOException {
        if (response != null) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = response.getWriter();
            responseWriter.print(ICJsonUtil.toJsonString(success(msg)));
            responseWriter.flush();
            responseWriter.close();
        }
    }

    public static <T> void success(HttpServletResponse httpServletResponse, T data) throws IOException {
        if (httpServletResponse != null) {
//            httpServletResponse.setContentType("text/html;charset=utf-8");
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = httpServletResponse.getWriter();
            responseWriter.print(ICJsonUtil.toJsonString(success(data)));
            responseWriter.flush();
            responseWriter.close();
        }
    }

    public static void fail(HttpServletResponse response, String msg) throws IOException {
        if (response != null) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
            PrintWriter responseWriter = response.getWriter();
            responseWriter.print(ICJsonUtil.toJsonString(fail(msg)));
            responseWriter.flush();
            responseWriter.close();
        }
    }
}
