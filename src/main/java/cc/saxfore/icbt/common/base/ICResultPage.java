package cc.saxfore.icbt.common.base;

import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICResultPage
 * 类 描 述：TODO
 * 创建时间：2019/8/11 3:14 PM
 * 创 建 人：wangjiang
 */
public class ICResultPage<T> extends ICPage {

    private List<T> dataList;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
