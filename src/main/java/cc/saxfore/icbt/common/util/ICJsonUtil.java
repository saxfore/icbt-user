package cc.saxfore.icbt.common.util;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICJsonUtil
 * 类 描 述：TODO
 * 创建时间：2019/9/6 2:22 PM
 * 创 建 人：wangjiang
 */
public class ICJsonUtil {

    /**
     * 对象变字符串
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return new Gson().toJson(object);
    }

    /**
     * 字符串转对象
     *
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T toBean(String source, Class<T> targetClass) {
        return new Gson().fromJson(source, targetClass);
    }

    /**
     * 字符串转List
     *
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String source, Class<T> targetClass) {
        ArrayList<T> targetList = new ArrayList<>();

        Gson gson = new Gson();
        JsonArray jsonElements = toJsonArray(source);
        for (JsonElement jsonElement : jsonElements) {
            T bean = gson.fromJson(jsonElement, targetClass);
            targetList.add(bean);
        }

        return targetList;
    }

    /**
     * 字符串转json
     *
     * @param source
     * @return
     */
    public static JsonObject toJson(String source) {
        return new JsonParser().parse(source).getAsJsonObject();
    }

    /**
     * 字符串转jsonArray
     *
     * @param source
     * @return
     */
    public static JsonArray toJsonArray(String source) {
        return new JsonParser().parse(source).getAsJsonArray();
    }

}
