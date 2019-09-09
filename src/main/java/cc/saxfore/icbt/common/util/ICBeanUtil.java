package cc.saxfore.icbt.common.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICBeanUtil
 * 类 描 述：TODO
 * 创建时间：2019/8/4 12:06 PM
 * 创 建 人：wangjiang
 */
public class ICBeanUtil extends BeanUtils {

    public static <T> List<T> iterable2List(Iterable<T> iterable) {
        List<T> copyList = new ArrayList<T>();
        if (iterable == null) {
            return copyList;
        }

        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            copyList.add(iterator.next());
        }

        return copyList;
    }

}
